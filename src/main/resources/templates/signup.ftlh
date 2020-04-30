<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="include/header.ftlh" %>
<title>Sign Up</title>
</head>
<body>
<%@ include file="include/menu.ftlh" %>
<div class="container">
    <div class="row">
    <div class="col-lg-6 col-md-6 col-sm-12">
        <a href="${redirect_url}" title="Sign up from VK">Sign up from VK</a>
        <form class="form needs-validation" method="POST" action="/signup" novalidate>

            <div class="form-group">
                <label for="nickname">Nickname</label>
                <input type="text" class="form-control" id="nickname" name="nickname" aria-describedby="nameHelp" placeholder="Nickname" required>
                <div class="valid-feedback">
                    Sounds great!
                </div>
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Email" required>
                <div class="invalid-feedback">
                    Your email is incorrect!
                </div>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
                <div class="invalid-feedback">
                    Your password should be longer than 6 symbols.
                </div>
            </div>

            <div class="form-group">
                <label for="password_check">Repeat password</label>
                <input type="password" class="form-control" id="password_check" name="password_check" placeholder="password_check" required>
                <div class="invalid-feedback">
                    Repeat your password correctly.
                </div>
            </div>

            <div class="form-group">
                <input type="radio"  name="sex" value="female"> female
                <input type="radio"   name="sex" value="male"> male
            </div>

            <div class="form-group">
                <label for="country">Country</label>
                <input type="text" class="form-control" id="country" name="country" placeholder="country" required>
            </div>

            <div class="form-group">
                <label for="about_me">About me</label>
                <textarea type="text" class="form-control" id="about_me" name="about_me" placeholder="about_me"></textarea>
            </div>

            <button type="submit" class="btn btn-primary">Register</button>
            <a class="create-acc" href="/signin">Sign in</a>
        </form>
        <c:if test="${!status.isEmpty()}">
            <c:if test="${status == 'true'}">
                <p class="text-success">User created successfully</p>
            </c:if>
            <c:if test="${status == 'false'}">
                <p class="text-danger">Cant create user</p>
            </c:if>
        </c:if>
    </div>
</div>
</div>
<script src="/resources/js/check.js"></script>
</body>
</html>