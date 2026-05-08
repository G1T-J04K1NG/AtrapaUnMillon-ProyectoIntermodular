
public class Usuario {

	// Creación clase Jugador Rafa: 07/05/25

	private String nombre;
	private String contraseña;
	private int puntacionMax;

	public Usuario(String nombre, String contraseña) {

		this.nombre = nombre;
		this.contraseña = contraseña;
		this.puntacionMax = 0;
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

	public int getPuntacionMax() {
		return puntacionMax;
	}

	public void setPuntacionMax(int puntacionMax) {
		this.puntacionMax = puntacionMax;
	}

	public static void actualizarPuntos(int puntuacion, int puntuacionMax) {

		if (puntuacion > puntuacionMax) {
			puntuacionMax = puntuacion;
		}

	}

}
