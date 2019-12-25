<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div>
        <@l.logout />
    </div>
    <div>Список ресторанов</div>
    <#list restaurants as restaurant>
        <div>
            <b>${restaurant.id}</b>
            <span>${restaurant.name}</span>
            <span>${restaurant.address}</span>
        </div>
    <#else>
        No message
    </#list>
</@c.page>
