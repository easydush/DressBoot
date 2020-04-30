<#import "/spring.ftl" as spring />

<#include "../macros/base.ftlh">

<#macro page_title>
    <title>${user.username}'s looks</title>
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
            <@spring.formTextarea "form.description" "class='form-control'"/>
            <div class="text-danger">
                <@spring.showErrors "<br>"/>
            </div>
        </div>

        <div class="form-group">
            <label>Image URL:</label>
            <@spring.formInput "form.image_url" "class='form-control'"/>
            <div class="text-danger">
                <@spring.showErrors "<br>"/>
            </div>
        </div>

        <#--<div class="form-group">
            <label>Choose items:</label>
            <@spring.formSingleSelect  "form.brand" "class='form-control'"/>
            <div class="text-danger">
                <@spring.showErrors "<br>"/>
            </div>
            <label for="brand">Choose a brand:</label><select id="brand" size="3">
                <#if brands??>
                    <#list brands as brand>
                        <option>${brand.name}</option>
                    </#list>
                </#if>
            </select>
        </div>-->
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input type="submit" class="btn btn-success" value="Confirm">
    </form>

    </div>

</#macro>

<@display_page/>