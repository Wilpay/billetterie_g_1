/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.modele.metier;

import modele.metier.lieu;

/**
 *
 * @author btssio
 */
public class TestLieu {
    public static void main(String[] args) {
        lieu lieu, lieu1, lieu2;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        lieu = new lieu("1", "Joliverie","141 Route de Clisson", 3000);
        System.out.println(lieu);
        System.out.println("\nTest n°2 : mutateurs");
        lieu.setNom("Joliverie");
        lieu.setAdresse("141 Route de Clisson");
        lieu.setCapaciteAccueil(3000);
        
        System.out.println(lieu);
        lieu1 = new lieu("1",null, null, 0);
        System.out.println(lieu1.equals(lieu));
        lieu2 = new lieu("2",null, null, 0);
        System.out.println(lieu1.equals(lieu2));
    }
}
