import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class PrincipalApp {
	public static void main (String [] args) {
		String url = "mongodb+srv://joaest22_db_user:"
				+ " UnjWo1ilrimUXFVL@atrapa1millon.dli87oo.mongodb.net/?appName=Atrapa1Millon";
		 try  {       	
	        	MongoClient mongoClient = MongoClients.create(url);
	            
	        	// Base de datos y colecci�n
	            MongoDatabase database = mongoClient.getDatabase("atrapa1millon");
	            
	            

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
}
