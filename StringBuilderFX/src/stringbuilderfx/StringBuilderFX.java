/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringbuilderfx;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import java.lang.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

/**
 *
 * @author Austin Brown
 */
public class StringBuilderFX extends Application {

    Scene startPageENG, startPageDE, testerPageENG, testerPageDE;

    TextField enter, enterDE;

    @Override
    public void start(Stage programWindow) throws FileNotFoundException {

        PlindromeFX palindrome = new PlindromeFX();
        programWindow.setTitle("Palindromprüfunganwendung");

        //startPageENG scene
        Label titleApp = new Label("Palindrome Checker");
        titleApp.setFont(Font.font("Courier New", 20));
        titleApp.setAlignment(Pos.CENTER);

        titleApp.setTextFill(Color.BLUE);
        Button startButton = new Button("Click here to start");

        Button buttonDE = new Button("Klicken sie hier für Deutsch");
        
      

        VBox engTitle = new VBox(20);
        engTitle.getChildren().addAll(titleApp, startButton, buttonDE);
        startPageENG = new Scene(engTitle, 500, 600);

        //testerPageENG scene
        Label instructions = new Label("Enter a word into the field, then click\n"
                + "the GO button to see if they are palindromes.\n"
                + "Please clear the field before returning to the menu.\n");
        Button returnTo = new Button("Return to menu");

        TextField enter = new TextField();
        //String engString = enter.getText();

        Button goButtonENG = new Button("GO");
        Label l = new Label("N/A");
        l.setTextFill(Color.RED);
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {//english GO button method
            public void handle(ActionEvent e) {
                String engString = enter.getText();

                boolean textRes = palindrome.evalText(engString);

                l.setText("The string entered was a palindrome: " + textRes);
                if (textRes == false) {
                    l.setTextFill(Color.DARKRED);
                } else if (textRes == true) {
                    l.setTextFill(Color.GREEN);
                }

                //l.setText("button selected");
            }
        };
        goButtonENG.setOnAction(event);
        //end eng go button method
        Button clearButtonENG = new Button("Clear");
        EventHandler<ActionEvent> clearEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent s) {
                enter.setText("");
                l.setText("N/A");
                l.setTextFill(Color.RED);
            }
        };
        clearButtonENG.setOnAction(clearEvent);

        VBox engTest = new VBox(20);
        engTest.getChildren().addAll(instructions, enter, goButtonENG, l, clearButtonENG, returnTo);
        testerPageENG = new Scene(engTest, 500, 600);

        //startPageDE scene
        Label titleAppDE = new Label("Palindromprüfung");
        titleAppDE.setFont(Font.font("Courier New", 20));
        titleAppDE.setTextFill(Color.BLUE);
        Button startButtonDE = new Button("Klicken sie hier beginnen");

        Button buttonENG = new Button("Klicken sie hier für Englisch");

        VBox deTitle = new VBox(20);
        deTitle.getChildren().addAll(titleAppDE, startButtonDE, buttonENG);
        startPageDE = new Scene(deTitle, 500, 600);

        //testerPageDE scene
        Label instructionsDE = new Label("Tippen ein Wort in die Feld, alsdann klicken\n"
                + "das GO Schaltfläche um zu prüfen ob sie ist ein Palindrome.\n"
                + "Bevor zurückkehrend an die Menü, bitte löschen die Feld.\n");
        Button returnToDE = new Button("Zurück an Menü");

        TextField enterDE = new TextField();
        //String deString = enterDE.getText();

        Button goButtonDE = new Button("GO");
        Label lj = new Label("N/A");
        lj.setTextFill(Color.RED);
        EventHandler<ActionEvent> eventDE = new EventHandler<ActionEvent>() {//German GO button method
            public void handle(ActionEvent k) {

                String deString = enterDE.getText();
                boolean textResDE = palindrome.evalText(deString);
                String sein = null;
                if (textResDE == false) {
                    sein = "Falsch";
                    lj.setTextFill(Color.DARKRED);
                } else if (textResDE == true) {
                    sein = "Wahr";
                    lj.setTextFill(Color.GREEN);
                }

                lj.setText("Die Zeichenkette war ein Palindrom: " + sein);

                //l.setText("button selected");
            }
        };
        goButtonDE.setOnAction(eventDE);
        //de GO method end
        Button clearButtonDE = new Button("Löschen");
        EventHandler<ActionEvent> clearEventDE = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent j) {
                enterDE.setText("");
                lj.setText("N/A");
                lj.setTextFill(Color.RED);
            }
        };
        clearButtonDE.setOnAction(clearEventDE);

        VBox deTest = new VBox(20);
        deTest.getChildren().addAll(instructionsDE, enterDE, goButtonDE, lj, clearButtonDE, returnToDE);
        testerPageDE = new Scene(deTest, 500, 600);

        //ENG start button
        startButton.setOnAction(e -> programWindow.setScene(testerPageENG));
        //DE start button
        startButtonDE.setOnAction(e -> programWindow.setScene(testerPageDE));
        //switch to DE
        buttonDE.setOnAction(e -> programWindow.setScene(startPageDE));
        //switch to ENG
        buttonENG.setOnAction(e -> programWindow.setScene(startPageENG));
        //return to menu ENG
        returnTo.setOnAction(e -> programWindow.setScene(startPageENG));
        //return to menu DE
        returnToDE.setOnAction(e -> programWindow.setScene(startPageDE));
        //GO button ENG

        //GO button DE
        //text field widths for ENG
        enter.setPrefWidth(300);
        enter.setMaxWidth(300);

        //text field widths for DE
        enterDE.setPrefWidth(300);
        enterDE.setMaxWidth(300);

        programWindow.setScene(startPageENG);
        programWindow.show();

    }

    /*
public EventHandler<Event> evalText() {
   
    buttonEval = new EventHandler<Event>(){
        public void handle(Event event){
            System.out.println(".");
            biddingHelperFrame.getBtnSag().setVisible(false);
        }
    };
    return buttonEval;
}
     */
    public static void main(String[] args) {
        launch(args);

    }

}
