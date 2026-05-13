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

import model.Partida;
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
	private Partida partida;

	private ArrayList<Pregunta> preguntas;

	private JButtonRedondo buttonMago;
	private JButtonRedondo buttonPublico;
	private JButtonRedondo buttonCambiarPregunta;
	private JButtonRedondo buttonSalvavidas;

	public JPanelPregunta(Partida partida) {
		this.partida = partida;
		setLayout(null);
		setBounds(0, 30, 1200, 770);
		setOpaque(true);
		crearBotonesdelPanel();
		cogerPreguntas();

	}

	private void crearBotonesdelPanel() {

		lblDinero = new JLabel("Saldo: " + partida.getDinero() + " €");
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
		buttonCambiarPregunta.setBackground(Color.GREEN);

		buttonCambiarPregunta.setBounds(90, 83, 60, 60);
		add(buttonCambiarPregunta);

		buttonSalvavidas = new JButtonRedondo((String) null);
		buttonSalvavidas.setIcon(null);
		buttonSalvavidas.setBackground(Color.GREEN);
		buttonSalvavidas.setBounds(12, 12, 60, 60);
		add(buttonSalvavidas);

		// --- BOTÓN VOLVER AL MENÚ PANTALLA GENERAL ---
		btnVolverMenu = new JButton("Volver al Menú");
		btnVolverMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JPanelFondo p = (JPanelFondo) getParent();
					p.getpPregunta().setVisible(false);
					p.getpMenu().setVisible(true);
					p.setComponentZOrder(p.getpMenu(), 0);
					p.revalidate();
					p.repaint();

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

	}

	private void comprobarRespuesta(String textoBoton) {
		String respuestaLimpia = textoBoton.substring(3);

		if (respuestaLimpia.equals(preguntaActual.getRespuestaCorrecta())) {

			int dineroNuevo = partida.getDinero() + 1000;
			partida.setDinero(dineroNuevo);
			lblDinero.setText("Saldo: " + partida.getDinero() + " €");

		} else {

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

	private void cogerPreguntas() {

		if (partida.isModoJuego()) {
			preguntas = MongoDBColecciones.getInstance().getPreguntasNormal();

		} else {
			preguntas = MongoDBColecciones.getInstance().getPreguntasAleatorio();
		}
	}

	public void recargarPanelPreguntas() {

		preguntaActual = preguntas.remove(0);

		lblPregunta.setText(preguntaActual.getPregunta());
		lblPregunta.setForeground(Color.WHITE);

		ArrayList<String> opciones = new ArrayList<>(preguntaActual.getRespuestas());

		btnOpcionA.setText("A: " + opciones.get(0));
		
		btnOpcionA.setEnabled(true);
		btnOpcionB.setText("B: " + opciones.get(1));
		btnOpcionB.setEnabled(true);
		btnOpcionC.setText("C: " + opciones.get(2));
		btnOpcionC.setEnabled(true);
		btnOpcionD.setText("D: " + opciones.get(3));
		btnOpcionD.setEnabled(true);
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

}