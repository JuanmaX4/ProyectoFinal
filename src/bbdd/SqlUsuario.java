package bbdd;

import bean.Usuario;

public class SqlUsuario {

	
	public static void registrarDataBase(Usuario usuario) {
		
		//Aqui se registra el usuario mediante esta sentencia en la tabla usuarios
		
		String sql = "INSERT INTO usuarios (Nombre, password) VALUES ('"+usuario.getNombre()+"', '"+usuario.getPassword()+"');";
		
		Conexion.EjecutarUpdate(sql);
	}	
	
	public int recogerCompra(int cantidad, int idProducto) {
		
		//Sentencia donde se selecciona los idproductos que se muestra en la tabla
			
		String sql = "SELECT * FROM producto where IdProducto='"+idProducto+"';";
		Conexion.EjecutarSentencia(sql);
				
		//Actualiza la tabla cuando compras eliminando a sin parte del stock
		
		String sqlStock = "update producto set Stock= Stock - '"+cantidad+"';";
		Conexion.EjecutarUpdate(sqlStock);
	
		return cantidad;
	}
}
