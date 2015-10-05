package week1;

import java.io.*;
import java.util.List;

/**
 * Created by ben on 9/19/2015.
 */
public class Reprint {

    List<String> printOut;
    String finalOutPutFile;

    public Reprint(List<String> printOut, String finalOutPutFile){
        this.printOut = printOut;
        this.finalOutPutFile = finalOutPutFile;


    }

    public void finalPrintFile() {

        PrintWriter printWriter = null;

        try {
            FileWriter writer2 = new FileWriter(finalOutPutFile);
            BufferedWriter writer3 = new BufferedWriter(writer2);
            printWriter = new PrintWriter(writer3);

            for (String singleLine : printOut) {
                printWriter.println(singleLine);//prints last line
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                try {
                    printWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }//if
        }///fin
    }
}
