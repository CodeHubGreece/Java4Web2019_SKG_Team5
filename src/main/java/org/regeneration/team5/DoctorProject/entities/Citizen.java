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

<<<<<<< HEAD
=======
    //user
>>>>>>> 4b2ae37292797f906bfa0e5d91e7297cc0435fa7
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;

<<<<<<< HEAD
    @OneToMany(mappedBy = "citizen",cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    private static List<Citizen> citizenList = new ArrayList<>();
    public Citizen(){
=======
    //appointment mapping
    @OneToMany (mappedBy = "citizen" ,cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();

    private static List<Citizen> citizenListList = new ArrayList<>();
>>>>>>> 4b2ae37292797f906bfa0e5d91e7297cc0435fa7

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

<<<<<<< HEAD
    public void setUser(User user) {
        this.user = user;
    }

    public String getAmka() {
=======
    public Integer getAmka() {
>>>>>>> 4b2ae37292797f906bfa0e5d91e7297cc0435fa7
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
