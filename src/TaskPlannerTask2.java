import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskPlannerTask2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");
        List<Integer> tasks = new ArrayList<>();
        for (String addTasks : input) {
            int current = Integer.parseInt(addTasks);
            tasks.add(current);
        }

        String commands = scan.nextLine();
        int countCompletedTasks = 0;
        int countDroppedTasks = 0;
        while (!"End".equals(commands)) {
            String[] parts = commands.split(" ");
            String commandReceived = parts[0];

            switch (commandReceived) {
                case "Complete":
                    int index = Integer.parseInt(parts[1]);
                    for (int i = 0; i < tasks.size(); i++) {
                        if (index == i) {
                            tasks.set(index, 0);
                        }
                    }
                    break;
                case "Change":
                    int indexChange = Integer.parseInt(parts[1]);
                    int time = Integer.parseInt(parts[2]);
                    for (int i = 0; i < tasks.size(); i++) {
                        if (indexChange == i) {
                            tasks.set(indexChange, time);
                        }
                    }
                    break;
                case "Drop":
                    int dropIndex = Integer.parseInt(parts[1]);
                    for (int i = 0; i < tasks.size(); i++) {
                        if (dropIndex == i) {
                            tasks.set(dropIndex, -1);
                        }
                    }
                    break;
                case "Count":
                    if ("Completed".equals(parts[1])) {
                        for (int i = 0; i < tasks.size(); i++) {
                            if (tasks.get(i) == 0) {
                                countCompletedTasks++;
                            }
                        }
                        System.out.println(countCompletedTasks);
                    } else if ("Incomplete".equals(parts[1])) {
                        int incomplete = tasks.size();
                        incomplete = (incomplete - countCompletedTasks) - countDroppedTasks;
                        System.out.println(incomplete);
                    } else if ("Dropped".equals(parts[1])) {
                        for (int i = 0; i < tasks.size(); i++) {
                            if (tasks.get(i) == -1) {
                                countDroppedTasks++;
                            }
                        }

                        System.out.println(countDroppedTasks);
                    }
                    break;
            }


            commands = scan.nextLine();
        }

        for (Integer getTasks : tasks) {
            if (getTasks > 0) {
                System.out.print(getTasks + " ");
            }
        }
    }
}
