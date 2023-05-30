/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import static controladores.FXMLRegistro.member;
import io.github.palexdev.materialfx.controls.MFXTextField;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Club;
import model.ClubDAOException;
import model.Member;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FXMLInicioDeSesionController implements Initializable {

    Club club;
    
    
    @FXML
    private Button acceptButton;
    @FXML
    private Button cancelButton;
    
    @FXML
    private MFXTextField passwordField;
    @FXML
    private Label mError;
    @FXML
    private MFXTextField nameField;

    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        
    }    


    @FXML
    private void clickAccept(MouseEvent event) throws IOException, ClubDAOException {
        String nick = nameField.getText();
        String password = passwordField.getText();
        member = Club.getInstance().getMemberByCredentials(nameField.getText(), passwordField.getText());
           if(member==null){
              /* FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLPaginaPersonal.fxml"));
                Parent root = loader.load();
                //Paso el usuario a la siguiente página, de esta forma la siguiente tiene el inicio de sesión
                //Hay q crear un objeto del tipo destino (FXMLPaginaPersonal) Y luego invocar un método del otro controlador al q le metas la variable que desees enviar. En este controlador invoco a setMember que está en controlador 2 y en el segundo lo guardas en una variable
                
                
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                
                stage.setScene(scene);
                stage.setTitle("Inicio de Sesión");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                acceptButton.getScene().getWindow().hide();
               */
               nameField.setText("");
               passwordField.setText("");
               mError.setVisible(true);
               
               
           }
           else{
               FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLPaginaPersonal.fxml"));
                Parent root = loader.load();
                //Paso el usuario a la siguiente página, de esta forma la siguiente tiene el inicio de sesión
                //Hay q crear un objeto del tipo destino (FXMLPaginaPersonal) Y luego invocar un método del otro controlador al q le metas la variable que desees enviar. En este controlador invoco a setMember que está en controlador 2 y en el segundo lo guardas en una variable
                FXMLPaginaPersonalController controlador2 = loader.getController();
                controlador2.setMember(club.getInstance().getMemberByCredentials(nick, password));
                
                acceptButton.getScene().setRoot(root);
           }
           
           
           
           
    
        
    }
        
   

    @FXML
    private void clickCancel(MouseEvent event) throws IOException {
            
            FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLPaginaInicial.fxml"));
                Parent root = loader.load();
                
                
                
                acceptButton.getScene().setRoot(root);
    }


    @FXML
    private void pEnter(KeyEvent event) throws IOException, ClubDAOException {
        if (event.getCode()== KeyCode.ENTER){
            String nick = nameField.getText();
        String password = passwordField.getText();
        member = Club.getInstance().getMemberByCredentials(nameField.getText(), passwordField.getText());
           if(member==null){
              /* FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLPaginaPersonal.fxml"));
                Parent root = loader.load();
                //Paso el usuario a la siguiente página, de esta forma la siguiente tiene el inicio de sesión
                //Hay q crear un objeto del tipo destino (FXMLPaginaPersonal) Y luego invocar un método del otro controlador al q le metas la variable que desees enviar. En este controlador invoco a setMember que está en controlador 2 y en el segundo lo guardas en una variable
                
                
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                
                stage.setScene(scene);
                stage.setTitle("Inicio de Sesión");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                acceptButton.getScene().getWindow().hide();
               */
               nameField.setText("");
               passwordField.setText("");
               mError.setVisible(true);
               
               
           }
           else{
               FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLPaginaPersonal.fxml"));
                Parent root = loader.load();
                //Paso el usuario a la siguiente página, de esta forma la siguiente tiene el inicio de sesión
                //Hay q crear un objeto del tipo destino (FXMLPaginaPersonal) Y luego invocar un método del otro controlador al q le metas la variable que desees enviar. En este controlador invoco a setMember que está en controlador 2 y en el segundo lo guardas en una variable
                FXMLPaginaPersonalController controlador2 = loader.getController();
                controlador2.setMember(club.getInstance().getMemberByCredentials(nick, password));
                
                acceptButton.getScene().setRoot(root);
           }
        }
    }

    @FXML
    private void pEnterNombre(KeyEvent event) {
        if (event.getCode()== KeyCode.ENTER){
            passwordField.requestFocus();
        }
        
    }
}

 
        
        
        

    


  

    

    