import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingListTask2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("!");
        List<String> products = new ArrayList<>();
        for (String names : input) {
            products.add(names);
        }

        String command = scan.nextLine();
        while (!"Go Shopping!".equals(command)) {
            String[] parts = command.split(" ");
            if ("Urgent".equals(parts[0])) {
                if (!products.contains(parts[1])) {
                    products.add(0, parts[1]);
                }
            } else if ("Unnecessary".equals(parts[0])) {
                products.remove(parts[1]);
            } else if ("Correct".equals(parts[0])) {
                if (products.contains(parts[1])) {
                    int old = products.indexOf(parts[1]);
                    products.set(old, parts[2]);
                }
            } else if ("Rearrange".equals(parts[0])) {
                if (products.contains(parts[1])) {
                    int current = products.indexOf(parts[1]);
                    products.add(parts[1]);
                    products.remove(current);
                }
            }

            command = scan.nextLine();
        }

        System.out.print(String.join(", ", products));


    }
}
