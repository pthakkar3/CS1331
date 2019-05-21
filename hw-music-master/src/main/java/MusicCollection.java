import java.util.Scanner;

public class MusicCollection {

    private static Scanner keyboard;
    private static String input;
    private static String songInput;
    private static int checker;

    public static void main(String[] args) {
        keyboard = new Scanner(System.in);
        Album a0 = new Album("The 20-20 Experience", "Justin Timberlake");
        Album a1 = new Album("American Idiot", "Green Day");
        Album a2 = new Album("Born Sinner", "J.Cole");
        Song mirrors = new Song("Mirrors", "Justin Timberlake", "Pop");
        Song night = new Song("Take Back The Night", "Justin Timberlake",
            "Pop");
        Song vision = new Song("Tunnel Vision", "Justin Timberlake", "Pop");
        Song blvd = new Song("Boulevard of Broken Dreams", "Green Day");
        Song born = new Song("Born Sinner", "J.Cole", "Rap");
        a0.addSong(mirrors);
        a0.addSong(night);
        a0.addSong(vision);
        a1.addSong(blvd);
        a2.addSong(born);
        Album[] albums = {a0, a1, a2};
        while (checker != -1) {
            for (int i = 0; i < albums.length; i++) {
                System.out.println("[" + i + "]" + albums[i].toString());
            }
            input = keyboard.nextLine();
            checker = Integer.parseInt(input);
            if (checker != -1) {
                albumOptions(albums[checker]);
            }
        }
    }

    public static void albumOptions(Album albumName) {
        System.out.println(albumName.toString());
        Song[] songs = albumName.getSongs();
        for (int i = 0; i < albumName.getNumSongs(); i++) {
            System.out.println("\t" + songs[i].toString());
        }
        System.out.println("[0] Add Song");
        System.out.println("[1] Go Back");
        input = keyboard.nextLine();
        checker = Integer.parseInt(input);
        if (checker == 0) {
            System.out.println("\t" + "Enter title, artist[, genre]");
            songInput = keyboard.nextLine();
            String[] songParts = songInput.split(",");
            if (songParts.length == 3) {
                Song userAdded = new Song(songParts[0], songParts[1],
                    songParts[2]);
                albumName.addSong(userAdded);
            } else {
                Song userAdded = new Song(songParts[0], songParts[1]);
                albumName.addSong(userAdded);
            }
        }
    }

}
