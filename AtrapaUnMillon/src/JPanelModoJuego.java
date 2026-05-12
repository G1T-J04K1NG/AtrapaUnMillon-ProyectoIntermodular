import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelModoJuego extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblModoJuego;
	private JButton btnModoNormal;
	private JButton btnModoInfinito;

	
	public JPanelModoJuego() {
		setBackground(Color.DARK_GRAY);
		setOpaque(true);
		setLayout(null);
		setBounds(300,200,600,400);
		
		lblModoJuego = new JLabel("Escoge un Modo de Juego");
		lblModoJuego.setHorizontalAlignment(SwingConstants.CENTER);
		lblModoJuego.setForeground(Color.WHITE);
		lblModoJuego.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblModoJuego.setBounds(115, 48, 370, 65);
		add(lblModoJuego);
		
		btnModoNormal = new JButton("Normal");
		
		btnModoNormal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnModoNormal.setBounds(75, 220, 180, 120);
		add(btnModoNormal);
		
		
		
		btnModoInfinito = new JButton("Infinito");
		btnModoInfinito.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnModoInfinito.setBounds(345, 220, 180, 120);
		add(btnModoInfinito);
		
		
	}
}
