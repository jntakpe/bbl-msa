package com.sopra.bbl.msa.event.dto;


import com.sopra.bbl.msa.event.domain.Event;
import com.sopra.bbl.msa.event.domain.EventType;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * DTO représentant l'enregistrement à un événement
 *
 * @author jntakpe
 */
public class EventRegistrationDTO {

    private String to;

    private String name;

    private EventType type;

    private LocalDate start;

    private Integer duration;

    private ChronoUnit durationUnit;

    public EventRegistrationDTO() {
    }

    public EventRegistrationDTO(Event event, String to) {
        setName(event.getName());
        setType(event.getType());
        setStart(event.getStart());
        setDuration(event.getDuration());
        setDurationUnit(event.getDurationUnit());
        setTo(to);
    }

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

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
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
                .append("strart", start)
                .append("duration", duration)
                .append("durationUnit", durationUnit)
                .toString();
    }
}
