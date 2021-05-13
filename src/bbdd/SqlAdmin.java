package bbdd;

import java.sql.SQLException;
import java.util.ArrayList;

import bean.Producto;
import bean.Usuario;

public class SqlAdmin {

	//SQL donde se actualiza la database eliminando el id del usuario ya que nombre y password pueden compartir un usuario pero id no.
	
	public int eliminarDatosUsuario(int id) {
		new Conexion().EjecutarUpdate("DELETE FROM usuarios WHERE Id='"+id+"';");
		return id;
	}
	
	//SQL donde se actualiza la database eliminando asi el producto
	
	public int eliminarDatosProducto(int id) {
		new Conexion().EjecutarUpdate("DELETE FROM producto WHERE IdProducto='"+id+"';");
		return id;
	}

	//Creacion de la tabla de usuario llevandole un Array List desde Controller y haciendo la sentencia SQL mientras se guarda en las correspondientes columnas.
	
	public ArrayList<Usuario> creacionTablaUsuario(ArrayList<Usuario> mostrarUsuario) throws SQLException {
	
		ArrayList<Usuario> listaUsuario = new ArrayList<>();
		
		new Conexion().EjecutarSentencia("Select * from usuarios;");
		
		Usuario usuario;
		
		//En este While se recorre las columnas donde se van mostrando los datos de la tabla usuario
		
		while(new Conexion().resultado.next()) {
			usuario = new Usuario(new Conexion().resultado.getInt("Id"), new Conexion().resultado.getString("Nombre"), new Conexion().resultado.getString("password"));
			listaUsuario.add(usuario);
		}
		
		return listaUsuario;
	}
	
	//Creacion de la tabla de producto llevandole un Array List desde Controller y haciendo la sentencia SQL mientras se guarda en las correspondientes columnas.
	
	public ArrayList<Producto> creacionTablaProducto(ArrayList<Producto> mostrarUsuario) throws SQLException {
		
		ArrayList<Producto> listaProducto = new ArrayList<>();
		
		new Conexion().EjecutarSentencia("Select * from producto;");
		
		Producto producto;
		
		//En este While se recorre las columnas donde se van mostrando los datos de la tabla producto
		
		while(new Conexion().resultado.next()) {
			producto = new Producto(new Conexion().resultado.getInt("IdProducto"), new Conexion().resultado.getString("Nombres"), new Conexion().resultado.getDouble("Precio"),
					new Conexion().resultado.getInt("Stock"), new Conexion().resultado.getString("Estado"));
			
			listaProducto.add(producto);
		}
		
		return listaProducto;
	}

	// BETA Creacion de la tabla de historial del usuario llevandole un Array List desde Controller y haciendo la sentencia SQL mientras se guarda en las correspondientes columnas.
	
	public ArrayList<Producto> creacionTablaProductoUsuario(ArrayList<Producto> mostrarCesta) throws SQLException {
		// TODO Auto-generated method stub
		
		
		ArrayList<Producto> listaCesta = new ArrayList<>();
		
		new Conexion().EjecutarSentencia("INSERT INTO detalle_venta (Nombre_Usuario, Nombre_Producto, Precio, Cantidad, Precio Venta) values ();");
		
		//new Conexion().EjecutarUpdate("INSERT INTO producto (Nombres, Precio, Stock, Estado) values ('"+nuevoProducto+"', '"+nuevoPrecio+"', '"+nuevoCantidad+"', '"+nuevoEstado+"');");
			
		Producto producto;
		
		while(new Conexion().resultado.next()) {
			producto = new Producto(new Conexion().resultado.getString("Nombre_Usuario"), new Conexion().resultado.getString("Nombre_Producto"), new Conexion().resultado.getDouble("Precio"), new Conexion().resultado.getInt("Cantidad"), new Conexion().resultado.getInt("PrecioVenta"));
			
			listaCesta.add(producto);
		}
		
		return mostrarCesta;
	}

	//Aqui inserto la sentencia de update los productos en la tabla producto de la database.
	
	public void insertarProducto(String nuevoProducto, double nuevoPrecio, int nuevoCantidad, int nuevoEstado) {
	
		new Conexion().EjecutarUpdate("INSERT INTO producto (Nombres, Precio, Stock, Estado) values ('"+nuevoProducto+"', '"+nuevoPrecio+"', '"+nuevoCantidad+"', '"+nuevoEstado+"');");
	}

	public void insertarCesta(int IdProducto, String nombreUser, String nombreProduc, int cantidad, double precio) {
		
		int numIdDetalleVentas=(int) Math.floor(Math.random()*9999+1);
		
		int numIdVentas=(int) Math.floor(Math.random()*9999+1);
		
		new Conexion().EjecutarUpdate("INSERT INTO detalle_ventas (IdDetalleVentas, IdVentas, IdProducto, Nombre_Usuario,  Nombre_Producto, Precio, Cantidad) values ('"+numIdDetalleVentas+"', '"+numIdVentas+"', '"+IdProducto+"', '"+nombreUser+"', '"+nombreProduc+"', '"+precio+"', '"+cantidad+"');");		
	}
	
}