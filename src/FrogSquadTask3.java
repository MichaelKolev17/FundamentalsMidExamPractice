import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FrogSquadTask3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");
        List<String> frogs = new ArrayList<>();
        for (String getFrogNames : input) {
            frogs.add(getFrogNames);
        }

        String command = scan.nextLine();

        while (!command.equals("Print Reversed")) {
            String[] parts = command.split(" ");
            String receivedCommand = parts[0];
            switch (receivedCommand) {
                case "Join":
                    String joinName = parts[1];
                    frogs.add(joinName);
                    break;
                case "Jump":
                    String jumpName = parts[1];
                    int indexJump = Integer.parseInt(parts[2]);
                    for (int i = 0; i < frogs.size(); i++) {
                        if (indexJump == i) {
                            frogs.add(indexJump, jumpName);
                        }
                    }
                    break;
                case "Dive":
                    int diveIndex = Integer.parseInt(parts[1]);
                    for (int i = 0; i < frogs.size(); i++) {
                        if (diveIndex == i) {
                            frogs.remove(diveIndex);
                        }
                    }
                    break;
                case "First":
                    int count = Integer.parseInt(parts[1]);
                    if (count >= frogs.size()) {
                        for (String frogNames : frogs) {
                            System.out.print(frogNames + " ");
                        }
                    } else {
                        for (int i = 0; i < count; i++) {
                            System.out.print(frogs.get(i) + " ");
                        }
                    }
                    break;
                case "Last":
                    int countLast = Integer.parseInt(parts[1]);
                    if (countLast >= frogs.size()) {
                        for (String frogNames : frogs) {
                            System.out.print(frogNames + " ");
                        }
                    } else {
                        int startPrint = frogs.size() - countLast;
                        for (int i = startPrint; i < frogs.size(); i++) {
                            System.out.print(frogs.get(i) + " ");
                        }
                        System.out.println();
                    }
                    break;
                case "Print":
                    if ("Normal".equals(parts[1])) {
                        System.out.print("Frogs: ");
                        for (String printFrogs : frogs) {
                            System.out.print(printFrogs + " ");
                        }
                        return;
                    }
                    break;
            }
            command = scan.nextLine();
        }
        System.out.println();
        Collections.reverse(frogs);
        System.out.print("Frogs: ");
        for (String print : frogs) {
            System.out.print(print + " ");
        }

    }
}
