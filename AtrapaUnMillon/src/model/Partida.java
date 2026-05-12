package model;

import java.util.*;

public class Partida {

	// Creación clase Partida Rafa: 07/05/25
	private Usuario usuario;
	private int dinero;
	private int ronda;
	private boolean modoJuego;

	public Partida(Usuario jugador) {
		this.usuario = jugador;
		this.dinero = 0;
		this.ronda = 0;
		this.modoJuego= true;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario jugador) {
		this.usuario = jugador;
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

	public boolean isModoJuego() {
		return modoJuego;
	}

	public void setModoJuego(boolean modoJuego) {
		this.modoJuego = modoJuego;
	}

	
	
}
