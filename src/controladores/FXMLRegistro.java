/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.io.File;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

import model.Club;
import model.ClubDAOException;
import model.Member;

/**
 * FXML Controller class
 *
 * @author julio
 */


public class FXMLRegistro implements Initializable {

    
    
    private BooleanProperty validPassword;

    private BooleanProperty equalPasswords; 
    private BooleanProperty validCVV;

    private BooleanProperty validTarjeta;
    private BooleanProperty validName;
    private BooleanProperty validUser;
    private BooleanProperty validApellidos;
    private BooleanProperty validTel;
    
    
    String nickName;
    String password;
    String name;
    String surname;
    String creditC;
    Image image;
    int ccv;
    String tel;
    
    public static Member member;
    Club club;
    
    private final int EQUALS = 0;
    @FXML
    private Button acceptButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField nameField;
    @FXML
    private Label nameAlert;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label passwordAlert;
    @FXML
    private TextField apellidosField;
    @FXML
    private Label apellidosAlert;
    @FXML
    private PasswordField repeatField;
    @FXML
    private Label repeatAlert;
    @FXML
    private TextField userField;
    @FXML
    private Label userAlert;
    @FXML
    private TextField telField;
    @FXML
    private Label telAlert;
    @FXML
    private PasswordField cvvField;
    @FXML
    private Label cvvAlert;
    @FXML
    private TextField tarjetaField;
    @FXML
    private Label tarjetaAlert;
    private MFXButton importButton;
    private ImageView fotoPerfil;

  
   
       

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
     
    
 


      private void checkCVV(){
          if(cvvField.textProperty().getValueSafe().length() != 3){
              manageError(cvvAlert, cvvField, validCVV);
          } else {
              manageCorrect(cvvAlert, cvvField, validCVV);
          }
      }
      
      private void checkName(){
          if(nameField.textProperty().getValueSafe().length() < 1 ){
              manageError(nameAlert, nameField, validName);
          } else {
              manageCorrect(nameAlert, nameField, validName);
          }
      }
      
      private void checkApellidos(){
          if(apellidosField.textProperty().getValueSafe().length() < 1){
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
      
      private void checkTel(){
          if(telField.textProperty().getValueSafe().length() != 9){
              manageError(telAlert, telField, validTel);
          } else {
              manageCorrect(telAlert, telField, validTel);
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
 
        
        
        
        validPassword = new SimpleBooleanProperty();   
        validPassword.setValue(Boolean.FALSE);
        
        passwordField.focusedProperty().addListener((observable, oldValue, newValue)-> {
            if(!newValue){
                checkEditPassword();
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
        
        validTel = new SimpleBooleanProperty();
        validTel.setValue(Boolean.FALSE);
        
        telField.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if(!newValue){
                checkTel();
            }
        }));
        
        equalPasswords = new SimpleBooleanProperty();
        equalPasswords.setValue(Boolean.FALSE);
        
        repeatField.focusedProperty().addListener((observable, oldValue, newValue)-> {
           if(!newValue){
               checkEquals();
           }
        }); 
       
        
        
        
        BooleanBinding validFields = Bindings.and(validCVV, validPassword)
                .and(validApellidos).and(validName)
                .and(validUser).and(validTarjeta).and(validTel)
                 .and(equalPasswords);
        
        
        
        acceptButton.disableProperty().bind(Bindings.not(validFields));
    }    


    @FXML
    private void handleBAcceptOnAction(ActionEvent event) throws IOException {
        try {
                    name = nameField.getText();
                    surname = apellidosField.getText();
                    tel = telField.getText();
                    nickName = userField.getText();
                    password = passwordField.getText();
                    creditC = tarjetaField.getText();
                    ccv = Integer.parseInt(cvvField.getText());
                    if (Club.getInstance().existsLogin(nickName)){
                        manageError(userAlert,userField,validUser);
                    } else{
                                         
                       member = Club.getInstance().registerMember(name, surname, tel, nickName, password, creditC, ccv, image);
                    }
                } catch (ClubDAOException ex) {
                    Logger.getLogger(FXMLRegistro.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLPaginaPersonal.fxml"));
                Parent root = loader.load();
               
                acceptButton.getScene().setRoot(root);
        passwordField.textProperty().setValue("");
        repeatField.textProperty().setValue("");
        

        
        validPassword.setValue(Boolean.FALSE);
        equalPasswords.setValue(Boolean.FALSE);
        
        
    }


    @FXML
    private void pEnterNombre(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
            apellidosField.requestFocus();
        }
        
    }

    @FXML
    private void pEnterContraseña(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
            repeatField.requestFocus();
        }
    }

    @FXML
    private void pEnterApellido(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
            passwordField.requestFocus();
        }
    }

    @FXML
    private void pEnterRepetir(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
            telField.requestFocus();
        }
    }

    @FXML
    private void pEnterUsuario(KeyEvent event) {
       if(event.getCode()==KeyCode.ENTER){
            tarjetaField.requestFocus();
        }
    }

    @FXML
    private void pEnterTelefono(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
            userField.requestFocus();
        }
    }

    @FXML
    private void pEnterCVV(KeyEvent event) throws IOException {
        if(event.getCode()==KeyCode.ENTER){
         try {
                    name = nameField.getText();
                    surname = apellidosField.getText();
                    tel = telField.getText();
                    nickName = userField.getText();
                    password = passwordField.getText();
                    creditC = tarjetaField.getText();
                    ccv = Integer.parseInt(cvvField.getText());
                    if (Club.getInstance().existsLogin(nickName)){
                        manageError(userAlert,userField,validUser);
                    } else{
                                         
                       member = Club.getInstance().registerMember(name, surname, tel, nickName, password, creditC, ccv, image);
                    }
                } catch (ClubDAOException ex) {
                    Logger.getLogger(FXMLRegistro.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLPaginaPersonal.fxml"));
                Parent root = loader.load();
               
                acceptButton.getScene().setRoot(root);
        passwordField.textProperty().setValue("");
        repeatField.textProperty().setValue("");
        

        
        validPassword.setValue(Boolean.FALSE);
        equalPasswords.setValue(Boolean.FALSE);}
        
    }

    @FXML
    private void pEnterTarjetaCredito(KeyEvent event) {
        if(event.getCode()==KeyCode.ENTER){
            cvvField.requestFocus();
        }
    }

    @FXML
    private void clickCancel(ActionEvent event) throws IOException {
         FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLPaginaInicial.fxml"));
                Parent root = loader.load();
                cancelButton.getScene().setRoot(root);
    }

    private void clickImportButton(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        configureFileChooser(fileChooser);
        Stage stage = (Stage) importButton.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            image = new Image(selectedFile.toURI().toString());
            fotoPerfil.setImage(image);
        }
    }

    private void configureFileChooser(FileChooser fileChooser) {
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("JPEG", "*.jpg", "*.jpeg")
        );
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg"));
    }
    }
    

    

    

