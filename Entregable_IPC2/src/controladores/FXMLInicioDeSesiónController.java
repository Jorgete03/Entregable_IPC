/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
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

/**
 * FXML Controller class
 *
 * @author julio
 */
public class FXMLInicioDeSesiónController implements Initializable {

   //properties to control valid fieds values. 
    private BooleanProperty validPassword;
    private BooleanProperty validName;
    
    
    //private BooleanBinding validFields;
    
    //When to strings are equal, compareTo returns zero  
    @FXML
    private Button acceptButton;
    @FXML
    private Button cancelButton;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label passwordAlert;
    @FXML
    private TextField nameField;
    
    
   
    

    /**
     * Updates the boolProp to false.Changes to red the background of the edit. 
     * Makes the error label visible and sends the focus to the edit. 
     * @param errorLabel label added to alert the user
     * @param textField edit text added to allow user to introduce the value
     * @param boolProp property which stores if the value is correct or not
     */
    private void manageError(Label errorLabel,TextField textField, BooleanProperty boolProp ){
        boolProp.setValue(Boolean.FALSE);
        showErrorMessage(errorLabel,textField);
        textField.requestFocus();
 
    }
    /**
     * Updates the boolProp to true. Changes the background 
     * of the edit to the default value. Makes the error label invisible. 
     * @param errorLabel label added to alert the user
     * @param textField edit text added to allow user to introduce the value
     * @param boolProp property which stores if the value is correct or not
     */
    private void manageCorrect(Label errorLabel,TextField textField, BooleanProperty boolProp ){
        boolProp.setValue(Boolean.TRUE);
        hideErrorMessage(errorLabel,textField);
        
    }
    /**
     * Changes to red the background of the edit and
     * makes the error label visible
     * @param errorLabel
     * @param textField 
     */
    private void showErrorMessage(Label errorLabel,TextField textField)
    {
        errorLabel.visibleProperty().set(true);
        textField.styleProperty().setValue("-fx-background-color: #FCE5E0");    
    }
    /**
     * Changes the background of the edit to the default value
     * and makes the error label invisible.
     * @param errorLabel
     * @param textField 
     */
    private void hideErrorMessage(Label errorLabel,TextField textField)
    {
        errorLabel.visibleProperty().set(false);
        textField.styleProperty().setValue("");
    }


    private void checkEditPassword(){
        if(!Utils.checkPassword(passwordField.textProperty().getValueSafe())){
            manageError(passwordAlert, passwordField, validPassword);
        } else{
            manageCorrect(passwordAlert, passwordField, validPassword);
        }
    }
    
    private void checkName(){
    }
    
    
    //=========================================================
    // you must initialize here all related with the object 
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        validName = new SimpleBooleanProperty();   
        validName.setValue(Boolean.FALSE);
        
        nameField.focusedProperty().addListener((observable, oldValue, newValue)-> {
            if(!newValue){
                checkName();
            }
        }); 
         
        
        validPassword = new SimpleBooleanProperty();   
        validPassword.setValue(Boolean.FALSE);
        
        passwordField.focusedProperty().addListener((observable, oldValue, newValue)-> {
            if(!newValue){
                checkEditPassword();
            }
        }); 
        
 
        BooleanBinding validFields = Bindings.and(validName, validPassword);
                 
         //Deshabilitar boton acceptar

        acceptButton.disableProperty().bind(
                Bindings.not(validFields)
        );
        
        // Ir a la página personal
        acceptButton.setOnAction((event) -> {
            try {
                
                FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLPaginaPersonal.fxml"));
                Parent root = loader.load();
                
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Inicio");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                acceptButton.getScene().getWindow().hide();
            } catch (IOException ex) {
                Logger.getLogger(FXMLInicioDeSesiónController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        cancelButton.setOnAction((event)-> {
            try {
                cancelButton.getScene().getWindow().hide();
                FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLPaginaInicial.fxml"));
                Parent root = loader.load();
                
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Inicio");
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLInicioDeSesiónController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    } 

    @FXML
    private void clickAccept(MouseEvent event) {
    }

    @FXML
    private void clickCancel(MouseEvent event) {
    }
   
    @FXML
    private void handleBAcceptOnAction(ActionEvent event){
        nameField.textProperty().setValue("");
        passwordField.textProperty().setValue("");
        
        validName.setValue(Boolean.FALSE);
        validPassword.setValue(Boolean.FALSE);
    }
}

