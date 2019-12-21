import pkprinci.SoapGenerator;

import java.util.ArrayList;
import java.util.List;

public class SoapGame {

    public static void main(String[] args) {
        int maxF = 9;
        int maxC = 12;

        List<String> initialWords = new ArrayList<>();
        initialWords.add("Pepe");
        initialWords.add("Joan");
        initialWords.add("Xema");
        initialWords.add("Oscar");


        SoapGenerator soapGenerator = new SoapGenerator(maxC, maxF);
        soapGenerator.insertInitialWords(initialWords);
        soapGenerator.printBooard();



    }
}
