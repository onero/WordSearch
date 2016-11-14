/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearch.bll;

import java.io.FileNotFoundException;
import java.util.List;

public class WordManager {

    private WordDAO wordDAO;

    //private final ArrayList<String> linesInFile;
    public WordManager() {
        wordDAO = new WordDAO();
        //linesInFile = FileReader.getAllLinesInFile("/resource/brit-a-z.txt");
    }

    /**
     * Gets word from a list of String words
     *
     * @return
     */
    public List<String> getAllWords() throws FileNotFoundException {
        List<String> allWords = wordDAO.getAllWords();
        return allWords;
    }

}
