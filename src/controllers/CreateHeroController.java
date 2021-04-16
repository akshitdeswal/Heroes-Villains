package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import models.Hero;
import utilities.DBUtility;

import java.io.IOException;
import java.sql.SQLException;

public class CreateHeroController {

    @FXML
    private GridPane firstNameText;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField realNameTextField;

    @FXML
    private TextField strengthTextField;

    @FXML
    private DatePicker birthdayDatePicker;

    @FXML
    private Label messageLabel;

    @FXML
    private void createHero(){
        if (fieldsAreFilled())
        {
            try {
                Hero newHero = new Hero(firstNameTextField.getText(),
                        lastNameTextField.getText(),
                        realNameTextField.getText(),
                        Integer.parseInt(strengthTextField.getText()),
                        birthdayDatePicker.getValue()
                        );
                DBUtility.insertHeroIntoDB(newHero);
                messageLabel.setText(newHero.toString());
            }catch(IllegalArgumentException | SQLException e)
            {
                messageLabel.setText(e.getMessage());
            }
        }
        firstNameTextField.clear();
        lastNameTextField.clear();
        strengthTextField.clear();

    }

    private boolean fieldsAreFilled()
    {
        String errorMessage = "The following fields are empty: ";
        if (firstNameTextField.getText().isEmpty())
            errorMessage += "first name, ";

        if (lastNameTextField.getText().isEmpty())
            errorMessage += "last name, ";

        if (realNameTextField.getText().isEmpty())
            errorMessage += "realName, ";

        if (strengthTextField.getText().isEmpty())
            errorMessage += "strength, ";

        if (birthdayDatePicker.getValue()==null)
            errorMessage += "birthday, ";

        if (errorMessage.equals("The following fields are empty: "))
            return true;

        //if there was at least 1 field that is empty.
        messageLabel.setText(errorMessage.substring(0, errorMessage.length()-2));
        return false;
    }
    @FXML
    private void returnToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/mainView.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle("Create a Destroyer");
        stage.show();
    }

}

