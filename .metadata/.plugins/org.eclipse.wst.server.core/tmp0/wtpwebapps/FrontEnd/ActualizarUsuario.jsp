
<%@ page import="Modelos.Usuario" %>
<% 
    // Obtener el perfil a editar desde el request
    Usuario usuario = (Usuario) request.getAttribute("usuario");
    
    // Verificar si el perfil existe antes de mostrar el formulario de edición
    if (usuario != null) {
%>
<%@include file="views/includes/header.jspl" %>
<body>
<%@include file="views/includes/sidebar.jspl" %>
    <div class="form-container">
        <h1>Edición de Perfil</h1>
        
        <form action="Usuario" method="post">
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombreCompleto" value="<%= usuario.getNombreCompleto() %>" class="form-input" required><br><br>
           <label for="nombre">Correo:</label>
            <input type="text" name="correo" value="<%= usuario.getCorreo() %>"class="form-input" requerid><br><br>
            <label for="nombre">Contraseña:</label>
            <input type="text" name="contraseña" value="<%= usuario.getContrasena() %>"class="form-input" requerid><br><br>
            <label for="nombre">IdPerfil:</label>
            <input type="number" name="idPerfil" value="<%= usuario.getPerfil().getIdPerfil() %>"class="form-input" requerid><br><br>
            <label for="nombre">UsuarioIdModificado:</label>
            <input type="number" name="usuarioUltModificacion" value="<%= usuario.getUsuarioUltModificacion() %>"class="form-input" requerid><br><br>
           <input type="hidden" name="idUsuario" value="<%= usuario.getIdUsuario() %>">
            <input type="submit" value="Guardar Cambios" class="form-submit">
        </form>
    </div>
    </body>
<%@include file="views/includes/footer.jspl" %>
<%
    } else {
%>
    <p>No se encontró el perfil para editar.</p>
<%
    }
%>