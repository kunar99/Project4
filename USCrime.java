/**
 * Created by johnclayton on 12/16/16.
 */

import java.io.*;
import java.io.FileReader;
import java.util.IdentityHashMap;
import java.util.Scanner;

public class USCrime {

    static double [] [] crimeArray;

    static void setUpCrimeArray(){

        crimeArray = new double[25] [25];

        Scanner input = null;

        int rowC = 0;
        int row = 0;
        int colC = 0;
        int col = 0;
        String inputLine = " ";
        double xnum = 0;
        String fileLocation;

        fileLocation = "/Users/johnclayton/Dropbox/Homework/Computer Science/Java/Final/src";


        try {

            input = new Scanner(new BufferedReader(new FileReader(fileLocation)));


            while (input.hasNextLine()){

                inputLine = input.nextLine();

                String[] inArray = inputLine.split(",");

                for (int x = 0; x < inArray.length; x++) {

                    crimeArray [rowC] [x] = Double.parseDouble(inArray[x]);
                }

                rowC++;

            }

            //Create 2D Array to store the values returned in the ArrayList named lines
            String[][] result = new String(crimeArray[rowC][]);
//For loop to loop through the Array
            for(int i=0; i<result.length; i++) {
                //Set the value of the 2D Array to the stored ArrayList line
                crimeArray [rowC] [i] = Double.parseDouble(result[i]);
                //Display the returned lines

            }//end for loop
            int index = getSpeakerSelected(inputLine, result);

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


            //} catch (Exception e) {

         //   System.out.println(e);


       // System.out.print(crimeArray);






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

