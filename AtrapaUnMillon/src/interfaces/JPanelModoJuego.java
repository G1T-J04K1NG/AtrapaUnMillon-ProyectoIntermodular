/*package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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

		lblModoJuego = new JLabel("Escoge un Modo de Juego");
		lblModoJuego.setHorizontalAlignment(SwingConstants.CENTER);
		lblModoJuego.setForeground(Color.WHITE);
		lblModoJuego.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblModoJuego.setBounds(115, 48, 370, 65);
		add(lblModoJuego);

		btnModoNormal = new JButton("Normal");

		btnModoNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanelFondo p = (JPanelFondo) getParent();
				p.getpMenu().getBtnEmpezarPartida().setEnabled(true);
				p.getpMenu().getBtnRanking().setEnabled(true);
				p.iniciarPartida(true);

			}
		});
		btnModoNormal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnModoNormal.setBounds(75, 150, 180, 120);
		add(btnModoNormal);

		btnModoAleatorio = new JButton("Aleatorio");
		btnModoAleatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanelFondo p = (JPanelFondo) getParent();

				p.getpMenu().getBtnEmpezarPartida().setEnabled(true);
				p.getpMenu().getBtnRanking().setEnabled(true);
				p.iniciarPartida(true);

			}
		});
		btnModoAleatorio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnModoAleatorio.setBounds(345, 150, 180, 120);
		add(btnModoAleatorio);

		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanelFondo p = (JPanelFondo) getParent();
				setVisible(false);
				p.getpMenu().getBtnEmpezarPartida().setEnabled(true);
				p.getpMenu().getBtnRanking().setEnabled(true);

			}
		});
		btnVolver.setBounds(240, 315, 120, 40);
		add(btnVolver);

	}
}*/
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

		JPanel panelFondo = new JPanel() {
			 private Image imagenFondo = new ImageIcon(getClass().getResource("/resources/modoJuego.png")).getImage();
			
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				 if (imagenFondo != null) {
				g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
				}
			}
		};
		
		panelFondo.setBounds(0, 0, 600, 400); 
		add(panelFondo);
		
		setComponentZOrder(panelFondo, getComponentCount() - 1);
		panelFondo.setLayout(null);
		
		btnModoNormal = new JButton("Normal");
		btnModoNormal.setBounds(100, 208, 151, 58);
		
		
		btnModoNormal.setOpaque(false);
		btnModoNormal.setContentAreaFilled(false); 
		btnModoNormal.setFocusPainted(false); 
		btnModoNormal.setBorder(new LineBorder(Color.WHITE, 3)); 
		btnModoNormal.setForeground(Color.WHITE); 
		
		panelFondo.add(btnModoNormal);
				
						btnModoNormal.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JPanelFondo p = (JPanelFondo) getParent();
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
								
								panelFondo.add(btnModoAleatorio);
								btnModoAleatorio.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										JPanelFondo p = (JPanelFondo) getParent();

										p.getpMenu().getBtnEmpezarPartida().setEnabled(true);
										p.getpMenu().getBtnRanking().setEnabled(true);
										p.iniciarPartida(true);

									}
								});
								btnModoAleatorio.setFont(new Font("Tahoma", Font.PLAIN, 20));
								
										btnVolver = new JButton("Volver");
										btnVolver.setBounds(240, 290, 120, 40);
										panelFondo.add(btnVolver);
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
