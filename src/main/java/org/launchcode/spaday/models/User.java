package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    @NotBlank
    @Size(min=5,max=15,message="Username must be between 5 and 15 characters long." )
    private String username;
    @Email
    private String email;
    @NotBlank
    @Size(min = 6)
    private String password;

    @NotNull(message = "Passwords do not match")
    private String verifyPassword;

    public User() {

    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    private void checkPassword(){
        if(this.verifyPassword != null && this.password != null && !this.password.equals(this.verifyPassword)){
            this.verifyPassword = null;
        }
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        this.checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        this.checkPassword();
    }
}
