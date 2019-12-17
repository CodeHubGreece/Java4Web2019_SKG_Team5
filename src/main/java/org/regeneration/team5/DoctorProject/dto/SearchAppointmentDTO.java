package org.regeneration.team5.DoctorProject.dto;

import java.security.Principal;
import java.sql.Date;

public class SearchAppointmentDTO {
    private String from;
    private String to;
    private String specialityTitle;
    private String info;
    private int doctorId;

    public SearchAppointmentDTO(String from, String to, String specialityTitle, String info, int doctorId) {
        this.from = from;
        this.to = to;
        this.specialityTitle = specialityTitle;
        this.info = info;
        this.doctorId = doctorId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSpecialityTitle() {
        return specialityTitle;
    }

    public void setSpecialityTitle(String specialityTitle) {
        this.specialityTitle = specialityTitle;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
}
