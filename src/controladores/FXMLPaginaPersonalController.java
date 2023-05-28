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
import model.Club;
import model.Member;

/**
 * FXML Controller class
 *
 * @author julio
 */
public class FXMLPaginaPersonalController implements Initializable {
    int id = 2;
    Club club;
    Member member;
    @FXML
    private Button CerButton;
    @FXML
    private MFXButton reservButton;
    @FXML
    private MFXButton verResButton;
    @FXML
    private MFXButton verDispButton;
    @FXML
    private MFXButton actButton;
    @FXML
    private Label labelNickName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //labelNickName.setText(member.getNickName());
        
    }    

    @FXML
    private void clickReserv(ActionEvent event)throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLPistas.fxml"));
                Parent root = loader.load();
                FXMLPistasController segundoController = loader.getController();
                segundoController.setPistaSeleccionada(member);
                
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
                
               MisReservas segundoController = loader.getController();
                segundoController.setMiembro(member);
                
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("MisReservas");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                verResButton.getScene().getWindow().hide(); 
    }

    
    @FXML
    private void clickVerDisp(ActionEvent event)throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/Reservas.fxml"));
                Parent root = loader.load();
                
                Reservas controlador2 = loader.getController();
                controlador2.reconocerID(id);
                
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

    void setMember(Member memberByCredentials) {
        member = memberByCredentials; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }

    @FXML
    private void clickCerrarSesion(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLPaginaInicial.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Pagina Inicial");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                actButton.getScene().getWindow().hide();
        
    }
    
}

