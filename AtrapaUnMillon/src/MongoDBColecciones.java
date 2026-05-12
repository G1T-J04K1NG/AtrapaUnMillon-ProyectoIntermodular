import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBColecciones {
	//Conexión a la BDD
 	String url = "mongodb+srv://joaest22_db_user:"
 				+ "UnjWo1ilrimUXFVL@atrapa1millon.dli87oo.mongodb.net/?appName=Atrapa1Millon";
	MongoClient mongoClient = MongoClients.create(url);
    
	MongoDatabase database = mongoClient.getDatabase("atrapa1millon");
    MongoCollection<Document> collectionUsuarios = database.getCollection("usuarios");
    MongoCollection<Document> collectionPreguntas = database.getCollection("preguntas");
    
    public ArrayList<Usuario> getUsuarios() {
    	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    	FindIterable<Document> usuariosDocumentos = collectionUsuarios.find();
    	for (Document usuario : usuariosDocumentos) {
    		usuarios.add(new Usuario (usuario.getString("usuario"),
    				usuario.getString("contraseña"),
    				usuario.getInteger("dineroUsuario"),
    				usuario.getInteger("dineroMejorPartida")));
    	}
    	return usuarios;
    }
}
