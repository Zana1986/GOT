<#include "base.ftl">
<#macro page_body>

<#if personen??>
<div class="container-fluid">
    <div class="page-header">
        <h4><span class="label label-default">Bewertungsniveau</span>
            <#list 1..5 as x>
                <#if x <= bewertunsNiveau>
                    <span class="glyphicon glyphicon-star"></span>
                <#else>
                    <span class="glyphicon glyphicon-star-empty"></span>
                </#if>
            </#list>
        </h4>
        <h4><span class="label label-default">Beherrschen</span>
            <#if beherrschen??>
            <#list beherrschen as b>
            ${b.ort.ortName}
            </#list>
            </#if>
        </h4>
    </div>
    <div class="row">
    <#list personen as person>
        <div class="col-sm-3 col-md-2">
            <div class="thumbnail">
                <img src="../images/Snow.jpg" alt="Profil">
                <div class="caption">
                    <h4>${person.person.name}</h4>
                    <p>${person.person.titel}</p>
                    <p>${person.person.biografie}</p>
                    <p>${person.person.herkunftsort.ortName}</p>
                    <p><span class="label label-default">Von</span>
                        Staffel ${person.startPunkt.staffelNummer} Episode ${person.startPunkt.epiNummer}
                    </p>
                    <p><span class="label label-default">Bis</span>
                        Staffel ${person.endPunkt.staffelNummer} Episode ${person.endPunkt.epiNummer}
                    </p>
                    <#if ratings??>
                    <#list ratings as rating>
                        <#list 1..5 as x>
                            <#if x <= rating[1].rating>
                                <span class="glyphicon glyphicon-star"></span>
                            <#else>
                                <span class="glyphicon glyphicon-star-empty"></span>
                            </#if>
                        </#list>
                    </#list>
                    </#if>
                </div>
            </div>
        </div>
    </#list>
    </div>
</div>
</#if>
</#macro>
<@dispaly_page/>