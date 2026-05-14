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
	private JPanelEntreRondas pEntreRondas;
	private Usuario usuario;
	private javax.sound.sampled.Clip clipActual;

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

		pPregunta = null;

		pRanking = new JPanelRanking();
		add(pRanking);
		pRanking.setVisible(false);

		pModo = new JPanelModoJuego();
		add(pModo);
		pModo.setVisible(false);
		
		pEntreRondas = new JPanelEntreRondas();
		add(pEntreRondas);
		pEntreRondas.setVisible(false);

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

	public void iniciarPartida(boolean modoJuego) {

		if (pPregunta != null) {
			remove(pPregunta);
		}

		pPregunta = new JPanelPregunta(new Partida(getUsuario(), modoJuego));
		pPregunta.setBounds(0, 30, 1200, 770);
		add(pPregunta);

		pMenu.setVisible(false);
		pModo.setVisible(false);
		pPregunta.setVisible(true);

		setComponentZOrder(pPregunta, 0);
		revalidate();
		repaint();
	}

	public JPanelEntreRondas getpEntreRondas() {
		return pEntreRondas;
	}

	public void setpEntreRondas(JPanelEntreRondas pEntreRondas) {
		this.pEntreRondas = pEntreRondas;
	}
	
	
	public void reproducirSonido(String ruta) {
		try {
			if (clipActual != null && clipActual.isRunning()) {
				clipActual.stop();
			}
			java.net.URL url = getClass().getResource(ruta);
			javax.sound.sampled.AudioInputStream audio = javax.sound.sampled.AudioSystem.getAudioInputStream(url);
			clipActual = javax.sound.sampled.AudioSystem.getClip();
			clipActual.open(audio);
			clipActual.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
