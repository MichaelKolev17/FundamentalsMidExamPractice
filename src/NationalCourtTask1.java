import java.util.Scanner;

public class NationalCourtTask1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int employeeOneEfficiency = Integer.parseInt(scan.nextLine());
        int employeeTwoEfficiency = Integer.parseInt(scan.nextLine());
        int employeeThreeEfficiency = Integer.parseInt(scan.nextLine());
        int totalPeopleCount = Integer.parseInt(scan.nextLine());

        int allEmployeesEfficiencyPerHour = employeeOneEfficiency + employeeTwoEfficiency + employeeThreeEfficiency;
        int hoursBreakCount = 0;
        int totalHoursCount = 0;

        while (totalPeopleCount > 0) {
            totalPeopleCount = totalPeopleCount - allEmployeesEfficiencyPerHour;
            totalHoursCount++;

            if (totalHoursCount % 3 == 0) {
                hoursBreakCount++;
            }

        }
        totalHoursCount = totalHoursCount + hoursBreakCount;

        System.out.printf("Time needed: %dh.", totalHoursCount);

    }
}
