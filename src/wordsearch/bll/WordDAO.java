/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearch.bll;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordDAO {

    private static final String DOCUMENT = "D:\\Programmering\\Java\\Netbeans\\WordSearch\\src\\wordsearch\\resource\\brit-a-z.txt";

    /**
     * Gets all the words from a given file
     *
     * @return
     * @throws java.io.FileNotFoundException
     */
    public List<String> getAllWords() throws FileNotFoundException {
        ArrayList<String> allLinesInFile = new ArrayList();
        File inputFile = new File(DOCUMENT);

        try (Scanner sc = new Scanner(inputFile)) {
            while (sc.hasNextLine()) {
                allLinesInFile.add(sc.nextLine());
            }
            sc.close();
        }
        return allLinesInFile;
    }

}
