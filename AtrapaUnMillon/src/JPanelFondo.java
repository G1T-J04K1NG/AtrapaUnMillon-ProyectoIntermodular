import javax.swing.JPanel;

public class JPanelFondo extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public JPanelFondo(Usuario usuario) {
		setLayout(null);
		setBounds(0,0,1200,800);
		//JPanelInformación Arriba
		JPanelInformacionUsuario pInformacion= new JPanelInformacionUsuario(usuario);
		add(pInformacion);
		
		//JPanel Menu
		JPanelMenuPrincipal pMenu = new JPanelMenuPrincipal();
		add(pMenu);
	}

}
