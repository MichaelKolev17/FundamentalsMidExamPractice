import java.util.Scanner;

public class BonusScoringSystemTask1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int studentCount = Integer.parseInt(scan.nextLine());
        int lectureCount = Integer.parseInt(scan.nextLine());
        int initialBonus = Integer.parseInt(scan.nextLine());


        double totalBonus = 0.0;
        double maxBonus = Double.MIN_VALUE;
        int maxAttendance = 0;
        for (int i = 0; i < studentCount; i++) {
            int studentAttendance = Integer.parseInt(scan.nextLine());

            totalBonus = (studentAttendance * 1.0 / lectureCount) * (5 + initialBonus);

            if (totalBonus > maxBonus) {
                maxBonus = totalBonus;
                maxAttendance = studentAttendance;
            }
        }

        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxBonus));
        System.out.printf("The student has attended %d lectures.%n", maxAttendance);

    }
}