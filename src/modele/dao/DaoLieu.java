/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.metier.lieu;

/**
 *
 * @author btssio
 */
public class DaoLieu {
            /**
     * Extraction d'une adresse, sur son identifiant
     * @param idLieu identifiant
     * @return objet Adresse
     * @throws SQLException 
     */
    public static lieu selectOne(int idLieu) throws SQLException {
        lieu unLieu = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM LIEU WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idLieu);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String id = rs.getString("id");
            String nom = rs.getString("nom");
            String adresse = rs.getString("adresse");
            int capaciteAccueil = rs.getInt("capaciteAccueil");
            unLieu = new lieu(id, nom, adresse, capaciteAccueil);
        }
        return unLieu;
    }

    /**
     * @return collection d'adresses
     * @throws SQLException 
     */
    public static List<lieu> selectAll() throws SQLException {
        List<lieu> lesLieu = new ArrayList<lieu>();
        lieu unLieu;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM LIEU";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String id = rs.getString("ID");
            String nom = rs.getString("NOM");
            String adresse = rs.getString("ADRESSE");
            int capaciteAccueil = rs.getInt("CAPACITE");
            unLieu = new lieu(id, nom, adresse, capaciteAccueil);
            lesLieu.add(unLieu);
        }
        return lesLieu;
    }
    
        /**
     * @return collection d'adresses
     * @throws SQLException 
     */
    public static List<lieu> selectAllByVille(String extraitLieuRepresentation) throws SQLException {
        List<lieu> lesLieu = new ArrayList<lieu>();
        lieu unLieu;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM LIEU WHERE NOM LIKE ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, "%"+extraitLieuRepresentation+"%");
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String id = rs.getString("ID");
            String nom = rs.getString("NOM");
            String adresse = rs.getString("ADRESSE");
            int capaciteAccueil = rs.getInt("CAPACITE");
            unLieu = new lieu(id, nom, adresse, capaciteAccueil);
            lesLieu.add(unLieu);
        }
        return lesLieu;
    }    

    /**

     * @return collection d'adresses
     * @throws SQLException 
     */
    public static List<lieu> selectAll(int cleTri, int ordreTri) throws SQLException {
        List<lieu> lesLieu = new ArrayList<lieu>();
        lieu unLieu;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM LIEU";
        switch (cleTri) {
            case 1: // Tri par Id
                requete += " ORDER BY ID";
                break;
            case 2: // Tri par nom
                requete += " ORDER BY NOM";
                break;
        }
        if (cleTri == 1 || cleTri == 2) {
            switch (ordreTri) {
                case 1: // Tri croissant
                    requete += " ASC";
                    break;
                case 2: // Tri décroissant
                    requete += " DESC";
                    break;
            }
        }
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
           String id = rs.getString("ID");
            String nom = rs.getString("NOM");
            String adresse = rs.getString("ADRESSE");
            int capaciteAccueil = rs.getInt("CAPACITE");
            unLieu = new lieu(id, nom, adresse, capaciteAccueil);
            lesLieu.add(unLieu);
        }
        return lesLieu;
    }

    public static int insert(int idLieu, lieu unLieu) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "INSERT INTO LIEU (ID, NOM, ADRESSE, CAPACITE) VALUES (?, ?, ?, ?)";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idLieu);
        pstmt.setString(2, unLieu.getId());
        pstmt.setString(3, unLieu.getNom());
        pstmt.setString(4, unLieu.getAdresse());
        pstmt.setInt(5, unLieu.getCapaciteAccueil());
        nb = pstmt.executeUpdate();
        return nb;
    }

    public static int update(int idLieu, lieu unLieu) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "UPDATE LIEU SET ID = ? , NOM = ? , ADRESSE = ? , CAPACITE = ?, WHERE ID = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idLieu);
        pstmt.setString(2, unLieu.getId());
        pstmt.setString(3, unLieu.getNom());
        pstmt.setString(4, unLieu.getAdresse());
        pstmt.setInt(5, unLieu.getCapaciteAccueil());;
        nb = pstmt.executeUpdate();
        return nb;
    }

    public static int delete(int idLieu) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "DELETE  FROM LIEU WHERE ID = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idLieu);
        nb = pstmt.executeUpdate();
        return nb;
    }
}
