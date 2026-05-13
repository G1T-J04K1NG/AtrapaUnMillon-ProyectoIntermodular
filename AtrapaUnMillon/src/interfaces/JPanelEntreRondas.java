package interfaces;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelEntreRondas extends JPanel {

	private static final long serialVersionUID = 1L;

	
	public JPanelEntreRondas() {
		setLayout(null);
		setBounds(359,60,500,320);
		acierto();
		
		
		
	}
	
	public void acierto() {
		removeAll();
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanelFondo p = (JPanelFondo)getParent();
				
				
				setVisible(false);
				p.getpPregunta().getPartida().setRonda(p.getpPregunta().getPartida().getRonda()+1);
				p.getpPregunta().recargarPanelPreguntas();
				
				
				
				
				
			}
		});
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSiguiente.setBounds(175, 200, 150, 40);
		add(btnSiguiente);
		
		ArrayList<String> frases = new ArrayList<>(List.of(
	            "Eres la cabra",
	            "¡Acertaste!",
	            "Le sabes",
	            "Simplemente cine",
	            "Basado",
	            "Directo al ángulo",
	            "Imposible fallar contigo",
	            "Totalmente de acuerdo, genio",
	            "¡Pura magia!",
	            "Lo has clavado",
	            "Demasiado nivel para este programa",
	            "¡Vaya lectura de juego!",
	            "Eres el elegido",
	            "Eres demasiado bueno"
	        ));
		JLabel lblHacertasteLaPregunta = new JLabel(frases.get((int)(Math.random()*frases.size())));
		lblHacertasteLaPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		lblHacertasteLaPregunta.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblHacertasteLaPregunta.setBounds(21, 22, 469, 153);
		add(lblHacertasteLaPregunta);
		
	}
}
