package com.company;

// Created by JClayton on 09/20/2018

public class Fraction implements Comparable {

   
    private String fraction;

    Fraction(String fraction) {     // Creating a constructor
     
        this.fraction = fraction;   // Store to variable fraction
    }

    @Override
    public int compareTo(Object input) {   // Method compares by cross mutliplying fractions
                                            // to determine which is larger or smaller

        String numbers[] = fraction.split("/");     // Seperates values and stores then in array
        int numerator = Integer.valueOf(numbers[0]);        // Holds the numerator
        int denominator = Integer.valueOf(numbers[1]);      // Holds the denominator
        numbers = input.toString().split("/");          // Splits the fraction and moves to next  
        int leftSideTotal = numerator * Integer.valueOf(numbers[1]);    // Holds left side total, first numerator and second denominator
        int rightSideTotal = denominator * Integer.valueOf(numbers[0]);  // Holds right side total, first denominator and second numerator

        return Integer.compare(leftSideTotal, rightSideTotal);  //returns 1 if the total on the left side is greater than the right side
                                                                //returns -1 is the total on the left side is less than the right side
                                                                //otherwise, returns 0
    }
    @Override
    public String toString() {
        return fraction;
    }

}
