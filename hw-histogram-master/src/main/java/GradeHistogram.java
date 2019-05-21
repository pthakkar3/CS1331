import java.util.Scanner;
import java.io.File;
public class GradeHistogram {
    public static void main(String[] args) throws Exception {
        Scanner gradeFile = new Scanner(new File(args[0]));
        int[] grades = new int[101];
        int intervalsize = 0;
        if (args.length < 2) {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("What interval size would you like?");
            intervalsize = keyboard.nextInt();
        } else {
            intervalsize = Integer.parseInt(args[1]);
        }
        while (gradeFile.hasNext()) {
            String line = gradeFile.nextLine();
            int comma = line.indexOf(",");
            String gradeStr = line.substring(comma + 1, line.length()).trim();
            int grade = Integer.parseInt(gradeStr);
            grades[grade]++;
        }
        int k = 100;
        for (int i = 100; i >= 0; i--) {
            if (i == k) {
                System.out.println();
                k = i - intervalsize;
                if (k < 0) {
                    k = -1;
                }
                if (k < 9) {
                    System.out.printf("%d - %d \t\t|", i, (k + 1));
                } else {
                    System.out.printf("%d - %d \t|", i, (k + 1));
                }
            }
            for (int j = 0; j < grades[i]; j++) {
                System.out.print("[]");
            }
        }
    }
}
