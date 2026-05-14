package interfaces;

import java.awt.Color;
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

		JPanelFondo p = (JPanelFondo) getParent();
		JButton btnSiguiente = new JButton("Siguiente");
		int aleatorio = (int) (0 + Math.random() * 2);

		if (aleatorio == 1) {
			p.reproducirSonido("/resources/success.wav");
		} else {
			p.reproducirSonido("/resources/8-bit-win-sound.wav");
		}

		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				p.getpPregunta().getPartida().setRonda(p.getpPregunta().getPartida().getRonda() + 1);
				p.getpPregunta().getLblRonda().setText("Ronda : " + (p.getpPregunta().getPartida().getRonda() +1));
				p.getpPregunta().recargarPanelPreguntas();

			}
		});
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSiguiente.setBounds(200, 260, 100, 27);
		add(btnSiguiente);

		ArrayList<String> frases = new ArrayList<>(
				List.of("GOAT", "¡Exacto!", "Factorazos", "Cine", "Prime", "Clasificado", "En el ángulo", "Imposible",
						"Genio", "Magia", "Clavado", "Nivel Dios", "Lectura", "El Elegido", "Diferente"));
		JLabel lblHacertasteLaPregunta = new JLabel(frases.get((int) (Math.random() * frases.size())));
		lblHacertasteLaPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		lblHacertasteLaPregunta.setFont(new Font("Franklin Gothic Book", Font.BOLD, 24));
		lblHacertasteLaPregunta.setForeground(Color.WHITE);
		lblHacertasteLaPregunta.setBounds(21, 60, 469, 153);
		add(lblHacertasteLaPregunta);

		JLabel lblHasAcertado = new JLabel("Has superado la ronda " + (p.getpPregunta().getPartida().getRonda() + 1));
		lblHasAcertado.setHorizontalAlignment(SwingConstants.CENTER);
		lblHasAcertado.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		lblHasAcertado.setForeground(Color.WHITE);
		lblHasAcertado.setBounds(21, 100, 469, 153);
		add(lblHasAcertado);

		Image img = new ImageIcon(getClass().getResource("/resources/ImagenPanelAvanzar.png")).getImage()
				.getScaledInstance(500, 320, Image.SCALE_SMOOTH);
		JLabel lblFondo = new JLabel(new ImageIcon(img));
		lblFondo.setBounds(0, 0, 500, 320);
		add(lblFondo);

	}

	public void fallo() {
		removeAll();
		JPanelFondo p = (JPanelFondo) getParent();

		int aleatorio = (int) (0 + Math.random() * 2);

		if (aleatorio == 1) {
			p.reproducirSonido("/resources/sad-trumpet-audio.wav");
		} else {

			p.reproducirSonido("/resources/metal-pipe-clang.wav");
		}
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				p.getpPregunta().setVisible(false);
				p.getpMenu().setVisible(true);
				p.setComponentZOrder(p.getpMenu(), 0);
				p.revalidate();
				p.repaint();

			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSalir.setBounds(200, 260, 100, 27);
		add(btnSalir);

		ArrayList<String> frases = new ArrayList<>(
				List.of("Qué malo", "¿En serio?", "Ni de coña", "Lamentable", "Era fácil", "Menudo nivel", "De chiste",
						"Casi, pero no", "Paquete", "Espabila", "No das pie con bola", "Qué desastre"));
		JLabel lblFallasteLaPregunta = new JLabel(frases.get((int) (Math.random() * frases.size())));
		lblFallasteLaPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		lblFallasteLaPregunta.setFont(new Font("Franklin Gothic Book", Font.BOLD, 24));
		lblFallasteLaPregunta.setForeground(Color.WHITE);
		lblFallasteLaPregunta.setBounds(21, 60, 469, 153);
		add(lblFallasteLaPregunta);

		JLabel lblHasFallado = new JLabel("Has fallado en la ronda " + (p.getpPregunta().getPartida().getRonda() + 1));
		lblHasFallado.setHorizontalAlignment(SwingConstants.CENTER);
		lblHasFallado.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		lblHasFallado.setForeground(Color.WHITE);
		lblHasFallado.setBounds(21, 100, 469, 153);
		add(lblHasFallado);

		Image img = new ImageIcon(getClass().getResource("/resources/ImagenPanelFallo.png")).getImage()
				.getScaledInstance(500, 320, Image.SCALE_SMOOTH);
		JLabel lblFondo = new JLabel(new ImageIcon(img));
		lblFondo.setBounds(0, 0, 500, 320);
		add(lblFondo);

	}

	public void plantarse() {
		removeAll();

		JPanelFondo p = (JPanelFondo) getParent();
		p.reproducirSonido("/resources/dun_dun_dun.wav");
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				p.getpPregunta().getPartida().setRonda(p.getpPregunta().getPartida().getRonda() + 1);
				p.getpPregunta().getLblRonda().setText("Ronda : " + (p.getpPregunta().getPartida().getRonda() +1));
				p.getpPregunta().recargarPanelPreguntas();

			}
		});
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSiguiente.setBounds(200, 260, 100, 27);
		add(btnSiguiente);

		ArrayList<String> frases = new ArrayList<>(
				List.of("GOAT", "¡Exacto!", "Factorazos", "Cine", "Prime", "Clasificado", "En el ángulo", "Imposible",
						"Genio", "Magia", "Clavado", "Nivel Dios", "Lectura", "El Elegido", "Diferente"));
		JLabel lblHacertasteLaPregunta = new JLabel(frases.get((int) (Math.random() * frases.size())));
		lblHacertasteLaPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		lblHacertasteLaPregunta.setFont(new Font("Franklin Gothic Book", Font.BOLD, 24));
		lblHacertasteLaPregunta.setForeground(Color.WHITE);
		lblHacertasteLaPregunta.setBounds(21, 60, 469, 153);
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

				p.getUsuario().setDineroUsuario(
						p.getUsuario().getDineroUsuario() + p.getpPregunta().getPartida().getDinero());
				MongoDBColecciones.getInstance().cambiarDineroUsuario(p.getUsuario());

				if (p.getpPregunta().getPartida().getDinero() > p.getUsuario().getDineroMejorPartida()) {
					p.getUsuario().setDineroMejorPartida(p.getpPregunta().getPartida().getDinero());
					MongoDBColecciones.getInstance().cambiarDineroMejorPartida(p.getUsuario(),
							p.getpPregunta().getPartida().getDinero());
				}
				p.getpInformacion().setUsuario(p.getUsuario());
				p.getpInformacion().setearEtiquetas();
			}
		});
		btnPlantarse.setBounds(370, 30, 100, 27);
		btnPlantarse.setFont(new Font("Tahoma", Font.BOLD, 10));
		add(btnPlantarse);

		JLabel lblSuelo = new JLabel(
				"Has llegado al suelo de la ronda " + (p.getpPregunta().getPartida().getRonda() + 1));
		lblSuelo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuelo.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		lblSuelo.setForeground(Color.WHITE);
		lblSuelo.setBounds(21, 100, 469, 153);
		add(lblSuelo);

		Image img = new ImageIcon(getClass().getResource("/resources/ImagenPanelAvanzar.png")).getImage()
				.getScaledInstance(500, 320, Image.SCALE_SMOOTH);
		JLabel lblFondo = new JLabel(new ImageIcon(img));
		lblFondo.setBounds(0, 0, 500, 320);
		add(lblFondo);

	}

	public void ganaste() {
		removeAll();
		JPanelFondo p = (JPanelFondo) getParent();
		JButton btnRetirarse = new JButton("Retirarse");
		p.reproducirSonido("/resources/ff7_victory_QyN4ZfS.wav");
		btnRetirarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanelFondo p = (JPanelFondo) getParent();

				setVisible(false);
				p.getpPregunta().setVisible(false);
				p.getpMenu().setVisible(true);
				p.setComponentZOrder(p.getpMenu(), 0);
				p.revalidate();
				p.repaint();

				p.getUsuario().setDineroUsuario(
						p.getUsuario().getDineroUsuario() + p.getpPregunta().getPartida().getDinero());
				MongoDBColecciones.getInstance().cambiarDineroUsuario(p.getUsuario());
				System.out.println(p.getUsuario().getDineroUsuario());
				if (p.getpPregunta().getPartida().getDinero() > p.getUsuario().getDineroMejorPartida()) {
					p.getUsuario().setDineroMejorPartida(p.getpPregunta().getPartida().getDinero());
					MongoDBColecciones.getInstance().cambiarDineroMejorPartida(p.getUsuario(),
							p.getpPregunta().getPartida().getDinero());
				}
				p.getpInformacion().setUsuario(p.getUsuario());
				p.getpInformacion().setearEtiquetas();
			}
		});
		btnRetirarse.setBounds(200, 260, 100, 27);
		btnRetirarse.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnRetirarse.setBounds(200, 260, 100, 27);
		add(btnRetirarse);

		Image img = new ImageIcon(getClass().getResource("/resources/ImagenPanelFinal.png")).getImage()
				.getScaledInstance(500, 320, Image.SCALE_SMOOTH);
		JLabel lblFondo = new JLabel(new ImageIcon(img));
		lblFondo.setBounds(0, 0, 500, 320); // poner a tamaño de panel
		add(lblFondo);

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
