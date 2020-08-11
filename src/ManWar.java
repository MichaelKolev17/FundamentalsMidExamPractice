import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManWar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputPirateShip = scan.nextLine().split(">");
        List<Integer> pirateShip = new ArrayList<>();
        for (String numbers : inputPirateShip) {
            int current = Integer.parseInt(numbers);
            pirateShip.add(current);
        }

        String[] inputWarship = scan.nextLine().split(">");
        List<Integer> warship = new ArrayList<>();
        for (String numbers : inputWarship) {
            int current = Integer.parseInt(numbers);
            warship.add(current);
        }
        int maxHealthCapacityOfSection = Integer.parseInt(scan.nextLine());

        String command = scan.nextLine();
        while (!"Retire".equals(command)) {
            String[] parts = command.split(" ");

            if ("Fire".equals(parts[0])) {
                int indexAttack = Integer.parseInt(parts[1]);
                int damage = Integer.parseInt(parts[2]);

                for (int i = 0; i < warship.size(); i++) {
                    if (i == indexAttack) {
                        warship.set(i, warship.get(i) - damage);
                        if (warship.get(i) <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        }
                    }
                }
            } else if ("Defend".equals(parts[0])) {
                int startIndex = Integer.parseInt(parts[1]);
                int endIndex = Integer.parseInt(parts[2]);
                int damage = Integer.parseInt(parts[3]);

                if (startIndex >= 0 && startIndex < pirateShip.size() && endIndex >= 0 && endIndex < pirateShip.size()) {
                    for (int i = startIndex; i <=endIndex ; i++) {
                        pirateShip.set(i, pirateShip.get(i) - damage);
                        if (pirateShip.get(i) <= 0) {
                            System.out.println("You lost! The pirate ship has sunken.");
                            return;
                        }
                    }
                }
            } else if ("Repair".equals(parts[0])) {
                int index = Integer.parseInt(parts[1]);
                int health = Integer.parseInt(parts[2]);

                if (index >= 0 && index < pirateShip.size()) {
                    pirateShip.set(index, pirateShip.get(index) + health);
                    if (pirateShip.get(index) > maxHealthCapacityOfSection) {
                       pirateShip.set(index, maxHealthCapacityOfSection);
                    }
                }
            } else if ("Status".equals(parts[0])) {
                double checkHealth = maxHealthCapacityOfSection * 0.2;
                int countSections = 0;
                for (int i = 0; i < pirateShip.size(); i++) {
                    if (pirateShip.get(i) < checkHealth) {
                        countSections++;
                    }
                }
                System.out.printf("%d sections need repair.%n", countSections);
            }

            command = scan.nextLine();

        }


        int warshipStatus = 0;
        for (Integer sections : warship) {
            warshipStatus += sections;
        }
        int pirateShipStatus = 0;
        for (Integer sections : pirateShip) {
            pirateShipStatus += sections;
        }

        System.out.printf("Pirate ship status: %d%n", pirateShipStatus);
        System.out.printf("Warship status: %d%n", warshipStatus);
    }
}
