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

	public ArrayList<Usuario> getUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		FindIterable<Document> usuariosDocumentos = collectionUsuarios.find();
		for (Document usuario : usuariosDocumentos) {
			usuarios.add(new Usuario(usuario.getString("usuario"), usuario.getString("contraseña"),
					usuario.getInteger("dineroUsuario"), usuario.getInteger("dineroMejorPartida")));
		}
		return usuarios;
	}

	public static Usuario getUsuarioPorUsuarioNombre(String usuarioNombre) {
		Document documento = collectionUsuarios.find(Filters.eq("usuario", usuarioNombre)).first();
		if (documento != null) {

			return documentoCastUsuario(documento);
		}
			return null;
		
	}

	private static Usuario documentoCastUsuario(Document documento) {
		Usuario usuarioCast = new Usuario();
		usuarioCast.setNombre(documento.getString("usuario"));
		usuarioCast.setContraseña(documento.getString("contraseña"));
		usuarioCast.setDineroMejorPartida(documento.getInteger("dineroMejorPartida"));
		usuarioCast.setDineroUsuario(documento.getInteger("dineroUsuario"));
		return usuarioCast;
	}
}
