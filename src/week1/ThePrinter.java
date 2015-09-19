package week1;

import java.io.*;
import java.util.*;


/**
 * Created by ben on 9/10/2015.
 */
public class ThePrinter {

    protected String companyName;
    protected String insertCompany;
    protected String userName;
    protected String insertUser;
    protected String userID;
    protected String insertID;
    protected String userOldWorldName;
    protected String insertOldWorldName;
    //Map<String,String> companyTokens = new HashMap<String,String>();
    String input = "input.txt";
    String line = null;
    BufferedReader br;
    PrintWriter printWriter = null;
    protected List<String> wholeFile = new ArrayList<>();

    public void printer(List<String[]> wholeContact) {

        companyName = wholeContact.get(0)[0];
        insertCompany = wholeContact.get(0)[1];
        userName = wholeContact.get(0)[2];
        insertUser = wholeContact.get(0)[3];
        userID = wholeContact.get(1)[0];
        insertID = wholeContact.get(1)[1];
        userOldWorldName = wholeContact.get(1)[2];
        insertOldWorldName = wholeContact.get(1)[3];

        //companyTokens.put(companyName, insertCompany);
        //companyTokens.put(userName, insertUser);
        //companyTokens.put(userID, insertID);
        //companyTokens.put(userOldWorldName, insertOldWorldName);

        try {
            br = new BufferedReader(new FileReader(input));

            while ((line = br.readLine()) != null) {

                line = line.replaceAll(companyName, insertCompany);
                line = line.replaceAll(userName, insertUser);
                line = line.replaceAll(userID, insertID);
                line = line.replaceAll(userOldWorldName, insertOldWorldName);

                wholeFile.add(line);
                finalPrintFile(wholeFile);
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

    public void finalPrintFile(List<String> line) {

        try {

            FileWriter writer2 = new FileWriter("new.txt");
            BufferedWriter writer3 = new BufferedWriter(writer2);
            printWriter = new PrintWriter(writer3);

            for (String singleLine : line) {
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