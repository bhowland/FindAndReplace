import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import week1.Change;
import week1.ReadTheDocs;
import week1.Reprint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ben on 9/20/2015.
 */
public class TestReprint {

    @Rule
    public TemporaryFolder fileRead =new TemporaryFolder();
    ReadTheDocs fileHold = new ReadTheDocs("testFiles\\findandreplace.txt", "testFiles\\input.txt", "testFiles\\readyToSend.txt");

    @Test
    public void testReadTwoFiles(){
        Reprint twoFile = new Reprint(null, null);
        assertNotNull(twoFile);
    }
}
