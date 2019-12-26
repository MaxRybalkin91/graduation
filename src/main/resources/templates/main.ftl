<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>
    <h5>Hello
    <#if known>
        , ${name}</h5>
    </#if>
    <div>This is a restaurant voting system</div>
</@c.page>