/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Historia_Clinica;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Paciente;
import model.Usuario;

import javax.swing.JOptionPane;
import sun.util.logging.PlatformLogger.Level;


/**
 *
 * @author 52999
 */
public class FXMLControllerDatosBioquimicos implements Initializable {
    
	Paciente paciente = new Paciente();
    


	@FXML private Button btnAtras;
    @FXML private Button btnSiguiente;
    @FXML private Button btnSalir;
    
    @FXML private Text txtConsumoTabaco;
    @FXML private Text txtFrecuenciaTabaco;
    
    @FXML private Text txtConsumoAlcohol;
    @FXML private Text txtFrecuenciaAlcohol;
    
    @FXML private Text txtActividadFisica;
    @FXML private Text txtFrecuenciaActividadFisica;
    @FXML private Text txtDuracionActividadFisica;
    
    @FXML private Text txtGlucosa;
    @FXML private Text txtColesterol;
    @FXML private Text txtTrigliceridos;
    @FXML private Text txtAlbumia;
    @FXML private Text txtOtros;
 
    @FXML private void SalirFormulario(ActionEvent event) {
    	
    	loadStage("/view/Registro_Paciente/FXMLViewRegistroPaciente.fxml",event);
    }
    
    @FXML private void SiguienteFormulario(ActionEvent event) {
    	 
    	loadStage("/view/Historia_Clinica/FXMLViewAlimentosPreferidos.fxml", event);
  
    }
    
    @FXML private void AtrasFormulario(ActionEvent event) {
   	 
    	loadStage("/view/Historia_Clinica/FXMLViewAntecedentesFamiliares.fxml", event);
  
    }
    
  
    
 
    private void loadStage(String url, Event event){
        
   	 try {

   	        Parent root = FXMLLoader.load(getClass().getResource(url));
   	        Scene scene = new Scene(root);
   	        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
   	        appStage.setScene(scene);
   	        appStage.toFront();
   	        appStage.show();

   	    } catch (Exception e) {
   	    }
   }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    	 	txtConsumoTabaco.setText(paciente.getConsumoTabaco());
    	 	txtFrecuenciaTabaco.setText(paciente.getFrecuenciaTabaco());
    	    
    	 	txtConsumoAlcohol.setText(paciente.getConsumoAlcohol());
    	 	txtFrecuenciaAlcohol.setText(paciente.getFrecuenciaAlcohol());
    	    
    	    txtActividadFisica.setText(paciente.getActividadFisica());
    	    txtFrecuenciaActividadFisica.setText(paciente.getFrecuenciaActividad());
    	    txtDuracionActividadFisica.setText(paciente.getDuracionActividad());
    	    
    	    txtGlucosa.setText(paciente.getGlucosa());
    	    txtColesterol.setText(paciente.getColesterol());
    	    txtTrigliceridos.setText(paciente.getTrigliceridos());
    	    txtAlbumia.setText(paciente.getAlbumia());
    	    txtOtros.setText(paciente.getOtrosDatosBioquimicos());
    	
    }    
    
}
