package com.dette.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
// import lombok.ToString;

@Getter
@Setter
// @ToString
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "client")
public class Client extends AbstractEntity {
    public Client() {
    }

    @Column(length = 25, unique = true)
    private String surnom;
    @Column(length = 15, unique = true)
    private String telephone;
    @Column(length = 30, unique = true)
    private String adresse;

    @OneToMany(mappedBy = "clientD")
    private List<Dette> dettes = new ArrayList<>();

    public Client(String surnom, String telephone, String adresse) {
        this.surnom = surnom;
        this.telephone = telephone;
        this.adresse = adresse;
    }

    public void addDettes(Dette dette) {
        dettes.add(dette);
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", surnom=" + surnom + ", telephone=" + telephone + ", adresse=" + adresse
                + "]";
    }

    // @Transient POUR NE PAS PERSISTER EN BD
    // create-drop
}
