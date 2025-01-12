<%@ page import="java.util.List" %>
<%@ page import="Modelos.Usuario" %>


<div class="container-usuario">
    <h1>Listado de Usuarios</h1>
    <div class="table-responsive">
        <table class="table tableuser">
            <!-- Encabezados de la tabla -->
            <thead>
                <tr>
                    <th>C�digo</th>
                    <th>Nombre Completo</th>
                    <th>Correo</th>
                    <th>Contrase�a</th>
                    <th>Perfil</th>
                    <th>Fecha de Registro</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <!-- Iteraci�n sobre todos los registros -->
                <% 

                List<Usuario> listado = (List<Usuario>) request.getAttribute("listado");
                if (listado != null && !listado.isEmpty()) {
                    for (Usuario usu : listado) {
                %>
                <tr>
                    <td><%= usu.getIdUsuario() %></td>
                    <td><%= usu.getNombreCompleto() %></td>
                    <td><%= usu.getCorreo() %></td>
                    <td><%= usu.getContrasena() %></td>
                    <td><%= usu.getPerfil().getNombre() %></td>
                    <td><%= usu.getFechaRegistro() %></td>
                    <td class="actions">
                        <a href="Usuario?accion=Modificar&idUsuario=<%= usu.getIdUsuario() %>">Editar</a>
                        <a href="Usuario?accion=Eliminar&idUsuario=<%= usu.getIdUsuario() %>">Eliminar</a>
                    </td>
                </tr>
                <% } %>
                <% } else { %>
                <tr>
                    <td colspan="7">No se encontraron usuarios.</td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    <br>
    <a href="Usuario?accion=Registrar" style="text-decoration: none; display: block; text-align: center; padding: 10px; background-color: #4CAF50; color: white; border-radius: 4px;">Registrar Nuevo Usuario</a>
</div>
