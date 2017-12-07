/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author btssio
 */
public class Representation {
    
    private String id;
    private LocalDate date;
    private String lieu;
    private String groupe;
    private LocalTime heure_debut;
    private LocalTime heure_fin;
    
    public Representation(String id, LocalDate date, String lieu, String groupe, LocalTime heure_debut, LocalTime heure_fin) {
        this.id = id;
        this.date = date;
        this.lieu = lieu;
        this.groupe = groupe;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;

    }

    @Override
    public String toString() {
        return "Representation{" + "id=" + id + ", date=" + date + ", lieu=" + lieu + ", groupe=" + groupe + ", heure_debut=" + heure_debut + ", heure_fin=" + heure_fin + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public LocalTime getHeure_debut() {
        return heure_debut;
    }

    public void setHeure_debut(LocalTime heure_debut) {
        this.heure_debut = heure_debut;
    }

    public LocalTime getHeure_fin() {
        return heure_fin;
    }

    public void setHeure_fin(LocalTime heure_fin) {
        this.heure_fin = heure_fin;
    }
    
    
}
