package main.java;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.java.Algorithm.Function;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.java.Algorithm.TextFieldConvecter;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    private RadioButton radioButton_o, radioButton_d;
    private Button runAlgorithmButton;
    private TextField firstField, secondField;
    private Label firstLabel, secondLabel;

    @Override
    public void start(Stage primaryStage) throws Exception{
        int width = 300;
        int height = 300;
        String title = "Euclidean Algorithm";

        radioButton_o = new RadioButton("(NWDo)");
        radioButton_o.setSelected(true);
        radioButton_d = new RadioButton("(NWDd)");

        runAlgorithmButton = new Button("Run algorithm!");
        HBox buttomBox = new HBox(runAlgorithmButton);
        buttomBox.setPadding(new Insets(20,105,50,105));

        HBox hBoxNumberField = new HBox();
        firstLabel = new Label("X:");
        secondLabel = new Label("Y:");
        firstField = new TextFieldConvecter.NumberTextField();
        secondField = new TextFieldConvecter.NumberTextField();
        VBox xBox = new VBox(firstLabel, firstField);
        VBox yBox = new VBox(secondLabel, secondField);
        hBoxNumberField.getChildren().addAll(xBox, yBox);

        VBox vBoxMain = new VBox();
        HBox checkHBox = new HBox(radioButton_o, radioButton_d);
        checkHBox.setPadding(new Insets(20,75,50,75));
        checkHBox.setSpacing(20);


        radioButton_o.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                if (isNowSelected) {
                    radioButton_d.setSelected(false);
                }
                else if(!radioButton_o.isSelected()&& !radioButton_d.isSelected())
                {
                    radioButton_o.setSelected(true);
                }
            }
        });

        radioButton_d.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                if (isNowSelected) {
                    radioButton_o.setSelected(false);
                }
                else if(!radioButton_o.isSelected()&& !radioButton_d.isSelected())
                {
                    radioButton_d.setSelected(true);
                }
            }
        });

        runAlgorithmButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(radioButton_o.isSelected())
                {
                    System.out.println("Odejmowanie selected!");
                }
                else if(radioButton_d.isSelected())
                {
                    System.out.println("Dzielenie selected!");
                }
            }
        });

        vBoxMain.getChildren().addAll(checkHBox,hBoxNumberField, buttomBox);
        primaryStage.setTitle(title);
        primaryStage.setScene(new Scene(vBoxMain, width, height));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
