import java.awt.EventQueue;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MainApp {

	public static void main(String[] args) {
		try {
			// Conexión a la BDD
			String url = "mongodb+srv://joaest22_db_user:"
					+ "UnjWo1ilrimUXFVL@atrapa1millon.dli87oo.mongodb.net/?appName=Atrapa1Millon";
			MongoClient mongoClient = MongoClients.create(url);

			MongoDatabase database = mongoClient.getDatabase("atrapa1millon");
			MongoCollection<Document> collectionUsuarios = database.getCollection("usuarios");
			MongoCollection<Document> collectionPreguntas = database.getCollection("preguntas");

			// InciarJframeInterfaz

			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						JframeInterfaz frame = new JframeInterfaz(collectionUsuarios, collectionPreguntas);
						frame.setVisible(true);
						frame.setResizable(false); // Para que no se pueda redimensionar.
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
