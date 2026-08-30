import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

void main() {
    // The safe dial starts at position 50
    int currentPosition = 50;

    // Counter to track how many times the dial points to 0 at any point
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

            // A nested loop to simulate every single click of the dial for this command
            for (int i = 0; i < amount; i++) {
                if (direction == 'R') {
                    // Clockwise rotation (Right)
                    // Move the dial up by 1 click. Wrap back to 0 if it goes past 99.
                    currentPosition = (currentPosition + 1) % 100;
                } else if (direction == 'L') {
                    // Anticlockwise rotation (Left)
                    // Move the dial down by 1 click. Add 100 before modulo to avoid negative numbers.
                    currentPosition = (currentPosition - 1 + 100) % 100;
                }

                // Check if the dial is pointing at 0 during this specific click
                if (currentPosition == 0) {
                    // Increment the counter by 1
                    zeroCount++;
                }
            }
        }

        // Close the scanner to free up system resources
        scanner.close();

        // Output the final tally to the console
        System.out.println("The dial pointed at 0 a total of " + zeroCount + " times.");

    } catch (FileNotFoundException e) {
        // This block catches the error if 'commands.txt' cannot be found
        System.out.println("Error: Could not find the file.");
    }
}