<#include "base.ftl">
<#macro page_body>
    <#if ort??>
    <ul>
        <li>Name: ${ort.ortName}</li>
        <li>Besitz von:
        <#list ort.owners as owner>
            <a href="/haus/${owner.haus.name}">${owner.haus.name}</a>
        </#list>
        </li>
        <li>Burg:
            <#if burge??>
            <#list burge as burg>
                ${burg.name}
            </#list>
            <#else>
            kein Burg Hier.
            </#if>
        </li>
        <li>Lokale Peronen:
        <#if lokalePersonen??>
        <#list lokalePersonen as person>
            <a href="/person/${person.name}">${person.name}</a>
        </#list>
        <#else>
            Niemand.
        </#if>
        </li>
        <li>Episoden:
        <#list ort.hoOwners as ho>
            <a href="/staffel/s${ho.episode.staffelNummer}/e${ho.episode.epiNummer}">Staffel ${ho.episode.staffelNummer} Episode ${ho.episode.epiNummer}</a>|
        </#list>
        </li>
    </ul>
    </#if>
</#macro>
<@dispaly_page/>