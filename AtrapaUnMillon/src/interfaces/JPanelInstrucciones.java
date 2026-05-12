package interfaces;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelInstrucciones extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnSalirInformacion;

	/**
	 * Create the panel.
	 */
	public JPanelInstrucciones() {
		setBackground(SystemColor.black);
		setLayout(null);

		JTextArea txtrbienvenidoAlJuego = new JTextArea();
		txtrbienvenidoAlJuego.setEditable(false);
		txtrbienvenidoAlJuego.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 16));
		txtrbienvenidoAlJuego.setToolTipText("");
		txtrbienvenidoAlJuego.setLineWrap(true);
		txtrbienvenidoAlJuego.setWrapStyleWord(true);
		txtrbienvenidoAlJuego.setText("\"Bienvenido al juego de Atrapa un Millón\"" + "\n FUNCIONAMIENTO : \n"
				+ "1.El usuario tendrá que ir contestando correctamente las preguntas lanzadas por nuestro presentador. \n"
				+ "2.El usuario contará con la ayuda de los comodines especiales \n"
				+ "3.El jugador tendrá la opción de retirarse y llevarse el dinero acumulado en las rondas 5 y 10. \n"
				+ "4.A partir de la ronda 12 el jugador podrá retirarse en cualquier momento. \n"
				+ "Mucha suerte y ATRAPA EL MILLÓN!!!!!");
		txtrbienvenidoAlJuego.setBounds(0, 32, 430, 278);
		txtrbienvenidoAlJuego.setOpaque(false);
		txtrbienvenidoAlJuego.setForeground(Color.white);
		add(txtrbienvenidoAlJuego);

		btnSalirInformacion = new JButton("VOLVER");
		btnSalirInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanelFondo p = (JPanelFondo) getParent();
				setVisible(false);
				p.getpMenu().setVisible(true);
				p.revalidate();
				p.repaint();
			}
		});
		btnSalirInformacion.setBounds(173, 253, 89, 23);
		add(btnSalirInformacion);
		setComponentZOrder(btnSalirInformacion, 0);

	}

}
