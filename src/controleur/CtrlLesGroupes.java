/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import vue.VueBilletterie;

/**
 *
 * @author btssio
 */
public class CtrlLesGroupes implements WindowListener, ActionListener {
    
     private VueBilletterie vue;
     
     
     public CtrlLesGroupes(VueBilletterie vue) {
        this.vue = vue;
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);

        // préparer l'état iniitial de la vue
        List<Groupes> lesGroupes = null;
        try {
            lesGroupes = DaoGroupe.selectAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlLesGroupes - échec de sélection des groupes");
        }
        afficherLesGroupes(lesGroupes);
}
     
}
