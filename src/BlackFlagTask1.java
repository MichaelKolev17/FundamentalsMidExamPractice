import java.util.Scanner;

public class BlackFlagTask1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int plunderDays = Integer.parseInt(scan.nextLine());
        int dailyPlunder = Integer.parseInt(scan.nextLine());
        double expectedPlunder = Double.parseDouble(scan.nextLine());

        double collectedPlunder = 0.0;

        for (int i = 1; i <= plunderDays; i++) {
            collectedPlunder += dailyPlunder;
            if (i % 3 == 0) {
                double additionalPlunder = dailyPlunder * 0.5;
                collectedPlunder += additionalPlunder;
            }
            if (i % 5 == 0) {
                collectedPlunder = collectedPlunder * 0.7;
            }
        }

        if (collectedPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", collectedPlunder);
        } else {
            double less = collectedPlunder / expectedPlunder * 100;
            System.out.printf("Collected only %.2f%% of the plunder.", less);
        }
    }
}
