<%@ page import="Utility.Order,  
         java.util.ArrayList,
         java.util.ResourceBundle"%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix ="m" uri ="tlds/dateTag.tld"  %> 
<jsp:useBean id="history" scope="session" class="java.util.ArrayList" />
<jsp:useBean id="order" scope="session" class="Utility.Order" />

<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="#">${currentLanguage.getString("hotel")}</a>
        <ul class="nav">
            <li class="divider-vertical"></li>
            <li class="active"><a href="./controller?command={userHistory}">${currentLanguage.getString("order_history")}</a></li>
            <li class="divider-vertical"></li>
            <li><a  href="./controller?command={leaveOrderpage}">${currentLanguage.getString("leave_order")}</a></li>
        </ul>
        <ul class="nav pull-right ">
            
            <li ><a href="./controller?command={localeEN}">EN</a></li>
            <li ><a href="./controller?command={localeRU}">РУС</a></li>
            <li ><a href="#">${sessionScope.user}</a></li>
            <li class="divider-vertical"></li>
            <li><a  href="./controller?command={signOutUser}">${currentLanguage.getString("signout")}</a></li>
        </ul>
    </div>
</div>


<div class="conteiner">         
    <div class="row" >
        <p class="lead offset8">${currentLanguage.getString("order_history")}</p>
        <br/>
        <div class="span12 offset3 well">
            <table class="table">  
                <thead>  
                    <tr>
                        <th>#</th> 
                        <th>${currentLanguage.getString("beds")}</th> 
                        <th>${currentLanguage.getString("star")}</th> 
                        <th>${currentLanguage.getString("datefrom")}</th>  
                        <th>${currentLanguage.getString("dateto")}</th>  
                        <th>${currentLanguage.getString("status")}</th>  
                        <th>${currentLanguage.getString("paid")}</th>  
                        <th>${currentLanguage.getString("remove")}</th>  
                        <th>${currentLanguage.getString("invoice")}</th> 
                    </tr>  
                </thead>  
                <tbody> 
                    <c:set var="bid" value="${0}"/>
                    <c:forEach  items="${history.iterator()}" var="order" >
                        <c:set var="bid" value="${bid+1}"/>
                        <tr>  
                            <td>${bid}</td> 
                            <td>${order.roomBeds}</td>  
                            <td>${order.roomStar}</td>  
                            <td><m:datetag>${order.dateFrom}</m:datetag></td>
                            <td><m:datetag>${order.dateTo}</m:datetag></td>
                            <td>${currentLanguage.getString(order.status)}</td>  
                            <td>${currentLanguage.getString(order.paid)}</td>  
                            <td><a href="./controller?command={removeThis}&order=${order.orderId}"><i class="icon-remove-sign"></i></a>
                            <td>
                                <c:if test="${order.status eq 'assigned' }"   >
                                    <c:if test="${order.paid eq 'no' }"   >
                                        <form class="form-horizontal" method="GET" action="controller">
                                            <input type="hidden" name="order_id" value="${order.orderId}"/>
                                            <button id="invoice" name="command" value="{takeInvoice}" type="submit" class="btn btn-default">${currentLanguage.getString("invoice")}</button>
                                        </form>
                                    </c:if>       
                                </c:if>
                            </td>
                        </tr>  
                    </c:forEach>  
                </tbody>  
            </table> 
        </div>
    </div>
</div>