<#include "base.ftl">
<#macro page_body>
<#--<div class="container">-->
    <#if episoden??>
        <#list episoden as episode>
            <div class="panel panel-default">
                <div class="panel-heading">
                    Staffel ${episode.staffelNummer} Episode ${episode.epiNummer} ${episode.titel}
                </div>
                <div class="panel-body">
                    <div class="row">
                        <ul class="col-sm-6 col-md-4" style="margin-left: 15px;">
                            <li>${episode.inhaltsAngabe}</li>
                            <li>${episode.erstausstrahlungsDatum}</li>
                            <li>
                                <#list 1..5 as x>
                                <#if x <= ratings[episode.epiNummer]>
                                    <span class="glyphicon glyphicon-star"></span>
                                <#else>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                </#if>
                                </#list>
                            </li>
                        </ul>
                        <div class="row col-sm-5 col-md-7" style="border-left: 1px solid #f3f3f3;">
                            <#list figurenEpisoden[episode.epiNummer] as auftreten>
                            <div class="col-sm-2">
                                <p>${auftreten.figur.name}</p>
                            </div>
                            </#list>
                        </div>
                    </div>
                </div>
            </div>
        </#list>
    <#else>
        <div class="alert alert-warning" role="alert"><p>Keine Episoden gefunden.</p></div>
    </#if>
<#--</div>-->
</#macro>
<@dispaly_page/>