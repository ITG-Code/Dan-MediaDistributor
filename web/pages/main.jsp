<h1>Subscriber login</h1>
<%
  if (session.getAttribute("subscriber") != null) {
    response.sendRedirect("?p=subscriber/manage");
    out.println("<script>document.location=\"?p=subscriber/manage\";</script>");
    return;
  }
%>
<form action="loginsubscriber" method="POST" id="loginsubscriber">
    <table>
        <tr><td>Username</td><td><input type="text" name="username" placeholder="Username"></td></tr>
        <tr><td>Password</td><td><input type="password" name="password" placeholder="Password"></td></tr>
        <tr><td></td><td><input type="submit" name="submit" value="Login"></td></tr>
        <tr><td></td><td><button class="register" onclick="document.location='?p=subscriber/register';">Register</button></td></tr>
    </table>
</form>
<pre id="logoutsubscriber_status"></pre>