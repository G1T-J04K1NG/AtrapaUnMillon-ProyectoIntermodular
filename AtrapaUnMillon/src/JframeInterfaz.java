import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JframeInterfaz extends JFrame {
	
	private MongoCollection<Document> collectionUsuarios;
	private MongoCollection<Document> collectionPreguntas;
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public JframeInterfaz(MongoCollection<Document> collectionUsuarios, MongoCollection<Document> collectionPreguntas) {
		setFont(new Font("Guttman Frank", Font.BOLD, 13));
		setTitle("Atrapa Un MiIlón");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 15, 1200, 800);
		contentPanel = new JPanelPregunta();
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblBienvenida = new JLabel("Esto es Atrapa Un Millón");
		lblBienvenida.setForeground(Color.WHITE);
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setFont(new Font("Verdana", Font.BOLD, 30));
		lblBienvenida.setBounds(335, 118, 530, 165);
		contentPanel.add(lblBienvenida);
		
		//Funcionalidad de btnIniciarSesion
		JButton btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							JFrameLogIn frameLogIn = new JFrameLogIn(collectionUsuarios);
							frameLogIn.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		//Formato de btnIniciarSesion
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnIniciarSesion.setBounds(150, 470, 250, 150);
		contentPanel.add(btnIniciarSesion);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnRegistrarse.setBounds(800, 470, 250, 150);
		contentPanel.add(btnRegistrarse);

	}
}
