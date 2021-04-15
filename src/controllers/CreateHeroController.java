package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import models.Hero;
import utilities.DBUtility;

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

}

