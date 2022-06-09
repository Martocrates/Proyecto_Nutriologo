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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Paciente;
import model.Usuario;
import model.conexion;

import javax.swing.JOptionPane;
import sun.util.logging.PlatformLogger.Level;


/**
 *
 * @author 52999
 */
public class FXMLControllerIndicadoresDieteticosDos implements Initializable {
    
	Paciente paciente = new Paciente();
	conexion miConexion = new conexion();

    
    
    @FXML private Button btnSiguiente;
    @FXML private Button btnCancelar;
    
    @FXML private TextArea txtAreaAlimentosPreferidos;
    @FXML private TextArea txtAreaAlimentosNoAgradables;
    @FXML private TextArea txtAreaAlimentosMalestar;
    @FXML private TextArea txtAreaSuplementos;
    @FXML private TextArea txtAreaRecordatorio;
    
 
	@FXML
	private void CancelarRegistro(ActionEvent event) {
		loadStage("/view/Nutriologo/FXMLViewPrincipal.fxml", event);
	}

	@FXML
	private void AnteriorFormulario(ActionEvent event) {
		
		GuardarRespuestasFormulario();
		loadStage("/view/Formulario/FXMLViewIndicadoresDieteticos.fxml", event);
	}

	@FXML
	private void GuardarFormulario(ActionEvent event) {
		int resp = JOptionPane.showConfirmDialog(null, "Una vez que guarde no se podra eliminar el registro, Desea continuar?");
		if (JOptionPane.YES_OPTION == resp) {
		
			  LocalDate todaysDate = LocalDate.now();
			  
			  paciente.setFechaPaciente(todaysDate+"");
			  
			  
			  
			    miConexion.ingresaPaciente();
		       
			loadStage("/view/Nutriologo/FXMLViewPrincipal.fxml", event);
		} else {
			
		}
	
	}
	private void GuardarRespuestasFormulario() {
		
		paciente.setAlimentosPreferidos(txtAreaAlimentosPreferidos.getText());
		paciente.setAlimentosNoAgradables(txtAreaAlimentosNoAgradables.getText());
		paciente.setAlimentosMalestar(txtAreaAlimentosMalestar.getText());
		paciente.setSuplementos(txtAreaSuplementos.getText());
		paciente.setRecordatorio(txtAreaRecordatorio.getText());
		
	}
	
	  public void ObtenerRespuestaFormulario() {
		  
		  
		  txtAreaAlimentosPreferidos.setText(paciente.getAlimentosPreferidos());
		  txtAreaAlimentosNoAgradables.setText(paciente.getAlimentosNoAgradables());
		  txtAreaAlimentosMalestar.setText(paciente.getAlimentosMalestar());
		  txtAreaSuplementos.setText(paciente.getSuplementos());
		  txtAreaRecordatorio.setText(paciente.getRecordatorio());
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
