package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.Controller;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Registrar extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrar frame = new Registrar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registrar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\juanm\\OneDrive\\Ambiente de Trabalho\\Curso ADA\\Java\\Proyecto\\src\\imgVista\\iconoProyecto.jpg"));
		setTitle("Registro de Usuario");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 346, 603);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			
			//Boton donde al pulsarlo se envian los datos insertados en el recuadro blanco su nombre y su contraseña
			
			public void actionPerformed(ActionEvent e) {				
				if (passwordField.getText().equals(passwordField_1.getText())) {					
					Controller.registrar(textField.getText(), passwordField.getText());
				}
				else {
					//Este if solamente acredita si la conraseña y el repetir contraseña coinciden si no es a sin saldra este mensaje
					
					JOptionPane.showMessageDialog(null, "No coinciden la Contraseña con el repetir Contraseña");
				}			
			}
		});
		btnNewButton.setFont(new Font("Blackadder ITC", Font.PLAIN, 25));
		btnNewButton.setBounds(79, 491, 162, 38);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Blackadder ITC", Font.BOLD, 25));
		lblNewLabel.setBounds(29, 94, 98, 38);
		panel.add(lblNewLabel);
		
		//Todos los recuadros donde se insertan todos los datos aunque la direccion no es necesario la deje por estetica
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setForeground(Color.ORANGE);
		lblApellidos.setFont(new Font("Blackadder ITC", Font.BOLD, 25));
		lblApellidos.setBounds(29, 194, 144, 38);
		panel.add(lblApellidos);
		
		JLabel lblApellidos_1 = new JLabel("Contrase\u00F1a:");
		lblApellidos_1.setForeground(Color.ORANGE);
		lblApellidos_1.setFont(new Font("Blackadder ITC", Font.BOLD, 25));
		lblApellidos_1.setBounds(29, 290, 144, 38);
		panel.add(lblApellidos_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(196, 292, 150, 38);
		panel.add(passwordField);
		
		JLabel lblApellidos_1_3 = new JLabel("Repite\nContrase\u00F1a:");
		lblApellidos_1_3.setForeground(Color.ORANGE);
		lblApellidos_1_3.setFont(new Font("Blackadder ITC", Font.BOLD, 25));
		lblApellidos_1_3.setBounds(10, 386, 186, 38);
		panel.add(lblApellidos_1_3);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(196, 388, 150, 38);
		panel.add(passwordField_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(196, 94, 148, 38);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(198, 194, 148, 38);
		panel.add(textField_1);
		
		//fondo de pantalla gif del registro de usuario
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\juanm\\OneDrive\\Ambiente de Trabalho\\Curso ADA\\Java\\Proyecto\\src\\imgVista\\clavedesolMovimiento.gif"));
		lblNewLabel_1.setBounds(0, 0, 346, 603);
		panel.add(lblNewLabel_1);
	}

}