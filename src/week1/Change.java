package week1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ben on 9/18/2015.
 */
public class Change {

    String line = null;
    BufferedReader br;
    protected List<String> wholeFile = new ArrayList<>();

    public void changeTheDefaultToValues(Map<String, String> wholeContact, String fileToBeChanged, String finalOutPutFile) {
        Reprint reprint = new Reprint();
        try {
            br = new BufferedReader(new FileReader(fileToBeChanged));

            while ((line = br.readLine()) != null) {
                for (Map.Entry<String, String> entry : wholeContact.entrySet()) {
                    line = line.replaceAll(entry.getKey(), entry.getValue());
                }
                wholeFile.add(line);
                reprint.finalPrintFile(wholeFile, finalOutPutFile);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
