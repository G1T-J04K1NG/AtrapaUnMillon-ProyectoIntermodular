package interfaces;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.bson.Document;

import model.Pregunta;
import model.Usuario;
import mongo.MongoDBColecciones;

public class JPanelPregunta extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image imagenFondo = new ImageIcon(getClass().getResource("/resources/Fondo JFrame Pregunta.png"))
			.getImage();

	private JButton btnOpcionA, btnOpcionB, btnOpcionC, btnOpcionD;
	private JLabel lblPregunta, lblDinero;
	private Pregunta preguntaActual;
	private JButton btnVolverMenu;

	private ArrayList<Pregunta> bancoPreguntas;
	private Usuario jugadorActual = new Usuario("Jugador1", "1234");

	private JButtonRedondo buttonMago;
	private JButtonRedondo buttonPublico;
	private JButtonRedondo buttonCambiarPregunta;
	private JButtonRedondo buttonSalvavidas;

	public JPanelPregunta() {
		setLayout(null);
		setBounds(0, 30, 1200, 770);
		setOpaque(true);
		
		lblDinero = new JLabel("Saldo: " + jugadorActual.getDineroUsuario() + " €");
		lblDinero.setForeground(Color.YELLOW);
		lblDinero.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblDinero.setBounds(30, 680, 300, 50);
		add(lblDinero);

		btnOpcionA = new JButton("");
		estiloBoton(btnOpcionA);
		btnOpcionA.setBounds(255, 419, 250, 40);
		btnOpcionA.addActionListener(e -> comprobarRespuesta(btnOpcionA.getText()));
		add(btnOpcionA);

		btnOpcionB = new JButton("");
		estiloBoton(btnOpcionB);
		btnOpcionB.setBounds(728, 421, 250, 40);
		btnOpcionB.addActionListener(e -> comprobarRespuesta(btnOpcionB.getText()));
		add(btnOpcionB);

		btnOpcionC = new JButton("");
		estiloBoton(btnOpcionC);
		btnOpcionC.setBounds(255, 679, 250, 40);
		btnOpcionC.addActionListener(e -> comprobarRespuesta(btnOpcionC.getText()));
		add(btnOpcionC);

		btnOpcionD = new JButton("");
		estiloBoton(btnOpcionD);
		btnOpcionD.setBounds(728, 679, 250, 40);
		btnOpcionD.addActionListener(e -> comprobarRespuesta(btnOpcionD.getText()));
		add(btnOpcionD);

		// --- LABEL PREGUNTA ---
		lblPregunta = new JLabel("CARGANDO PREGUNTA...");
		lblPregunta.setOpaque(true);
		lblPregunta.setBackground(new Color(50, 50, 50));
		lblPregunta.setForeground(Color.WHITE);
		lblPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		lblPregunta.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPregunta.setBounds(255, 518, 723, 60);
		lblPregunta.setBorder(new javax.swing.border.LineBorder(Color.CYAN, 1));
		add(lblPregunta);

		// --- BOTÓN VOLVER AL MENÚ ---
		btnVolverMenu = new JButton("Volver al Menú");
		btnVolverMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JPanelFondo p = (JPanelFondo) getParent();
					p.getpPregunta().setVisible(false);
					p.getpMenu().setVisible(true);
					p.revalidate();
					p.repaint();
					createPreguntas();
					p.setComponentZOrder(p.getpMenu(), 0);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnVolverMenu.setBounds(940, 24, 250, 40);
		add(btnVolverMenu);

		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				try {
					JPanelFondo p = (JPanelFondo) getParent();
					if (p != null && p.getpMenu() != null) {
						p.getpMenu().setVisible(false);
					}
				} catch (Exception ex) {

				}
			}
		});
		createPreguntas();

	}

	private void createPreguntas() {
		cargarBancoDePreguntas();

		buttonMago = new JButtonRedondo((String) null);
		buttonMago.setForeground(Color.BLACK);
		buttonMago.setBackground(Color.GREEN);
		buttonMago.setIcon(new ImageIcon(JPanelPregunta.class.getResource("/resources/IconoMagoFinal.png")));
		buttonMago.setBounds(90, 12, 60, 60);
		add(buttonMago);
		buttonMago.setFocusPainted(false);
		buttonMago.setContentAreaFilled(false);
		buttonMago.setBorderPainted(false);

		buttonPublico = new JButtonRedondo((String) null);
		buttonPublico.setBackground(Color.GREEN);
		buttonPublico.setIcon(new ImageIcon(JPanelPregunta.class.getResource("/resources/IconoComodinPublico.png")));
		buttonPublico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonPublico.setBounds(12, 83, 60, 60);
		add(buttonPublico);
		buttonPublico.setFocusPainted(false);
		buttonPublico.setContentAreaFilled(false);
		buttonPublico.setBorderPainted(false);

		buttonCambiarPregunta = new JButtonRedondo((String) null);

		buttonCambiarPregunta.setBounds(90, 83, 60, 60);
		add(buttonCambiarPregunta);

		buttonSalvavidas = new JButtonRedondo((String) null);
		buttonSalvavidas.setIcon(null);
		buttonSalvavidas.setBackground(Color.GREEN);
		buttonSalvavidas.setBounds(12, 12, 60, 60);
		add(buttonSalvavidas);

		rellenarPreguntas();
	}

	private void comprobarRespuesta(String textoBoton) {
		String respuestaLimpia = textoBoton.substring(3);

		if (respuestaLimpia.equals(preguntaActual.getRespuestaCorrecta())) {
			// --- ACERTÓ ---
			int dineroNuevo = jugadorActual.getDineroUsuario() + 1000;
			jugadorActual.setDineroUsuario(dineroNuevo);
			lblDinero.setText("Saldo: " + jugadorActual.getDineroUsuario() + " €");

			rellenarPreguntas();

		} else {
			// --- FALLÓ ---
			lblPregunta.setText("¡HAS FALLADO! Fin de la partida.");
			lblPregunta.setForeground(Color.RED);

			btnOpcionA.setEnabled(false);
			btnOpcionB.setEnabled(false);
			btnOpcionC.setEnabled(false);
			btnOpcionD.setEnabled(false);
		}
	}

	private void estiloBoton(JButton btn) {
		btn.setUI(new javax.swing.plaf.basic.BasicButtonUI());
		btn.setBackground(new Color(220, 220, 220));
		btn.setForeground(Color.BLACK);
		btn.setOpaque(true);
		btn.setContentAreaFilled(true);
		btn.setBorder(new LineBorder(Color.WHITE, 2));
		btn.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn.setFocusPainted(false);
		btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (imagenFondo != null) {
			g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
		}
	}

	private void cargarBancoDePreguntas() {
		bancoPreguntas = new ArrayList<>();
		bancoPreguntas.add(new Pregunta("¿Qué órgano del cuerpo humano bombea sangre?", "Corazón",
				new ArrayList<>(Arrays.asList("Pulmón", "Hígado", "Corazón", "Riñón")), 1));
		bancoPreguntas.add(new Pregunta("¿Cuál es la moneda oficial de España?", "Euro",
				new ArrayList<>(Arrays.asList("Peseta", "Dólar", "Euro", "Libra")), 1));

		Collections.shuffle(bancoPreguntas);
	}

	public void rellenarPreguntas() {
		if (bancoPreguntas.isEmpty()) {
			lblPregunta.setText("¡ENHORABUENA! HAS GANADO EL MILLÓN.");
			lblPregunta.setForeground(Color.GREEN);
			btnOpcionA.setEnabled(false);
			btnOpcionB.setEnabled(false);
			btnOpcionC.setEnabled(false);
			btnOpcionD.setEnabled(false);
			return;
		}

		preguntaActual = bancoPreguntas.remove(0);

		lblPregunta.setText(preguntaActual.getPregunta());
		lblPregunta.setForeground(Color.WHITE);

		ArrayList<String> opciones = new ArrayList<>(preguntaActual.getRespuestas());
		Collections.shuffle(opciones);

		btnOpcionA.setText("A: " + opciones.get(0));
		btnOpcionA.setEnabled(true);
		btnOpcionB.setText("B: " + opciones.get(1));
		btnOpcionB.setEnabled(true);
		btnOpcionC.setText("C: " + opciones.get(2));
		btnOpcionC.setEnabled(true);
		btnOpcionD.setText("D: " + opciones.get(3));
		btnOpcionD.setEnabled(true);
	}
}