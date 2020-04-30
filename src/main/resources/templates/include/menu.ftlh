<div class="d-flex flex-column flex-md-row align-items-center p-2 px-md-3 mb-2 bg-white border-bottom shadow-sm">
    <img src="/images/hanger.png" class="img-fluid">
    <h2 class="my-0 mr-md-auto font-weight-normal" href="/home">Dress Up</h2>
    <nav class="my-2 my-md-0 mr-md-3">

        <#if current_user??>
            <a class="text-primary" href="/profile">Hello, ${current_user.getNickname()}</a>
            <a class="p-2 text-dark" href="/logout">Log out</a>
        </#if>

        <c#if current_user.nickname == 'admin'>
            <a class="btn btn-outline-danger" href="/admin">Admin page</a>
        </#if>

        <#if current_user == null??>
            <a class="btn btn-outline-success m-1" href="/signin">Sign in</a>
            <a class="btn btn-outline-primary" href="/signup">Sign up</a>
        </#if>
    </nav>
    <form class="form-inline ">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
</div>