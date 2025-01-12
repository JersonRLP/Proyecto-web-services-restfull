package Interfaces;

import java.util.List;

import model.Usuario;

public interface IUsuario {

	void saveUser(Usuario usuario);
	void updateUser(Usuario usuario);
	void deleteUser(Usuario usuario);
	List<Usuario> listUsuarios();
	boolean existCorreo(String correo);
}
