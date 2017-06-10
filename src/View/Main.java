package View;

import Model.User;
import Model.UserDB;
import Model.UserIO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static Model.UserIO.readUsers;

/**
 * Created by SAimon22 on 6/7/2017.
 */
public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("signIn.fxml"));
        primaryStage.setTitle("Sign in");
        primaryStage.setScene(new Scene(root, 350, 205));
        primaryStage.show();
        stater();
    }


    public static void main(String[] args) {
        launch(args);
    }
    public void stater(){
        try{
            UserDB.setUsersArrayList((ArrayList<User>) UserIO.readUsers());

        }
        catch( IOException ex) {
            System.out.print("File Error");

        }
        catch( ClassNotFoundException ex) {
            System.out.print("File Error");

        }
    }

}
