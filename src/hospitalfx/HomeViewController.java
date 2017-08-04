/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalfx;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import helpers.Routes;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author danml
 */
public class HomeViewController implements Initializable {

    @FXML
    private JFXHamburger hamburger;
    @FXML
    private AnchorPane holderPane;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private Label txtCurrentWindow;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();

            if (drawer.isShown()) {
                drawer.close();
            } else {
                drawer.open();
            }

        });
        try {
            VBox sidePane = FXMLLoader.load(getClass().getResource("/hospitalfx/Drawer.fxml"));
            AnchorPane doctorsPane = FXMLLoader.load(getClass().getResource(Routes.DOCTORSVIEW));
            AnchorPane login = FXMLLoader.load(getClass().getResource(Routes.LOGINVIEW));
            AnchorPane payments = FXMLLoader.load(getClass().getResource(Routes.PAYMENTSVIEW));
            AnchorPane appointment = FXMLLoader.load(getClass().getResource(Routes.APPOINTMENTSVIEW));
            AnchorPane welcome = FXMLLoader.load(getClass().getResource(Routes.WELCOMEVIEW));
            setNode(welcome);
            drawer.setSidePane(sidePane);

            for (Node node : sidePane.getChildren()) {
                if (node.getAccessibleText() != null) {
                    node.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent ev) -> {
                        switch (node.getAccessibleText()) {
                            case "homeMenu":
                                drawer.close();
                                setNode(welcome);
                                break;
                            case "doctorMenu":
                                drawer.close();                               
                                setNode(doctorsPane);
                                break;
                            case "paymentMenu":
                                drawer.close();
                                setNode(payments);
                                break;
                            case "appointmentMenu":
                                drawer.close();                                
                                setNode(appointment);
                                break;                                
                        }
                    });
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void setNode(Node node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);
    }


}
