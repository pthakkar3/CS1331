public class Song {

    private String title;
    private String artist;
    private String album;

    public Song(String title, String artist, String album) {
        this.title = title;
        this.artist = artist;
        this.album = album;
    }

    public String toString() {
        return String.format("%s by %s on %s", title, artist, album);
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }
}
