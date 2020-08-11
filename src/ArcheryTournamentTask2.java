//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class ArcheryTournamentTask2 {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//        String[] input = scan.nextLine().split("\\|");
//        List<Integer> targets = new ArrayList<>();
//
//        for (String getTargets : input) {
//            int current = Integer.parseInt(getTargets);
//            targets.add(current);
//        }
//
//        String command = scan.nextLine();
//
//        int points = 0;
//        while (!"Game over".equals(command)) {
//            String[] parts = command.split("@");
//
//            if ("Shoot Left".equals(parts[0])) {
//                int startIndex = Integer.parseInt(parts[1]);
//                if (startIndex > targets.size()) {
//                    break;
//                } else {
//                    int startIndexToShoot = Integer.parseInt(parts[1]);
//                    int length = Integer.parseInt(parts[2]);
//
//                    for (int i = targets.size(); i <=  ; i--) {
//                        if (i == length) {
//                            int element = targets.get(i);
//                            targets.set(i, element -5);
//                            points += 5;
//                        }
//                    }
//
//
//
//                }
//
//            } else if ("Shoot Right".equals(parts[0])) {
//                int startIndex = Integer.parseInt(parts[1]);
//                if (startIndex > targets.size()) {
//                    break;
//                } else {
//                    int startIndexToShoot = Integer.parseInt(parts[1]);
//                    int length = Integer.parseInt(parts[2]);
//
////                    for (int i = 0; i < ; i++) {
////
////                    }
//
//                }
//            }
//            command = scan.nextLine();
//        }
//
//        System.out.println();
//    }
//}
//
//
////