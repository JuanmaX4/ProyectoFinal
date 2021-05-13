package bean;

public class Producto {

	int idProducto;
	String nombreProducto;
	double precio;
	int stock;
	String estado;
	int IdUsuario;
	int cantidad;
	int idVenta;
	double precioVenta;
	String nombre;
	

	public Producto(){
		
		
	}
	
	//Constructor donde se implementan ahi los for de la database proyecto de la tabla producto en el loginAdmin al darle TablaProducto
	
	public Producto(int idProducto, String nombreProducto, 
			double precio, int stock, String estado) {
		
		this.idProducto=idProducto;
		this.nombreProducto=nombreProducto;
		this.precio=precio;
		this.stock=stock;
		this.estado=estado;
	}
	
	//BETA constructor productos donde se verian en la tabla cesta del usuario que no fue implementado por falta de tiempo
	
	public Producto(String nombre, String nombreProducto, double precio, int cantidad, double precioVenta) {
		this.nombre=nombre;
		this.nombreProducto=nombreProducto;
		this.precio=precio;
		this.precioVenta=precioVenta;
		this.cantidad=cantidad;		
	}
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getIdUsuario() {
		return IdUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.IdUsuario = idUsuario;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}