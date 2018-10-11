<%--
  Created by IntelliJ IDEA.
  User: djul
  Date: 09/07/18
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="header.jsp"/>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<body class = "text-success">
<h3  style ="text-align: center">Les githubers :</h3>
<br>
<div class="form-group">
    <form action="UnTrack" method=POST>
        <label>L'ID du githuber à supprimer?</label><br><input name="id_githuber" type="text"><br>
        <input type="submit" value="UnTrack">
    </form>
</div>
<div class = "text-center text-info">
<c:forEach items = "${myList}" var = "item"  varStatus="status">
        <ul class="list-group">
            <li >id : <c:out value="${item.id}"/></li>
            <li >name : <c:out value="${item.name}"/></li>
            <li >login : <c:out value="${item.login}"/></li>
            <li >url : <c:out value="${item.url}"/></li>
            <li >email : <c:out value="${item.email}"/></li>
            <li >bio : <c:out value="${item.bio}"/></li>
            <li >location : <c:out value="${item.location}"/></li>
            <li ><img src="${item.avatar}" width="5%" alt=""/></li>
        </ul>
        <div>
            <hr align="center" width="10%" style="border:1px solid #277b06">
        </div>
</c:forEach>
</div>
</body>
</html>
