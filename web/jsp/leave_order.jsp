<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="#">${currentLanguage.getString("hotel")}</a>
        <ul class="nav">
            <li class="divider-vertical"></li>
            <li ><a href="./controller?command={userHistory}">${currentLanguage.getString("order_history")}</a></li>
            <li class="divider-vertical"></li>
            <li class="active"><a  href="./controller?command={leaveOrderpage}">${currentLanguage.getString("leave_order")}</a></li>
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
        <div class="span6 offset5 well">
            <form class="form-horizontal" >
                <fieldset>
                    <!-- Form leave order -->
                    <center>  <legend>${currentLanguage.getString("leave_order")}</legend></center>
                    <!-- Select star -->
                   
                    <c:if test="${requestScope.isVisibleAlertLeaveOrder eq true}">
                        <div class="alert alert-error">
                            <a class="close" data-dismiss="alert" href="#">X</a>Please input correct all field
                        </div>
                    </c:if>
                    <div class="control-group">
                        <label class="control-label" for="star">${currentLanguage.getString("select_star")}</label>
                        <div class="controls">
                            <select id="star" name="star" class="input-medium">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>
                    </div>

                    <!-- Select beds -->

                    <div class="control-group">
                        <label class="control-label" for="beds">${currentLanguage.getString("select_beds")}</label>
                        <div class="controls">
                            <select id="beds" name="beds" class="input-medium">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                        </div>
                    </div>

                    <!-- Date from input-->
                    <div class="control-group">
                        <label class="control-label" for="datefrom">${currentLanguage.getString("datefrom")}</label>
                        <div class="controls">
                            <input type="date" id="datefrom" name="datefrom"  placeholder="" class="input-medium">

                        </div>
                    </div>

                    <!-- Date to input-->
                    <div class="control-group">
                        <label class="control-label" for="dateto">${currentLanguage.getString("dateto")}</label>
                        <div class="controls">
                            <input id="dateto" name="dateto" type="date" placeholder="" class="input-medium">
                        </div>
                    </div>

                    <!-- Button (Double) -->
                    <div class="control-group">
                        <label class="control-label" for="accept-btn"></label>
                        <div class="controls">
                            <button id="accept-btn" name="command" value="{leaveOrderAccept}" type="submit" class="btn btn-default">${currentLanguage.getString("accept")}</button>
                            <button id="decline-btn" name="command" value="{leaveOrderDecline}" type="submit" class="btn btn-default">${currentLanguage.getString("decline")}</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>
