/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Tehtava;
import java.sql.*;
import java.util.*;

/**
 *
 * @author siniliu
 */
public class TehtavaDao implements Dao<Tehtava, Integer> {
    
    private Database database;

    public TehtavaDao(Database database) {
        this.database = database;
    }
    
    

    @Override
    public Tehtava findOne(Integer key) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Sanat WHERE id = ?");
        stmt.setInt(1, key);
        
        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }
        
        Tehtava t = new Tehtava(rs.getInt("id"), rs.getString("etu"), 
            rs.getString("keski"), rs.getString("taka"));
        
        stmt.close();
        rs.close();
        conn.close();
        
        return t;
    }

    @Override
    public List<Tehtava> findAll() throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Sanat");
        
        ResultSet rs = stmt.executeQuery();
        
        //lisää palauta null jos tyhjä taulu !!!
        
        List<Tehtava> tehtavat = new ArrayList<>();
        while (rs.next()) {
            Tehtava t = new Tehtava(rs.getInt("id"), rs.getString("etu"), 
                rs.getString("keski"), rs.getString("taka"));
            
            tehtavat.add(t);
        } 
     
        stmt.close();
        rs.close();
        conn.close();
        
        return tehtavat;
    }

    @Override
    public Tehtava saveOrUpdate(Tehtava object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer key) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM Sanat WHERE id =?");
        
        stmt.setInt(1, key);
        stmt.executeUpdate();
        
        stmt.close();
        conn.close();
    }
    
    
    
    
    
}
