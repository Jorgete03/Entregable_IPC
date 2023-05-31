/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;


import static controladores.FXMLRegistro.member;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Club;
import model.ClubDAOException;
import model.Court;
import model.Member;

/**
 * FXML Controller class
 *
 * @author julio
 */

public class FXMLPistasController implements Initializable {
    Club club;
    public static Court pistaseleccionada;
   
    
    
    
    @FXML
    private Button bVolver;
    @FXML
    private Label labelField;
    @FXML
    private ImageView fotoPerfil;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        labelField.setText(member.getNickName());
        fotoPerfil.setImage(member.getImage());

    }    

    @FXML
    private void clickPista1(ActionEvent event) throws IOException {
        try {
            pistaseleccionada = club.getInstance().getCourt("Pista 1");
        } catch (ClubDAOException ex) {
            Logger.getLogger(FXMLPistasController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPistasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/ReservarPista.fxml"));
                Parent root = loader.load();
                ReservarPista segundoController = loader.getController();
                //segundoController.setPistaSeleccionada(pistaseleccionada);
                //segundoController.setMiembro(member);
                
                
                bVolver.getScene().setRoot(root);
        
    }

    @FXML
    private void clickPista3(ActionEvent event) throws IOException {
        try {
            pistaseleccionada = club.getInstance().getCourt("Pista 3");
        } catch (ClubDAOException ex) {
            Logger.getLogger(FXMLPistasController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPistasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/ReservarPista.fxml"));
                Parent root = loader.load();
                ReservarPista segundoController = loader.getController();
                //segundoController.setPistaSeleccionada(pistaseleccionada);
                //segundoController.setMiembro(member);
                
                
                bVolver.getScene().setRoot(root);
    }

    @FXML
    private void clickPista5(ActionEvent event) throws IOException {
        try {
            pistaseleccionada = club.getInstance().getCourt("Pista 5");
        } catch (ClubDAOException ex) {
            Logger.getLogger(FXMLPistasController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPistasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/ReservarPista.fxml"));
                Parent root = loader.load();
                ReservarPista segundoController = loader.getController();
                //segundoController.setPistaSeleccionada(pistaseleccionada);
                //segundoController.setMiembro(member);
                
               
                bVolver.getScene().setRoot(root);
    }

    @FXML
    private void clickPista2(ActionEvent event) throws IOException {
        try {
            pistaseleccionada = club.getInstance().getCourt("Pista 2");
        } catch (ClubDAOException ex) {
            Logger.getLogger(FXMLPistasController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPistasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/ReservarPista.fxml"));
                Parent root = loader.load();
                ReservarPista segundoController = loader.getController();
                //segundoController.setPistaSeleccionada(pistaseleccionada);
                //segundoController.setMiembro(member);
                
                
                bVolver.getScene().setRoot(root);
    }

    @FXML
    private void clickPista4(ActionEvent event) throws IOException {
        try {
            pistaseleccionada = club.getInstance().getCourt("Pista 4");
        } catch (ClubDAOException ex) {
            Logger.getLogger(FXMLPistasController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPistasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/ReservarPista.fxml"));
                Parent root = loader.load();
                ReservarPista segundoController = loader.getController();
                //segundoController.setPistaSeleccionada(pistaseleccionada);
                ///segundoController.setMiembro(member);
                
                
                bVolver.getScene().setRoot(root);
    }

    @FXML
    private void clickPista6(ActionEvent event) throws IOException {
        try {
            pistaseleccionada = club.getInstance().getCourt("Pista 6");
        } catch (ClubDAOException ex) {
            Logger.getLogger(FXMLPistasController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLPistasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/ReservarPista.fxml"));
                Parent root = loader.load();
                ReservarPista segundoController = loader.getController();
                //segundoController.setPistaSeleccionada(pistaseleccionada);
                //segundoController.setMiembro(member);
                
               
                bVolver.getScene().setRoot(root);
    }

    void setPistaSeleccionada(Member miembro) {
        member = miembro; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @FXML
    private void clickVolver(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLPaginaPersonal.fxml"));
                Parent root = loader.load();
                
                
                
                bVolver.getScene().setRoot(root);
    }
    
}
/*FXMLSegundoController segundoController = loader.getController();
        segundoController.setPistaSeleccionada(pistaSeleccionada);*/