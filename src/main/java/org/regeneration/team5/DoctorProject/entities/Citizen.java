package org.regeneration.team5.DoctorProject.entities;

import javax.persistence.*;

@Entity
public class Citizen {
    @Id
    private Integer amka;
    @Column
    private String email;
    @Column
    private String mobile;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID")
    private User user;

    public void Citizen(){

    }
    public void Citizen(Integer amka, String email, String mobile, User user){
        this.amka = amka;
        this.email = email;
        this.mobile = mobile;
        this.user = user;
    }

    public Integer getAmka() {
        return amka;
    }

    public User getUser() {
        return user;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setAmka(Integer amka) {
        this.amka = amka;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
