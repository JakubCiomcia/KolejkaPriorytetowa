package ProjectWithScanner.Odc40_ProjectSolution_Scanner;

import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CustomQueue<Person> queue = new CustomQueue(new ArrayDeque(), new ArrayDeque());
        PersonCommandProcessor personCommandProcessor = new PersonCommandProcessor(queue);

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
