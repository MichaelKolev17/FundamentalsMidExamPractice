import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FriendListMaintenanceTask2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");
        List<String> namesList = new ArrayList<>();
        for (String addNames : input) {
            namesList.add(addNames);
        }

        int blacklistedCount = 0;
        int lostCount = 0;
        String command = scan.nextLine();
        while (!"Report".equals(command)) {
            String[] parts = command.split(" ");
            if ("Blacklist".equals(parts[0])) {
                if (namesList.contains(parts[1])) {
                    String nameToChange = parts[1];
                    String newElement = "Blacklisted";
                    int index = 0;
                    for (int i = 0; i < namesList.size(); i++) {
                        if (namesList.get(i).equals(nameToChange)) {
                            System.out.printf("%s was blacklisted.%n", namesList.get(i));
                            blacklistedCount++;
                            index = i;
                        }
                    }
                    namesList.set(index, newElement);
                } else {
                    System.out.printf("%s was not found.%n", parts[1]);
                }
            } else if ("Error".equals(parts[0])) {
                int index = Integer.parseInt(parts[1]);
                for (int i = 0; i < namesList.size(); i++) {
                    if (i == index) {
                        if ("Blacklisted".equals(namesList.get(i))) {
                            break;
                        } else if ("Lost".equals(namesList.get(i))) {
                            break;
                        } else {
                            System.out.printf("%s was lost due to an error.%n", namesList.get(i));
                            lostCount++;
                            String newElement = "Lost";
                            namesList.set(i, newElement);
                        }
                    }
                }
            } else if ("Change".equals(parts[0])) {
                int index = Integer.parseInt(parts[1]);
                String newName = parts[2];
                for (int i = 0; i < namesList.size(); i++) {
                    if (i == index) {
                        System.out.printf("%s changed his username to %s.%n", namesList.get(i), newName);
                        namesList.set(i, newName);
                    }
                }
            }
            command = scan.nextLine();
        }

        System.out.printf("Blacklisted names: %d%n", blacklistedCount);
        System.out.printf("Lost names: %d%n", lostCount);
        System.out.print(String.join(" ", namesList));
    }
}
