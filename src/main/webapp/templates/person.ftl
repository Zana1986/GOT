<#include "base.ftl">

<#macro page_body>
<#if personen??>
<div>
    <ul class="list-group">
        <#list personen as person>
        <a href="/person/${person.name}"><li class="list-group-item">${person.name}</li></a>
        </#list>
    </ul>
</div>
</#if>
</#macro>
<@dispaly_page/>