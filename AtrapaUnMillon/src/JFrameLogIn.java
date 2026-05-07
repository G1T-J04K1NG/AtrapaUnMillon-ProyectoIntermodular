import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class JFrameLogIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public JFrameLogIn(MongoCollection<Document> collectionUsuarios) {
		setTitle("Atrapa Un Millón: Inicio De Sesión");
		setBounds(350, 200, 650, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUsuario.setBounds(128, 117, 73, 21);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasenia = new JLabel("Contraseña:");
		lblContrasenia.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblContrasenia.setBounds(101, 209, 100, 21);
		contentPane.add(lblContrasenia);
		
		textField = new JTextField();
		textField.setBounds(193, 118, 220, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(193, 209, 220, 24);
		contentPane.add(textField_1);
		
		JLabel lblSesion = new JLabel("Inicio de Sesión");
		lblSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblSesion.setFont(new Font("Verdana", Font.BOLD, 22));
		lblSesion.setBounds(155, 28, 290, 45);
		contentPane.add(lblSesion);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnEntrar.setBounds(250, 306, 100, 23);
		contentPane.add(btnEntrar);

	}
}
