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
public class FXMLControllerIndicadoresClinicos implements Initializable {
    
	Paciente paciente = new Paciente();
    

    
    
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
    
    @FXML private void SiguienteFormulario(ActionEvent event) {
    	GuardarRespuestasFormulario();
    	
    	if (txtFieldPelo.getText().isEmpty() || txtFieldUnia.getText().isEmpty() ||txtFieldPiel.getText().isEmpty() ||txtFieldDiarrea.getText().isEmpty() ||
    			txtFieldEstrenimiento.getText().isEmpty() ||txtFieldVomito.getText().isEmpty() ||txtFieldColitis.getText().isEmpty() ||txtFieldPirosis.getText().isEmpty() ||
    			txtFieldGastritis.getText().isEmpty() ||txtFieldUlcera.getText().isEmpty() ||txtFieldOjos.getText().isEmpty() ||txtFieldDentadura.getText().isEmpty() ||
    			txtFieldHidratacion.getText().isEmpty() ||txtFieldNauseas.getText().isEmpty() ||txtFieldOtros.getText().isEmpty() ||
    			txtFieldEnfermedadDiagnosticada.getText().isEmpty() ||txtFieldMedicamentoTomado.getText().isEmpty() ||txtFieldCualMedicamentoTomado.getText().isEmpty() ||
    			txtFieldDosisMedicamentoTomado.getText().isEmpty() ||txtFieldDesdeCuandoMedicamento.getText().isEmpty() ||txtFieldAlgunaCirugia.getText().isEmpty() ||
    			txtFieldEspecificarCirugia.getText().isEmpty() ) {
    		
    		Mensaje.MostrarMensajeDatosIncompletos();
    	}else {
        	loadStage("/view/Formulario/FXMLViewIndicadoresDieteticos.fxml",event);

    	}
    }
    @FXML private void CancelarRegistro(ActionEvent event) {
    	loadStage("/view/Nutriologo/FXMLViewPrincipal.fxml",event);
    }
    @FXML private void AnteriorFormulario(ActionEvent event) {
    	GuardarRespuestasFormulario();
    	loadStage("/view/Formulario/FXMLViewDatosBioquimicos.fxml",event);
    }
  
    
  
    public void GuardarRespuestasFormulario() {
    	
    	paciente.setPelo(txtFieldPelo.getText());
        paciente.setUnias(txtFieldUnia.getText());
        paciente.setPiel(txtFieldPiel.getText());
        paciente.setDiarrea(txtFieldDiarrea.getText());
        paciente.setEstrenimiento(txtFieldEstrenimiento.getText());
        
        paciente.setVomito(txtFieldVomito.getText());
        paciente.setColitis(txtFieldColitis.getText());
        paciente.setPirosis(txtFieldPirosis.getText());
        paciente.setGastritis(txtFieldGastritis.getText());
        paciente.setUlcera(txtFieldUlcera.getText());
        
        paciente.setOjos(txtFieldOjos.getText());
        paciente.setDentadura(txtFieldDentadura.getText());
        paciente.setHidratacion(txtFieldHidratacion.getText());
        paciente.setNauseas(txtFieldNauseas.getText());
        paciente.setOtrosDatosClinicos(txtFieldOtros.getText());
        
        paciente.setEnfermedadDiagnosticada(txtFieldEnfermedadDiagnosticada.getText());
        paciente.setTomaAlgunMedicamento(txtFieldMedicamentoTomado.getText());
        paciente.setCualMedicamentoToma(txtFieldCualMedicamentoTomado.getText());
        paciente.setDosisMedicamento(txtFieldDosisMedicamentoTomado.getText());
        
        paciente.setDesdeCuandoMedicamento(txtFieldDesdeCuandoMedicamento.getText());
        paciente.setCirugiasPracticadas(txtFieldAlgunaCirugia.getText());
        paciente.setEspecificarCirugias(txtFieldEspecificarCirugia.getText());
        
    }
    
    public void ObtenerRespuestaFormulario() {
    	
    	
    	txtFieldPelo.setText(paciente.getPelo());
        txtFieldUnia.setText(paciente.getUnias());
        txtFieldPiel.setText(paciente.getPiel());
        txtFieldDiarrea.setText(paciente.getDiarrea());
        txtFieldEstrenimiento.setText(paciente.getEstrenimiento());
        
        txtFieldVomito.setText(paciente.getVomito());
        txtFieldColitis.setText(paciente.getColitis());
        txtFieldPirosis.setText(paciente.getPirosis());
        txtFieldGastritis.setText(paciente.getGastritis());
        txtFieldUlcera.setText(paciente.getUlcera());
        
        txtFieldOjos.setText(paciente.getOjos());
        txtFieldDentadura.setText(paciente.getDentadura());
        txtFieldHidratacion.setText(paciente.getHidratacion());
        txtFieldNauseas.setText(paciente.getNauseas());
        txtFieldOtros.setText(paciente.getOtrosDatosClinicos());
        
        txtFieldEnfermedadDiagnosticada.setText(paciente.getEnfermedadDiagnosticada());
        txtFieldMedicamentoTomado.setText(paciente.getTomaAlgunMedicamento());
        txtFieldCualMedicamentoTomado.setText(paciente.getCualMedicamentoToma());
        txtFieldDosisMedicamentoTomado.setText(paciente.getDosisMedicamento());
        txtFieldDesdeCuandoMedicamento.setText(paciente.getDesdeCuandoMedicamento());
        txtFieldAlgunaCirugia.setText(paciente.getCirugiasPracticadas());
        txtFieldEspecificarCirugia.setText(paciente.getEspecificarCirugias());
        
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
