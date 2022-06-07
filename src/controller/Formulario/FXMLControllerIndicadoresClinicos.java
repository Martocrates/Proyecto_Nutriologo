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
public class FXMLControllerIndicadoresClinicos implements Initializable {
    
	Usuario usuario = new Usuario();
    

    
    
    @FXML private Button btnSiguiente;
    @FXML private Button btnCancelar;
    
    @FXML private TextField txtFieldPelo;
    @FXML private TextField txtFieldUnia;
    @FXML private TextField txtFieldPiel;
    @FXML private TextField txtFieldDiarrea;
    @FXML private TextField txtFieldEstrenimiento;
    
    @FXML private TextField  txtFieldVomito;
    @FXML private TextField txtFieldColitis;
    @FXML private TextField txtFieldPirosis;
    @FXML private TextField txtFieldGastritis;
    @FXML private TextField txtFieldUlcera;
    
    @FXML private TextField txtFieldOjos;
    @FXML private TextField txtFieldDentadura;
    @FXML private TextField txtFieldHidratacion;
    @FXML private TextField txtFieldNauseas;
    @FXML private TextField txtFieldOtros;
    
    @FXML private TextField txtFieldEnfermedadDiagnosticada;
    @FXML private TextField txtFieldMedicamentoTomado;
    @FXML private TextField txtFieldCualMedicamentoTomado;
    @FXML private TextField txtFieldDosisMedicamentoTomado;
    @FXML private TextField txtFieldDesdeCuandoMedicamento;
    @FXML private TextField txtFieldAlgunaCirugia;
    @FXML private TextField txtFieldEspecificarCirugia;
    
 
    @FXML private void CancelarRegistro(ActionEvent event) {
    	loadStage("/view/Nutriologo/FXMLViewPrincipal.fxml",event);
    }
    @FXML private void AnteriorFormulario(ActionEvent event) {
    	GuardarRespuestasFormulario();
    	loadStage("/view/Formulario/FXMLViewDatosBioquimicos.fxml",event);
    }
    @FXML private void SiguienteFormulario(ActionEvent event) {
    	GuardarRespuestasFormulario();
    	loadStage("/view/Formulario/FXMLViewIndicadoresDieteticos.fxml",event);
    }
    
  
    private void GuardarRespuestasFormulario() {
    	/*
    	@FXML private TextField txtFieldPelo;
        @FXML private TextField txtFieldUnia;
        @FXML private TextField txtFieldPiel;
        @FXML private TextField txtFieldDiarrea;
        @FXML private TextField txtFieldEstrenimiento;
        
        @FXML private TextField  txtFieldVomito;
        @FXML private TextField txtFieldColitis;
        @FXML private TextField txtFieldPirosis;
        @FXML private TextField txtFieldGastritis;
        @FXML private TextField txtFieldUlcera;
        
        @FXML private TextField txtFieldOjos;
        @FXML private TextField txtFieldDentadura;
        @FXML private TextField txtFieldHidratacion;
        @FXML private TextField txtFieldNauseas;
        @FXML private TextField txtFieldOtros;
        
        txtFieldEnfermedadDiagnosticada;
        txtFieldMedicamentoTomado;
        txtFieldCualMedicamentoTomado;
        txtFieldDosisMedicamentoTomado;
        txtFieldDesdeCuandoMedicamento;
        txtFieldAlgunaCirugia;
        txtFieldEspecificarCirugia; */
        
    }
    
    public void ObtenerRespuestaFormulario() {
    	
    	
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
    	ObtenerRespuestaFormulario();
    }    
    
}
