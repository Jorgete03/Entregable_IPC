/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

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
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Club;
import model.ClubDAOException;

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
        try {
            // TODO
            club.getInstance();
        } catch (ClubDAOException ex) {
            Logger.getLogger(FXMLInicioDeSesionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLInicioDeSesionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    


    @FXML
    private void clickAccept(MouseEvent event) throws IOException, ClubDAOException {
           if(club.getInstance().getMemberByCredentials(nameField.getText(), passwordField.getText())==null){
               nameField.setText("");
               passwordField.setText("");
               mError.setVisible(true);
               
           }
           else{
               FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLPaginaPersonal.fxml"));
                Parent root = loader.load();
                
                
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                
                stage.setScene(scene);
                stage.setTitle("Inicio de Sesión");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                acceptButton.getScene().getWindow().hide();
           }
           
           
           
           
    
        
    }
        
   

    @FXML
    private void clickCancel(MouseEvent event) throws IOException {
            
            FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLPaginaInicial.fxml"));
                Parent root = loader.load();
                
                
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                
                stage.setScene(scene);
                stage.setTitle("Inicio de Sesión");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                acceptButton.getScene().getWindow().hide();
    }

}
 
        
        
        

    


  

    

    