import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String getNumbers : input) {
            int current = Integer.parseInt(getNumbers);
            numbers.add(current);
        }

        String command = scan.nextLine();

        while (!"end".equals(command)) {
            String[] parts = command.split(" ");
            String receivedCommand = parts[0];

            switch (receivedCommand) {
                case "swap":
                    int swapIndexOne = Integer.parseInt(parts[1]);
                    int swapIndexTwo = Integer.parseInt(parts[2]);
                    int swapElementOne = 0;
                    int swapElementTwo = 0;

                    for (int i = 0; i < numbers.size(); i++) {
                        if (swapIndexOne == i) {
                            swapElementOne = numbers.get(i);
                        }
                        if (swapIndexTwo == i) {
                            swapElementTwo = numbers.get(i);
                        }
                    }
                    int temp = swapElementOne;
                    swapElementOne = swapElementTwo;
                    swapElementTwo = temp;

                    numbers.set(swapIndexOne, swapElementOne);
                    numbers.set(swapIndexTwo, swapElementTwo);
                    break;
                case "multiply":
                    int indexOneMultiply = Integer.parseInt(parts[1]);
                    int indexTwoMultiply = Integer.parseInt(parts[2]);
                    int multipliedNumber = 0;
                    int elementOne = 0;
                    int elementTwo = 0;

                    for (int i = 0; i < numbers.size(); i++) {
                        if (indexOneMultiply == i) {
                            elementOne = numbers.get(i);
                        }
                        if (indexTwoMultiply == i) {
                            elementTwo = numbers.get(i);
                        }
                    }
                    multipliedNumber = elementOne * elementTwo;
                    numbers.set(indexOneMultiply, multipliedNumber);
                    break;
                case "decrease":
                    for (int i = 0; i < numbers.size(); i++) {
                        numbers.set(i, numbers.get(i) - 1);
                    }
                    break;
            }

            command = scan.nextLine();
        }

        System.out.println(numbers.toString().replace("[","").replace("]", ""));

    }
}
