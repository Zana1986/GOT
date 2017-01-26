<#include "base.ftl">

<#macro page_body>
    <#if figuren??>
        <div class="container">
            <ul>
                <#list figuren as figur>
                    <li>
                        <a href="<#if figur.type == 1>/person/${figur.name}<#else>/tier/${figur.name}</#if>">
                        ${figur.name}</a>
                    </li>
                </#list>
            </ul>
        </div>
    </#if>
</#macro>
<@dispaly_page/>