/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//selvitä: miten nimeän paketit???

package main;

import java.sql.*;
import java.util.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class JavaFxSovellus extends Application {

    @Override
    public void start(Stage ikkuna) {
        //korjaa > refaktoroi tehtavan luonti
        Tehtava tehtava1 = new Tehtava(1, "viini", "marja", "puuro");
        Tehtava tehtava2 = new Tehtava(2, "villi", "kissa", "peto");
        
        
        //TEHTAVA SCENE
        ikkuna.setTitle("Arvaa sana!");
        GridPane tehtavaasettelu = new GridPane();
        tehtavaasettelu.add(new Label("logout"),0,0);
        tehtavaasettelu.add(new Label("username"),2,0);
        TextField arvaus = new TextField();
        tehtavaasettelu.add(new Label("viini"),0,4);
        tehtavaasettelu.add(arvaus,1,4);
        tehtavaasettelu.add(new Label("puuro"),3,4);
        Button tarkistusnappi = new Button("Tarkista!");
        tehtavaasettelu.add(tarkistusnappi, 1, 5);
        tehtavaasettelu.setPrefSize(600, 380);
        
        //TULOS SCENE
        GridPane tulosasettelu = new GridPane();
        tulosasettelu.add(new Label("logout"),0,0);
        tulosasettelu.add(new Label("username"),2,0);
        tulosasettelu.setPrefSize(600, 380);
        Button uusiTehtavaNappi = new Button("Uusi tehtävä!");
        tulosasettelu.add(uusiTehtavaNappi, 1, 5);
        Scene tulosnakyma = new Scene(tulosasettelu);
        
        //olisko Scene vaihtoehto popup-ikkunalle
        //tulos popup-ikkunassa
//        Popup popup = new Popup();
//        popup.setX(300);
//        popup.setY(300);
//        popup.setAutoFix(true);
//        popup.setAutoHide(true);    
        
        
        //tarkista onko vastaus oikein
        tarkistusnappi.setOnAction((event) ->{
            Boolean oikein = tehtava1.tarkista(arvaus.getText().trim()); 
            
            //popup-ikkuna ilmoittaa oliko oikein
            String tulos = "";
            if (oikein) {
                tulosasettelu.add(new Label("Oikein!"), 1, 1);
                
                //tulos = "Arvasit oikein!";
                
            } else {
                tulosasettelu.add(new Label("Väärin"), 1, 1);
                //tulos = "Väärin meni - kokeile uudestaan!";
            }         
            
            ikkuna.setScene(tulosnakyma);
            
//            popup.getContent().add(new Label(tulos));
//            popup.show(ikkuna);
            //labelit++ menee päällekkäin - ratkaisu?
        });
        
        Scene tehtavanakyma = new Scene(tehtavaasettelu);
        
        
        //refaktoroi näin 2.2 https://materiaalit.github.io/ohjelmointi-s17/part12/
        uusiTehtavaNappi.setOnAction((event) -> {
           ikkuna.setScene(tehtavanakyma);
       });
        


        ikkuna.setScene(tehtavanakyma);
        ikkuna.show();
    }

    public static void main(String[] args) throws Exception {
        launch(JavaFxSovellus.class);
        
        
        

        //toimii
//        Database database = new Database("jdbc:sqlite:yhdyssanat.db");
//        TehtavaDao tehtavat = new TehtavaDao(database);
//        
//        List<Tehtava> listaus = tehtavat.findAll();
//        
//        listaus.forEach(t -> System.out.println(t));
        
    }
    
}

