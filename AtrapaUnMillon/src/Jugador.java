
public class Jugador {

	// Creación clase Jugador Rafa: 07/05/25

	private String nombre;
	private String contraseña;
	int puntacionMax;

	public Jugador(String nombre, String contraseña, int puntacionMax) {

		this.nombre = nombre;
		this.contraseña = contraseña;
		this.puntacionMax = puntacionMax;
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

	// Método posible Actualizar Puntos en caso de que guardemos ranking
	/*
	 * 
	 * public static void actualizarPuntos(int puntuacion){ if(puntuacion >
	 * puntuacionMax){ puntuacionMax= puntuacion;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

}
