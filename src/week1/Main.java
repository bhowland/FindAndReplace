package week1;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by ben on 9/18/2015.
 */

@WebService
public class Main {

    @WebMethod
    public static void main(String[] args) {
        ReadTheDocs newLetter = new ReadTheDocs("findandreplace.txt", "input.txt", "readyToSend.txt");
        newLetter.readInValues();
    }
}
