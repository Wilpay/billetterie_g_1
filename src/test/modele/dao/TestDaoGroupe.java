/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.modele.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import modele.dao.DaoGroupe;
import modele.dao.Jdbc;
import modele.metier.Groupe;

/**
 *
 * @author btssio
 */
public class TestDaoGroupe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        java.sql.Connection cnx = null;

        try {
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_SelectUnique(1);
            System.out.println("Test1 effectué : sélection unique\n");
            test2_SelectMultiple();
            System.out.println("Test2 effectué : sélection multiple\n");
            test2_2_SelectMultiple("ON");
            System.out.println("Test2_2 effectué : sélection multiple avec filtrage sur le nom du Groupe\n");
            test3_Insert(99);
            System.out.println("Test3 effectué : insertion\n");
            test4_Update(99);
            System.out.println("Test4 effectué : mise à jour\n");
            test5_Delete(99);
            System.out.println("Test5 effectué : suppression\n");
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur de pilote JDBC : " + e);
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e);
        } finally {
            try {
                if (cnx != null) {
                    cnx.close();
                }
            } catch (SQLException e) {
                System.err.println("Erreur de fermeture de la connexion JDBC : " + e);
            }
        }

    }

    /**
     * Vérifie qu'une connexion peut être ouverte sur le SGBD
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void test0_Connexion() throws ClassNotFoundException, SQLException {
        Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql:", "//localhost/", "festival", "root", "joliverie");
//        Jdbc.creer("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:", "@localhost:1521:XE", "", "btssio", "btssio");
        Jdbc.getInstance().connecter();
        Connection cnx = Jdbc.getInstance().getConnexion();
    }

    /**
     * Affiche une adresse d'après son identifiant
     * @throws SQLException
     */
    public static void test1_SelectUnique(int idGroupe) throws SQLException {
        Groupe ceGroupe = DaoGroupe.selectOne(idGroupe);
        System.out.println("Groupe d'identifiant : "+idGroupe+" : "+ceGroupe.toString());
    }

    /**
     * Affiche toutes les villes
     * @throws SQLException
     */
    public static void test2_SelectMultiple() throws SQLException {
        List<Groupe> desGroupes = DaoGroupe.selectAll();
        System.out.println("Les adresses lues : "+desGroupes.toString());
    }
    /**
     * Affiche toutes les villes filtrées sur un nom de ville
     * @throws SQLException
     */
    public static void test2_2_SelectMultiple(String nom) throws SQLException {
        List<Groupe> desGroupes = DaoGroupe.selectAllByGroupe(nom);
        System.out.println("Les Groupes lues : "+desGroupes.toString());
    }

    /**
     * Ajoute un client 
     * @throws SQLException
     */
    public static void test3_Insert(int idGroupe) throws SQLException {
        Groupe unGroupe = new Groupe("1", "Groupe folklorique du Bachkortostan", null, null, 40, "Bachkirie", "O");
        int nb= DaoGroupe.insert(idGroupe, unGroupe);
        System.out.println("Un nouveau groupe a été insérée: "+nb);
        test1_SelectUnique(idGroupe);
    }

    /**
     * Modifie une adresse
     * @throws SQLException
     */
    public static void test4_Update(int idGroupe) throws SQLException {
         Groupe unGroupe = new Groupe("1", "Groupe folklorique du Bachkortostan", null, null, 40, "Bachkirie", "O");
        int nb= DaoGroupe.update(idGroupe, unGroupe);
        System.out.println("Un Groupe a été modifiée: "+nb);
        test1_SelectUnique(idGroupe);
    }

    /**
     * Supprime un enregistrement
     * @throws SQLException
     */
    public static void test5_Delete(int idGroupe) throws SQLException {
        int nb= DaoGroupe.delete(idGroupe);
        System.out.println("Un Groupe a été supprimée: "+nb);
        test2_SelectMultiple();
   }
    }
    

