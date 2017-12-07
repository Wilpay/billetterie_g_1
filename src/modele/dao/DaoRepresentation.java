/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.DateFormatter;
import modele.metier.Representation;

/**
 *
 * @author btssio
 */
public class DaoRepresentation {
        /**
     * Extraction d'une adresse, sur son identifiant
     * @param idRepresentation identifiant
     * @return objet Adresse
     * @throws SQLException 
     */
    public static Representation selectOne(int idRepresentation) throws SQLException {
        Representation uneRepresentation = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Representation WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idRepresentation);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String id = rs.getString("id_rep");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String date = rs.getString("date_rep");
            String lieu = rs.getString("id_lieu");
            String groupe = rs.getString("id_groupe");
            String heure_debut = rs.getString("heure_deb");
            String heure_fin = rs.getString("heure_fin");
            uneRepresentation = new Representation(id, date, lieu, groupe, heure_debut, heure_fin);
        }
        return uneRepresentation;
    }

    /**
     * @return collection d'adresses
     * @throws SQLException 
     */
    public static List<Representation> selectAll() throws SQLException {
        List<Representation> lesRepresentation = new ArrayList<Representation>();
        Representation uneRepresentation;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT g.nom, l.nom FROM REPRESENTATION r\n" +
                            "INNER JOIN  GROUPE g ON r.id_groupe = g.id\n" +
                                    "INNER JOIN LIEU l ON r.id_lieu = l.id";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String id = rs.getString("id_rep");
            String date = rs.getString("date_rep");
            String lieu = rs.getString("id_lieu");
            String groupe = rs.getString("id_groupe");
            String heure_debut = rs.getString("heure_deb");
            String heure_fin = rs.getString("heure_fin");
            uneRepresentation = new Representation(id, date, lieu, groupe, heure_debut, heure_fin);
            lesRepresentation.add(uneRepresentation);
        }
        return lesRepresentation;
    }
    
        /**
     * @return collection d'adresses
     * @throws SQLException 
     */
    public static List<Representation> selectAllByVille(String extraitLieuRepresentation) throws SQLException {
        List<Representation> lesRepresentation = new ArrayList<Representation>();
        Representation uneRepresentation;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM REPRESENTATION WHERE ID_LIEU LIKE ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, "%"+extraitLieuRepresentation+"%");
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String id = rs.getString("id_rep");
            String date = rs.getString("date_rep");
            String lieu = rs.getString("id_lieu");
            String groupe = rs.getString("id_groupe");
            String heure_debut = rs.getString("heure_deb");
            String heure_fin = rs.getString("heure_fin");
            uneRepresentation = new Representation(id, date, lieu, groupe, heure_debut, heure_fin);
            lesRepresentation.add(uneRepresentation);
        }
        return lesRepresentation;
    }    

    /**

     * @return collection d'adresses
     * @throws SQLException 
     */
    public static List<Representation> selectAll(int cleTri, int ordreTri) throws SQLException {
        List<Representation> lesRepresentation = new ArrayList<Representation>();
        Representation uneRepresentation;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM REPRESENTATION";
        switch (cleTri) {
            case 1: // Tri par Id
                requete += " ORDER BY ID_REP";
                break;
            case 2: // Tri par ville
                requete += " ORDER BY ID_LIEU";
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
            String id = rs.getString("id_rep");
            String date = rs.getString("date_rep");
            String lieu = rs.getString("id_lieu");
            String groupe = rs.getString("id_group");
            String heure_debut = rs.getString("heure_deb");
            String heure_fin = rs.getString("heure_fin");
            uneRepresentation = new Representation(id, date, lieu, groupe, heure_debut, heure_fin);
            lesRepresentation.add(uneRepresentation);
        }
        return lesRepresentation;
    }

    public static int insert(int idRepresentation, Representation uneRepresentation) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "INSERT INTO REPRESENTATION (ID_REP, DATE_REP, ID_LIEU, ID_GROUPE, HEURE_DEB, HEURE_FIN) VALUES (?, ?, ?, ?, ?, ?, ?)";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idRepresentation);
        pstmt.setString(2, uneRepresentation.getId());
        pstmt.setString(3, uneRepresentation.getDate());
        pstmt.setString(4, uneRepresentation.getLieu());
        pstmt.setString(5, uneRepresentation.getGroupe());
        pstmt.setString(6, uneRepresentation.getHeure_debut());
        pstmt.setString(7, uneRepresentation.getHeure_fin());
        nb = pstmt.executeUpdate();
        return nb;
    }

    public static int update(int idRepresentation, Representation uneRepresentation) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "UPDATE REPRESENTATION SET ID = ? , DATE = ? , LIEU = ? , GROUPE = ? , HEURE_DEB = ? , HEURE_FIN = ? WHERE ID = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(2, uneRepresentation.getId());
        pstmt.setString(3, uneRepresentation.getDate());
        pstmt.setString(4, uneRepresentation.getLieu());
        pstmt.setString(5, uneRepresentation.getGroupe());
        pstmt.setString(6, uneRepresentation.getHeure_debut());
        pstmt.setString(7, uneRepresentation.getHeure_fin());
        pstmt.setInt(8, idRepresentation);
        nb = pstmt.executeUpdate();
        return nb;
    }

    public static int delete(int idRepresentation) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "DELETE  FROM REPRESENTATION WHERE ID = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idRepresentation);
        nb = pstmt.executeUpdate();
        return nb;
    }

}
