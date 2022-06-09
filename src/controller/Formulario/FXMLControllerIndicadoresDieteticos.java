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
    
    @FXML private TextField txtFieldComidasAlDia;
    @FXML private TextField txtFieldDondeCome;
    @FXML private TextField txtFieldQuienPreparaAlimento;
    @FXML private TextField txtFieldCambiosHambre;
    @FXML private TextField txtFieldHaModificadoAlimentacion;
    @FXML private TextField txtFieldPorQueHaModificadoAlimentacion;
    
 
    @FXML private void CancelarRegistro(ActionEvent event) {
    	loadStage("/view/Nutriologo/FXMLViewPrincipal.fxml",event);
    }
    @FXML private void AnteriorFormulario(ActionEvent event) {
    	GuardarRespuestasFormulario();
    	loadStage("/view/Formulario/FXMLViewIndicadoresClinicos.fxml",event);
    }
    @FXML private void SiguienteFormulario(ActionEvent event) {
    	GuardarRespuestasFormulario();
    	loadStage("/view/Formulario/FXMLViewIndicadoresDieteticosDos.fxml",event);
    }
    
    private void GuardarRespuestasFormulario() {
    	
    	paciente.setComidasAlDia(txtFieldComidasAlDia.getText());
    	paciente.setDondeCome(txtFieldDondeCome.getText());
    	paciente.setQuienPreparaAlimentos(txtFieldQuienPreparaAlimento.getText());
    	paciente.setCambiosEnHambre(txtFieldCambiosHambre.getText());
    	paciente.setModificacionAlimentacion(txtFieldHaModificadoAlimentacion.getText());
    	paciente.setRazonDeModificacionAlimentacion(txtFieldPorQueHaModificadoAlimentacion.getText());
    	
    }
    
    public void ObtenerRespuestaFormulario() {
    	
    	txtFieldComidasAlDia.setText(paciente.getComidasAlDia());
    	txtFieldDondeCome.setText(paciente.getDondeCome());
    	txtFieldQuienPreparaAlimento.setText(paciente.getQuienPreparaAlimentos());
    	txtFieldCambiosHambre.setText(paciente.getCambiosEnHambre());
    	txtFieldHaModificadoAlimentacion.setText(paciente.getModificacionAlimentacion());
    	txtFieldPorQueHaModificadoAlimentacion.setText(paciente.getRazonDeModificacionAlimentacion());
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
