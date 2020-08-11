import java.util.Scanner;

public class BiscuitsFactoryTask1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countBiscuitsPerWorkerPerDay = Integer.parseInt(scan.nextLine());
        int workersNumber = Integer.parseInt(scan.nextLine());
        int biscuitsCompetitors = Integer.parseInt(scan.nextLine());

        double producedByDay = 0.0;

        double totalProduced = 0.0;

        for (int i = 1; i <= 30 ; i++) {
            if (i % 3 == 0) {
                producedByDay = Math.floor((countBiscuitsPerWorkerPerDay * workersNumber) * 0.75);
                totalProduced += producedByDay;
                continue;
            }

            producedByDay = countBiscuitsPerWorkerPerDay * workersNumber;
            totalProduced += producedByDay;
        }

        System.out.printf("You have produced %.0f biscuits for the past month.%n", totalProduced);

        if (totalProduced > biscuitsCompetitors) {
            double diff = totalProduced - biscuitsCompetitors;
            double percentageMore = (diff / biscuitsCompetitors) * 100;
            System.out.printf("You produce %.2f percent more biscuits.", percentageMore);
        } else {
            double diff = biscuitsCompetitors - totalProduced;
            double percentageLess = (diff / biscuitsCompetitors) * 100;
            System.out.printf("You produce %.2f percent less biscuits.", percentageLess);
        }
    }
}
