import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

void main() {
    // We use a 'long' because the total output joltage across all banks will be very large
    long totalOutputJoltage = 0;

    String textFileName = "C:\\Users\\alexc\\IdeaProjects\\advent-of-code-25-adr\\textFiles\\day03.txt";

    try {
        // Target the text file containing the rows of batteries
        File file = new File(textFileName);

        // Scanner reads the file line by line
        Scanner scanner = new Scanner(file);

        // Loop through the file as long as there is another line to read
        while (scanner.hasNextLine()) {
            // Read the line and remove any leading/trailing spaces
            String line = scanner.nextLine().trim();

            // Skip empty lines or lines with fewer than 12 batteries to prevent errors
            if (line.length() < 12) continue;

            // Call our helper method to find the maximum 12-digit joltage for this row,
            // and add it to our running total.
            totalOutputJoltage += getMaxJoltageForBank(line);
        }

        // Close the scanner to free up system resources
        scanner.close();

        // Output the final tally to the console
        System.out.println("The total output joltage across all banks is: " + totalOutputJoltage);

    } catch (FileNotFoundException e) {
        // Catches the error if 'batteries.txt' cannot be found in the project root
        System.out.println("Error: Could not find the file.");
    }
}

// --- Helper Method ---
// This method selects exactly 12 batteries in order to form the largest possible 12-digit number.
long getMaxJoltageForBank(String line) {
    int targetLength = 12;
    int n = line.length();
    StringBuilder bestJoltageBuilder = new StringBuilder();

    // Tracks where we are allowed to start searching in the string
    int startIndex = 0;

    // Loop 12 times to pick each of the 12 digits from left to right
    for (int step = 0; step < targetLength; step++) {
        // Calculate how many digits still need to be picked after this one
        int digitsNeededAfterThis = targetLength - 1 - step;

        // Find the furthest index we can search up to, ensuring we leave enough characters for the remaining digits
        int searchEndIndex = n - 1 - digitsNeededAfterThis;

        char maxChar = '/'; // Initialise lower than any digit character ('0' is ASCII 48, '/' is 47)
        int maxCharIndex = -1;

        // Search through the allowed window to find the largest digit available
        for (int i = startIndex; i <= searchEndIndex; i++) {
            char currentChar = line.charAt(i);
            if (currentChar > maxChar) {
                maxChar = currentChar;
                maxCharIndex = i; // Remember the position of this highest digit
            }
        }

        // Append the largest found digit to our building 12-digit number
        bestJoltageBuilder.append(maxChar);

        // Move our search starting point to immediately after the digit we just chose
        startIndex = maxCharIndex + 1;
    }

    // Convert the final 12-digit string into a long and return it
    return Long.parseLong(bestJoltageBuilder.toString());
}