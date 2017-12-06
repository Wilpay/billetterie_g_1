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
import modele.dao.DaoGroupe;
import modele.metier.Groupe;
import vue.VueBilletterie;
import vue.VuePrincipale;

public class CtrlLesGroupes implements WindowListener{

    private VuePrincipale vue; // LA VUE

    public CtrlLesGroupes(VuePrincipale vue) {
        this.vue = vue;
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
        // le controleur écoute le bouton jButtonRechercher de sa vue
        // préparer l'état iniitial de la vue
        List<Groupe> lesGroupes = null;
        try {
            lesGroupes = DaoGroupe.selectAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlLesClients - échec de sélection des Clients");
        }
        afficherLesGroupes(lesGroupes);
    }

    // contrôle de la vue
    /**
     * Remplir le composant JTable avec les adresses
     *
     * @param desGroupes liste des adresses à afficher
     */
    private final void afficherLesGroupes(List<Groupe> desGroupes) {
        getVue().getModeleTableGroupe().setRowCount(0);
        String[] titresColonnes = {"ID", "NOM", "NOMPAYS"};
        getVue().getModeleTableGroupe().setColumnIdentifiers(titresColonnes);
        
        String[] ligneDonnees = new String[3];
        
        for (Groupe unGroupe : desGroupes) {
            ligneDonnees[0] = unGroupe.getId();
            ligneDonnees[1] = unGroupe.getNom();
            ligneDonnees[2] = unGroupe.getNomPays();
            getVue().getModeleTableGroupe().addRow(ligneDonnees);            
        }       
    }

    
    /**
     * Quitter l'application, après demande de confirmation
     */
    private void quitter() {
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(getVue(), "Quitter l'application\nEtes-vous sûr(e) ?", "AGENCEB", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
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

    // REACTIONS EVENEMENTIELLES
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
