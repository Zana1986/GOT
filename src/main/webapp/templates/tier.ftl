<#include "base.ftl">
<#macro page_body>
    <#if tiere??>
    <div class="container">
        <ul class="list-group">
            <#list tiere as tier>
            <li><a href="/tier/${tier.name}">${tier.name}</a></li>
            </#list>
        </ul>
    </div>
    </#if>
</#macro>
<@dispaly_page/>