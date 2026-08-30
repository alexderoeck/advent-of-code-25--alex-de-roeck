import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

void main() {
    // The safe dial starts at position 50
    int currentPosition = 50;

    // Counter to track how many times the dial lands exactly on 0
    int zeroCount = 0;

    String textFileName = "C:\\Users\\alexc\\IdeaProjects\\advent-of-code-25-adr\\textFiles\\day01.txt";

    try {
        // Target the text file containing the sequence of commands
        File file = new File(textFileName);

        // Scanner reads the file line by line
        Scanner scanner = new Scanner(file);

        // Loop through the file as long as there is another line to read
        while (scanner.hasNextLine()) {
            // Read the line and remove any leading/trailing spaces
            String line = scanner.nextLine().trim();

            // Skip empty lines to prevent the program from crashing
            if (line.isEmpty()) continue;

            // Extract the first character to determine the direction (R or L)
            char direction = line.charAt(0);

            // Extract the rest of the string and convert it into an integer
            int amount = Integer.parseInt(line.substring(1));

            if (direction == 'R') {
                // Clockwise rotation (Right)
                // Add the amount to the current position.
                // The modulo operator (%) 100 ensures the dial wraps back to 0 after 99.
                currentPosition = (currentPosition + amount) % 100;
            } else if (direction == 'L') {
                // Anticlockwise rotation (Left)
                // Subtract the amount. Because Java's modulo can return negative numbers,
                // we add 100 before applying % 100 to ensure a positive position.
                currentPosition = (currentPosition - (amount % 100) + 100) % 100;
            }

            // Check if the dial has landed on 0 at the end of this specific command
            if (currentPosition == 0) {
                // Increment the counter by 1
                zeroCount++;
            }
        }

        // Close the scanner to free up system resources
        scanner.close();

        // Output the final tally to the console
        System.out.println("The dial landed on 0 at the end of a command " + zeroCount + " times.");

    } catch (FileNotFoundException e) {
        // This block catches the error if 'commands.txt' cannot be found in the project root
        System.out.println("Error: Could not find the file.");
    }
}