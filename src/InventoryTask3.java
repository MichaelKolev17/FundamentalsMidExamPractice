import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryTask3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] items = scan.nextLine().split(", ");
        List<String> arrayItems = new ArrayList<>();
        for (String getItems : items) {
            arrayItems.add(getItems);
        }

        String command = scan.nextLine();

        while (!"Craft!".equals(command)) {
            String[] parts = command.split(" - ");

            if ("Collect".equals(parts[0])) {
                if (!arrayItems.contains(parts[1])) {
                    arrayItems.add(parts[1]);
                }
            } else if ("Drop".equals(parts[0])) {
                arrayItems.remove(parts[1]);
            } else if ("Combine Items".equals(parts[0])) {
                String[] itemsCheck = parts[1].split(":");
                if (arrayItems.contains(itemsCheck[0])) {
                    int itemIndex = 0;
                    for (int i = 0; i < arrayItems.size() ; i++) {

                        if (arrayItems.get(i).equals(itemsCheck[0])) {
                            itemIndex = i;
                        }
                    }
                    arrayItems.add(itemIndex + 1, itemsCheck[1]);
                }
            } else if ("Renew".equals(parts[0])) {
                if (arrayItems.contains(parts[1])) {
                    int indexRemove = 0;
                    for (int i = 0; i < arrayItems.size(); i++) {
                        if (arrayItems.get(i).equals(parts[1])) {
                            indexRemove = i;
                        }

                    }
                    arrayItems.remove(indexRemove);
                    arrayItems.add(parts[1]);
                }
            }


            command = scan.nextLine();
        }

        System.out.println(String.join(", ", arrayItems));
    }
}
