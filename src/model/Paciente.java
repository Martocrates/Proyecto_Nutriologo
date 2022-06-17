package model;

import javafx.beans.property.SimpleStringProperty;

public class Paciente {

	public SimpleStringProperty matricula = new SimpleStringProperty();

	public SimpleStringProperty nombre = new SimpleStringProperty();

	public SimpleStringProperty apellido = new SimpleStringProperty();

	public SimpleStringProperty fecha = new SimpleStringProperty();
	
	public String getMatricula() {
		return matricula.get();
	}
	public void setMatricula(SimpleStringProperty matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre.get();
	}

	public void setNombre(SimpleStringProperty nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido.get();
	}

	public void setApellido(SimpleStringProperty apellido) {
		this.apellido = apellido;
	}

	public String getFecha() {
		return fecha.get();
	}

	public void setFecha(SimpleStringProperty fecha) {
		this.fecha = fecha;
	}
	private static int expediente;
	
	/*Indicadores*/
	private static boolean editable = false;
	private static int matriculaActualPaciente;
	
	
	public int getMatriculaActualPaciente() {
		return matriculaActualPaciente;
	}
	public void setMatriculaActualPaciente(int matriculaActualPaciente) {
		Paciente.matriculaActualPaciente = matriculaActualPaciente;
	}
	/*Datos paciente*/
	private static String nombrePaciente;
	private static String fechaPaciente;
	private static String apellidoPaciente;
	private static int matriculaPaciente;
	private static int edad;
	private static String sexo;
	private static String carrera;
	private static int semestre;
	private static String turno;
	private static String fechaNacimiento;
	private static String ocupacion;
	private static String telefono;
	private static String email;

	/*Antecedentes familiares*/
	private static String obesidad;
	private static String diabetes;
	private static String hta;
	private static String cancer;
	private static String Hipercolesterolemia;
	private static String Hipertrigliceridemia;
	
	/*Datos antropologicos*/
	private static float peso;
	private static float talla;
	private static float imc;
	private static float perimetroCintura;
	private static float perimetroCadera;
	private static float icc;
	
	/*Datos bioquimicos*/
	private static String consumoTabaco;
	private static String frecuenciaTabaco;
	private static String consumoAlcohol;
	private static String frecuenciaAlcohol;
	private static String actividadFisica;
	private static String frecuenciaActividad;
	private static String duracionActividad;
	private static String glucosa;
	private static String colesterol;
	private static String trigliceridos;
	private static String albumia;
	private static String otrosDatosBioquimicos;
	
	/*Indicadores clinicos*/
	private static String pelo;
	private static String unias;
	private static String piel;
	private static String diarrea;
	private static String estrenimiento;
	
	private static String vomito;
	private static String colitis;
	private static String pirosis;
	private static String gastritis;
	private static String ulcera;
	
	private static String ojos;
	private static String dentadura;
	private static String hidratacion;
	private static String nauseas;
	private static String otrosDatosClinicos;
	
	private static String enfermedadDiagnosticada;
	private static String tomaAlgunMedicamento;
	private static String cualMedicamentoToma;
	private static String dosisMedicamento;
	private static String desdeCuandoMedicamento;
	private static String cirugiasPracticadas;
	private static String especificarCirugias;
	
	/*Indicadores dieteticos*/
	private static String comidasAlDia;
	private static String dondeCome;
	private static String quienPreparaAlimentos;
	private static String cambiosEnHambre;
	private static String modificacionAlimentacion;
	private static String razonDeModificacionAlimentacion;
	
	/*Indicadores dieteticos dos*/
	private static String alimentosPreferidos;
	private static String alimentosNoAgradables;
	private static String alimentosMalestar;
	private static String suplementos;
	private static String recordatorio;
	
	public int getExpediente() {
		return expediente;
	}
	public void setExpediente(int expediente) {
		Paciente.expediente = expediente;
	}
	
	public String getNombrePaciente() {
		return nombrePaciente;
	}
	public void setNombrePaciente(String nombrePaciente) {
		Paciente.nombrePaciente = nombrePaciente;
	}
	public String getApellidoPaciente() {
		return apellidoPaciente;
	}
	public void setApellidoPaciente(String apellidoPaciente) {
		Paciente.apellidoPaciente = apellidoPaciente;
	}
	public int getMatriculaPaciente() {
		return matriculaPaciente;
	}
	public void setMatriculaPaciente(int matriculaPaciente) {
		Paciente.matriculaPaciente = matriculaPaciente;
	}

	public boolean getEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObesidad() {
		return obesidad;
	}

	public void setObesidad(String obesidad) {
		this.obesidad = obesidad;
	}

	public String getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(String diabetes) {
		this.diabetes = diabetes;
	}

	public String getHta() {
		return hta;
	}

	public void setHta(String hta) {
		this.hta = hta;
	}

	public String getCancer() {
		return cancer;
	}

	public void setCancer(String cancer) {
		this.cancer = cancer;
	}

	public String getHipercolesterolemia() {
		return Hipercolesterolemia;
	}

	public void setHipercolesterolemia(String hipercolesterolemia) {
		Hipercolesterolemia = hipercolesterolemia;
	}

	public String getHipertrigliceridemia() {
		return Hipertrigliceridemia;
	}

	public void setHipertrigliceridemia(String hipertrigliceridemia) {
		Hipertrigliceridemia = hipertrigliceridemia;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getTalla() {
		return talla;
	}

	public void setTalla(float talla) {
		this.talla = talla;
	}

	public float getImc() {
		return imc;
	}

	public void setImc(float imc) {
		this.imc = imc;
	}

	public float getPerimetroCintura() {
		return perimetroCintura;
	}

	public void setPerimetroCintura(float perimetroCintura) {
		this.perimetroCintura = perimetroCintura;
	}

	public float getPerimetroCadera() {
		return perimetroCadera;
	}

	public void setPerimetroCadera(float perimetroCadera) {
		this.perimetroCadera = perimetroCadera;
	}

	public float getIcc() {
		return icc;
	}

	public void setIcc(float icc) {
		this.icc = icc;
	}

	public String getConsumoTabaco() {
		return consumoTabaco;
	}

	public void setConsumoTabaco(String consumoTabaco) {
		this.consumoTabaco = consumoTabaco;
	}

	public String getFrecuenciaTabaco() {
		return frecuenciaTabaco;
	}

	public void setFrecuenciaTabaco(String frecuenciaTabaco) {
		this.frecuenciaTabaco = frecuenciaTabaco;
	}

	public String getConsumoAlcohol() {
		return consumoAlcohol;
	}

	public void setConsumoAlcohol(String consumoAlcohol) {
		this.consumoAlcohol = consumoAlcohol;
	}

	public String getFrecuenciaAlcohol() {
		return frecuenciaAlcohol;
	}

	public void setFrecuenciaAlcohol(String frecuenciaAlcohol) {
		this.frecuenciaAlcohol = frecuenciaAlcohol;
	}

	public String getActividadFisica() {
		return actividadFisica;
	}

	public void setActividadFisica(String actividadFisica) {
		this.actividadFisica = actividadFisica;
	}

	public String getFrecuenciaActividad() {
		return frecuenciaActividad;
	}

	public void setFrecuenciaActividad(String frecuenciaActividad) {
		this.frecuenciaActividad = frecuenciaActividad;
	}

	public String getDuracionActividad() {
		return duracionActividad;
	}

	public void setDuracionActividad(String duracionActividad) {
		this.duracionActividad = duracionActividad;
	}

	public String getGlucosa() {
		return glucosa;
	}

	public void setGlucosa(String glucosa) {
		this.glucosa = glucosa;
	}

	public String getColesterol() {
		return colesterol;
	}

	public void setColesterol(String colesterol) {
		this.colesterol = colesterol;
	}

	public String getTrigliceridos() {
		return trigliceridos;
	}

	public void setTrigliceridos(String trigliceridos) {
		this.trigliceridos = trigliceridos;
	}

	public String getAlbumia() {
		return albumia;
	}

	public void setAlbumia(String albumia) {
		this.albumia = albumia;
	}

	public String getOtrosDatosBioquimicos() {
		return otrosDatosBioquimicos;
	}

	public void setOtrosDatosBioquimicos(String otrosDatosBioquimicos) {
		this.otrosDatosBioquimicos = otrosDatosBioquimicos;
	}

	public String getPelo() {
		return pelo;
	}

	public void setPelo(String pelo) {
		this.pelo = pelo;
	}

	public String getUnias() {
		return unias;
	}

	public void setUnias(String unias) {
		this.unias = unias;
	}

	public String getPiel() {
		return piel;
	}

	public void setPiel(String piel) {
		this.piel = piel;
	}

	public String getDiarrea() {
		return diarrea;
	}

	public void setDiarrea(String diarrea) {
		this.diarrea = diarrea;
	}

	public String getEstrenimiento() {
		return estrenimiento;
	}

	public void setEstrenimiento(String estrenimiento) {
		this.estrenimiento = estrenimiento;
	}

	public String getVomito() {
		return vomito;
	}

	public void setVomito(String vomito) {
		this.vomito = vomito;
	}

	public String getColitis() {
		return colitis;
	}

	public void setColitis(String colitis) {
		this.colitis = colitis;
	}

	public String getPirosis() {
		return pirosis;
	}

	public void setPirosis(String pirosis) {
		this.pirosis = pirosis;
	}

	public String getGastritis() {
		return gastritis;
	}

	public void setGastritis(String gastritis) {
		this.gastritis = gastritis;
	}

	public String getUlcera() {
		return ulcera;
	}

	public void setUlcera(String ulcera) {
		this.ulcera = ulcera;
	}

	public String getOjos() {
		return ojos;
	}

	public void setOjos(String ojos) {
		this.ojos = ojos;
	}

	public String getDentadura() {
		return dentadura;
	}

	public void setDentadura(String dentadura) {
		this.dentadura = dentadura;
	}

	public String getHidratacion() {
		return hidratacion;
	}

	public void setHidratacion(String hidratacion) {
		this.hidratacion = hidratacion;
	}

	public String getNauseas() {
		return nauseas;
	}

	public void setNauseas(String nauseas) {
		this.nauseas = nauseas;
	}

	public String getOtrosDatosClinicos() {
		return otrosDatosClinicos;
	}

	public void setOtrosDatosClinicos(String otrosDatosClinicos) {
		this.otrosDatosClinicos = otrosDatosClinicos;
	}

	public String getEnfermedadDiagnosticada() {
		return enfermedadDiagnosticada;
	}

	public void setEnfermedadDiagnosticada(String enfermedadDiagnosticada) {
		this.enfermedadDiagnosticada = enfermedadDiagnosticada;
	}

	public String getTomaAlgunMedicamento() {
		return tomaAlgunMedicamento;
	}

	public void setTomaAlgunMedicamento(String tomaAlgunMedicamento) {
		this.tomaAlgunMedicamento = tomaAlgunMedicamento;
	}

	public String getCualMedicamentoToma() {
		return cualMedicamentoToma;
	}

	public void setCualMedicamentoToma(String cualMedicamentoToma) {
		this.cualMedicamentoToma = cualMedicamentoToma;
	}

	public String getDosisMedicamento() {
		return dosisMedicamento;
	}

	public void setDosisMedicamento(String dosisMedicamento) {
		this.dosisMedicamento = dosisMedicamento;
	}

	public String getDesdeCuandoMedicamento() {
		return desdeCuandoMedicamento;
	}

	public void setDesdeCuandoMedicamento(String comienzoMedicamento) {
		this.desdeCuandoMedicamento = comienzoMedicamento;
	}

	public String getCirugiasPracticadas() {
		return cirugiasPracticadas;
	}

	public void setCirugiasPracticadas(String cirugiasPracticadas) {
		this.cirugiasPracticadas = cirugiasPracticadas;
	}

	public String getEspecificarCirugias() {
		return especificarCirugias;
	}

	public void setEspecificarCirugias(String especificarCirugias) {
		this.especificarCirugias = especificarCirugias;
	}

	public String getComidasAlDia() {
		return comidasAlDia;
	}

	public void setComidasAlDia(String comidasAlDia) {
		this.comidasAlDia = comidasAlDia;
	}

	public String getDondeCome() {
		return dondeCome;
	}

	public void setDondeCome(String dondeCome) {
		this.dondeCome = dondeCome;
	}

	public String getQuienPreparaAlimentos() {
		return quienPreparaAlimentos;
	}

	public void setQuienPreparaAlimentos(String quienPreparaAlimentos) {
		this.quienPreparaAlimentos = quienPreparaAlimentos;
	}

	public String getCambiosEnHambre() {
		return cambiosEnHambre;
	}

	public void setCambiosEnHambre(String cambiosEnHambre) {
		this.cambiosEnHambre = cambiosEnHambre;
	}

	public String getModificacionAlimentacion() {
		return modificacionAlimentacion;
	}

	public void setModificacionAlimentacion(String modificacionAlimentacion) {
		this.modificacionAlimentacion = modificacionAlimentacion;
	}

	public String getRazonDeModificacionAlimentacion() {
		return razonDeModificacionAlimentacion;
	}

	public void setRazonDeModificacionAlimentacion(String razonDeModificacionAlimentacion) {
		this.razonDeModificacionAlimentacion = razonDeModificacionAlimentacion;
	}

	public String getAlimentosPreferidos() {
		return alimentosPreferidos;
	}

	public void setAlimentosPreferidos(String alimentosPreferidos) {
		this.alimentosPreferidos = alimentosPreferidos;
	}

	public String getAlimentosNoAgradables() {
		return alimentosNoAgradables;
	}

	public void setAlimentosNoAgradables(String alimentosNoAgradables) {
		this.alimentosNoAgradables = alimentosNoAgradables;
	}

	public String getAlimentosMalestar() {
		return alimentosMalestar;
	}

	public void setAlimentosMalestar(String alimentosMalestar) {
		this.alimentosMalestar = alimentosMalestar;
	}

	public String getSuplementos() {
		return suplementos;
	}

	public void setSuplementos(String suplementos) {
		this.suplementos = suplementos;
	}

	public String getRecordatorio() {
		return recordatorio;
	}

	public void setRecordatorio(String recordatorio) {
		this.recordatorio = recordatorio;
	}
	public String getFechaPaciente() {
		return fechaPaciente;
	}
	public void setFechaPaciente(String fechaPaciente) {
		Paciente.fechaPaciente = fechaPaciente;
	}

	public void reiniciarDatos() {
		/*Datos paciente*/
		 nombrePaciente="";
		 fechaPaciente="";
		 apellidoPaciente="";
		 matriculaPaciente=0;
		 edad=0;
		 sexo="";
		 carrera="";
		 semestre=0;
		 turno="";
		 fechaNacimiento="";
		 ocupacion="";
		 telefono="";
		 email="";

		/*Antecedentes familiares*/
		 obesidad="";
		 diabetes="";
		 hta="";
		 cancer="";
		 Hipercolesterolemia="";
		 Hipertrigliceridemia="";
		
		/*Datos antropologicos*/
		 peso=0;
		 talla=0;
		 imc=0;
		 perimetroCintura=0;
		 perimetroCadera=0;
		 icc=0;
		
		/*Datos bioquimicos*/
		 consumoTabaco="";
		 frecuenciaTabaco="";
		 consumoAlcohol="";
		 frecuenciaAlcohol="";
		 actividadFisica="";
		 frecuenciaActividad="";
		 duracionActividad="";
		 glucosa="";
		 colesterol="";
		 trigliceridos="";
		 albumia="";
		 otrosDatosBioquimicos="";
		
		/*Indicadores clinicos*/
		 pelo="";
		 unias="";
		 piel="";
		 diarrea="";
		 estrenimiento="";
		
		 vomito="";
		 colitis="";
		 pirosis="";
		 gastritis="";
		 ulcera="";
		
		 ojos="";
		 dentadura="";
		 hidratacion="";
		 nauseas="";
		 otrosDatosClinicos="";
		
		 enfermedadDiagnosticada="";
		 tomaAlgunMedicamento="";
		 cualMedicamentoToma="";
		 dosisMedicamento="";
		 desdeCuandoMedicamento="";
		 cirugiasPracticadas="";
		 especificarCirugias="";
		
		/*Indicadores dieteticos*/
		 comidasAlDia="";
		 dondeCome="";
		 quienPreparaAlimentos="";
		 cambiosEnHambre="";
		 modificacionAlimentacion="";
		 razonDeModificacionAlimentacion="";
		
		/*Indicadores dieteticos dos*/
		 alimentosPreferidos="";
		 alimentosNoAgradables="";
		 alimentosMalestar="";
		 suplementos="";
		 recordatorio="";
	}

	
}
