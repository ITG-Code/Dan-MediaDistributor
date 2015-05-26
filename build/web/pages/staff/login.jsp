<%
  if (session.getAttribute("employee") != null) {
    response.sendRedirect("?p=staff/manage");
    out.println("<script>document.location=\"?p=staff/manage\";</script>");
    return;
  }
%>
<h1>Employee Login</h1>
<form action="loginstaff" method="POST" id="loginstaff">
    <table>
        <tr><td>Username</td><td><input type="text" name="username" placeholder="Username"></td></tr>
        <tr><td>Password</td><td><input type="password" name="password" placeholder="Password"></td></tr>
        <tr><td></td><td><input type="submit" name="submit" value="Login"></td></tr>
    </table>
</form>
<pre id="loginstaff_status"></pre>