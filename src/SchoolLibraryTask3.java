import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolLibraryTask3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("&");
        List<String> books = new ArrayList<>();
        for (String addBooks : input) {
            books.add(addBooks);
        }

        String command = scan.nextLine();
        while (!"Done".equals(command)) {
            String[] parts = command.split(" \\| ");

            if ("Add Book".equals(parts[0])) {
                if (!books.contains(parts[1])) {
                    books.add(0, parts[1]);
                }
            } else if ("Take Book".equals(parts[0])) {
                books.remove(parts[1]);
            } else if ("Swap Books".equals(parts[0])) {
                if (books.contains(parts[1]) && books.contains(parts[2])) {
                    int indexFirstBook = 0;
                    int indexSecondBook = 0;
                    for (int i = 0; i < books.size(); i++) {
                        if (books.get(i).equals(parts[1])) {
                            indexFirstBook = i;
                        }
                        if (books.get(i).equals(parts[2])) {
                            indexSecondBook = i;
                        }
                    }
                    int temp = 0;
                    temp = indexFirstBook;
                    indexFirstBook = indexSecondBook;
                    indexSecondBook = temp;
                    books.set(indexFirstBook, parts[1]);
                    books.set(indexSecondBook, parts[2]);
                }
            } else if ("Insert Book".equals(parts[0])) {
                books.add(parts[1]);
            } else if ("Check Book".equals(parts[0])) {
                int index = Integer.parseInt(parts[1]);
                if (index > books.size()) {
                    break;
                } else {
                    String bookName = "";
                    for (int i = 0; i < books.size(); i++) {

                        if (i == index) {
                            bookName = books.get(i);
                        }
                    }
                    System.out.println(bookName);
                }
            }

            command = scan.nextLine();
        }


        System.out.print(String.join(", ", books));
    }
}
