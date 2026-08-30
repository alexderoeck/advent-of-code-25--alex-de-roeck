import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

void main() {
    // We use a 'long' because adding these large IDs together will quickly exceed the maximum value of a standard 'int'
    long sumOfInvalidIds = 0;

    String textFileName = "C:\\Users\\alexc\\IdeaProjects\\advent-of-code-25-adr\\textFiles\\day02.txt";

    try {
        // Target the text file containing the single line of comma-separated ranges
        File file = new File(textFileName);

        // Scanner reads the file
        Scanner scanner = new Scanner(file);

        // Check if the file actually has content to read
        if (scanner.hasNextLine()) {
            // Read the entire single line and remove any leading/trailing spaces
            String line = scanner.nextLine().trim();

            // Split the line by commas to get an array of individual ranges (e.g., "11-22", "95-115")
            String[] ranges = line.split(",");

            // Loop through each range in the array
            for (String range : ranges) {
                // Split the current range by the dash to separate the start and end points
                String[] bounds = range.split("-");

                // Parse the start point as a long
                long start = Long.parseLong(bounds[0]);

                // Parse the end point as a long
                long end = Long.parseLong(bounds[1]);

                // Loop through every single ID from the start point to the end point (inclusive)
                for (long currentId = start; currentId <= end; currentId++) {

                    // Convert the current ID into a String so we can easily check its digits
                    String idStr = String.valueOf(currentId);

                    // Get the total length (number of digits) of the current ID
                    int length = idStr.length();

                    // An invalid ID must have an even number of digits to be a sequence repeated twice
                    if (length % 2 == 0) {

                        // Extract the first half of the string (from index 0 up to the middle)
                        String firstHalf = idStr.substring(0, length / 2);

                        // Extract the second half of the string (from the middle to the end)
                        String secondHalf = idStr.substring(length / 2);

                        // Check if the two halves are exactly identical
                        if (firstHalf.equals(secondHalf)) {

                            // If they match, it is an invalid ID, so add it to our running total
                            sumOfInvalidIds += currentId;
                        }
                    }
                }
            }
        }

        // Close the scanner to free up system resources
        scanner.close();

        // Output the final sum to the console
        System.out.println("The total sum of all invalid IDs is: " + sumOfInvalidIds);

    } catch (FileNotFoundException e) {
        // This block catches the error if 'ranges.txt' cannot be found in the project root
        System.out.println("Error: Could not find the file.");
    }
}