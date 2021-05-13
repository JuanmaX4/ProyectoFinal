package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import bean.Producto;
import bean.Usuario;
import controlador.Controller;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CestaCompra extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton Pagar;
	private JButton Mostrar_Tabla;
	private JButton Logout;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TablaUsuario frame = new TablaUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public CestaCompra() throws SQLException {
		setTitle("Cesta");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\juanm\\OneDrive\\Ambiente de Trabalho\\Curso ADA\\Java\\Proyecto\\src\\imgVista\\iconoProyecto.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Boton que cierra la pantalla de la Cesta
		
		Logout = new JButton("Cerrar Sesi\u00F3n");
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}
		});
		Logout.setForeground(new Color(244, 164, 96));
		Logout.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		Logout.setBackground(new Color(255, 175, 175));
		Logout.setBounds(563, 317, 153, 79);
		contentPane.add(Logout);
		
		//Scroll donde puedes subir y bajar la tabla en caso de que haya muchos parametros dentro con el raton
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 543, 349);
		contentPane.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		Mostrar_Tabla = new JButton("Mostrar Tabla");
		Mostrar_Tabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Array que recorre el objeto Producto donde en 5 se almacenara las columnas que mencionamos abajo del codigo
				
				ArrayList<Producto> mostrarProducto = new ArrayList<Producto>(5);
				
				try {
					mostrarProducto = new Controller().verTablaProductoUsuario(mostrarProducto);
				} catch (SQLException e1) {
					JOptionPane.showConfirmDialog(null, "Hubo un error en la Database");
					e1.printStackTrace();
				}
				
				DefaultTableModel modeoTablaProducto = (DefaultTableModel)table.getModel();
				
				Object [] row = new Object[4];
					
				String [] columnas = {"Nombre Usuario", "Nombre Producto", "Precio", "Cantidad", "Precio Venta"};
				
				//For donde se recorre la columna mencionada en el array columnas
				
				for (int i = 0; i < columnas.length; i++) {
					modeoTablaProducto.addColumn(columnas[i]);
				}
				
				//For donde recorreria todas las filas seleccionada de la tabla detalles_ventas
				
				for (int i = 0; i < mostrarProducto.size(); i++) {
					row[0]=mostrarProducto.get(i).getNombre();
					row[1]=mostrarProducto.get(i).getNombreProducto();
					row[2]=mostrarProducto.get(i).getPrecio();
					row[3]=mostrarProducto.get(i).getCantidad();
					row[4]=mostrarProducto.get(i).getPrecioVenta();
					modeoTablaProducto.addRow(row);
				}		
			}
		});
		Mostrar_Tabla.setForeground(new Color(128, 0, 0));
		Mostrar_Tabla.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		Mostrar_Tabla.setBackground(Color.PINK);
		Mostrar_Tabla.setBounds(563, 45, 153, 79);
		contentPane.add(Mostrar_Tabla);
		
		Pagar = new JButton("Pagar Cesta");
		Pagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Hacer un Insert into pagar algo XD
				String pago = JOptionPane.showInputDialog(null, "Introducie la cantidad a pagar");
	
				//Falta de codigo que no pude terminar esta parte esta en beta access
				
				int cantidadPagada=Integer.parseInt(pago);
		
			}
		});
		Pagar.setForeground(new Color(102, 205, 170));
		Pagar.setBackground(Color.PINK);
		Pagar.setFont(new Font("Brush Script MT", Font.PLAIN, 25));
		Pagar.setBounds(563, 176, 153, 79);
		contentPane.add(Pagar);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 744, 449);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\juanm\\OneDrive\\Ambiente de Trabalho\\Curso ADA\\Java\\Proyecto\\src\\imgVista\\instrumentos.jpg"));
		contentPane.add(lblNewLabel);
	}
}