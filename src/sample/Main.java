package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.scenicview.ScenicView;

import java.awt.*;

public class Main extends Application {
    Stage window;
    Scene sceneHome,sceneSavings,sceneMortgage,sceneLoans;       //creating scenes

    @Override
    public void start(Stage primaryStage) throws Exception{

        //tabs shit
        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Simple", new Label("Show all planes available"));   //setting up tabs for different type sof savings
        Tab tab2 = new Tab("Compound" , new Label("Show all cars available"));  //setting up tabs for different type sof savings

        tabPane.getTabs().add(tab1);       //adding tabs to the tabs
        tabPane.getTabs().add(tab2);

        VBox vBox = new VBox(tabPane);           //making a vbox object to have space

        tabPane.widthProperty().addListener((observable, oldValue, newValue) ->      //adding event listeners to something I dont understand
        {
            tabPane.setTabMinWidth(tabPane.getWidth() / 2);    //so the defualt size of a pane will be the half of one scene
            tabPane.setTabMaxWidth(tabPane.getWidth() / 2);
        });

        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);    //removes the close buttons from each tab

        //////////////
        window = primaryStage;

        Label lb0 = new Label("Welcome Scene");        //creating labels for identifying sccnes
        Label lb1 = new Label("SceneSavings : Savings");
        Label lb2 = new Label("SceneMortgage : Mortgage");
        Label lb3 = new Label("SceneLoans : Loan");

        Button btnToSavings = new Button("Savings");        //creating buttons
        Button btnToMortgage = new Button("Mortgage");
        Button btnToLoans = new Button("Loans");
        Button btnSavingToHome = new Button("Go to Home");
        Button btnMortgageToHome = new Button("Go to Home");
        Button btnLoanToHome = new Button("Go to Home");

        btnToSavings.setOnAction(e -> window.setScene(sceneSavings));      //setting up buttons with actions
        btnToMortgage.setOnAction(e ->window.setScene(sceneMortgage));
        btnToLoans.setOnAction(e -> window.setScene(sceneLoans));
        btnSavingToHome.setOnAction(e -> window.setScene(sceneHome));
        btnMortgageToHome.setOnAction(e -> window.setScene(sceneHome));
        btnLoanToHome.setOnAction(e -> window.setScene(sceneHome));

        //setting up btns in the welcome scene to go to other scene
        VBox layout0 = new VBox(20);
        layout0.getChildren().addAll(lb0,btnToSavings,btnToMortgage,btnToLoans);
        sceneHome = new Scene(layout0,700,600);

        //Setting Layout 1 as sceneSavings  savings
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(lb1,vBox,btnSavingToHome);
        sceneSavings = new Scene(layout1,400,400);

        //Setting Layout 2 as sceneMortgage     mortgage
        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(lb2,btnMortgageToHome);
        sceneMortgage =new Scene(layout2,400,400);

        //Setting Layout 3 as sceneLoans        loan
        VBox layout3 = new VBox(20);
        layout3.getChildren().addAll(lb3,btnLoanToHome);
        sceneLoans =new Scene(layout3,400,400);

        //////////adding css
        sceneSavings.getStylesheets().add("/sample/Savings.css");
        sceneHome.getStylesheets().add("/sample/Home.css");
        //////////////

        window.setScene(sceneHome);       //sets the first scene to be scene 0
        window.setTitle("Financial Calculator");
        window.show();

        ScenicView.show(sceneHome);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
