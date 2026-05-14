package interfaces;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
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

import model.Partida;
import model.Usuario;
import mongo.MongoDBColecciones;
import java.awt.Toolkit;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrameLogIn.class.getResource("/resources/logo_atrapa_millon.png")));
		setTitle("Atrapa Un Millón: Inicio De Sesión");
		setBounds(350, 200, 650, 400);
		contentPane = new JPanel() {
		    // IMPORTANTE: Cambia "FondoLogin.png" por el nombre real de tu imagen
		    private Image imagenFondo = new ImageIcon(getClass().getResource("/resources/Captura de pantalla 2026-05-13 123945.png")).getImage();

		    @Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        // Esto dibuja la imagen ocupando todo el tamaño del panel
		        if (imagenFondo != null) {
		            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
		        }
		    }
		};
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// --- LABEL USUARIO ---
				JLabel lblUsuario = new JLabel("Usuario:");
				lblUsuario.setForeground(Color.WHITE); // LETRA BLANCA
				lblUsuario.setFont(new Font("Arial", Font.BOLD, 18)); // Negrita para que se lea bien
				lblUsuario.setBounds(100, 117, 90, 21);
				contentPane.add(lblUsuario);

				// --- LABEL CONTRASEÑA ---
				JLabel lblContrasenia = new JLabel("Contraseña:");
				lblContrasenia.setForeground(Color.WHITE); // LETRA BLANCA
				lblContrasenia.setFont(new Font("Arial", Font.BOLD, 18)); // Negrita
				lblContrasenia.setBounds(70, 209, 120, 21);
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
		lblSesion.setForeground(Color.WHITE); // LETRA BLANCA
		lblSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblSesion.setFont(new Font("Verdana", Font.BOLD, 26)); // Negrita y un poco más grande
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
					Usuario usuarioEncontrado = MongoDBColecciones.getInstance().getUsuarioPorUsuarioNombre(usuarionombre);
					if (usuarioEncontrado != null) {
						if (txtContrasenia.getText().trim().equals(usuarioEncontrado.getContraseña())) {
							dispose();
							JPanelFondo panelFondo = new JPanelFondo(usuarioEncontrado);
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
