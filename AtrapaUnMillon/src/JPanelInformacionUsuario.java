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

				JPanelFondo p = (JPanelFondo) getParent();
				p.getpMenu().setVisible(false);
				p.getpInstrucciones().setBounds(0, 0, p.getWidth(), p.getHeight());
				p.getpInstrucciones().setVisible(true);
				p.setBounds(0, 0, 1200, 700);

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

	}
}
