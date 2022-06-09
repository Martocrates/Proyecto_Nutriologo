package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;







public class conexion {
	
	private String ip = "localhost";
	private String puerto = "8012";
	private String DB = "nutritesi";
	private String userDB = "root";
	private String userDBPassword = "";
	
Paciente paciente = new Paciente();	
Usuario usuario = new Usuario();
	public void ingresaPaciente() {
		
		
		
		try {
			
			
			//1. CREAR CONEXION
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://"+ip+":"+"3306"+"/nutritesi","root","");

			
			//2. CREAR CONSULTA PREPARADA
 			PreparedStatement pacienteDatosPersonales = miConexion.prepareStatement("INSERT INTO estudiantes(matricula,nombre,apellidos,edad,sexo,carrera,semestre,turno,fechaNaci,ocupacion,telefono,email,fechaRegistro,idUsuario) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			//3.Establecer parametros de consulta
			pacienteDatosPersonales.setInt(1,paciente.getMatriculaPaciente());
			System.out.println(paciente.getMatriculaPaciente());
			pacienteDatosPersonales.setString(2, paciente.getNombrePaciente());
			System.out.println(paciente.getNombrePaciente());
			pacienteDatosPersonales.setString(3, paciente.getApellidoPaciente());
			System.out.println(paciente.getApellidoPaciente());
			pacienteDatosPersonales.setInt(4,paciente.getEdad());
			System.out.println(paciente.getEdad());

			pacienteDatosPersonales.setString(5, paciente.getSexo());
			System.out.println(paciente.getSexo());
			pacienteDatosPersonales.setString(6, paciente.getCarrera());
			System.out.println(paciente.getCarrera());
			pacienteDatosPersonales.setInt(7,paciente.getSemestre());
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
			//4. Ejecutar
			pacienteDatosPersonales.executeUpdate();	
			
			pacienteDatosPersonales.close();
			
			
 			PreparedStatement pacienteAntecedentesFam = miConexion.prepareStatement("INSERT INTO antecedentesfam(obesidad, diabetes, hta, cancer, hipercolesterolemia, hipertrigliceridemia, matricula) VALUES (?,?,?,?,?,?,?)");

			
 			
 			pacienteAntecedentesFam.setString(1, paciente.getObesidad());
 			pacienteAntecedentesFam.setString(2, paciente.getDiabetes());
 			pacienteAntecedentesFam.setString(3, paciente.getHta());
 			pacienteAntecedentesFam.setString(4, paciente.getCancer());
 			pacienteAntecedentesFam.setString(5, paciente.getHipercolesterolemia());
 			pacienteAntecedentesFam.setString(6, paciente.getHipertrigliceridemia());
 			pacienteAntecedentesFam.setInt(7, paciente.getMatriculaPaciente());
 			
 			pacienteAntecedentesFam.executeUpdate();
 			pacienteAntecedentesFam.close();
			
 			PreparedStatement pacienteDatosAntropologicos = miConexion.prepareStatement("INSERT INTO datosantropo(peso, talla, imc, perimetroCintura, perimetroCadera, icc, matricula) VALUES (?,?,?,?,?,?,?)");
 			
 			pacienteDatosAntropologicos.setFloat(1,paciente.getPeso());
 			pacienteDatosAntropologicos.setFloat(2,paciente.getTalla());
 			pacienteDatosAntropologicos.setFloat(3,paciente.getImc());
 			pacienteDatosAntropologicos.setFloat(4,paciente.getPerimetroCintura());
 			pacienteDatosAntropologicos.setFloat(5,paciente.getPerimetroCadera());
 			pacienteDatosAntropologicos.setFloat(6,paciente.getIcc());
 			pacienteDatosAntropologicos.setInt(7,paciente.getMatriculaPaciente());
 			
 			
 			pacienteDatosAntropologicos.executeUpdate();
 			pacienteDatosAntropologicos.close();
			
 			
 			PreparedStatement pacienteDatosBioquimicos = miConexion.prepareStatement("INSERT INTO datosbioqui(consuTabaco,frecuenciaTabaco,bebiAlcohol,frecuenciaAlcohol,actividadFisica,frecuenciaFisica,duracionFisica,glucosa,colesterol,trigliceridos,albumia,otros,matricula ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");

 			pacienteDatosBioquimicos.setString(1,paciente.getConsumoTabaco());
 			pacienteDatosBioquimicos.setString(2,paciente.getFrecuenciaTabaco());
 			pacienteDatosBioquimicos.setString(3,paciente.getConsumoAlcohol());
 			pacienteDatosBioquimicos.setString(4,paciente.getFrecuenciaAlcohol());
 			pacienteDatosBioquimicos.setString(5,paciente.getActividadFisica());
 			pacienteDatosBioquimicos.setString(6,paciente.getFrecuenciaActividad());
 			pacienteDatosBioquimicos.setString(7,paciente.getDuracionActividad());
 			pacienteDatosBioquimicos.setString(8,paciente.getGlucosa());
 			pacienteDatosBioquimicos.setString(9,paciente.getColesterol());
 			pacienteDatosBioquimicos.setString(10,paciente.getTrigliceridos());
 			pacienteDatosBioquimicos.setString(11,paciente.getAlbumia());
 			pacienteDatosBioquimicos.setString(12,paciente.getOtrosDatosBioquimicos());
 			pacienteDatosBioquimicos.setInt(13,paciente.getMatriculaPaciente());
 			
 			
 			pacienteDatosBioquimicos.executeUpdate();
 			pacienteDatosBioquimicos.close();
 			
 			
 			PreparedStatement pacienteIndicadoresClinicos = miConexion.prepareStatement("INSERT INTO indiclini(pelo,uñas,piel,ojos,dentadura,diarrea,estrenimiento,vomito,colitis,pirosis,gastritis,ulcera,hidratacion,nauseas,otros,enfermedadDiag,medicamento,cual,dosis,desdeCuando,cirugia,especificar,matricula) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

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
 			
 			
 			PreparedStatement pacienteIndicadoresDieteticos = miConexion.prepareStatement("INSERT INTO indidieteti(comidas,dondeCome,quienAli,cambios,modificacion,causas,matricula ) VALUES (?,?,?,?,?,?,?)");
 			
 			pacienteIndicadoresDieteticos.setString(1,paciente.getComidasAlDia());
 			pacienteIndicadoresDieteticos.setString(2,paciente.getDondeCome());
 			pacienteIndicadoresDieteticos.setString(3,paciente.getQuienPreparaAlimentos());
 			pacienteIndicadoresDieteticos.setString(4,paciente.getCambiosEnHambre());
 			pacienteIndicadoresDieteticos.setString(5,paciente.getModificacionAlimentacion());
 			pacienteIndicadoresDieteticos.setString(6, paciente.getRazonDeModificacionAlimentacion());
 			pacienteIndicadoresDieteticos.setInt(7, paciente.getMatriculaPaciente());

 			
 			
 			pacienteIndicadoresDieteticos.executeUpdate();
 			pacienteIndicadoresDieteticos.close();
 			
 			PreparedStatement pacienteIndicadoresDieteticosDos = miConexion.prepareStatement("INSERT INTO form7(alimentosPrefe,alimentosNo,alimentosMalestar,suplementos,recordatorio,matricula) VALUES (?,?,?,?,?,?)");

 			pacienteIndicadoresDieteticosDos.setString(1,paciente.getAlimentosPreferidos());
			pacienteIndicadoresDieteticosDos.setString(2,paciente.getAlimentosNoAgradables());
 			pacienteIndicadoresDieteticosDos.setString(3,paciente.getAlimentosMalestar());
 			pacienteIndicadoresDieteticosDos.setString(4,paciente.getSuplementos());
 			pacienteIndicadoresDieteticosDos.setString(5,paciente.getRecordatorio());
 			pacienteIndicadoresDieteticosDos.setInt(6,paciente.getMatriculaPaciente());
 			
 			pacienteIndicadoresDieteticosDos.executeUpdate();
 			pacienteIndicadoresDieteticosDos.close();
 			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

}
