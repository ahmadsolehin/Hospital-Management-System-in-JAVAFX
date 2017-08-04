/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctors;

import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author danml
 */
public class DoctorsController implements Initializable {

    @FXML
    private JFXComboBox<String> comboSpecialization;
    @FXML
    private JFXComboBox<String> comboDepartment;
    @FXML
    private ToggleGroup q;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Populate Comboboxe with static options,
        comboSpecialization.getItems().addAll("Pychologist","Psychiatric","Gynaecologist"
        +"Pathologist","Cardiologist","Orginologist","unspecified");
        comboSpecialization.getSelectionModel().selectLast();
        
        comboDepartment.getItems().addAll("Pychology","Maternity","OutPatient"
        + "Mourtuary","Others");
        comboDepartment.getSelectionModel().selectLast();
    }    
    
}
