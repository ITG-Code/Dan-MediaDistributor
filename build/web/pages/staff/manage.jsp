<%@page import="se.definewild.mediadist.db.Employees" %>
<%
  if (session.getAttribute("employee") == null) {
    response.sendRedirect("?p=staff/login");
    out.println("<script>document.location=\"?p=staff/login\";</script>");
    return;
  }
  Employees employee = (Employees) session.getAttribute("employee");
%>
<div id="toolbar">
    <a href="?p=staff/manage">Home</a>
    <a href="?p=staff/register">Add Staff</a>
    <a href="?p=staff/todeliver">To deliver</a>
</div>

<div id="subscribers">
    <h1>Place use the menu to do what you want</h1>
</div>

<div id="loggedin">
    <h1>Logged in as <%=employee.getFname() + " " + employee.getLname()%></h1>
    <form action="logoutstaff" method="POST" id="logoutstaff">
        <table>
            <tr><td></td><td><input type="submit" name="submit" value="Logout"></td></tr>
        </table>
    </form>
    <pre id="logoutstaff_status"></pre>
</div>