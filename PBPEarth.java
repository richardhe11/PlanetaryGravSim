package com.company;
import java.math.*;
import java.util.*;

//note: still haven't cleaned out all the bugs yet, but it's working so far!
public class PBPEarth {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        boolean yes = false;

        while (!yes) {

            System.out.println("Welcome to the Hammer and Feather experiment!");
            System.out.println();

            System.out.println("Enter your feather's mass (kg): ");
            double F = scnr.nextDouble();
            //setting variable for the Feather

            System.out.println("Enter your hammer's mass (kg): ");
            double H = scnr.nextDouble();
            //setting variable for the Hammer

            System.out.println("Enter the height from which you want to drop the two objects (m): ");
            double R = scnr.nextDouble() + 6378000;
            //setting total radius (6379000 is the approx. radius from the Earth's surface to it's core)

            if (((R - 6378000) < 0) || (F < 0) || (H < 0)) {
                yes = false; //in case user inputs negative variables that do not exist
            }

            else {
                yes = true; //in case user inputs negative variables that do not exist
            }

            double M = 5.97 * Math.pow(10, 24); //setting the mass of the Earth
            double G = 6.67 * Math.pow(10, -11); //setting the Gravitational Constant
            double f1 = (G * F * M) / Math.pow(R, 2); //calculating for the gravitational force of the feather
            double f2 = (G * H * M) / Math.pow(R, 2); //calculating for the gravitational force of the hammer
            double a1 = f1 / F; //calculating gravitational acceleration for the feather
            double a2 = f2 / H; //calculating gravitational acceleration for the hammer

            BigDecimal feather = new BigDecimal(a1);
            feather = feather.round(new MathContext(3)); //calculating three significant figures for acceleration of feather
            double A1 = feather.doubleValue();

            BigDecimal hammer = new BigDecimal(a2);
            hammer = hammer.round(new MathContext(3)); //calculating three significant figures for acceleration of hammer
            double A2 = hammer.doubleValue();

            System.out.println();
            System.out.println("FEATHER RESULTS: ");

            for (int i = 0; i <= (R - 6378000); i++) {
                System.out.println("At " + i + " metres, the feather will have fallen for approx. " + Math.sqrt(i/(a1/2)) + " seconds.");
                //Time lapsed per metre for the feather
            }

            System.out.println();
            System.out.println("HAMMER RESULTS: ");

            for (int i = 0; i <= (R - 6378000); i++) {
                System.out.println("At " + i + " metres, the hammer will have fallen for approx. " + Math.sqrt(i/(a2/2)) + " seconds.");
                //Time lapsed for metre for the hammer
            }

            if ((A1 == A2) && (yes))
            //checks if the two objects have the same acceleration (if they will hit the ground at the same time)
            {
                System.out.println("");
                System.out.println("'Well, how about that! Looks like Galileo was correct!'");
                System.out.println("Both objects will have hit the ground at the same time, falling at " + A1 + " m/s^2 (at the equator).");
                    //results message
            }

            else
            //this is to prompt the user to not use negative numbers
            {
                System.out.println();
                System.out.println("Feather: DNE Hammer: DNE");
                System.out.println("Please input values greater than zero.");
                System.out.println();
            }

        }
    }
}
//richardhe2016
