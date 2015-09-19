package week1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by ben on 9/18/2015.
 */
public class ReadTheDocs {

    protected Map<String, String> wholeContact = new HashMap<>();

    public void readInValues(String csvFileToRun, String fileToBeChanged, String finalOutPutFile) {

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
                    e.printStackTrace();
                }
            }
        }

        Change printOutLetter = new Change();
        printOutLetter.changeTheDefaultToValues(wholeContact,fileToBeChanged, finalOutPutFile);
    }//end readInValues
}