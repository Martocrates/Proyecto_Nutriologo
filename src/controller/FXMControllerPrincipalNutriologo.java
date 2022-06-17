package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

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
import model.conexion;

public class FXMControllerPrincipalNutriologo implements Initializable{
	
	Paciente paciente = new Paciente();
	conexion miConexion = new conexion();
	
	@FXML private TextField txtUser;
    
    
	@FXML private PasswordField txtPassword;
    
   
    @FXML private Button btnConsultar;
    @FXML private Button btnCerrarSesion;
    @FXML private Button btnIngresar;
    
 
    @FXML
    private void eventAction(ActionEvent event){
        
        
         Object evt = event.getSource();
         
         if (evt.equals(btnConsultar)){
        	 
        	
             
        	  loadStage("/view/Registro_Paciente/FXMLViewRegistroPaciente.fxml",event);
             
             
         }
    }
    
    @FXML private void CerrarSesion(ActionEvent event) {
    	loadStage("/view/Login/FXMLViewLogin.fxml",event);
    }
    @FXML private void IngresarRegistro(ActionEvent event) {
    	paciente.reiniciarDatos();
    	
    	
    	loadStage("/view/Formulario/FXMLViewDatosPersonales.fxml",event);
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
    
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	
    	 
    	
    }    
}
