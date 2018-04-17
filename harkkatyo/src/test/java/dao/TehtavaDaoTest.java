/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import domain.Tehtava;
import java.sql.*;
import java.util.*;

/**
 *
 * @author siniliu
 */

//tuleeko tähän implements DaoTest tms?
public class TehtavaDaoTest {
    
    TehtavaDao td;
    Connection conn;
    
    public TehtavaDaoTest() throws Exception {   
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        String databaseAddress = "jdbc:sqlite:FakeYhdyssanat.db";
        Database database = new Database(databaseAddress);

        this.conn = DriverManager.getConnection(databaseAddress);

        this.td = new TehtavaDao(database);
        
    }
    
    @After
    public void tearDown() {
    }


    
    
    @Test
    public void etsiEka() throws SQLException {
        
        Tehtava t = new Tehtava(1, "viini", "marja", "puuro");
        String testi = td.findOne(1).toString();
        String vertailu = t.toString();

        assertEquals(vertailu, testi);
    }
    
    
    
}
