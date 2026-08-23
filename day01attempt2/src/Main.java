import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

void main() {

    String testFilePath = "C:\\Users\\alexc\\IdeaProjects\\advent-of-code-25-adr\\.idea\\day01test.txt";
    String filePath = "C:\\Users\\alexc\\IdeaProjects\\advent-of-code-25-adr\\.idea\\day01.txt";

    int degrees = 50; // 50 DEGREES BY DEFAULT
    int count = 0; // COUNT OF  ENDING ON ZERO

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

        String line;
        while ((line = reader.readLine()) != null) { // FOR EACH LINE

            //System.out.println(line);

            int turnNum;
            try { // CONVERTS THE STRING OF NUMBER(S) INTO AN INTEGER
                turnNum = Integer.parseInt(line.substring(1));
            }
            catch (NumberFormatException e) {
                System.out.println("ERROR - NumberFormatException");
                turnNum = 0;
            }

            if ( line.charAt(0) == 'L' ) { // IF CODE STARTS WITH 'L'
                for (int i = 1; i <= turnNum; i++) { // FOR THE TOTAL CLICKS
                    degrees -= 1; // SUBTRACT 1
                    if (degrees == -1) { // IF IT GOES TO -1
                        degrees = 99; // SET TO 99
                    }
                }
            }
            else if ( line.charAt(0) == 'R' ){ // IF THE CODE STARTS WITH 'R'
                for (int i = 1; i <= turnNum; i++) { // FOR THE TOTAL CLICKS
                    degrees += 1; // ADD 1
                    if (degrees == 100) { // IF IT GOES TO 100
                        degrees = 0; // SET TO 0
                    }
                }
            }
            else { // ERROR CATCH
                System.out.println("ERROR - CODE DOES NOT START WITH L or R");
            }

            if ( degrees == 0 ) { // IF DEGREES END ON ZERO
                count += 1; // ADD ONE TO THE COUNT
            }

        }
    }

    catch (FileNotFoundException e) { // CATCH FOR FILE NOT FOUND ERROR
        System.out.println("ERROR - File not found");
    }
    catch (IOException e) { // CATCH FOR ERROR READING FILE
        System.out.println("ERROR - Error reading file");
    }

    // OUTPUTS OF FINAL DEGREES AND COUNT
    System.out.println("Final Degrees: " + degrees);
    System.out.println("Final Count: " + count);
}
