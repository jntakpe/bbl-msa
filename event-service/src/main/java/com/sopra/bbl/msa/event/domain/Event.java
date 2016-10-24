package com.sopra.bbl.msa.event.domain;


import com.sopra.bbl.msa.commons.jpa.IdentifiableEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Entité représentant un événement
 *
 * @author jntakpe
 */
@Entity
public class Event extends IdentifiableEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private EventType type;

    private LocalDate start;

    private Integer duration;

    @Enumerated(EnumType.STRING)
    private ChronoUnit durationUnit;

    @ManyToMany
    private Set<Attendee> attendees = new HashSet<>();

    public Event() {
    }

    public Event(String name, EventType type, LocalDate start, Integer duration, ChronoUnit durationUnit) {
        setName(name);
        setType(type);
        setStart(start);
        setDuration(duration);
        setDurationUnit(durationUnit);
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

    public Set<Attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(Set<Attendee> attendees) {
        this.attendees = attendees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Event)) {
            return false;
        }
        Event event = (Event) o;
        return Objects.equals(name, event.name) &&
                type == event.type &&
                Objects.equals(start, event.start);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, start);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("type", type)
                .append("strart", start)
                .append("duration", duration)
                .append("durationUnit", durationUnit)
                .toString();
    }
}
