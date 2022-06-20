/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Formulario;

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
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Mensaje;
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
    

	@FXML private TextField txtFieldConsumoTabaco;
	@FXML private TextField txtFieldTabacoFrecuencia;
	
	@FXML private TextField txtFieldConsumoAlcohol;
	@FXML private TextField txtFieldAlcoholFrecuencia;
	
	@FXML private TextField txtFieldActividadFisica;
	@FXML private TextField txtFieldActividadFisicaFrecuencia;
	@FXML private TextField txtFieldActividadFisicaDuracion;
    
	@FXML private TextField txtFieldGlucosa;
	@FXML private TextField txtFieldColesterol;
	@FXML private TextField txtFieldTrigliceridos;
	@FXML private TextField txtFieldAlbumia;
	@FXML private TextField txtFieldOtros;
	
    @FXML private Button btnSiguiente;
    @FXML private Button btnCancelar;
    
 
    @FXML private void CancelarRegistro(ActionEvent event) {
    	
    	loadStage("/view/Nutriologo/FXMLViewPrincipal.fxml",event);
    }
    @FXML private void AnteriorFormulario(ActionEvent event) {
    	 GuardarRespuestasFormulario();
    	loadStage("/view/Formulario/FXMLViewDatosAntropologicos.fxml",event);
    }
    @FXML private void SiguienteFormulario(ActionEvent event) {
    	 GuardarRespuestasFormulario();
    	 
    	 if(txtFieldConsumoTabaco.getText().isEmpty() || txtFieldTabacoFrecuencia.getText().isEmpty() || txtFieldConsumoAlcohol.getText().isEmpty() || txtFieldAlcoholFrecuencia.getText().isEmpty() ||
    			 txtFieldActividadFisica.getText().isEmpty() ||txtFieldActividadFisicaFrecuencia.getText().isEmpty() ||txtFieldActividadFisicaDuracion.getText().isEmpty() ||
    			 txtFieldGlucosa.getText().isEmpty() || txtFieldColesterol.getText().isEmpty() ||txtFieldTrigliceridos.getText().isEmpty() ||txtFieldAlbumia.getText().isEmpty() ||
    			 txtFieldOtros.getText().isEmpty()) {
    		 
    		 Mensaje.MostrarMensajeDatosIncompletos();
    	 }else {
    	    	loadStage("/view/Formulario/FXMLViewIndicadoresClinicos.fxml",event);
    	 }
    	 
    	 

    }
    
  
    
    
    public void GuardarRespuestasFormulario() {
    	
    	paciente.setConsumoTabaco(txtFieldConsumoTabaco.getText());
    	paciente.setFrecuenciaTabaco(txtFieldTabacoFrecuencia.getText());
    	
    	paciente.setConsumoAlcohol(txtFieldConsumoAlcohol.getText());
    	paciente.setFrecuenciaAlcohol(txtFieldAlcoholFrecuencia.getText());
    	
    	paciente.setActividadFisica(txtFieldActividadFisica.getText());
    	paciente.setFrecuenciaActividad(txtFieldActividadFisicaFrecuencia.getText());
    	paciente.setDuracionActividad(txtFieldActividadFisicaDuracion.getText());
        
    	paciente.setGlucosa(txtFieldGlucosa.getText());
    	paciente.setColesterol(txtFieldColesterol.getText());
    	paciente.setTrigliceridos(txtFieldTrigliceridos.getText());
    	paciente.setAlbumia(txtFieldAlbumia.getText());
    	paciente.setOtrosDatosBioquimicos(txtFieldOtros.getText());
    	
    }
    
    public void ObtenerRespuestaFormulario() {
    	
    	txtFieldConsumoTabaco.setText(paciente.getConsumoTabaco());
    	txtFieldTabacoFrecuencia.setText(paciente.getFrecuenciaTabaco());
    	
    	txtFieldConsumoAlcohol.setText(paciente.getConsumoAlcohol());
    	txtFieldAlcoholFrecuencia.setText(paciente.getFrecuenciaAlcohol());
    	
    	txtFieldActividadFisica.setText(paciente.getActividadFisica());
    	txtFieldActividadFisicaFrecuencia.setText(paciente.getFrecuenciaActividad());
    	txtFieldActividadFisicaDuracion.setText(paciente.getDuracionActividad());
        
    	txtFieldGlucosa.setText(paciente.getGlucosa());
    	txtFieldColesterol.setText(paciente.getColesterol());
    	txtFieldTrigliceridos.setText(paciente.getTrigliceridos());
    	txtFieldAlbumia.setText(paciente.getAlbumia());
    	txtFieldOtros.setText(paciente.getOtrosDatosBioquimicos());
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
    	ObtenerRespuestaFormulario();
    }    
    
}
