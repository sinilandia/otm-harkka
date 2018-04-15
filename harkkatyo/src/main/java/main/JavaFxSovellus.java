/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//selvitä: miten nimeän paketit???

package main;

import java.sql.*;
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
        Tehtava tehtava = new Tehtava();
        
        ikkuna.setTitle("Arvaa sana!");
        ikkuna.show();
        GridPane asettelu = new GridPane();
        asettelu.add(new Label("logout"),0,0);
        asettelu.add(new Label("username"),2,0);
        TextField arvaus = new TextField();
        asettelu.add(new Label("viini"),0,4);
        asettelu.add(arvaus,1,4);
        asettelu.add(new Label("puuro"),3,4);
        Button tarkistusnappi = new Button("Tarkista!");
        asettelu.add(tarkistusnappi, 1, 5);
        asettelu.setPrefSize(600, 380);
        
        //olisko Scene vaihtoehto popup-ikkunalle
        //tulos popup-ikkunassa
        Popup popup = new Popup();
        popup.setX(300);
        popup.setY(300);
        popup.setAutoFix(true);
        popup.setAutoHide(true);    
        
        
        //tarkista onko vastaus oikein
        tarkistusnappi.setOnAction((event) ->{
            Boolean oikein = tehtava.tarkista(arvaus.getText().trim()); 
            
            //popup-ikkuna ilmoittaa oliko oikein
            String tulos = "";
            if (oikein) {
                tulos = "Arvasit oikein!";
                
            } else {
                tulos = "Väärin meni - kokeile uudestaan!";
            }         
            
            popup.getContent().add(new Label(tulos));
            popup.show(ikkuna);
            //labelit++ menee päällekkäin - ratkaisu?
        });
        
        Scene nakyma = new Scene(asettelu);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) throws Exception {
        //launch(JavaFxSovellus.class);
        
        Connection connection = DriverManager.getConnection("jdbc:sqlite:yhdysssanat.db");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Sanat");

        if (resultSet.next()) {
            System.out.println("Hei tietokantamaailma!");
        } else {
            System.out.println("Yhteyden muodostaminen epäonnistui.");
        }
        
    }
}

