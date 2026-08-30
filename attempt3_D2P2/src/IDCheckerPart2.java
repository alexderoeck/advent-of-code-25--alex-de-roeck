import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

void main() {
    // We use a 'long' because the total sum will quickly exceed the maximum limit of an 'int'
    long sumOfInvalidIds = 0;

    String textFileName = "C:\\Users\\alexc\\IdeaProjects\\advent-of-code-25-adr\\textFiles\\day02.txt";


    // Compile the regex pattern once outside the loop for maximum efficiency
    // ^ means start of string, (.+) captures any sequence of 1 or more digits,
    // \\1+ expects that exact captured sequence to repeat 1 or more times, $ means end of string
    Pattern repeatingPattern = Pattern.compile("^(.+)\\1+$");

    try {
        // Target the text file containing the ranges
        File file = new File(textFileName);
        Scanner scanner = new Scanner(file);

        // Check if the file has content
        if (scanner.hasNextLine()) {
            // Read the single line of comma-separated ranges and remove trailing spaces
            String line = scanner.nextLine().trim();

            // Split the line into individual range strings
            String[] ranges = line.split(",");

            for (String range : ranges) {
                // Split each range by the dash to separate the start and end points
                String[] bounds = range.split("-");
                long start = Long.parseLong(bounds[0]);
                long end = Long.parseLong(bounds[1]);

                // Loop through every ID in the current range
                for (long currentId = start; currentId <= end; currentId++) {
                    // Convert the ID to a string so the regex engine can process it
                    String idStr = String.valueOf(currentId);

                    // Apply the compiled regex pattern to the current ID string
                    Matcher matcher = repeatingPattern.matcher(idStr);

                    // If .matches() returns true, the entire ID is made of a repeating sequence
                    if (matcher.matches()) {
                        // Add the invalid ID to our running total
                        sumOfInvalidIds += currentId;
                    }
                }
            }
        }

        // Close the scanner to free up system resources
        scanner.close();

        // Output the final tally to the console
        System.out.println("The total sum of all invalid IDs is: " + sumOfInvalidIds);

    } catch (FileNotFoundException e) {
        // Catches the error if 'ranges.txt' cannot be found in the project root
        System.out.println("Error: Could not find the file.");
    }
}