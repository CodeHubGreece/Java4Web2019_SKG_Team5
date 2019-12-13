package org.regeneration.team5.DoctorProject.entities;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.*;
import java.util.*;
@Entity
public class Citizen {
    @Id
    private String amka;
    @Column
    private String email;
    @Column
    private String mobile;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID")
    private User user;
    @OneToMany(mappedBy = "citizen",cascade = CascadeType.ALL)
    private List<Appointment> appointments;
    private static List<Citizen> citizenList = new ArrayList<>();
    public Citizen(){
    }
    public Citizen(String amka, String email, String mobile,@Autowired User user) {
        this.amka = amka;
        this.email = email;
        this.mobile = mobile;
        this.user = user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getAmka() {
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
    public void setAmka(String amka) {
        this.amka = amka;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public static List<Citizen> getCitizenList() {
        return citizenList;
    }
    public static void setCitizenList(List<Citizen> citizenList) {
        Citizen.citizenList = citizenList;
    }
}