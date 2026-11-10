package com.example.studentapp.entity;

import java.io.Serializable;

public class Survey implements Serializable {
    private String heardFrom;
    private String wantsUpdates;
    private String emailOffers;
    private String contactVia;

    public Survey() {
        heardFrom = "";
        wantsUpdates = "";
        emailOffers = "";
        contactVia = "";
    }

    public Survey(String heardFrom, String wantsUpdates, String emailOffers, String contactVia) {
        this.heardFrom = heardFrom;
        this.wantsUpdates = wantsUpdates;
        this.emailOffers = emailOffers;
        this.contactVia = contactVia;
    }

    public String getHeardFrom() {
        return heardFrom;
    }

    public void setHeardFrom(String heardFrom) {
        this.heardFrom = heardFrom;
    }

    public String getWantsUpdates() {
        return wantsUpdates;
    }

    public void setWantsUpdates(String wantsUpdates) {
        this.wantsUpdates = wantsUpdates;
    }

    public String getEmailOffers() {
        return emailOffers;
    }

    public void setEmailOffers(String emailOffers) {
        this.emailOffers = emailOffers;
    }

    public String getContactVia() {
        return contactVia;
    }

    public void setContactVia(String contactVia) {
        this.contactVia = contactVia;
    }
}