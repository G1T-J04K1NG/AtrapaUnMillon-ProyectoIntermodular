package interfaces;

import javax.swing.*;
import java.awt.*;

public class JDialogInstrucciones extends JDialog {

	public JDialogInstrucciones(JFrame parent) {
		super(parent, "Instrucciones", true);

		setSize(460, 340);
		setLocationRelativeTo(parent);
		setResizable(false);
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);

		JTextArea txtInstrucciones = new JTextArea();
		txtInstrucciones.setEditable(false);
		txtInstrucciones.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 16));
		txtInstrucciones.setLineWrap(true);
		txtInstrucciones.setWrapStyleWord(true);
		txtInstrucciones.setText("\"Bienvenido al juego de Atrapa un Millón\"" + "\n FUNCIONAMIENTO : \n"
				+ "1.El usuario tendrá que ir contestando correctamente a las 15 preguntas lanzadas por nuestro presentador. \n"
				+ "2.Falla supone perder el dinero acumulado y terminar la partida \n"
				+ "2.El usuario contará con la ayuda de los comodines especiales \n"
				+ "3.El jugador tendrá la opción de retirarse y llevarse el dinero acumulado en las rondas 5 y 10. \n"
				+ "4.A partir de la ronda 13 el jugado no podrá retirarse hasta que acierte la última pregunta. \n"
				+ "\n " + "\n " + "RECOMPENSAS por cada respuesta correcta: \n"
				+ "Rondas 1-5: El jugador sumará 20000 \n" + "Rondas 6-10: El jugador sumará 60000 \n"
				+ "Rondas 11-15 : El jugador sumará 120000 \n" + "Mucha suerte y ATRAPA EL MILLÓN!!!!!");
		txtInstrucciones.setOpaque(false);
		txtInstrucciones.setForeground(Color.WHITE);
		txtInstrucciones.setBounds(10, 10, 430, 240);
		getContentPane().add(txtInstrucciones);

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(180, 265, 89, 23);
		btnVolver.addActionListener(e -> dispose());
		getContentPane().add(btnVolver);
	}
}
