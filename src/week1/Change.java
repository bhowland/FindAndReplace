package week1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ben on 9/18/2015.
 */
public class Change {

    public String line = null;
    public BufferedReader br;
    public List<String> wholeFile = new ArrayList<>();
    public Map<String, String> wholeContact;
    public String fileToBeChanged;
    public String finalOutPutFile;

    public Change(Map<String, String> wholeContact, String fileToBeChanged, String finalOutPutFile){
        this.wholeContact = wholeContact;
        this.fileToBeChanged = fileToBeChanged;
        this.finalOutPutFile = finalOutPutFile;

    }

    public void changeTheDefaultToValues() {
        Reprint reprint = new Reprint(wholeFile, finalOutPutFile);
        try {
            br = new BufferedReader(new FileReader(fileToBeChanged));

            while ((line = br.readLine()) != null) {
                for (Map.Entry<String, String> entry : wholeContact.entrySet()) {
                    line = line.replaceAll(entry.getKey(), entry.getValue());
                }
                wholeFile.add(line);
                reprint.finalPrintFile();
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
