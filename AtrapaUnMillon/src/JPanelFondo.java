import javax.swing.JFrame;
import javax.swing.JPanel;

public class JPanelFondo extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanelInformacionUsuario pInformacion;
	private JPanelMenuPrincipal pMenu;
	private JPanelPregunta pPregunta;
	
	
	public JPanelFondo(Usuario usuario) {
		setLayout(null);
		setBounds(0,0,1200,800);
		//JPanelInformación Arriba
		 pInformacion= new JPanelInformacionUsuario(usuario);
		add(pInformacion);
		
		//JPanel Menu
		pMenu = new JPanelMenuPrincipal();
		add(pMenu); 
		
		//
		pPregunta = new JPanelPregunta();
		add(pPregunta);
		pPregunta.setVisible(false);
	}


	public JPanelInformacionUsuario getpInformacion() {
		return pInformacion;
	}


	public void setpInformacion(JPanelInformacionUsuario pInformacion) {
		this.pInformacion = pInformacion;
	}


	public JPanelMenuPrincipal getpMenu() {
		return pMenu;
	}


	public void setpMenu(JPanelMenuPrincipal pMenu) {
		this.pMenu = pMenu;
	}


	public JPanelPregunta getpPregunta() {
		return pPregunta;
	}


	public void setpPregunta(JPanelPregunta pPregunta) {
		this.pPregunta = pPregunta;
	}

	
	
	
}
