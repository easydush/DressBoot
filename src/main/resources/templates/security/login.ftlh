
<#include "../macros/base.ftlh">

<#macro page_title>
    <title>Login page</title>
</#macro>

<#macro page_body>
    <div class="col-6 offset-3">
        <form action="/login" method="post">
            <div class="form-group">
                <label for="usernameInput">Username</label>
                <input class="form-control" name="username" placeholder="Username" id="usernameInput">
            </div>
            <div class="form-group">
                <label for="passwordInput">Password</label>
                <input class="form-control" type="password" name="password" placeholder="Password" id="passwordInput">
            </div>
            <div class="form-group">
                <input class="form-control" type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            </div>
            <input class="btn btn-primary" type="submit" value="Log in">
        </form>
        <p> Login from VK: <a href="${vkLogin}">click here</a></p>


    </div>
</#macro>

<@display_page/>