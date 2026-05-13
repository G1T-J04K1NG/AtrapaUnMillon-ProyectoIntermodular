package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import model.Partida;
import model.Usuario;

public class JPanelFondo extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanelInformacionUsuario pInformacion;
	private JPanelMenuPrincipal pMenu;
	private JPanelPregunta pPregunta;
	private JPanelRanking pRanking;
	private JPanelModoJuego pModo;
	private Usuario usuario;

	public JPanelFondo(Usuario usuario) {
		this.usuario = usuario;
		setLayout(null);
		setBounds(0, 0, 1200, 800);
		// JPanelInformación Arriba
		pInformacion = new JPanelInformacionUsuario(usuario);
		add(pInformacion);

		// JPanel Menu
		pMenu = new JPanelMenuPrincipal();
		add(pMenu);

		
		pPregunta = new JPanelPregunta(new Partida (usuario,true));
		add(pPregunta);
		pPregunta.setVisible(false);

		pRanking = new JPanelRanking();
		add(pRanking);
		pRanking.setVisible(false);

		pModo = new JPanelModoJuego();
		add(pModo);
		pModo.setVisible(false);

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

	public JPanelRanking getpRanking() {
		return pRanking;
	}

	public void setpRanking(JPanelRanking pRanking) {
		this.pRanking = pRanking;
	}

	public JPanelModoJuego getpModo() {
		return pModo;
	}

	public void setpModo(JPanelModoJuego pModo) {
		this.pModo = pModo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

}
