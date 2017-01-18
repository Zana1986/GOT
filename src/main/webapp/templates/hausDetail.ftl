<#include "base.ftl">
<#macro page_body>

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
                <a href="/ort/${b.ort.ortName}">${b.ort.ortName}</a>
            </#list>
            </#if>
        </h4>
    </div>
    <#if personen??>
        <div class="row">
        <#list personen as person>
            <div class="col-sm-3 col-md-2">
                <div class="thumbnail">
                    <img src="../images/Snow.jpg" alt="Profil">
                    <div class="caption">
                        <h4><a href="/person/${person.person.name}">${person.person.name}</a></h4>
                        <p>Titel:${person.person.titel}</p>
                        <p>Biografie:${person.person.biografie}</p>
                        <p>Herkunfsort:<a href="/ort/${person.person.herkunftsort.ortName}">${person.person.herkunftsort.ortName}</a></p>
                        <p><span class="label label-default">Von</span>
                            <a href="/staffel">Staffel ${person.startPunkt.staffelNummer}</a>
                            <a href="/staffel/${person.startPunkt.staffelNummer}?nummer=${person.startPunkt.staffelNummer}">Episode ${person.startPunkt.epiNummer}</a>
                        </p>
                        <p><span class="label label-default">Bis</span>
                            <a href="/staffel">Staffel ${person.endPunkt.staffelNummer}</a>
                            <a href="/staffel/${person.endPunkt.staffelNummer}?nummer=${person.endPunkt.staffelNummer}">Episode ${person.endPunkt.epiNummer}</a>
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
    </#if>
</div>
</#macro>
<@dispaly_page/>