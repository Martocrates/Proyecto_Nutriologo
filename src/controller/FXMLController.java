/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import model.Usuario;
import model.conexion;

import javax.swing.JOptionPane;
import sun.util.logging.PlatformLogger.Level;


/**
 *
 * @author 52999
 */
public class FXMLController implements Initializable {
    
	Usuario usuario = new Usuario();
   
    @FXML
    private TextField txtUser;
    
    @FXML
    private PasswordField txtPassword;
    
    @FXML
    private Button btnLogin;
    
    String user1 = "nutriologo";
    String user2 = "pasante";
    String user3 = "supervisor";
    String password = "123";
   
    @FXML
    private void eventAction(ActionEvent event){
        
        
         Object evt = event.getSource();
         
         if (evt.equals(btnLogin)){
        	 
             
             if (!txtUser.getText().isEmpty() && !txtPassword.getText().isEmpty()){
            	 
            	 if(txtUser.getText().equals(user1) && txtPassword.getText().equals(password)) {
            		 usuario.setNombre(user1);
            		 usuario.setIdUsuario(1);
            		 
            		 loadStage("/view/Nutriologo/FXMLViewPrincipal.fxml",event);
            		
            	 } else if(txtUser.getText().equals(user2) && txtPassword.getText().equals(password)) {
            		 usuario.setNombre(user2);
            		 usuario.setIdUsuario(2);
            		 loadStage("/view/Nutriologo/FXMLViewPrincipal.fxml",event);
            	 } else if(txtUser.getText().equals(user3) && txtPassword.getText().equals(password)) {
            		 usuario.setNombre(user3);
            		 usuario.setIdUsuario(3);
            		 loadStage("/view/Supervisor/FXMLViewPrincipal.fxml",event);
            	 }
            
                 
                 
                 
                 
             }else{
                 JOptionPane.showMessageDialog(null, "ERROR AL INICIAR");
             }
             
             
         }
    }
    
    @FXML private void FinishAplication(ActionEvent event) {
    	Platform.exit();
       // System.exit(0);
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
    }    
    
}
