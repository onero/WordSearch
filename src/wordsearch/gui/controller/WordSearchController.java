/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearch.gui.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import wordsearch.bll.WordManager;

/**
 * FXML Controller class
 *
 * @author gta1
 */
public class WordSearchController implements Initializable {

    @FXML
    private TextField txtSearch;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnClear;
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
    private Button btnClose;
    @FXML
    private ListView listResult;
    @FXML
    private Label lblCount;

    private final WordManager wordManager;

    public WordSearchController() {
        wordManager = new WordManager();
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> allWords = wordManager.getAllWords();
        comboLimitation.setItems(FXCollections.observableArrayList(
                "10",
                "20",
                "50",
                "100"));
        comboLimitation.setVisibleRowCount(4);
    }

    @FXML
    private void search() {

    }

    @FXML
    private void clear() {

    }

    @FXML
    private void close() {

    }

    @FXML
    private void filterSearch() {

    }

}
