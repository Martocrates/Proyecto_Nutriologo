package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Paciente;
import model.Usuario;

public class FXMLControllerRegistros_Pacientes implements Initializable{
	
	Usuario usuario = new Usuario();
	
	@FXML private TextField txtUser;
	@FXML private PasswordField txtPassword;
	
	@FXML private Button btnVolver;
	@FXML private Button btnVer;
	@FXML private Button btnEditar;
//	@FXML private Button btnEliminar;
	
	//Variables de la tabla
	@FXML private TableView<Paciente> tablaPacientes;

	@FXML private TableColumn matricula;
	@FXML private TableColumn nombre;
	@FXML private TableColumn apellido;
	@FXML private TableColumn fecha;
	
	private int posicionPersonaEnTabla;
	
	ObservableList<Paciente> pacientes;
    @FXML
    private void eventKey(KeyEvent event){
        
        
        Object evt = event.getSource();
        
        if(evt.equals(txtUser)){
            
            if(event.getCharacter().equals(" ")){
                event.consume();
            }
            
        }else if(evt.equals(txtPassword)){
            
            if(event.getCharacter().equals(" ")){
                event.consume();
            }
        }
    }
    @FXML
    private void eventAction(ActionEvent event){
        
        
         Object evt = event.getSource();
         
         if (evt.equals(btnVolver)){
             if(usuario.getNombre().equals("supervisor")) {
            	 loadStage("/view/Supervisor/FXMLViewPrincipal.fxml",event);
             }else if(usuario.getNombre().equals("nutriologo")) {
            	 loadStage("/view/Nutriologo/FXMLViewPrincipal.fxml",event);
             }
        	  
             
             
         }
         if (evt.equals(btnVer)){
             
       		System.out.println("XD");
       		Paciente paciente = new Paciente();
       		
       		
       		paciente.matricula.set("A1");
       		paciente.nombre.set("A2");
       		paciente.apellido.set("A3");
       		paciente.fecha.set("A4");
       		
       		pacientes.add(paciente);
        }
        
         if (evt.equals(btnEditar)){
             
        	
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
/**
 * Listener de la tabla personas
 */
private final ListChangeListener<Paciente> selectorTablaPersonas =
        new ListChangeListener<Paciente>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Paciente> c) {
                ponerPersonaSeleccionada();
            }
        };

/**
 * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
 */
public Paciente getTablaPersonasSeleccionada() {
    if (tablaPacientes != null) {
        List<Paciente> tabla = tablaPacientes.getSelectionModel().getSelectedItems();
        if (tabla.size() == 1) {
            final Paciente competicionSeleccionada = tabla.get(0);
            return competicionSeleccionada;
        }
    }
    return null;
}

/**
 * Método para poner en los textFields la tupla que selccionemos
 */
private void ponerPersonaSeleccionada() {
    final Paciente persona = getTablaPersonasSeleccionada();
    posicionPersonaEnTabla = pacientes.indexOf(persona);
/*
    if (persona != null) {

        // Pongo los textFields con los datos correspondientes
        nombreTF.setText(persona.getNombre());
        apellidoTF.setText(persona.getApellido());
        edadTF.setText(persona.getEdad().toString());
        telefonoTF.setText(persona.getTelefono());

        // Pongo los botones en su estado correspondiente
        modificarBT.setDisable(false);
        eliminarBT.setDisable(false);
        aniadirBT.setDisable(true);

    }*/
}

/*	Para modificar
@FXML private void modificar(ActionEvent event) {
    Paciente paciente = new Paciente();
    paciente.nombre.set(nombreTF.getText());
    paciente.apellido.set(apellidoTF.getText());
    paciente.edad.set(Integer.parseInt(edadTF.getText()));
    paciente.telefono.set(telefonoTF.getText());
    paciente.set(posicionPersonaEnTabla, persona);
}
*/
@FXML private void eliminar(ActionEvent event) {
    pacientes.remove(posicionPersonaEnTabla);
}
/**
 * Método para inicializar la tabla
 */
    private void inicializarTablaPacientes() {
    	matricula.setCellValueFactory(new PropertyValueFactory<Paciente,String>("matricula"));
    	nombre.setCellValueFactory(new PropertyValueFactory<Paciente,String>("nombre"));
    	apellido.setCellValueFactory(new PropertyValueFactory<Paciente,String>("apellido"));
    	fecha.setCellValueFactory(new PropertyValueFactory<Paciente,String>("fecha"));
    	
    	pacientes = FXCollections.observableArrayList();
    	tablaPacientes.setItems(pacientes);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Inicializamos la tabla
        this.inicializarTablaPacientes();

       

        // Seleccionar las tuplas de la tabla de las personas
        final ObservableList<Paciente> tablaPersonaSel = tablaPacientes.getSelectionModel().getSelectedItems();
        tablaPersonaSel.addListener(selectorTablaPersonas);
        
        if (usuario.getNombre().equals("supervisor")) {
        	btnEditar.setDisable(true);
        }else if (usuario.getNombre().equals("nutriologo")) {
        	
        }
        
        // Inicializamos la tabla con algunos datos aleatorios
       
}
    }
