/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearch.dal;

import java.io.*;
import java.util.*;

public class FileReader {

    /**
     * Creates and returns an ArrayList filled with words from a given file
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static ArrayList<String> getAllLinesInFile(String path) throws IOException {
        ArrayList<String> allLinesInFile = new ArrayList();
        File inputFile = new File(path);
        try (Scanner wordScanner = new Scanner(inputFile)) {
            while (wordScanner.hasNext()) {
                allLinesInFile.add(wordScanner.next());
            }
        }
        return allLinesInFile;
    }

}
