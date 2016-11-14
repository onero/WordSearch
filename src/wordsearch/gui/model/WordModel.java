/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearch.gui.model;

import java.io.FileNotFoundException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import wordsearch.bll.SortCommand;
import wordsearch.bll.WordManager;

public class WordModel {

    private final WordManager wordManager;
    private final ObservableList<String> items;

    public WordModel() {
        wordManager = new WordManager();
        items = FXCollections.observableArrayList();
    }

    /**
     * Get the words from the ObservableList
     *
     * @return
     */
    public ObservableList<String> getWords() {
        return items;
    }

    /**
     * Gets all words from the manager
     *
     * @throws FileNotFoundException
     */
    public void reset() throws FileNotFoundException {
        items.clear();
        items.addAll(wordManager.getAllWords());
    }

    /**
     * Gets all search words from the word manager
     *
     * @param searchWord
     * @param command
     * @param caseSensitive
     */
    public void updateSearchWords(String searchWord, SortCommand command, boolean caseSensitive) {
        String word = searchWord.trim().toLowerCase();
        if (caseSensitive) {
            word = searchWord.trim();
        }
        items.clear();
        switch (command) {
            case BEGINS_WITH:
                items.addAll(wordManager.getWordsBeginWith(word));
                break;
            case CONTAINS:
                items.addAll(wordManager.getWordsContain(word));
                break;
            case ENDS_WITH:
                items.addAll(wordManager.getWordsEndWith(word));
                break;
            case EXACT:
                items.addAll(wordManager.getWordsExact(word));
                break;
            default:
                System.out.println("How did this happen!?");
                break;
        }
        checkForEmptyList();
    }

    /**
     * Check if ObservableList has items in it
     *
     */
    public void checkForEmptyList() {
        if (items.isEmpty()) {
            items.add("No result");
        }
    }

    /**
     * Define max results
     *
     * @param amount
     */
    public void updateMaxResults(int amount) {
        items.remove(amount, items.size());
    }

}
