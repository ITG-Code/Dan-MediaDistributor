<%@page import="se.definewild.mediadist.db.Subscribers"%>
<%@taglib uri="/WEB-INF/tags.tld" prefix="tag" %>
<%
  if (session.getAttribute("subscriber") == null) {
    response.sendRedirect("?p=main");
    out.println("<script>document.location=\"?p=main\";</script>");
    return;
  }
  Subscribers subscriber = (Subscribers) session.getAttribute("subscriber");
%>
<form action="addsubscription" method="POST" id="addsubscription">
    <table>
        <tr><td>Media</td><td><tag:Media name="media" title="Select media" value="-1"></tag:Media></td></tr>
        <tr><td>Address</td><td><input type="text" name="address" placeholder="Samplestreet 123" value="<%=subscriber.getAddress().getAddress()%>"></td></tr>
        <tr><td>Zipcode</td><td><input type="text" name="zipcode" placeholder="12345" value="<%=subscriber.getAddress().getZipcode()%>"></td></tr>
        <tr><td>City</td><td><input type="text" name="city" placeholder="City" value="<%=subscriber.getAddress().getCity()%>"></td></tr>
        <tr><td></td><td><input type="submit" name="submit" value="Register"></td></tr>
    </table>
</form>
<pre id="addsubscription_status"></pre>