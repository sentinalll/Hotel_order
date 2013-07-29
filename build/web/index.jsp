<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.Locale,
        java.util.ResourceBundle"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Отель</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    </head>
    <body>
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>

        <c:if test="${sessionScope.currentLanguage eq null}">
        <%
            ResourceBundle currentLanguage = ResourceBundle.getBundle("ua.epam.properties.locale.language",Locale.getDefault());
            session.setAttribute("currentLanguage", currentLanguage);
            session.setAttribute("currentPage", "jsp/login.jsp");
        %>
        </c:if>
        <c:if test="${requestScope.page eq null}">
            <c:set var="page" value="jsp/login.jsp" scope="request"/>  
        </c:if>
        <jsp:include page="${requestScope.page}" /> 

    </body>
</html>