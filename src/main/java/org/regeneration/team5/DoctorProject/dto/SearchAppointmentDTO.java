package org.regeneration.team5.DoctorProject.dto;

import java.security.Principal;
import java.sql.Date;

public class SearchAppointmentDTO {
    private String specialityTitle;
    private String from;
    private String to;

    public SearchAppointmentDTO(String from, String to, String specialityTitle) {
        this.from = from;
        this.to = to;
        this.specialityTitle = specialityTitle;
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

}
