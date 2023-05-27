/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import io.github.palexdev.materialfx.controls.MFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author julio
 */
public class FXMLPaginaPersonalController implements Initializable {

    @FXML
    private Button CerButton;
    @FXML
    private TextField nickField;
    @FXML
    private MFXButton reservButton;
    @FXML
    private MFXButton verResButton;
    @FXML
    private MFXButton anulButton;
    @FXML
    private Label verDispButton;
    @FXML
    private Label ActButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickReserv(ActionEvent event) {
        
    }

    @FXML
    private void clickVerRes(ActionEvent event) {
    }

    @FXML
    private void clickAnul(ActionEvent event) {
    }

    @FXML
    private void clickVerDisp(MouseEvent event) {
    }

    @FXML
    private void clickAct(MouseEvent event) {
    }
    
}
