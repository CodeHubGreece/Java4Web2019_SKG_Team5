package org.regeneration.team5.DoctorProject.entities;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @ManyToOne
    @JoinColumn(name = "specialityID")
    private Speciality speciality;

    //appointment mapping
//    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
//    private List<Appointment> appointments;

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

//    public Doctor(Integer doctorId, User user, Speciality speciality, List<Appointment> appointments) {
//        this.doctorId = doctorId;
//        this.user = user;
//        this.speciality = speciality;
//        this.appointments = appointments;
//    }

//    public Speciality getSpeciality() {
//        return speciality;
//    }
//
//    public void setSpeciality(Speciality speciality) {
//        this.speciality = speciality;
//    }
//
//    public List<Appointment> getAppointments() {
//        return appointments;
//    }
//
//    public void setAppointments(List<Appointment> appointments) {
//        this.appointments = appointments;
//    }
}