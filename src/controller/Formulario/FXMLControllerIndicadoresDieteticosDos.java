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
import model.Usuario;

import javax.swing.JOptionPane;
import sun.util.logging.PlatformLogger.Level;


/**
 *
 * @author 52999
 */
public class FXMLControllerIndicadoresDieteticosDos implements Initializable {
    
	Usuario usuario = new Usuario();
    

    
    
    @FXML private Button btnSiguiente;
    @FXML private Button btnCancelar;
    
 
	@FXML
	private void CancelarRegistro(ActionEvent event) {
		loadStage("/view/Nutriologo/FXMLViewPrincipal.fxml", event);
	}

	@FXML
	private void AnteriorFormulario(ActionEvent event) {
		loadStage("/view/Formulario/FXMLViewIndicadoresDieteticos.fxml", event);
	}

	@FXML
	private void GuardarFormulario(ActionEvent event) {
		int resp = JOptionPane.showConfirmDialog(null, "Una vez que guarde no se podra eliminar el registro, Desea continuar?");
		if (JOptionPane.YES_OPTION == resp) {
		
			loadStage("/view/Nutriologo/FXMLViewPrincipal.fxml", event);
		} else {
			
		}
	
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
