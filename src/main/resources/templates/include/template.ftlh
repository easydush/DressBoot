<#assign  security=JspTaglibs["http://www.springframework.org/security/tags"] />

<#macro page_title>
    <title>Page title!</title>
</#macro>
<#macro style_block>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</#macro>

<#macro page_body>
    <h1>Basic Page</h1>
    <p>This is the body of the page!</p>
</#macro>

<#macro header>
    <header>

        <div class="header_pos d-flex flex-column flex-md-row fixed-top align-items-center p-2 px-md-3 mb-2 bg-white border-bottom shadow-sm">
            <a class="my-0 mr-md-auto navbar-brand text-dark" href="">Twitter</a>
            <nav class="my-2 my-md-0 mr-md-3">
                <@security.authorize access="isAuthenticated()">
                    <a href="/mylooks" class="btn mr-2 btn-outline-success">My looks</a>
                    <a href="/users/<@security.authentication property="principal.username" />" class="mr-2">My Profile
                        (<@security.authentication property="principal.username" />)</a>
                    <a href="/logout">Log out</a>
                </@security.authorize>
                <@security.authorize access="! isAuthenticated()">
                    <a href="/login" class="mr-2">Login</a>
                    <a href="/register">Register</a>
                </@security.authorize>
            </nav>
        </div>
        <meta name="_csrf" content="${_csrf.token}"/>
        <!-- default header name is X-CSRF-TOKEN -->
        <meta name="_csrf_header" content="${_csrf.headerName}"/>
    </header>
</#macro>

<#macro display_page>
    <!doctype html>
    <html>
    <head>
        <@style_block/>
        <@page_title/>
    </head>
    <body>
    <@header/>
    <div class="container" style="margin-top: 4em;">
        <@page_body/>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    </body>
    </html>
</#macro>