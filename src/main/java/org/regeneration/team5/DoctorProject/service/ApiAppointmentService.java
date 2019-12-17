package org.regeneration.team5.DoctorProject.service;

import org.regeneration.team5.DoctorProject.dto.AppointmentDTO;
import org.regeneration.team5.DoctorProject.entities.Appointment;
import org.regeneration.team5.DoctorProject.entities.Citizen;
import org.regeneration.team5.DoctorProject.entities.Doctor;
import org.regeneration.team5.DoctorProject.entities.User;
import org.regeneration.team5.DoctorProject.repositories.AppointmentRepository;
import org.regeneration.team5.DoctorProject.repositories.CitizenRepository;
import org.regeneration.team5.DoctorProject.repositories.DoctorRepository;
import org.regeneration.team5.DoctorProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.List;

@Service
public class ApiAppointmentService {
    private final AppointmentRepository appointmentRepository;
    @Autowired
    private CitizenRepository citizenRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private UserRepository userRepository;
    private Instant instant;

    public ApiAppointmentService(@Autowired AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    public Appointment deleteByAppointmentId(int id){
        return appointmentRepository.deleteByAppointmentId(id);
    }
    public List<Appointment> findAll(){
        return appointmentRepository.findAll();
    }

    public Appointment findById(int id){
        return appointmentRepository.findByAppointmentId(id);
    }

    public List<Appointment> findByDateAndDoctor(Timestamp from,Timestamp to, Doctor doctor){
        return appointmentRepository.findAllByCreatedAtBetweenAndDoctor(from,to,doctor);
    }

    public List<Appointment> findByDateAndInfo(Timestamp from, Timestamp to, String info){
        return appointmentRepository.findAllByCreatedAtBetweenAndInfo(from,to,info);
    }


    public Appointment setNewAppointment(AppointmentDTO appointmentDTO, User user) throws ParseException {
        SimpleDateFormat formatter6=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Appointment newAppointment = new Appointment();
        //newAppointment.setAppointmentId(appointmentDTO.getAppointmentId());
        newAppointment.setCitizen(citizenRepository.findCitizenByUser(user));
        newAppointment.setDoctor(doctorRepository.findByDoctorId(appointmentDTO.getDoctorId()));
        //newAppointment.setCreatedAt(Instant.parse(appointmentDTO.getDate().concat(" ").concat(appointmentDTO.getTime())));
        newAppointment.setCreatedAt(formatter6.parse(appointmentDTO.getDate().concat(" ").concat(appointmentDTO.getTime()).concat(":00")));
        newAppointment.setInfo(appointmentDTO.getInfo());
        newAppointment.setSymptoms(appointmentDTO.getSymptoms());
        appointmentRepository.save(newAppointment);
        return newAppointment;
    }
}
