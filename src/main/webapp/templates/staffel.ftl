<#include "base.ftl">
<#macro page_body>
    <div>
        <div class="row">
            <#list staffeln as staffel>
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <a href="/staffel/s${staffel.nummer}"><img src="../images/GameOfThronesSeason${staffel.nummer}.jpg" alt="Staffel !{staffel.nummer}"></a>
                        <div class="caption">
                            <h3>Kurzfassung</h3>
                            <ul>
                                <li>Staffel ${staffel.nummer}</li>
                                <li>${staffel.episodenAnzahl} Episoden</li>
                                <li>Startsdatum ${staffel.startsDatum}</li>
                                <li>
                                    <#list 1..5 as x>
                                        <#if x <= ratings[staffel.nummer-1]>
                                            <span class="glyphicon glyphicon-star"></span>
                                        <#else>
                                            <span class="glyphicon glyphicon-star-empty"></span>
                                        </#if>
                                    </#list>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</#macro>
<@dispaly_page/>