/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;
import static controladores.FXMLPistasController.pistaseleccionada;
import static controladores.FXMLRegistro.member;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Booking;
import model.Club;
import model.ClubDAOException;
import model.Court;
import model.Member;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ReservarPista implements Initializable {
    int currentIndex;
    Club club;
    Court court;
   
    private ObservableList<LocalTime> hora;
    @FXML
    private MFXButton botonVolver;
    @FXML
    private MFXButton bReservar1;
    @FXML
    private MFXDatePicker menuDia;
    @FXML
    private ListView<LocalTime> listView;
    @FXML
    private Label nickName;
    @FXML
    private ImageView fotoPerfil;
    @FXML
    private MFXButton bReservar12;
    @FXML
    private Label labelError;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            nickName.setText(member.getNickName());
             fotoPerfil.setImage(member.getImage());
            club.getInstance();
        } catch (ClubDAOException ex) {
            Logger.getLogger(ReservarPista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReservarPista.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<LocalTime> hora = FXCollections.observableArrayList();
        for(int i = 9; i<22;i++){
            hora.add(LocalTime.of(i, 0));
            
        }
        
        listView.setItems(hora);
        listView.setCellFactory(new Callback<ListView<LocalTime>, ListCell<LocalTime>>() {
            @Override
            public ListCell<LocalTime> call(ListView<LocalTime> listView) {
                return new BookingCells();
            }
        });
    }    

    @FXML
    private void clickVolver(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLPistas.fxml"));
                Parent root = loader.load();
                botonVolver.getScene().setRoot(root);
    }


    
    

    @FXML
    private void clickReservar(ActionEvent event) throws ClubDAOException, IOException {
        if (member.checkHasCreditInfo()&&member.getSvc()!=-1){
        LocalDate dia = menuDia.getValue();
        LocalTime hora1 = listView.getSelectionModel().getSelectedItem();
        LocalDateTime momento = LocalDateTime.now();
        club.getInstance().registerBooking(momento, dia, hora1, true, pistaseleccionada, member);
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLPistas.fxml"));
                Parent root = loader.load();
                botonVolver.getScene().setRoot(root);}
        else{
            labelError.setText("Debe ingresar los datos de la tarjeta");
        }
        
    }

    @FXML
    private void pEnter(KeyEvent event) {
    }

    void setPistaSeleccionada(Court pistaseleccionada) {
        court = pistaseleccionada; 
    }

    void setMiembro(Member miembro) {
        member=miembro; 
    }

    @FXML
    private void clickReservarSinPagar(ActionEvent event) throws ClubDAOException, IOException {
        
        LocalDate dia = menuDia.getValue();
        LocalTime hora1 = listView.getSelectionModel().getSelectedItem();
        LocalDateTime momento = LocalDateTime.now();
        club.getInstance().registerBooking(momento, dia, hora1, false, pistaseleccionada, member);
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vistas/FXMLPistas.fxml"));
                Parent root = loader.load();
                botonVolver.getScene().setRoot(root);
    }
}

class BookingCells extends ListCell<LocalTime> {



         @Override
            protected void updateItem(LocalTime item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.toString());
                }
            }
}



    


   
    

    

