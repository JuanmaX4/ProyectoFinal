package controlador;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import bbdd.SqlUsuario;
import bbdd.SqlAdmin;
import bean.Producto;
import bean.Usuario;
import modelo.Usuarios;
import vista.*;

public class Controller{
	
	
	//Funcion donde se puede saber si el usuario existe en la database o no
	
	public boolean checkUser(String user, String password) {
		 //new Usuarios().checkUser(user, password);
		if (new Usuarios().checkUser(user, password) != null) {
			return true;
		}
		return false;
	}
	
	//Funcion login donde mete los datos el usuario su nombre y password
	
	public void login(String username, String pass) {
		
		//txtusuario && Password
		
		username = new Login().txtusuario.getText();
		
		pass = new Login().Password.getText();
		
		JOptionPane.showMessageDialog(null, "Cargando....");
		
	}
	
	//Registro de usuario conectado a la database
	
	public static void registrar(String usuario, String contrasena) {
		
		Usuario usuarioRegistrado= new Usuario(usuario, contrasena);
		
		JOptionPane.showMessageDialog(null, "Registro en curso....");
		
		SqlUsuario.registrarDataBase(usuarioRegistrado);
	}	
	
	//Pantalla emergente que indica que al loguearse fue incorrecto
	
	public void registroFallido() {
		ErrorInicioSesion frame2 = new ErrorInicioSesion();
		frame2.setVisible(true);
	}
	
	//Tabla en la que solo accede el admin. monstrando asi en la database todos los usuarios
	
	public void mostrarUsuario() throws SQLException {
		TablaUsuario frameTableUser = new TablaUsuario();
		frameTableUser.setVisible(true);
	}
	
	//Manda a eliminar el admin. el usuario
	
	public int eliminarSqlUsuario(int id) {
		return new SqlAdmin().eliminarDatosUsuario(id);
	}
	
	//Manda el administrado a eliminar un producto
	
	public int eliminarSqlProducto(int id) {
		return new SqlAdmin().eliminarDatosProducto(id);
	}

	//Muestra la tabla de usuario en la clase TablaUsuario
	
	public ArrayList<Usuario> verTablaUsuario(ArrayList<Usuario> mostrarUsuario) throws SQLException {
		return new SqlAdmin().creacionTablaUsuario(mostrarUsuario);
	}
	
	//Muestra la tabla de los productos en la clase TablaProducto
	
	public ArrayList<Producto> verTablaProducto(ArrayList<Producto> mostrarProducto) throws SQLException {
		return new SqlAdmin().creacionTablaProducto(mostrarProducto);
	}
	
	//Agriega productos en la cesta solo debe tener la id del Producto y la cantidad que quiera el cliente
	
	public int agregarProductoCesta(int cantidad, int idProducto) {
		return new SqlUsuario().recogerCompra(cantidad, idProducto);
	}

	//En beta se muestra el historial de la compra del usuario.

	public ArrayList<Producto> verTablaProductoUsuario(ArrayList<Producto> mostrarCesta) throws SQLException {
		return new SqlAdmin().creacionTablaProductoUsuario(mostrarCesta);
	}

	//Crea un objeto en la database incrementandose su IdProducto
	
	public void crearProducto(String nuevoProducto, double nuevoPrecio, int nuevoCantidad, int nuevoEstado) {
		new SqlAdmin().insertarProducto(nuevoProducto, nuevoPrecio, nuevoCantidad, nuevoEstado);
	}
	
	//En beta agriego el historia de la compra pero no pude terminarlo por falta de tiempo
	
	public void agregarCarrito(int idProducto, String nombreUser, String nombreProduc, int cantidad, double precio) {
		new SqlAdmin().insertarCesta(idProducto, nombreUser, nombreProduc, cantidad, precio);
	}
	
	//Metodo donde se reproduce el sonido de la tienda
	
	 public void ReproducirSonido(String nombreSonido){
	     
		 try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	       } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
	         System.out.println("Error al reproducir el sonido.");
	         ex.printStackTrace();
	       }
	 }	
}