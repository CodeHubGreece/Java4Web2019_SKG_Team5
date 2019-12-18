package org.regeneration.team5.DoctorProject.controller;

import org.regeneration.team5.DoctorProject.dto.AppointmentDTO;
import org.regeneration.team5.DoctorProject.dto.SearchAppointmentDTO;
import org.regeneration.team5.DoctorProject.entities.Appointment;
import org.regeneration.team5.DoctorProject.entities.Doctor;
import org.regeneration.team5.DoctorProject.entities.User;
import org.regeneration.team5.DoctorProject.repositories.CitizenRepository;
import org.regeneration.team5.DoctorProject.repositories.DoctorRepository;
import org.regeneration.team5.DoctorProject.repositories.SpecialityRepository;
import org.regeneration.team5.DoctorProject.repositories.UserRepository;
import org.regeneration.team5.DoctorProject.service.ApiAppointmentService;
import org.regeneration.team5.DoctorProject.service.ApiDoctorDetailsService;
import org.regeneration.team5.DoctorProject.service.ApiSpecialityService;
import org.regeneration.team5.DoctorProject.service.ApiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.security.Principal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AppointmentController {
    private final ApiAppointmentService appointmentService;
    private final ApiUserService userService;
    private Principal principal;
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
    public List<Appointment> findCitizenAppointments(@RequestParam("specialityTitle")String specialityTitle,@RequestParam("from")String from,@RequestParam("to")String to,Principal principal){
        List<Appointment> appointmentList = new ArrayList<>();
        User user = userService.findByUsername(principal.getName());
        List<Appointment> allUserAppointments = appointmentService.findByCitizen(citizenRepository.findCitizenByUser(user));
        for(Appointment aua : allUserAppointments){
            for(Doctor doc : doctorDetailsService.findDoctorsBySpeciality(apiSpecialityService.findSpecialitiesByTitle(specialityTitle)))
            if (doc ==aua.getDoctor()){
                appointmentList.add(aua);
            }
        }
        return appointmentList;
    }



}
