package com.sopra.bbl.msa.event.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * DTO représentant l'enregistrement à un événement
 *
 * @author jntakpe
 */
public class RegistrationDTO {

    private String eventName;

    private String username;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String eventName, String username) {
        this.eventName = eventName;
        this.username = username;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("eventName", eventName)
                .append("username", username)
                .toString();
    }
}
