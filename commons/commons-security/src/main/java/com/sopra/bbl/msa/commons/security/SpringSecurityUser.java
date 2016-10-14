package com.sopra.bbl.msa.commons.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Objects;

/**
 * {@link User} utilisé par Spring Security pour garder les informations sur l'utilisateur connecté
 *
 * @author jntakpe
 */
public class SpringSecurityUser extends User {

    public static final String ROLE_PREFIX = "ROLE_";

    private Long id;

    private String email;

    public SpringSecurityUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Long id, String email) {
        super(username, password, authorities);
        this.id = id;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        SpringSecurityUser user = (SpringSecurityUser) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

}
