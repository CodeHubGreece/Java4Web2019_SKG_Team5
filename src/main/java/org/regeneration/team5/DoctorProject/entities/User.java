package org.regeneration.team5.DoctorProject.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private short property=0;

    @OneToOne(mappedBy = "user")
    private Citizen citizen;

    @OneToOne(mappedBy = "user")
    private Doctor doctor;

    private static List<User> userList = new ArrayList<>();

    //private static PasswordEncoder passwordEncoder;

    public User(){

    }
//    public void User(String username,String password){
//        this.username = username;
//        this.password = password;
//    }

//    public void User(String firstname,String lastname, String username, String password){
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.password = password;
//        this.username = username;
//    }

    public User(String firstname, String lastname, String username, String password){
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.username = username;
    }


    public Integer getUserID() {
        return userID;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getProperty() {
        return property;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProperty(short property) {
        this.property = property;
    }

    public boolean getUserType(){
        if (property==1){
            return false;
        }else {
            return true;
        }
    }

    public static List<User> getUserList() {
        return userList;
    }
    public static void setUserList(List<User> userList){
        userList = userList;
    }
}
