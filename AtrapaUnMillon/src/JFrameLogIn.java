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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameLogIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContrasenia;

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
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(193, 118, 220, 24);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContrasenia = new JTextField();
		txtContrasenia.setColumns(10);
		txtContrasenia.setBounds(193, 209, 220, 24);
		contentPane.add(txtContrasenia);
		
		JLabel lblSesion = new JLabel("Inicio de Sesión");
		lblSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblSesion.setFont(new Font("Verdana", Font.BOLD, 22));
		lblSesion.setBounds(155, 28, 290, 45);
		contentPane.add(lblSesion);
		
		JLabel lblfallo = new JLabel("");
		lblfallo.setHorizontalAlignment(SwingConstants.CENTER);
		lblfallo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblfallo.setForeground(Color.RED);
		lblfallo.setBounds(128, 265, 329, 21);
		contentPane.add(lblfallo);
		
		//Funcionalidad BtnEntrar
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtUsuario.getText().equals("") && !txtContrasenia.getText().equals("")) {
					
				}
				else {
					lblfallo.setText("No puede haber campos vacíos.");
					
				}
				
			}
		});
		btnEntrar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnEntrar.setBounds(250, 306, 100, 23);
		contentPane.add(btnEntrar);
		
		

	}
}
