---
title: Welcome Homework & Setup
---
[Download Zip](https://github.gatech.edu/cs1331-spring2016/hw0/archive/master.zip) 

## Intro
This assignment gets you started with the basic tools you will need to complete all of your homework projects.  This project will:

- Ensure that you have correctly installed the JDK (Java Development Kit)
- Give you practice using a text editor to write Java programs
- Give you practice compiling and running Java programs
- Give you practice identifying and locating an error
- Show you a bit of command line fun

## Problem Description
You are a CS 1331 student who needs to install the JDK, configure it for command line use, and learn how to use a programmer's text editor to create and edit Java source code.


## Solution Description
###Setting Up Your Computer
1. Download and install the JDK on your computer using [our installation instructions](http://cs1331.org/install-java.html) or [Oracle's installation instructions](http://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
2. Download and install a programmer's text editor.  You may end up trying out several over the course of the semester before you settle on one.  See our [guide to text editors](http://cs1331.org/text-editors.html).
3. Create a directory for your CS 1331 coursework somewhere on your hard disk; we suggest `cs1331`. 
  * You can do this on the command line by navigating to the directory you want to contain is the cs1331 folder (using the `cd` command). 
  * To create the folder use the command `mkdir cs1331`. 
  * Enter the new folder by using the command `cd cs1331`. 
  * Note: avoid putting spaces in file and directory names, since doing so complicates the use of some command line tools.
4. Move the zip file you downloaded earlier (named `hw0-master.zip`) to the cs1331 folder. 
  * If on Mac or Linux, you can do this on the command line by running the following command from within the cs1331 folder: `mv "path/to/hw0-master.zip" .` where "path/to/hw0-master.zip" is the path to the zip file which may look something like "~/Downloads/hw0-master.zip". 
  * If on Windows, use the command `move "C:\path\to\hw0-master.zip" .` where "C:\path\to\hw0-master.zip" is the full path to the zip file which may look something like "C:\Users\Keith\Downloads\hw0-master.zip".
5. If the JDK is installed correctly, the following command will unzip the file you just moved for you: `jar xf hw0-master.zip`.
  * Remember, you are running this command from within the cs1331 folder which now contains the hw0-master.zip file. 
  * **If this does not work, check that you completed step one (1) correctly.**
6. You now have a folder named "hw0-master". Move into this folder by running the command `cd hw0-master`.
7.  On the command line, make sure you are in the hw0-master folder. Enter these commands:

        $ javac -version 2> hw0-output.txt
        $ java -version 2>> hw0-output.txt

Please note what is happening here: 
`>` redirects the standard output of a program.  `2>` redirects `stderr`, which is used for diagnostics (such as version strings).  The first line creates the `hw0-output.txt` file, and the second line (with the extra `>`) adds more text to the file. Here is a [nice discussion](http://www.jstorimer.com/blogs/workingwithcode/7766119-when-to-use-stderr-instead-of-stdout) of the file descriptors `stdin`, `stdout` and `stderr`.

What this means is that `>` (or `2>`) will overwrite the file, so if you go back to repeat the first step, you'll need to repeat all the other steps as well.

###Your First Java Program
1. Open your text editor and create a file in your newly created `hw0-master` directory named `NimblyBimbly.java` and enter the following Java program:

        public class NimblyBimbly {
            public static void main(String[] args) {
                for (int i = 0; i < 9; i++) {
                    System.out.print("\u004D\u0065\u006F\u0077 ");
                }
                System.out.println("...");
                System.out.println("\u004D\u0065\u006F\u0077\u0021");
            }
        }

2. On the command line, go to the directory containing your newly created `NimblyBimbly.java` file and enter `javac NimblyBimbly.java`. Do a directory listing using the command `ls` on Mac and Linux or `dir` on Windows; you should see a file called `NimblyBimbly.class` that contains the compiled bytecode of your `NimblyBimbly` program.  These commands should look like this:

        Mac / Linux:

        $ javac NimblyBimbly.java
        $ ls
        NimblyBimbly.class NimblyBimbly.java hw0-output.txt build.gradle index.md ...

        Windows:

        C:\...\cs1331\hw0-master> javac NimblyBimbly.java
        C:\...\cs1331\hw0-master> dir
        NimblyBimbly.class NimblyBimbly.java hw0-output.txt build.gradle index.md ...

3. Now enter `java NimblyBimbly` to run the program and see its output on the command line.
4. Add the output of your program to `hw0-output.txt` by running

          java NimblyBimbly >> hw0-output.txt

###Oh no. An Error
1. We have provided a file (`Schools.java`) for you that contains some sort of error.
2. Attempt to compile and run `Schools.java` (using `javac` and `java`).
3. At some point during this process you will encounter an error. Read this error carefully and determine where in `Schools.java` the error originated. That is, identify which line caused the error. It's alright if you don't understand what the error means or how to fix it, but do your best to reason through it and think about it. You will encounter lots of errors as you work through homework for this class, so it's important that you learn early how to decipher the error messages.
4. Finally, report your findings. Open up the `hw0-output.txt` file from before in your text editor. At the bottom, add two lines.
    1. The first line should say when the error occurred - that is, during compilation or during running.
    2.  On the second line, first put the number of the line causing the error. Then, copy the line itself.

For example, if you compiled the program successfully, the error happened when you ran it, and line 2 caused
the error, you would add

        runtime
        2. public static void main(String[] args) {

to the file.

## Submission

You will need to have [gradle version 2.10](http://gradle.org/gradle-download/) installed to submit your homework. You can test if it is installed and working by running the command `gradle -version`. Once you have it installed, submit your assignment by running from the root of your homework directory:

        gradle -q submit

**Note: This command may take a few seconds to run! Just be patient!**
**Also, when you type in your password, no characters will appear. This is okay and is working as designed. Just type your password and hit enter. If you typed your password correctly, it will work.**

### Remember to check that your files were sucessfully submitted! This is your responsibility!
