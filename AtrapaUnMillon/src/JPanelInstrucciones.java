import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Font;

public class JPanelInstrucciones extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public JPanelInstrucciones() {
		setBackground(SystemColor.info);
		setLayout(null);

		textField = new JTextField();
		add(textField);
		textField.setColumns(10);

		JTextArea txtrbienvenidoAlJuego = new JTextArea();
		txtrbienvenidoAlJuego.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 16));
		txtrbienvenidoAlJuego.setToolTipText("");
		txtrbienvenidoAlJuego.setBackground(SystemColor.info);

		txtrbienvenidoAlJuego.setLineWrap(true);
		txtrbienvenidoAlJuego.setWrapStyleWord(true);
		txtrbienvenidoAlJuego.setText("\"Bienvenido al juego de Atrapa un Millón\"" + " FUNCIONAMIENTO : \n"
				+ "1.El usuario tendrá que ir contestando correctamente las preguntas lanzadas por nuestro presentador. \n"
				+ "2.El usuario contará con la ayuda de los comodines especiales \n"
				+ "3.El jugador tendrá la opción de retirarse y llevarse el dinero acumulado en las rondas 5 y 10. \n"
				+ "4.A partir de la ronda 12 el jugador podrá retirarse en cualquier momento. \n"
				+ "Mucha suerte y ATRAPA EL MILLÓN!!!!!");
		txtrbienvenidoAlJuego.setBounds(22, 22, 407, 267);
		add(txtrbienvenidoAlJuego);

	}
}
