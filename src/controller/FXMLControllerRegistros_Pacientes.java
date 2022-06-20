package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Paciente;
import model.Usuario;
import model.conexion;

public class FXMLControllerRegistros_Pacientes implements Initializable {

	Usuario usuario = new Usuario();
	Paciente paciente = new Paciente();
	conexion miConexion = new conexion();
	
	ArrayList<String> MATRICULA = new ArrayList<String>(); // Create an ArrayList object
	ArrayList<String> NOMBRE = new ArrayList<String>(); // Create an ArrayList object
	ArrayList<String> APELLIDOS = new ArrayList<String>(); // Create an ArrayList object
	ArrayList<String> FECHA = new ArrayList<String>(); // Create an ArrayList object
	
	int contador =0;
	@FXML
	private TextField txtUser;
	
	@FXML private TextField txtFieldBuscarMatricula;
	
	@FXML
	private PasswordField txtPassword;

	@FXML
	private Button btnVolver;
	@FXML
	private Button btnVer;
	@FXML
	private Button btnEditar;
	
	
	
	@FXML private Button btnBuscarMatricula;
	
	@FXML
	private Button btnActualizar;
//	@FXML private Button btnEliminar;

	// Variables de la tabla
	@FXML
	private TableView<Paciente> tablaPacientes;

	@FXML
	private TableColumn matricula;
	@FXML
	private TableColumn nombre;
	@FXML
	private TableColumn apellido;
	@FXML
	private TableColumn fecha;
	

	private int posicionPersonaEnTabla;

	ObservableList<Paciente> pacientes = miConexion.getPacientes();

	@FXML
	private void eventKey(KeyEvent event) {

		Object evt = event.getSource();

		if (evt.equals(txtUser)) {

			if (event.getCharacter().equals(" ")) {
				event.consume();
			}

		} else if (evt.equals(txtPassword)) {

			if (event.getCharacter().equals(" ")) {
				event.consume();
			}
		}
	}

	@FXML
	private void eventAction(ActionEvent event) {

		Object evt = event.getSource();

		if (evt.equals(btnVolver)) {
			if (usuario.getNombre().equals("supervisor")) {
				loadStage("/view/Supervisor/FXMLViewPrincipal.fxml", event);
			} else if (usuario.getNombre().equals("nutriologo")) {
				loadStage("/view/Nutriologo/FXMLViewPrincipal.fxml", event);
			}else if (usuario.getNombre().equals("pasante")) {
				loadStage("/view/Nutriologo/FXMLViewPrincipal.fxml", event);
			}

		}
		if (evt.equals(btnVer)) {
			int matricula = Integer.parseInt(MATRICULA.get(posicionPersonaEnTabla));
			
			//System.out.println("Estudiante con matricula: "+matricula);
			miConexion.obtenerDatosPersonalesPaciente(matricula);
			miConexion.obtenerAntecedentesFamiliaresPaciente(matricula);
			miConexion.obtenerDatosAntropologicosPaciente(matricula);
			miConexion.obtenerDatosBioquimicosPaciente(matricula);
			miConexion.obtenerIndicadoresDieteticosPaciente(matricula);
			miConexion.obtenerIndicadoresClinicos(matricula);
			paciente.setMatriculaPaciente(matricula);
			
			
			loadStage("/view/Historia_Clinica/FXMLViewDatosPersonales.fxml", event);
		}

		if (evt.equals(btnEditar)) {
			
			int matricula = Integer.parseInt(MATRICULA.get(posicionPersonaEnTabla));
			
			//System.out.println("Estudiante con matricula: "+matricula);
			miConexion.obtenerDatosPersonalesPaciente(matricula);
			miConexion.obtenerAntecedentesFamiliaresPaciente(matricula);
			miConexion.obtenerDatosAntropologicosPaciente(matricula);
			miConexion.obtenerDatosBioquimicosPaciente(matricula);
			miConexion.obtenerIndicadoresDieteticosPaciente(matricula);
			miConexion.obtenerIndicadoresClinicos(matricula);
			paciente.setMatriculaPaciente(matricula);

			paciente.setMatriculaActualPaciente(matricula);
			paciente.setEditable(true);
			//controller.Historia_Clinica.FXMLControllerDatosPersonales
			
			loadStage("/view/Formulario/FXMLViewPaginacion.fxml", event);
		}
	}

	@FXML private void BuscarPacienteTabla(ActionEvent event) {
	
		pacientes.clear();
		MATRICULA.clear();
		NOMBRE.clear();
		APELLIDOS.clear();
		FECHA.clear();
		Paciente paciente = new Paciente();
		
		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://"+"localhost"+":"+"3306"+"/nutritesi","root","");
		
			// 5. CREAR OBJETO STATEMENT
			Statement miStatement = miConexion.createStatement();

			// 6.EJECUTAR LA EJECUCION SQL																			/* ID 1*/
			ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM estudiantes WHERE matricula = "+txtFieldBuscarMatricula.getText());
			
			// 7. Recorrer EL RESULTSET/*
			
			while (miResultSet.next()) {
						
				MATRICULA.add(miResultSet.getInt("matricula")+"");
				
				NOMBRE.add(miResultSet.getString("nombre"));
				
				APELLIDOS.add(miResultSet.getString("apellidos"));
				FECHA.add(miResultSet.getString("fechaRegistro"));
					
				contador++;
			
			}

			 for (int i = 0; i < MATRICULA.size(); i++) {
				 
		        	Paciente p1 = new Paciente();
		            p1.matricula.set(MATRICULA.get(i));
		            p1.nombre.set(NOMBRE.get(i));
		            p1.apellido.set(APELLIDOS.get(i));
		            p1.fecha.set(FECHA.get(i));
		            pacientes.add(p1);
		        }
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	@FXML private void ActualizarTabla (ActionEvent event) {
		
		pacientes.clear();
		MATRICULA.clear();
		NOMBRE.clear();
		APELLIDOS.clear();
		FECHA.clear();
		Paciente paciente = new Paciente();

		
		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://"+"localhost"+":"+"3306"+"/nutritesi","root","");

				
			// 5. CREAR OBJETO STATEMENT
			Statement miStatement = miConexion.createStatement();

			// 6.EJECUTAR LA EJECUCION SQL																			/* ID 1*/
			ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM estudiantes");
			
			// 7. Recorrer EL RESULTSET/*
			
			while (miResultSet.next()) {
				
				
				
				MATRICULA.add(miResultSet.getInt("matricula")+"");
				
				NOMBRE.add(miResultSet.getString("nombre"));
				
				APELLIDOS.add(miResultSet.getString("apellidos"));
				FECHA.add(miResultSet.getString("fechaRegistro"));
					
				contador++;
			
			}
			
			
			 for (int i = 0; i < MATRICULA.size(); i++) {
				 
		        	Paciente p1 = new Paciente();
		            p1.matricula.set(MATRICULA.get(i));
		            p1.nombre.set(NOMBRE.get(i));
		            p1.apellido.set(APELLIDOS.get(i));
		            p1.fecha.set(FECHA.get(i));
		            pacientes.add(p1);
		        }
			
			/*
	        for (int i = 0; i < 20; i++) {
	        	Paciente p1 = new Paciente();
	            p1.matricula.set("Nombre " + i);
	            p1.nombre.set("Apellido " + i);
	            p1.apellido.set("RAA" + i);
	            p1.fecha.set("67589458" + i);
	            pacientes.add(p1);
	        }
			*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Listener de la tabla personas
	 */
	private final ListChangeListener<Paciente> selectorTablaPersonas = new ListChangeListener<Paciente>() {
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
		 * if (persona != null) {
		 * 
		 * // Pongo los textFields con los datos correspondientes
		 * nombreTF.setText(persona.getNombre());
		 * apellidoTF.setText(persona.getApellido());
		 * edadTF.setText(persona.getEdad().toString());
		 * telefonoTF.setText(persona.getTelefono());
		 * 
		 * // Pongo los botones en su estado correspondiente
		 * modificarBT.setDisable(false); eliminarBT.setDisable(false);
		 * aniadirBT.setDisable(true);
		 * 
		 * }
		 */
	}

	/*
	 * Para modificar
	 * 
	 * @FXML private void modificar(ActionEvent event) { Paciente paciente = new
	 * Paciente(); paciente.nombre.set(nombreTF.getText());
	 * paciente.apellido.set(apellidoTF.getText());
	 * paciente.edad.set(Integer.parseInt(edadTF.getText()));
	 * paciente.telefono.set(telefonoTF.getText());
	 * paciente.set(posicionPersonaEnTabla, persona); }
	 */
	@FXML
	private void eliminar(ActionEvent event) {
		pacientes.remove(posicionPersonaEnTabla);
	}

	/**
	 * Método para inicializar la tabla
	 */
	private void inicializarTablaPacientes() {
		matricula.setCellValueFactory(new PropertyValueFactory<Paciente, String>("matricula"));
		nombre.setCellValueFactory(new PropertyValueFactory<Paciente, String>("nombre"));
		apellido.setCellValueFactory(new PropertyValueFactory<Paciente, String>("apellido"));
		fecha.setCellValueFactory(new PropertyValueFactory<Paciente, String>("fecha"));

		pacientes = FXCollections.observableArrayList();
		tablaPacientes.setItems(pacientes);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		paciente.setEditable(false);
		// Inicializamos la tabla
		this.inicializarTablaPacientes();

		// Seleccionar las tuplas de la tabla de las personas
		final ObservableList<Paciente> tablaPersonaSel = tablaPacientes.getSelectionModel().getSelectedItems();
		tablaPersonaSel.addListener(selectorTablaPersonas);

		if (usuario.getNombre().equals("supervisor") || usuario.getNombre().equals("pasante")) {
			btnEditar.setDisable(true);
		} else if (usuario.getNombre().equals("nutriologo")) {

		}

		// Inicializamos la tabla con algunos datos aleatorios

	}

	private void loadStage(String url, Event event) {

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
}
