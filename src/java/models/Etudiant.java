/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ISSATSO
 */
public class Etudiant 
{
    private String nom;
    private String prenom;
    private String login;
    private String mp;
    private String groupe;
    private long cin;
    private int genre;

    public Etudiant() 
    {
    }

    public Etudiant(String nom, String prenom, String login, String mp, String groupe, long cin, int genre) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mp = mp;
        this.groupe = groupe;
        this.cin = cin;
        this.genre = genre;
    }

    public String getNom() 
    {
        return nom;
    }

    public void setNom(String nom) 
    {
        this.nom = nom;
    }

    public String getPrenom() 
    {
        return prenom;
    }

    public void setPrenom(String prenom) 
    {
        this.prenom = prenom;
    }

    public String getLogin() 
    {
        return login;
    }

    public void setLogin(String login) 
    {
        this.login = login;
    }

    public String getMp() 
    {
        return mp;
    }

    public void setMp(String mp) 
    {
        this.mp = mp;
    }

    public String getGroupe() 
    {
        return groupe;
    }

    public void setGroupe(String groupe) 
    {
        this.groupe = groupe;
    }

    public long getCin() 
    {
        return cin;
    }

    public void setCin(long cin) 
    {
        this.cin = cin;
    }

    public int getGenre() 
    {
        return genre;
    }

    public void setGenre(int genre) 
    {
        this.genre = genre;
    }  

    @Override
    public String toString() {
        return "Etudiant{" + "nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", mp=" + mp + ", groupe=" + groupe + ", cin=" + cin + ", genre=" + genre + '}';
    }
    
    
    public static Etudiant login_etudiant(String login,String mp)
    {
        Connection con = ConnectionDb.getConnexion();
        String rep = "SELECT * FROM ETUDIANTS WHERE Login ='"+login +"' and motDePasse ='"+mp+"' ";
        Statement pst ;
        Etudiant et = new Etudiant();
        try 
        {
            pst = con.createStatement();
            ResultSet rs = pst.executeQuery(rep);
            while (rs.next()) 
            {
                et.setNom(rs.getString("nom"));
                et.setPrenom(rs.getString("prenom"));
                et.setCin(rs.getLong("cin"));
                et.setGenre(rs.getInt("genre"));
                et.setGroupe(rs.getString("groupe"));
                et.setLogin(rs.getString("login"));
                et.setMp(rs.getString("motDePasse"));
                System.out.println("Bonjour "+rs.getString("login"));            
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return et;
    }
    
    public static void ajout (Etudiant etu)
    {
        try 
        {
            Connection con = ConnectionDb.getConnexion();
            PreparedStatement reqSauvegarder = con.prepareStatement("insert into tp1g2.etudiants values (?,?,?,?,?,?,?)");
            reqSauvegarder.setLong(1, etu.cin);
            reqSauvegarder.setString(2,etu.nom);
            reqSauvegarder.setString(3, etu.prenom);
            reqSauvegarder.setString(4, etu.groupe);
            reqSauvegarder.setInt(5, etu.genre);
            reqSauvegarder.setString(6, etu.login);
            reqSauvegarder.setString(7, etu.mp);
            Boolean ok = reqSauvegarder.executeUpdate () == 0;
            con.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
}

