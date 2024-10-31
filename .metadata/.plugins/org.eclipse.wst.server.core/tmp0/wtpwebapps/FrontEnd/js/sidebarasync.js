async function cargarContenido(url) {
    try {
        const response = await fetch(url);
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }
        const data = await response.text();
        document.getElementById('main-content').innerHTML = data;
    } catch (error) {
        console.error('Ha habido un problema con tu operación de fetch:', error);
        mostrarError('Error al cargar el contenido. Por favor, inténtelo de nuevo más tarde.');
    }
}

document.addEventListener('DOMContentLoaded', function() {
    const sidebar = document.querySelector('.sidebar');
    sidebar.addEventListener('click', async function(event) {
        const link = event.target.closest('a.link-async');
        if (link) {
            event.preventDefault();
            await cargarContenido(link.getAttribute('href'));
        }
    });
});