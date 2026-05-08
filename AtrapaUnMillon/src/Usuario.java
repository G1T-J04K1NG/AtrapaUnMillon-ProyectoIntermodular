
public class Usuario {

	// Creación clase Jugador Rafa: 07/05/25

	private String nombre;
	private String contraseña;
	private int ganadorMax;

	public Usuario(String nombre, String contraseña) {

		this.nombre = nombre;
		this.contraseña = contraseña;
		this.ganadorMax = 0;
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

	public int getGanadorMax() {
		return ganadorMax;
	}

	public void setGanadorMax(int puntacionMax) {
		this.ganadorMax = puntacionMax;
	}

	public static void actualizarPuntos(int dinero, int ganadorMax) {

		if (dinero > ganadorMax) {
			ganadorMax = dinero;
		}

	}

}
