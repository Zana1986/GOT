<#include "base.ftl">
<#macro page_body>

<#if person??>
<ul>
    <li>Name: ${person.name}</li>
    <li>Biographie: ${person.biografie}</li>
    <li>Herkunftsort: <a href="/ort/${person.herkunftsort.ortName}">${person.herkunftsort.ortName}</a></li>
    <li>Haus:
        <#if person.haeuse??>
        <#list person.haeuse as haus>
            <a href="/haus/${haus.haus.name}">${haus.haus.name}</a>
            <a href="/staffel">Staffel ${haus.startPunkt.staffelNummer}</a>
            <a href="/staffel/${haus.startPunkt.staffelNummer}?nummer=${haus.startPunkt.staffelNummer}">Episode ${haus.startPunkt.epiNummer}</a>
             -
            <a href="/staffel">Staffel ${haus.endPunkt.staffelNummer}</a>
            <a href="/staffel/${haus.endPunkt.staffelNummer}?nummer=${haus.endPunkt.staffelNummer}">Episode ${haus.endPunkt.epiNummer}</a>
        </#list>
        </#if>
    </li>
    <li>Beziehungen:
        <ul>
            <#list person.relations as relation>
            <li><a href="/person/${relation.freunde.name}">${relation.freunde.name}</a> Typ: ${relation.relationsTyp}</li>
            </#list>
        </ul>
    </li>

    <li>Tiere:
        <#if tiere??>
            <#list tiere as tier>
            <a href="/tier/${tier.name}">${tier.name}</a>
            </#list>
        <#else>
            Kein Tier.
        </#if>
    </li>
</ul>
</#if>
</#macro>
<@dispaly_page/>