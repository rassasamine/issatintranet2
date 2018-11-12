/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ISSATSO
 */
public class TestMain {
    public static void main(String [] args){
        
        //Etudiant e1 = new Etudiant("Radhouane", "Skander", "Ace", "123", "LFSI-A3", 22222222, 0);
        //Etudiant.ajout(e1);
        
        Etudiant e2 = Etudiant.login_etudiant("Ace","123");
        System.out.print(e2.toString());
    }
}
