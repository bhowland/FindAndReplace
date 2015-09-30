import org.junit.*;

import org.junit.rules.TemporaryFolder;
import week1.Change;
import week1.ReadTheDocs;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by ben on 9/20/2015.
 */
public class TestChange {

    @Rule
    public TemporaryFolder fileRead =new TemporaryFolder();
    ReadTheDocs fileHold = new ReadTheDocs("testFiles\\findandreplace.txt", "testFiles\\input.txt", "testFiles\\readyToSend.txt");

    @Test
    public void testReadThreeFiles(){
        Change threeFile = new Change(null, null, null);
        assertNotNull(threeFile);
    }

    @Test
    public void testCorrectMapping(){

        Change sizeOfMap = new Change(fileHold.wholeContact, "testFiles\\input.txt", "testFiles\\readyToSend.txt");
        String testMessage = "Map should be size of 12.";
        sizeOfMap.changeTheDefaultToValues();
        assertTrue(testMessage, sizeOfMap.wholeFile.size() == 12);

    }
}
