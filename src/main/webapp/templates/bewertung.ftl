<#include "base.ftl">

<#macro page_body>
    <#--<#if ratingsWithNutzer??>-->
    <#--<div class="container">-->
        <#--<p class="lead">Alle Bewertungen</p>-->
        <#--<ul class="list-group">-->
            <#--<#list ratingsWithNutzer as bewertung>-->
                <#--<li class="list-group-item">-->
                    <#--<h4>Benutzer: ${bewertung[1].name}</h4>-->
                    <#--<h4 class="list-group-item-heading">-->
                        <#--Niveau-->
                        <#--<#list 1..5 as x>-->
                            <#--<#if x <= bewertung[0].rating>-->
                                <#--<span class="glyphicon glyphicon-star"></span>-->
                            <#--<#else>-->
                                <#--<span class="glyphicon glyphicon-star-empty"></span>-->
                            <#--</#if>-->
                        <#--</#list>-->
                    <#--</h4>-->
                    <#--<textarea rows="5" cols="20" disabled>-->
                        <#--${bewertung[0].textInhalt}-->
                    <#--</textarea>-->
                <#--</li>-->
            <#--</#list>-->
        <#--</ul>-->
    <#--</div>-->
    <#--<#else>-->
        <#--<p>Keine Bewertung.</p>-->
    <#--</#if>-->

    <#if ratingsAllNutzer??>
    <div class="container">
        <p class="lead">Alle Bewertungen</p>
        <p class="lead">Durchschnitt: ${durchschnitt}</p>
        <ul class="list-group">
            <#list ratingsAllNutzer as bewertung>
                <li class="list-group-item">
                    <h4>Benutzer: ${bewertung.benutzer.name}</h4>
                    <h4 class="list-group-item-heading">
                        Niveau
                        <#list 1..5 as x>
                            <#if x <= bewertung.rating>
                                <span class="glyphicon glyphicon-star"></span>
                            <#else>
                                <span class="glyphicon glyphicon-star-empty"></span>
                            </#if>
                        </#list>
                    </h4>
                    <textarea class="form-control" rows="5" disabled>${bewertung.textInhalt}</textarea>
                </li>
            </#list>
        </ul>
    </div>
    <#else>
    <p>Keine Bewertung.</p>
    </#if>
</#macro>
<@dispaly_page/>