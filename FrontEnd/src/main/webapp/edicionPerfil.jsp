
<%@ page import="Modelos.Perfil" %>
<% 
    // Obtener el perfil a editar desde el request
    Perfil perfil = (Perfil) request.getAttribute("perfil");
    
    // Verificar si el perfil existe antes de mostrar el formulario de edici�n
    if (perfil != null) {
%>
<%@include file="views/includes/header.jspl" %>
<body>
<%@include file="views/includes/sidebar.jspl" %>
    <div class="form-container">
        <h1>Edici�n de Perfil</h1>
        
        <form action="Perfil" method="post">
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" value="<%= perfil.getNombre() %>" class="form-input" required><br><br>
            <input type="hidden" name="idPerfil" value="<%= perfil.getIdPerfil() %>">
            <input type="submit" value="Guardar Cambios" class="form-submit">
        </form>
    </div>
    </body>
<%@include file="views/includes/footer.jspl" %>
<%
    } else {
%>
    <p>No se encontr� el perfil para editar.</p>
<%
    }
%>
