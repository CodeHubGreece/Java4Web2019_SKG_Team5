package org.regeneration.team5.DoctorProject.entities;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Citizen {
    @Id
    private Integer amka;
    @Column
    private String email;
    @Column
    private String mobile;

    //user
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;

    //appointment mapping
    @OneToMany (mappedBy = "citizen" ,cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();

    private static List<Citizen> citizenListList = new ArrayList<>();

    public static List<Citizen> getCitizenListList() {
        return citizenListList;
    }

    public static void setCitizenListList(List<Citizen> citizenListList) {
        Citizen.citizenListList = citizenListList;
    }

    public  Citizen(){

    }
    public  Citizen(Integer amka, String email, String mobile, @Autowired User user){
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
