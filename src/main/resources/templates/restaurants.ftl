<#include "parts/security.ftl">
<#import "parts/common.ftl" as c>

<@c.page>
    <div class="card-columns">
        <#list restaurants as restaurant>
            <div class="card my-3">
                <div class="m-2">
                    <#assign rest_id = "${restaurant.id?c}">
                    <input type="hidden" id="${rest_id}" name="id">
                    <span>${restaurant.name}</span>
                    <i>${restaurant.address}</i>
                    <i>${restaurant.votes}</i>
                    <td><a href="/restaurants/${rest_id}/vote">Vote</a></td>
                    <#if isAdmin>
                        <td><a href="/restaurants/${rest_id}">Edit</a></td>
                    </#if>
                </div>
            </div>
        <#else>
            No message
        </#list>
    </div>
</@c.page>