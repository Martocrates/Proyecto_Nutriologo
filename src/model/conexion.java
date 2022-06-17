package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.ObservableList;

public class conexion {

	private String ip = "localhost";
	private String puerto = "8012";
	private String DB = "nutritesi";
	private String userDB = "root";
	private String userDBPassword = "";
	private int expediente;
	private static ObservableList<Paciente> pacientes;

	public ObservableList<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(ObservableList<Paciente> pacientes) {
		conexion.pacientes = pacientes;
	}

	Paciente paciente = new Paciente();
	Usuario usuario = new Usuario();

	public void obtenerDatosTabla() {

		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + "3306" + "/nutritesi",
					"root", "");

			// 5. CREAR OBJETO STATEMENT
			Statement miStatement = miConexion.createStatement();

			// 6.EJECUTAR LA EJECUCION SQL /* ID 1*/
			ResultSet miResultSet = miStatement
					.executeQuery("SELECT matricula,nombre,apellidos,fechaRegistro FROM estudiantes");

			// 7. Recorrer EL RESULTSET
			while (miResultSet.next()) {

				paciente.matricula.set(miResultSet.getInt("matricula") + "");
				System.out.println(miResultSet.getInt("matricula") + "");
				paciente.nombre.set(miResultSet.getString("nombre"));
				paciente.apellido.set(miResultSet.getString("apellidos"));
				paciente.fecha.set(miResultSet.getString("fechaRegistro"));

				pacientes.add(paciente);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void obtenerDatosPersonalesPaciente(int matriculaEstudiante) {

		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + "3306" + "/nutritesi",
					"root", "");

			// 5. CREAR OBJETO STATEMENT
			Statement miStatement = miConexion.createStatement();

			// 6.EJECUTAR LA EJECUCION SQL /* ID 1*/
			ResultSet miResultSet = miStatement.executeQuery(
					"SELECT matricula,nombre,apellidos,edad,sexo,carrera,semestre,turno,fechaNaci,ocupacion,telefono,email,fechaRegistro,idUsuario FROM estudiantes WHERE matricula = "
							+ matriculaEstudiante + "");

			// 7. Recorrer EL RESULTSET
			while (miResultSet.next()) {
				//paciente.setMatriculaPaciente(miResultSet.getInt("matricula"));
				paciente.setNombrePaciente(miResultSet.getString("nombre"));
				paciente.setApellidoPaciente(miResultSet.getString("apellidos"));
				paciente.setEdad(miResultSet.getInt("edad"));
				paciente.setSexo(miResultSet.getString("sexo"));
				paciente.setCarrera(miResultSet.getString("carrera"));
				paciente.setSemestre(miResultSet.getInt("semestre"));
				paciente.setTurno(miResultSet.getString("turno"));
				paciente.setFechaNacimiento(miResultSet.getString("fechaNaci"));
				paciente.setOcupacion(miResultSet.getString("ocupacion"));
				paciente.setTelefono(miResultSet.getString("telefono"));
				paciente.setEmail(miResultSet.getString("email"));
				paciente.setFechaPaciente(miResultSet.getString("fechaRegistro"));
				paciente.setExpediente(miResultSet.getInt("idUsuario"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void obtenerAntecedentesFamiliaresPaciente(int matriculaEstudiante) {

		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + "3306" + "/nutritesi",
					"root", "");

			// 5. CREAR OBJETO STATEMENT
			Statement miStatement = miConexion.createStatement();

			// 6.EJECUTAR LA EJECUCION SQL /* ID 1*/
			ResultSet miResultSet = miStatement.executeQuery(
					"SELECT obesidad,diabetes,hta,cancer,hipercolesterolemia,hipertrigliceridemia FROM antecedentesfam WHERE matricula = "
							+ matriculaEstudiante + "");

			// 7. Recorrer EL RESULTSET
			while (miResultSet.next()) {
				paciente.setObesidad(miResultSet.getString("obesidad"));
				paciente.setDiabetes(miResultSet.getString("diabetes"));
				paciente.setHta(miResultSet.getString("hta"));
				paciente.setCancer(miResultSet.getString("cancer"));
				paciente.setHipercolesterolemia(miResultSet.getString("hipercolesterolemia"));
				paciente.setHipertrigliceridemia(miResultSet.getString("hipertrigliceridemia"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void obtenerDatosAntropologicosPaciente(int matriculaEstudiante) {

		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + "3306" + "/nutritesi",
					"root", "");

			// 5. CREAR OBJETO STATEMENT
			Statement miStatement = miConexion.createStatement();

			// 6.EJECUTAR LA EJECUCION SQL /* ID 1*/
			ResultSet miResultSet = miStatement.executeQuery(
					"SELECT peso,talla,imc,perimetroCintura,perimetroCadera,icc FROM datosantropo WHERE matricula = "
							+ matriculaEstudiante + "");

			// 7. Recorrer EL RESULTSET
			while (miResultSet.next()) {
				paciente.setPeso(miResultSet.getFloat("peso"));
				paciente.setTalla(miResultSet.getFloat("talla"));
				paciente.setImc(miResultSet.getFloat("imc"));
				paciente.setPerimetroCintura(miResultSet.getFloat("perimetroCintura"));
				paciente.setPerimetroCadera(miResultSet.getFloat("perimetroCadera"));
				paciente.setIcc(miResultSet.getFloat("icc"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void obtenerDatosBioquimicosPaciente(int matriculaEstudiante) {

		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + "3306" + "/nutritesi",
					"root", "");

			// 5. CREAR OBJETO STATEMENT
			Statement miStatement = miConexion.createStatement();

			// 6.EJECUTAR LA EJECUCION SQL /* ID 1*/
			ResultSet miResultSet = miStatement.executeQuery(
					"SELECT consuTabaco,frecuenciaTabaco,bebiAlcohol,frecuenciaAlcohol,actividadFisica,frecuenciaFisica,"
							+ "duracionFisica,glucosa,colesterol,trigliceridos,albumia,otros FROM datosbioqui WHERE matricula = "
							+ matriculaEstudiante + "");

			// 7. Recorrer EL RESULTSET
			while (miResultSet.next()) {
				paciente.setConsumoTabaco(miResultSet.getString("consuTabaco"));
				paciente.setFrecuenciaTabaco(miResultSet.getString("frecuenciaTabaco"));

				paciente.setConsumoAlcohol(miResultSet.getString("bebiAlcohol"));
				paciente.setFrecuenciaAlcohol(miResultSet.getString("frecuenciaAlcohol"));

				paciente.setActividadFisica(miResultSet.getString("actividadFisica"));
				paciente.setFrecuenciaActividad(miResultSet.getString("frecuenciaFisica"));
				//
				paciente.setDuracionActividad(miResultSet.getString("duracionFisica"));
				paciente.setGlucosa(miResultSet.getString("glucosa"));
				paciente.setColesterol(miResultSet.getString("colesterol"));
				paciente.setTrigliceridos(miResultSet.getString("trigliceridos"));
				paciente.setAlbumia(miResultSet.getString("albumia"));
				paciente.setOtrosDatosBioquimicos(miResultSet.getString("otros"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void obtenerIndicadoresDieteticosPaciente(int matriculaEstudiante) {

		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + "3306" + "/nutritesi",
					"root", "");

			// 5. CREAR OBJETO STATEMENT
			Statement miStatement = miConexion.createStatement();

			// 6.EJECUTAR LA EJECUCION SQL /* ID 1*/
			ResultSet miResultSet = miStatement
					.executeQuery("SELECT * FROM form7 WHERE matricula = " + matriculaEstudiante + "");

			// 7. Recorrer EL RESULTSET
			while (miResultSet.next()) {
				paciente.setAlimentosPreferidos(miResultSet.getString("alimentosPrefe"));
				System.out.println(miResultSet.getString("alimentosPrefe") + matriculaEstudiante);
				paciente.setAlimentosNoAgradables(miResultSet.getString("alimentosNo"));
				paciente.setAlimentosMalestar(miResultSet.getString("alimentosMalestar"));
				paciente.setSuplementos(miResultSet.getString("suplementos"));
				paciente.setRecordatorio(miResultSet.getString("recordatorio"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		obtenerIndicadoresDieteticosPaciente2(matriculaEstudiante);
	}
	
	public void obtenerIndicadoresDieteticosPaciente2(int matriculaEstudiante) {

		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + "3306" + "/nutritesi",
					"root", "");

			// 5. CREAR OBJETO STATEMENT
			Statement miStatement = miConexion.createStatement();

			// 6.EJECUTAR LA EJECUCION SQL /* ID 1*/
			ResultSet miResultSet = miStatement
					.executeQuery("SELECT * FROM indidieteti WHERE matricula = " + matriculaEstudiante + "");

			// 7. Recorrer EL RESULTSET
			while (miResultSet.next()) {
				
				paciente.setComidasAlDia(miResultSet.getString("comidas"));
				paciente.setDondeCome(miResultSet.getString("dondeCome"));
				paciente.setQuienPreparaAlimentos(miResultSet.getString("quienAli"));
				paciente.setCambiosEnHambre(miResultSet.getString("cambios"));
				paciente.setModificacionAlimentacion(miResultSet.getString("modificacion"));
				paciente.setRazonDeModificacionAlimentacion(miResultSet.getString("causas"));
				
				
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void obtenerIndicadoresClinicos(int matriculaEstudiante) {

		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + "3306" + "/nutritesi",
					"root", "");

			// 5. CREAR OBJETO STATEMENT
			Statement miStatement = miConexion.createStatement();

			// 6.EJECUTAR LA EJECUCION SQL /* ID 1*/
			ResultSet miResultSet = miStatement
					.executeQuery("SELECT * FROM indiclini WHERE matricula = " + matriculaEstudiante + "");

			// 7. Recorrer EL RESULTSET
			while (miResultSet.next()) {
				
				
				paciente.setPelo(miResultSet.getString("pelo"));
				paciente.setUnias(miResultSet.getString("uñas"));
				paciente.setPiel(miResultSet.getString("piel"));
				paciente.setOjos(miResultSet.getString("ojos"));
				paciente.setDentadura(miResultSet.getString("dentadura"));
				paciente.setDiarrea(miResultSet.getString("diarrea"));
				paciente.setEstrenimiento(miResultSet.getString("estrenimiento"));
				paciente.setVomito(miResultSet.getString("vomito"));
				paciente.setColitis(miResultSet.getString("colitis"));
				paciente.setPirosis(miResultSet.getString("pirosis"));
				paciente.setGastritis(miResultSet.getString("gastritis"));
				paciente.setUlcera(miResultSet.getString("ulcera"));
				paciente.setHidratacion(miResultSet.getString("hidratacion"));
				paciente.setNauseas(miResultSet.getString("nauseas"));
				
				paciente.setOtrosDatosClinicos(miResultSet.getString("otros"));
				paciente.setEnfermedadDiagnosticada(miResultSet.getString("enfermedadDiag"));
				paciente.setTomaAlgunMedicamento(miResultSet.getString("medicamento"));
				paciente.setCualMedicamentoToma(miResultSet.getString("cual"));
				paciente.setDosisMedicamento(miResultSet.getString("dosis"));
				paciente.setDesdeCuandoMedicamento(miResultSet.getString("desdeCuando"));
				paciente.setCirugiasPracticadas(miResultSet.getString("cirugia"));
				paciente.setEspecificarCirugias(miResultSet.getString("especificar"));
				
				
				/*
				paciente.setAlimentosPreferidos(miResultSet.getString("alimentosPrefe"));
				System.out.println(miResultSet.getString("alimentosPrefe") + matriculaEstudiante);
				paciente.setAlimentosNoAgradables(miResultSet.getString("alimentosNo"));
				paciente.setAlimentosMalestar(miResultSet.getString("alimentosMalestar"));
				paciente.setSuplementos(miResultSet.getString("suplementos"));
				paciente.setRecordatorio(miResultSet.getString("recordatorio"));
				 */
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void actualizarPaciente() {
		try {

			// 1. CREAR CONEXION
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + "3306" + "/nutritesi",
					"root", "");

			// 2. CREAR CONSULTA PREPARADA
			PreparedStatement pacienteDatosPersonales = miConexion.prepareStatement(
					"UPDATE estudiantes SET matricula = ?,nombre = ?,apellidos = ?,edad = ?,sexo = ?,carrera = ?,"
					+ "semestre = ?,turno = ?,fechaNaci = ?,ocupacion = ?,telefono = ?,email = ?,fechaRegistro = ?"
					+ ",idUsuario = ? WHERE matricula = ?"); //15

			// 3.Establecer parametros de consulta
			pacienteDatosPersonales.setInt(1, paciente.getMatriculaPaciente());
		
			pacienteDatosPersonales.setString(2, paciente.getNombrePaciente());

			pacienteDatosPersonales.setString(3, paciente.getApellidoPaciente());
		
			pacienteDatosPersonales.setInt(4, paciente.getEdad());

			pacienteDatosPersonales.setString(5, paciente.getSexo());

			pacienteDatosPersonales.setString(6, paciente.getCarrera());
			
			pacienteDatosPersonales.setInt(7, paciente.getSemestre());
			
			pacienteDatosPersonales.setString(8, paciente.getTurno());
			
			pacienteDatosPersonales.setString(9, paciente.getFechaNacimiento());
		
			pacienteDatosPersonales.setString(10, paciente.getOcupacion());
			
			pacienteDatosPersonales.setString(11, paciente.getTelefono());
			
			pacienteDatosPersonales.setString(12, paciente.getEmail());
			
			pacienteDatosPersonales.setString(13, paciente.getFechaPaciente());
			
			pacienteDatosPersonales.setInt(14, usuario.getIdUsuario());
			
			pacienteDatosPersonales.setInt(15, paciente.getMatriculaActualPaciente());
			
			// 4. Ejecutar
			pacienteDatosPersonales.executeUpdate();

			pacienteDatosPersonales.close();

			
			PreparedStatement pacienteAntecedentesFam = miConexion.prepareStatement(
					"UPDATE antecedentesfam SET obesidad = ?, diabetes = ?, hta = ?, cancer = ?, hipercolesterolemia = ?,"
					+ " hipertrigliceridemia = ?, matricula = ? WHERE matricula = ?");

			pacienteAntecedentesFam.setString(1, paciente.getObesidad());
			pacienteAntecedentesFam.setString(2, paciente.getDiabetes());
			pacienteAntecedentesFam.setString(3, paciente.getHta());
			pacienteAntecedentesFam.setString(4, paciente.getCancer());
			pacienteAntecedentesFam.setString(5, paciente.getHipercolesterolemia());
			pacienteAntecedentesFam.setString(6, paciente.getHipertrigliceridemia());
			pacienteAntecedentesFam.setInt(7, paciente.getMatriculaPaciente());
			pacienteAntecedentesFam.setInt(8, paciente.getMatriculaActualPaciente());

			pacienteAntecedentesFam.executeUpdate();
			pacienteAntecedentesFam.close();

			PreparedStatement pacienteDatosAntropologicos = miConexion.prepareStatement(
					"UPDATE datosantropo SET peso = ?, talla = ?, imc = ?, perimetroCintura = ?, perimetroCadera = ?,"
					+ " icc = ?, matricula = ? WHERE matricula = ?");

			pacienteDatosAntropologicos.setFloat(1, paciente.getPeso());
			pacienteDatosAntropologicos.setFloat(2, paciente.getTalla());
			pacienteDatosAntropologicos.setFloat(3, paciente.getImc());
			pacienteDatosAntropologicos.setFloat(4, paciente.getPerimetroCintura());
			pacienteDatosAntropologicos.setFloat(5, paciente.getPerimetroCadera());
			pacienteDatosAntropologicos.setFloat(6, paciente.getIcc());
			pacienteDatosAntropologicos.setInt(7, paciente.getMatriculaPaciente());
			pacienteDatosAntropologicos.setInt(8, paciente.getMatriculaActualPaciente());

			pacienteDatosAntropologicos.executeUpdate();
			pacienteDatosAntropologicos.close();

			PreparedStatement pacienteDatosBioquimicos = miConexion.prepareStatement(
					"UPDATE datosbioqui SET consuTabaco = ?,frecuenciaTabaco = ?,bebiAlcohol = ?,frecuenciaAlcohol = ?,actividadFisica = ?"
					+ ",frecuenciaFisica = ?,duracionFisica = ?,glucosa = ?,colesterol = ?,trigliceridos = ?,"
					+ "albumia = ?,otros = ?, matricula = ?"
					+ " WHERE matricula = ?");

			pacienteDatosBioquimicos.setString(1, paciente.getConsumoTabaco());
			pacienteDatosBioquimicos.setString(2, paciente.getFrecuenciaTabaco());
			pacienteDatosBioquimicos.setString(3, paciente.getConsumoAlcohol());
			pacienteDatosBioquimicos.setString(4, paciente.getFrecuenciaAlcohol());
			pacienteDatosBioquimicos.setString(5, paciente.getActividadFisica());
			
			pacienteDatosBioquimicos.setString(6, paciente.getFrecuenciaActividad());
			pacienteDatosBioquimicos.setString(7, paciente.getDuracionActividad());
			pacienteDatosBioquimicos.setString(8, paciente.getGlucosa());
			pacienteDatosBioquimicos.setString(9, paciente.getColesterol());
			pacienteDatosBioquimicos.setString(10, paciente.getTrigliceridos());
			pacienteDatosBioquimicos.setString(11, paciente.getAlbumia());
			pacienteDatosBioquimicos.setString(12, paciente.getOtrosDatosBioquimicos());
			pacienteDatosBioquimicos.setInt(13, paciente.getMatriculaPaciente());
			pacienteDatosBioquimicos.setInt(14, paciente.getMatriculaActualPaciente());

			pacienteDatosBioquimicos.executeUpdate();
			pacienteDatosBioquimicos.close();

			PreparedStatement pacienteIndicadoresClinicos = miConexion.prepareStatement(
					"UPDATE indiclini SET pelo = ?,uñas = ?,piel = ?,ojos = ?,dentadura = ?,"
					+ "diarrea = ?,estrenimiento = ?,vomito = ?,colitis = ?,pirosis = ?,"
					+ "gastritis = ?,ulcera = ?,hidratacion = ?,nauseas = ?,otros = ?,"
					+ "enfermedadDiag = ?,medicamento = ?,cual = ?,dosis = ?,desdeCuando = ?,"
					+ "cirugia = ?,especificar = ?,matricula = ? WHERE matricula = ?");

			pacienteIndicadoresClinicos.setNString(1, paciente.getPelo());
			pacienteIndicadoresClinicos.setNString(2, paciente.getUnias());
			pacienteIndicadoresClinicos.setNString(3, paciente.getPiel());
			pacienteIndicadoresClinicos.setNString(4, paciente.getOjos());
			pacienteIndicadoresClinicos.setNString(5, paciente.getDentadura());
			pacienteIndicadoresClinicos.setNString(6, paciente.getDiarrea());
			pacienteIndicadoresClinicos.setNString(7, paciente.getEstrenimiento());
			pacienteIndicadoresClinicos.setNString(8, paciente.getVomito());
			pacienteIndicadoresClinicos.setNString(9, paciente.getColitis());
			pacienteIndicadoresClinicos.setNString(10, paciente.getPirosis());
			pacienteIndicadoresClinicos.setNString(11, paciente.getGastritis());
			pacienteIndicadoresClinicos.setNString(12, paciente.getUlcera());
			pacienteIndicadoresClinicos.setNString(13, paciente.getHidratacion());
			pacienteIndicadoresClinicos.setNString(14, paciente.getNauseas());
			pacienteIndicadoresClinicos.setNString(15, paciente.getOtrosDatosClinicos());
			pacienteIndicadoresClinicos.setNString(16, paciente.getEnfermedadDiagnosticada());
			pacienteIndicadoresClinicos.setNString(17, paciente.getTomaAlgunMedicamento());
			pacienteIndicadoresClinicos.setNString(18, paciente.getCualMedicamentoToma());
			pacienteIndicadoresClinicos.setNString(19, paciente.getDosisMedicamento());
			pacienteIndicadoresClinicos.setNString(20, paciente.getDesdeCuandoMedicamento());
			pacienteIndicadoresClinicos.setNString(21, paciente.getCirugiasPracticadas());
			pacienteIndicadoresClinicos.setNString(22, paciente.getEspecificarCirugias());
			pacienteIndicadoresClinicos.setInt(23, paciente.getMatriculaPaciente());
			pacienteIndicadoresClinicos.setInt(24, paciente.getMatriculaActualPaciente());
			
			pacienteIndicadoresClinicos.executeUpdate();
			pacienteIndicadoresClinicos.close();

			PreparedStatement pacienteIndicadoresDieteticos = miConexion.prepareStatement(
					"UPDATE indidieteti SET comidas = ?,dondeCome = ?,quienAli = ?,cambios = ?,modificacion = ?,"
					+ "causas = ?,matricula = ?  WHERE matricula = ?");

			pacienteIndicadoresDieteticos.setString(1, paciente.getComidasAlDia());
			pacienteIndicadoresDieteticos.setString(2, paciente.getDondeCome());
			pacienteIndicadoresDieteticos.setString(3, paciente.getQuienPreparaAlimentos());
			pacienteIndicadoresDieteticos.setString(4, paciente.getCambiosEnHambre());
			pacienteIndicadoresDieteticos.setString(5, paciente.getModificacionAlimentacion());
			pacienteIndicadoresDieteticos.setString(6, paciente.getRazonDeModificacionAlimentacion());
			pacienteIndicadoresDieteticos.setInt(7, paciente.getMatriculaPaciente());
			pacienteIndicadoresDieteticos.setInt(8, paciente.getMatriculaActualPaciente());

			pacienteIndicadoresDieteticos.executeUpdate();
			pacienteIndicadoresDieteticos.close();

			PreparedStatement pacienteIndicadoresDieteticosDos = miConexion.prepareStatement(
					"UPDATE form7 SET alimentosPrefe = ?,alimentosNo = ?,alimentosMalestar = ?,suplementos = ?,recordatorio = ?,"
					+ "matricula = ? WHERE matricula = ?");

			pacienteIndicadoresDieteticosDos.setString(1, paciente.getAlimentosPreferidos());
			pacienteIndicadoresDieteticosDos.setString(2, paciente.getAlimentosNoAgradables());
			pacienteIndicadoresDieteticosDos.setString(3, paciente.getAlimentosMalestar());
			pacienteIndicadoresDieteticosDos.setString(4, paciente.getSuplementos());
			pacienteIndicadoresDieteticosDos.setString(5, paciente.getRecordatorio());
			pacienteIndicadoresDieteticosDos.setInt(6, paciente.getMatriculaPaciente());
			pacienteIndicadoresDieteticosDos.setInt(7, paciente.getMatriculaActualPaciente());

			pacienteIndicadoresDieteticosDos.executeUpdate();
			pacienteIndicadoresDieteticosDos.close();

		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	
	public void ingresaPaciente() {

		try {

			// 1. CREAR CONEXION
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + "3306" + "/nutritesi",
					"root", "");

			// 2. CREAR CONSULTA PREPARADA
			PreparedStatement pacienteDatosPersonales = miConexion.prepareStatement(
					"INSERT INTO estudiantes(matricula,nombre,apellidos,edad,sexo,carrera,semestre,turno,fechaNaci,ocupacion,telefono,email,fechaRegistro,idUsuario) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			// 3.Establecer parametros de consulta
			pacienteDatosPersonales.setInt(1, paciente.getMatriculaPaciente());
			System.out.println(paciente.getMatriculaPaciente());
			pacienteDatosPersonales.setString(2, paciente.getNombrePaciente());
			System.out.println(paciente.getNombrePaciente());
			pacienteDatosPersonales.setString(3, paciente.getApellidoPaciente());
			System.out.println(paciente.getApellidoPaciente());
			pacienteDatosPersonales.setInt(4, paciente.getEdad());
			System.out.println(paciente.getEdad());

			pacienteDatosPersonales.setString(5, paciente.getSexo());
			System.out.println(paciente.getSexo());
			pacienteDatosPersonales.setString(6, paciente.getCarrera());
			System.out.println(paciente.getCarrera());
			pacienteDatosPersonales.setInt(7, paciente.getSemestre());
			System.out.println(paciente.getSemestre());
			pacienteDatosPersonales.setString(8, paciente.getTurno());
			System.out.println(paciente.getTurno());
			pacienteDatosPersonales.setString(9, paciente.getFechaNacimiento());
			System.out.println(paciente.getFechaNacimiento());
			pacienteDatosPersonales.setString(10, paciente.getOcupacion());
			System.out.println(paciente.getOcupacion());
			pacienteDatosPersonales.setString(11, paciente.getTelefono());
			System.out.println(paciente.getTelefono());
			pacienteDatosPersonales.setString(12, paciente.getEmail());
			System.out.println(paciente.getEmail());
			pacienteDatosPersonales.setString(13, paciente.getFechaPaciente());
			System.out.println(paciente.getFechaPaciente());
			pacienteDatosPersonales.setInt(14, usuario.getIdUsuario());
			System.out.println(usuario.getIdUsuario());
			// 4. Ejecutar
			pacienteDatosPersonales.executeUpdate();

			pacienteDatosPersonales.close();

			PreparedStatement pacienteAntecedentesFam = miConexion.prepareStatement(
					"INSERT INTO antecedentesfam(obesidad, diabetes, hta, cancer, hipercolesterolemia, hipertrigliceridemia, matricula) VALUES (?,?,?,?,?,?,?)");

			pacienteAntecedentesFam.setString(1, paciente.getObesidad());
			pacienteAntecedentesFam.setString(2, paciente.getDiabetes());
			pacienteAntecedentesFam.setString(3, paciente.getHta());
			pacienteAntecedentesFam.setString(4, paciente.getCancer());
			pacienteAntecedentesFam.setString(5, paciente.getHipercolesterolemia());
			pacienteAntecedentesFam.setString(6, paciente.getHipertrigliceridemia());
			pacienteAntecedentesFam.setInt(7, paciente.getMatriculaPaciente());

			pacienteAntecedentesFam.executeUpdate();
			pacienteAntecedentesFam.close();

			PreparedStatement pacienteDatosAntropologicos = miConexion.prepareStatement(
					"INSERT INTO datosantropo(peso, talla, imc, perimetroCintura, perimetroCadera, icc, matricula) VALUES (?,?,?,?,?,?,?)");

			pacienteDatosAntropologicos.setFloat(1, paciente.getPeso());
			pacienteDatosAntropologicos.setFloat(2, paciente.getTalla());
			pacienteDatosAntropologicos.setFloat(3, paciente.getImc());
			pacienteDatosAntropologicos.setFloat(4, paciente.getPerimetroCintura());
			pacienteDatosAntropologicos.setFloat(5, paciente.getPerimetroCadera());
			pacienteDatosAntropologicos.setFloat(6, paciente.getIcc());
			pacienteDatosAntropologicos.setInt(7, paciente.getMatriculaPaciente());

			pacienteDatosAntropologicos.executeUpdate();
			pacienteDatosAntropologicos.close();

			PreparedStatement pacienteDatosBioquimicos = miConexion.prepareStatement(
					"INSERT INTO datosbioqui(consuTabaco,frecuenciaTabaco,bebiAlcohol,frecuenciaAlcohol,actividadFisica,frecuenciaFisica,duracionFisica,glucosa,colesterol,trigliceridos,albumia,otros,matricula ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");

			pacienteDatosBioquimicos.setString(1, paciente.getConsumoTabaco());
			pacienteDatosBioquimicos.setString(2, paciente.getFrecuenciaTabaco());
			pacienteDatosBioquimicos.setString(3, paciente.getConsumoAlcohol());
			pacienteDatosBioquimicos.setString(4, paciente.getFrecuenciaAlcohol());
			pacienteDatosBioquimicos.setString(5, paciente.getActividadFisica());
			pacienteDatosBioquimicos.setString(6, paciente.getFrecuenciaActividad());
			pacienteDatosBioquimicos.setString(7, paciente.getDuracionActividad());
			pacienteDatosBioquimicos.setString(8, paciente.getGlucosa());
			pacienteDatosBioquimicos.setString(9, paciente.getColesterol());
			pacienteDatosBioquimicos.setString(10, paciente.getTrigliceridos());
			pacienteDatosBioquimicos.setString(11, paciente.getAlbumia());
			pacienteDatosBioquimicos.setString(12, paciente.getOtrosDatosBioquimicos());
			pacienteDatosBioquimicos.setInt(13, paciente.getMatriculaPaciente());

			pacienteDatosBioquimicos.executeUpdate();
			pacienteDatosBioquimicos.close();

			PreparedStatement pacienteIndicadoresClinicos = miConexion.prepareStatement(
					"INSERT INTO indiclini(pelo,uñas,piel,ojos,dentadura,diarrea,estrenimiento,vomito,colitis,pirosis,gastritis,ulcera,hidratacion,nauseas,otros,enfermedadDiag,medicamento,cual,dosis,desdeCuando,cirugia,especificar,matricula) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			pacienteIndicadoresClinicos.setNString(1, paciente.getPelo());
			pacienteIndicadoresClinicos.setNString(2, paciente.getUnias());
			pacienteIndicadoresClinicos.setNString(3, paciente.getPiel());
			pacienteIndicadoresClinicos.setNString(4, paciente.getOjos());
			pacienteIndicadoresClinicos.setNString(5, paciente.getDentadura());
			pacienteIndicadoresClinicos.setNString(6, paciente.getDiarrea());
			pacienteIndicadoresClinicos.setNString(7, paciente.getEstrenimiento());
			pacienteIndicadoresClinicos.setNString(8, paciente.getVomito());
			pacienteIndicadoresClinicos.setNString(9, paciente.getColitis());
			pacienteIndicadoresClinicos.setNString(10, paciente.getPirosis());
			pacienteIndicadoresClinicos.setNString(11, paciente.getGastritis());
			pacienteIndicadoresClinicos.setNString(12, paciente.getUlcera());
			pacienteIndicadoresClinicos.setNString(13, paciente.getHidratacion());
			pacienteIndicadoresClinicos.setNString(14, paciente.getNauseas());
			pacienteIndicadoresClinicos.setNString(15, paciente.getOtrosDatosClinicos());
			pacienteIndicadoresClinicos.setNString(16, paciente.getEnfermedadDiagnosticada());
			pacienteIndicadoresClinicos.setNString(17, paciente.getTomaAlgunMedicamento());
			pacienteIndicadoresClinicos.setNString(18, paciente.getCualMedicamentoToma());
			pacienteIndicadoresClinicos.setNString(19, paciente.getDosisMedicamento());
			pacienteIndicadoresClinicos.setNString(20, paciente.getDesdeCuandoMedicamento());
			pacienteIndicadoresClinicos.setNString(21, paciente.getCirugiasPracticadas());
			pacienteIndicadoresClinicos.setNString(22, paciente.getEspecificarCirugias());
			pacienteIndicadoresClinicos.setInt(23, paciente.getMatriculaPaciente());

			pacienteIndicadoresClinicos.executeUpdate();
			pacienteIndicadoresClinicos.close();

			PreparedStatement pacienteIndicadoresDieteticos = miConexion.prepareStatement(
					"INSERT INTO indidieteti(comidas,dondeCome,quienAli,cambios,modificacion,causas,matricula ) VALUES (?,?,?,?,?,?,?)");

			pacienteIndicadoresDieteticos.setString(1, paciente.getComidasAlDia());
			pacienteIndicadoresDieteticos.setString(2, paciente.getDondeCome());
			pacienteIndicadoresDieteticos.setString(3, paciente.getQuienPreparaAlimentos());
			pacienteIndicadoresDieteticos.setString(4, paciente.getCambiosEnHambre());
			pacienteIndicadoresDieteticos.setString(5, paciente.getModificacionAlimentacion());
			pacienteIndicadoresDieteticos.setString(6, paciente.getRazonDeModificacionAlimentacion());
			pacienteIndicadoresDieteticos.setInt(7, paciente.getMatriculaPaciente());

			pacienteIndicadoresDieteticos.executeUpdate();
			pacienteIndicadoresDieteticos.close();

			PreparedStatement pacienteIndicadoresDieteticosDos = miConexion.prepareStatement(
					"INSERT INTO form7(alimentosPrefe,alimentosNo,alimentosMalestar,suplementos,recordatorio,matricula) VALUES (?,?,?,?,?,?)");

			pacienteIndicadoresDieteticosDos.setString(1, paciente.getAlimentosPreferidos());
			pacienteIndicadoresDieteticosDos.setString(2, paciente.getAlimentosNoAgradables());
			pacienteIndicadoresDieteticosDos.setString(3, paciente.getAlimentosMalestar());
			pacienteIndicadoresDieteticosDos.setString(4, paciente.getSuplementos());
			pacienteIndicadoresDieteticosDos.setString(5, paciente.getRecordatorio());
			pacienteIndicadoresDieteticosDos.setInt(6, paciente.getMatriculaPaciente());

			pacienteIndicadoresDieteticosDos.executeUpdate();
			pacienteIndicadoresDieteticosDos.close();

		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

}
