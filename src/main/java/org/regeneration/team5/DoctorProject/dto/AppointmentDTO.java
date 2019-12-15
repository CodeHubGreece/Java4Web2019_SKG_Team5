package org.regeneration.team5.DoctorProject.dto;

import org.springframework.stereotype.Component;

@Component
public class AppointmentDTO {

    private int citizenId;
    private int doctorId;
    private String date;
    private String time;
    private String symptoms;
    private String info;

    public AppointmentDTO(){

    }

    public AppointmentDTO(int citizenId, int doctorId, String date, String time, String symptoms, String info) {
        this.citizenId = citizenId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
        this.symptoms = symptoms;
        this.info = info;
    }

    public int getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(int citizenId) {
        this.citizenId = citizenId;
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
}
