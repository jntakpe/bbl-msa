package com.sopra.bbl.msa.profile.dto;

import com.sopra.bbl.msa.profile.domain.NotificationType;
import com.sopra.bbl.msa.profile.domain.Profile;
import com.sopra.bbl.msa.profile.domain.ProfileNotificationSettings;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

    public ProfileNotificationDTO() {
    }

    public ProfileNotificationDTO(Profile profile) {
        this.login = profile.getLogin();
        this.email = profile.getEmail();
        this.firstName = profile.getFirstName();
        this.lastName = profile.getLastName();
        this.notifications = profile.getProfileNotificationSettings().stream()
                .filter(ProfileNotificationSettings::isAccept)
                .map(n -> n.getNotification().getType())
                .collect(Collectors.toSet());
    }

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
