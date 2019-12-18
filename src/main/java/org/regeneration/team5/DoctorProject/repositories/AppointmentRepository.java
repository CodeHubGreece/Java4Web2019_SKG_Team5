package org.regeneration.team5.DoctorProject.repositories;

import org.regeneration.team5.DoctorProject.entities.Appointment;
import org.regeneration.team5.DoctorProject.entities.Citizen;
import org.regeneration.team5.DoctorProject.entities.Doctor;
import org.regeneration.team5.DoctorProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    List<Appointment> findAllByInfo(String description);

    List<Appointment> findAllByDoctor(Doctor doctor);

    //List<Appointment> findAllByCreatedAtBetweenAndDoctor(String fromDate, String toDate, Doctor doctor);

    List<Appointment> findByDoctor(Doctor doctor);
    List<Appointment> findAllByCreatedAtBetweenAndInfo(Date createdAt, Date createdAt2, String info);
    //List<Appointment> findBySpecialityAndFromAndTo(String title,String from,String to);
    Appointment findByAppointmentId(int id);
    List<Appointment> findByCitizen(Citizen citizen);
    //List<Appointment> findAllByCreatedAtBetweenAndDoctorAndCitizen(String from, String to, Doctor byDoctorId);
}
