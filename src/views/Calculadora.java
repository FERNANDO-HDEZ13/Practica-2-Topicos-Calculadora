package views;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;

public class Calculadora extends Stage implements EventHandler {

    private Scene escena;
    private TextField txtoperacion;
    private HBox[] hBoxes;
    private Button[] arBotones;
    private VBox vBox;
    private char[] arNumeros = {'C','$','%','&','7','8','9','/','4','5','6','*','1','2','3','+','0','.','=','-'};
    private String operador="", num1, num2;
    private double  total;



    public Calculadora(){


        CrearUI();

        this.setTitle("Calculadora");
        this.setScene(escena);
        this.show();



    }

    private void CrearUI() {
        vBox = new VBox();
        hBoxes = new HBox[5];
        arBotones = new Button[20];

        txtoperacion = new TextField();
        txtoperacion.setEditable(false);
        txtoperacion.setPrefHeight(50);
        txtoperacion.setText("");
        txtoperacion.setAlignment(Pos.BASELINE_RIGHT);






        int pos = 0;
        for (int i = 0; i < hBoxes.length; i++) { // Iterarme sobre el arreglo de HBox
            hBoxes[i] = new HBox();
            hBoxes[i].setSpacing(10);
            hBoxes[i].setPadding(new Insets(5));
            for (int j = 0; j < 4; j++) { // Ciclo para crear 4 botones
                arBotones[pos] = new Button(arNumeros[pos] + "");
                arBotones[pos].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventoCalcu(arNumeros[pos]));
                arBotones[pos].setPrefSize(50, 50);
                hBoxes[i].getChildren().add(arBotones[pos]);
                pos++; //Contador de botones creados

            }
        }

        vBox.getChildren().addAll(txtoperacion, hBoxes[0], hBoxes[1], hBoxes[2], hBoxes[3], hBoxes[4]);
        vBox.setPadding(new Insets (10, 5, 5, 5));
        arBotones[0].setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #FFA500");
        arBotones[1].setVisible(false);
        arBotones[2].setVisible(false);
        arBotones[3].setVisible(false);
        arBotones[4].setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #808080");
        arBotones[5].setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #808080");
        arBotones[6].setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #808080");
        arBotones[7].setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #FFA500");
        arBotones[8].setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #808080");
        arBotones[9].setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #808080");
        arBotones[10].setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #808080");
        arBotones[11].setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #FFA500");
        arBotones[12].setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #808080");
        arBotones[13].setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #808080");
        arBotones[14].setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #808080");
        arBotones[15].setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #FFA500");
        arBotones[16].setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #808080");
        arBotones[17].setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #FFA500");
        arBotones[18].setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #FFA500");
        arBotones[19].setStyle("-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #FFA500");

        escena = new Scene(vBox, 250, 250);


    }

    @Override
    public void handle(Event event) {
        txtoperacion.setText("");
        total = 0;
        num1 = "";
        num2 = "";
        operador = "";

    }

    class EventoCalcu implements EventHandler{

        char tecla;
        public EventoCalcu(char tecla){
            this.tecla = tecla;




        }


        @Override
        public void handle(Event event) {
            System.out.println(tecla);
            if (tecla == 'C')
            {
                txtoperacion.setText("");
                total = 0;
                num1 = "";
                num2 = "";
                operador = "";
            }
            else
            {
                if (tecla == '+' || tecla == '-' || tecla == '*' || tecla == '/'){
                    operador = tecla + "";
                    System.out.println(operador);
                    txtoperacion.setText("");
                }
                else{
                    if (tecla == '='){
                        switch(operador) {
                            case "+":
                                total = Double.parseDouble(num1) + Math.abs(Double.parseDouble(num2));
                                break;
                            case "-":
                                total = Double.parseDouble(num1) - Math.abs(Double.parseDouble(num2));
                                break;
                            case "*":
                                total = Double.parseDouble(num1) * Math.abs(Double.parseDouble(num2));
                                break;
                            case "/":
                                total = Double.parseDouble(num1) / Math.abs(Double.parseDouble(num2));
                                break;
                        }
                        txtoperacion.setText(total +"");
                        num1 = total+"";
                    }
                    else{
                        if (operador == ""){

                            txtoperacion.setText(txtoperacion.getText() + tecla + "");
                            num1 = txtoperacion.getText();

                        }
                        else{

                            txtoperacion.setText(txtoperacion.getText() + tecla + "");
                            num2 = txtoperacion.getText();

                        }

                    }
                }

            }







        }
    }
}
