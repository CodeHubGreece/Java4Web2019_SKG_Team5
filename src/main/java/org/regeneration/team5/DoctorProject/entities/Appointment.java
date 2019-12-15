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

    @Column(name = "doctorID")
    private int doctorId;

    @Column(name = "amka")
    private int amka;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "amka")
    private Citizen citizen;
    //doctor

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctorID")
    private Doctor doctor;

    @Column(name = "symptoms")
    private  String symptoms;

    @Column(name = "info")
    private String info;

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

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getAmka() {
        return amka;
    }

    public void setAmka(int amka) {
        this.amka = amka;
    }
}