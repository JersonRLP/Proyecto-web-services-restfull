<%@ include file="views/includes/header.jspl" %>

<body>
    <%@ include file="views/includes/sidebar.jspl" %>
	
    <div class="container-registro">
        <h1>Registro de Perfil</h1>
        
        <%-- Mostrar mensaje de error si existe --%>
        <% String mensajeError = (String) request.getAttribute("mensajeError"); %>
    	<% if (mensajeError != null) { %>
            <div class="alert alert-danger">
                 <%= mensajeError %>
            </div>
        <% } %>
        
        <form action="Perfil" method="post">
            <label class="form-label" for="nombre">Nombre:</label>
            <input class="form-input" type="text" id="nombre" name="nombre" required>
            <input class="form-submit" type="submit" value="Registrar">
        </form>
    </div>
</body>

<%@ include file="views/includes/footer.jspl" %>
