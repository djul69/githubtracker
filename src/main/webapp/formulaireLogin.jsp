<%--
  Created by IntelliJ IDEA.
  User: djul
  Date: 09/07/18
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

    <jsp:include page="WEB-INF/header.jsp"/>

<body class = "text-success">
<div class="form-group">
    <form action="track" method=POST>
        <label>Votre login github?</label><br><input name="login" type="text"><br>
        <input type="submit" value="Envoyer le formumlaire">
    </form>
</div>
</body>
</html>