<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="#">${currentLanguage.getString("hotel")}</a>
        <ul class="nav">
            <li class="divider-vertical"></li>
            <li><a href="./controller?command={userHistory}">${currentLanguage.getString("order_history")}</a></li>
            <li class="divider-vertical"></li>
            <li><a  href="./controller?command={leaveOrderpage}">${currentLanguage.getString("leave_order")}</a></li>
        </ul>
        <ul class="nav pull-right ">
            <li ><a href="./controller?command={localeEN}">EN</a></li>
            <li ><a href="./controller?command={localeRU}">РУС</a></li>
            <li ><a href="#">${requestScope.user}</a></li>
            <li class="divider-vertical"></li>
            <li><a  href="./controller?command={signOutUser}">${currentLanguage.getString("signout")}</a></li>
        </ul>
    </div>
</div>

        <center><p>${currentLanguage.getString("order_accept")}</p></center>



