/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import io.github.palexdev.materialfx.controls.MFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    private MFXButton verDispButton;
    @FXML
    private MFXButton actButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickReserv(ActionEvent event)throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLPistas.fxml"));
                Parent root = loader.load();
                
                
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Pistas");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                reservButton.getScene().getWindow().hide();
    }

    @FXML
    private void clickVerRes(ActionEvent event)throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/MisReservas.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("MisReservas");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                verResButton.getScene().getWindow().hide(); 
    }

    @FXML
    private void clickAnul(ActionEvent event)throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/MisReservas.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("AnularReservas");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                anulButton.getScene().getWindow().hide();
    }
    @FXML
    private void clickVerDisp(ActionEvent event)throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/Reservas.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Reservas");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                verDispButton.getScene().getWindow().hide();
    }

    @FXML
    private void clickAct(ActionEvent event)throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLRegistro.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Registro");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                actButton.getScene().getWindow().hide();
    }
    
}
