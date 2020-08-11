import java.util.Scanner;

public class PasswordResetFinalExamTask1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String passwordText = scan.nextLine();
        String command = scan.nextLine();

        while (!"Done".equals(command)) {
            String[] tokens = command.split("\\s+");
            String commandToInitiate = tokens[0];

            switch (commandToInitiate) {
                case "TakeOdd":
                    String temporary = "";
                    for (int i = 0; i < passwordText.length(); i++) {
                        if (i % 2 == 1) {
                            temporary += passwordText.charAt(i);
                        }
                    }
                    passwordText = temporary;
                    System.out.println(passwordText);
                    break;
                case "Cut":
                    int cutIndex = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    String firstString = passwordText.substring(0, cutIndex);
                    String secondString = passwordText.substring(cutIndex + length);
                    passwordText = firstString + secondString;
                    System.out.println(passwordText);
                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[2];
                    String temporaryString = "";

                    if (passwordText.contains(substring)) {
                        temporaryString = passwordText.replaceAll(substring, substitute);
                        passwordText = temporaryString;
                        System.out.println(passwordText);
                    } else {
                        System.out.println("Nothing to replace");
                    }
                    break;
            }

            command = scan.nextLine();
        }

        System.out.println("Your password is: " + passwordText);
    }
}
