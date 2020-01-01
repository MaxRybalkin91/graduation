<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Restaurant voting system</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/restaurants">Restaurants</a>
            </li>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/users">User list</a>
                </li>
            </#if>
            <#if user??>
                <li class="nav-item">
                    <a class="nav-link" href="/users/profile">Edit my profile</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/restaurants">List of restaurants</a>
                </li>
            </#if>
        </ul>

        <div class="navbar-text mr-3">${name}</div>
        <@l.logout />
    </div>
</nav>
