/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalfx;

import com.jfoenix.controls.JFXDecorator;
import helpers.Routes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author danml
 */
public class HospitalFX extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(Routes.LOGINVIEW));
        JFXDecorator decorator=new JFXDecorator(stage, root, false, false, true);
        decorator.setCustomMaximize(false);
        decorator.setBorder(Border.EMPTY);
        
        Scene scene = new Scene(decorator);
        scene.getStylesheets().add(HospitalFX.class.getResource("/styles/styles.css").toExternalForm());
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        
        stage.setIconified(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
