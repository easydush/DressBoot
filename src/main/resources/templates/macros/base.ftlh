<#assign  security=JspTaglibs["http://www.springframework.org/security/tags"] />

<#macro page_title>
    <title>Page title!</title>
</#macro>
<#macro style_block>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default.ftlh header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
</#macro>

<#macro page_body>
    <h1>Basic Page</h1>
    <p>This is the body of the page!</p>
</#macro>

<#macro header>
    <header>
        <div class="d-flex flex-column flex-md-row align-items-center p-2 px-md-3 mb-2 bg-white border-bottom shadow-sm">
            <img src="/images/hanger.png" class="img-fluid" alt="hanger" href="/">
            <h2 class="my-0 mr-md-auto font-weight-normal" href="/">Dress Up</h2>
            <nav class="my-2 my-md-0 mr-md-3">
                <@security.authorize access="isAuthenticated()">
                    <a href="/profile/looks/create" class="btn mr-2 btn-outline-success">Create look</a>
                    <a href="/profile" class="mr-2"><@security.authentication property="principal.username" /></a>
                    <a href="/logout">Log out</a>
                </@security.authorize>
                <@security.authorize access="! isAuthenticated()">
                    <a href="/login" class="mr-2">Login</a>
                    <a href="/signup">Sign Up</a>
                </@security.authorize>
            </nav>
            <form class="form-inline ">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

    <div class="container" style="margin-top: 4em;">
        <@page_body/>
    </div>

    </body>
    </html>
</#macro>