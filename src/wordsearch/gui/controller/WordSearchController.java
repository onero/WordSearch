/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearch.gui.controller;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import wordsearch.bll.SortCommand;
import wordsearch.gui.model.WordModel;

/**
 * FXML Controller class
 *
 * @author gta1
 */
public class WordSearchController implements Initializable {

    @FXML
    private TextField txtSearch;
    @FXML
    private RadioButton rbtnBeginsWith;
    @FXML
    private RadioButton rbtnContains;
    @FXML
    private RadioButton rbtnEndsWith;
    @FXML
    private RadioButton rbtnExact;
    @FXML
    private CheckBox checkCaseSensitive;
    @FXML
    private ComboBox<String> comboLimitation;
    @FXML
    private ListView listResult;
    @FXML
    private Text lblCount;

    private final WordModel wordModel;

    public WordSearchController() {
        wordModel = new WordModel();
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listResult.setItems(wordModel.getWords());
        try {
            wordModel.reset();
            updateLabel();
        } catch (FileNotFoundException ex) {
            System.out.println("Serious error!");
        }

        comboLimitation.setItems(FXCollections.observableArrayList(
                "10",
                "20",
                "50",
                "100"));
        comboLimitation.setVisibleRowCount(4);
    }

    /**
     * Makes a query for the list of words with the text from txtSearch
     */
    @FXML
    private void search() {
        SortCommand command = null;
        String searchWord = txtSearch.getText();
        boolean caseSensitive = checkCaseSensitive.isSelected();
        command = checkRadioChoice(command);
        wordModel.updateSearchWords(searchWord, command, caseSensitive);
        updateLabel();
    }

    /**
     * Get the command chosen from radio button
     *
     * @param command
     * @return
     */
    private SortCommand checkRadioChoice(SortCommand command) {
        if (rbtnBeginsWith.isSelected()) {
            command = SortCommand.BEGINS_WITH;
        }
        if (rbtnContains.isSelected()) {
            command = SortCommand.CONTAINS;
        }
        if (rbtnEndsWith.isSelected()) {
            command = SortCommand.ENDS_WITH;
        }
        if (rbtnExact.isSelected()) {
            command = SortCommand.EXACT;
        }
        return command;
    }

    /**
     * Clears the queries and brings back the complete list of words
     */
    @FXML
    private void clear() throws FileNotFoundException {
        wordModel.reset();
        updateLabel();
        txtSearch.setText("");
    }

    @FXML
    private void close() {
        System.exit(1);
    }

    /**
     * Updates the word count
     */
    private void updateLabel() {
        //If the entry in list of words contain NO_RESULT we will show zero results on counter
        if (!wordModel.getWords().contains(WordModel.NO_RESULT)) {
            lblCount.setText("" + wordModel.getWords().size());
        } else {
            lblCount.setText("0");
        }
    }

    /**
     * Limits the amount of results
     */
    @FXML
    private void limitAmount() {
        search();
        wordModel.updateMaxResults(Integer.parseInt(comboLimitation.getSelectionModel().getSelectedItem()));
        updateLabel();
    }

}
