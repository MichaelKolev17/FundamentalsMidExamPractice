import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\|");
        List<String> rooms = new ArrayList<>();
        for (String getRooms : input) {
            rooms.add(getRooms);
        }

        int health = 100;
        int bitcoins = 0;
        int roomCount = 0;
        boolean isDead = false;

        for (int i = 0; i < rooms.size(); i++) {
            String [] command = rooms.get(i).split(" ");

            if ("potion".equals(command[0])) {
                int currentHealth = health;
                int getHealed = Integer.parseInt(command[1]);
                health += getHealed;
                if (health > 100) {
                    health = 100;
                    System.out.printf("You healed for %d hp.%n", health - currentHealth);
                    System.out.printf("Current health: %d hp.%n", health);
                } else {
                    System.out.printf("You healed for %d hp.%n", getHealed);
                    System.out.printf("Current health: %d hp.%n", health);
                }

                roomCount++;

            } else if ("chest".equals(command[0])) {
                int foundCoins = Integer.parseInt(command[1]);
                bitcoins += foundCoins;
                roomCount++;
                System.out.printf("You found %d bitcoins.%n", foundCoins);
            } else {
                int damage = Integer.parseInt(command[1]);
                String monster = command[0];
                if (health <= damage) {
                    System.out.printf("You died! Killed by %s.%n",monster);
                    isDead = true;
                    roomCount++;
                    break;
                } else {
                    health -= damage;
                    roomCount++;
                    System.out.printf("You slayed %s.%n", monster);

                }
            }
        }

        if (isDead) {
            System.out.printf("Best room: %d%n", roomCount);
        } else {
            System.out.printf("You've made it!%n");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d%n", health);
        }

    }
}


