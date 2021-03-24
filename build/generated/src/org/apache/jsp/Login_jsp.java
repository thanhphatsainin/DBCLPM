package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/login.css\">\n");
      out.write("    <title>Đăng Nhập</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"main\">\n");
      out.write("\n");
      out.write("        <form action=\"CheckLoginUser\" method=\"POST\" class=\"form\" id=\"form-1\">\n");
      out.write("          <h3 class=\"heading\">Đăng Nhập QLDT PTIT</h3>\n");
      out.write("            <img src=\"/assets/image/Logo_PTIT.jpg\" alt=\"\" class=\"image\">\n");
      out.write("\n");
      out.write("<!--            \"/assets/image/Logo_PTIT.jpg\"-->\n");
      out.write("      \n");
      out.write("          <div class=\"spacer\"></div>\n");
      out.write("      \n");
      out.write("          <div class=\"form-group\">\n");
      out.write("            <label for=\"mgv\" class=\"form-label\">Mã giảng viên</label>\n");
      out.write("            <input id=\"mgv\" name=\"username\" type=\"text\" placeholder=\"VD: B17DCCN450\" class=\"form-control\" autofocus>\n");
      out.write("            <span class=\"form-message\"></span>\n");
      out.write("          </div>\n");
      out.write("      \n");
      out.write("          <div class=\"form-group\">\n");
      out.write("            <label for=\"password\" class=\"form-label\">Mật khẩu</label>\n");
      out.write("            <input id=\"password\" name=\"password\" type=\"password\" placeholder=\"Nhập mật khẩu\" class=\"form-control\">\n");
      out.write("            <span class=\"form-message\"></span>\n");
      out.write("          </div>\n");
      out.write("      \n");
      out.write("          <button class=\"form-submit\" type=\"submit\">Đăng Nhập</button>\n");
      out.write("        </form>\n");
      out.write("        <script src=\"/assets/JS/login.js\"></script>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("            // Mong muốn nhận được\n");
      out.write("            Validator({\n");
      out.write("                form: '#form-1',\n");
      out.write("                rules: [\n");
      out.write("                    Validator.isRequired('#mgv'),\n");
      out.write("                    Validator.isRequired('#password'),\n");
      out.write("                ],\n");
      out.write("//                onSubmit: function(data){\n");
      out.write("//\n");
      out.write("//                  console.log(data);\n");
      out.write("                  // nếu submit với JS thì ông lấy data ở đây\n");
      out.write("\n");
      out.write("                  // Nếu submit = form như bình thường thì cmt hàm này\n");
      out.write("//                }\n");
      out.write("            });\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("      </div>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
