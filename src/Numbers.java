import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String getNumbers : input) {
            int current = Integer.parseInt(getNumbers);
            numbers.add(current);
        }

        int sumAllNumbers = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sumAllNumbers += numbers.get(i);
        }
        double averageNumber = 1.0 * sumAllNumbers / numbers.size();

        List<Integer> topNumbers = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > averageNumber) {
                topNumbers.add(numbers.get(i));
            }
        }

        if (topNumbers.size() == 0) {
            System.out.print("No");
        } else if (topNumbers.size() > 5) {
            double average = 0.0;
            for (int i = 0; i < topNumbers.size(); i++) {
                average += topNumbers.get(i);
            }
            average = average / topNumbers.size();
            List<Integer> aboveAverage = new ArrayList<>();
            for (int i = 0; i < topNumbers.size(); i++) {
                if (topNumbers.get(i) > average) {
                    aboveAverage.add(topNumbers.get(i));
                }
            }
            aboveAverage.sort(Collections.reverseOrder());
            for (Integer printNums : aboveAverage) {
                System.out.print(printNums + " ");
            }

        } else {
            topNumbers.sort(Collections.reverseOrder());
            for (Integer printNums : topNumbers) {
                System.out.print(printNums + " ");
            }
        }
    }
}

