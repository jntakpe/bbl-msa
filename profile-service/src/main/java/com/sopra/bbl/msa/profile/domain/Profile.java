package com.sopra.bbl.msa.profile.domain;

import com.sopra.bbl.msa.commons.jpa.IdentifiableEntity;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Entité représentant un profil utilisateur de l'application
 *
 * @author jntakpe
 */
@Entity
@NamedEntityGraph(name = "Profile.withNotifs", attributeNodes = @NamedAttributeNode("profileNotificationSettings"))
public class Profile extends IdentifiableEntity {

    @NotNull
    @Column(unique = true)
    private String login;

    @Email
    @NotNull
    @Column(unique = true)
    private String email;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "profile")
    private Set<ProfileNotificationSettings> profileNotificationSettings = new HashSet<>();

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

    public Set<ProfileNotificationSettings> getProfileNotificationSettings() {
        return profileNotificationSettings;
    }

    public void setProfileNotificationSettings(Set<ProfileNotificationSettings> profileNotificationSettings) {
        this.profileNotificationSettings = profileNotificationSettings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile) o;
        return Objects.equals(login, profile.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}
