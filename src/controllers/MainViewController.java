package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import models.Hero;
import models.Villain;
import utilities.DBUtility;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private Label heroLabel;

    @FXML
    private ListView<Hero> heroListView;

    @FXML
    private Label villainLabel;

    @FXML
    private ListView<Villain> villainListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            heroListView.getItems().addAll(DBUtility.getHeroList());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        villainListView.getItems().addAll(DBUtility.getVillainList());
    }


}

