import java.util.Scanner;

public class DisneyLandJourney {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double journeyCosts = Double.parseDouble(scan.nextLine());
        int months = Integer.parseInt(scan.nextLine());

        double totalPossibleSavings = months * (journeyCosts * 0.25);
        double savingsPerMonth = totalPossibleSavings / months;
        double finalSavings = 0.0;

        for (int i = 1; i <= months ; i++) {

            if (i % 2 == 1) {
                if (i == 1) {
                    finalSavings += savingsPerMonth;
                    continue;
                }
                finalSavings = finalSavings * 0.84;
            }
            if (i % 4 == 0) {
                double bonus = finalSavings * 0.25;
                finalSavings += bonus;
            }
            finalSavings += savingsPerMonth;
        }

        if (finalSavings >= journeyCosts) {
            double moneyLeft = finalSavings - journeyCosts;
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.", moneyLeft);
        } else {
            double moneyNeed= journeyCosts - finalSavings;
            System.out.printf("Sorry. You need %.2flv. more.", moneyNeed);
        }
    }
}
