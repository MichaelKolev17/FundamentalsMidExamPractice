import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\|");
        List<String> treasureArray = new ArrayList<>();
        for (String s : input) {
            treasureArray.add(s);
        }

        String command = scan.nextLine();



        while (!"Yohoho!".equals(command)) {
            String[] parts = command.split(" ");
            if ("Loot".equals(parts[0])) {
                List<String> arrayParts = new ArrayList<>();
                for (String getParts : parts) {
                    arrayParts.add(getParts);
                }
                for (int i = 1; i < arrayParts.size(); i++) {
                    if (!treasureArray.contains(arrayParts.get(i))) {
                        treasureArray.add(0, arrayParts.get(i));
                    }
                }
            } else if ("Drop".equals(parts[0])) {
                int index = Integer.parseInt(parts[1]);
                for (int i = 0; i < treasureArray.size(); i++) {
                    if (i == index) {
                        String temp = treasureArray.get(i);
                        treasureArray.remove(i);
                        treasureArray.add(temp);
                    }
                }
            } else if ("Steal".equals(parts[0])) {
                int numberStealItems = Integer.parseInt(parts[1]);
                List<String> arrayStolenItems = new ArrayList<>();
                if (numberStealItems >= treasureArray.size()) {
                    for (int i = 0; i < treasureArray.size(); i++) {
                        arrayStolenItems.add(treasureArray.get(i));
                        treasureArray.remove(i);
                        i= -1;
                    }
                    System.out.print(String.join(", ", arrayStolenItems));
                    System.out.println();
                    break;
                } else {
                    int sizeArray = treasureArray.size();
                    int diff = sizeArray - numberStealItems;
                    for (int i = diff; i < treasureArray.size(); i++) {
                        arrayStolenItems.add(treasureArray.get(i));
                        treasureArray.remove(i);
                        i = 4;
                    }
                    System.out.print(String.join(", ", arrayStolenItems));
                    System.out.println();
                }
            }

            command = scan.nextLine();
        }

        int sumItems = 0;
        for (int i = 0; i < treasureArray.size(); i++) {
            int current = treasureArray.get(i).length();
            sumItems += current;
        }
        if (sumItems == 0) {
            System.out.println("Failed treasure hunt.");
        } else {
            double averageGain = sumItems * 1.0 / treasureArray.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageGain);
            }

        }

    }

