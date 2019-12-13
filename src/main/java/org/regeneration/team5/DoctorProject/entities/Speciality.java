package org.regeneration.team5.DoctorProject.entities;

import javax.persistence.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//OK
@Entity
public class Speciality {

    @Id
    private Integer specialityId;
    @Column
    private String title;

    //doctor mapping
    @OneToMany (mappedBy = "speciality",cascade = CascadeType.ALL)
    private List<Doctor> doctor ;


    public Integer getSpecializationId() {
        return specialityId;
    }

    public void setSpecializationId(Integer specializationId) {
        this.specialityId = specializationId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Doctor> getDoctor() {
        return doctor;
    }

    public void setDoctor(List<Doctor> doctors) {
        this.doctor = doctors;
    }
}
