/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import dao.TehtavaDao;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author siniliu
 */
public class TehtavaService {
    private TehtavaDao tehtavadao;
    private Integer luku;

    public TehtavaService(TehtavaDao tehtavadao) {
        this.tehtavadao = tehtavadao;
        this.luku = 0;
    }
    
    
    
//    public Tehtava seuraavaTehtava() throws SQLException {
//        this.luku++;
//        Tehtava palautettava = tehtavadao.findOne(luku);
//        return palautettava; 
//    }

    public Integer seuraava() {
        luku++;
        return luku;
    }
    
    
    
    
    
}
