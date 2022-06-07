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
    String user2 = "supervisor";
    String password = "123";
   
    @FXML
    private void eventAction(ActionEvent event){
        
        
         Object evt = event.getSource();
         
         if (evt.equals(btnLogin)){
             
             if (!txtUser.getText().isEmpty() && !txtPassword.getText().isEmpty()){
            	 
            	 if(txtUser.getText().equals(user1) && txtPassword.getText().equals(password)) {
            		 usuario.setNombre(user1);
            		 loadStage("/view/Nutriologo/FXMLViewPrincipal.fxml",event);
            		
            	 } else if(txtUser.getText().equals(user2) && txtPassword.getText().equals(password)) {
            		 usuario.setNombre(user2);
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
    
    try{
        ((Node)(event.getSource())).getScene().getWindow().hide();
        
        Parent root = FXMLLoader.load(getClass().getResource(url));
        Scene scene = new Scene(root);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.show();
        
        newStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
            @Override
            public void handle(WindowEvent event){
                Platform.exit();
            }
        });
        
    }catch(IOException ex){
      //  Logger.getLogger(ViewLoginController.class.getName()).log(Level.SEVERE,null,ex);
    }
}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
