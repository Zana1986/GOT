<#include "base.ftl">
<#macro page_body>

<#if suchErgebnis??>
<ul>
    <#if figur??>
        <#list suchErgebnis as e>
            <li>
                <a href="<#if e.type==1>/person/${e.name}<#else>/tier/${e.name}</#if>">
                    ${e.name}
                </a>
            </li>
        </#list>
    <#elseif haus??>
        <#list suchErgebnis as e>
            <li><a href="/haus">${e.name}</a></li>
        </#list>
    <#elseif staffel??>
        <#list suchErgebnis as e>
            <li><a href="/staffel">Staffel ${e.nummer}</a></li>
        </#list>
    </#if>
</ul>
</#if>

</#macro>
<@dispaly_page/>