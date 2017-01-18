<#include "base.ftl">
<#macro page_body>
    <#if orte??>
    <div class="container">
        <ul class="list-group">
            <#list orte as ort>
                <li><a href="/ort/${ort.ortName}">${ort.ortName}</a></li>
            </#list>
        </ul>
    </div>
    </#if>
</#macro>
<@dispaly_page/>