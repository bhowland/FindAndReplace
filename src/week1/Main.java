package week1;

/**
 * Created by ben on 9/18/2015.
 */
public class Main {
    public static void main(String[] args) {
        ReadTheDocs newLetter = new ReadTheDocs("findandreplace.txt", "input.txt", "readyToSend.txt");
        newLetter.readInValues();
    }
}
