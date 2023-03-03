package KolejkaPriorytetowa;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CustomQueue<Person> queue = new CustomQueue(new ArrayDeque(), new ArrayDeque());
        PersonCommandProcessor personCommandProcessor = new PersonCommandProcessor(queue);

        System.out.println("Provide new person in queue by entering for example: \"ADD PERSON(Krzytof_Kowalski)\" \n" +
                "If you want the person to leave the queue, provide for exaple: \"LEAVE PERSON(Mariusz_Baranski)\" \n" +
                "If you want the person to be admitted to the store provide: \"PROCESS\" \n" +
                "If you want end " + "enter \"EXIT\"");

        Scanner scanner = new Scanner(System.in);

        System.out.println();

        while (scanner.hasNext()) {

            String command = scanner.nextLine();

            if("exit".equals(command)){
                System.out.println("Exiting program");
                break;
            }

            personCommandProcessor.processCommand(command);

        }
    }
}
