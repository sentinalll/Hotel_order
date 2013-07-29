<%@ page import="Utility.Order,  
         java.util.ArrayList"%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix ="m" uri ="tlds/dateTag.tld"  %> 
<jsp:useBean id="allclients" scope="session" class="java.util.ArrayList" />
<jsp:useBean id="order" scope="session" class="Utility.Order" />
<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="#">${currentLanguage.getString("hotel")}</a>
        <ul class="nav">
            <li class="divider-vertical"></li>
            <li ><a href="./controller?command={newOrderAdmin}">${currentLanguage.getString("new_order")}</a></li>
            <li class="divider-vertical"></li>
            <li ><a  href="./controller?command={archivedOrderAdmin}">${currentLanguage.getString("archived")}</a></li>
            <li class="divider-vertical"></li>
            <li><a  href="./controller?command={paidOrderAdmin}">${currentLanguage.getString("paid_order")}</a></li>
            <li class="divider-vertical"></li>
            <li class="active"><a  href="./controller?command={allclients}">${currentLanguage.getString("all_clients")}</a></li>
            <li class="divider-vertical"></li>
            <li><a  href="./controller?command={allroom}">${currentLanguage.getString("all_rooms")}</a></li>
        </ul>
        <ul class="nav pull-right ">
            <li ><a href="./controller?command={localeEN}">EN</a></li>
            <li ><a href="./controller?command={localeRU}">РУС</a></li>
            <li ><a href="#">${sessionScope.admin}</a></li>
            <li class="divider-vertical"></li>
            <li><a  href="./controller?command={signOutAdmin}">${currentLanguage.getString("signout")}</a></li>
        </ul>
    </div>
</div>
<div class="conteiner">         
    <div class="row" >
        <div class="span13 offset0 well">
            <table class="table">  
                <thead>  
                    <tr>
                        <th>#</th> 
                        <th>${currentLanguage.getString("client_id")}</th> 
                        <th>${currentLanguage.getString("name")}</th> 
                        <th>${currentLanguage.getString("surname")}</th> 
                        <th>${currentLanguage.getString("email")}</th> 
                        <th>${currentLanguage.getString("telephone")}</th> 
                        <th>${currentLanguage.getString("date_created")}</th> 
                    </tr>  
                </thead>  
                <tbody> 
                    <c:set var="bid" value="${0}"/>
                    <c:forEach  items="${allclients.iterator()}" var="order" >
                        <c:set var="bid" value="${bid+1}"/>
                        <tr>  
                            <td>${bid}</td> 
                            <td>${order.clientsId}</td> 
                            <td>${order.name}</td>  
                            <td>${order.surname}</td>  
                            <td>${order.email}</td>  
                            <td>${order.tel}</td>  
                            <td><m:datetag>${order.dateFrom}</m:datetag></td>
                        </tr>  
                    </c:forEach>  
                </tbody>  
            </table> 
        </div>
    </div>
</div>