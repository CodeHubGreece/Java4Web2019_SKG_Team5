package org.regeneration.team5.DoctorProject.entities;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.*;
import java.util.*;
@Entity
public class Citizen {
    @Id
    @Column(name = "amka")
    private String amka;
    @Column(name = "email")
    private String email;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "userID")
    private String userId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}