<#import "/spring.ftl" as spring />

<#include "../macros/base.ftlh">

<#macro page_title>
    <title>${user.username}'s items</title>
</#macro>

<#macro page_body>
    <h3>Add new item</h3>
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

        <div class="form-group">
            <label for="brand_name">Choose a brand:</label>
            <select id="brand_name"  name="brand_name" size="1" required="required">
                <#if brands??>
                    <option value=null>-----</option>
                    <#list brands as brand>
                        <option value="${brand.name}">${brand.name}</option>
                    </#list>
                </#if>
            </select>
        </div>
        <div class="form-group">
            <label>Choose look:</label>
            <label for="look_id">Choose a look:</label>
            <select id="look_id" size="1" name="look_id">
                <option value=null>-----</option>
                <#if looks??>
                    <#list looks as look>
                        <option value="${look.id}">${look.name}</option>
                    </#list>
                </#if>
            </select>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input type="submit" class="btn btn-success" value="Confirm">
    </form>

    </div>

</#macro>

<@display_page/>