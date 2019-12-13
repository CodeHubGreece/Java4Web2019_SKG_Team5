package org.regeneration.team5.DoctorProject.entities;
import javax.persistence.*;
import java.util.List;
@Entity
public class Doctor {
    @Id
    private Integer doctorId;
    //user
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID")
    private User user;
    //specialization
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specialityID")
    private Speciality speciality;
    //appointment mapping
    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL )
    private List<Appointment> appointments;
    public Integer getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}