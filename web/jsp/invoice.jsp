<%@ page import="Utility.Order "%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix ="m" uri ="tlds/dateTag.tld"  %> 
<jsp:useBean id="invoice" scope="session" class="Utility.Order" />
<!DOCTYPE html>
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

<table width="30%" border="3">
    <tr valign="top">
        <td width="40%"><b>${currentLanguage.getString("payer")} : </b></td>
        <td>${invoice.name} ${invoice.surname} </td>
    </tr>
    <tr valign="top">
        <td><b>${currentLanguage.getString("recipient")} : </b></td>
        <td>Hotel</td>
    </tr>
    <tr valign="top">
        <td><b>${currentLanguage.getString("payment")}: </b></td>
        <td>${currentLanguage.getString("for_living")}</td>
    </tr>
    <tr valign="top">
        <td><b>${currentLanguage.getString("datefrom")} : </b></td>
        <td><m:datetag>${invoice.dateFrom}</m:datetag></td>
    </tr>
    <tr valign="top">
        <td><b>${currentLanguage.getString("dateto")} : </b></td>
    <td><m:datetag>${invoice.dateTo}</m:datetag></td>
    </tr>
    <tr valign="top">
        <td><b>${currentLanguage.getString("number")} №${invoice.hotelNumber} </b></td>
        <td>${invoice.roomStar}<i class="icon-star"></i> </td>
    </tr>
    <tr valign="top">
        <td><b>${currentLanguage.getString("beds")} : </b></td>
        <td>${invoice.roomBeds} </td>
    </tr>
    <tr valign="top">
        <td><b>${currentLanguage.getString("summary")} :</b></td>
        <td>${invoice.summary}</td>
    </tr>
</table>



<form class="form-horizontal" method="POST" action="controller">
    <input type="hidden" name="order_id" value="${invoice.orderId}"/>
    <button id="invoice" name="command" value="{paid}" type="submit" class="btn btn-default">${currentLanguage.getString("pay")}</button>
</form>