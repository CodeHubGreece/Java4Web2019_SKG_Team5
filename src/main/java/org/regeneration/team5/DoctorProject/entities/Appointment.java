package org.regeneration.team5.DoctorProject.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    @Column(name = "appointmentID")
    private Integer appointmentId;
    @Column(name = "created_at")
=======
    private Integer appointmentId;
    @Column
>>>>>>> 4b2ae37292797f906bfa0e5d91e7297cc0435fa7
    private Date createdAt;

    //citizen
    @ManyToOne(cascade = CascadeType.ALL)
<<<<<<< HEAD
    @JoinColumn(name = "amka")
=======
   // @JoinColumn(name = "amka")
    @MapsId
>>>>>>> 4b2ae37292797f906bfa0e5d91e7297cc0435fa7
    private Citizen citizen;

    //doctor
    @ManyToOne(cascade = CascadeType.ALL)
<<<<<<< HEAD
    @JoinColumn(name = "doctorID")
    private Doctor doctor;

    @Column(name = "symptoms")
=======
    //JoinColumn(name = "doctorId")
    @MapsId
    private Doctor doctor;

>>>>>>> 4b2ae37292797f906bfa0e5d91e7297cc0435fa7
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
