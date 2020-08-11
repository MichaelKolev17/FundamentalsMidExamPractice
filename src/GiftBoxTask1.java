import java.util.Scanner;

public class GiftBoxTask1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double sizeOfASide = Double.parseDouble(scan.nextLine());
        int numberSheetsPaper = Integer.parseInt(scan.nextLine());
        double areaSingleSheet = Double.parseDouble(scan.nextLine());

        double areaBox = sizeOfASide * sizeOfASide * 6;

        double totalCoverage = 0.0;
        for (int i = 1; i <= numberSheetsPaper ; i++) {
            if (i % 3 == 0) {
                double reducedCoverage = areaSingleSheet * 0.25;
                totalCoverage += reducedCoverage;
                continue;
            }
            totalCoverage += areaSingleSheet;
        }

        double finalCoverage = (totalCoverage / areaBox) * 100;
        System.out.printf("You can cover %.2f%% of the box.", finalCoverage);
    }
}
