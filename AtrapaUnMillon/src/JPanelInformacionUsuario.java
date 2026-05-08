import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class JPanelInformacionUsuario extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public JPanelInformacionUsuario(Usuario usuario) {
		setLayout(null);
		setSize(1200, 30);

		JLabel lblUsuarioNombre = new JLabel("Usuario : " + usuario.getNombre());
		lblUsuarioNombre.setBounds(10, 0, 113, 30);
		add(lblUsuarioNombre);

		JButton btnInformacion = new JButton("");
		btnInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel instrucciones = new JPanelInstrucciones();

			}
		});
		btnInformacion
				.setIcon(new ImageIcon(JPanelInformacionUsuario.class.getResource("/resources/Proyecto nuevo.png")));
		btnInformacion.setBounds(896, 0, 184, 30);
		btnInformacion.setBorderPainted(false);
		btnInformacion.setContentAreaFilled(false);
		btnInformacion.setFocusPainted(false);
		btnInformacion.setOpaque(false);
		btnInformacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(btnInformacion);

	}
}
