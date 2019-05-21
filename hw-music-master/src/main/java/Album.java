public class Album {
    private String title;
    private String artist;
    private Song[] songs;
    private int numSongs;

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        songs = new Song[3];
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public Song[] getSongs() {
        return songs;
    }

    public int getNumSongs() {
        return numSongs;
    }

    public void addSong(Song s) {
        if (numSongs < songs.length) {
            songs[numSongs] = s;
            numSongs++;
        } else {
            Song[] temp = new Song[songs.length * 2];
            for (int i = 0; i < songs.length; i++) {
                temp[i] = songs[i];
            }
            songs = temp;
            songs[numSongs] = s;
            numSongs++;
        }
    }

    public String toString() {
        return title + " - " + artist;
    }
}
