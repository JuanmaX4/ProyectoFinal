package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class ErrorInicioSesion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErrorInicioSesion frame = new ErrorInicioSesion();
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
	public ErrorInicioSesion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\juanm\\OneDrive\\Ambiente de Trabalho\\Curso ADA\\Java\\Proyecto\\src\\iconoProyecto.jpg"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 552, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//En esta clase no hay mucho que explicar es una pantalla normal y corriente que inserta en el que el usuaior o password fueron incorrectos y no se encuentran en la database
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 548, 353);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario o Password Incorrectos");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setBackground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Blackadder ITC", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(118, 77, 393, 170);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\juanm\\OneDrive\\Ambiente de Trabalho\\Curso ADA\\Java\\Proyecto\\src\\imgVista\\ErrorInicio.jfif"));
		lblNewLabel.setBounds(0, 0, 538, 353);
		panel.add(lblNewLabel);
	}
}
