/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

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
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import model.Club;
import model.ClubDAOException;

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
    private BooleanProperty validName;
    private BooleanProperty validUser;
    private BooleanProperty validApellidos;
    
    Club club;
    
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
    private Label dniAlert;
    @FXML
    private Label cvvAlert;
    @FXML
    private Label tarjetaAlert;
    @FXML
    private TextField nameField;
    @FXML
    private TextField userField;
    @FXML
    private PasswordField cvvField;
    @FXML
    private TextField tarjetaField;
    @FXML
    private Label nameAlert;
    @FXML
    private TextField apellidosField;
    @FXML
    private Label apellidosAlert;
    @FXML
    private Label userAlert;
    
   
       

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
          if(dniField.textProperty().getValueSafe().length() != 8){
              manageError(dniAlert, dniField, validDNI);
          } else {
              manageCorrect(dniAlert, dniField, validDNI);
          }
      }


      private void checkCVV(){
          if(cvvField.textProperty().getValueSafe().length() != 3){
              manageError(cvvAlert, cvvField, validCVV);
          } else {
              manageCorrect(cvvAlert, cvvField, validCVV);
          }
      }
      
      private void checkName(){
          if(nameField.textProperty().getValueSafe().length() < 1 && nameField.textProperty().getValueSafe().contains(" ")){
              manageError(nameAlert, nameField, validName);
          } else {
              manageCorrect(nameAlert, nameField, validName);
          }
      }
      
      private void checkApellidos(){
          if(apellidosField.textProperty().getValueSafe().length() < 1  && !nameField.textProperty().getValueSafe().contains(" ")){
              manageError(apellidosAlert, apellidosField, validApellidos);
          } else {
              manageCorrect(apellidosAlert, apellidosField, validApellidos);
          }
      }
      
      private void checkUser(){
          if(userField.textProperty().getValueSafe().length() < 1 && userField.textProperty().getValueSafe().contains(" ")){
              manageError(userAlert, userField, validUser);
          } else {
              manageCorrect(userAlert, userField, validUser);
          }
      }
      
      private void checkTarjeta(){
          if(tarjetaField.textProperty().getValueSafe().length() != 16){
              manageError(tarjetaAlert, tarjetaField, validTarjeta);
          } else {
              manageCorrect(tarjetaAlert, tarjetaField, validTarjeta);
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
        
        
       
        
        try {
            club= Club.getInstance();
        } catch (ClubDAOException ex) {
            Logger.getLogger(FXMLRegistro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
        
        validDNI = new SimpleBooleanProperty();
        validDNI.setValue(Boolean.FALSE);
        
        dniField.focusedProperty().addListener((observable, oldValue, newValue)-> {
            if(!newValue){
                checkDNI();
            }
        }); 
        
        validName = new SimpleBooleanProperty();
        validName.setValue(Boolean.FALSE);
        
        nameField.focusedProperty().addListener((observable, oldValue, newValue)-> {
            if(!newValue){
                checkName();
            }
        }); 
        
        validApellidos = new SimpleBooleanProperty();
        validApellidos.setValue(Boolean.FALSE);
        
        apellidosField.focusedProperty().addListener((observable, oldValue, newValue)-> {
            if(!newValue){
                checkApellidos();
            }
        }); 
        
        validUser = new SimpleBooleanProperty();
        validUser.setValue(Boolean.FALSE);
        
        userField.focusedProperty().addListener((observable, oldValue, newValue)-> {
            if(!newValue){
                checkUser();
            }
        }); 
        
        validTarjeta = new SimpleBooleanProperty();
        validTarjeta.setValue(Boolean.FALSE);
        
        tarjetaField.focusedProperty().addListener((observable, oldValue, newValue)-> {
            if(!newValue){
                checkTarjeta();
            }
        }); 
        
        validCVV = new SimpleBooleanProperty();
        validCVV.setValue(Boolean.FALSE);
        
        cvvField.focusedProperty().addListener((observable, oldValue, newValue)-> {
            if(!newValue){
                checkCVV();
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
                .and(validCVV).and(validApellidos).and(validName)
                .and(validUser).and(validDNI).and(validTarjeta)
                 .and(equalPasswords);
         

        acceptButton.disableProperty().bind(
                Bindings.not(validFields)
        );
        
       
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
    private void clickCancel(MouseEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLPaginaInicial.fxml"));
                Parent root = loader.load();
                
                
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Registro");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                acceptButton.getScene().getWindow().hide();
    }
    

    
}
