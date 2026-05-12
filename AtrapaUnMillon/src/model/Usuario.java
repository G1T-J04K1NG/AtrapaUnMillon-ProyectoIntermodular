package model;

import org.bson.Document;

public class Usuario {

	// Creación clase Jugador Rafa: 07/05/25

	private String nombre;
	private String contraseña;
	private int dineroUsuario;
	private int dineroMejorPartida;

	public Usuario() {

	}

	public Usuario(String nombre, String contraseña) {
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.dineroUsuario = 0;
		this.dineroMejorPartida = 0;
	}

	public Usuario(String nombre, String contraseña, int dinero, int mejorPartida) {
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.dineroUsuario = dinero;
		this.dineroMejorPartida = mejorPartida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public int getDineroUsuario() {
		return dineroUsuario;
	}

	public void setDineroUsuario(int dineroUsuario) {
		this.dineroUsuario = dineroUsuario;
	}

	public int getDineroMejorPartida() {
		return dineroMejorPartida;
	}

	public void setDineroMejorPartida(int dineroMejorPartida) {
		this.dineroMejorPartida = dineroMejorPartida;
	}

}
