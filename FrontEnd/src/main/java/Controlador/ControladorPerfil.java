package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Impl.PerfilImpl;
import Modelos.Perfil;

/**
 * Servlet implementation class ControladorPerfil
 */
public class ControladorPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorPerfil() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");

		if (accion != null) {
			switch (accion) {
				case "Listado":
					listarPerfiles(request, response);
					break;
				case "Registrar":
					request.getRequestDispatcher("/registroPerfil.jsp").forward(request, response);
					break;
				case "Modificar":
					modificarPerfil(request, response);
					break;
				case "Eliminar":
					eliminarPerfil(request, response);
					break;
				default:
					response.sendRedirect(request.getContextPath() + "/Perfil?accion=Listado");
					break;
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/Perfil?accion=Listado");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idPerfil = request.getParameter("idPerfil");
		String nombre = request.getParameter("nombre");

		Perfil perfil = new Perfil();
		perfil.setNombre(nombre);

		PerfilImpl crud = new PerfilImpl();

		if (idPerfil == null || idPerfil.isEmpty()) {
			// Nuevo perfil
			if (perfilExistePorNombre(nombre, crud.ListadoPerfil())) {
		        request.setAttribute("mensajeError", "El perfil con el nombre " + nombre + " ya existe.");
		        request.getRequestDispatcher("/registroPerfil.jsp").forward(request, response);
		        return;
		    }
			crud.CrearPerfil(perfil);
		} else {
			// Actualizar perfil
			int cod = Integer.parseInt(idPerfil);
			perfil.setIdPerfil(cod);
			crud.ActualizarPerfil(perfil);
		}

		response.sendRedirect(request.getContextPath() + "/Perfil?accion=Listado");
	}

	private void listarPerfiles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PerfilImpl crud = new PerfilImpl();
		List<Perfil> listadoPerfiles = crud.ListadoPerfil();
		request.setAttribute("listado", listadoPerfiles);
		request.getRequestDispatcher("/listadoPerfil.jsp").forward(request, response);
	}

	private void modificarPerfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idPerfilModificar = request.getParameter("idPerfil");
		if (idPerfilModificar != null) {
			int idPerfil = Integer.parseInt(idPerfilModificar);
			PerfilImpl perfilImpl = new PerfilImpl();
			Perfil perfil = obtenerPerfilPorId(idPerfil, perfilImpl.ListadoPerfil());
			request.setAttribute("perfil", perfil);
			request.getRequestDispatcher("/edicionPerfil.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/Perfil?accion=Listado");
		}
	}

	private void eliminarPerfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PerfilImpl eliminar = new PerfilImpl();
		int codelim = Integer.parseInt(request.getParameter("idPerfil"));
		eliminar.EliminarPerfil(codelim);
		listarPerfiles(request, response);
	}

	private Perfil obtenerPerfilPorId(int idPerfil, List<Perfil> listaPerfiles) {
		for (Perfil perfil : listaPerfiles) {
			if (perfil.getIdPerfil() == idPerfil) {
				return perfil;
			}
		}
		return null;
	}
	
	
	private boolean perfilExistePorNombre(String nombre, List<Perfil> listaPerfiles) {
	    return listaPerfiles.stream().anyMatch(p -> p.getNombre().equalsIgnoreCase(nombre));
	}

}
