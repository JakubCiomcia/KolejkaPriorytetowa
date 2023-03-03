package ProjectWithScanner.Odc40_ProjectSolution_Scanner;

public class PersonCommandProcessor {

    private final CustomQueue<Person> customQueue;

    public PersonCommandProcessor(CustomQueue<Person> customQueue) {
        this.customQueue = customQueue;
    }

    public void processCommand(String command) {
        if (command.contains("ADD PERSON")) {
            handleAddPerson(command, command.contains("VIP"));
        } else if (command.contains("LEAVE PERSON")) {
            handleLeavePerson(command);
        } else if (command.contains("PROCESS")) {
            handleProcess(command);
        } else {
            throw new RuntimeException("What are you mean with this command ? " + command);
        }
    }

    private void handleAddPerson(String command, Boolean isVip) {
        Person incomingPerson = createdIncomingPerson(command, isVip);

        if (isVip) {
            customQueue.welcomeVip(incomingPerson);
        } else {
            customQueue.welcome(incomingPerson);
        }
    }

    private Person createdIncomingPerson(String command, Boolean isVip) {
        String personKey = command
                .replace("ADD PERSON(", "")
                .replace(isVip ? ",VIP)" : ")", "");

        String[] split = personKey.split("_");

        String name = split[0];
        String surName = split[1];
        Integer counter = customQueue.getAndIncrementCounter(personKey);
        System.out.println(command);

        if (split.length == 2) {

            return new Person(name, surName, counter);
        }
        if (split.length == 3) {
            return new Person(name, surName, counter, isVip);
        } else {
            throw new IllegalArgumentException("Illegal argument: " + command);
        }

    }

    private void handleLeavePerson(String command) {
        System.out.println(command);

        Person person = createdLeavingPerson(command);
        customQueue.leave(person);

    }

    private Person createdLeavingPerson(String command) {

        String personId = command
                .replace("LEAVE PERSON(", "")
                .replace(")", "");

        String[] splitId = personId.split("_");

        if (splitId.length == 2 || splitId.length == 3) {

            String name = splitId[0];
            String surName = splitId[1];
            Integer counter = 1;
            return new Person(name, surName, counter);
        }

        else {
            throw new IllegalArgumentException("Illegal argument: " + command);
        }
    }

    private void handleProcess(String command) {
        System.out.println(command);
        customQueue.enter();
    }
}

