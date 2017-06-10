package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by SAimon22 on 6/7/2017.
 */
public class SignInController implements Initializable {
    @FXML
    public Button SignInButton;
    @FXML
    public Button CreateAccountButton;
    @FXML
    public TextField userName;
    @FXML
    public TextField inputPassword;
    @FXML
    public Label PasswordError;
    @FXML
    public Label UsernameError;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void showMessage(String message, Color fontColor){
        UsernameError.setText(message);
        UsernameError.setVisible(true);
        UsernameError.setTextFill(fontColor);
    }

    public void SignInPressed(ActionEvent event){
        if (userName.getText().isEmpty() || inputPassword.getText().isEmpty()) {
            showMessage("username and password", Color.RED);
        }


    }

    public boolean userNameChecker() {
        return false;
    }

    public String createAccount() throws IOException{

        Stage createAStage= new Stage();
        Parent root = FXMLLoader.load(CreateAccount.class.getResource("/View/createAccount.fxml"));
        createAStage.setTitle("Create Account");
        createAStage.setScene(new Scene(root, 550, 500));
        createAStage.show();
        return "success";

    }
}