<#import "/spring.ftl" as spring />

<#include "../macros/base.ftlh">

<#macro page_title>
    <title>${user.username}'s looks</title>
</#macro>

<#macro page_body>
    <div class="col-6 offset-3">
        <h1>My looks</h1>
        <a href="/profile/looks/create">Create new look</a>
        <#list looks as look>
            <div class="look-card">
                <div class="look-header">
                    <h3 class="look-name">${look.name}</a></h3>
                </div>
                <div class="look-description">${look.description}</div>
            </div>
        <table id="itemsTable" class="timeline">
            <#if items??>
                <#list items as item>
                <tr>
                    <td class="timeline-item">
                        <i><b>${item.name}</b></i>
                    </td>
                    <td class="timeline-item">
                        ${item.brand}
                    </td>
                    <td class="timeline-item">
                        ${item.description}
                    </td>
                    
                    <img class="sitelink_arrow" src="${item.image_url}" alt="item_image"/>
                    
                </tr>
                </#list>
            <#--<#else>
            <h4>No Looks Available</h4>-->
            </#if>
            </#list>
    </div>

</#macro>

<@display_page/>