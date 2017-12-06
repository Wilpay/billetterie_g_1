/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;



/**
 *
 * @author btssio
 */
public class Groupe {

    
      private String id;
      private String nom;
      private String identite;
      private String adresse;
      private int nbPers;
      private String nomPays;
      private String hebergement;
      
      
      public Groupe(String id, String nom, String identite, String adresse, int nbPers, String nomPays, String hebergement) {
        this.id = id;
        this.nom = nom;
        this.identite = identite;
        this.adresse = adresse;
        this.nbPers = nbPers;
        this.nomPays = nomPays;
        this.hebergement = hebergement;

    }

    @Override
    public String toString() {
        return "Groupe{" + "id=" + id + ", nom=" + nom + ", identite=" + identite + ", adresse=" + adresse + ", nbPers=" + nbPers + ", nomPays=" + nomPays + ", hebergement=" + hebergement + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIdentite() {
        return identite;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNbPers() {
        return nbPers;
    }

    public void setNbPers(int nbPers) {
        this.nbPers = nbPers;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }

    public String getHebergement() {
        return hebergement;
    }

    public void setHebergement(String hebergement) {
        this.hebergement = hebergement;
    }
      
      
}
