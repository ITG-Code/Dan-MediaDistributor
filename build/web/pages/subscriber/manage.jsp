<%@page import="se.definewild.mediadist.bean.Helper"%>
<%@page import="se.definewild.mediadist.db.Subscriptions"%>
<%@page import="java.util.List"%>
<%@page import="se.definewild.mediadist.db.Subscribers" %>
<%@page import="se.definewild.mediadist.db.Media" %>
<%
  if (session.getAttribute("subscriber") == null) {
    response.sendRedirect("?p=main");
    out.println("<script>document.location=\"?p=main\";</script>");
    return;
  }
  Subscribers subscriber = (Subscribers) session.getAttribute("subscriber");
%>
<div id="toolbar">
    <a href="?p=subscriber/manage">Home</a>
    <a href="?p=subscriber/add">Add subscriptions</a>
    <a href="?p=subscriber/settings">Change settings</a>
</div>

<div id="subscriptions">
    <h1>Subscriptions</h1>
    <%
        List<Subscriptions> subscriptions = Helper.GetSubscriptions(Helper.RefreshObject(subscriber));
        for (Subscriptions sub : subscriptions) {
    %>
        <div class="subscription" x-id="<%=sub.getId()%>">
            <div class="name"><%=sub.getMedia().getName()%></div>
            <button class="cancel">Cancel</button>
        </div>
    <%
        }
    %>
</div>

<div id="loggedin">
    <h1>Logged in as <%=subscriber.getFname() + " " + subscriber.getLname()%></h1>
    <form action="logoutsubscriber" method="POST" id="logoutsubscriber">
        <table>
            <tr><td></td><td><input type="submit" name="submit" value="Logout"></td></tr>
        </table>
    </form>
    <pre id="logoutsubscriber_status"></pre>
</div>