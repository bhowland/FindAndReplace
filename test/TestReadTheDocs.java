
import org.junit.*;

import org.junit.rules.ExternalResource;
import org.junit.rules.TemporaryFolder;
import week1.ReadTheDocs;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

/**
 * Created by ben on 9/20/2015.
 */
public class TestReadTheDocs {


    @Rule
    public TemporaryFolder fileRead =new TemporaryFolder();



    @Test
    public void testReadThreeFiles(){
        ReadTheDocs threeFile = new ReadTheDocs(null, null, null);
        assertNotNull(threeFile);
    }

    @Test
    public void testCorrectMapping(){

        ReadTheDocs sizeOfMap = new ReadTheDocs("findandreplace.txt", "input.txt", "readyToSend.txt");
        String testMessage = "Map should be size of 4.";
        sizeOfMap.readInValues();
        assertTrue(testMessage, sizeOfMap.wholeContact.size() == 4);

    }

     @Test
     public void testCorrectValues() {
         ReadTheDocs valueOfMap = new ReadTheDocs("findandreplace.txt", "input.txt", "readyToSend.txt");
         valueOfMap.readInValues();
         assertEquals("Great Lakes", valueOfMap.wholeContact.get("<<COMPANY_NAME>>"));
     }

    @Test(expected = FileNotFoundException.class)
    public void testForFileNotFound() {
        String csvFileToRun = "null.txt";
        String fileToBeChanged = "input.txt";
        String finalOutPutFile = "readyToSend.txt";
        ReadTheDocs noFile = new ReadTheDocs(csvFileToRun, fileToBeChanged, finalOutPutFile);
        //noFile.readInValues();
        fail("Expected a FileNotFoundException");
    }

}
