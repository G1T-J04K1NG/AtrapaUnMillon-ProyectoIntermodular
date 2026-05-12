package mongo;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import model.Usuario;

public class MongoDBColecciones {
	// Conexión a la BDD
	static String url = "mongodb+srv://joaest22_db_user:"
			+ "UnjWo1ilrimUXFVL@atrapa1millon.dli87oo.mongodb.net/?appName=Atrapa1Millon";
	static MongoClient mongoClient = MongoClients.create(url);
	static MongoDatabase database = mongoClient.getDatabase("atrapa1millon");
	private static MongoCollection<Document> collectionUsuarios = database.getCollection("usuarios");
	private static MongoCollection<Document> collectionPreguntas = database.getCollection("preguntas");

	public static ArrayList<Usuario> getUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		FindIterable<Document> usuariosDocumentos = collectionUsuarios.find();
		for (Document usuario : usuariosDocumentos) {
			usuarios.add(documentoCastUsuario(usuario));
		}
		return usuarios;
	}
	
	public static void añadirDocumentoUsuario(Usuario usuario) {
		collectionUsuarios.insertOne(usuarioCastDocumento(usuario));
		
		collectionUsuarios = database.getCollection("usuarios");
	}

	public static Usuario getUsuarioPorUsuarioNombre(String usuarioNombre) {
		Document documento = collectionUsuarios.find(Filters.eq("usuario", usuarioNombre)).first();
		if (documento != null) {

			return documentoCastUsuario(documento);
		}
			return null;
		
	}

	public static Usuario documentoCastUsuario(Document documento) {
		Usuario usuarioCast = new Usuario();
		usuarioCast.setNombre(documento.getString("usuario"));
		usuarioCast.setContraseña(documento.getString("contraseña"));
		usuarioCast.setDineroMejorPartida(documento.getInteger("dineroMejorPartida"));
		usuarioCast.setDineroUsuario(documento.getInteger("dineroUsuario"));
		return usuarioCast;
	}
	
	public static Document usuarioCastDocumento(Usuario usuario) {
		Document documentoCast = new Document("usuario",usuario.getNombre())
				.append("contraseña",usuario.getContraseña())
				.append("dineroUsuario", usuario.getDineroUsuario())
				.append("dineroMejorPartida", usuario.getDineroMejorPartida());
		return documentoCast;
	}
	
	
	public static boolean comprobarExistenciaUsuario(String usuario) {
		boolean existe =false;
		FindIterable<Document> usuarios = collectionUsuarios.find();
		for (Document user : usuarios) {
			if(user.getString("usuario").equals(usuario)) {
				existe = true;
			}
		}
		return existe;
	}

	public static MongoCollection<Document> getCollectionUsuarios() {
		return collectionUsuarios;
	}

	public static void setCollectionUsuarios(MongoCollection<Document> collectionUsuarios) {
		MongoDBColecciones.collectionUsuarios = collectionUsuarios;
	}

	public static MongoCollection<Document> getCollectionPreguntas() {
		return collectionPreguntas;
	}

	public static void setCollectionPreguntas(MongoCollection<Document> collectionPreguntas) {
		MongoDBColecciones.collectionPreguntas = collectionPreguntas;
	}
	
	
	
}
