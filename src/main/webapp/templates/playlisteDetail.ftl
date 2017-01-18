<#include "base.ftl">
<#macro page_body>

<div class="container">
    <#if playliste??>
        <p class="lead">Liste Detail</p>
        <ul class="list-group">
            <#list playliste.episoden as episode>
                <li class="list-group-item">
                    <a href="/staffel/${episode.staffelNummer}?nummer=${episode.staffelNummer}">
                        Staffel ${episode.staffelNummer} Episode ${episode.epiNummer}
                    </a>
                </li>
            </#list>
        </ul>
    <#else>
        <p class="text-danger">Erstelle neue Playliste nicht erfolgreich.</p>
    </#if>
</div>
</#macro>
<@dispaly_page/>