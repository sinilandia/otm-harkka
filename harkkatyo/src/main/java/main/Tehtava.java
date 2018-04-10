/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author siniliu
 */
public class Tehtava {
    private String etusana;
    private String  keskisana;
    private String takasana;

    public Tehtava() {
        etusana = "viini";
        keskisana = "marja";
        takasana = "puuro";
    }

    public String getEtusana() {
        return etusana; 
    }

    public String getKeskisana() {
        return keskisana;
    }

    public String getTakasana() {
        return takasana;
    }
    
    public boolean tarkista(String arvaus) {
        if (arvaus.equals(keskisana)) { 
            return true; 
        }
        return false;

        
    }
    
}
