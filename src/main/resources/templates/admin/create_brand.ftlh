<#import "/spring.ftl" as spring />

<#include "../macros/base.ftlh">

<#macro page_title>
    <title>Add brand</title>
</#macro>

<#macro page_body>
    <form method="post">
        <div class="form-group">
            <label>Title:</label>
            <@spring.formInput "form.name" "class='form-control'"/>
            <div class="text-danger">
                <@spring.showErrors "<br>"/>
            </div>
        </div>
        <div class="form-group">
            <label>Description:</label>
            <@spring.formInput "form.description" "class='form-control'"/>
            <div class="text-danger">
                <@spring.showErrors "<br>"/>
            </div>
        </div>
        <div class="form-group">
            <label>Logo URL:</label>
            <@spring.formInput "form.logoUrl" "class='form-control'"/>
            <div class="text-danger">
                <@spring.showErrors "<br>"/>
            </div>
        </div>



        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input type="submit" class="btn btn-success" value="Confirm">
    </form>

    </div>

</#macro>

<@display_page/>