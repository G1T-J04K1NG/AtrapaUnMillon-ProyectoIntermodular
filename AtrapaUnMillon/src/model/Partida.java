package model;
import java.util.*;

public class Partida {

	// Creación clase Partida Rafa: 07/05/25
	private Usuario jugador;
	private int dinero;
	private int ronda;


	public Partida(Usuario jugador) {
		this.jugador = jugador;
		this.dinero = 0;
		this.ronda = 0;
		
	}
	/*
	 * Sobre el constructor de Partida: Lo suyo es que empieze con dinero 500 e ir
	 * aumentando según las respuestas correctas Hay que pensar como calcular la
	 * puntuación: Si va a ser una mezcla entre puntuación por tiempo restante o por
	 * premio o como numPregunta hay que pensarlo. Normalmente en los programas
	 * estos según por la pregunta que vayas dejan que te lleves el dinero o no, hay
	 * que plantearlo
	 *
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public Usuario getJugador() {
		return jugador;
	}

	public void setJugador(Usuario jugador) {
		this.jugador = jugador;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public int getRonda() {
		return ronda;
	}

	public void setRonda(int ronda) {
		this.ronda = ronda;
	}


}
