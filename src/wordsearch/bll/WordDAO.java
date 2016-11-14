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

    /**
     * Gets all the words from a given file
     *
     * @return
     * @throws java.io.FileNotFoundException
     */
    public List<String> getAllWords() throws FileNotFoundException {
        ArrayList<String> allLinesInFile = new ArrayList();
        File inputFile = new File("brit-a-z.txt");
        try (Scanner wordScanner = new Scanner(inputFile)) {
            while (wordScanner.hasNext()) {
                allLinesInFile.add(wordScanner.next());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Cannot find file" + inputFile);
        }
        return allLinesInFile;
    }

}
