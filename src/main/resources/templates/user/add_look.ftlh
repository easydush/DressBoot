<#import "/spring.ftl" as spring />

<#include "../macros/base.ftlh">

<#macro page_title>
    <title>${user.username}'s looks</title>
</#macro>

<#macro page_body>
    <h3>Add new look</h3>
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

        <#--<div class="form-group">
            <label>Choose items:</label>
            <@spring.formMultiSelect  "form.items" "class='form-control'"/>
            <div class="text-danger">
                <@spring.showErrors "<br>"/>
            </div>
            <select multiple size="2">
                <#if items??>
                    <#list items as item>
                        <option>${item.name}</option>
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