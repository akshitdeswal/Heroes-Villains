import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Hero;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
//        ArrayList<String> moves = new ArrayList<>();
//        moves.add("aalll");
//        moves.add("may");
//        Hero hero = new Hero("Akshit","Deswal","Akshit Deswal", 90, LocalDate.of(2002,8,13),moves );
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("views/mainView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Marvel Main Page");
        stage.show();
    }
}
