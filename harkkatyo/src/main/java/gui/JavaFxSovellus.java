/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//selvitä: miten nimeän paketit???

package gui;

import dao.Database;
import dao.TehtavaDao;
import domain.Tehtava;
import domain.TehtavaService;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JavaFxSovellus extends Application {
    
    private TehtavaService tehtavaservice;
    private TehtavaDao tehtavadao;
    private Database database;
    private Tehtava tehtava;
    
    @Override
    public void init() throws Exception {
        this.database = new Database("jdbc:sqlite:yhdyssanat.db");
        this.tehtavadao = new TehtavaDao(this.database);
        this.tehtavaservice = new TehtavaService(tehtavadao);
        this.tehtava = tehtavadao.findOne(tehtavaservice.seuraava());
    }

    @Override
    public void start(Stage ikkuna) throws SQLException {
        
        
        //TEHTAVA SCENE
        ikkuna.setTitle("Arvaa sana!");
        GridPane tehtavaasettelu = new GridPane();
        tehtavaasettelu.add(new Label("logout"),0,0);
        tehtavaasettelu.add(new Label("username"),2,0);
        TextField arvaus = new TextField();      
        
        String etusana = tehtava.getEtusana();
        String takasana = tehtava.getTakasana();
        
        Label etusanalabel = new Label(etusana);
        Label takasanalabel = new Label(takasana);
        tehtavaasettelu.add(etusanalabel,0,4);
        tehtavaasettelu.add(arvaus,1,4);
        tehtavaasettelu.add(takasanalabel,3,4);
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
        
        Label tulos = new Label("");
        tulosasettelu.add(tulos, 1, 1);
        Scene tulosnakyma = new Scene(tulosasettelu);
         
        
        
        //tarkista onko vastaus oikein
        //muutetaan labelin tekstiä tuloksen mukaan
        tarkistusnappi.setOnAction((event) ->{
            Boolean oikein = tehtava.tarkista(arvaus.getText().trim()); 
            
            if (oikein) {            
               tulos.setText("Oikein!");
            } else {
                tulos.setText("Väärin!");
            }         
            
            ikkuna.setScene(tulosnakyma);
         
        });
        
        Scene tehtavanakyma = new Scene(tehtavaasettelu);
        
        
        //refaktoroi näin 2.2 https://materiaalit.github.io/ohjelmointi-s17/part12/
        uusiTehtavaNappi.setOnAction((event) -> {
            try {
                this.tehtava = tehtavadao.findOne(tehtavaservice.seuraava());
            } catch (SQLException ex) {
                Logger.getLogger(JavaFxSovellus.class.getName()).log(Level.SEVERE, null, ex);
            }
                etusanalabel.setText(tehtava.getEtusana());
                takasanalabel.setText(tehtava.getTakasana());

           ikkuna.setScene(tehtavanakyma);
       });

        ikkuna.setScene(tehtavanakyma);
        ikkuna.show();
    }

    public static void main(String[] args) throws Exception {
        launch(JavaFxSovellus.class);
        
    }
    
}

