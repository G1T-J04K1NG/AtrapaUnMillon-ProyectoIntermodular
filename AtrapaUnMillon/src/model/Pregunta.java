package model;
import java.util.*;

//Creación clase Pregunta Rafa: 07/05/25

public class Pregunta {

	private String pregunta;
	private String respuestaCorrecta;
	private ArrayList<String> respuestas;
	private int dificultad;
	
	public Pregunta() {
		
	}
	
	
	public Pregunta(String pregunta, String respuestaCorrecta, ArrayList<String> respuestas, int dificultad) {
		this.pregunta = pregunta;
		this.respuestaCorrecta = respuestaCorrecta;
		this.respuestas = respuestas;
		this.dificultad = dificultad;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public String getRespuestaCorrecta() {
		return respuestaCorrecta;
	}
	public void setRespuestaCorrecta(String respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}
	public ArrayList<String> getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(ArrayList<String> respuestas) {
		this.respuestas = respuestas;
	}
	public int getDificultad() {
		return dificultad;
	}
	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}
}
