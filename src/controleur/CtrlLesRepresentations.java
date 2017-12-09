/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import modele.dao.DaoRepresentation;
import modele.metier.Representation;
import vue.VuePrincipale;

/**
 *
 * @author btssio
 */
public class CtrlLesRepresentations implements WindowListener {
     private VuePrincipale vue; // LA VUE
     
     public CtrlLesRepresentations(VuePrincipale vue) {
        this.vue = vue;
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
        // le controleur écoute le bouton jButtonRechercher de sa vue
        // préparer l'état iniitial de la vue
        List<Representation> lesRepresentations = null;
        try {
            lesRepresentations = DaoRepresentation.selectAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlLesRepresentations - échec de sélection des Representations");
        }
        afficherLesRepresentations(lesRepresentations);
    }
     
     // contrôle de la vue
    /**
     * Remplir le composant JTable avec les groupes
     *
     * @param desRepresentations liste des adresses à afficher
     */
    private final void afficherLesRepresentations(List<Representation> desRepresentations) {
        getVue().getModeleTableRepresentation().setRowCount(0);
        String[] titresColonnes = {"Lieu", "Groupe", "date","heureDeb","heureFin"};
        getVue().getModeleTableRepresentation().setColumnIdentifiers(titresColonnes);
        

        
        String[] ligneDonnees = new String[5];
        
        for (Representation uneRepresentation : desRepresentations) {
            ligneDonnees[0] = uneRepresentation.getLieu();
            ligneDonnees[1] = uneRepresentation.getGroupe();
            ligneDonnees[2] = uneRepresentation.getDate();
            ligneDonnees[3] = uneRepresentation.getHeure_debut();
            ligneDonnees[4] = uneRepresentation.getHeure_fin();
            getVue().getModeleTableRepresentation().addRow(ligneDonnees);            
        }       
    }
    
    /**
     * Quitter l'application, après demande de confirmation
     */
    private void quitter() {
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(getVue(), "Quitter l'application\nEtes-vous sûr(e) ?", "festival", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            System.exit(0);
        }
    }
    
    // ACCESSEURS et MUTATEURS
    public VuePrincipale getVue() {
        return vue;
    }
    
    public void setVue(VuePrincipale vue) {
        this.vue = vue;
    }

    @Override
    public void windowOpened(WindowEvent e) {
       }

    @Override
    public void windowClosing(WindowEvent e) {
        quitter();
        }

    @Override
    public void windowClosed(WindowEvent e) {
        }

    @Override
    public void windowIconified(WindowEvent e) {
        }

    @Override
    public void windowDeiconified(WindowEvent e) {
        }

    @Override
    public void windowActivated(WindowEvent e) {
        }

    @Override
    public void windowDeactivated(WindowEvent e) {
        }

    
 



}
