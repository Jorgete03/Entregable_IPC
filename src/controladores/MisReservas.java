/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Booking;
import model.Club;
import model.ClubDAOException;
import model.Member;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class MisReservas implements Initializable {
    Club club;
    Member member;
    
    @FXML
    private Button botonVolver;
    @FXML
    private ListView<Booking> listVew1;
    @FXML
    private Button bBorrar;
    @FXML
    private Label NombreUsuario;
    @FXML
    private ToolBar labelNickName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            club = Club.getInstance();
        } catch (IOException | ClubDAOException ex) {
            Logger.getLogger(Reservas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //club.setInitialData();
        //club.addSimpleData();
        
        //IMPORTANTE quitar comentario la terminar Registro
        
        //NombreUsuario.setText(member.getNickName());
        ArrayList<Booking> array = club.getBookings();
        ObservableList<Booking> reservas = FXCollections.observableArrayList(array);
        listVew1.setItems(reservas);
        listVew1.setCellFactory(new Callback<ListView<Booking>, ListCell<Booking>>() {
            @Override
            public ListCell<Booking> call(ListView<Booking> listView) {
                return new BookingCell();
            }
        });
    }    

    @FXML
    private void clickVolver(ActionEvent event)  throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLPaginaPersonal.fxml"));
                Parent root = loader.load();
                
                botonVolver.getScene().setRoot(root);
    }


    @FXML
    private void clickBorrar(ActionEvent event) {
    }

    void setMiembro(Member miembro) {
        member = miembro;// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
class BookingCell extends ListCell<Booking> {

    @Override
    protected void updateItem(Booking t, boolean bln) {
        super.updateItem(t, bln); //To change body of generated methods, choose Tools | Templates.
        if (bln) // esta vacia
        {
            setText("");
        } else {
            setText(t.getMember().getNickName() + " " +t.getCourt().getName() + " " + t.getBookingDate().toString());
        }

    }
}