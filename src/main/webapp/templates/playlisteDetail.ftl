<#include "base.ftl">
<#macro page_body>

<div class="container">
    <#if playliste??>
        <p class="lead">Liste Detail</p>
        <ul class="list-group">
            <#list playliste.episoden as episode>
                <li class="list-group-item">
                    <a href="/staffel/s${episode.episode.staffelNummer}/e${episode.episode.epiNummer}">
                        Staffel ${episode.episode.staffelNummer} Episode ${episode.episode.epiNummer}
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