package org.regeneration.team5.DoctorProject.entities;
import javax.persistence.*;
import java.util.Date;
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointmentID")
    private Integer appointmentId;
    @Column(name = "created_at")
    private Date createdAt;
    //citizen
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "amka")
    private Citizen citizen;
    //doctor
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctorID")
    private Doctor doctor;
    @Column(name = "symptoms")
    private  String symptoms;
    public Integer getAppointmentId() {
        return appointmentId;
    }
    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Citizen getCitizen() {
        return citizen;
    }
    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public String getSymptoms() {
        return symptoms;
    }
    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    private String info;
}