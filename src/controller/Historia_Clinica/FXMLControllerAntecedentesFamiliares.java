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
public class FXMLControllerAntecedentesFamiliares implements Initializable {
    
Paciente paciente = new Paciente();
    


	
    @FXML private Button btnSiguiente;
    @FXML private Button btnSalir;
    @FXML private Button btnAtras;
    
    @FXML private Text txtObesidad;
    @FXML private Text txtDiabetes;
    @FXML private Text txtHTA;
    
    @FXML private Text txtCancer;
    @FXML private Text txtHipercolesterolemia;
    @FXML private Text txtHipertrigliceridemia;
    
    @FXML private Text txtPeso;
    @FXML private Text txtTalla;
    @FXML private Text txtIMC;
    @FXML private Text txtPerimetroCintura;
    @FXML private Text txtPerimetroCadera;
    @FXML private Text txtICC;
    
 
 
    @FXML private void AnteriorFormulario(ActionEvent event) {
   	 
    	loadStage("/view/Historia_Clinica/FXMLViewDatosPersonales.fxml",event);
    }
    
    @FXML private void SalirFormulario(ActionEvent event) {
    	
    	loadStage("/view/Registro_Paciente/FXMLViewRegistroPaciente.fxml",event);
    }
    
    @FXML private void SiguienteFormulario(ActionEvent event) {
   	 	System.out.println("XD");
   	 loadStage("/view/Historia_Clinica/FXMLViewDatosBioquimicos.fxml",event);
  
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
    	
    	 txtObesidad.setText(paciente.getObesidad());
    	 txtDiabetes.setText(paciente.getDiabetes());
    	 txtHTA.setText(paciente.getHta());
    	    
    	 txtCancer.setText(paciente.getCancer());
    	 txtHipercolesterolemia.setText(paciente.getHipercolesterolemia());
    	 txtHipertrigliceridemia.setText(paciente.getHipertrigliceridemia());
    	    
    	 txtPeso.setText(paciente.getPeso()+"");
    	 txtTalla.setText(paciente.getTalla()+"");
    	 txtIMC.setText(paciente.getImc()+"");
    	 txtPerimetroCintura.setText(paciente.getPerimetroCintura()+"");
    	 txtPerimetroCadera.setText(paciente.getPerimetroCadera()+"");
    	 txtICC.setText(paciente.getIcc()+"");
    }    
    
}
