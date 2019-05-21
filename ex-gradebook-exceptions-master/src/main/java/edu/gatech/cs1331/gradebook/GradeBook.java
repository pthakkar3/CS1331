package edu.gatech.cs1331.gradebook;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;

public class GradeBook {

    private Integer[] hwGrades;
    private Integer[] examGrades;
    private Integer[] pqGrades;
    private int finalExamGrade;

    public GradeBook(String gradesFile) throws FileNotFoundException,
                                               IOException,
                                               ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(gradesFile));
        String line = reader.readLine();
        int lineNum = 1;
        while (line != null) {
            String category = line.split(":")[0];
            String gradesClause = line.split(":")[1];
            if (category.equalsIgnoreCase("HWs")) {
                hwGrades = extractGrades(gradesClause, lineNum);
            } else if (category.equalsIgnoreCase("Exams")) {
                examGrades = extractGrades(gradesClause, lineNum);
            } else if (category.equalsIgnoreCase("PQs")) {
                pqGrades = extractGrades(gradesClause, lineNum);
            } else if (category.equalsIgnoreCase("Final Exam")) {
                finalExamGrade = extractFinalExamGrade(gradesClause, lineNum);
            } else {
                // If we get here we read a category we don't recognize.
                String msg = "Unrecognized category: " + category
                    + " on line " + lineNum;
                // We've discovered a problem, so we create an
                // exception, our "message in a bottle" and throw it
                // to whomever called us.
                throw new ParseException(msg, lineNum);
                // Look up the API docs for ParseException. Can we
                // pass only a message to the constructor?
            }
            line = reader.readLine();
            lineNum++;
        }
    }

    private Integer[] extractGrades(String gradesClause, int lineNum)
            throws ParseException {
        String[] gradeStrings = gradesClause.split(",");
        Integer[] grades = new Integer[gradeStrings.length];
        for (int i = 0; i < gradeStrings.length; ++i) {
            try {
                grades[i] = Integer.parseInt(gradeStrings[i].trim());
            } catch (NumberFormatException e) {
                // We catch an unchecked exception so we can "rethrow" a
                // more informative checked excaption.
                String msg =
                    String.format("Score %d (%s) not an integer on line %d",
                                  i, gradeStrings[i], lineNum);
                throw new ParseException(msg, lineNum);
            }
        }
        return grades;
    }

    private int extractFinalExamGrade(String gradesClause, int lineNum)
            throws ParseException {
        if (gradesClause.trim().isEmpty()) {
            throw new ParseException("Final exam field is empty", lineNum);
        }
        try {
            // What if we don't trim()?
            return Integer.parseInt(gradesClause.trim());
        } catch (NumberFormatException e) {
            // We catch an unchecked exception so we can "rethrow" a
            // more informative checked excaption.
            String msg =
                String.format("Final exam score %s on lin %d is not an integer.",
                              gradesClause, lineNum);
            throw new ParseException(msg, lineNum);
        }
    }

    public double courseAverage() {
        return 0.2 * average(hwGrades)
            + 0.45 * average(examGrades)
            + 0.15 * average(pqGrades)
            + 0.2 * finalExamGrade;
    }

    private double average(Integer[] nums) {
        return Arrays.asList(nums).stream().reduce(0, Integer::sum) / nums.length;
    }
}
