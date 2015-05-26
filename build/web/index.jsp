<%@page import="se.definewild.mediadist.bean.Helper"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.io.PrintStream"%>
<%@page import="java.io.StringWriter"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="md" uri="/WEB-INF/tags.tld" %>
<%
  String base = request.getParameter("p");
  String url;
  if (base == null)
    base = "main";

  url = "pages/" + base + ".jsp";
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=base.replace("/", " - ")%> - MediaDistributor</title>
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <script type="text/javascript" src="js/prototype-1.7.2.js"></script>
        <%
          for (String part : Helper.BaseSplitter(base)) {
            if (!Helper.FileExists("js/"+part+".js"))
                continue;
        %>
        <script type="text/javascript" src="js<%=part%>.js"></script>
        <%
          }
          if (base != "main") {
        %>
        <script type="text/javascript" src="js/main.js"></script>
        <%
          }
        %>
    </head>
    <body>
        <header>
            <nav role="main">
                <a class="logo" href="./" title="">MediaDistributor<span class="beta">Alpha</span></a>
            </nav>
        </header>
        <div class="content">
            <%
              try {
                pageContext.include(url, false);
              } catch (Exception t) {
            %>
            <h1>Error</h1>
            <pre>
                <%
                  ByteArrayOutputStream os = new ByteArrayOutputStream();
                  PrintStream ps = new PrintStream(os);
                  t.printStackTrace(ps);
                  t.printStackTrace();
                  out.println(os.toString("UTF8"));

                %>
            </pre>
            <%
              }
            %>
        </div>
        <footer>
            <div class="left">Copyright &copy; Dan Printzell 2015</div>
            <div class="center">
                Version: 0.0.1-ALPHA
                <a href="?p=staff/login">Staff</a>
            </div>
            <div class="right">
                <span>Powered by:</span>
                <a href="https://nodejs.org/">
                    <span class="icon-code">X</span>
                    <span class="popup">NodeJS<br/><span class="arrow"></span></span>
                </a>
                <a href="http://socket.io/">
                    <span class="icon-code">X</span>
                    <span class="popup">SocketIO<br/><span class="arrow"></span></span>
                </a>
                <a href="http://icomoon.io">
                    <span class="icon-IcoMoon">X</span>
                    <span class="popup">IcoMoon<br/><span class="arrow"></span></span>
                </a>
                <a href="http://lesscss.org">
                    <span class="icon-code">X</span>
                    <span class="popup">Less<br/><span class="arrow"></span></span>
                </a>
            </div>
        </footer>
    </body>
</html>
