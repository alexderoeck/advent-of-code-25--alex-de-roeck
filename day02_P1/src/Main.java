
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

void main() {

    String testFilePath = "C:\\Users\\alexc\\IdeaProjects\\advent-of-code-25-adr\\textFiles\\day02test.txt";
    String filePath = "C:\\Users\\alexc\\IdeaProjects\\advent-of-code-25-adr\\textFiles\\day02.txt";

    long total = 0L; // TOTAL OF INVALID ID's

    try (Scanner scan1 = new Scanner(new FileReader(filePath))) {
        scan1.useDelimiter(",");

        String range;
        while ( scan1.hasNext() ) {
            range = scan1.next();
            System.out.println(range);

            Scanner scan2 = new Scanner(range); // SCANS BETWEEN RANGE "-"
            scan2.useDelimiter("-");

            int start; // START OF RANGE ----------
            try { // CONVERTS THE STRING OF NUMBER(S) INTO AN INTEGER
                start = Integer.parseInt(scan2.next());
            }
            catch (NumberFormatException e) {
                System.out.println("ERROR - NumberFormatException");
                start = 0;
            }

            int end; // END OF RANGE ----------
            try { // CONVERTS THE STRING OF NUMBER(S) INTO AN INTEGER
                end = Integer.parseInt(scan2.next());
            }
            catch (NumberFormatException e) {
                System.out.println("ERROR - NumberFormatException");
                end = 0;
            }

            System.out.println("Start: " + start + " End: " + end);


            // CHECKING THE RANGE FOR INVALID ID's
            for (int i = start; i <= end; i++) { // FOR ALL NUMBERS IN RANGE

                String temp = String.valueOf(i);
                int len = temp.length(); // GET LENGTH OF STRING
                if ( temp.startsWith("0") ){ //  IF IT LEADS WITH ZERO ITS INVALID
                    total += i; // ADD TO TOTAL
                    System.out.println(i + " Added to the total");
                    System.out.println("Total is " + total);
                }
                else if ( (len % 2) == 0) { // IF EVEN CONTINUE, AS ODD MUST BE VALID

                    int mid = (len / 2); // GET MIDDLE OF STRING
                    String firstHalf = temp.substring(0, mid); // GET FIRST HALF
                    String secondHalf = temp.substring(mid); // GET SECOND HALF
                    boolean isInvalid = firstHalf.equals(secondHalf); // CHECK IF HALVES ARE SAME -> INVALID
                    if (isInvalid) { // IF INVALID ID
                        total += i; // ADD TO TOTAL
                        System.out.println(i + " Added to the total");
                        System.out.println("Total is " + total);
                    }

                }

            }
        }

    }

    catch (FileNotFoundException e) {
        System.out.println("ERROR - FILE NOT FOUND");
    }
    catch (IOException e) {
        System.out.println("ERROR - ERROR READING FILE");
    }

    // OUTPUTS OF FINAL TOTAL
    System.out.println("Final Total: " + total);

}
