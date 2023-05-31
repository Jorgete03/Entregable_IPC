/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import static controladores.FXMLRegistro.member;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
import javafx.scene.image.ImageView;
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
   
    @FXML
    private Button botonVolver;
    @FXML
    private ListView<Booking> listVew1;
    @FXML
    private Button bBorrar;
    @FXML
    private Label NombreUsuario;
    @FXML
    private ImageView fotoPerfil;

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
        
        NombreUsuario.setText(member.getNickName());
        fotoPerfil.setImage(member.getImage());
        List<Booking> array = club.getUserBookings(member.getNickName());
        ObservableList<Booking> reservasOld = FXCollections.observableArrayList(array);
        LocalDateTime d = LocalDateTime.now();
        Collections.sort(reservasOld, Comparator.comparing(Booking::getBookingDate).reversed());
        ObservableList<Booking> reservas= FXCollections.observableArrayList();
        if(reservasOld.size()>=1){
        reservas.add(reservasOld.get(0));}
        if(reservasOld.size()>=2){
        reservas.add(reservasOld.get(1));}
        
        
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
    private void clickBorrar(ActionEvent event) throws ClubDAOException, IOException {
         LocalDateTime d = LocalDateTime.now();
        club.getInstance();
        ObservableList<Booking> reservas = listVew1.getItems();
        if((reservas.get(listVew1.getSelectionModel().getSelectedIndex()).getBookingDate().getHour()-d.getHour()>=24 && reservas.get(listVew1.getSelectionModel().getSelectedIndex()).getBookingDate().getDayOfYear()-d.getDayOfYear()>=1)){
                reservas.remove(listVew1.getSelectionModel().getSelectedIndex());
                club.removeBooking(listVew1.getSelectionModel().getSelectedItem());
            }
    }

    void setMiembro(Member miembro) {
        //member = miembro;// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
             setText("Usuario: " + t.getMember().getNickName() + " " +t.getCourt().getName() + " Día: " + t.getMadeForDay().toString() + " Hora: " + t.getFromTime().toString());
        }

    }
}