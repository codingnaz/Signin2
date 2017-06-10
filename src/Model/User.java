package Model;

import java.io.Serializable;

/**
 * Created by SAimon22 on 6/7/2017.
 */
public class User extends Person implements Serializable {
    private String phoneNumber;
    private String profilePhoto;
    private String username;
    private String password;

    private String email;


    public User() {

    }

    public User(String firstName, String lastName, String ssn, String dob, String gender, String username, String password, String email, String phoneNumber, String profilePhoto) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setSsn(ssn);
        this.setDob(dob);
        this.setGender(gender);
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
        this.setProfilePhoto(profilePhoto);



    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }




}
