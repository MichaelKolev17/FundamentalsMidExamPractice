import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String commands = scan.nextLine();

        StringBuilder sbText = new StringBuilder(input);

        while (!"Reveal".equals(commands)) {
            String[] tokens = commands.split(":\\|:");
            String action = tokens[0];

            switch (action) {
                case "InsertSpace":
                    int indexInsert = Integer.parseInt(tokens[1]);
                    sbText.insert(indexInsert, " ");
                    break;
                case "Reverse":
                    StringBuilder substring = new StringBuilder(tokens[1]);
                    input = sbText.toString();
                    if (input.contains(substring)) {
                        substring.reverse();
                    }
                    break;
                case "ChangeAll":
                    break;
            }

            commands = scan.nextLine();
        }

        System.out.println();
    }
}
