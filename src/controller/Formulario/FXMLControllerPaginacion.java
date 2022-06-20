package controller.Formulario;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Paciente;

public class FXMLControllerPaginacion  implements Initializable {
	
	Paciente paciente = new Paciente();
	FXMLControllerAntecedentesFamiliares pageAntecedentesFam = new FXMLControllerAntecedentesFamiliares();
	FXMLControllerDatosAntropologicos pageDatosAntropologicos = new FXMLControllerDatosAntropologicos();
	FXMLControllerDatosBioquimicos pageDatosBioquimicos = new FXMLControllerDatosBioquimicos();
	FXMLControllerDatosPersonales pageDatosPersonales = new FXMLControllerDatosPersonales();
	FXMLControllerIndicadoresClinicos pageIndicadoresClinicos = new FXMLControllerIndicadoresClinicos();
	FXMLControllerIndicadoresDieteticos pageIndicadoresDieteticos = new FXMLControllerIndicadoresDieteticos();
	FXMLControllerIndicadoresDieteticosDos pageIndicadoresDieteticosDos = new FXMLControllerIndicadoresDieteticosDos();


    
    @FXML private Pagination pagination;
    
    @FXML private VBox personalPageForm;
    @FXML private Button btnSiguiente;
    @FXML private Button btnCancelar;
    
    @FXML private TextField txtFieldNombre;
    @FXML private TextField txtFieldApellido;
    @FXML private TextField txtFieldMatricula;
    @FXML private TextField txtFieldEdad;
    @FXML private TextField txtFieldSexo;
    @FXML private TextField txtFieldCarrera;
    @FXML private TextField  txtFieldSemestre;
    @FXML private TextField txtFieldTurno;
    @FXML private TextField  txtFieldFechaNacimiento;
    @FXML private TextField txtFieldOcupacion;
    @FXML private TextField txtFieldTelefono;
    @FXML private TextField txtFieldEmail;
    
  
    static int indexAnterior ;
    static int index;
    
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
    
        pagination.setPageFactory(new Callback<Integer, Node>() {
           @Override
           public Node call(Integer pageIndex) {  
        	   System.out.println("ALFIN? INDEX ANTERIOR: " + indexAnterior + "INDEX ACTUAL: " + pagination.getCurrentPageIndex());
        	   
        	   
               return createPage(pageIndex);
           }
       });
        
   
    }    
    static int temp = 0;
    static int temp2 = 0;
	public VBox createPage(int index) {

		
		this.index = index;
	
		
		Parent root = null;
		try {

			if (this.index  == 0) {
				
			
				
				root = FXMLLoader.load(getClass().getResource("/view/Formulario/FXMLViewDatosPersonales.fxml"));
				
				return (VBox) root;

			}
			else if (this.index  == 1) {
				
				
				root = FXMLLoader.load(getClass().getResource("/view/Formulario/FXMLViewAntecedentesFamiliares.fxml"));
				
				if (temp2 !=0) {
					
				}
				//System.out.println(pageDatosPersonales.getNuevoNombre());

				//return (VBox) root;
			}
			else if (this.index  == 2) {

				
				root = FXMLLoader.load(getClass().getResource("/view/Formulario/FXMLViewDatosAntropologicos.fxml"));

				//return (VBox) root;
			}
			else if (this.index  == 3) {

				root = FXMLLoader.load(getClass().getResource("/view/Formulario/FXMLViewDatosBioquimicos.fxml"));

			//	return (VBox) root;

			}
			else if (this.index  == 4) {
			//	GuardarRespuestasFormulario(index,indexAnterior);
				root = FXMLLoader.load(getClass().getResource("/view/Formulario/FXMLViewIndicadoresClinicos.fxml"));

			//	return (VBox) root;

			}
			else if (this.index  == 5) {
			//	GuardarRespuestasFormulario(index,indexAnterior);
				root = FXMLLoader.load(getClass().getResource("/view/Formulario/FXMLViewIndicadoresDieteticos.fxml"));

			//	return (VBox) root;

			}
			else if (this.index  == 6) {
			//	GuardarRespuestasFormulario(index,indexAnterior);
				root = FXMLLoader
						.load(getClass().getResource("/view/Formulario/FXMLViewIndicadoresDieteticosDos.fxml"));

				//return (VBox) root;

			} else {
				root = FXMLLoader.load(getClass().getResource("/view/Formulario/FXMLViewDatosPersonales.fxml"));

				
			//	return (VBox) root;
			}
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		temp = indexAnterior;
		
		temp2 = 1;
		
		indexAnterior = this.index;

		return (VBox) root;

	}

   public void GuardarRespuestasFormulario(int index, int indexAnterior){
	   
	   System.out.println(paciente.getNombrePaciente()+"NOMBRE QUE SE GUARDA" + "index:"+index+ " anterior: "+indexAnterior);
	   if(index!=indexAnterior) {
		   
		  
	   
		if(indexAnterior==0) {
//			root = FXMLLoader.load(getClass().getResource("/view/Formulario/FXMLViewDatosPersonales.fxml"));
			 System.out.println(paciente.getNombrePaciente()+"NOMBRE QUE SE GUARDA");
	
				pageDatosPersonales.GuardarRespuestasFormulario();
			
			
			
			
		}if(indexAnterior==1) {
//			root = FXMLLoader.load(getClass().getResource("/view/Formulario/FXMLViewAntecedentesFamiliares.fxml"));
			pageAntecedentesFam.GuardarRespuestasFormulario();
			 
		}if(indexAnterior==2) {
		//	root = FXMLLoader.load(getClass().getResource("/view/Formulario/FXMLViewDatosAntropologicos.fxml"));
			pageDatosAntropologicos.GuardarRespuestasFormulario();
			 
		}if(indexAnterior==3) {
		//	root = FXMLLoader.load(getClass().getResource("/view/Formulario/FXMLViewDatosBioquimicos.fxml"));
			pageDatosBioquimicos.GuardarRespuestasFormulario();
			
			
		}if(indexAnterior==4) {
		//	root = FXMLLoader.load(getClass().getResource("/view/Formulario/FXMLViewIndicadoresClinicos.fxml"));
			pageIndicadoresClinicos.GuardarRespuestasFormulario();
			  
		}if(indexAnterior==5) {
		//	root = FXMLLoader.load(getClass().getResource("/view/Formulario/FXMLViewIndicadoresDieteticos.fxml"));
			pageIndicadoresDieteticos.GuardarRespuestasFormulario();
			
		}if(indexAnterior==6) {
		//	root = FXMLLoader.load(getClass().getResource("/view/Formulario/FXMLViewIndicadoresDieteticosDos.fxml"));
			pageIndicadoresDieteticosDos.GuardarRespuestasFormulario();
			
		}else {
		//	root = FXMLLoader.load(getClass().getResource("/view/Formulario/FXMLViewDatosPersonales.fxml"));
			//pageDatosPersonales.GuardarRespuestasFormulario();
			  
		}
		
	   }
    }

}
