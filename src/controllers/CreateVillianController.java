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
import javafx.stage.Stage;
import models.Hero;
import models.Villain;
import utilities.DBUtility;

import java.io.IOException;
import java.sql.SQLException;

public class CreateVillianController {

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField evilPurposeTextPurpose;

    @FXML
    private TextField strengthTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField lethalWeaponTextField;

    @FXML
    private DatePicker birthdayDatePicker;

    @FXML
    private Label messageLabel;

    @FXML
    private void createVillain(){
        if (fieldsAreFilled())
        {
            try {
                Villain newVillain = new Villain(firstNameTextField.getText(),
                        lastNameTextField.getText(),
                        Integer.parseInt(strengthTextField.getText()),
                        birthdayDatePicker.getValue(),
                        evilPurposeTextPurpose.getText(),
                        lethalWeaponTextField.getText()
                );
                DBUtility.insertVillianIntoDB(newVillain);
                messageLabel.setText(newVillain.toString());
            }catch(IllegalArgumentException | SQLException e)
            {
                messageLabel.setText(e.getMessage());
            }
            firstNameTextField.clear();
            lastNameTextField.clear();
            strengthTextField.clear();
            evilPurposeTextPurpose.clear();
            lethalWeaponTextField.clear();


        }
    }

    private boolean fieldsAreFilled()
    {
        String errorMessage = "The following fields are empty: ";
        if (firstNameTextField.getText().isEmpty())
            errorMessage += "first name, ";

        if (lastNameTextField.getText().isEmpty())
            errorMessage += "last name, ";

        if (strengthTextField.getText().isEmpty())
            errorMessage += "strength, ";

        if (birthdayDatePicker.getValue()==null)
            errorMessage += "birthday, ";

        if(evilPurposeTextPurpose.getText().isEmpty())
            errorMessage += "evilPurpose, ";

        if (lethalWeaponTextField.getText().isEmpty())
            errorMessage += "lethalWeapon, ";

        if (errorMessage.equals("The following fields are empty: "))
            return true;


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
