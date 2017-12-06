/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.modele.metier;

import modele.metier.Groupe;

/**
 *
 * @author btssio
 */
public class TestGroupe {
    public static void main(String[] args) {
        Groupe gpr, gpr1, gpr2;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        gpr = new Groupe("1", "Groupe folklorique du Bachkortostan", null, null, 40, "Bachkirie", "O");
        System.out.println(gpr);
        System.out.println("\nTest n°2 : mutateurs");
        gpr.setNom("Groupe folklorique du Bachkortostan");
        gpr.setIdentite(null);
        gpr.setAdresse(null);
        gpr.setNbPers(40);
        gpr.setNomPays("Bachkirie");
        gpr.setHebergement("O");
        System.out.println(gpr);
        gpr1 = new Groupe("1",null, null, null, 0, null, null);
        System.out.println(gpr1.equals(gpr));
        gpr2 = new Groupe("2",null, null, null, 0, null, null);
        System.out.println(gpr1.equals(gpr2));
    }
}
