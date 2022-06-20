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
    
    @FXML private Text txtPelo;
    @FXML private Text txtUnia;
    @FXML private Text txtPiel;
    @FXML private Text txtDiarrea;
    @FXML private Text txtEstrenimiento;
    @FXML private Text txtEnfermedadDiagnosticada;
    @FXML private Text txtTomaAlgunMedicamento;
    @FXML private Text txtCualMedicamentoToma;
    @FXML private Text txtDosisMedicamento;
    @FXML private Text txtLeHanPracticadoCirugia;
    @FXML private Text txtVomito;
    @FXML private Text txtColitis;
    @FXML private Text txtPirosis;
    @FXML private Text txtGastritis;
    @FXML private Text txtUlcera;
    @FXML private Text txtOjos;
    @FXML private Text txtDentadura;
    @FXML private Text txtHidratacion;
    @FXML private Text txtNauseas;
    @FXML private Text txtOtros;
    @FXML private Text txtDesdeCuandoMedicamento;
    @FXML private Text txtEspecificarCirugia;
	@FXML
	private void SiguienteFormulario(ActionEvent event) {

    	loadStage("/view/Historia_Clinica/FXMLViewIndicadoresDieteticos.fxml", event);

	}

	@FXML
	private void CancelarRegistro(ActionEvent event) {
    	loadStage("/view/Registro_Paciente/FXMLViewRegistroPaciente.fxml",event);
	}

	@FXML
	private void AnteriorFormulario(ActionEvent event) {
		
		loadStage("/view/Historia_Clinica/FXMLViewDatosBioquimicos.fxml",event);
		}
  

    
    public void ObtenerRespuestaFormulario() {
    	
    	
    	txtPelo.setText(paciente.getPelo());
        txtUnia.setText(paciente.getUnias());
        txtPiel.setText(paciente.getPiel());
        txtDiarrea.setText(paciente.getDiarrea());
        txtEstrenimiento.setText(paciente.getEstrenimiento());
        
        txtVomito.setText(paciente.getVomito());
        txtColitis.setText(paciente.getColitis());
        txtPirosis.setText(paciente.getPirosis());
        txtGastritis.setText(paciente.getGastritis());
        txtUlcera.setText(paciente.getUlcera());
        
        txtOjos.setText(paciente.getOjos());
        txtDentadura.setText(paciente.getDentadura());
        txtHidratacion.setText(paciente.getHidratacion());
        txtNauseas.setText(paciente.getNauseas());
        txtOtros.setText(paciente.getOtrosDatosClinicos());
        
        txtEnfermedadDiagnosticada.setText(paciente.getEnfermedadDiagnosticada());
        txtTomaAlgunMedicamento.setText(paciente.getTomaAlgunMedicamento());
        txtCualMedicamentoToma.setText(paciente.getCualMedicamentoToma());
        txtDosisMedicamento.setText(paciente.getDosisMedicamento());
        txtDesdeCuandoMedicamento.setText(paciente.getDesdeCuandoMedicamento());
        txtLeHanPracticadoCirugia.setText(paciente.getCirugiasPracticadas());
        txtEspecificarCirugia.setText(paciente.getEspecificarCirugias());
        
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
