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
import modele.metier.Groupe;

/**
 *
 * @author btssio
 */
public class DaoGroupe {
    /**
     * Extraction d'une adresse, sur son identifiant
     * @param idGroupe identifiant
     * @return objet Adresse
     * @throws SQLException 
     */
    public static Groupe selectOne(int idGroupe) throws SQLException {
        Groupe unGroupe = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Groupe WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idGroupe);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String id = rs.getString("ID");
            String nom = rs.getString("NOM");
            String identite = rs.getString("IDENTITERESPONSABLE");
            String adresse = rs.getString("ADRESSEPOSTALE");
            int nbPers = rs.getInt("NOMBREPERSONNES");
            String nomPays = rs.getString("NOMPAYS");
            String hebergement = rs.getString("HEBERGEMENT");
            unGroupe = new Groupe(id, nom, identite, adresse, nbPers, nomPays, hebergement);
        }
        return unGroupe;
    }

    /**
     * Extraction de toutes les adresses
     * @return collection d'adresses
     * @throws SQLException 
     */
    public static List<Groupe> selectAll() throws SQLException {
        List<Groupe> lesGroupes = new ArrayList<Groupe>();
        Groupe unGroupe;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Groupe";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String id = rs.getString("ID");
            String nom = rs.getString("NOM");
            String identite = rs.getString("IDENTITERESPONSABLE");
            String adresse = rs.getString("ADRESSEPOSTALE");
            int nbPers = rs.getInt("NOMBREPERSONNES");
            String nomPays = rs.getString("NOMPAYS");
            String hebergement = rs.getString("HEBERGEMENT");
            unGroupe = new Groupe(id, nom, identite, adresse, nbPers, nomPays, hebergement);
            lesGroupes.add(unGroupe);
        }
        return lesGroupes;
    }
    
        /**
     * Extraction de toutes les adresses dont le nom de ville contient la chaîne recherchée
     * @param extraitNomGroupe
     * @return collection d'adresses
     * @throws SQLException 
     */
    public static List<Groupe> selectAllByGroupe(String extraitNomGroupe) throws SQLException {
        List<Groupe> lesGroupes = new ArrayList<Groupe>();
        Groupe unGroupe;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Groupe WHERE NOMPAYS LIKE ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, "%"+extraitNomGroupe+"%");
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String id = rs.getString("ID");
            String nom = rs.getString("NOM");
            String identite = rs.getString("IDENTITERESPONSABLE");
            String adresse = rs.getString("ADRESSEPOSTALE");
            int nbPers = rs.getInt("NOMBREPERSONNES");
            String nomPays = rs.getString("NOMPAYS");
            String hebergement = rs.getString("HEBERGEMENT");
            unGroupe = new Groupe(id, nom, identite, adresse, nbPers, nomPays, hebergement);
            lesGroupes.add(unGroupe);
        }
        return lesGroupes;
    }    

    /**
     * Extraction de toutes les adresses, ordonnées
     * @param cleTri 1=>ID ; 2=>VILLE
     * @param ordreTri 1=>ASC ; 2=>DESC
     * @return collection d'adresses
     * @throws SQLException 
     */
    public static List<Groupe> selectAll(int cleTri, int ordreTri) throws SQLException {
        List<Groupe> lesGroupes = new ArrayList<Groupe>();
        Groupe unGroupe;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM GROUPE";
        switch (cleTri) {
            case 1: // Tri par Id
                requete += " ORDER BY ID";
                break;
            case 2: // Tri par ville
                requete += " ORDER BY VILLE";
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
            String identite = rs.getString("IDENTITERESPONSABLE");
            String adresse = rs.getString("ADRESSEPOSTALE");
            int nbPers = rs.getInt("NOMBREPERSONNES");
            String nomPays = rs.getString("NOMPAYS");
            String hebergement = rs.getString("HEBERGEMENT");
            unGroupe = new Groupe(id, nom, identite, adresse, nbPers, nomPays, hebergement);
            lesGroupes.add(unGroupe);
        }
        return lesGroupes;
    }

    public static int insert(int idGroupe, Groupe unGroupe) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "INSERT INTO GROUPE (ID, NOM, IDENTITERESPONSABLE, ADRESSEPOSTALE, NOMBREPERSONNES, NOMPAYS, HEBERGEMENT) VALUES (?, ?, ?, ?, ?, ?, ?)";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idGroupe);
        pstmt.setString(2, unGroupe.getNom());
        pstmt.setString(3, unGroupe.getIdentite());
        pstmt.setString(4, unGroupe.getAdresse());
        pstmt.setInt(5, unGroupe.getNbPers());
        pstmt.setString(6, unGroupe.getNomPays());
        pstmt.setString(7, unGroupe.getHebergement());
        nb = pstmt.executeUpdate();
        return nb;
    }

    public static int update(int idGroupe, Groupe unGroupe) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "UPDATE GROUPE SET NOM = ? , IDENTITERESPONSABLE = ? , ADRESSEPOSTALE = ? , NOMBREPERSONNES = ? , NOMPAYS = ? , HEBERGEMENT = ? WHERE ID = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(2, unGroupe.getNom());
        pstmt.setString(3, unGroupe.getIdentite());
        pstmt.setString(4, unGroupe.getAdresse());
        pstmt.setInt(5, unGroupe.getNbPers());
        pstmt.setString(6, unGroupe.getNomPays());
        pstmt.setString(7, unGroupe.getHebergement());
        pstmt.setInt(8, idGroupe);
        nb = pstmt.executeUpdate();
        return nb;
    }

    public static int delete(int idGroupe) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "DELETE  FROM GROUPE WHERE ID = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idGroupe);
        nb = pstmt.executeUpdate();
        return nb;
    }

    
}
