import java.awt.EventQueue;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import interfaces.JframeInterfaz;

public class MainApp {
	public static void main (String [] args) {
		
		 try  { 
			 	
	            
	            //InciarJframeInterfaz
	            
	            EventQueue.invokeLater(new Runnable() {
	    			public void run() {
	    				try {
	    					JframeInterfaz frame = new JframeInterfaz();
	    					frame.setVisible(true);
	    					frame.setResizable(false); //Para que no se pueda redimensionar.
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
