<#include "parts/security.ftl">
<#import "parts/common.ftl" as c>

<@c.page>
    <div class="card-columns">
        <#list restaurants as restaurant>
            <div class="card my-3">
                <div class="m-2">
                    <input type="hidden" id="${restaurant.id}" name="id">
                    <span>${restaurant.name}</span>
                    <i>${restaurant.address}</i>
                    <i>${restaurant.votes}</i>
                    <#if isAdmin>
                        <td><a href="/restaurants/${restaurant.id}">edit</a></td>
                    </#if>
                </div>
            </div>
        <#else>
            No message
        </#list>
    </div>
</@c.page>