package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import models.Hero;
import models.Villain;
import utilities.DBUtility;


import java.io.IOException;
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
            villainListView.getItems().addAll(DBUtility.getVillainList());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    @FXML
    private void createNewHeroButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/createHero.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle("Create a New Warrior");
        stage.show();
    }



}

