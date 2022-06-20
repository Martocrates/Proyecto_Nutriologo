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
public class FXMLControllerDatosAntropologicos implements Initializable {
    
	Paciente paciente = new Paciente();
    

    
    
    @FXML private Button btnSiguiente;
    @FXML private Button btnCancelar;
    
    @FXML private TextField	txtFieldPeso;
    @FXML private TextField	txtFieldTalla;
    @FXML private TextField	txtFieldIMC;
    @FXML private TextField	txtFieldPerimetroCintura;
    @FXML private TextField	txtFieldPerimetroCadera;
    @FXML private TextField	txtFieldICC;
    
 
    @FXML private void CancelarRegistro(ActionEvent event) {
    	
    	loadStage("/view/Nutriologo/FXMLViewPrincipal.fxml",event);
    }
    @FXML private void AnteriorFormulario(ActionEvent event) {
    	GuardarRespuestasFormulario();
    	loadStage("/view/Formulario/FXMLViewAntecedentesFamiliares.fxml",event);
    }
    @FXML private void SiguienteFormulario(ActionEvent event) {
    	GuardarRespuestasFormulario();
    	
    	if (Float.parseFloat(txtFieldPeso.getText())<1 || Float.parseFloat(txtFieldTalla.getText())<1 ||Float.parseFloat( txtFieldIMC.getText())< 1 ||
    			Float.parseFloat(txtFieldPerimetroCintura.getText())<1 || Float.parseFloat(txtFieldPerimetroCadera.getText())<1 || Float.parseFloat(txtFieldICC.getText())<1) {
    		Mensaje.MostrarMensajeDatosIrreales();
    	}else {
    		loadStage("/view/Formulario/FXMLViewDatosBioquimicos.fxml",event);
    	}
    	
    	
    }
    
  
    public void ObtenerRespuestaFormulario() {
    	 txtFieldPeso.setText(paciente.getPeso()+"");
    	 txtFieldTalla.setText(paciente.getTalla()+"");
    	 txtFieldIMC.setText(paciente.getImc()+"");
    	 txtFieldPerimetroCintura.setText(paciente.getPerimetroCintura()+"");
    	 txtFieldPerimetroCadera.setText(paciente.getPerimetroCadera()+"");
    	 txtFieldICC.setText(paciente.getIcc()+"");
    	
    }
    public void GuardarRespuestasFormulario() {
  //  	Double.parseDouble()
    	   	paciente.setPeso(Float.parseFloat(txtFieldPeso.getText()));
    	    paciente.setTalla(Float.parseFloat(txtFieldTalla.getText()));
    	    paciente.setImc(Float.parseFloat(txtFieldIMC.getText()));
    	    paciente.setPerimetroCintura(Float.parseFloat(txtFieldPerimetroCintura.getText()));
    	    paciente.setPerimetroCadera(Float.parseFloat(txtFieldPerimetroCadera.getText()));
    	    paciente.setIcc(Float.parseFloat(txtFieldICC.getText()));
    	
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
