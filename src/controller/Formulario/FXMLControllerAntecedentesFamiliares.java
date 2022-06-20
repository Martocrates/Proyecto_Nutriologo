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
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
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
    
	@FXML private CheckBox ChBoxObesidad;
	@FXML private CheckBox ChBoxDiabetes;
	@FXML private CheckBox ChBoxHTA;
	@FXML private CheckBox ChBoxCancer;
	@FXML private CheckBox ChBoxHipercolesterolemia;
	@FXML private CheckBox ChBoxHipertrigliceridemia;
    
    
    @FXML private Button btnSiguiente;
    @FXML private Button btnCancelar;
    
    @FXML private VBox pageAntecedentesFam;
    public VBox createPage(int index) {
    	 
       
 
    	   Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("/view/Formulario/FXMLViewAntecedentesFamiliares.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       
        
        
        return (VBox) root;
    }  
 
    @FXML private void CancelarRegistro(ActionEvent event) {
    	loadStage("/view/Nutriologo/FXMLViewPrincipal.fxml",event);
    }
    @FXML private void AnteriorFormulario(ActionEvent event) {
    	loadStage("/view/Formulario/FXMLViewDatosPersonales.fxml",event);
    	GuardarRespuestasFormulario();
    	
    }
    @FXML private void SiguienteFormulario(ActionEvent event) {
    	
    	GuardarRespuestasFormulario();
    	
    	loadStage("/view/Formulario/FXMLViewDatosAntropologicos.fxml",event);
    }
    
  
    public void GuardarRespuestasFormulario() {
    	 if(ChBoxObesidad.isSelected()) {
    		 paciente.setObesidad("Si");
    	 }else {
    		 paciente.setObesidad("No");
    	 }
    	 
    	 if(ChBoxDiabetes.isSelected()) {
    		 paciente.setDiabetes("Si");
    	 }else {
    		 paciente.setDiabetes("No");
    	 }
    	 
    	 if(ChBoxHTA.isSelected()) {
    		 paciente.setHta("Si");
    	 }else {
    		 paciente.setHta("No");
    	 }
    	 
    	 if(ChBoxCancer.isSelected()) {
    		 paciente.setCancer("Si");
    	 }else {
    		 paciente.setCancer("No");
    	 }
    	 
    	 if(ChBoxHipercolesterolemia.isSelected()) {
    		 paciente.setHipercolesterolemia("Si");
    	 }else {
    		 paciente.setHipercolesterolemia("No");
    	 }
    	 
    	 if(ChBoxHipertrigliceridemia.isSelected()) {
    		 paciente.setHipertrigliceridemia("Si");
    	 }else {
    		 paciente.setHipertrigliceridemia("No");
    	 }
    	
    }
    
    public void ObtenerRespuestaFormulario() {
    	 if(paciente.getObesidad().equals("Si")) {
    		 ChBoxObesidad.setSelected(true);
    	 }else {
    		 ChBoxObesidad.setSelected(false);
    	 }
    	 
    	 if(paciente.getDiabetes().equals("Si") ) {
    		 ChBoxDiabetes.setSelected(true);
    		 
    	 }else {
    		 ChBoxDiabetes.setSelected(false);
    	 }
    	 
    	 if(paciente.getHta().equals("Si")) {
    		 ChBoxHTA.setSelected(true);
    	 }else {
    		 ChBoxHTA.setSelected(false);
    	 }
    	 
    	 if(paciente.getCancer().equals("Si")) {
    		
    		 ChBoxCancer.setSelected(true);
    	 }else {
    		 ChBoxCancer.setSelected(false);
    	 }
    	 
    	 if(paciente.getHipercolesterolemia().equals("Si")) {
    		 
    		 ChBoxHipercolesterolemia.setSelected(true);
    	 }else {
    		 ChBoxHipercolesterolemia.setSelected(false);
    	 }
    	 
    	 if(paciente.getHipertrigliceridemia().equals("Si")) {
    		 paciente.setHipertrigliceridemia("Si");
    		 ChBoxHipertrigliceridemia.setSelected(true);
    	 }else {
    		 ChBoxHipertrigliceridemia.setSelected(false);
    	 }
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
