<#include "base.ftl">

<#macro page_body>
    <#if figuren??>
    <div>
        <ul class="list-group">
            <#list figuren as figur>
                <a href="<#if figur.type == 1>/person/${figur.name}<#else>/tier/${figur.name}</#if>">
                    <li class="list-group-item">${figur.name}</li>
                </a>
            </#list>
        </ul>
    </div>
    </#if>
</#macro>
<@dispaly_page/>