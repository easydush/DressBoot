<#import "/spring.ftl" as spring />

<#include "../macros/base.ftlh">

<#macro page_title>
    <title>${user.username}'s items</title>
</#macro>

<#macro page_body>
    <div class="col-6 offset-3">
        <h1>My items</h1>
        <a href="/profile/items/create">Create new item</a>
        <br/>
        <table id="itemsTable" class="timeline">
            <#if items??>
                <#list items as item>
                    <td>
                        <tr class="timeline-item">
                            <i><b>${item.name}</b></i>
                        </tr>
                        <tr class="timeline-item">
                            ${item.brand.name}
                        </tr>
                        <tr class="timeline-item">
                            ${item.description}
                        </tr>

                        <img class="sitelink_arrow" src="${item.image_url}" alt="item_image"/>

                    </td>
                    <br/>
                </#list>
            <#else>
                <h4>No Items Available</h4>
            </#if>
    </div>

</#macro>

<@display_page/>