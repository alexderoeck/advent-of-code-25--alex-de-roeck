import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

void main() {

    int degrees = 50; // STARTS AT 50
    int count = 0; // NUM OF TIMES DEGREES = 0

    String filePath = "C:\\Users\\alexc\\IdeaProjects\\advent-of-code-25-adr\\.idea\\day01.txt";

    try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
        System.out.println("That file exists");


        String line;
        while((line = reader.readLine()) != null){
            System.out.println(line + " --------------------");
            System.out.println("Degrees before: " + degrees);
            System.out.println("Count before: " + count);

            if( (line.charAt(0)) == 'L' ) { //IF TURNING LEFT ---------------------------------

                if ( line.length() == 2 ) { // ONE NUMBER

                    int num = line.charAt(1) - '0'; // CONVERTS CHAR -> INT
                    if (degrees == 0){
                        degrees -= num;
                        if (degrees < 0) { // CAN ONLY PASS ZERO ONCE SO NO LOOP NEEDED
                            degrees += 100; // MAKE THE VALUE SUITABLE
                        } // DOES NOT ADD 1 TO COUNT AS THAT WOULD MAKE IT INACCURATE AS 0 ALREADY ACCOUNTED FOR
                    }
                    else {
                        degrees -= num;
                        if (degrees < 0) { // CAN ONLY PASS ZERO ONCE SO NO LOOP NEEDED
                            degrees += 100; // MAKE THE VALUE SUITABLE
                            count += 1; // ADD 1 TO THE COUNT
                        }
                    }
                    if (degrees == 0){
                        count += 1;
                    }

                } else if ( line.length() == 3 ) { // TWO NUMBERS -----------

                    int tensNum = (line.charAt(1) - '0') * 10;
                    if (degrees == 0){
                        degrees -= tensNum;
                        if (degrees < 0) { // CAN ONLY PASS ZERO ONCE SO NO LOOP NEEDED
                            degrees += 100; // MAKE THE VALUE SUITABLE
                        } // DOES NOT ADD 1 TO COUNT AS THAT WOULD MAKE IT INACCURATE AS 0 ALREADY ACCOUNTED FOR
                    }
                    else {
                        degrees -= tensNum;
                        if (degrees < 0) { // CAN ONLY PASS ZERO ONCE SO NO LOOP NEEDED
                            degrees += 100; // MAKE THE VALUE SUITABLE
                            count += 1; // ADD 1 TO THE COUNT
                        }
                    }

                    int num = line.charAt(2) - '0'; // CONVERTS CHAR -> INT
                    if (degrees == 0){
                        degrees -= num;
                        if (degrees < 0) { // CAN ONLY PASS ZERO ONCE SO NO LOOP NEEDED
                            degrees += 100; // MAKE THE VALUE SUITABLE
                        } // DOES NOT ADD 1 TO COUNT AS THAT WOULD MAKE IT INACCURATE AS 0 ALREADY ACCOUNTED FOR
                    }
                    else {
                        degrees -= num;
                        if (degrees < 0) { // CAN ONLY PASS ZERO ONCE SO NO LOOP NEEDED
                            degrees += 100; // MAKE THE VALUE SUITABLE
                            count += 1; // ADD 1 TO THE COUNT
                        }
                    }
                    if (degrees == 0){
                        count += 1;
                    }

                } else if ( line.length() == 4 ){ // THREE NUMBERS -----------

                    int hundredsNum = (line.charAt(1) - '0');
                    count += hundredsNum; // EVERY HUNDRED IS A PASS OF ZERO -> ADD TO COUNT NUM OF HUNDREDS

                    int tensNum = (line.charAt(2) - '0') * 10;
                    if (degrees == 0){
                        degrees -= tensNum;
                        if (degrees < 0) { // CAN ONLY PASS ZERO ONCE SO NO LOOP NEEDED
                            degrees += 100; // MAKE THE VALUE SUITABLE
                        } // DOES NOT ADD 1 TO COUNT AS THAT WOULD MAKE IT INACCURATE AS 0 ALREADY ACCOUNTED FOR
                    }
                    else {
                        degrees -= tensNum;
                        if (degrees < 0) { // CAN ONLY PASS ZERO ONCE SO NO LOOP NEEDED
                            degrees += 100; // MAKE THE VALUE SUITABLE
                            count += 1; // ADD 1 TO THE COUNT
                        }
                    }

                    int num = line.charAt(3) - '0'; // CONVERTS CHAR -> INT
                    if (degrees == 0){
                        degrees -= num;
                        if (degrees < 0) { // CAN ONLY PASS ZERO ONCE SO NO LOOP NEEDED
                            degrees += 100; // MAKE THE VALUE SUITABLE
                        } // DOES NOT ADD 1 TO COUNT AS THAT WOULD MAKE IT INACCURATE AS 0 ALREADY ACCOUNTED FOR
                    }
                    else {
                        degrees -= num;
                        if (degrees < 0) { // CAN ONLY PASS ZERO ONCE SO NO LOOP NEEDED
                            degrees += 100; // MAKE THE VALUE SUITABLE
                            count += 1; // ADD 1 TO THE COUNT
                        }
                    }
                    if (degrees == 0){
                        count += 1;
                    }
                }
                else{
                    System.out.println("Error - Code too long:" + line);
                }

            }
            else if ( (line.charAt(0)) == 'R' ) { //IF TURNING RIGHT ---------------------------------

                if ( line.length() == 2 ) { // ONE NUMBER -----------

                    int num = line.charAt(1) - '0'; // CONVERTS CHAR -> INT
                    if (degrees == 0){
                        degrees += num;
                        if (degrees > 99){ // CAN ONLY PASS ZERO ONCE SO NO LOOP NEEDED
                            degrees -= 100; // MAKE THE VALUE SUITABLE
                        }// DOES NOT ADD 1 TO COUNT AS THAT WOULD MAKE IT INACCURATE AS 0 ALREADY ACCOUNTED FOR
                    }
                    else {
                        degrees += num;
                        if (degrees > 99){ // CAN ONLY PASS ZERO ONCE SO NO LOOP NEEDED
                            degrees -= 100; // MAKE THE VALUE SUITABLE
                            count += 1; // ADD 1 TO THE COUNT
                        }
                    }

                } else if ( line.length() == 3 ) { // TWO NUMBERS -----------

                    int tensNum = (line.charAt(1) - '0') * 10;
                    degrees += tensNum;
                    if (degrees > 99){ // CAN ONLY PASS ZERO ONCE SO NO LOOP NEEDED
                        degrees -= 100; // MAKE THE VALUE SUITABLE
                        count += 1; // ADD 1 TO THE COUNT
                    }

                    int num = line.charAt(2) - '0';
                    degrees += num;
                    if (degrees > 99){ // CAN ONLY PASS ZERO ONCE SO NO LOOP NEEDED
                        degrees -= 100; // MAKE THE VALUE SUITABLE
                        count += 1; // ADD 1 TO THE COUNT
                    }

                } else if ( line.length() == 4 ){ // THREE NUMBERS -----------

                    int hundredsNum = (line.charAt(1) - '0');
                    count += hundredsNum; // EVERY HUNDRED IS A PASS OF ZERO -> ADD TO COUNT NUM OF HUNDREDS

                    int tensNum = (line.charAt(2) - '0') * 10;
                    degrees += tensNum;
                    if (degrees > 99){ // CAN ONLY PASS ZERO ONCE SO NO LOOP NEEDED
                        degrees -= 100; // MAKE THE VALUE SUITABLE
                        count += 1; // ADD 1 TO THE COUNT
                    }

                    int num = line.charAt(3) - '0';
                    degrees += num;
                    if (degrees > 99){ // CAN ONLY PASS ZERO ONCE SO NO LOOP NEEDED
                        degrees -= 100; // MAKE THE VALUE SUITABLE
                        count += 1; // ADD 1 TO THE COUNT
                    }

                    //int total = bigNum + tensNum + num;
                    //degrees += bigNum;    // REDUNDANT AS IT GETS CANCELLED OUT
                }
                else{
                    System.out.println("Error - Code more than 4 characters / value over 999:" + line);
                }

            }
            else{
                System.out.println("Error - No direction Specified:" + line);
            }


            // ENSURE DEGREES REMAINS BETWEEN 0 AND 99 (INCLUSIVE) --- NOW A CATCH IN PART 2 OF DAY01
            /*while ((degrees > 99) || (degrees <0) ){

                System.out.println("ERROR - UPDATED DEGREES TO BE CORRECT");

                if (degrees > 99){
                    degrees -= 100;
                }
                if (degrees < 0) {
                    degrees += 100;
                }
            }*/


            // UPDATES COUNT IF DEGREES == 0
//            if (degrees == 0){
//                count += 1;
//            }

            System.out.println("Degrees after: " + degrees);
            System.out.println("Count after: " + count);

        }
    }


    catch(FileNotFoundException e){
        System.out.println("Could not locate file");
    }
    catch(IOException e){
        System.out.println("Something went wrong");
    }

    System.out.println("Total times pointed at zero: " + count);

}
