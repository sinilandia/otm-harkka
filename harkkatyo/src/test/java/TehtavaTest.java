/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import main.Tehtava;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author siniliu
 */
public class TehtavaTest {
    
    Tehtava tehtava;
    
    public TehtavaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        // pitääkö tähän tehdä Scenet ja Staget jne???
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tehtava = new Tehtava();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void oikeaVastaus() {
        String oikein = "marja";
        Boolean tulos = tehtava.tarkista(oikein);      
        assertEquals(true, tulos);
     }
     
     @Test
     public void vaaraVastaus(){
        String vaarin = "ploo";
        Boolean tulos = tehtava.tarkista(vaarin); 
        assertEquals(false, tulos);
     }
     
     @Test
     public void konstruktoriAsettaaEtusananOikein(){
         String etusana = "viini";
         assertEquals("viini", etusana);
     }
     
     @Test
     public void konstruktoriAsettaaKeskisananOikein(){
         String keskisana = "marja";
         assertEquals("marja", keskisana);
     }
     
     @Test
     public void konstruktoriAsettaaTakasananOikein(){
         String takasana = "puuro";
         assertEquals("puuro", takasana);
     }
     
     @Test
     public void getEtusanapalauttaaEtusanan() {
         assertEquals("viini", tehtava.getEtusana());
     }
     
     @Test
     public void getKeskisanaPalauttaaEtusanan() {
         assertEquals("marja", tehtava.getKeskisana());
     }
     
     @Test
     public void getTakasanaPalauttaaEtusanan() {
         assertEquals("puuro", tehtava.getTakasana());
     }
}

