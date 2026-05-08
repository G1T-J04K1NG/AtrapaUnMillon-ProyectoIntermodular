import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.awt.Color;

public class JPanelMenuPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public JPanelMenuPrincipal(Usuario usuario) {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		// Configuramos el panel
        setLayout(null);
        setSize(1200, 770);
        //boton Empezar Partida
        JButton btnEmpezarPartida = new JButton("Empezar Partida");
        btnEmpezarPartida.setContentAreaFilled(false);
        btnEmpezarPartida.setFocusPainted(true);
        btnEmpezarPartida.setForeground(new Color(255, 255, 0));
        btnEmpezarPartida.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnEmpezarPartida.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btnEmpezarPartida.setBounds(471, 665, 335, 81);
        add(btnEmpezarPartida);
        
        //boton Ranking
        JButton btnRanking = new JButton("Ranking");
        btnRanking.setContentAreaFilled(false);
        btnRanking.setFocusPainted(true);
        btnRanking.setForeground(new Color(255, 255, 0));
        btnRanking.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnRanking.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btnRanking.setBounds(40, 184, 168, 70);
        add(btnRanking);
        
        JLabel labelimagen = new JLabel("");
        labelimagen.setIcon(new ImageIcon(JPanelMenuPrincipal.class.getResource("/resources/ChatGPT Image 8 may 2026, 13_10_39.png")));
        labelimagen.setBounds(-138, 11, 1338, 770);
        add(labelimagen);
	}
}
