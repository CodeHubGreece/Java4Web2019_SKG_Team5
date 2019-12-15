package org.regeneration.team5.DoctorProject.controller;

import org.regeneration.team5.DoctorProject.dto.AppointmentDTO;
import org.regeneration.team5.DoctorProject.entities.Appointment;
import org.regeneration.team5.DoctorProject.service.ApiAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class AppointmentController {

    private final ApiAppointmentService appointmentService;

    public AppointmentController(@Autowired ApiAppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/appointment/new")
    public Appointment newAppointment(@RequestBody AppointmentDTO appointmentDTO) throws ParseException {
        return appointmentService.setNewAppointment(appointmentDTO);
    }

    @GetMapping("/appointments")
    public List<Appointment> findAll(){
       return appointmentService.findAll();
    }



}
