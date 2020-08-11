import java.util.*;

public class ShootForTheWinTask2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");

        List<Integer> numbersList = new ArrayList<>();
        for (String numbers : input) {
            int current = Integer.parseInt(numbers);
            numbersList.add(current);
        }

        String command = scan.nextLine();
        int countShotTargets = 0;
        while (!"End".equals(command)) {
            int indexOfTheTarget = Integer.parseInt(command);

            for (int i = 0; i < numbersList.size(); i++) {
                if (i == indexOfTheTarget) {
                    int valueIndex = numbersList.get(i);
                    for (int j = 0; j < numbersList.size(); j++) {

                        if (numbersList.get(j) > valueIndex) {
                            if (numbersList.get(j) == -1) {
                                continue;
                            }
                            numbersList.set(j, numbersList.get(j) - valueIndex);
                        } else if (numbersList.get(j) <= valueIndex) {
                            if (numbersList.get(j) == -1) {
                                continue;
                            }
                            numbersList.set(j, numbersList.get(j) + valueIndex);
                        }

                    }
                    numbersList.set(i, -1);
                    countShotTargets++;
                }
            }

            command = scan.nextLine();
        }
        System.out.print("Shot targets: " + countShotTargets + " -> ");
        for (Integer integer : numbersList) {
            System.out.print(integer + " ");
        }

    }
}

