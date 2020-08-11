import java.util.Scanner;

public class ExperienceGainingTask1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double neededExperience = Double.parseDouble(scan.nextLine());
        int battles = Integer.parseInt(scan.nextLine());

        double gainedExp = 0.0;
        int countBattles = 0;
        boolean isEnough = false;
        for (int i = 1; i <= battles; i++) {
            double expEarnedPerBattle = Double.parseDouble(scan.nextLine());

            if (i % 3 == 0) {
                double additionalExp = expEarnedPerBattle * 1.15;
                gainedExp += additionalExp;
                countBattles++;
                if (gainedExp >= neededExperience) {
                    isEnough = true;
                    break;
                }
                continue;
            } else if (i % 5 == 0) {
                double removedExp = expEarnedPerBattle * 0.9;
                gainedExp += removedExp;
                countBattles++;
                if (gainedExp >= neededExperience) {
                    isEnough = true;
                    break;
                }
                continue;
            }

            gainedExp += expEarnedPerBattle;
            countBattles++;

            if (gainedExp >= neededExperience) {
                isEnough = true;
                break;
            }
        }
        if (isEnough) {
            System.out.printf("Player successfully collected his needed experience for %d battles.", countBattles);
        } else {
            double expNeeded = neededExperience - gainedExp;
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", expNeeded);
        }


    }
}
