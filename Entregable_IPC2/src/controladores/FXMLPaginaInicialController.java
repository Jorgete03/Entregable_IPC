/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author julio
 */
public class FXMLPaginaInicialController implements Initializable {

    @FXML
    private Button botonRegistro;
    @FXML
    private Button botonInicio;
    @FXML
    private Button botonPistas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void clickPistas(ActionEvent event) {
    }

    @FXML
    private void clickRegistrarse(ActionEvent event) throws IOException {
         FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLRegistro.fxml"));
                Parent root = loader.load();
                
                
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Registro");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                botonRegistro.getScene().getWindow().hide();
    }

    @FXML
    private void clickInicioSesion(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLInicioDeSesión.fxml"));
                Parent root = loader.load();
                
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Inicio");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                botonInicio.getScene().getWindow().hide();
    }
    
}
