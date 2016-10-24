package com.sopra.bbl.msa.event.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sopra.bbl.msa.commons.jpa.IdentifiableEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Entité décrivant un particant à une formation
 *
 * @author jntakpe
 */
@Entity
public class Attendee extends IdentifiableEntity {

    private String login;

    @JsonIgnore
    @ManyToMany(mappedBy = "attendees")
    private Set<Event> events = new HashSet<>();

    public Attendee() {
    }

    public Attendee(String login) {
        setLogin(login);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Attendee)) {
            return false;
        }
        Attendee attendee = (Attendee) o;
        return Objects.equals(login, attendee.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("login", login)
                .toString();
    }
}
