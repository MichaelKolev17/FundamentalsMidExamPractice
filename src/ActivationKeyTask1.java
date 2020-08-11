import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ActivationKeyTask1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String[] array = input.split("");
        List<String> inputData = new ArrayList<>();
        for (String text : array) {
            inputData.add(text);
        }


        String command = scan.nextLine();

        while (!"Generate".equals(command)) {
            String[] tokens = command.split(">>>");

            if ("Contains".equals(tokens[0])) {
                if (inputData.contains(tokens[1])) {
                    String textToken = tokens[1];
                    System.out.println(input + " contains" + textToken);
                } else {
                    System.out.println("Substring not found!");
                }
            } else if ("Flip".equals(tokens[0])) {
                if ("Upper".equals(tokens[1])) {
                    int startIndex = Integer.parseInt(tokens[2]);
                    int lastIndex = Integer.parseInt(tokens[3]);

                    for (int i = 0; i < inputData.size(); i++) {
                       if (i >= startIndex && i < lastIndex) {
                           String element = inputData.get(i);
                           element = element.toUpperCase();
                           inputData.set(i, element);
                       }

                    }

                    for (String text : inputData) {
                        System.out.print(text);
                    }
                    System.out.println();

                } else if ("Lower".equals(tokens[1])) {
                    int startIndex = Integer.parseInt(tokens[2]);
                    int lastIndex = Integer.parseInt(tokens[3]);

                    for (int i = 0; i < inputData.size(); i++) {
                        if (i >= startIndex && i < lastIndex) {
                            String element = inputData.get(i);
                            element = element.toLowerCase();
                            inputData.set(i, element);
                        }

                    }
                    for (String text : inputData) {
                        System.out.print(text);
                    }
                    System.out.println();
                }

            } else if ("Slice".equals(tokens[0])) {
                int startIndex = Integer.parseInt(tokens[1]);
                int lastIndex = Integer.parseInt(tokens[2]);

                int counterRemovedLetters = 0;
                for (int i = 0; i < inputData.size(); i++) {
                    if (i == startIndex) {
                        inputData.remove(i);
                        counterRemovedLetters++;
                        i = i - 1;
                        if (counterRemovedLetters == lastIndex - startIndex) {
                            break;
                        }
                    }
                }
                for (String text : inputData) {
                    System.out.print(text);
                }
                System.out.println();
            }

            command = scan.nextLine();
        }

        System.out.print("Your activation key is: ");
        for (String text : inputData) {
            System.out.print(text);
        }

    }
}