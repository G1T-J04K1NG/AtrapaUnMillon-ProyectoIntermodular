package interfaces;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import mongo.MongoDBColecciones;

public class JPanelMenuPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	public JButton btnRanking;
	public JButton btnEmpezarPartida;
	private JLabel label;

	/**
	 * Create the panel.
	 */
	public JPanelMenuPrincipal() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		// Configuramos el panel

		setLayout(null);
		setBounds(0, 30, 1200, 770);

		// boton Empezar Partida
		btnEmpezarPartida = new JButton("Empezar Partida");
		btnEmpezarPartida.setContentAreaFilled(false);
		btnEmpezarPartida.setFocusPainted(true);
		btnEmpezarPartida.setForeground(new Color(255, 255, 0));
		btnEmpezarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanelFondo p = (JPanelFondo) getParent();
				p.getpModo().setVisible(true);
				p.setComponentZOrder(p.getpModo(), 0);
				p.repaint();
				btnEmpezarPartida.setEnabled(false);
				btnRanking.setEnabled(false);
			}
		});
		btnEmpezarPartida.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnEmpezarPartida.setBounds(431, 642, 336, 83);
		add(btnEmpezarPartida);

		// boton Ranking
		btnRanking = new JButton("Ranking");
		btnRanking.setContentAreaFilled(false);
		btnRanking.setFocusPainted(true);
		btnRanking.setForeground(new Color(255, 255, 0));
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JPanelFondo p = (JPanelFondo)getParent();
				MongoDBColecciones.getInstance().actualizarRanking();
				p.getpRanking().reiniciarSituacionInicial();
				p.getpRanking().setVisible(true);
			}
		});
		btnRanking.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnRanking.setBounds(40, 184, 168, 70);
		add(btnRanking);

		JLabel labelimagen = new JLabel("");
		labelimagen.setIcon(new ImageIcon(JPanelMenuPrincipal.class.getResource("/resources/FondoMenuPrincipal.png")));
		labelimagen.setBounds(-170, 0, 1500, 770);
		add(labelimagen);
		
		label = new JLabel("New label");
		label.setBounds(120, 458, 46, 14);
		add(label);

	}

	public JButton getBtnRanking() {
		return btnRanking;
	}

	public void setBtnRanking(JButton btnRanking) {
		this.btnRanking = btnRanking;
	}

	public JButton getBtnEmpezarPartida() {
		return btnEmpezarPartida;
	}

	public void setBtnEmpezarPartida(JButton btnEmpezarPartida) {
		this.btnEmpezarPartida = btnEmpezarPartida;
	}
	
	
}
