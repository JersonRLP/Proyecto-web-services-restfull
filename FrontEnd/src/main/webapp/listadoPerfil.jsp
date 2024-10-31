<%@ page import="java.util.List" %>
<%@ page import="Modelos.Perfil" %>

    <div class="container">
        <h1>Listado de Perfiles</h1>
        <table>
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nombre</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <% 
                List<Perfil> listado = (List<Perfil>) request.getAttribute("listado");
                if (listado != null && !listado.isEmpty()) {
                    for (Perfil perfil : listado) {
                %>
                <tr>
                    <td class="text-center"><%= perfil.getIdPerfil() %></td>
                    <td class="text-center"><%= perfil.getNombre() %></td>
                    <td class="actions text-center">
                        <a href="Perfil?accion=Modificar&idPerfil=<%= perfil.getIdPerfil() %>">Editar</a>
						<a href="Perfil?accion=Eliminar&idPerfil=<%= perfil.getIdPerfil() %>">Eliminar</a>

                    </td>
                </tr>
                <% 
                    }
                } else {
                %>
                <tr>
                    <td class="text-center" colspan="3">No se encontraron perfiles.</td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <br>
        <a href="registroPerfil.jsp" style="text-decoration: none; display: block; text-align: center; padding: 10px; background-color: #4CAF50; color: white; border-radius: 4px;">Registrar Nuevo Perfil</a>
    </div>
