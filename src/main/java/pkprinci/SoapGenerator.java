package pkprinci;

import java.util.List;
import java.util.Random;

public class SoapGenerator {

    private char[][] soapBoard;
    private boolean[][] soapBoardInUse;

    public SoapGenerator(int a, int b) {
        soapBoard = new char[a][b];
        soapBoardInUse = new boolean[a][b];
        int i;
        int j;
        for (i = 0; i < a; i++) {
            for (j = 0; j < b; j++) {
                soapBoard[i][j] = getRandom();
                soapBoardInUse[i][j] = false;
            }
        }
    }

    private void addWord(int x, int y, String word) {
        for (int wi = 0; wi < word.length(); wi++) {
            soapBoard[x][y] = word.charAt(wi);
            soapBoardInUse[x][y] = true;
            x++;
        }
    }

    private boolean wordIsValid(int x, int y, String word) {
        boolean respones = true;

        if (word.length() + x > soapBoard.length)
            return false;

        for (int wi = 0; wi < word.length(); wi++) {
            respones = respones && !soapBoardInUse[x][y];
            x++;
        }

        return respones;
    }

    public void printBooard() {
        for (int i = 0; i < soapBoard.length; i++) {
            for (int j = 0; j < soapBoard[i].length; j++) {
                System.out.print(soapBoard[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    private char getRandom() {
        Random random = new Random();
        char randomCharacter = (char) (random.nextInt(26) + 'a');
        return randomCharacter;
    }


    public void insertInitialWords(List<String> initialWords) {
        for (String word : initialWords) {
            insertWord(word);
        }
    }

    private void insertWord(String word) {
        for (int i = 0; i < soapBoard.length; i++) {
            for (int j = 0; j < soapBoard[i].length; j++) {
                if (wordIsValid(i, j, word)) {
                    addWord(i, j, word);
                    return;
                }
            }
        }
    }
}
