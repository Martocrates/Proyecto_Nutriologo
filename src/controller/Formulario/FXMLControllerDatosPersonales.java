/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Formulario;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
public class FXMLControllerDatosPersonales implements Initializable {
    
	Paciente paciente = new Paciente();
    

    
    
    @FXML private Button btnSiguiente;
    @FXML private Button btnCancelar;
    
    @FXML private TextField txtFieldNombre;
    @FXML private TextField txtFieldApellido;
    @FXML private TextField txtFieldMatricula;
    @FXML private TextField txtFieldEdad;
    @FXML private TextField txtFieldSexo;
    @FXML private TextField txtFieldCarrera;
    @FXML private TextField  txtFieldSemestre;
    @FXML private TextField txtFieldTurno;
    @FXML private TextField  txtFieldFechaNacimiento;
    @FXML private TextField txtFieldOcupacion;
    @FXML private TextField txtFieldTelefono;
    @FXML private TextField txtFieldEmail;
    
  
    
 
    @FXML private void CancelarRegistro(ActionEvent event) {
    	loadStage("/view/Nutriologo/FXMLViewPrincipal.fxml",event);
    }
    @FXML private void SiguienteFormulario(ActionEvent event) {
    	
    	
    	GuardarRespuestasFormulario();
    	
    	if(txtFieldNombre.getText().isEmpty() || txtFieldApellido.getText().isEmpty() || txtFieldMatricula.getText().isEmpty() || 
    			txtFieldEdad.getText().isEmpty() || txtFieldSexo.getText().isEmpty() || txtFieldCarrera.getText().isEmpty() || 
    			txtFieldSemestre.getText().isEmpty() || txtFieldTurno.getText().isEmpty() || txtFieldFechaNacimiento.getText().isEmpty() || 
    			txtFieldOcupacion.getText().isEmpty() || txtFieldTelefono.getText().isEmpty() || txtFieldEmail.getText().isEmpty() ) {
    		Mensaje.MostrarMensajeDatosIncompletos();
    	}else {
    		loadStage("/view/Formulario/FXMLViewAntecedentesFamiliares.fxml",event);
    	}
    	
    	
    
    }
  
    public void GuardarRespuestasFormulario() {
    	


    	paciente.setMatriculaPaciente(Integer.parseInt(txtFieldMatricula.getText()));
    	paciente.setNombrePaciente(txtFieldNombre.getText());
    	
    	paciente.setApellidoPaciente(txtFieldApellido.getText());	
    	LocalDate todaysDate = LocalDate.now();
    	paciente.fecha.set(todaysDate+"");
    	paciente.setFechaPaciente(todaysDate+"");
    	
    	
    	paciente.setEdad(Integer.parseInt(txtFieldEdad.getText()));
    
    	paciente.setSexo(txtFieldSexo.getText());
    	paciente.setCarrera(txtFieldCarrera.getText());
    	paciente.setSemestre(Integer.parseInt(txtFieldSemestre.getText()));
    	paciente.setTurno(txtFieldTurno.getText());
    	paciente.setFechaNacimiento(txtFieldFechaNacimiento.getText());
    	paciente.setOcupacion(txtFieldOcupacion.getText());
    	paciente.setTelefono(txtFieldTelefono.getText());
    	paciente.setEmail(txtFieldEmail.getText());
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
   
    	txtFieldNombre.setText(paciente.getNombrePaciente());
    	
    	txtFieldApellido.setText(paciente.getApellidoPaciente());
    	txtFieldEdad.setText(paciente.getEdad()+"");
    	txtFieldSexo.setText(paciente.getSexo());
    	txtFieldCarrera.setText(paciente.getCarrera());
    	txtFieldSemestre.setText(paciente.getSemestre()+"");
    	
    	txtFieldTurno.setText(paciente.getTurno());
    	txtFieldFechaNacimiento.setText(paciente.getFechaNacimiento());
    	txtFieldOcupacion.setText(paciente.getOcupacion());
    	txtFieldTelefono.setText(paciente.getTelefono());
    	txtFieldEmail.setText(paciente.getEmail());
    	txtFieldMatricula.setText(paciente.getMatriculaPaciente()+"");

    }    
    
}
