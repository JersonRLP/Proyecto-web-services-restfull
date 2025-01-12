package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import Impl.UsuarioImpl;
import Modelos.Perfil;
import Modelos.Usuario;

/**
 * Servlet implementation class ControladorUsuario
 */
public class ControladorUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion=request.getParameter("accion");

		if (accion != null) {
			switch (accion) {
			 case "Listado":

	                UsuarioImpl list = new UsuarioImpl();
	                List<Usuario> listadoUsuarios = list.ListadoUsuario();
	                request.setAttribute("listado", listadoUsuarios);
	                request.getRequestDispatcher("/ListadoUsuarios.jsp").forward(request, response);
	                break;

				case "Registrar":
					request.getRequestDispatcher("/RegistroUsuarios.jsp").forward(request, response);
					break;

				case "Modificar":
					String idUsuarioModificar = request.getParameter("idUsuario");
					if (idUsuarioModificar != null) {
						int idUsuario = Integer.parseInt(idUsuarioModificar);
						UsuarioImpl update = new UsuarioImpl();
						Usuario usuario = obtenerUsuarioPorId(idUsuario, update.ListadoUsuario());
						request.setAttribute("usuario", usuario);
						request.getRequestDispatcher("/ActualizarUsuario.jsp").forward(request, response);
					} else {
						response.sendRedirect(request.getContextPath() + "/Usuario?accion=Listado");
					}
					break;

				case "Eliminar":
					UsuarioImpl eliminar = new UsuarioImpl();
					int codelim = Integer.parseInt(request.getParameter("idUsuario"));
					eliminar.EliminarUsuario(codelim);	 
					List<Usuario> listado = eliminar.ListadoUsuario();
					request.setAttribute("listado", listado);	
					request.getRequestDispatcher("/ListadoUsuarios.jsp").forward(request, response);
					break;

				default:
					response.sendRedirect(request.getContextPath() + "/Usuario?accion=Listado");
					break;
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/Usuario?accion=Listado");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String idUsuario = request.getParameter("idUsuario");
        String nombreCompleto = request.getParameter("nombreCompleto");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String idPerfil = request.getParameter("idPerfil");
        String usuarioUltModificacion = request.getParameter("usuarioUltModificacion");

        Usuario usuario = new Usuario();
        UsuarioImpl crud = new UsuarioImpl();

        usuario.setNombreCompleto(nombreCompleto);
        usuario.setCorreo(correo);
        usuario.setContrasena(contrasena);

        Perfil perfil = new Perfil();
        perfil.setIdPerfil(Integer.parseInt(idPerfil));
        usuario.setPerfil(perfil);
        usuario.setUsuarioRegistro(Integer.parseInt(usuarioUltModificacion));

        JsonObject jsonResponse = new JsonObject();
        List<Usuario> listaUsuarios = crud.ListadoUsuario();

        if (idUsuario == null || idUsuario.isEmpty()) {
            // Nuevo usuario
            if (obtenerUsuarioPorNombre(nombreCompleto, listaUsuarios) == null) {
                crud.CrearUsuario(usuario);
            } else {
                jsonResponse.addProperty("mensajeError", "El usuario con el nombre " + nombreCompleto + " ya existe.");
                response.getWriter().write(new Gson().toJson(jsonResponse));
                return;
            }
        } else {
            // Actualizar usuario
            usuario.setIdUsuario(Integer.parseInt(idUsuario));
            crud.ActualizarUsuario(usuario);
        }

        jsonResponse.addProperty("success", true);
        response.getWriter().write(new Gson().toJson(jsonResponse));
	}

	
	private Usuario obtenerUsuarioPorId(int idUsuario, List<Usuario> listaUsuarios) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getIdUsuario() == idUsuario) {
                return usuario;
            }
        }
        return null;
    }
	
	 private Usuario obtenerUsuarioPorNombre(String nombre, List<Usuario> listaUsuarios) {
	        for (Usuario usuario : listaUsuarios) {
	            if (usuario.getNombreCompleto().equalsIgnoreCase(nombre)) {
	                return usuario;
	            }
	        }
	        return null;
	    }

}
