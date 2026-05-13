package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import model.Usuario;

public class JPanelInformacionUsuario extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public JPanelInformacionUsuario(Usuario usuario) {
		setLayout(null);
		setBounds(0, 0, 1200, 30);

		JLabel lblUsuarioNombre = new JLabel("Usuario : " + usuario.getNombre());
		lblUsuarioNombre.setBounds(10, 0, 113, 30);
		add(lblUsuarioNombre);

		JButton btnInformacion = new JButton("");
		btnInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(JPanelInformacionUsuario.this);
				new JDialogInstrucciones(frame).setVisible(true);
			}

		});

		btnInformacion
				.setIcon(new ImageIcon(JPanelInformacionUsuario.class.getResource("/resources/Proyecto nuevo.png")));
		btnInformacion.setBounds(1101, 0, 99, 30);
		btnInformacion.setBorderPainted(false);
		btnInformacion.setContentAreaFilled(false);
		btnInformacion.setFocusPainted(false);
		btnInformacion.setOpaque(false);
		btnInformacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnInformacion);

		JLabel lblDinero = new JLabel("Dinero : " + usuario.getDineroUsuario() + " $$");
		lblDinero.setBounds(157, 0, 113, 30);
		add(lblDinero);

		JLabel lblMejorPartida = new JLabel("Mejor partida : " + usuario.getDineroMejorPartida());
		lblMejorPartida.setBounds(289, 0, 211, 30);
		add(lblMejorPartida);

	}
}