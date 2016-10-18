<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- регистрируем JSTL теги -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Книги</title>
</head>
<body>
<h2>Книги</h2>
<table border="1">
    <!-- задаем таблицу для вывода -->
    <tr>
        <td><b>Название</b></td>
        <td><b>Автор</b></td>
    </tr>
    <!-- цикл для вывода всех элементов переданной коллекции -->
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${ent.author}"/></td>
            <td><c:out value="${ent.title}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
