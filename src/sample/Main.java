package sample;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import views.Calculadora;
import views.Encriptador;
import views.Rompecabezas;

public class Main extends Application {
    private VBox vBox;
    private MenuBar mnbPrincipal;
    private Menu menCompetencia1, menCompetencia2, menCerrar;
    private MenuItem mitCalcu, mitRompecabezas, mitEncriptar,mitSalir;
    private Scene escena;
    private Button btn1, btn2, btn3, btn4,btn5,btn6,btn7;
    private Label lbl1,lbl2,lbl3;
    private BorderPane Bp;
    private FlowPane Fp;
    private GridPane Gp;
    private AnchorPane Ap;


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));


        CrearMenu();
        primaryStage.setTitle("Clase 4 - Topicos");
        primaryStage.setScene(escena);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }



    private void CrearMenu() {
        vBox = new VBox();

        mnbPrincipal    = new MenuBar();
        menCompetencia1 = new Menu("COMPETENCIA 1");
        menCompetencia2 = new Menu("COMPETENCIA 2");
        menCerrar       = new Menu("CERRAR");

        mnbPrincipal.getMenus().addAll(menCompetencia1, menCompetencia2, menCerrar);

        mitCalcu = new MenuItem("CALCULADORA");
        mitCalcu.setOnAction(event -> opcionesMenu(1));
        mitRompecabezas = new MenuItem("ROMPECABEZAS");
        mitRompecabezas.setOnAction(actionEvent -> opcionesMenu(2));
        mitEncriptar = new MenuItem("ENCRIPTADOR");
        mitEncriptar.setOnAction(actionEvent -> opcionesMenu(3));
        menCompetencia1.getItems().addAll(mitCalcu,mitRompecabezas, mitEncriptar);




        mitSalir = new MenuItem("SALIR");
        mitSalir.setOnAction(event -> { System.exit(0);});
        menCerrar.getItems().add(mitSalir);

        vBox.getChildren().add(mnbPrincipal);
        escena = new Scene(vBox, 300, 275);

    }

    private void opcionesMenu(int opc) {
        switch(opc){
            case 1: new Calculadora(); break;
            case 2: new Rompecabezas(); break;
            case 3: new Encriptador();

        }
    }
    




    public static void main(String[] args) {
        launch(args);
    }
}
