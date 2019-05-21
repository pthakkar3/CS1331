import static org.junit.Assert.*;
import org.junit.Test;

public class SongbaseTest {

    Song ramblinMan = new Song("Ramblin' Man", "The Allman Brothers Band", "The Road Goes On Forever");
    Song iFoughtTheLaw = new Song("I Fought the Law", "The Clash", "The Cost of Living");
    Song underPressure = new Song("Under Pressure", "Queen (with David Bowie)", "Hot Space");
    Song searchAndDestroy = new Song("Search And Destroy", "The Stooges", "Raw Power");

    Song[] songs = {ramblinMan, iFoughtTheLaw, underPressure, searchAndDestroy};
    Songbase pbase = new Songbase(songs);

    @Test
    public void constructorTest() {
        try {
            Song[] songs = {ramblinMan, iFoughtTheLaw, underPressure, searchAndDestroy};
            Songbase pb = new Songbase(songs);
        } catch (Throwable t) {
            fail("-10 Constructor threw exception for valid input:");
        }
    }

    @Test
    public void toStringTest() {
        assertEquals("-10 toString() returns incorrect value:",
                     "Ramblin' Man by The Allman Brothers Band on The Road Goes On Forever", ramblinMan.toString());
    }

    @Test
    public void findByTitleTest() {
        assertEquals("-10 findByTitle(\"Under Pressure\") returns incorrect value:",
                     underPressure, pbase.findByTitle("Under Pressure"));
    }

    @Test
    public void findByArtist() {
        assertEquals("-10 findByArtist(\"The Clash\") returns incorrect value:",
                     iFoughtTheLaw, pbase.findByArtist("The Clash"));
    }
}
