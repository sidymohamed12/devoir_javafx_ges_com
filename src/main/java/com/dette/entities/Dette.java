package com.dette.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "dette")
public class Dette extends AbstractEntity {

    private Double montant;
    private Double montantVerser;

    @Transient
    private Double montantRestant;

    public Double getMontantRestant() {
        return (this.montant - this.montantVerser);
    }

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client clientD;

    @OneToMany(mappedBy = "dette")
    private List<Detail> details = new ArrayList<>();

    public void addDetail(Detail detail) {
        details.add(detail);
    }

    @Override
    public String toString() {
        return "Dette [id=" + id + ", montant=" + montant + ", montantVerser=" + montantVerser + ", montantRestant="
                + montantRestant
                + ", date=" + date + ", clientD=" + clientD + "]";
    }

}
