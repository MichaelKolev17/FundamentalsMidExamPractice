import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int employeeOneEfficiency = Integer.parseInt(scan.nextLine());
        int employeeTwoEfficiency = Integer.parseInt(scan.nextLine());
        int employeeThreeEfficiency = Integer.parseInt(scan.nextLine());
        int studentCount = Integer.parseInt(scan.nextLine());

        int countHours = 0;
        int totalPerHour = 0;

        while (studentCount > 0) {

            totalPerHour = employeeOneEfficiency + employeeTwoEfficiency + employeeThreeEfficiency;
            countHours++;
            studentCount -= totalPerHour;

            if (countHours % 4 == 0) {
                countHours++;
            }

        }

        System.out.printf("Time needed: %dh.", countHours);

    }
}
