import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");
        int[] targetNumbers = new int[input.length];

        for (int i = 0; i < targetNumbers.length; i++) {
            targetNumbers[i] = Integer.parseInt(input[i]);
        }

        String indices = scan.nextLine();
        while (!"End".equals(indices)) {
            int indicesNumber = Integer.parseInt(indices);


            if (indicesNumber > targetNumbers.length - 1) {
                indices = scan.nextLine();
                continue;
            }

            for (int i = 0; i < targetNumbers.length; i++) {
                if (indicesNumber == i) {
                    if (targetNumbers[i + 1] > targetNumbers[i]) {
                        targetNumbers[i + 1] -= targetNumbers[i];
                    }
                    if (targetNumbers[targetNumbers.length - 1] > targetNumbers[i]) {
                        targetNumbers[targetNumbers.length - 1] -= targetNumbers[i];
                    }
                    if (targetNumbers[targetNumbers.length / 2] > targetNumbers[i]) {
                        targetNumbers[targetNumbers.length / 2] -= targetNumbers[i];
                    }
                    targetNumbers[i] = - 1;
                }
            }

            indices = scan.nextLine();
        }
    }
}
