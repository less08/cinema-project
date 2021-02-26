package com.dev.filarmonic.model.dto;

import com.dev.filarmonic.annotation.EmailValidator;
import com.dev.filarmonic.annotation.PasswordValidator;

@PasswordValidator(field = "password", fieldMatch = "repeatedPassword")
public class UserRequestDto {
    @EmailValidator
    private String email;
    private String password;
    private String repeatedPassword;

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
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }
}
