
public class Usuario {

	// Creación clase Jugador Rafa: 07/05/25

	private String nombre;
	private String contraseña;
	private int dineroUsuario;

	public Usuario(String nombre, String contraseña) {
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.dineroUsuario = 0;
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

	public int getdineroUsuario() {
		return dineroUsuario;
	}

	public void setdineroUsuario(int dinero) {
		this.dineroUsuario = dinero;
	}

}
