import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

void main() {
    // We use a 'long' to prevent integer overflow if the total gets very high
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

            // Skip empty lines or lines with fewer than 2 batteries to prevent errors
            if (line.length() < 2) continue;

            // Call our helper method to do the heavy lifting for this specific row,
            // and add the returned maximum joltage to our running total.
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
// Extracting this logic makes the main method cleaner.
// This method takes a single row of batteries and returns its highest possible 2-digit joltage.
int getMaxJoltageForBank(String line) {
    // Variable to track the highest joltage found in this specific bank so far
    int maxBankJoltage = 0;

    // Outer loop: picks the first battery.
    // It stops at the second-to-last character (length - 1) because the first battery needs at least one battery to its right.
    for (int i = 0; i < line.length() - 1; i++) {

        // Inner loop: picks the second battery.
        // It always starts at 'i + 1' to ensure it is strictly to the right of the first battery.
        for (int j = i + 1; j < line.length(); j++) {

            // Convert the characters into their integer values.
            // Subtracting the character '0' is a standard Java trick to get the true numeric value of a char.
            int firstDigit = line.charAt(i) - '0';
            int secondDigit = line.charAt(j) - '0';

            // Form the two-digit joltage (e.g., if digits are 2 and 4, 2 * 10 + 4 = 24)
            int currentJoltage = (firstDigit * 10) + secondDigit;

            // If this specific pair produces a higher joltage than our current record for this bank, update the record
            if (currentJoltage > maxBankJoltage) {
                maxBankJoltage = currentJoltage;
            }
        }
    }

    // Send the highest value found back to where the method was called in the main loop
    return maxBankJoltage;
}