package week1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 * Created by ben on 9/18/2015.
 */
public class ReadTheDocs {

    public Map<String, String> wholeContact = new HashMap<>();
    public String csvFileToRun;
    protected String fileToBeChanged;
    protected String finalOutPutFile;
    private final Logger logger = Logger.getLogger(ReadTheDocs.class);

    public ReadTheDocs(String csvFileToRun, String fileToBeChanged, String finalOutPutFile) {
        logger.info("here in the constructor");
        this.csvFileToRun = csvFileToRun;
        this.fileToBeChanged = fileToBeChanged;
        this.finalOutPutFile = finalOutPutFile;
    }

    public void readInValues() {

        BufferedReader br = null;
        String line = "";
        String splitIcon = ",";
        String deepSplitIcon = ":";

        try {

            br = new BufferedReader(new FileReader(csvFileToRun));

            while ((line = br.readLine()) != null) {
                String splitOne[] = line.split(splitIcon);

                for (int i = 0; i < splitOne.length; i++) {
                    String keyValue[] = splitOne[i].split(deepSplitIcon);
                    wholeContact.put(keyValue[0], keyValue[1]);
                }//end for
            }//end while

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }  catch (IOException e){
            e.printStackTrace();
        }finally {
            if (br != null){
                try{
                    br.close();
                }catch (IOException e){
                    logger.error("captin oh captin", e);
                    e.printStackTrace();
                }
            }
        }
        Change printOutLetter = new Change(wholeContact,fileToBeChanged, finalOutPutFile);
        printOutLetter.changeTheDefaultToValues();
    }//end readInValues
}
