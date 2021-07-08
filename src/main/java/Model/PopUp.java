package Model;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.lang.management.BufferPoolMXBean;

public class PopUp {

    public PopUp() {

    }

    public void error() {
        final Stage dialog = new Stage();
        dialog.setTitle("Error");
        dialog.initModality(Modality.APPLICATION_MODAL);
        Button reset = new Button();
        reset.setOnAction(actionEvent ->{
            System.out.println("Reset");
        });
        reset.setText("Reset");
        reset.setFont(new Font(20));
        Text text = new Text("Do you want to reset your password/login?");
        text.setFont(new Font(15));
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(text);
        dialogVbox.getChildren().add(reset);
        dialog.setResizable(false);
        Scene dialogScene = new Scene(dialogVbox, 400, 150);
        dialog.setScene(dialogScene);
        dialogScene.getStylesheets().add(getClass().getClassLoader().getResource("PopUpCSS.css").toExternalForm());
        dialog.show();
    }
}
