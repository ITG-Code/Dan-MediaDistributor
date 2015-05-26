<%@taglib uri="/WEB-INF/tags.tld" prefix="tag" %>
<form action="registerstaff" method="POST" id="registerstaff">
    <table>
        <tr><td>Firstname</td><td><input type="text" name="firstname" placeholder="Firstname"></td></tr>
        <tr><td>Lastname</td><td><input type="text" name="lastname" placeholder="Lastname"></td></tr>
        <tr><td>Distric</td><td><tag:Districts name="district" title="Select district" value="-1"></tag:Districts></td></tr>
        <tr><td>Email</td><td><input type="email" name="email" placeholder="me@mail.com"></td></tr>
        <tr><td>Password</td><td><input type="password" name="password" placeholder="Password"></td></tr>
        <tr><td></td><td><input type="submit" name="submit" value="Register"></td></tr>
    </table>
</form>