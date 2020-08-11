import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeaponSmith {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\|");
        List<String> weapon = new ArrayList<>();
        for (String getWeapon : input) {
            weapon.add(getWeapon);
        }
        String command = scan.nextLine();

        while (!"Done".equals(command)) {
            String[] parts = command.split(" ");
            if ("Move".equals(parts[0])) {
                if ("Left".equals(parts[1])) {
                    int index = Integer.parseInt(parts[2]);
                    for (int i = 0; i < weapon.size(); i++) {
                        if (i == index && !(i == 0)) {
                            String temp = weapon.get(i - 1);
                            weapon.set(i - 1, weapon.get(i));
                            weapon.set(i, temp);
                        }
                    }
                } else if ("Right".equals(parts[1])) {
                    int index = Integer.parseInt(parts[2]);
                    for (int i = 0; i < weapon.size(); i++) {
                        if (i == index) {
                            String temp = weapon.get(i + 1);
                            weapon.set(i + 1, weapon.get(i));
                            weapon.set(i, temp);
                        }
                    }
                }
            } else if ("Check".equals(parts[0])) {
                if ("Even".equals(parts[1])) {
                    List<String> evenElements = new ArrayList<>();
                    for (int i = 0; i < weapon.size(); i++) {
                        if (i % 2 == 0) {
                            evenElements.add(weapon.get(i));
                        }
                    }
                    System.out.print(String.join(" ", evenElements));
                    System.out.println();
                } else if ("Odd".equals(parts[1])) {
                    List<String> oddElements = new ArrayList<>();
                    for (int i = 0; i < weapon.size(); i++) {
                        if (i % 2 == 1) {
                            oddElements.add(weapon.get(i));
                        }
                    }
                    System.out.print(String.join(" ", oddElements));
                    System.out.println();
                }
            }

            command = scan.nextLine();
        }


        System.out.print("You crafted ");
        for (String print : weapon) {
            System.out.print(print);
        }
        System.out.print("!");

    }
}

