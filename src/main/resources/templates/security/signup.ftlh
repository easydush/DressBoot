<#import "/spring.ftl" as spring />

<#include "../macros/base.ftlh">

<#macro page_title>
    <title>Sign Up</title>
</#macro>

<#macro page_body>
    <div class="col-6 offset-3">
        <@spring.bind path= "form" />
        <#if form?? && noErrors??>
            Welcome, ${form.username}!<br>
        <#else>
            <form method="post">
                <div class="form-group">
                    <label>Username:</label>
                    <@spring.formInput "form.username" "class='form-control'"/>
                    <div class="text-danger">
                        <@spring.showErrors "<br>"/>
                    </div>
                    <div class="text-danger username-error">
                        Current user already exist
                    </div>
                </div>
                <div class="form-group">
                    <label>Full Name:</label>
                    <@spring.formInput "form.fullName" "class='form-control'"/>
                    <div class="text-danger">
                        <@spring.showErrors "<br>"/>
                    </div>
                </div>

                <div class="form-group">
                    <label>Password:</label>
                    <@spring.formPasswordInput  "form.password" "class='form-control'"/>
                    <div class="text-danger">
                        <@spring.showErrors "<br>"/>
                    </div>
                </div>
                <div class="form-group">
                    <label>Password repeat:</label>
                    <@spring.formPasswordInput  "form.passwordRepeat" "class='form-control'"/>
                    <div class="text-danger">
                        <@spring.showErrors "<br>"/>
                    </div>
                </div>

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <input type="submit" class="btn btn-success" value="Confirm">
            </form>
        </#if>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script>

        $(document).ready(function () {
            let token = $("meta[name='_csrf']").attr("content");
            let header = $("meta[name='_csrf_header']").attr("content");
            let usernameError = $('.username-error');
            usernameError.hide();
            $(document).ajaxSend(function (e, xhr, options) {
                xhr.setRequestHeader(header, token);
            });
            const MIN_USERNAME_LENGTH = 6;
            $("#username").blur(function () {
                let value = $("#username").val();
                let valueLen = value.length;
                if (valueLen >= MIN_USERNAME_LENGTH) {
                    $.ajax({
                        url: "/users/checkUsername",
                        type: "POST",
                        dataType: 'json',
                        data: {
                            "username": value
                        },
                        success: function (data) {
                            let usernameError = $('.username-error');
                            if (data) {
                                usernameError.show();
                            } else {
                                usernameError.hide();
                            }
                        }

                    });

                }

            });
        });


    </script>
</#macro>

<@display_page/>