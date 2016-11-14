/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearch.bll;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import wordsearch.dal.WordDAO;

public class WordManager {

    private final WordDAO wordDAO;

    private List<String> allWords;

    public WordManager() {
        wordDAO = new WordDAO();
    }

    /**
     * Gets word from a list of String words
     *
     * @return
     * @throws java.io.FileNotFoundException
     */
    public List<String> getAllWords() throws FileNotFoundException {
        allWords = wordDAO.getAllWords();
        return allWords;
    }

    /**
     * Get search words
     *
     * @param searchWord
     * @return
     */
    public ArrayList<String> getAllSearchWords(String searchWord) {
        ArrayList<String> searchWords = new ArrayList();
        for (String word : allWords) {
            if (word.contains(searchWord)) {
                searchWords.add(word);
            }
        }
        return searchWords;
    }

    /**
     * Get words that begin with the query
     *
     * @param searchWord
     * @return
     */
    public ArrayList<String> getWordsBeginWith(String searchWord) {
        ArrayList<String> wordsBeginWith = new ArrayList();
        for (String word : allWords) {
            if (word.startsWith(searchWord)) {
                wordsBeginWith.add(word);
            }
        }
        return wordsBeginWith;
    }

    /**
     * Gets words that contain the query
     *
     * @param searchWord
     * @return
     */
    public ArrayList<String> getWordsContain(String searchWord) {
        ArrayList<String> wordsContain = new ArrayList();
        for (String word : allWords) {
            if (word.contains(searchWord)) {
                wordsContain.add(word);
            }
        }
        return wordsContain;
    }

    /**
     *
     * @param searchWord
     * @return
     */
    public ArrayList<String> getWordsEndWith(String searchWord) {
        ArrayList<String> wordsEndsWith = new ArrayList();
        for (String word : allWords) {
            if (word.endsWith(searchWord)) {
                wordsEndsWith.add(word);
            }
        }
        return wordsEndsWith;
    }

    public ArrayList<String> getWordsExact(String searchWord) {
        ArrayList<String> wordsExact = new ArrayList();
        for (String word : allWords) {
            if (word.equals(searchWord)) {
                wordsExact.add(word);
            }
        }
        return wordsExact;
    }
}
