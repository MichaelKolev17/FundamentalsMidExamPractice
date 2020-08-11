import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TanksCollectorTask3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] input = scan.nextLine().split(", ");
        List<String> tanks = new ArrayList<>();
        for (String getTanks : input) {
            tanks.add(getTanks);
        }
        int countCommands = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < countCommands; i++) {
            String[] parts = scan.nextLine().split(", ");

            if ("Add".equals(parts[0])) {
                if (tanks.contains(parts[1])) {
                    System.out.println("Tank is already bought");
                } else {
                    System.out.println("Tank successfully bought");
                    tanks.add(parts[1]);
                }
            } else if ("Remove".equals(parts[0])) {
                if (tanks.contains(parts[1])) {
                    System.out.println("Tank successfully sold");
                    tanks.remove(parts[1]);
                } else {
                    System.out.println("Tank not found");
                }
            } else if ("Remove At".equals(parts[0])) {
                int index = Integer.parseInt(parts[1]);
                for (int j = 0; j < tanks.size(); j++) {
                    if (j == index) {
                        System.out.println("Tank successfully sold");
                        tanks.remove(j);
                    }
                    if (index > tanks.size()) {
                        System.out.println("Index out of range");
                    }
                }
            } else if ("Insert".equals(parts[0])) {
                int index = Integer.parseInt(parts[1]);
                for (int j = 0; j < tanks.size(); j++) {
                    if (j == index && tanks.contains(parts[2])) {
                        System.out.println("Tank is already bought");
                    } else if (j == index) {
                        tanks.add(j, parts[2]);
                        System.out.println("Tank successfully bought");
                    }
                }
                if (index > tanks.size()) {
                    System.out.println("Index out of range");
                }
            }
        }

        System.out.println(String.join(", ", tanks));
    }
}
