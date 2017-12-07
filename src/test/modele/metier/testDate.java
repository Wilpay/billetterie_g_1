/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.modele.metier;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author btssio
 */
public class testDate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date maDate;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        maDate = sdf.parse("2015-11-02", new ParsePosition(0));
        System.out.println(maDate.toString());
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ld = LocalDate.parse("31/13/2018",formatter);
         System.out.println(ld.toString());
    }
    
}
