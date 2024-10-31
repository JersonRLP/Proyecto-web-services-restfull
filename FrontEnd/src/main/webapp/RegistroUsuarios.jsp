<%@ include file="views/includes/header.jspl" %>

<body>
    <%@ include file="views/includes/sidebar.jspl" %>

    <div class="container">
        <h1>Registro de Usuarios</h1>

        <!-- Mostrar mensaje de error -->
        <div id="mensajeError" class="alert alert-danger" style="display:none;"></div>
        
        <form id="registroForm">
            <label class="form-label" for="nombreCompleto">Nombre Completo:</label>
            <input class="form-input" type="text" id="nombreCompleto" name="nombreCompleto" required>
            
            <label class="form-label" for="correo">Correo:</label>
            <input class="form-input" type="email" id="correo" name="correo" required>
            
            <label class="form-label" for="contraseña">Contraseña:</label>
            <input class="form-input" type="password" id="contraseña" name="contraseña" required>
            
            <label class="form-label" for="idPerfil">ID Perfil:</label>
            <input class="form-input" type="number" id="idPerfil" name="idPerfil" required>
            
            <label class="form-label" for="usuarioUltModificacion">Usuario Registro:</label>
            <input class="form-input" type="number" id="usuarioUltModificacion" name="usuarioUltModificacion" required>
            
            <input class="form-submit" type="submit" value="Registrar">
        </form>
    </div>

    <script>
        $(document).ready(function() {
            $('#registroForm').submit(function(event) {
                event.preventDefault(); // Detener el envío del formulario

                var nombreCompleto = $('#nombreCompleto').val();
                var correo = $('#correo').val();
                var contraseña = $('#contraseña').val();
                var idPerfil = $('#idPerfil').val();
                var usuarioUltModificacion = $('#usuarioUltModificacion').val();
                
                $.ajax({
                    url: 'Usuario', // La URL a la que se enviará la solicitud
                    type: 'POST',
                    data: {
                        nombreCompleto: nombreCompleto,
                        correo: correo,
                        contraseña: contraseña,
                        idPerfil: idPerfil,
                        usuarioUltModificacion: usuarioUltModificacion
                    },
                    success: function(response) {
                        // Manejar la respuesta del servidor
                        if (response.mensajeError) {
                            $('#mensajeError').text(response.mensajeError).show();
                        } else {
                            // Redirigir o actualizar la página según sea necesario
                            window.location.href = 'Usuario?accion=Listado';
                        }
                    },
                    error: function() {
                        // Manejar el error
                        $('#mensajeError').text('Error en la solicitud.').show();
                    }
                });
            });
        });
    </script>
</body>

</body>
<%@ include file="views/includes/footer.jspl" %>
