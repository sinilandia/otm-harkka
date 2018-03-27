/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

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
public class KassapaateTest {
    
    Kassapaate kassapaate;
    
    public KassapaateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kassapaate = new Kassapaate(); //1000 euroa
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void kassapaateLuotuOikein() {
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void kateisostoToimiiEdullisesti() {
        assertEquals(10 ,kassapaate.syoEdullisesti(250));
        assertEquals(100240, kassapaate.kassassaRahaa());
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty()); 
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kateisostoToimiiMaukkaasti() {
        assertEquals(100 ,kassapaate.syoMaukkaasti(500));
        assertEquals(100400, kassapaate.kassassaRahaa());
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty()); 
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kateisostoEiRahaaEdullisesti() {
        assertEquals(200 ,kassapaate.syoEdullisesti(200));
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty()); 
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kateisostoEiRahaaMaukkaasti() {
        assertEquals(100 ,kassapaate.syoMaukkaasti(100));
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty()); 
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void korttimaksuToimiiEdullisesti(){
        Maksukortti kortti = new Maksukortti(1000); //10 euroa
        assertTrue(kassapaate.syoEdullisesti(kortti));
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassapaate.kassassaRahaa());       
    }
    
    @Test 
    public void korttimaksuToimiiMaukkaasti() {
        Maksukortti kortti = new Maksukortti(1000); //10 euroa
        assertTrue(kassapaate.syoMaukkaasti(kortti));
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassapaate.kassassaRahaa());        
    }
    
    @Test
    public void korttimaksuEiRahaaEdullisesti() {
        Maksukortti kortti = new Maksukortti(0);
        assertFalse(kassapaate.syoEdullisesti(kortti));
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());    
        assertEquals(100000, kassapaate.kassassaRahaa());   
    }
    
    @Test
    public void korttimaksuEiRahaaMaukkaasti() {
        Maksukortti kortti = new Maksukortti(0);
        assertFalse(kassapaate.syoMaukkaasti(kortti));
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());    
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void lataaRahaaKortilleOnnistuu() {
        Maksukortti kortti = new Maksukortti(0);
        kassapaate.lataaRahaaKortille(kortti, 1000); //10 euroa
        assertEquals(101000, kassapaate.kassassaRahaa());
        assertEquals(1000, kortti.saldo());
    }
    
    @Test
    public void lataaRahaaKortilleEiOnnistu() {
        Maksukortti kortti = new Maksukortti(0);
        kassapaate.lataaRahaaKortille(kortti, -10);
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(0, kortti.saldo());
    }
    
}



