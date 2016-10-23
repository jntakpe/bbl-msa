package com.sopra.bbl.msa.notifications.dto;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * DTO représentant l'enregistrement à un événement
 *
 * @author jntakpe
 */
public class EventRegistrationDTO {

    @NotNull
    private String to;

    @NotNull
    private String name;

    @NotNull
    private String type;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate start;

    private Integer duration;

    private ChronoUnit durationUnit;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate strart) {
        this.start = strart;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public ChronoUnit getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(ChronoUnit durationUnit) {
        this.durationUnit = durationUnit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("to", to)
                .append("name", name)
                .append("type", type)
                .append("start", start)
                .append("duration", duration)
                .append("durationUnit", durationUnit)
                .toString();
    }
}
