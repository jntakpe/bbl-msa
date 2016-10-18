package com.sopra.bbl.msa.profile.domain;

import com.sopra.bbl.msa.commons.jpa.IdentifiableEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import java.util.Objects;

/**
 * Entité représentant une notification
 *
 * @author jntakpe
 */
@Entity
public class Notification extends IdentifiableEntity {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Notification)) {
            return false;
        }
        Notification that = (Notification) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("type", type)
                .toString();
    }
}
