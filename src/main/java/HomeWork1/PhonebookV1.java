package HomeWork1;

import java.io.IOException;
import java.util.Scanner;

public class PhonebookV1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Entry[] entries = FileUtils.readFile("raw_phonebook_data.csv");

            MergeSort.sort(entries);

            FileUtils.writeToFile(entries, "sorted_phonebook.csv");

            while (true) {
                System.out.println("Enter a name to search (Surname, Name) or -1 to exit:");
                String name = scanner.nextLine();

                if (name.equals("-1")) {
                    break;
                }

                int[] result = BinarySearch.search(entries, name);

                if (result.length == 0) {
                    System.out.println("No entries found for the name: " + name);
                } else {
                    int startIndex = result[0];
                    int endIndex = result[1];
                    System.out.println("Found " + (endIndex - startIndex + 1) + " entries:");
                    for (int i = startIndex; i <= endIndex; i++) {
                        System.out.println(entries[i]);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while processing the file: " + e.getMessage());
        }

        scanner.close();
    }
}