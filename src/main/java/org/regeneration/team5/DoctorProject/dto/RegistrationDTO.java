package org.regeneration.team5.DoctorProject.dto;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RegistrationDTO {
    private String amka;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private String mobile;

    public RegistrationDTO(){

    }

    public RegistrationDTO(String amka, String firstname, String lastname, String username, String password, String email, String mobile) {
        this.amka = amka;
        this.firstname =firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
    }

    public String getAmka() {
        return amka;
    }

    public void setAmka(String amka) {
        this.amka = amka;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
