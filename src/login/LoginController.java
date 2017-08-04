/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import helpers.Routes;
import hospitalfx.HospitalFX;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import models.User;

/**
 * FXML Controller class
 *
 * @author danml
 */
public class LoginController implements Initializable {

    @FXML
    private JFXButton btnLogin;
    @FXML
    private JFXSpinner loggingProgress;
    @FXML
    private JFXTextField txtUsername;
    @FXML
    private JFXPasswordField txtPassword;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loggingProgress.setVisible(false);
    }

    @FXML
    private void loginAction(ActionEvent event) throws IOException {
        loggingProgress.setVisible(true);
        PauseTransition pauseTransition = new PauseTransition();
        pauseTransition.setDuration(Duration.seconds(5));
        pauseTransition.setOnFinished(ev -> {
            System.out.println("Complte one");
            completeLogin();
            System.out.println("Complte two");
        });
        pauseTransition.play();

    }

    private boolean isValidInput() {
        return (txtUsername.getText().trim().length() > 0) && (txtPassword.getText().trim().length() > 0);
    }

    private void completeLogin() {
        loggingProgress.setVisible(false);
        if (isValidInput()) {
            try {
                User user=new User();
                user.setUsername(txtUsername.getText());
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource(Routes.MAINVIEW));
                JFXDecorator decorator = new JFXDecorator(stage, root, false, false, true);
                decorator.setCustomMaximize(false);
                decorator.setBorder(Border.EMPTY);

                Scene scene = new Scene(decorator);
                scene.getStylesheets().add(HospitalFX.class.getResource("/styles/styles.css").toExternalForm());
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(scene);

                stage.setIconified(false);
                stage.show();
                //Hide login window
                btnLogin.getScene().getWindow().hide();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
