/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Booking;
import model.Club;
import model.ClubDAOException;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Reservas implements Initializable {

    
    Club club;
    @FXML
    private ListView<Booking> listVew1;
    private ObservableList<Booking> reservas;
    @FXML
    private Button botonVolver;
    @FXML
    private TextField nombreUsuario;
    @FXML
    private Button bBuscar;
    private int currentIndex = -1;

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
        club.addSimpleData();
        ArrayList<Booking> array = club.getBookings();
        reservas = FXCollections.observableArrayList(array);
        listVew1.setItems(reservas);
        listVew1.setCellFactory(new Callback<ListView<Booking>, ListCell<Booking>>() {
            @Override
            public ListCell<Booking> call(ListView<Booking> listView) {
                return new BookingCell();
            }
        });
        
        
    }    

    @FXML
    private void clickVolver(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLPaginaInicial.fxml"));
                Parent root = loader.load();
                
                
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Registro");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                botonVolver.getScene().getWindow().hide();
    }

    @FXML
    private void textoNombre(ActionEvent event) {
    }

    @FXML
    private void clickBuscar(ActionEvent event) {
        String name = nombreUsuario.getText();
    for (int i = currentIndex + 1; i < listVew1.getItems().size(); i++) {
        Booking booking = listVew1.getItems().get(i);
        if (booking.getMember().getNickName().equals(name)) {
            listVew1.getSelectionModel().select(booking);
            currentIndex = i;
            break;
        }
    }

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


