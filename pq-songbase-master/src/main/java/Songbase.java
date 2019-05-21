public class Songbase {

    private Song[] songs;

    public Songbase(Song[] songs) {
        this.songs = songs;
    }

    public Song findByTitle(String title) {
        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }

    public Song findByArtist(String artist) {
        for (Song song : songs) {
            if (song.getArtist().equals(artist)) {
                return song;
            }
        }
        return null;
    }
}
