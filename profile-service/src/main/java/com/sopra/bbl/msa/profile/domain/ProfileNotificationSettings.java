package com.sopra.bbl.msa.profile.domain;

import com.sopra.bbl.msa.commons.jpa.IdentifiableEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

/**
 * Entité paramétrant les {@link Notification} pour chaque {@link Profile}
 *
 * @author jntakpe
 */
@Entity
public class ProfileNotificationSettings extends IdentifiableEntity {

    private boolean accept;

    @ManyToOne(optional = false)
    private Profile profile;

    @ManyToOne(optional = false)
    private Notification notification;

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
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
        if (!(o instanceof ProfileNotificationSettings)) {
            return false;
        }
        ProfileNotificationSettings that = (ProfileNotificationSettings) o;
        return Objects.equals(profile, that.profile) &&
                Objects.equals(notification, that.notification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profile, notification);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("accept", accept)
                .append("user", profile)
                .append("notification", notification)
                .toString();
    }
}
