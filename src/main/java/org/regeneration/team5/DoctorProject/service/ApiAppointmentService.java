package org.regeneration.team5.DoctorProject.service;

import org.regeneration.team5.DoctorProject.dto.AppointmentDTO;
import org.regeneration.team5.DoctorProject.entities.Appointment;
import org.regeneration.team5.DoctorProject.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ApiAppointmentService {
    private final AppointmentRepository appointmentRepository;

    public ApiAppointmentService(@Autowired AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> findAll(){
        return appointmentRepository.findAll();
    }

    public Appointment findById(int id){
        return appointmentRepository.findByAppointmentId(id);
    }

    public List<Appointment> findByDateAndDoctor(Timestamp from,Timestamp to, int id){
        return appointmentRepository.findAllByCreatedAtBetweenAndDoctorId(from,to,id);
    }

    public List<Appointment> findByDateAndInfo(Timestamp from, Timestamp to, String info){
        return appointmentRepository.findAllByCreatedAtBetweenAndInfo(from,to,info);
    }

    public Appointment setNewAppointment(AppointmentDTO appointmentDTO) throws ParseException {
        SimpleDateFormat formatter6=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        Appointment newAppointment = new Appointment();
        newAppointment.setAmka(appointmentDTO.getCitizenId());
        newAppointment.setDoctorId(appointmentDTO.getDoctorId());
        newAppointment.setCreatedAt(formatter6.parse(appointmentDTO.getDate().concat(appointmentDTO.getTime())));
        newAppointment.setInfo(appointmentDTO.getSymptoms());
        newAppointment.setSymptoms(appointmentDTO.getInfo());
        return appointmentRepository.save(newAppointment);
    }
}
