/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.modele.metier;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.dao.Jdbc;
import modele.metier.Representation;
import test.modele.dao.TestDaoRepresentation;

/**
 *
 * @author btssio
 */
public class TestRepresentation {
    public static void main(String args[]){
        try {
            Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql:", "//localhost/", "festival", "root", "joliverie");
            Jdbc.getInstance().connecter();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestDaoRepresentation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TestDaoRepresentation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        System.out.println("---------------------------------------------------");
        System.out.println("test de création d'un objet de type representation:");
        System.out.println("---------------------------------------------------");
        Representation laRepresentation = new Representation(1,"2018-06-11","Parc Hellfest, Clisson ","Hellfest 2018","14:00:00","23:00:00",5000);
        System.out.println(laRepresentation.toString());
        System.out.println("test réussi");
    }
}