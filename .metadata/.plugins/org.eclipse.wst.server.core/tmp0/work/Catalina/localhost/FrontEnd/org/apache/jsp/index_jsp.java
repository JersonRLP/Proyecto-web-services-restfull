/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.1
 * Generated at: 2024-07-13 00:46:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/views/includes/sidebar.jspl", Long.valueOf(1720809782280L));
    _jspx_dependants.put("/views/includes/header.jspl", Long.valueOf(1720809782278L));
    _jspx_dependants.put("/views/includes/footer.jspl", Long.valueOf(1720809782276L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <title>Sidebar</title>\r\n");
      out.write("  <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("  <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css2?family=Work+Sans&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/listadoperfil.css\">\r\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("</head>");
      out.write("\n");
      out.write("<body>\n");
      out.write("<nav class=\"sidebar\">\r\n");
      out.write("    <div class=\"sidebar-top-wrapper\">\r\n");
      out.write("        <div class=\"sidebar-top\">\r\n");
      out.write("            <a href=\"#\" class=\"logo__wrapper\">\r\n");
      out.write("                <img src=\"imagenes/cibertec.jpg\" alt=\"Logo\" class=\"logo-small\">\r\n");
      out.write("                <span class=\"hide company-name\">CIBERTEC</span>\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <button class=\"expand-btn\" type=\"button\">\r\n");
      out.write("            <svg width=\"16\" height=\"16\" viewBox=\"0 0 16 16\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\" aria-labelledby=\"exp-btn\" role=\"img\">\r\n");
      out.write("                <title id=\"exp-btn\">Expand/Collapse Menu</title>\r\n");
      out.write("                <path d=\"M6.00979 2.72L10.3565 7.06667C10.8698 7.58 10.8698 8.42 10.3565 8.93333L6.00979 13.28\"\r\n");
      out.write("                      stroke-width=\"1.5\" stroke-miterlimit=\"10\" stroke-linecap=\"round\" stroke-linejoin=\"round\" />\r\n");
      out.write("            </svg>\r\n");
      out.write("        </button>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"search__wrapper\">\r\n");
      out.write("        <svg width=\"14\" height=\"14\" viewBox=\"0 0 14 14\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\" aria-labelledby=\"search-icon\" role=\"img\">\r\n");
      out.write("            <title id=\"search-icon\">Search</title>\r\n");
      out.write("            <path d=\"M9 9L13 13M5.66667 10.3333C3.08934 10.3333 1 8.244 1 5.66667C1 3.08934 3.08934 1 5.66667 1C8.244 1 10.3333 3.08934 10.3333 5.66667C10.3333 8.244 8.244 10.3333 5.66667 10.3333Z\"\r\n");
      out.write("                  stroke-width=\"1.5\" stroke-linecap=\"round\" stroke-linejoin=\"round\" />\r\n");
      out.write("        </svg>\r\n");
      out.write("        <input type=\"text\" aria-labelledby=\"search-icon\">\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"sidebar-links\">\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a href=\"Perfil?accion=Listado\" title=\"Dashboard\" class=\"tooltip link-async\">\r\n");
      out.write("                    <svg xmlns=\"http://www.w3.org/2000/svg\" class=\"icon icon-tabler icon-tabler-layout-dashboard\" width=\"24\"\r\n");
      out.write("                         height=\"24\" viewBox=\"0 0 24 24\" stroke-width=\"2\" stroke=\"currentColor\" fill=\"none\" stroke-linecap=\"round\"\r\n");
      out.write("                         stroke-linejoin=\"round\" aria-hidden=\"true\">\r\n");
      out.write("                        <path stroke=\"none\" d=\"M0 0h24v24H0z\" fill=\"none\" />\r\n");
      out.write("                        <path d=\"M4 4h6v8h-6z\" />\r\n");
      out.write("                        <path d=\"M4 16h6v4h-6z\" />\r\n");
      out.write("                        <path d=\"M14 12h6v8h-6z\" />\r\n");
      out.write("                        <path d=\"M14 4h6v4h-6z\" />\r\n");
      out.write("                    </svg>\r\n");
      out.write("                    <span class=\"link hide\">Perfil</span>\r\n");
      out.write("                    <span class=\"tooltip__content\">Dashboard</span>\r\n");
      out.write("                </a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a href=\"Usuario?accion=Listado\" class=\"tooltip link-async\">\r\n");
      out.write("                    <svg xmlns=\"http://www.w3.org/2000/svg\" class=\"icon icon-tabler icon-tabler-chart-bar\" width=\"24\"\r\n");
      out.write("                         height=\"24\" viewBox=\"0 0 24 24\" stroke-width=\"2\" stroke=\"currentColor\" fill=\"none\" stroke-linecap=\"round\"\r\n");
      out.write("                         stroke-linejoin=\"round\" aria-hidden=\"true\">\r\n");
      out.write("                        <path stroke=\"none\" d=\"M0 0h24v24H0z\" fill=\"none\" />\r\n");
      out.write("                        <path d=\"M3 12m0 1a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v6a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1z\" />\r\n");
      out.write("                        <path d=\"M9 8m0 1a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v10a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1z\" />\r\n");
      out.write("                        <path d=\"M15 4m0 1a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v14a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1z\" />\r\n");
      out.write("                        <path d=\"M4 20l14 0\" />\r\n");
      out.write("                    </svg>\r\n");
      out.write("                    <span class=\"link hide\">Usuario</span>\r\n");
      out.write("                    <span class=\"tooltip__content\">Market Overview</span>\r\n");
      out.write("                </a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li>\r\n");
      out.write("                <a href=\"#\" class=\"tooltip link-async\">\r\n");
      out.write("                    <svg xmlns=\"http://www.w3.org/2000/svg\" class=\"icon icon-tabler icon-tabler-chart-bar\" width=\"24\"\r\n");
      out.write("                         height=\"24\" viewBox=\"0 0 24 24\" stroke-width=\"2\" stroke=\"currentColor\" fill=\"none\" stroke-linecap=\"round\"\r\n");
      out.write("                         stroke-linejoin=\"round\" aria-hidden=\"true\">\r\n");
      out.write("                        <path stroke=\"none\" d=\"M0 0h24v24H0z\" fill=\"none\" />\r\n");
      out.write("                        <path d=\"M3 12m0 1a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v6a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1z\" />\r\n");
      out.write("                        <path d=\"M9 8m0 1a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v10a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1z\" />\r\n");
      out.write("                        <path d=\"M15 4m0 1a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v14a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1z\" />\r\n");
      out.write("                        <path d=\"M4 20l14 0\" />\r\n");
      out.write("                    </svg>\r\n");
      out.write("                    <span class=\"link hide\">Proyectos</span>\r\n");
      out.write("                    <span class=\"tooltip__content\">Market Overview</span>\r\n");
      out.write("                </a>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"sidebar__profile\">\r\n");
      out.write("        <div class=\"avatar__wrapper\">\r\n");
      out.write("            <img class=\"avatar\" src=\"imagenes/cibertec.jpg\" alt=\"Joe Doe Picture\">\r\n");
      out.write("            <div class=\"online__status\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"avatar__name hide\">\r\n");
      out.write("            <div class=\"user-name\">CIBERTEC</div>\r\n");
      out.write("            <div class=\"email\">cibertec.edu.pe</div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <a href=\"#logout\" class=\"logout hide\">\r\n");
      out.write("            <svg xmlns=\"http://www.w3.org/2000/svg\" class=\"icon icon-tabler icon-tabler-logout\" width=\"24\" height=\"24\"\r\n");
      out.write("                 viewBox=\"0 0 24 24\" stroke-width=\"2\" stroke=\"currentColor\" fill=\"none\" stroke-linecap=\"round\"\r\n");
      out.write("                 stroke-linejoin=\"round\" aria-labelledby=\"logout-icon\" role=\"img\">\r\n");
      out.write("                <title id=\"logout-icon\">log out</title>\r\n");
      out.write("                <path stroke=\"none\" d=\"M0 0h24v24H0z\" fill=\"none\"></path>\r\n");
      out.write("                <path d=\"M14 8v-2a2 2 0 0 0 -2 -2h-7a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h7a2 2 0 0 0 2 -2v-2\"></path>\r\n");
      out.write("                <path d=\"M9 12h12l-3 -3\"></path>\r\n");
      out.write("                <path d=\"M18 15l3 -3\"></path>\r\n");
      out.write("            </svg>\r\n");
      out.write("        </a>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("<div id=\"main-content\"></div>\r\n");
      out.write("\n");
      out.write("<div id=\"main-content\">\n");
      out.write("    <!-- Todo el contenido dinámico irá aquí -->\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("  <script src=\"js/script.js\"></script>\r\n");
      out.write("<script src=\"js/sidebarasync.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}