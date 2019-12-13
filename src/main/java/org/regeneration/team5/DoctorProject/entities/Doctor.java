package org.regeneration.team5.DoctorProject.entities;

import javax.persistence.*;
<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> 4b2ae37292797f906bfa0e5d91e7297cc0435fa7
import java.util.List;

@Entity
public class Doctor {

    @Id
    private Integer doctorId;

    //user
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID")
<<<<<<< HEAD
    private User user;

    //specialization
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specialityID")
    private Speciality speciality;

    //appointment mapping
    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL )
    private List<Appointment> appointments;
=======
    //@MapsId
    private User user;

    //specialization
    @OneToMany(cascade = CascadeType.ALL)
   // @JoinColumn(name="specializationId")
    @MapsId
    private Specialization specialization;

    //appointment mapping
    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL )
    private List<Appointment> appointments = new ArrayList<>();
>>>>>>> 4b2ae37292797f906bfa0e5d91e7297cc0435fa7


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
