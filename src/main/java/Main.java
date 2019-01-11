package main.java;

import com.sun.javafx.scene.traversal.Algorithm;
import javafx.scene.control.*;
import main.java.Algorithm.Function;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
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
    private TextFieldConvecter.NumberTextField firstField, secondField;
    private Label firstLabel, secondLabel;

    @Override
    public void start(Stage primaryStage) throws Exception{
        int width = 300;
        int height = 350;
        String title = "Euclidean Algorithm";

        //Radio Button Box

        radioButton_o = new RadioButton("(GCDs)");
        radioButton_o.setSelected(true);
        radioButton_d = new RadioButton("(GCDd)");

        runAlgorithmButton = new Button("Run algorithm!");
        HBox buttomBox = new HBox(runAlgorithmButton);
        buttomBox.setPadding(new Insets(20,105,10,105));


        //Loop

        TextFieldConvecter.NumberTextField loopNumber = new TextFieldConvecter.NumberTextField();
        loopNumber.setText("0");
        CheckBox loopCheck = new CheckBox("How many repeat: pow(10,X) ");
        HBox loopBox = new HBox(loopNumber, loopCheck);
        loopNumber.setMaxWidth(30);
        loopNumber.setMinWidth(30);
        loopBox.setPadding(new Insets(10,0,20,50));

        //Bézout && mod

        Label bezoutLabel = new Label("Bézout: none");
        Label bezoutmodLabel = new Label("a^(-1) = none");
        bezoutLabel.setPadding(new Insets(10,0,10,10));
        bezoutmodLabel.setPadding(new Insets(10,0,10,10));



        //Input Box

        HBox hBoxNumberField = new HBox();
        firstLabel = new Label("X:");
        secondLabel = new Label("Y:");
        firstField = new TextFieldConvecter.NumberTextField();
        firstField.setText("0");
        secondField = new TextFieldConvecter.NumberTextField();
        secondField.setText("0");
        VBox xBox = new VBox(firstLabel, firstField);
        VBox yBox = new VBox(secondLabel, secondField);
        hBoxNumberField.getChildren().addAll(xBox, yBox);


        //MainBox

        VBox vBoxMain = new VBox();
        HBox checkHBox = new HBox(radioButton_o, radioButton_d);
        checkHBox.setPadding(new Insets(20,75,20,75));
        checkHBox.setSpacing(20);


        //ResultZone

        Label resultLabel = new Label("(GCD): ");
        Label timeLabel = new Label("time: 0.0ms");
        resultLabel.setPadding(new Insets(20,0,10,10));
        timeLabel.setPadding(new Insets(10,0,10,10));


        // Radio Button Listener

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

                Function function = new Function();
                int result = 0;
                int x=Integer.parseInt(firstField.getText());
                int y=Integer.parseInt(secondField.getText());
                long startT = System.currentTimeMillis();

                if(x==y)
                {
                    result=x;
                }
                else
                {
                    if(radioButton_o.isSelected())
                    {
                        if(loopCheck.isSelected())
                        {
                            long loop = (long) Math.pow(10,Integer.parseInt(loopNumber.getText()));
                            for(long i=0;i<loop;i++)
                            {
                                result = function.NWDo(x,y);
                            }
                        }
                        else
                        {
                            result = function.NWDo(x,y);
                        }
                    }

                    else if(radioButton_d.isSelected())
                    {
                        if(loopCheck.isSelected())
                        {
                            long loop = (long) Math.pow(10,Integer.parseInt(loopNumber.getText()));
                            for(long i=0;i<loop;i++)
                            {
                                result = function.NWDd(x,y);
                            }
                        }
                        else
                        {
                            result = function.NWDd(x,y);
                        }
                    }
                }
                long endT = System.currentTimeMillis();

                resultLabel.setText("(GCD): " + Integer.toString(result));
                timeLabel.setText("time: " + String.valueOf(endT-startT) +"ms");
                long tab[] = function.expandedEuclidean(x,y);

                bezoutLabel.setText("Bézout: " + tab[0] + "=" + x + " * " + tab[1] + " + " + y + " * " + tab[2]);
                //System.out.println(tab[0] + " -> " + tab[1] + " -> " + tab[2]);
                if(tab[0]==1)
                {
                    bezoutmodLabel.setText("a^(-1) = " + (x+tab[2]));
                }
                else
                {
                    bezoutmodLabel.setText("a^(-1) = none");
                }


            }
        });

        //Primary Scene && Stage

        vBoxMain.getChildren().addAll(checkHBox,loopBox, hBoxNumberField,resultLabel, timeLabel, bezoutLabel, bezoutmodLabel, buttomBox);
        primaryStage.setTitle(title);
        primaryStage.setScene(new Scene(vBoxMain, width, height));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
