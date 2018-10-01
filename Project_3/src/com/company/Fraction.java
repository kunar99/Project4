package com.company;

// Created by JClayton on 09/20/2018

public class Fraction implements Comparable {

    //to hold the list of fractions
    private String fraction;

    //constructor
    Fraction(String fraction) {

        //stores input to fraction variable
        this.fraction = fraction;
    }

    //this method compares each fraction using cross multiplying to determine
    // 	the result, thus determining which one is larger and smaller
    @Override
    public int compareTo(Object input) {

        //stores the fractions to an array and separates them
        String numbers[] = fraction.split("/");

        //to hold the numerator
        int numerator = Integer.valueOf(numbers[0]);

        //to hold the denominator
        int denominator = Integer.valueOf(numbers[1]);

        //splits the fractions again to get the next fraction
        numbers = input.toString().split("/");

        //to hold the left side total of the first numerator and the second denominator
        int leftSideTotal = numerator * Integer.valueOf(numbers[1]);

        //to hold the right side total of the fist denominator and the second numerator
        int rightSideTotal = denominator * Integer.valueOf(numbers[0]);


        return Integer.compare(leftSideTotal, rightSideTotal);  //returns 1 if the total on the left side is greater than the right side
                                                                //returns -1 is the total on the left side is less than the right side
                                                                //otherwise, returns 0
    }

    //to String method
    @Override
    public String toString() {
        return fraction;
    }

}