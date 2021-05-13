package main;

import java.awt.EventQueue;
import bbdd.Conexion;
import vista.Login;

public class Main {
	public static void main(String[] args) {
		/* Conexión con la BBDD */
		Conexion.Conectar();
		
		/* LLamada a la vista principal */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
	}
}