import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WizardPokerTask3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(":");
        List<String> cards = new ArrayList<>();
        for (String addCards : input) {
            cards.add(addCards);
        }

        List<String> newDeckOfCards = new ArrayList<>();

        String command = scan.nextLine();
        while (!"Ready".equals(command)) {
            String[] parts = command.split(" ");
            String receivedCommand = parts[0];

            switch (receivedCommand) {
                case "Add":
                    String addCardName = parts[1];
                    if (cards.contains(addCardName)) {
                        newDeckOfCards.add(addCardName);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Insert":
                    String insertCardName = parts[1];
                    int index = Integer.parseInt(parts[2]);
                    if (cards.contains(insertCardName)) {
                        newDeckOfCards.add(index, insertCardName);
                    } else {
                        System.out.println("Error!");
                }
                    break;
                case "Remove":
                    String removeCard = parts[1];
                    if (!newDeckOfCards.contains(removeCard)) {
                        System.out.println("Card not found.");
                    }
                    newDeckOfCards.remove(removeCard);
                    break;
                case "Swap":
                    String swapCardOne = parts[1];
                    String swapCardTwo = parts[2];
                    int indexCardOne = 0;
                    int indexCardTwo = 0;

                    for (int i = 0; i < newDeckOfCards.size(); i++) {
                        if (newDeckOfCards.get(i).equals(swapCardOne)) {
                            indexCardOne = i;
                        }
                        if (newDeckOfCards.get(i).equals(swapCardTwo)) {
                            indexCardTwo = i;
                        }
                    }
                    String temp = swapCardOne;
                    swapCardOne = swapCardTwo;
                    swapCardTwo = temp;
                    newDeckOfCards.set(indexCardOne, swapCardOne);
                    newDeckOfCards.set(indexCardTwo, swapCardTwo);
                    break;
                case "Shuffle":
                    Collections.reverse(newDeckOfCards);
                    break;
            }
            command = scan.nextLine();
        }

        System.out.print(String.join(" ", newDeckOfCards));
    }
}
