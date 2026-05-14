package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import model.Partida;
import model.Pregunta;
import mongo.MongoDBColecciones;

public class JPanelPregunta extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image imagenFondo = new ImageIcon(getClass().getResource("/resources/Fondo JFrame Pregunta.png"))
			.getImage();
	private javax.sound.sampled.Clip clipActual;
	private JButton btnOpcionA, btnOpcionB, btnOpcionC, btnOpcionD;
	private JLabel lblPregunta, lblDinero;
	private Pregunta preguntaActual;
	private JButton btnSalir;
	private Partida partida;

	private ArrayList<Pregunta> preguntas;
	private boolean salvavidasUsado;
	private boolean publicoUsado;
	private boolean magoUsado;
	private boolean cambiarPreguntaUsado;
	private JButtonRedondo btnMago;
	private JButtonRedondo btnPublico;
	private JButtonRedondo btnCambiarPregunta;
	private JButtonRedondo btnSalvavidas;
	private ArrayList<String> opciones;

	public JPanelPregunta(Partida partida) {
		salvavidasUsado = false;
		magoUsado = false;
		publicoUsado = false;
		cambiarPreguntaUsado = false;
		this.partida = partida;
		setLayout(null);
		setBounds(0, 30, 1200, 770);
		setOpaque(true);

		crearBotonesdelPanel();
		cogerPreguntas();
		recargarPanelPreguntas();

	}

	private void crearBotonesdelPanel() {

		UIManager.put("ToolTip.background", new Color(30, 30, 30));
		UIManager.put("ToolTip.foreground", Color.YELLOW);
		UIManager.put("ToolTip.font", new Font("Tahoma", Font.BOLD, 14));
		UIManager.put("ToolTip.border", new LineBorder(Color.CYAN, 1));

		lblDinero = new JLabel();
		lblDinero.setForeground(Color.YELLOW);
		lblDinero.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblDinero.setBounds(30, 680, 300, 50);
		lblDinero.setText("Saldo: " + partida.getDinero() + " €");
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

		// COMODIN MAGO
		btnMago = new JButtonRedondo((String) null);
		btnMago.setForeground(Color.BLACK);
		btnMago.setBackground(Color.GREEN);
		btnMago.setIcon(new ImageIcon(JPanelPregunta.class.getResource("/resources/IconoMagoFinal.png")));
		btnMago.setBounds(90, 12, 60, 60);
		add(btnMago);
		btnMago.setFocusPainted(false);
		btnMago.setContentAreaFilled(false);
		btnMago.setBorderPainted(false);
		btnMago.setToolTipText("Mago: Muestra una opción durante 2 segundos, probablemente la correcta...");
		javax.swing.ToolTipManager.sharedInstance().registerComponent(btnMago);
		btnMago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!magoUsado) {
					magoUsado = true;
					btnMago.setBackground(Color.RED);
					btnMago.setContentAreaFilled(false);
					btnMago.setBorderPainted(false);
					btnMago.setFocusPainted(false);

					int probabilidad = (int) (Math.random() * 10);

					int indiceVisible;
					if (probabilidad < 7) {
						//
						indiceVisible = 0;

						for (int i = 0; i < opciones.size(); i++) {
							if (opciones.get(i).equals(preguntaActual.getRespuestaCorrecta())) {
								indiceVisible = i;
								break;
							}
						}
					} else {

						indiceVisible = (int) (Math.random() * 4);
					}

					if (indiceVisible != 0)
						btnOpcionA.setVisible(false);
					if (indiceVisible != 1)
						btnOpcionB.setVisible(false);
					if (indiceVisible != 2)
						btnOpcionC.setVisible(false);
					if (indiceVisible != 3)
						btnOpcionD.setVisible(false);

					btnMago.setEnabled(false);

					// Timer
					javax.swing.Timer timer = new javax.swing.Timer(2000, new ActionListener() {
						public void actionPerformed(ActionEvent e2) {
							btnOpcionA.setVisible(true);
							btnOpcionB.setVisible(true);
							btnOpcionC.setVisible(true);
							btnOpcionD.setVisible(true);
						}
					});
					timer.setRepeats(false);
					timer.start();
				}
			}
		});
		// COMODIN PUBLICO
		btnPublico = new JButtonRedondo((String) null);
		btnPublico.setBackground(Color.GREEN);
		btnPublico.setIcon(new ImageIcon(JPanelPregunta.class.getResource("/resources/IconoComodinPublico.png")));
		btnPublico.setBounds(12, 83, 60, 60);
		add(btnPublico);
		btnPublico.setFocusPainted(false);
		btnPublico.setContentAreaFilled(false);

		btnPublico.setBorderPainted(false);
		btnPublico.setToolTipText("Público: Elimina dos respuestas incorrectas");
		javax.swing.ToolTipManager.sharedInstance().registerComponent(btnPublico);
		btnPublico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!publicoUsado) {
					publicoUsado = true;
					JButton[] opciones = { btnOpcionA, btnOpcionB, btnOpcionC, btnOpcionD };
					btnPublico.setBackground(Color.RED);
					ArrayList<JButton> incorrectas = new ArrayList<>();

					for (JButton boton : opciones) {
						String textosinprefijo = boton.getText().substring(3);
						if (!textosinprefijo.trim().equalsIgnoreCase(preguntaActual.getRespuestaCorrecta().trim())) {

							incorrectas.add(boton);
						}
					}

					Collections.shuffle(incorrectas);
					incorrectas.get(0).setVisible(false);
					incorrectas.get(1).setVisible(false);

					btnPublico.setEnabled(false);
				}
			}
		});

		// COMODIN CAMBIAR PREGUNTA
		btnCambiarPregunta = new JButtonRedondo((String) null);
		btnCambiarPregunta
				.setIcon(new ImageIcon(JPanelPregunta.class.getResource("/resources/ImagenComodinNuevaPregunta.png")));
		btnCambiarPregunta.setBackground(Color.GREEN);
		btnCambiarPregunta.setBounds(90, 83, 60, 60);
		add(btnCambiarPregunta);

		btnCambiarPregunta.setToolTipText("Cambiar pregunta: Sustituye la pregunta actual por otra");
		javax.swing.ToolTipManager.sharedInstance().registerComponent(btnCambiarPregunta);
		btnCambiarPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!cambiarPreguntaUsado) {
					cambiarPreguntaUsado = true;
					btnCambiarPregunta.setEnabled(false);
					btnCambiarPregunta.setEnabled(false);
					btnCambiarPregunta.setBackground(Color.RED);
					btnCambiarPregunta.setContentAreaFilled(false);
					btnCambiarPregunta.setBorderPainted(false);
					btnCambiarPregunta.setFocusPainted(false);

					preguntas.remove(preguntaActual);
					if (preguntas.isEmpty()) {
						cogerPreguntas();
					}
					Collections.shuffle(preguntas);
					recargarPanelPreguntas();
				}
			}
		});
		btnCambiarPregunta
				.setIcon(new ImageIcon(JPanelPregunta.class.getResource("/resources/ImagenComodinNuevaPregunta.png")));
		btnCambiarPregunta.setBackground(Color.GREEN);

		// COMODIN SALVAVIDAS
		btnSalvavidas = new JButtonRedondo((String) null);
		btnSalvavidas.setIcon(new ImageIcon(JPanelPregunta.class.getResource("/resources/ImagenComodinSalvavida.png")));
		btnSalvavidas.setBackground(Color.GREEN);
		btnSalvavidas.setBounds(12, 12, 60, 60);
		btnSalvavidas.setFocusPainted(false);
		btnSalvavidas.setContentAreaFilled(false);
		btnSalvavidas.setBorderPainted(false);
		add(btnSalvavidas);
		btnSalvavidas.setToolTipText("Salvavidas: Revela la respuesta correcta");
		javax.swing.ToolTipManager.sharedInstance().registerComponent(btnSalvavidas);

		btnSalvavidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!salvavidasUsado) {

					salvavidasUsado = true;
					btnSalvavidas.setEnabled(false);
					btnSalvavidas.setBackground(Color.RED);
					btnSalvavidas.setContentAreaFilled(false);
					btnSalvavidas.setBorderPainted(false);
					btnSalvavidas.setFocusPainted(false);

					for (int i = 0; i < opciones.size(); i++) {
						if (opciones.get(i).equals(preguntaActual.getRespuestaCorrecta()))
							switch (i) {

							case 0:
								btnOpcionA.setBackground(Color.GREEN);
								break;

							case 1:
								btnOpcionB.setBackground(Color.GREEN);
								break;
							case 2:
								btnOpcionC.setBackground(Color.GREEN);
								break;
							case 3:
								btnOpcionD.setBackground(Color.GREEN);
								break;

							}

					}

				}

			}
		});

		// --- BOTÓN VOLVER AL MENÚ PANTALLA GENERAL ---
		btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(192, 192, 192));
		btnSalir.setForeground(new Color(0, 0, 0));
		btnSalir.addActionListener(new ActionListener() {
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
		btnSalir.setBounds(1053, 31, 100, 30);
		add(btnSalir);

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
		deshabilitarBotones();
		if (respuestaLimpia.equals(preguntaActual.getRespuestaCorrecta())) {
			switch (partida.getRonda()) {
			case 0, 1, 2, 3, 4:
				partida.setDinero(partida.getDinero() + 20000);
				break;
			case 5, 6, 7, 8, 9:
				partida.setDinero(partida.getDinero() + 60000);
				break;
			case 10, 11, 12, 13, 14:
				partida.setDinero(partida.getDinero() + 120000);
				break;
			}
			lblDinero.setText("Saldo: " + partida.getDinero() + " €");
			JPanelFondo p = (JPanelFondo) getParent();
			switch (partida.getRonda()) {
			case 4, 9, 12:
				p.getpEntreRondas().plantarse();
				break;
			case 14:
				p.getpEntreRondas().ganaste();
				break;
			default:
				p.getpEntreRondas().acierto();
				break;
			}

			p.setComponentZOrder(p.getpEntreRondas(), 0);
			p.revalidate();
			p.repaint();
			p.getpEntreRondas().setVisible(true);

		} else {
			JPanelFondo p = (JPanelFondo) getParent();
			p.getpEntreRondas().fallo();
			p.setComponentZOrder(p.getpEntreRondas(), 0);
			p.revalidate();
			p.repaint();
			p.getpEntreRondas().setVisible(true);

		}

	}

	private void estiloBoton(JButton btn) {
		btn.setUI(new javax.swing.plaf.basic.BasicButtonUI());
		btn.setBackground(new Color(0, 0, 0));
		btn.setForeground(new Color(255, 255, 255));
		btn.setOpaque(true);
		btn.setContentAreaFilled(true);
		btn.setBorder(new LineBorder(new Color(0, 255, 255), 2));
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
		btnSalvavidas.setEnabled(true);
		btnMago.setEnabled(true);
		btnPublico.setEnabled(true);
		btnCambiarPregunta.setEnabled(true);

		preguntaActual = preguntas.remove(0);
		estiloBoton(btnOpcionA);
		estiloBoton(btnOpcionB);
		estiloBoton(btnOpcionC);
		estiloBoton(btnOpcionD);

		lblPregunta.setText(preguntaActual.getPregunta());
		lblPregunta.setForeground(Color.WHITE);

		opciones = new ArrayList<>(preguntaActual.getRespuestas());

		btnOpcionA.setText("A: " + opciones.get(0));
		btnOpcionA.setEnabled(true);
		btnOpcionA.setVisible(true);
		btnOpcionB.setText("B: " + opciones.get(1));
		btnOpcionB.setEnabled(true);
		btnOpcionB.setVisible(true);
		btnOpcionC.setText("C: " + opciones.get(2));
		btnOpcionC.setEnabled(true);
		btnOpcionC.setVisible(true);
		btnOpcionD.setText("D: " + opciones.get(3));
		btnOpcionD.setEnabled(true);
		btnOpcionD.setVisible(true);
		btnSalir.setEnabled(true);
		repaint();
		revalidate();
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public void deshabilitarBotones() {

		btnSalvavidas.setEnabled(false);
		btnCambiarPregunta.setEnabled(false);
		btnMago.setEnabled(false);
		btnPublico.setEnabled(false);

		btnOpcionA.setEnabled(false);
		btnOpcionB.setEnabled(false);
		btnOpcionC.setEnabled(false);
		btnOpcionD.setEnabled(false);
		btnSalir.setEnabled(false);

	}

	public void habilitarBotones() {
		btnSalvavidas.setEnabled(true);
		btnCambiarPregunta.setEnabled(true);
		btnMago.setEnabled(true);
		btnPublico.setEnabled(true);
		btnOpcionA.setEnabled(true);
		btnOpcionB.setEnabled(true);
		btnOpcionC.setEnabled(true);
		btnOpcionD.setEnabled(true);
		btnSalir.setEnabled(true);

	}
	
	


}