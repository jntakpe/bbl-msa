package com.sopra.bbl.msa.commons.jpa;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Contient la clé primaire d'une entité
 *
 * @author jntakpe
 */
@MappedSuperclass
public abstract class IdentifiableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
