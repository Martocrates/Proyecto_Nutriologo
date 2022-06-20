package model;

import javax.swing.JOptionPane;

public class Mensaje {
	
	
	
	public static void MostrarMensajeDatosIncompletos () {
		JOptionPane.showMessageDialog(null, "Todo los campos deben estar llenos",
				  "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
	}
	
	public static void MostrarMensajeDatosIrreales () {
		JOptionPane.showMessageDialog(null, "Los campos no pueden ser menor a 1!",
				  "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
	}

}
