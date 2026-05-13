package interfaces;

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
				p.getpMenu().setVisible(false);
				p.getpModo().setVisible(false);
				
				
				p.setpPregunta(new JPanelPregunta(new Partida(p.getUsuario(),true)));
				p.add(p.getpPregunta());
				p.getpPregunta().setVisible(true);
				p.getpPregunta().revalidate();
				p.repaint();
				
				
				
				

			}
		});
		btnModoNormal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnModoNormal.setBounds(75, 150, 180, 120);
		add(btnModoNormal);

		btnModoAleatorio = new JButton("Aleatorio");
		btnModoAleatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanelFondo p = (JPanelFondo) getParent();
				p.getpMenu().setVisible(false);
				p.getpMenu().getBtnEmpezarPartida().setEnabled(true);
				p.getpMenu().getBtnRanking().setEnabled(true);
				
				
				p.getpModo().setVisible(false);
				
				p.setpPregunta(new JPanelPregunta(new Partida(p.getUsuario(),false)));
				p.add(p.getpPregunta());
				p.getpPregunta().setVisible(true);
				p.getpPregunta().revalidate();
				p.repaint();
				
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
}
