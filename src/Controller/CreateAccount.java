package Controller;

import Model.User;
import Model.UserDB;
import Model.UserIO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import static Model.UserDB.users;


/**
 * Created by SAimon22 on 6/7/2017.
 */
public class CreateAccount implements Initializable{
    public Label emailLabel;
    @FXML
    public Label phoneLabel;
    @FXML
    public Label genderLable;
    @FXML
    public Label confirmPasswordID;


    public TextField userInputFirstName;
    @FXML
    public TextField userInputLastName;
    @FXML
    public TextField userInputDOB;
    @FXML
    public TextField userInputGender;
    @FXML
    public RadioButton userInputRadioMaleButton;
    @FXML
    public RadioButton userInputRadioFemaleButton;
    @FXML
    public RadioButton inputPrivateButton;
    @FXML
    public TextField inputEmail;
    @FXML
    public TextField userInputSSN;
    @FXML
    public TextField userInputP1st;
    @FXML
    public TextField userInputPassword;
    @FXML
    public TextField userInputPasswordConfirm;
    @FXML
    public TextField userInputUserName;


    public Label lastNError;
    @FXML
    public Label emailError;
    @FXML
    public Label phoneError;
    @FXML
    public Label passwordError;
    @FXML
    public Label  SSNError;
    @FXML
    public Label  BODError;
    @FXML
    public Label  firstNError;
    @FXML
    public Label  userNameError;
    @FXML
    public Label  gError;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    boolean hasError= false;

    public String goodSSN(){

        if( userInputLastName.getText().isEmpty())
        {
            hasError= true;
            lastNError.setText("Error");
            lastNError.setVisible(true);
            lastNError.setTextFill(Color.RED);
        }
        else if (!userInputSSN.getText().isEmpty()) {
            Pattern ssnPattern = Pattern.compile("^(?!000|666)[0-8][0-9]{2}(?!00)[0-9]{2}(?!0000)[0-9]{4}$");
            if (!ssnPattern.matcher(userInputSSN.getText()).matches()){
                hasError= true;
                SSNError.setText("Error");
                SSNError.setVisible(true);
                SSNError.setTextFill(Color.RED);
            }
        }
        return userInputSSN.getText();

    }




    public String goodLastName(){

        if( userInputLastName.getText().isEmpty())
        {
            hasError= true;
            lastNError.setText("Error");
            lastNError.setVisible(true);
            lastNError.setTextFill(Color.RED);
        }
        return userInputFirstName.getText();

    }

    public String password(){
        String goodPassword= null;
        if(!userInputPassword.getText().isEmpty() ){
            Pattern patternPassword = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}");
            if (patternPassword.matcher(userInputPassword.getText()).matches() && userInputPassword.getText().equals(userInputPasswordConfirm.getText())) {
                goodPassword= userInputPassword.getText();
            } else{
            hasError= true;
            passwordError.setText("Error");
            passwordError.setVisible(true);
            passwordError.setTextFill(Color.RED);
            }
        }
        else{
            hasError= true;
            passwordError.setText("Error");
            passwordError.setVisible(true);
            passwordError.setTextFill(Color.RED);

        }
           return goodPassword;
    }


    public String UserName(){
        if( userInputUserName.getText().isEmpty()){
            hasError= true;
            userNameError.setText("Error");
            userNameError.setVisible(true);
            userNameError.setTextFill(Color.RED);
        }return userInputUserName.getText();
    }
    public String goodUserName(){
        String goodUserNames =null;
        if(UserName().equals(users.getUsername())){
            userNameError.setText("User Name Exit");
            userNameError.setVisible(true);
            userNameError.setTextFill(Color.RED);
            hasError=true;
            goodUserNames= null;
        }
        else{goodUserNames= UserName(); }
        return goodUserNames;
    }
       /** else if ( userInputUserName.getText().equals(User.getUsername()))
        String goodUserName= null;


        return goodUserName;

    }
/**/
       public String goodFirstName(){

           if( userInputFirstName.getText().isEmpty())
           {
               hasError= true;
               firstNError.setText("Error");
               firstNError.setVisible(true);
               firstNError.setTextFill(Color.RED);
           }
           return userInputFirstName.getText();

       }

    public String phoneNumber(){
        String phoneNumberW = null;
        if (!userInputP1st.getText().isEmpty()) {
            Pattern phoneNumberPattern = Pattern.compile("^(?:(?:\\+?1\\s*(?:[.-]\\s*)?)?(?:\\(\\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\\s*\\)|([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\\s*(?:[.-]\\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\\s*(?:[.-]\\s*)?([0-9]{4})(?:\\s*(?:#|x\\.?|ext\\.?|extension)\\s*(\\d+))?$");
            if (!phoneNumberPattern.matcher(userInputP1st.getText()).matches()) {
                hasError = true;
                phoneError.setText("Error");
                phoneError.setVisible(true);
                phoneError.setTextFill(Color.RED);
            } else {

                phoneNumberW= userInputP1st.getText();
            }
        }
    return phoneNumberW;
    }


    public String genderLableSetter(){
        String genderS = null;
        if(userInputRadioMaleButton.isSelected()){
            genderS ="Male";
        }
        else if(userInputRadioFemaleButton.isSelected()){
            genderS ="Female";
        }
        else if(inputPrivateButton.isSelected())  { genderS= "Private";}
        return genderS;
    }


public String gender(){
        if(genderLableSetter().equals(null)){
            System.out.print("Gender Error");
            hasError= true;
            gError.setText("Error");
            gError.setVisible(true);
            gError.setTextFill(Color.RED);
        }

            return genderLableSetter();
    }


    public void SignupPressed(ActionEvent event){
        phoneNumber();
        genderLableSetter();

       if(hasError== false){
           User newUser= new User(
                   goodFirstName(),
                   goodLastName(),
                   goodSSN(),
                   userInputDOB.getText(),
                   gender(),
                   goodUserName(),
                   password(),
                   inputEmail.getText(),
                   "test",
                   "test");
           UserDB.getUsersArrayList().add(newUser);
       }
           else{
           genderLableSetter();

       }
       try {
           UserIO.writeUsers(UserDB.getUsersArrayList());
       } catch (IOException ex) {
           ex.printStackTrace();
           System.out.println("cant write dat file");
       }

    }

}
