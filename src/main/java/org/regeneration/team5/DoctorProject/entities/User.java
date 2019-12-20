package org.regeneration.team5.DoctorProject.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @JsonIgnore
    private String username;
    @Column
    @JsonIgnore
    private String password;
    @Column
    private String role;

    private static List<User> userList = new ArrayList<>();
    public User(){
    }

    public User(String firstname, String lastname, String username, String password,String role){
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.username = username;
        this.role = role;
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
    public String getRole() {
        return role;
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
    public void setRole(String role) {
        this.role = role;
    }



    public static List<User> getUserList() {
        return userList;
    }
    public static void setUserList(List<User> userList){
        userList = userList;
    }
}