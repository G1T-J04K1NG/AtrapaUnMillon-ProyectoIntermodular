import javax.swing.JFrame;
import javax.swing.JPanel;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class JPanelFondo extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanelInformacionUsuario pInformacion;
	private JPanelMenuPrincipal pMenu;
	private JPanelPregunta pPregunta;
	private JPanelInstrucciones pInstrucciones;
	private JPanelRanking pRanking;
	private JPanelModoJuego pModo;
	private MongoCollection<Document> collectionPreguntas,	collectionUsuarios;

	public JPanelFondo(Usuario usuario, MongoCollection<Document> collectionUsuarios, MongoCollection<Document> collectionPreguntas ) {
		
		setLayout(null);
		setBounds(0, 0, 1200, 800);
		// JPanelInformación Arriba
		pInformacion = new JPanelInformacionUsuario(usuario);
		add(pInformacion);

		// JPanel Menu
		pMenu = new JPanelMenuPrincipal();
		add(pMenu);

		//
		pPregunta = new JPanelPregunta();
		add(pPregunta);
		pPregunta.setVisible(false);

		pInstrucciones = new JPanelInstrucciones();
		add(pInstrucciones);
		pInstrucciones.setVisible(false);

		pRanking = new JPanelRanking(collectionUsuarios);
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

	public JPanelInstrucciones getpInstrucciones() {
		return pInstrucciones;
	}

	public void setpInstrucciones(JPanelInstrucciones pInstrucciones) {
		this.pInstrucciones = pInstrucciones;
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

	public MongoCollection<Document> getCollectionPreguntas() {
		return collectionPreguntas;
	}

	public void setCollectionPreguntas(MongoCollection<Document> collectionPreguntas) {
		this.collectionPreguntas = collectionPreguntas;
	}

	public MongoCollection<Document> getCollectionUsuarios() {
		return collectionUsuarios;
	}

	public void setCollectionUsuarios(MongoCollection<Document> collectionUsuarios) {
		this.collectionUsuarios = collectionUsuarios;
	}

	
	
}
