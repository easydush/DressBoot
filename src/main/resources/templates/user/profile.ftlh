<#import "/spring.ftl" as spring />

<#include "../macros/base.ftlh">

<#macro page_title>
    <title>${user.username}</title>
</#macro>

<#macro page_body>
    <div class="col-6 offset-3">
        <a href="/profile/looks">My looks</a>
        <a href="/profile/items">My items</a>
        <h4>One new image for you:</h4>
        <img src="${random_image_url}">
    </div>

</#macro>

<@display_page/>