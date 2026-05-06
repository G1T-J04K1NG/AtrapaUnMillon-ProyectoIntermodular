import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;

public class JframeInterfaz extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public JframeInterfaz() {
		setFont(new Font("Guttman Frank", Font.BOLD, 13));
		setTitle("Atrapa Un MiIlón");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 15, 1200, 800);
		contentPanel = new JPanel();
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
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnIniciarSesion.setBounds(150, 470, 250, 150);
		contentPanel.add(btnIniciarSesion);
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(800, 470, 250, 150);
		contentPanel.add(btnNewButton);

	}
}
