package org.regeneration.team5.DoctorProject.controller;

import org.regeneration.team5.DoctorProject.dto.AppointmentDTO;
import org.regeneration.team5.DoctorProject.dto.SearchAppointmentDTO;
import org.regeneration.team5.DoctorProject.entities.Appointment;
import org.regeneration.team5.DoctorProject.entities.Doctor;
import org.regeneration.team5.DoctorProject.entities.User;
import org.regeneration.team5.DoctorProject.repositories.*;
import org.regeneration.team5.DoctorProject.service.ApiAppointmentService;
import org.regeneration.team5.DoctorProject.service.ApiDoctorDetailsService;
import org.regeneration.team5.DoctorProject.service.ApiSpecialityService;
import org.regeneration.team5.DoctorProject.service.ApiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RestController
public class AppointmentController {
    private final ApiAppointmentService appointmentService;
    private final ApiUserService userService;
    private Principal principal;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private CitizenRepository citizenRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ApiDoctorDetailsService doctorDetailsService;
    @Autowired
    private ApiSpecialityService apiSpecialityService;
    private SearchAppointmentDTO searchAppointmentDTO;


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
    @GetMapping("appointment/delete/{id}")
    public Appointment delete(@PathVariable Integer id) {
        return  appointmentService.deleteAppointment(id);
    }

    @GetMapping("/doctor/appointments")
    public List<Appointment> findDoctorAppointments(Principal principal){
        User user = userService.findByUsername(principal.getName());
        return appointmentService.findByDoctor(doctorRepository.findByUser(user));
    }

    @GetMapping("/doctor/appointment/{id}")
    public Appointment findAppointmentById(@PathVariable int id,Principal principal){
        User user = userService.findByUsername(principal.getName());
        List<Appointment> allUserAppointments = appointmentService.findByDoctor(doctorRepository.findByUser(user));
        for (Appointment appointment : allUserAppointments) {
            if (appointment.getAppointmentId().equals(id)) {
                return appointment;
            }
        }
        return null;
    }


//    @PostMapping("/appointment/new")
//    public Appointment newAppointment(@RequestBody AppointmentDTO appointmentDTO, Principal principal) throws ParseException {
//        User user = userService.findByUsername(principal.getName());
//        return appointmentService.setNewAppointment(appointmentDTO,user);
//    }


    @PutMapping("/appointment/update/{id}")
    public Appointment updateAppointment(@RequestBody AppointmentDTO upAppointmentDTO, Principal principal,@PathVariable Integer id) throws ParseException {
        User user = userService.findByUsername(principal.getName());
        return appointmentService.updateAppointment(upAppointmentDTO,user,id);
    }

    @GetMapping("/citizen/appointments")
    public List<Appointment> findCitizenAppointments(@RequestParam("specialityTitle")String specialityTitle,@RequestParam("from")String from,@RequestParam("to")String to,Principal principal) throws ParseException {
        List<Appointment> appointmentList = new ArrayList<>();
        SimpleDateFormat formatter6=new SimpleDateFormat("yyyy-MM-dd");
        Date fromForm = formatter6.parse(from);
        Date toForm = formatter6.parse(to);
        User user = userService.findByUsername(principal.getName());
        List<Appointment> allUserAppointments = appointmentService.findByCitizen(citizenRepository.findCitizenByUser(user));
        for(Appointment aua : allUserAppointments){
            for(Doctor doc : doctorDetailsService.findDoctorsBySpeciality(apiSpecialityService.findSpecialitiesByTitle(specialityTitle)))

            if (doc ==aua.getDoctor() && aua.getCreatedAt().compareTo(fromForm)>0 && aua.getCreatedAt().compareTo(toForm)<0){
                appointmentList.add(aua);
            }
        }
        return appointmentList;
    }

    @GetMapping("/citizen/appointment/{id}")
    public Appointment findAppointmentById(@PathVariable Integer id,Principal principal){
        User user = userService.findByUsername(principal.getName());
        List<Appointment> allUserAppointments = appointmentService.findByCitizen(citizenRepository.findCitizenByUser(user));
        for (Appointment appointment : allUserAppointments) {
            if (appointment.getAppointmentId().equals(id)) {
                return appointment;
            }
        }
        return null;
    }







}
