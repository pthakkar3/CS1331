import static org.junit.Assert.*;
import org.junit.Test;

public class SongTest {
    @Test
    public void constructorTest() {
        try {
            Song a = new Song("Mr. Roboto", "Styx", "Killroy Was Here");
        } catch (Throwable t) {
            fail("-10 Constructor threw exception for valid input:");
        }
    }

    @Test
    public void gettersTest() {
        String expectedTitle = "Mr. Roboto";
        String expectedArtist = "Styx";
        String expectedAlbum = "Killroy Was Here";
        Song p = new Song(expectedTitle, expectedArtist, expectedAlbum);
        assertEquals("-10 getTitle() returns incorrect value:",
                     expectedTitle, p.getTitle());
        assertEquals("-10 getArtist() returns incorrect value",
                     expectedArtist, p.getArtist());
        assertEquals("-10 getAlbum() returns incorrect value",
                     expectedAlbum, p.getAlbum());
    }
}
