<#include "base.ftl">

<#macro page_body>
<#if personen??>
<div>
    <ul>
        <#list personen as person>
            <li><a href="/person/${person.name}">${person.name}</a></li>
        </#list>
    </ul>
</div>
</#if>
</#macro>
<@dispaly_page/>