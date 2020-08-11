import java.util.Scanner;

public class DistanceCalculatorTask1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int stepsMade = Integer.parseInt(scan.nextLine());
        double lengthOfOneStep = Double.parseDouble(scan.nextLine());
        int distanceNeedToTravel = Integer.parseInt(scan.nextLine());

        double totalLength = 0.0;

        for (int i = 1; i <= stepsMade ; i++) {
            if (i % 5 == 0) {
                double reducedStep = lengthOfOneStep * 0.7;
                totalLength += reducedStep;
                continue;
            }
            totalLength += lengthOfOneStep;
        }

        totalLength = totalLength / 100;

        System.out.printf("You travelled %.2f%% of the distance!", (totalLength/distanceNeedToTravel) * 100);

    }
}
