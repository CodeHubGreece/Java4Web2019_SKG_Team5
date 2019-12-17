package org.regeneration.team5.DoctorProject.controller;

import org.regeneration.team5.DoctorProject.dto.AppointmentDTO;
import org.regeneration.team5.DoctorProject.dto.SearchAppointmentDTO;
import org.regeneration.team5.DoctorProject.entities.Appointment;
import org.regeneration.team5.DoctorProject.entities.User;
import org.regeneration.team5.DoctorProject.repositories.CitizenRepository;
import org.regeneration.team5.DoctorProject.repositories.DoctorRepository;
import org.regeneration.team5.DoctorProject.repositories.UserRepository;
import org.regeneration.team5.DoctorProject.service.ApiAppointmentService;
import org.regeneration.team5.DoctorProject.service.ApiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.ParseException;
import java.util.List;

@RestController
public class AppointmentController {
    private final ApiAppointmentService appointmentService;
    private final ApiUserService userService;
    @Autowired
    private CitizenRepository citizenRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private UserRepository userRepository;


    public AppointmentController(@Autowired ApiAppointmentService appointmentService,@Autowired ApiUserService userService) {
        this.appointmentService = appointmentService;
        this.userService = userService;
    }

    @PostMapping("/appointment/new")
    public Appointment newAppointment(@RequestBody AppointmentDTO appointmentDTO, Principal principal) throws ParseException {
        User user = userService.findByUsername(principal.getName());
        return appointmentService.setNewAppointment(appointmentDTO,user);
    }

    @GetMapping("/appointments")
    public List<Appointment> findAll(){
       return appointmentService.findAll();
    }

//    @GetMapping("/appointment/searchByDoctor/{id}")
//    public List<Appointment> findAppointmentByDoctor(@RequestBody SearchAppointmentDTO searchAppointmentDTO, Principal principal, @PathVariable int id){
//        User user = userService.findByUsername(principal.getName());
//        //searchAppointmentDTO.setDoctorId(id);
//        return appointmentService.findByDateAndDoctor(searchAppointmentDTO,doctorRepository.findByDoctorId(user.getUserID()));
//    }
    @DeleteMapping("appointment/delete/{id}")
    public Appointment delete(@PathVariable Integer id) {
        return  appointmentService.deleteAppointment(id);
    }

    @GetMapping("/doctor/appointments")
    public List<Appointment> findDoctorAppointments(Principal principal){
        User user = userService.findByUsername(principal.getName());
        return appointmentService.findByDoctor(doctorRepository.findByUser(user));
    }

    @GetMapping("/citizen/appointments")
    public List<Appointment> findCitizenAppointments(Principal principal){
        User user = userService.findByUsername(principal.getName());
        return appointmentService.findByCitizen(citizenRepository.findCitizenByUser(user));
    }



}
