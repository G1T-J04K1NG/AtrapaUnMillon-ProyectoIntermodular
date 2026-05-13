package interfaces;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import mongo.MongoDBColecciones;

public class JPanelEntreRondas extends JPanel {

	private static final long serialVersionUID = 1L;

	public JPanelEntreRondas() {
		setLayout(null);
		setBounds(359, 60, 500, 320);

	}

	public void acierto() {
		removeAll();
		Image img = new ImageIcon(getClass().getResource("/resources/ImagenPanelAvanzar.png"))
                .getImage()
                .getScaledInstance(500, 320, Image.SCALE_SMOOTH);
		JLabel lblFondo = new JLabel(new ImageIcon(img));
		lblFondo.setBounds(0, 0, 500, 320); //poner a tamaño de panel
		add(lblFondo);
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanelFondo p = (JPanelFondo) getParent();

				setVisible(false);
				p.getpPregunta().getPartida().setRonda(p.getpPregunta().getPartida().getRonda() + 1);
				p.getpPregunta().recargarPanelPreguntas();
				p.getpPregunta().habilitarBotones();
			}
		});
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSiguiente.setBounds(175, 200, 150, 40);
		add(btnSiguiente);

		ArrayList<String> frases = new ArrayList<>(List.of("Eres la cabra", "¡Acertaste!", "Le sabes",
				"Simplemente cine", "Basado", "Directo al ángulo", "Imposible fallar contigo",
				"Totalmente de acuerdo, genio", "¡Pura magia!", "Lo has clavado", "Demasiado nivel para este programa",
				"¡Vaya lectura de juego!", "Eres el elegido", "Eres demasiado bueno"));
		JLabel lblHacertasteLaPregunta = new JLabel(frases.get((int) (Math.random() * frases.size())));
		lblHacertasteLaPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		lblHacertasteLaPregunta.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		lblHacertasteLaPregunta.setBounds(21, 22, 469, 153);
		add(lblHacertasteLaPregunta);

	}

	public void fallo() {
		removeAll();
		Image img = new ImageIcon(getClass().getResource("/resources/ImagenPanelFallo.png"))
                .getImage()
                .getScaledInstance(500, 320, Image.SCALE_SMOOTH);
		JLabel lblFondo = new JLabel(new ImageIcon(img));
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JPanelFondo p = (JPanelFondo) getParent();
				setVisible(false);
				p.getpPregunta().setVisible(false);
				p.getpMenu().setVisible(true);
				p.setComponentZOrder(p.getpMenu(), 0);
				p.revalidate();
				p.repaint();
				
				
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSalir.setBounds(175, 200, 150, 40);
		add(btnSalir);

		ArrayList<String> frases = new ArrayList<>(List.of("Anda que no eres malo eh", "¿En serio no has acertado eso?",
				"Hasta un reloj parado acierta dos veces al día", "No me lo creo, eres peor que Vinicius",
				"Tampoco era para tanto la pregunta", "Vaya, te has lucido campeón", "Eso lo sabe hasta mi abuela",
				"Buf, por los pelos ¿no?", "Menudo crack de pacotilla", "Hasta tú puedes con esto"));
		JLabel lblFallasteLaPregunta = new JLabel(frases.get((int) (Math.random() * frases.size())));
		lblFallasteLaPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		lblFallasteLaPregunta.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		lblFallasteLaPregunta.setBounds(21, 22, 469, 153);
		add(lblFallasteLaPregunta);

	}

	public void plantarse() {
		removeAll();
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanelFondo p = (JPanelFondo) getParent();

				setVisible(false);
				p.getpPregunta().getPartida().setRonda(p.getpPregunta().getPartida().getRonda() + 1);
				p.getpPregunta().recargarPanelPreguntas();
				p.getpPregunta().habilitarBotones();
			}
		});
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSiguiente.setBounds(75, 200, 150, 40);
		add(btnSiguiente);

		ArrayList<String> frases = new ArrayList<>(List.of("Eres la cabra", "¡Acertaste!", "Le sabes",
				"Simplemente cine", "Basado", "Directo al ángulo", "Imposible fallar contigo",
				"Totalmente de acuerdo, genio", "¡Pura magia!", "Lo has clavado", "Demasiado nivel para este programa",
				"¡Vaya lectura de juego!", "Eres el elegido", "Eres demasiado bueno"));
		JLabel lblHacertasteLaPregunta = new JLabel(frases.get((int) (Math.random() * frases.size())));
		lblHacertasteLaPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		lblHacertasteLaPregunta.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		lblHacertasteLaPregunta.setBounds(21, 22, 469, 153);
		add(lblHacertasteLaPregunta);
		
		
		JButton btnPlantarse = new JButton("Plantarse");
		btnPlantarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanelFondo p = (JPanelFondo) getParent();
				
				setVisible(false);
				p.getpPregunta().setVisible(false);
				p.getpMenu().setVisible(true);
				p.setComponentZOrder(p.getpMenu(), 0);
				p.revalidate();
				p.repaint();
				
				
				p.getUsuario().setDineroUsuario(p.getUsuario().getDineroUsuario() + p.getpPregunta().getPartida().getDinero());
				MongoDBColecciones.getInstance().cambiarDineroUsuario(p.getUsuario());
				System.out.println(p.getUsuario().getDineroUsuario());
				if (p.getpPregunta().getPartida().getDinero() > p.getUsuario().getDineroMejorPartida()) {
				MongoDBColecciones.getInstance().cambiarDineroMejorPartida(p.getUsuario(), p.getpPregunta().getPartida().getDinero());
			}
				p.getpInformacion().setUsuario(p.getUsuario());
				p.getpInformacion().setearEtiquetas();
			}
		});
		btnPlantarse.setBounds(275, 200, 150, 40);
		btnPlantarse.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPlantarse.setBounds(275, 200, 150, 40);
		add(btnPlantarse);
		
		
		
	}
	
	
	public void ganaste() {
		removeAll();
		
		Image img = new ImageIcon(getClass().getResource("/resources/ImagenPanelFinal.png"))
                .getImage()
                .getScaledInstance(500, 320, Image.SCALE_SMOOTH);
		JLabel lblFondo = new JLabel(new ImageIcon(img));
		lblFondo.setBounds(0, 0, 500, 320); //poner a tamaño de panel
		add(lblFondo);
		
		JButton btnVolver = new JButton("Salir");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JPanelFondo p = (JPanelFondo) getParent();
				setVisible(false);
				p.getpPregunta().setVisible(false);
				p.getpMenu().setVisible(true);
				p.setComponentZOrder(p.getpMenu(), 0);
				p.revalidate();
				p.repaint();
				
				
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnVolver.setBounds(175, 200, 150, 40);
		add(btnVolver);;
		
		JButton btnPlantarse = new JButton("Plantarse");
		btnPlantarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanelFondo p = (JPanelFondo) getParent();
				
				setVisible(false);
				p.getpPregunta().setVisible(false);
				p.getpMenu().setVisible(true);
				p.setComponentZOrder(p.getpMenu(), 0);
				p.revalidate();
				p.repaint();
				
				
				p.getUsuario().setDineroUsuario(p.getUsuario().getDineroUsuario() + p.getpPregunta().getPartida().getDinero());
				MongoDBColecciones.getInstance().cambiarDineroUsuario(p.getUsuario());
				System.out.println(p.getUsuario().getDineroUsuario());
				if (p.getpPregunta().getPartida().getDinero() > p.getUsuario().getDineroMejorPartida()) {
				MongoDBColecciones.getInstance().cambiarDineroMejorPartida(p.getUsuario(), p.getpPregunta().getPartida().getDinero());
			}
				p.getpInformacion().setUsuario(p.getUsuario());
				p.getpInformacion().setearEtiquetas();
			}
		});
		btnPlantarse.setBounds(275, 200, 150, 40);
		btnPlantarse.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPlantarse.setBounds(275, 200, 150, 40);
		add(btnPlantarse);
		
		
		
	}
	
	public void volverMenu() {
		JPanelFondo p = (JPanelFondo) getParent();
		setVisible(false);
		p.getpPregunta().setVisible(false);
		p.getpMenu().setVisible(true);
		p.setComponentZOrder(p.getpMenu(), 0);
		p.revalidate();
		p.repaint();
		
	}
}
