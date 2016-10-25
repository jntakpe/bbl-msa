package com.sopra.bbl.msa.notifications.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * DTO contenant les informations permettant de notifier un utilisateur
 *
 * @author jntakpe
 */
public class ProfileNotificationDTO {

    private String login;

    private String email;

    private String firstName;

    private String lastName;

    private Set<NotificationType> notifications = new HashSet<NotificationType>();

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<NotificationType> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<NotificationType> notifications) {
        this.notifications = notifications;
    }
}
