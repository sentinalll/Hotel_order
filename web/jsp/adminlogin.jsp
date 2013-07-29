<%@ page pageEncoding="UTF-8" %>
<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="#">${currentLanguage.getString("hotel")}</a>

        <ul class="nav pull-right ">
            <li ><a href="./controller?command={localeEN}">EN</a></li>
            <li ><a href="./controller?command={localeRU}">РУС</a></li>

        </ul>
    </div>
</div>

<div class="container" >
    <div class="row" >
        <div class="span4 offset4 well">
            <legend>${currentLanguage.getString("admin_login")}</legend>
             <form method="POST" action="controller" accept-charset="UTF-8">
                <input type="text" id="email" class="span4" name="email" placeholder="${currentLanguage.getString("login")}">
                <input type="password" id="password" class="span4" name="password" placeholder="${currentLanguage.getString("password")}">
                <button type="submit" name="command" value="{adminLogin}" class="btn btn-info btn-block">${currentLanguage.getString("signin")}</button>
            </form>    
        </div>
    </div>
</div>