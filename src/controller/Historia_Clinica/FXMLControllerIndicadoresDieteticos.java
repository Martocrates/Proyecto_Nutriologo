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
import model.Mensaje;
import model.Paciente;
import model.Usuario;

import javax.swing.JOptionPane;
import sun.util.logging.PlatformLogger.Level;


/**
 *
 * @author 52999
 */
public class FXMLControllerIndicadoresDieteticos implements Initializable {
    
	Paciente paciente = new Paciente();
    

    
    
    @FXML private Button btnSiguiente;
    @FXML private Button btnCancelar;
    
    @FXML private Text txtComidasAlDia;
    @FXML private Text txtDondeCome;
    @FXML private Text txtQuienPreparaAlimentos;
    @FXML private Text txtCambiosHambre;
    @FXML private Text txtHaModificadoAlimentacion;
    @FXML private Text txtPorqueHaModificadoAlimentacion;
    
 
    @FXML private void CancelarRegistro(ActionEvent event) {
    	loadStage("/view/Registro_Paciente/FXMLViewRegistroPaciente.fxml",event);
    }
    @FXML private void AnteriorFormulario(ActionEvent event) {
    	loadStage("/view/Historia_Clinica/FXMLViewIndicadoresClinicos.fxml", event);
    }
    @FXML private void SiguienteFormulario(ActionEvent event) {
    	
    	loadStage("/view/Historia_Clinica/FXMLViewAlimentosPreferidos.fxml", event);

    	
    	
    }
    
  
    
    public void ObtenerRespuestaFormulario() {
    	
    	txtComidasAlDia.setText(paciente.getComidasAlDia());
    	txtDondeCome.setText(paciente.getDondeCome());
    	txtQuienPreparaAlimentos.setText(paciente.getQuienPreparaAlimentos());
    	txtCambiosHambre.setText(paciente.getCambiosEnHambre());
    	txtHaModificadoAlimentacion.setText(paciente.getModificacionAlimentacion());
    	txtPorqueHaModificadoAlimentacion.setText(paciente.getRazonDeModificacionAlimentacion());
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
