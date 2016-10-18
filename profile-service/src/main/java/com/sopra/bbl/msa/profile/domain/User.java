package com.sopra.bbl.msa.profile.domain;

import com.sopra.bbl.msa.commons.jpa.IdentifiableEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

/**
 * Entité représentant un utilisateur de l'application
 *
 * @author jntakpe
 */
@Entity
public class User extends IdentifiableEntity {

    @Column(unique = true)
    private String login;

    @Column(unique = true)
    private String email;

    private String firstName;

    private String lastName;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}
