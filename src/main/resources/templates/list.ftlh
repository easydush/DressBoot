<#import "/spring.ftl" as spring />

<#include "macros/base.ftlh">

<#macro page_title>
    <title>All brands</title>
</#macro>

<#macro page_body>
    <div class="col-6 offset-3">
        <h1>All brands</h1>
        <a href="/brands/create">Add new brand</a>
        <tr>
        <#list brands as brand>
        <div class="brand-card">
            <td><div class="brand-header">
                <h3 class="brand-name">${brand.name}</a></h3>
                </div>
            </td>
            <td>
                <div class="brand-description">${brand.description}</div>
            </td>
            <td>
                <img href="${brand.logo_url}">
            </td>

        </div>
        </#list>
        </tr>
    </div>

</#macro>

<@display_page/>