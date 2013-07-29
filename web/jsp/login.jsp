<%@ page import="java.util.ResourceBundle"%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="#">${currentLanguage.getString("hotel")}</a>
        <ul class="nav pull-right ">
            <li ><a href="./controller?command={localeEN}">EN</a></li>
            <li ><a href="./controller?command={localeRU}">РУС</a></li>
        </ul>
    </div>
</div>

<div class="conteiner">         
    <div class="row" >
        <div class="span6 offset1 well">
            <form class="form-horizontal" action="controller" method="POST">
                <fieldset>
                    <center><legend>${currentLanguage.getString("register")}</legend></center>
                        
                        <c:if test="${requestScope.isVisibleAlertReg eq true}">
                        <div class="alert alert-error">
                            <a class="close" data-dismiss="alert" href="#">X</a>Please input all field
                        </div>
                    </c:if>
                    <div class="control-group">
                        <label class="control-label" for="email">${currentLanguage.getString("email")}</label>
                        <div class="controls">
                            <input id="email" name="email" type="text" placeholder="example@domain.com" class="input-medium">
                            <c:if test="${requestScope.isEmailReg eq true}">
                                <p>User with this email has already registered</p>
                            </c:if>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="password">${currentLanguage.getString("password")}</label>
                        <div class="controls">
                            <input id="password" name="password" type="password" placeholder="" class="input-medium">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="name">${currentLanguage.getString("name")}</label>
                        <div class="controls">
                            <input id="name" name="name" type="text" placeholder="" class="input-medium">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="surname">${currentLanguage.getString("surname")}</label>
                        <div class="controls">
                            <input id="surname" name="surname" type="text" placeholder="" class="input-medium">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="tel">${currentLanguage.getString("telephone")}</label>
                        <div class="controls">
                            <input id="tel" name="tel" type="text" placeholder="+380-(XX)-XXX-XX-XX" class="input-medium">
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <button type="submit" id="accept-btn"  name="command" value="{register}Accept"  class="btn btn-default">${currentLanguage.getString("accept")}</button>
                            <button type="submit" id="decline-btn"  name="command" value="{register}Decline"  class="btn btn-default">${currentLanguage.getString("decline")}</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
        <div class="span4 offset4 well">
            <legend>${currentLanguage.getString("pleasesignin")}</legend>
            
            <c:if test="${requestScope.isVisibleAlertLoginUser eq true}">
                <div class="alert alert-error">
                    <a class="close" data-dismiss="alert" href="#">X</a>Incorrect login or password
                </div>
            </c:if>
            <form method="POST" action="controller" accept-charset="UTF-8">
                <input type="text" id="email" class="span4" name="email" placeholder="${currentLanguage.getString("email")}">
                <input type="password" id="password" class="span4" name="password" placeholder="${currentLanguage.getString("password")}">
                <button type="submit" name="command" value="{login}" class="btn btn-info btn-block">${currentLanguage.getString("signin")}</button>
            </form> 


        </div>
    </div>
</div>
