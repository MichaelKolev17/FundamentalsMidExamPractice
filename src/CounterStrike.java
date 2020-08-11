import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scan.nextLine());

        int countWonBattles = 0;
        while (initialEnergy >= 0) {
            String input = scan.nextLine();

            if ("End of battle".equals(input)) {
                System.out.printf("Won battles: %d. Energy left: %d",countWonBattles, initialEnergy);
                break;
            }
            int distanceToReachAnEnemy = Integer.parseInt(input);

            if (initialEnergy < distanceToReachAnEnemy) {
                initialEnergy = 0;
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", countWonBattles, initialEnergy);
                return;
            } else {
                initialEnergy -= distanceToReachAnEnemy;
                countWonBattles++;
                if (countWonBattles % 3 == 0) {
                    initialEnergy = initialEnergy + countWonBattles;
                }
            }

        }
    }
}
