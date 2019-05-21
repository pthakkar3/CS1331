package edu.gatech.cs1331.gradebook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {
        Scanner kbd = new Scanner(System.in);
        boolean isValidInput = false;
        // Notice that, due to nested scoping, we must declare
        // gradesFile here so we can reference it in both the try
        // block and catch clause
        String gradesFile = "";
        // What happens if we don't initialize gradesFile with ""?
        while (!isValidInput) {
            try {
                System.out.print("Enter the name of a grades file: ");
                gradesFile = kbd.nextLine();
                GradeBook gb = new GradeBook(gradesFile.trim());
                // If line above throws an exception, we won't get here
                isValidInput = true;
                System.out.printf("Your final course grade is %.1f%n",
                                  gb.courseAverage());
            } catch (FileNotFoundException e) {
                // In each of these catch clauses we catch an excetion
                // ("message in a bottle") thrown by the GradeBook
                // constructor to indicate a problem and deal with it
                // appropriately.
                System.out.println(String.format("%s was not found.", gradesFile));
                System.out.println("Try again.");
            } catch (ParseException e) {
                System.out.println(String.format("%s was malformed.", gradesFile));
                System.out.println(e.getMessage());
                System.out.println("Try again.");
            }
            // If any other kinds of exceptions are thrown, we don't
            // know how to recover from them, so we declare that we
            // propagate them (see method header) instead of catching
            // them. Notice that GradeBook's constructor throws an
            // IOException, which we declare instead of catch.
        }
    }
}
