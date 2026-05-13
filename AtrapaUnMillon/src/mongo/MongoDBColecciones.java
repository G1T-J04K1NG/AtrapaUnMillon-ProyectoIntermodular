package mongo;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
import org.bson.Document;
 
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
 
import model.Pregunta;
import model.Usuario;
 
public class MongoDBColecciones {
 
	private static MongoDBColecciones instancia;
 
	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> collectionUsuarios;
	private MongoCollection<Document> collectionPreguntas;
 
	// Constructor privado: inicializa la conexión y las colecciones
	private MongoDBColecciones() {
		try {
			String url = "mongodb+srv://joaest22_db_user:"
					+ "UnjWo1ilrimUXFVL@atrapa1millon.dli87oo.mongodb.net/?appName=Atrapa1Millon";
			this.mongoClient = MongoClients.create(url);
			this.database = mongoClient.getDatabase("atrapa1millon");
			this.collectionUsuarios = database.getCollection("usuarios");
			this.collectionPreguntas = database.getCollection("preguntas");
		} catch (Exception e) {
			throw new RuntimeException("Error al conectar con MongoDB: " + e.getMessage());
		}
	}
 
	// Punto de acceso global a la instancia única
	public static MongoDBColecciones getInstance() {
		if (instancia == null) {
			instancia = new MongoDBColecciones();
		}
		return instancia;
	}
 
	public ArrayList<Usuario> getUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		FindIterable<Document> usuariosDocumentos = collectionUsuarios.find();
		for (Document usuario : usuariosDocumentos) {
			usuarios.add(documentoCastUsuario(usuario));
		}
		return usuarios;
	}
 
	public void añadirDocumentoUsuario(Usuario usuario) {
		collectionUsuarios.insertOne(usuarioCastDocumento(usuario));
		collectionUsuarios = database.getCollection("usuarios");
	}
 
	public Usuario getUsuarioPorUsuarioNombre(String usuarioNombre) {
		Document documento = collectionUsuarios.find(Filters.eq("usuario", usuarioNombre)).first();
		if (documento != null) {
			return documentoCastUsuario(documento);
		}
		return null;
	}
 
	public Usuario documentoCastUsuario(Document documento) {
		Usuario usuarioCast = new Usuario();
		usuarioCast.setNombre(documento.getString("usuario"));
		usuarioCast.setContraseña(documento.getString("contraseña"));
		usuarioCast.setDineroMejorPartida(documento.getInteger("dineroMejorPartida"));
		usuarioCast.setDineroUsuario(documento.getInteger("dineroUsuario"));
		return usuarioCast;
	}
 
	public Document usuarioCastDocumento(Usuario usuario) {
		Document documentoCast = new Document("usuario", usuario.getNombre())
				.append("contraseña", usuario.getContraseña())
				.append("dineroUsuario", usuario.getDineroUsuario())
				.append("dineroMejorPartida", usuario.getDineroMejorPartida());
		return documentoCast;
	}
 
	public boolean comprobarExistenciaUsuario(String usuario) {
		boolean existe = false;
		FindIterable<Document> usuarios = collectionUsuarios.find();
		for (Document user : usuarios) {
			if (user.getString("usuario").equals(usuario)) {
				existe = true;
			}
		}
		return existe;
	}
 
	public MongoCollection<Document> getCollectionUsuarios() {
		return collectionUsuarios;
	}
 
	public void setCollectionUsuarios(MongoCollection<Document> collectionUsuarios) {
		this.collectionUsuarios = collectionUsuarios;
	}
 
	public MongoCollection<Document> getCollectionPreguntas() {
		return collectionPreguntas;
	}
 
	public void setCollectionPreguntas(MongoCollection<Document> collectionPreguntas) {
		this.collectionPreguntas = collectionPreguntas;
	}
 
	public ArrayList<Pregunta> getPreguntasNormal() {
		ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
		ArrayList<Pregunta> totalPreguntas = getPreguntas();
		for (int i = 0; i < 3; i++) {
			int preguntasSacadas = 0;
			do {
				int aux = (int) (Math.random() * totalPreguntas.size());
				if (totalPreguntas.get(aux).getDificultad() == i + 1) {
					preguntas.add(totalPreguntas.remove(aux));
					preguntasSacadas++;
				}
			} while (preguntasSacadas != 6);
		}
		
		return preguntas;
	}
 
	public ArrayList<Pregunta> getPreguntasAleatorio() {
		ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
		ArrayList<Pregunta> totalPreguntas = getPreguntas();
		
		for (int i = 0; i < 18; i++) {
			int aux = (int) (Math.random() * totalPreguntas.size());
			preguntas.add(totalPreguntas.remove(aux));
		}
		return preguntas;
	}
 
	public ArrayList<Pregunta> getPreguntas() {
		ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
		FindIterable<Document> preguntasDocumentos = collectionPreguntas.find();
		for (Document documento : preguntasDocumentos) {
			preguntas.add(documentoCastPregunta(documento));
		}
		return preguntas;
	}
 
	public Pregunta documentoCastPregunta(Document documento) {
		Pregunta preguntaCast = new Pregunta();
		preguntaCast.setPregunta(documento.getString("pregunta"));
		preguntaCast.setRespuestaCorrecta(documento.getString("respuestaCorrecta"));
		preguntaCast.setDificultad(documento.getInteger("dificultad"));
		preguntaCast.setRespuestas(new ArrayList<String>(List.of(documento.getString("respuesta1"),
				documento.getString("respuesta2"),
				documento.getString("respuesta3"),
				documento.getString("respuesta4"))));
		Collections.shuffle(preguntaCast.getRespuestas());
		return preguntaCast;
	}
	
	public void actualizarRanking() {
		instancia.setCollectionUsuarios(database.getCollection("usuarios"));
	}
	
	
}


