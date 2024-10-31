package Modelos;


public class Usuario {

	private int idUsuario;
	private String nombreCompleto;
	private String correo;
	private String contrasena;
	private Perfil perfil;
	private int usuarioRegistro;
	private String fechaRegistro;
	private int usuarioUltModificacion;
	private String fechaUltModificacion;
	
	public Usuario() {
		//super();
	}

	public Usuario(int idUsuario, String nombreCompleto, String correo, String contrasena, Perfil perfil,
			int usuarioRegistro, String fechaRegistro, int usuarioUltModificacion,
			String fechaUltModificacion) {
		//super();
		this.idUsuario = idUsuario;
		this.nombreCompleto = nombreCompleto;
		this.correo = correo;
		this.contrasena = contrasena;
		this.perfil = perfil;
		this.usuarioRegistro = usuarioRegistro;
		this.fechaRegistro = fechaRegistro;
		this.usuarioUltModificacion = usuarioUltModificacion;
		this.fechaUltModificacion = fechaUltModificacion;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public int getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(int usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public int getUsuarioUltModificacion() {
		return usuarioUltModificacion;
	}

	public void setUsuarioUltModificacion(int usuarioUltModificacion) {
		this.usuarioUltModificacion = usuarioUltModificacion;
	}

	public String getFechaUltModificacion() {
		return fechaUltModificacion;
	}

	public void setFechaUltModificacion(String fechaUltModificacion) {
		this.fechaUltModificacion = fechaUltModificacion;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreCompleto=" + nombreCompleto + ", correo=" + correo
				+ ", contrase�a=" + contrasena + ", perfil=" + perfil + ", usuarioRegistro=" + usuarioRegistro
				+ ", fechaRegistro=" + fechaRegistro + ", usuarioUltModificacion=" + usuarioUltModificacion
				+ ", fechaUltModificacion=" + fechaUltModificacion + "]";
	}


	
	
}

