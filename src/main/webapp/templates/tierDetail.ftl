<#include "base.ftl">
<#macro page_body>
    <#if tier??>
    <ul>
        <li>Name: ${tier.name}</li>
        <li>Herkunftsort: <a href="/ort/${tier.herkunftsort.ortName}">${tier.herkunftsort.ortName}</a></li>
        <li>Besitzer: <a href="/person/${tier.person.name}">${tier.person.name}</a></li>
    </ul>
    </#if>
</#macro>
<@dispaly_page/>