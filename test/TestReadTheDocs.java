
import org.junit.*;
import static org.junit.Assert.assertTrue;
import week1.ReadTheDocs;

/**
 * Created by ben on 9/20/2015.
 */
public class TestReadTheDocs {


    @Test
    public void testReadThreeFiles(){
        ReadTheDocs threeFile = new ReadTheDocs();
        String testMessage = "Should be reading in three values";
    }

    @Test
    public void testCorrectMapping(){

        ReadTheDocs sizeOfMap = new ReadTheDocs();
        String testMessage = "Map should be size of 4.";
        assertTrue(testMessage, sizeOfMap.wholeContact.size() == 4);

    }
}
