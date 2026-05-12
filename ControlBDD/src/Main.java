import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class Main {

	public static void main (String [] args) {
		ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
		
		
		 try  { 
			 
			 	//Conexión a la BDD
			 	String url = "mongodb+srv://joaest22_db_user:"
			 				+ "UnjWo1ilrimUXFVL@atrapa1millon.dli87oo.mongodb.net/?appName=Atrapa1Millon";
	        	MongoClient mongoClient = MongoClients.create(url);
	            
	        	MongoDatabase database = mongoClient.getDatabase("atrapa1millon");
	            MongoCollection<Document> collectionUsuarios = database.getCollection("usuarios");
	            MongoCollection<Document> collectionPreguntas = database.getCollection("preguntas");
	            
			 	CrearObjetosPregunta(preguntas);
				insertarPreguntas(collectionPreguntas, preguntas);
	
				}   catch (Exception e) {
				    e.printStackTrace();
				}
		 

	
	}//FIN MAIN
	
	public static void insertarPreguntas(MongoCollection<Document> collectionPreguntas, ArrayList<Pregunta> preguntas) {
        
		for(int i=0; i<preguntas.size();i++) {
		       Document pregunta = new Document("pregunta", preguntas.get(i).getPregunta())
		                .append("respuestaCorrecta", preguntas.get(i).getRespuestaCorrecta())
		                .append("dificultad", preguntas.get(i).getDificultad())
		                .append("respuesta1", preguntas.get(i).getRespuestas().get(0))
		                .append("respuesta2", preguntas.get(i).getRespuestas().get(1))
		                .append("respuesta3", preguntas.get(i).getRespuestas().get(2))
		                .append("respuesta4", preguntas.get(i).getRespuestas().get(3));
		                
		                collectionPreguntas.insertOne(pregunta);
			
		}
        
	}

	
	public static void CrearObjetosPregunta (ArrayList<Pregunta> preguntas) {
		

		ArrayList<String> respuestas;

		// ==========================
		// DIFICULTAD 2
		// ==========================

		respuestas = new ArrayList<String>();
		respuestas.add("Lope de Vega");
		respuestas.add("Miguel de Cervantes");
		respuestas.add("Federico García Lorca");
		respuestas.add("Camilo José Cela");

		preguntas.add(new Pregunta(
		    "¿Quién escribió “Don Quijote de la Mancha”?",
		    "Miguel de Cervantes",
		    respuestas,
		    2
		));

		respuestas = new ArrayList<String>();
		respuestas.add("Plata");
		respuestas.add("Hierro");
		respuestas.add("Oro");
		respuestas.add("Zinc");

		preguntas.add(new Pregunta(
		    "¿Cuál es el metal cuyo símbolo químico es Fe?",
		    "Hierro",
		    respuestas,
		    2
		));

		respuestas = new ArrayList<String>();
		respuestas.add("Europa");
		respuestas.add("Asia");
		respuestas.add("África");
		respuestas.add("Oceanía");

		preguntas.add(new Pregunta(
		    "¿En qué continente está Egipto?",
		    "África",
		    respuestas,
		    2
		));

		respuestas = new ArrayList<String>();
		respuestas.add("9");
		respuestas.add("10");
		respuestas.add("11");
		respuestas.add("12");

		preguntas.add(new Pregunta(
		    "¿Cuántos jugadores tiene un equipo de fútbol en el campo?",
		    "11",
		    respuestas,
		    2
		));

		respuestas = new ArrayList<String>();
		respuestas.add("Grecia");
		respuestas.add("Italia");
		respuestas.add("Portugal");
		respuestas.add("Turquía");

		preguntas.add(new Pregunta(
		    "¿Qué país tiene forma de bota?",
		    "Italia",
		    respuestas,
		    2
		));

		respuestas = new ArrayList<String>();
		respuestas.add("Picasso");
		respuestas.add("Van Gogh");
		respuestas.add("Leonardo da Vinci");
		respuestas.add("Monet");

		preguntas.add(new Pregunta(
		    "¿Quién pintó “La Mona Lisa”?",
		    "Leonardo da Vinci",
		    respuestas,
		    2
		));

		respuestas = new ArrayList<String>();
		respuestas.add("Tibia");
		respuestas.add("Húmero");
		respuestas.add("Fémur");
		respuestas.add("Radio");

		preguntas.add(new Pregunta(
		    "¿Cuál es el hueso más largo del cuerpo humano?",
		    "Fémur",
		    respuestas,
		    2
		));

		respuestas = new ArrayList<String>();
		respuestas.add("Español");
		respuestas.add("Portugués");
		respuestas.add("Inglés");
		respuestas.add("Francés");

		preguntas.add(new Pregunta(
		    "¿Qué idioma se habla principalmente en Brasil?",
		    "Portugués",
		    respuestas,
		    2
		));

		respuestas = new ArrayList<String>();
		respuestas.add("K2");
		respuestas.add("Everest");
		respuestas.add("Aconcagua");
		respuestas.add("Kilimanjaro");

		preguntas.add(new Pregunta(
		    "¿Cuál es la montaña más alta del mundo?",
		    "Everest",
		    respuestas,
		    2
		));

		respuestas = new ArrayList<String>();
		respuestas.add("Oxígeno");
		respuestas.add("Hidrógeno");
		respuestas.add("Helio");
		respuestas.add("Nitrógeno");

		preguntas.add(new Pregunta(
		    "¿Qué gas respiramos principalmente?",
		    "Oxígeno",
		    respuestas,
		    2
		));
		
		respuestas = new ArrayList<String>();
		respuestas.add("Sídney");
		respuestas.add("Melbourne");
		respuestas.add("Canberra");
		respuestas.add("Perth");

		preguntas.add(new Pregunta(
		    "¿Cuál es la capital de Australia?",
		    "Canberra",
		    respuestas,
		    2
		));
		
		
		respuestas = new ArrayList<String>();
		respuestas.add("Newton");
		respuestas.add("Tesla");
		respuestas.add("Einstein");
		respuestas.add("Darwin");

		preguntas.add(new Pregunta(
		    "¿Qué científico formuló la teoría de la relatividad?",
		    "Einstein",
		    respuestas,
		    2
		));
		
		respuestas = new ArrayList<String>();
		respuestas.add("Sahara");
		respuestas.add("Gobi");
		respuestas.add("Kalahari");
		respuestas.add("Antártico");

		preguntas.add(new Pregunta(
		    "¿Cuál es el desierto más grande del mundo?",
		    "Antártico",
		    respuestas,
		    2
		));
		
		respuestas = new ArrayList<String>();
		respuestas.add("1965");
		respuestas.add("1969");
		respuestas.add("1972");
		respuestas.add("1959");

		preguntas.add(new Pregunta(
		    "¿En qué año llegó el hombre a la Luna?",
		    "1969",
		    respuestas,
		    2
		));
		
		respuestas = new ArrayList<String>();
		respuestas.add("Barómetro");
		respuestas.add("Termómetro");
		respuestas.add("Higrómetro");
		respuestas.add("Altímetro");

		preguntas.add(new Pregunta(
		    "¿Qué instrumento mide la presión atmosférica?",
		    "Barómetro",
		    respuestas,
		    2
		));
		

		// ==========================
		// DIFICULTAD 3
		// ==========================

		respuestas = new ArrayList<String>();
		respuestas.add("Indonesia");
		respuestas.add("Filipinas");
		respuestas.add("Suecia");
		respuestas.add("Japón");

		preguntas.add(new Pregunta(
		    "¿Cuál es el país con mayor número de islas del mundo?",
		    "Suecia",
		    respuestas,
		    3
		));

		respuestas = new ArrayList<String>();
		respuestas.add("Sócrates");
		respuestas.add("Platón");
		respuestas.add("Aristóteles");
		respuestas.add("Pitágoras");

		preguntas.add(new Pregunta(
		    "¿Qué filósofo fue maestro de Alejandro Magno?",
		    "Aristóteles",
		    respuestas,
		    3
		));

		respuestas = new ArrayList<String>();
		respuestas.add("Oxígeno");
		respuestas.add("Carbono");
		respuestas.add("Hidrógeno");
		respuestas.add("Helio");

		preguntas.add(new Pregunta(
		    "¿Cuál es el elemento más abundante en el universo?",
		    "Hidrógeno",
		    respuestas,
		    3
		));

		respuestas = new ArrayList<String>();
		respuestas.add("Serbia");
		respuestas.add("Croacia");
		respuestas.add("Austria");
		respuestas.add("Hungría");

		preguntas.add(new Pregunta(
		    "¿En qué país nació Nikola Tesla?",
		    "Croacia",
		    respuestas,
		    3
		));

		respuestas = new ArrayList<String>();
		respuestas.add("Maya");
		respuestas.add("Azteca");
		respuestas.add("Inca");
		respuestas.add("Olmeca");

		preguntas.add(new Pregunta(
		    "¿Qué civilización construyó Machu Picchu?",
		    "Inca",
		    respuestas,
		    3
		));

		respuestas = new ArrayList<String>();
		respuestas.add("Taskent");
		respuestas.add("Ulán Bator");
		respuestas.add("Astana");
		respuestas.add("Dusambé");

		preguntas.add(new Pregunta(
		    "¿Cuál es la capital de Mongolia?",
		    "Ulán Bator",
		    respuestas,
		    3
		));

		respuestas = new ArrayList<String>();
		respuestas.add("Pitágoras");
		respuestas.add("Newton");
		respuestas.add("Gauss");
		respuestas.add("Euler");

		preguntas.add(new Pregunta(
		    "¿Qué matemático desarrolló gran parte del cálculo diferencial junto con Leibniz?",
		    "Newton",
		    respuestas,
		    3
		));

		respuestas = new ArrayList<String>();
		respuestas.add("Ardilla voladora");
		respuestas.add("Murciélago");
		respuestas.add("Colugo");
		respuestas.add("Pingüino");

		preguntas.add(new Pregunta(
		    "¿Cuál es el único mamífero capaz de volar?",
		    "Murciélago",
		    respuestas,
		    3
		));

		respuestas = new ArrayList<String>();
		respuestas.add("Rusia");
		respuestas.add("Estados Unidos");
		respuestas.add("Francia");
		respuestas.add("China");

		preguntas.add(new Pregunta(
		    "¿Qué país tiene más husos horarios oficiales?",
		    "Francia",
		    respuestas,
		    3
		));

		respuestas = new ArrayList<String>();
		respuestas.add("Mozart");
		respuestas.add("Bach");
		respuestas.add("Beethoven");
		respuestas.add("Chopin");

		preguntas.add(new Pregunta(
		    "¿Qué compositor quedó sordo en sus últimos años?",
		    "Beethoven",
		    respuestas,
		    3
		));
		
		respuestas = new ArrayList<String>();
		respuestas.add("30.000");
		respuestas.add("150.000");
		respuestas.add("300.000");
		respuestas.add("3.000.000");

		preguntas.add(new Pregunta(
		    "¿Cuál es la velocidad aproximada de la luz en el vacío en km/s?",
		    "300.000",
		    respuestas,
		    3
		));
		
		respuestas = new ArrayList<String>();
		respuestas.add("Japón");
		respuestas.add("Indonesia");
		respuestas.add("Islandia");
		respuestas.add("Chile");

		preguntas.add(new Pregunta(
		    "¿Qué país tiene el mayor número de volcanes activos?",
		    "Indonesia",
		    respuestas,
		    3
		));
		
		respuestas = new ArrayList<String>();
		respuestas.add("Tolkien");
		respuestas.add("George R. R. Martin");
		respuestas.add("Ursula K. Le Guin");
		respuestas.add("C. S. Lewis");

		preguntas.add(new Pregunta(
		    "¿Qué escritor creó el universo de “Terramar”?",
		    "Ursula K. Le Guin",
		    respuestas,
		    3
		));
		
		respuestas = new ArrayList<String>();
		respuestas.add("Yen");
		respuestas.add("Yuan");
		respuestas.add("Won");
		respuestas.add("Ringgit");

		preguntas.add(new Pregunta(
		    "¿Cuál es la moneda oficial de Corea del Sur?",
		    "Won",
		    respuestas,
		    3
		));
		
		respuestas = new ArrayList<String>();
		respuestas.add("1985");
		respuestas.add("1987");
		respuestas.add("1989");
		respuestas.add("1991");

		preguntas.add(new Pregunta(
		    "¿En qué año cayó el Muro de Berlín?",
		    "1989",
		    respuestas,
		    3
		));

		// ==========================
		// DIFICULTAD 4
		// ==========================

		respuestas = new ArrayList<String>();
		respuestas.add("Isaac Newton");
		respuestas.add("Rudolf Clausius");
		respuestas.add("Max Planck");
		respuestas.add("Michael Faraday");

		preguntas.add(new Pregunta(
		    "¿Qué científico acuñó el término “entropía” en termodinámica?",
		    "Rudolf Clausius",
		    respuestas,
		    4
		));

		respuestas = new ArrayList<String>();
		respuestas.add("Mónaco");
		respuestas.add("Luxemburgo");
		respuestas.add("San Marino");
		respuestas.add("Ciudad del Vaticano");

		preguntas.add(new Pregunta(
		    "¿Cuál es el país más pequeño del mundo reconocido internacionalmente?",
		    "Ciudad del Vaticano",
		    respuestas,
		    4
		));

		respuestas = new ArrayList<String>();
		respuestas.add("Nerón");
		respuestas.add("Augusto");
		respuestas.add("Constantino I");
		respuestas.add("Trajano");

		preguntas.add(new Pregunta(
		    "¿Qué emperador romano convirtió el cristianismo en religión legal mediante el Edicto de Milán?",
		    "Constantino I",
		    respuestas,
		    4
		));

		respuestas = new ArrayList<String>();
		respuestas.add("Plata");
		respuestas.add("Mercurio");
		respuestas.add("Hidrógeno");
		respuestas.add("Helio");

		preguntas.add(new Pregunta(
		    "¿Cuál es el único elemento químico cuyo símbolo proviene de su nombre en latín “Hydrargyrum”?",
		    "Mercurio",
		    respuestas,
		    4
		));

		respuestas = new ArrayList<String>();
		respuestas.add("Tolstói");
		respuestas.add("Chéjov");
		respuestas.add("Dostoyevski");
		respuestas.add("Pushkin");

		preguntas.add(new Pregunta(
		    "¿Qué escritor ruso es autor de “Los hermanos Karamázov”?",
		    "Dostoyevski",
		    respuestas,
		    4
		));
		
		respuestas = new ArrayList<String>();
		respuestas.add("Tolstói");
		respuestas.add("Chéjov");
		respuestas.add("Dostoyevski");
		respuestas.add("Pushkin");

		preguntas.add(new Pregunta(
		    "¿Qué escritor ruso es autor de “Los hermanos Karamázov”?",
		    "Dostoyevski",
		    respuestas,
		    4
		));
		
		respuestas = new ArrayList<String>();
		respuestas.add("Austerlitz");
		respuestas.add("Leipzig");
		respuestas.add("Trafalgar");
		respuestas.add("Waterloo");

		preguntas.add(new Pregunta(
		    "¿En qué batalla fue derrotado definitivamente Napoleón Bonaparte?",
		    "Waterloo",
		    respuestas,
		    4
		));
		
		respuestas = new ArrayList<String>();
		respuestas.add("Almatý");
		respuestas.add("Taskent");
		respuestas.add("Astaná");
		respuestas.add("Biskek");

		preguntas.add(new Pregunta(
		    "¿Cuál es la capital de Kazajistán actualmente?",
		    "Astaná",
		    respuestas,
		    4
		));
		
		respuestas = new ArrayList<String>();
		respuestas.add("Protón");
		respuestas.add("Neutrón");
		respuestas.add("Electrón");
		respuestas.add("Fotón");

		preguntas.add(new Pregunta(
		    "¿Qué partícula subatómica tiene carga negativa?",
		    "Electrón",
		    respuestas,
		    4
		));
		
		respuestas = new ArrayList<String>();
		respuestas.add("Beethoven");
		respuestas.add("Mozart");
		respuestas.add("Wagner");
		respuestas.add("Verdi");

		preguntas.add(new Pregunta(
		    "¿Quién compuso la ópera “La flauta mágica”?",
		    "Mozart",
		    respuestas,
		    4
		));
		
		respuestas = new ArrayList<String>();
		respuestas.add("Francés");
		respuestas.add("Italiano");
		respuestas.add("Romanche");
		respuestas.add("Alemán");

		preguntas.add(new Pregunta(
		    "¿Cuál es el idioma más hablado en Suiza?",
		    "Alemán",
		    respuestas,
		    4
		));
		
		respuestas = new ArrayList<String>();
		respuestas.add("Egipcia");
		respuestas.add("Romana");
		respuestas.add("Mesopotámica");
		respuestas.add("Fenicia");

		preguntas.add(new Pregunta(
		    "¿Qué civilización desarrolló la escritura cuneiforme?",
		    "Mesopotámica",
		    respuestas,
		    4
		));
		
		respuestas = new ArrayList<String>();
		respuestas.add("Byte");
		respuestas.add("Bit");
		respuestas.add("Megabyte");
		respuestas.add("Hertz");

		preguntas.add(new Pregunta(
		    "¿Cuál es la unidad básica de información en informática?",
		    "Bit",
		    respuestas,
		    4
		));
		
		respuestas = new ArrayList<String>();
		respuestas.add("Irak");
		respuestas.add("Siria");
		respuestas.add("Irán");
		respuestas.add("Jordania");

		preguntas.add(new Pregunta(
		    "¿Qué país fue antiguamente conocido como Persia?",
		    "Irán",
		    respuestas,
		    4
		));
		
		respuestas = new ArrayList<String>();
		respuestas.add("Darwin");
		respuestas.add("Pasteur");
		respuestas.add("Mendel");
		respuestas.add("Lamarck");

		preguntas.add(new Pregunta(
		    "¿Quién formuló las leyes de la herencia genética moderna?",
		    "Mendel",
		    respuestas,
		    4
		));
		
		
	}
	
	 public static void reiniciarColecciones(MongoCollection<Document> collectionPreguntas) {
		 collectionPreguntas.deleteMany(new Document());
	 }
}//FIN CLASS

