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
import javax.swing.JPasswordField;  // ← Añadido
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
	private JPasswordField txtContrasenia;  // ← Cambiado
	public JButton btnEntrar;
	public JLabel lblUsuario;

	public JFrameLogIn(JframeInterfaz frame) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrameLogIn.class.getResource("/resources/logo_atrapa_millon.png")));
		setTitle("Atrapa Un Millón: Inicio De Sesión");
		setBounds(350, 200, 650, 400);
		contentPane = new JPanel() {
		    private Image imagenFondo = new ImageIcon(getClass().getResource("/resources/registro.png")).getImage();

		    @Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        if (imagenFondo != null) {
		            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
		        }
		    }
		};
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(Color.WHITE); 
		lblUsuario.setFont(new Font("Arial", Font.BOLD, 18)); 
		lblUsuario.setBounds(100, 117, 90, 21);
		contentPane.add(lblUsuario);

		JLabel lblContrasenia = new JLabel("Contraseña:");
		lblContrasenia.setForeground(Color.WHITE); 
		lblContrasenia.setFont(new Font("Arial", Font.BOLD, 18)); 
		lblContrasenia.setBounds(70, 209, 120, 21);
		contentPane.add(lblContrasenia);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(193, 118, 220, 24);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtContrasenia = new JPasswordField();  // ← Cambiado
		txtContrasenia.setColumns(10);
		txtContrasenia.setBounds(193, 209, 220, 24);
		contentPane.add(txtContrasenia);

		JLabel lblSesion = new JLabel("Inicio de Sesión");
		lblSesion.setForeground(Color.WHITE); 
		lblSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblSesion.setFont(new Font("Verdana", Font.BOLD, 26)); 
		lblSesion.setBounds(155, 28, 290, 45);
		contentPane.add(lblSesion);

		JLabel lblfallo = new JLabel("");
		lblfallo.setHorizontalAlignment(SwingConstants.CENTER);
		lblfallo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblfallo.setForeground(Color.RED);
		lblfallo.setBounds(128, 265, 329, 21);
		contentPane.add(lblfallo);

		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String contrasenia = new String(txtContrasenia.getPassword());  // ← Cambiado

				if (!txtUsuario.getText().trim().isEmpty() && !contrasenia.trim().isEmpty()) {
					String usuarionombre = txtUsuario.getText();
					Usuario usuarioEncontrado = MongoDBColecciones.getInstance().getUsuarioPorUsuarioNombre(usuarionombre);
					if (usuarioEncontrado != null) {
						if (contrasenia.trim().equals(usuarioEncontrado.getContraseña())) {  // ← Cambiado
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
