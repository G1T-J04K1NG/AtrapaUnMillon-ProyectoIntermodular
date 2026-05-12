package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import model.Usuario;
import mongo.MongoDBColecciones;

public class JFrameLogIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContrasenia;
	public JButton btnEntrar;
	public JLabel lblUsuario;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public JFrameLogIn(JframeInterfaz frame) {
		setTitle("Atrapa Un Millón: Inicio De Sesión");
		setBounds(350, 200, 650, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblUsuario = new JLabel("Usuario:");
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

		// Funcionalidad BtnEntrar
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtUsuario.getText().trim().isEmpty() && !txtContrasenia.getText().trim().isEmpty()) {
					String usuarionombre = txtUsuario.getText();
					Usuario usuarioEncontrado = MongoDBColecciones.getUsuarioPorUsuarioNombre(usuarionombre);
					if (usuarioEncontrado != null) {
						if (txtContrasenia.getText().trim().equals(usuarioEncontrado.getString("contraseña"))) {
							dispose();

							Usuario usuario = new Usuario(usuarionombre, usuarioEncontrado.getString("contraseña"),
									usuarioEncontrado.getInteger("dineroUsuario"),
									usuarioEncontrado.getInteger("dineroMejorPartida"));

							JPanelFondo panelFondo = new JPanelFondo(usuario, collectionUsuarios, collectionPreguntas);
							frame.setContentPane(panelFondo);

						} else {
							lblfallo.setText("La contraseña no es correcta.");
						}
					} else {
						lblfallo.setText("Este usuario no existe.");
					}

				} else {
					lblfallo.setText("Debes rellenar todos los campos.");

				}

			}
		});
		btnEntrar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnEntrar.setBounds(250, 306, 100, 23);
		contentPane.add(btnEntrar);

	}

}
