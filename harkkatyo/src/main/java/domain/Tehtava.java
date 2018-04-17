/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author siniliu
 */
public class Tehtava {
    private Integer id;
    private String etusana;
    private String  keskisana;
    private String takasana;

    public Tehtava(Integer nro, String etu, String keski, String taka) {
        id = nro;
        etusana = etu;
        keskisana = keski;
        takasana = taka;
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

    @Override
    public String toString() {
        return "Tehtava" + " id=" + id + ", etusana=" + etusana + ", keskisana=" + keskisana + ", takasana=" + takasana;
    }
    
    
    
}
