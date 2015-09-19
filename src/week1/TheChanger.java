/**
 * Created by ben on 9/10/2015.
 */
package week1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TheChanger {

    protected String companyName;
    protected String insertCompany;
    protected String userName;
    protected String insertUser;
    protected String userID;
    protected String insertID;
    protected String userOldWorldName;
    protected String insertOldWorldName;
    protected String[] lineSegment;
    protected List<String[]> wholeContact = new ArrayList<>();

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getInsertCompany() {
        return insertCompany;
    }

    public void setInsertCompany(String insertCompany) {
        this.insertCompany = insertCompany;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getInsertUser() {
        return insertUser;
    }

    public void setInsertUser(String insertUser) {
        this.insertUser = insertUser;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getInsertID() {
        return insertID;
    }

    public void setInsertID(String insertID) {
        this.insertID = insertID;
    }

    public String getUserOldWorldName() {
        return userOldWorldName;
    }

    public void setUserOldWorldName(String userOldWorldName) {
        this.userOldWorldName = userOldWorldName;
    }

    public String getInsertOldWorldName() {
        return insertOldWorldName;
    }

    public void setInsertOldWorldName(String insertOldWorldName) {
        this.insertOldWorldName = insertOldWorldName;
    }

    public void run() {

        String csvFileToRun = "findandreplace.txt";
        BufferedReader br = null;
        String line = "";
        String splitIcon = "[,:]";

        try {
            br = new BufferedReader(new FileReader(csvFileToRun));

            while ((line = br.readLine()) != null) {

                lineSegment = line.split(splitIcon);
                wholeContact.add(lineSegment);

            }//end while

            companyName = wholeContact.get(0)[0];
            insertCompany = wholeContact.get(0)[1];
            userName = wholeContact.get(0)[2];
            insertUser = wholeContact.get(0)[3];
            userID = wholeContact.get(1)[0];
            insertID = wholeContact.get(1)[1];
            userOldWorldName = wholeContact.get(1)[2];
            insertOldWorldName = wholeContact.get(1)[3];

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

    ThePrinter printOutLetter = new ThePrinter();
    printOutLetter.printer(wholeContact);
    }//end run
}
