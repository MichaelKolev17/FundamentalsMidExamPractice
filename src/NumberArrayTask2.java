import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberArrayTask2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String getNumbers : input) {
            int current = Integer.parseInt(getNumbers);
            numbers.add(current);
        }

        String command = scan.nextLine();

        while (!"End".equals(command)) {
            String[] parts = command.split(" ");
            String receivedCommand = parts[0];

            switch (receivedCommand) {
                case "Switch":
                    int index = Integer.parseInt(parts[1]);
                    for (int i = 0; i < numbers.size(); i++) {
                        if (i == index) {
                            numbers.set(index, - numbers.get(i));
                        }
                    }
                    break;
                case "Change":
                    int indexChange = Integer.parseInt(parts[1]);
                    int valueChange = Integer.parseInt(parts[2]);
                    for (int i = 0; i < numbers.size(); i++) {
                        if (i == indexChange) {
                            numbers.set(indexChange, valueChange);
                        }
                    }
                    break;
                case "Sum":
                    if ("Negative".equals(parts[1])) {
                        int negativeNumbersSum = 0;
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) < 0) {
                                negativeNumbersSum += numbers.get(i);
                            }
                        }
                        System.out.println(negativeNumbersSum);
                    } else if ("Positive".equals(parts[1])) {
                        int positiveSum = 0;
                        for (int i = 0; i < numbers.size(); i++) {
                         if (numbers.get(i) > 0) {
                             positiveSum += numbers.get(i);
                         }
                        }
                        System.out.println(positiveSum);
                    } else if ("All".equals(parts[1])) {
                        int sumAll = 0;
                        for (int i = 0; i < numbers.size(); i++) {
                            sumAll += numbers.get(i);
                        }
                        System.out.println(sumAll);
                    }
                    break;
            }
            command = scan.nextLine();
        }

        for (Integer printNumbers : numbers) {
            if (printNumbers >= 0) {
                System.out.print(printNumbers + " ");
            }
        }
    }
}
