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
import javafx.scene.control.Cell;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
    int id;
    
    Club club;
    private ObservableList<Booking> reservas;
    @FXML
    private Button botonVolver;
    @FXML
    private TextField nombreUsuario;
    @FXML
    private Button bBuscar;
    private int currentIndex = -1;
    @FXML
    private ListView<Booking> listView1;

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
        //club.setInitialData();//Para borrar la prueba
        //club.addSimpleData();//Para probar la listview
        ArrayList<Booking> array = club.getBookings();
        reservas = FXCollections.observableArrayList(array);
        listView1.setItems(reservas);
        listView1.setCellFactory(new Callback<ListView<Booking>, ListCell<Booking>>() {
            @Override
            public ListCell<Booking> call(ListView<Booking> listView) {
                return new BookingCells1();
            }
        });
        
        
        
    }    

    @FXML
    private void clickVolver(ActionEvent event) throws IOException {
        if (id==1){
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
        if (id ==2){
            FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLPaginaPersonal.fxml"));
                Parent root = loader.load();
                
                
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Registro");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                botonVolver.getScene().getWindow().hide();
        
        }
    }

    @FXML
    private void textoNombre(ActionEvent event) {
    }

    @FXML
    private void clickBuscar(ActionEvent event) {
        String name = nombreUsuario.getText();
    for (int i = currentIndex + 1; i < listView1.getItems().size(); i++) {
        Booking booking = listView1.getItems().get(i);
        if(i==listView1.getItems().size()-1){i=0;}
        if (booking.getMember().getNickName().equals(name)) {
            listView1.getSelectionModel().select(booking);
            currentIndex = i;
            scrollToSelectedElement();
            
            break;
        }
    }

    }
    
    private void scrollToSelectedElement() {
        int selectedIndex = listView1.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            listView1.scrollTo(selectedIndex);
        }
    }

    @FXML
    private void pEnter(KeyEvent event) {
        if (event.getCode()== KeyCode.ENTER){
            String name = nombreUsuario.getText();
    for (int i = currentIndex + 1; i < listView1.getItems().size(); i++) {
        Booking booking = listView1.getItems().get(i);
        if(i==listView1.getItems().size()-1){i=0;}
        if (booking.getMember().getNickName().equals(name)) {
            listView1.getSelectionModel().select(booking);
            currentIndex = i;
            scrollToSelectedElement();
            break;
                }
            }
        }
    }

    void reconocerID(int idd) {
        id = idd;
    }
}
class BookingCells1 extends ListCell<Booking> {

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




