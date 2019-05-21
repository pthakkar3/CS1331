import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;
import java.lang.String;
public class Recitation2 {
  public static void main(String[] args) throws Throwable
  {
    Scanner filescanner = new Scanner(System.in);
    System.out.println("Enter your file name:");
    String filename = filescanner.nextLine();
    Scanner origfile = new Scanner(new File(filename+".txt"));
    PrintStream newfile = new PrintStream(new File(filename + "-uppercase.txt"));
    while (origfile.hasNext())
    {
      String line = origfile.nextLine();
      String newline = line;
      newline.toUpperCase();
      newfile.println(newline);
    }
    newfile.flush();
    newfile.close();
  }
}
