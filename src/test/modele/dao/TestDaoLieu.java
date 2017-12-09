/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.modele.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import modele.dao.DaoLieu;
import modele.dao.Jdbc;
import modele.metier.lieu;

/**
 *
 * @author btssio
 */
public class TestDaoLieu {

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
            System.out.println("Test2_2 effectué : sélection multiple avec filtrage sur le nom du Lieu\n");
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
    public static void test1_SelectUnique(int idLieu) throws SQLException {
        lieu ceLieu = DaoLieu.selectOne(idLieu);
        System.out.println("Lieu d'identifiant : "+idLieu+" : "+ceLieu.toString());
    }

    /**
     * Affiche toutes les villes
     * @throws SQLException
     */
    public static void test2_SelectMultiple() throws SQLException {
        List<lieu> desLieux = DaoLieu.selectAll();
        System.out.println("Les adresses lues : "+desLieux.toString());
    }
    /**
     * Affiche toutes les villes filtrées sur un nom de ville
     * @throws SQLException
     */
    public static void test2_2_SelectMultiple(String nom) throws SQLException {
        List<lieu> desLieux = DaoLieu.selectAllByVille(nom);
        System.out.println("Les Lieux lues : "+desLieux.toString());
    }

    /**
     * Ajoute un client 
     * @throws SQLException
     */
    public static void test3_Insert(int idLieu) throws SQLException {
        lieu unLieu = new lieu("1", "Joliverie","141 Route de Clisson", 3000);
        int nb= DaoLieu.insert(idLieu, unLieu);
        System.out.println("Un nouveau lieu a été insérée: "+nb);
        test1_SelectUnique(idLieu);
    }

    /**
     * Modifie une adresse
     * @throws SQLException
     */
    public static void test4_Update(int idLieu) throws SQLException {
         lieu unLieu = new lieu("1", "Joliverie","141 Route de Clisson", 3000);
        int nb= DaoLieu.update(idLieu, unLieu);
        System.out.println("Un lieu a été modifiée: "+nb);
        test1_SelectUnique(idLieu);
    }

    /**
     * Supprime un enregistrement
     * @throws SQLException
     */
    public static void test5_Delete(int idLieu) throws SQLException {
        int nb= DaoLieu.delete(idLieu);
        System.out.println("Un lieu a été supprimée: "+nb);
        test2_SelectMultiple();
   }
    }
    

