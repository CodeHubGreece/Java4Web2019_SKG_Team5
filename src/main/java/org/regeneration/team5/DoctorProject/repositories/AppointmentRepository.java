package org.regeneration.team5.DoctorProject.repositories;

import org.regeneration.team5.DoctorProject.entities.Appointment;
import org.regeneration.team5.DoctorProject.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    List<Appointment> findAllByInfo(String description);

    List<Appointment> findAllByDoctor(Doctor doctor);

    List<Appointment> findAllByCreatedAtBetweenAndDoctor(Timestamp fromDate, Timestamp toDate, Doctor doctor);

    List<Appointment> findAllByCreatedAtBetweenAndInfo(Date createdAt, Date createdAt2, String info);

    Appointment findByAppointmentId(int id);
}
