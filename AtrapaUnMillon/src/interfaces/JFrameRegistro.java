package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import model.Usuario;
import mongo.MongoDBColecciones;

public class JFrameRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContrasenia;
	private JTextField txtRepetir;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public JFrameRegistro(JframeInterfaz frame) {
		setTitle("Atrapa Un Millón: Registro de Usuario");
		setBounds(350, 200, 650, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUsuario.setBounds(99, 80, 73, 21);
		contentPane.add(lblUsuario);

		JLabel lblContrasenia = new JLabel("Contraseña:");
		lblContrasenia.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblContrasenia.setBounds(72, 137, 100, 21);
		contentPane.add(lblContrasenia);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(215, 81, 220, 24);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtContrasenia = new JTextField();
		txtContrasenia.setColumns(10);
		txtContrasenia.setBounds(215, 138, 220, 24);
		contentPane.add(txtContrasenia);

		JLabel lblIncorrecto = new JLabel("");
		lblIncorrecto.setForeground(new Color(255, 0, 0));
		lblIncorrecto.setBounds(215, 252, 220, 12);
		contentPane.add(lblIncorrecto);

		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setFont(new Font("Verdana", Font.BOLD, 22));
		lblRegistro.setBounds(180, 10, 290, 45);
		contentPane.add(lblRegistro);

		JButton btnRegistrar = new JButton("Registrarse");
		btnRegistrar.addActionListener(new ActionListener() {

			// Comprobación para registrar
			public void actionPerformed(ActionEvent e) {
				if (txtUsuario.getText().isEmpty() || txtContrasenia.getText().isEmpty()
						|| txtRepetir.getText().isEmpty()) {
					lblIncorrecto.setText("Debes rellenar todos los campos.");
				} else {
					if (!txtContrasenia.getText().equals(txtRepetir.getText())) {
						lblIncorrecto.setText("Las contraseñas no coinciden.");
						
						}
					else {
						boolean existe = MongoDBColecciones.comprobarExistenciaUsuario(txtUsuario.getText());
						if (existe) {
							lblIncorrecto.setText("El nombre " + txtUsuario.getText() + " ya está escogido.");
						} 
						else {
							dispose();
							Document user = new Document("usuario", txtUsuario.getText())
									.append("contraseña", txtContrasenia.getText()).append("dineroUsuario", 0)
									.append("dineroMejorPartida", 0);
							MongoDBColecciones.getCollectionUsuarios().insertOne(user);
							Usuario usuario = new Usuario(txtUsuario.getText(), txtContrasenia.getText());

							JPanelFondo panelFondo = new JPanelFondo(usuario);
							frame.setContentPane(panelFondo);
						}
					}					
				}
			}
		});


		btnRegistrar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnRegistrar.setBounds(275, 288, 100, 23);
		contentPane.add(btnRegistrar);

		txtRepetir = new JTextField();
		txtRepetir.setColumns(10);
		txtRepetir.setBounds(215, 196, 220, 24);
		contentPane.add(txtRepetir);

		JLabel lblRepetircontrasenia = new JLabel("RepetirContraseña:");
		lblRepetircontrasenia.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblRepetircontrasenia.setBounds(30, 195, 175, 21);
		contentPane.add(lblRepetircontrasenia);

	}
}
