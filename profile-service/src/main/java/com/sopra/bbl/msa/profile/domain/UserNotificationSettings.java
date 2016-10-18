package com.sopra.bbl.msa.profile.domain;

import com.sopra.bbl.msa.commons.jpa.IdentifiableEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

/**
 * Entité paramétrant les {@link Notification} pour chaque {@link User}
 *
 * @author jntakpe
 */
@Entity
public class UserNotificationSettings extends IdentifiableEntity {

    private boolean accept;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Notification notification;

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserNotificationSettings)) {
            return false;
        }
        UserNotificationSettings that = (UserNotificationSettings) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(notification, that.notification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, notification);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("accept", accept)
                .append("user", user)
                .append("notification", notification)
                .toString();
    }
}
