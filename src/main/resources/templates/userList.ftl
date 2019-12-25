<#import "parts/common.ftl" as c>

<@c.page>
    List of users

    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Role</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><#if !user.isAdmin()><a href="/user/${user.id}">edit</a></#if></td>
                <td><#if !user.isAdmin()><a href="/user/${user.id}">delete</a></#if></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>
