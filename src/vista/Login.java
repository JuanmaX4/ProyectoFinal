package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.Controller;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.ImageIcon;

import java.applet.AudioClip;
import java.awt.Color;
import javax.swing.JPasswordField;


public class Login extends JFrame {

	private JPanel contentPane;
	public JTextField txtusuario;
	public JPasswordField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					//inicio de sesion en el login 
					
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\juanm\\OneDrive\\Ambiente de Trabalho\\Curso ADA\\Java\\Proyecto\\src\\imgVista\\iconoProyecto.jpg"));		
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("claveMenu.ico"));
		//setIconImage(iconoPropio);
		//setVisible(true);
		setBounds(100, 100, 1033, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//panel donde estan insertando los botones de inicio sesion y contraseña tambien al lado nombre contraseña
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1019, 472);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//hueco del programa donde insertas en el teclado de la GUI interfaz grafica tu contraseña
		
		Password = new JPasswordField();
		Password.setBounds(610, 180, 150, 38);
		panel.add(Password);

		//hueco del programa donde insertas en el teclado de la GUI interfaz grafica tu nombre de usuario
		
		txtusuario = new JTextField();
		txtusuario.setBounds(612, 116, 148, 38);
		panel.add(txtusuario);
		txtusuario.setColumns(10);
		
		//boton de inciio de sesion
		
		JButton Login = new JButton("Iniciar Sesi\u00F3n");

		Login.setBackground(Color.ORANGE);
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = txtusuario.getText();
				String pass = Password.getText();
				boolean loginSuccess = new Controller().checkUser(user, pass);
				
				//if donde si el login es true en el controller entonces te abrira la tienda y si metes el usuario root y contraseña manolo iniciaras el modo admin.
				
				if(loginSuccess) {
					new Controller().ReproducirSonido("src/vista/sonido/TaDa-login.wav");					
					dispose();
					if (txtusuario.getText().equals("root") && Password.getText().equals("manolo")) {
						TiendaAdmin frameAd = new TiendaAdmin();
						frameAd.setVisible(true);
					}
					
					Tienda frame = new Tienda();
					frame.setVisible(true);
				}else {
					ErrorInicioSesion frame2 = new ErrorInicioSesion();
					frame2.setVisible(true);
				}
			}
		});
		Login.setBounds(612, 262, 131, 38);
		panel.add(Login);
		
		//boton de registrarse donde te manda a la pantalla Registrar
		
		JButton btnNewButton_1 = new JButton("Registrarse");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrar rg = new Registrar();				
				rg.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setBounds(612, 322, 131, 38);
		panel.add(btnNewButton_1);
		
		//boton de usuario con su color su fuente, tamaño y el color del recuadro del boton
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(504, 120, 74, 26);
		panel.add(lblNewLabel);
		
		//boton de contraseña con su color su fuente, tamaño y el color del recuadro del boton
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setBackground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(500, 185, 99, 28);
		panel.add(lblNewLabel_1);
		
		//imagen de fondo
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\juanm\\OneDrive\\Ambiente de Trabalho\\Curso ADA\\Java\\Proyecto\\src\\imgVista\\orchesta.gif"));
		lblNewLabel_2.setBounds(0, 0, 1019, 493);
		panel.add(lblNewLabel_2);
	}
}
