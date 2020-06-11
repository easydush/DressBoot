
<#include "../macros/base.ftlh">

<#macro page_title>
    <title>Login page</title>
</#macro>

<#macro page_body>
    <div class="col-6 offset-3">
        <form action="/login" method="post">
            <#if error?? && error == "USER_NOT_FOUND">
                <div class="alert alert-danger" role="alert">
                    <h5>Wrong login or password</h5>
                </div>
            </#if>
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
        <div class="container unauthenticated">
            <div>
                Login from VK: <a href="${vkLogin}">click here</a>
            </div>
            <div>
                With Google: <a href="/oauth2/authorization/google">click here</a>
            </div>
        </div>


    </div>
</#macro>

<@display_page/>