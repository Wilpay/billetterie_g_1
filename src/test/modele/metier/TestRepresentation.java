/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.modele.metier;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

import modele.metier.Representation;

/**
 *
 * @author btssio
 */
public class TestRepresentation {
    public static void main(String[] args) {
        Representation representation, representation1, representation2;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        representation = new Representation("5", "2015-05-23","La Joliverie", "Groupe folklorique des Émirats", "18:15", "19:00");
        System.out.println(representation);
        System.out.println("\nTest n°2 : mutateurs");
        representation.setDate("2015-05-23");
        representation.setLieu("La Joliverie");
        representation.setGroupe("Groupe folklorique des Émirats");
        representation.setHeure_debut("18:15");
        representation.setHeure_fin("19:00");
        System.out.println(representation);
        representation1 = new Representation("1",null, null, null, null, null);
        System.out.println(representation1.equals(representation));
        representation2 = new Representation("2",null, null, null, null, null);
        System.out.println(representation1.equals(representation2));
    }
}
