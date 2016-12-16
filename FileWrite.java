
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Week8D {

    public static void main(String[] args) {

        int count = 0;
        int[] wordCount = new int[16];

        BufferedReader inputStreamReader = null;

        String fileLine;
        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/johnclayton/Dropbox/Mattis.txt");
            InputStreamReader streamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferReader = new BufferedReader(streamReader);


            System.out.println("The top 16 saying from James " + "\"Mad Dog\" " + "Mattis");
            System.out.println("___________________________________________________ \n");

            // Read one Line using BufferedReader
            while ((fileLine = bufferReader.readLine()) != null) {
                System.out.println(fileLine);
            }

            for (int i = 0; i < wordCount.length; i++)
                if (wordCount[i] != -1)
                    count++;

            System.out.println("\nThe total number of sentences are: " +count);

        } catch (IOException io) {
            System.out.println("File IO exception" + io.getMessage());
        }finally {
            // Need another catch for closing
            // the streams
            try {
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
            } catch (IOException io) {
                System.out.println("Problem closing the Files" + io.getMessage());
            }

        }


    }
}
