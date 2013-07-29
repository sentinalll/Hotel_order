<%@ page import="Utility.Order,  
         java.util.ArrayList"%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix ="m" uri ="tlds/dateTag.tld"  %> 
<jsp:useBean id="allorder" scope="session" class="java.util.ArrayList" />
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
            <li class="active"><a  href="./controller?command={paidOrderAdmin}">${currentLanguage.getString("paid_order")}</a></li>
            <li class="divider-vertical"></li>
            <li ><a  href="./controller?command={allclients}">${currentLanguage.getString("all_clients")}</a></li>
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
                        <th>${currentLanguage.getString("order_id")}</th> 
                        <th>${currentLanguage.getString("client_id")}</th> 
                        <th>${currentLanguage.getString("beds")}</th> 
                        <th>${currentLanguage.getString("star")}</th> 
                        <th>${currentLanguage.getString("datefrom")}</th> 
                        <th>${currentLanguage.getString("dateto")}</th> 
                        <th>${currentLanguage.getString("status")}</th> 
                        <th>${currentLanguage.getString("apartment_id")}</th> 
                        <th>${currentLanguage.getString("summary")}</th> 
                        <th>${currentLanguage.getString("paid")}</th> 
                        <th>${currentLanguage.getString("show_user")}</th> 

                    </tr>  
                </thead>  
                <tbody> 
                    <c:set var="bid" value="${0}"/>
                    <c:forEach  items="${allorder.iterator()}" var="order" >
                        <c:if test="${order.paid eq 'yes'}">
                            <c:set var="bid" value="${bid+1}"/>
                            <tr>  
                                <td>${bid}</td> 
                                <td>${order.orderId}</td>  
                                <td>${order.clientsId}</td>  
                                <td>${order.roomBeds}</td>  
                                <td>${order.roomStar}</td>  
                                <td><m:datetag>${order.dateFrom}</m:datetag></td>
                                <td><m:datetag>${order.dateTo}</m:datetag></td>
                                <td>${currentLanguage.getString(order.status)}</td>  
                                <td>${order.apartmentId}</td>  
                                <td>${order.summary}</td>  
                               <td>${currentLanguage.getString(order.paid)}</td>  
                               <td>${currentLanguage.getString(order.showUser)}</td>  

                            </tr> 
                        </c:if>
                    </c:forEach>  
                </tbody>  
            </table> 
        </div>
    </div>
</div>