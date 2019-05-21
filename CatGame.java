import java.util.Scanner;

public class CatGame{
    public static void main(String[] args) {
        System.out.println("How many meows?");
        Scanner inputScanner = new Scanner(System.in);
        String input = inputScanner.nextInt();
        int meowGoal = Integer.parseint(input);
        System.out.println("meowGoal:" + meowGoal);
        String[] winningLines = new String[meowGoal];
        int meowCount = 0;
        while (meowCount < meowGoal) {
            System.out.println("Your line:");
            String line = inputScanner.nextLine();
            if (line.contains('meow')) {
                meowCount++;
            }
            System.out.println("line:" + line);
            System.out.println("meowCount:" + meowCount);
        }
    }
}
