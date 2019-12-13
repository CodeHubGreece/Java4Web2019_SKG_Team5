package org.regeneration.team5.DoctorProject.entities;

import javax.persistence.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//OK
@Entity
public class Specialization {

    @Id
    private Integer specializationId;
    @Column
    private String title;

    //doctor mapping
    @OneToMany (mappedBy = "specialization")
    @JoinColumn(name = "doctorId")
    private List<Doctor> doctors = new ArrayList<>();


    public Integer getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(Integer specializationId) {
        this.specializationId = specializationId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Doctor> getDoctor() {
        return doctors;
    }

    public void setDoctor(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
