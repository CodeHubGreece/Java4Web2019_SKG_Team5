package org.regeneration.team5.DoctorProject.dto;

import org.springframework.stereotype.Component;

@Component
public class AppointmentDTO {

    //private Integer appointmentId;
    private String specialityTitle;
    private String amka;
    private int doctorId;
    private String date;
    private String time;
    private String symptoms;
    private String info;

    public AppointmentDTO(){

    }

    public AppointmentDTO(String specialityTitle, String amka, int doctorId, String date, String time, String symptoms, String info) {
        this.specialityTitle = specialityTitle;
        //this.appointmentId = appointmentId;
        this.amka = amka;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
        this.symptoms = symptoms;
        this.info = info;
    }

//    public Integer getAppointmentId() {
//        return appointmentId;
//    }
//
//    public void setAppointmentId(Integer appointmentId) {
//        this.appointmentId = appointmentId;
//    }

    public String getAmka() {
        return amka;
    }

    public void setAmka(String amka) {
        this.amka = amka;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getSpecialityTitle() {
        return specialityTitle;
    }

    public void setSpecialityTitle(String specialityTitle) {
        this.specialityTitle = specialityTitle;
    }
}
