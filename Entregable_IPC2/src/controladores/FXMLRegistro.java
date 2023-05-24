/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author julio
 */


public class FXMLRegistro implements Initializable {

    
    
    private BooleanProperty validPassword;
    private BooleanProperty validEmail;
    private BooleanProperty equalPasswords; 
    private BooleanProperty validCVV;
    private BooleanProperty validDNI;
    private BooleanProperty validTarjeta;
    
    private final int EQUALS = 0;
    @FXML
    private Button acceptButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField emailField;
    @FXML
    private Label emailAlert;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label passwordAlert;
    @FXML
    private PasswordField repeatField;
    @FXML
    private Label repeatAlert;
    @FXML
    private TextField dniField;
    @FXML
    private TextField nombreField;
    @FXML
    private TextField usuarioField;
    @FXML
    private PasswordField cvvField;
    @FXML
    private TextField tarjetaDeCreditoField;
    @FXML
    private Label dniAlert;
    @FXML
    private Label cvvAlert;
    @FXML
    private Label tarjetaAlert;

    private void manageError(Label errorLabel,TextField textField, BooleanProperty boolProp ){
        boolProp.setValue(Boolean.FALSE);
        showErrorMessage(errorLabel,textField);
        textField.requestFocus();
 
    }
    
    private void manageCorrect(Label errorLabel,TextField textField, BooleanProperty boolProp ){
        boolProp.setValue(Boolean.TRUE);
        hideErrorMessage(errorLabel,textField);
        
    }
    
    private void showErrorMessage(Label errorLabel,TextField textField)
    {
        errorLabel.visibleProperty().set(true);
        textField.styleProperty().setValue("-fx-background-color: #FCE5E0");    
    }
    
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
     
      private void checkEditEmail(){
        if(!Utils.checkEmail(emailField.textProperty().getValueSafe())){
            //Incorrect Email
            manageError(emailAlert, emailField, validEmail);
        }else {
            manageCorrect(emailAlert, emailField, validEmail);
        }
    }
      
      private void checkDNI(){
          if(dniField.textProperty().getValueSafe().length() < 8){
              
          }
      }
    
    
    
    private void checkEquals(){
        if(passwordField.textProperty().getValueSafe().compareTo
        (repeatField.textProperty().getValueSafe()) != EQUALS){
            showErrorMessage(repeatAlert,repeatField);
            equalPasswords.setValue(Boolean.FALSE);
            passwordField.textProperty().setValue("");
            repeatField.textProperty().setValue("");
            passwordField.requestFocus();
        } else {
            manageCorrect(repeatAlert, repeatField, equalPasswords);
        }
    }
   
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        validEmail = new SimpleBooleanProperty();
        validEmail.setValue(Boolean.FALSE);
        
        emailField.focusedProperty().addListener((observable, oldValue, newValue)->{
            if (!newValue){
                checkEditEmail();
            }
        }
        );
        
        
        
        validPassword = new SimpleBooleanProperty();   
        validPassword.setValue(Boolean.FALSE);
        
        passwordField.focusedProperty().addListener((observable, oldValue, newValue)-> {
            if(!newValue){
                checkEditPassword();
            }
        }); 
        
        
        
        equalPasswords = new SimpleBooleanProperty();
        equalPasswords.setValue(Boolean.FALSE);
        
        repeatField.focusedProperty().addListener((observable, oldValue, newValue)-> {
           if(!newValue){
               checkEquals();
           }
        }); 
       
        
        
        
        BooleanBinding validFields = Bindings.and(validEmail, validPassword)
                 .and(equalPasswords);
         

        acceptButton.disableProperty().bind(
                Bindings.not(validFields)
        );
        
        cancelButton.setOnAction((event)-> {
            cancelButton.getScene().getWindow().hide();
        });
    }    

    @FXML
    private void clickAccept(MouseEvent event) {
    }

    @FXML
    private void handleBAcceptOnAction(ActionEvent event) {
        emailField.textProperty().setValue("");
        passwordField.textProperty().setValue("");
        repeatField.textProperty().setValue("");
        
        validEmail.setValue(Boolean.FALSE);
        validPassword.setValue(Boolean.FALSE);
        equalPasswords.setValue(Boolean.FALSE);
    }

    @FXML
    private void clickCancel(MouseEvent event) {
    }
    
}
