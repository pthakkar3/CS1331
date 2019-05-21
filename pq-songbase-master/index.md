# Songbase Programming Quiz

[Download Zip](https://github.gatech.edu/cs1331-{semester}/pq-songbase/archive/master.zip)

In this programming quiz you will write a class to represent songs, and a class that implements a simple database for music.

1. Download the zip file of this repository to the directory on your disk where you keep your CS 1331 course work.

2. Unzip the zip archive and navigate to the directory created by unzipping the archive at the command line. You should see a ``build.gradle`` file in this directory. This is the *project root*.

4. Implement the following constructors and methods in ``Song``:

  - a constructor that takes three ``String`` parameters.
    - The first parameter is the title/name of the song and should be stored in an instance variable.
    - The second parameter is the artist who performs the song and should be stored in an instance variable.
    - The third parameter is the album that the song appears on.
  - ``public String toString()`` returns a ``String`` representation of a ``Song`` object in the form ``<title> by <artist> on <album>``. For example, ``new Song("Mr. Roboto", "Styx", "Killroy Was Here").toString()`` would return ``Mr. Roboto by Styx on Killroy Was Here``.
  - ``public String getTitle()`` returns the name of this song.
  - ``public String getArtist()`` returns the artist of this song.
  - ``public String getAlbum()`` returns the album of this song.

5. Implement the following constructors and methods in ``Songbase``:

  - a constructor that takes a single parameter that is an array of ``Song``. The ``Song`` array passed as an argument to the constructor should be stored in an array instance variable.
  - ``public Song findByTitle(String title)`` returns the first ``Song`` instance stored in the array instance variable whose name matches ``title`` and ``null`` if no ``Song`` is found.
  - ``public Song findByArtist(String artist)`` returns the first ``Song`` instance stored in the array instance variable that was performed by the artist ``artist`` and ``null`` if no ``Song`` is found.

Tips:

- First, create your ``Song`` and ``Songbase`` classes and stub out all the required contructors and methods with dummy return values. Then go back and fill in implementations. ("//TODO" comments may help you remember what you need to come back to.)
- Run ``gradle -q test`` to get a report of test failures. This should open in a window like checkstyle. (If it fails before the window is opened with errors on the command line, this means that the tests themselves did not compile. Read the error meesages carefully and make sure your methods and constructors are named and formatted correctly!)
  - If the report does *not* say "100% successful", then click through each failure and pay close attention to the **first** line of the error - this will tell you what is wrong.
- As you add functionality, rerun the previous step and re-submit if your grade is improved.
- Look at the test code in ``src/test/java`` to see how your class is used.


## Submission

You will need to have [gradle version 2.10+](http://gradle.org/gradle-download/) installed to submit your homework. Once you have it installed, submit your assignment by running from the root of your homework directory:

        gradle -q submit

Remember to check that your files were submitted successfully! They will be located in a repository on your github.gatech.edu account with the name {hw-name} after you have submitted them. You can submit as many times as you want, we will take your last submission prior to the time the assignment is due.

## Files to submit

        src/main/java/Song.java
        src/main/java/Songbase.java

### Submissions that do not compile will recieve a zero!
This means the entire submission. Make sure every Java file that is submitted compiles successfully!
