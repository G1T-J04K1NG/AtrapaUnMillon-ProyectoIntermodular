package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import model.Partida;

public class JPanelModoJuego extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblModoJuego;
	private JButton btnModoNormal;
	private JButton btnModoAleatorio;
	private JButton btnVolver;

	public JPanelModoJuego() {
		setBackground(Color.DARK_GRAY);
		setOpaque(true);
		setLayout(null);
		setBounds(300, 200, 600, 400);

		JPanel panelImagen = new JPanel() {
			 Image imagenFondo = new ImageIcon(getClass().getResource("/resources/modoJuego.png")).getImage();
			
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				 if (imagenFondo != null) {
				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
				}
			}
		};
		
		panelImagen.setBounds(0, 0, 600, 400); 
		add(panelImagen);
		
		panelImagen.setLayout(null);
		
		btnModoNormal = new JButton("Normal");
		btnModoNormal.setBounds(100, 208, 151, 58);
		
		
		btnModoNormal.setOpaque(false);
		btnModoNormal.setContentAreaFilled(false); 
		btnModoNormal.setFocusPainted(false); 
		btnModoNormal.setBorder(new LineBorder(Color.WHITE, 3)); 
		btnModoNormal.setForeground(Color.WHITE); 
		
		panelImagen.add(btnModoNormal);
				
						btnModoNormal.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JPanelFondo p = (JPanelFondo) getParent();
								p.reproducirSonido("/resources/nochedecasino.wav");
								p.getpMenu().getBtnEmpezarPartida().setEnabled(true);
								p.getpMenu().getBtnRanking().setEnabled(true);
								p.iniciarPartida(true);
				
							}
						});
								btnModoNormal.setFont(new Font("Tahoma", Font.PLAIN, 20));
								
								btnModoAleatorio = new JButton("Aleatorio");
								btnModoAleatorio.setBounds(348, 208, 151, 58);
								
								
								btnModoAleatorio.setOpaque(false);
								btnModoAleatorio.setContentAreaFilled(false); 
								btnModoAleatorio.setFocusPainted(false); 
								btnModoAleatorio.setBorder(new LineBorder(Color.WHITE, 3)); 
								btnModoAleatorio.setForeground(Color.WHITE); 
								
								panelImagen.add(btnModoAleatorio);
								btnModoAleatorio.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										JPanelFondo p = (JPanelFondo) getParent();
										p.reproducirSonido("/resources/nochedecasino.wav");
										p.getpMenu().getBtnEmpezarPartida().setEnabled(true);
										p.getpMenu().getBtnRanking().setEnabled(true);
										p.iniciarPartida(false);

									}
								});
								btnModoAleatorio.setFont(new Font("Tahoma", Font.PLAIN, 20));
								
										btnVolver = new JButton("Volver");
										btnVolver.setBounds(240, 290, 120, 40);
										panelImagen.add(btnVolver);
										btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 20));
										btnVolver.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												JPanelFondo p = (JPanelFondo) getParent();
												setVisible(false);
												p.getpMenu().getBtnEmpezarPartida().setEnabled(true);
												p.getpMenu().getBtnRanking().setEnabled(true);

											}
										});
										
			
		btnVolver.setOpaque(false);
		btnVolver.setContentAreaFilled(false); 
		btnVolver.setFocusPainted(false); 
		btnVolver.setBorder(new LineBorder(Color.WHITE, 2)); 
		btnVolver.setForeground(Color.WHITE);
	}
}
