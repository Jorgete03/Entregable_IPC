/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import static controladores.FXMLRegistro.member;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
    @FXML
    private Label mPagado;
    @FXML
    private Label horasAlert;

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

        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime bookingDateTime = LocalDateTime.of(reservas.get(listVew1.getSelectionModel().getSelectedIndex()).getMadeForDay(), reservas.get(listVew1.getSelectionModel().getSelectedIndex()).getFromTime());

        if (ChronoUnit.HOURS.between(currentDateTime, bookingDateTime) >= 24) {
            club.removeBooking(listVew1.getSelectionModel().getSelectedItem());
            reservas.remove(listVew1.getSelectionModel().getSelectedIndex());
            horasAlert.setVisible(false);
        } else {
            horasAlert.setVisible(true);
        }
            
        
      
        
    }

    void setMiembro(Member miembro) {
        //member = miembro;// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @FXML
    private void bPagar(ActionEvent event) throws ClubDAOException, IOException {
        ObservableList<Booking> reservas = listVew1.getItems();
        if(listVew1.getSelectionModel().getSelectedItem().getPaid()){
            mPagado.setText("Ya habia sido pagado");
        }
        else{
            club.getInstance().removeBooking(listVew1.getSelectionModel().getSelectedItem());
            listVew1.getSelectionModel().getSelectedItem().setPaid(Boolean.TRUE);
            
            mPagado.setText("Pago actualizado");
            
            
            listVew1.setCellFactory(new Callback<ListView<Booking>, ListCell<Booking>>() {
            public ListCell<Booking> call(ListView<Booking> listView) {
                return new BookingCell();
            }
        });
            club.getUserBookings(member.getNickName()).add(listVew1.getSelectionModel().getSelectedItem());
        }
    }
    
}


class BookingCell extends ListCell<Booking> {

    @Override
    protected void updateItem(Booking t, boolean bln) {
        String pagado;
        /* (t.getPaid()){pagado = "Pagadp";}
        else{pagado="Pendiente de pago";}*/
        super.updateItem(t, bln); //To change body of generated methods, choose Tools | Templates.
        if (bln) // esta vacia
        {
            setText("");
        } else {
            if (t.getPaid()){
             setText("Usuario: " + t.getMember().getNickName() + " " +t.getCourt().getName() + " Día: " + t.getMadeForDay().toString() + " Hora: " + t.getFromTime().toString() +" Pagado" );}
             else{
                setText("Usuario: " + t.getMember().getNickName() + " " +t.getCourt().getName() + " Día: " + t.getMadeForDay().toString() + " Hora: " + t.getFromTime().toString() +" Pendiente de pago" );
        }
        }

    }
}