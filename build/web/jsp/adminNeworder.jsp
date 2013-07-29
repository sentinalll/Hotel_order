<%@ page import="Utility.Order,  
         java.util.ArrayList,
         Utility.Apartment,
         java.util.HashMap;"%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix ="m" uri ="tlds/dateTag.tld"  %> 

<jsp:useBean id="neworderadmin" scope="session" class="java.util.ArrayList" />
<jsp:useBean id="compatAp" scope="session"  class="java.util.HashMap" type="java.util.Map<String,ArrayList<Apartment>>"  />
<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="#">${currentLanguage.getString("hotel")}</a>
        <ul class="nav">
            <li class="divider-vertical"></li>
            <li class="active"><a href="./controller?command={newOrderAdmin}">${currentLanguage.getString("new_order")}</a></li>
            <li class="divider-vertical"></li>
            <li><a href="./controller?command={archivedOrderAdmin}">${currentLanguage.getString("archived")}</a></li>
            <li class="divider-vertical"></li>
            <li><a  href="./controller?command={paidOrderAdmin}">${currentLanguage.getString("paid_order")}</a></li>
            <li class="divider-vertical"></li>
            <li><a  href="./controller?command={allclients}">${currentLanguage.getString("all_clients")}</a></li>
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
        <div class="span15 offset0 well">
            <table class="table" >  
                <thead>  
                    <tr>
                        <th>#</th> 
                        <th>${currentLanguage.getString("order_id")}</th> 
                        <th>${currentLanguage.getString("client_id")}</th>  
                        <th>${currentLanguage.getString("datefrom")}</th>  
                        <th>${currentLanguage.getString("dateto")}</th>  
                        <th>${currentLanguage.getString("beds")}</th>  
                        <th>${currentLanguage.getString("star")}</th>  
                        <th>${currentLanguage.getString("status")}</th>  
                        <th>${currentLanguage.getString("compatible_ap")}</th>  
                    </tr>  
                </thead>  
                <tbody> 
                    <c:set var="bid" value="${0}"/>
                    <c:forEach  items="${neworderadmin.iterator()}" var="order" >
                        <c:if test="${order.showUser eq true}">
                            <c:set var="bid" value="${bid+1}"/>
                            <tr>  
                                <td>${bid}</td> 
                                <td>${order.orderId}</td>  
                                <td>${order.clientsId}</td>  
                                <td><m:datetag>${order.dateFrom}</m:datetag></td>
                                <td><m:datetag>${order.dateTo}</m:datetag></td>
                                <td>${order.roomBeds}</td>
                                <td>${order.roomStar}</td>
                                <td>${order.status}</td>

                                <td>

                                    <form class="form-horizontal" method="GET" action="controller">
                                        <input type="hidden" name="order_id" value="${order.orderId}"/>
                                        <select id="selectAp" name="selectAp" class="input-large">
                                            <c:if test="${compatAp.get(order.orderId).size() eq 0}">
                                                <option  value="${order.orderId}" >No compatible rooms</option>
                                            </c:if>
                                            <c:forEach  items="${compatAp.get(order.orderId).iterator()}" var="apartment" > 
                                                <c:if test="${compatAp.get(order.orderId).size() ne 0}">
                                                    <option  value="${apartment.id}" > ${currentLanguage.getString("number")} =  ${apartment.name}/${currentLanguage.getString("beds")}= ${apartment.roomBeds}/${currentLanguage.getString("star")} = ${apartment.roomStar}/${currentLanguage.getString("price")} = ${apartment.price}$</option>
                                                </c:if>
                                            </c:forEach>  
                                        </select>
                                        <c:if test="${compatAp.get(order.orderId).size() ne 0}">
                                            <button id="accept-btn" name="command" value="{apartmentToOrderAccept}" type="submit" class="btn btn-default">${currentLanguage.getString("confirm")}</button>
                                            <button id="accept-btn" name="command" value="{apartmentToOrderDecline}" type="submit" class="btn btn-default">${currentLanguage.getString("denied")}</button>
                                        </c:if>
                                        <c:if test="${compatAp.get(order.orderId).size() eq 0}">
                                            <button id="accept-btn" name="command" value="{apartmentToOrderDecline}" type="submit" class="btn btn-default">${currentLanguage.getString("denied")}</button>
                                        </c:if>
                                    </form>
                                </td>
                            </tr>  
                        </c:if>
                    </c:forEach>  
                </tbody>  
            </table>
        </div>
    </div>
</div>