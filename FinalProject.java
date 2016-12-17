import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by jclayton on 12/16/2016.
 */
public class FinalProject {

      public static void main(String[] args) throws IOException {
        //Define Variables & Initialize
        String fileName = "quotes.txt";
        String line;
        String[] splitLine;

        //Create a new BufferReader object and File Reader Object
        BufferedReader in = new BufferedReader(new FileReader(fileName));

        //Create an ArrayList to List the text as strings - used to split the string into a 2D array
        List<String[]> lines = new ArrayList<>();
        //Create Scanner Object
        Scanner input = new Scanner(System.in);
        //Display Options
        System.out.println("1.  What were the percentage in population growth for each consecutive year from 1994 - 2013?");
        System.out.println("2.  What year was the murder rate the highest?");
        System.out.println("3.  What year was the Murder rate the lowest?");
        System.out.println("4.  What year was the Robbery rate the highest?");
        System.out.println("5.  What year was the Robbery rate the lowest?");
        System.out.println("6.  What was the total percentage change in Motor Vehicle Theft between 1998 and 2012?");
        System.out.println("7.  What year had the most Rape incidents?");
        System.out.println("8.  What year was the Rape rate the highest?");
        System.out.println("Q.  Quit the program");

        System.out.println("Enter your selection: ");

        //Create an int name userSelection to store the users input option
        String userSelection = input.nextLine();






        //Try statement to throw the IO Exception if it fails
        try {
//Set the ArrayList named line to the BufferReader named in to read the next Line from the text file
            line = in.readLine();

//While statement to loop through the text file until there isn't a new line
            while (line !=null) {

                //Set the ArrayList named line to the BufferReader named in to read the next Line from the text file
                line = in.readLine();
                //Store the string as the array splitline and split it at the - in the text string
                splitLine = line.split("-");

                //For statement to loop through the splitLine string
                for(int i=0; i<splitLine.length; i++) {
//Store the Substring value that was after the split -
                    splitLine[i] = splitLine[i].substring(0, splitLine[i].length());
                }//end for statement
                //Add the line to the Array
                lines.add(splitLine);
                //Set the ArrayList named line back to read the next line in the text file
                line = in.readLine();
            }//end while loop

//Create 2D Array to store the values returned in the ArrayList named lines
            String[][] result = new String[lines.size()][];
//For loop to loop through the Array
            for(int i=0; i<result.length; i++) {
                //Set the value of the 2D Array to the stored ArrayList line
                result[i]  = lines.get(i);
                //Display the returned lines

            }//end for loop
            int index = getSpeakerSelected(userSelection, result);

            //If the index returns a match
            if (index != -1) {
                //Display the quote and the speaker
                System.out.println(getQuote(index, result) + "\tQuoted By: " + getSpeaker(index, result));

            }//end if

            //If the binary search method doesn't match a string in the array
            else {
                //Display no quotes found
                System.out.println("No quotes matched the option you selected. Please try again");
            }//end else statement
        }//end try statement
//Catch any exception thrown from the Try statement
        catch (IOException ex)  {
//Display Error Message
            ex.printStackTrace();
        }//end catch statement
    }

    //getSpeaker Method to get the Speaker of the quote
    private static int getSpeakerSelected(String speakerSelected, String[][] result)
    {
        //loop through the array
        for (int i=0;i<result.length;i++) {

            //if the input matches a stored value in the 2nd row of the array
            if (speakerSelected.trim().equalsIgnoreCase(result[i][1])) {
                return i;
            }//end if
        }return -1;
    }//end method

    //get Quote method to get the Quote stored in the array
    private static String getQuote(int index, String[][] result) {
        return result[index][0];
    }//end method

    //getter method to get the Speaker of the quote stored in the array
    private static String getSpeaker(int index, String[][] result) {
        return result[index][1];
    }//end method
}
