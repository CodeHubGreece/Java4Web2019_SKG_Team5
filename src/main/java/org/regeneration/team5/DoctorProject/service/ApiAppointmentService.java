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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
    //private User user;
    private Principal principal;
    private  ApiAppointmentService apiAppointmentService;

    public ApiAppointmentService(@Autowired AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    public Appointment deleteAppointment(Integer id){
        Appointment deletedAppointment = appointmentRepository.findByAppointmentId(id);
        appointmentRepository.delete(deletedAppointment);
        return deletedAppointment;
    }
    public List<Appointment> findAll(){
        return appointmentRepository.findAll();
    }

    public Appointment findById(int id){
        return appointmentRepository.findByAppointmentId(id);
    }

    public List<Appointment> findByCitizen(Citizen citizen){
        return appointmentRepository.findByCitizen(citizen);
    }
    public List<Appointment> findByDoctor(Doctor doctor){
        return appointmentRepository.findByDoctor(doctor);
    }

    public Appointment setNewAppointment(AppointmentDTO appointmentDTO, User user) throws ParseException {
        SimpleDateFormat formatter6=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Appointment newAppointment = new Appointment();
        LocalDate localDate = LocalDate.now();
        String dateApp=appointmentDTO.getDate();
        if(dateApp.compareTo(String.valueOf(localDate))>0) {
            //newAppointment.setAppointmentId(appointmentDTO.getAppointmentId());
            newAppointment.setCitizen(citizenRepository.findCitizenByUser(user));
            newAppointment.setDoctor(doctorRepository.findByDoctorId(appointmentDTO.getDoctorId()));
            //newAppointment.setCreatedAt(Instant.parse(appointmentDTO.getDate().concat(" ").concat(appointmentDTO.getTime())));
            newAppointment.setCreatedAt(formatter6.parse(appointmentDTO.getDate().concat(" ").concat(appointmentDTO.getTime()).concat(":00")));
            newAppointment.setInfo(appointmentDTO.getInfo());
            newAppointment.setSymptoms(appointmentDTO.getSymptoms());
            appointmentRepository.save(newAppointment);
        }else
        {
            System.out.println("Not ");
        }
        return newAppointment;
    }


  //  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd")
    public Appointment updateAppointment(AppointmentDTO upAppointmentDTO, User user, Integer id ) throws ParseException {
        Appointment oldAppointment = appointmentRepository.findByAppointmentId(id);
        LocalDate localDate = LocalDate.now();
        SimpleDateFormat oldDate = new SimpleDateFormat("yyyy-MM-dd");
        String dateApp= upAppointmentDTO.getDate();
        if(dateApp.compareTo(String.valueOf(localDate))>=0){
        oldAppointment.setCitizen(citizenRepository.findCitizenByUser(user));
            oldAppointment.setDoctor(doctorRepository.findByDoctorId(upAppointmentDTO.getDoctorId()));
            oldAppointment.setCreatedAt(oldDate.parse(upAppointmentDTO.getDate().concat(" ").concat(upAppointmentDTO.getTime()).concat(":00")));
            oldAppointment.setInfo(upAppointmentDTO.getInfo());
            oldAppointment.setSymptoms(upAppointmentDTO.getSymptoms());
            appointmentRepository.save(oldAppointment);
        }else {
            System.out.println("Not");
       }
        return oldAppointment;
    }

}






