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
            System.out.println(line);
            System.out.println("Degrees: " + degrees);

            if( (line.charAt(0)) == 'L' ) { //IF TURNING LEFT
                if( line.length() == 2 ) {
                    int num = line.charAt(1) - '0';
                    degrees -= num;

                } else if ( line.length() == 3 ) {
                    int bigNum = (line.charAt(1) - '0') * 10;
                    int num = line.charAt(2) - '0';
                    int total = bigNum + num;
                    degrees -= total;

                } else if ( line.length() == 4 ){ // THREE NUMBERS
                    int bigNum = (line.charAt(1) - '0') * 100;
                    int midNum = (line.charAt(2) - '0') * 10;
                    int num = line.charAt(3) - '0';
                    int total = bigNum + midNum + num;
                    degrees -= total;
                }
                else{
                    System.out.println("Error - Code too long:" + line);
                }

            }
            else if ( (line.charAt(0)) == 'R' ) { //IF TURNING RIGHT

                if( line.length() == 2 ) { // ONE NUMBER
                    int num = line.charAt(1) - '0';
                    degrees += num;

                } else if ( line.length() == 3 ) { // TWO NUMBERS
                    int bigNum = (line.charAt(1) - '0') * 10;
                    int num = line.charAt(2) - '0';
                    int total = bigNum + num;
                    degrees += total;

                } else if ( line.length() == 4 ){ // THREE NUMBERS
                    int bigNum = (line.charAt(1) - '0') * 100;
                    int midNum = (line.charAt(2) - '0') * 10;
                    int num = line.charAt(3) - '0';
                    int total = bigNum + midNum + num;
                    degrees += total;
                }
                else{
                    System.out.println("Error - Code too long:" + line);
                }

            }
            else{
                System.out.println("Error - No direction Specified:" + line);
            }

            // ENSURE DEGREES REMAINS BETWEEN 0 AND 99 (INCLUSIVE)
            while ((degrees > 99) || (degrees <0) ){
                if (degrees > 99){
                    degrees -= 100;
                }
                if (degrees < 0) {
                    degrees += 100;
                }
            }


            // UPDATES COUNT IF DEGREES == 0
            if (degrees == 0){
                count += 1;
            }

            System.out.println("Degrees after: " + degrees);

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
