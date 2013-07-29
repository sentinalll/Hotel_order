<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8"  import="java.util.Locale,
         java.util.ResourceBundle"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <title>Hotel</title>
    </head>
    <body>
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
       
            <%
                session.setAttribute("currentPage", "jsp/adminlogin.jsp");
            %>
       
        <c:if test="${requestScope.page eq null}">
            <c:set var="page" value="jsp/adminlogin.jsp" scope="request"/>  
        </c:if>
        
        <jsp:include page="${requestScope.page}" /> 
    </body>
</html>
