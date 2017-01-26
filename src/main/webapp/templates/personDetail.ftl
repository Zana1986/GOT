<#include "base.ftl">
<#macro page_body>

<#if person??>
<div class="container">
    <ul>
        <li>Name: ${person.name}</li>
        <li>Biographie: ${person.biografie}</li>
        <li>Herkunftsort: <a href="/ort/${person.herkunftsort.ortName}">${person.herkunftsort.ortName}</a></li>
        <li>Haus:
            <#if person.haeuse??>
            <#list person.haeuse as haus>
                <a href="/haus/${haus.haus.name}">${haus.haus.name}</a>
                <a href="/staffel/s${haus.startPunkt.staffelNummer}/e${haus.startPunkt.epiNummer}">Staffel ${haus.startPunkt.staffelNummer} Episode ${haus.startPunkt.epiNummer}</a>
                 -
                <a href="/staffel/s${haus.endPunkt.staffelNummer}/e${haus.endPunkt.epiNummer}">Staffel ${haus.endPunkt.staffelNummer} Episode ${haus.endPunkt.epiNummer}</a>
            </#list>
            </#if>
        </li>
        <li>Beziehungen:
            <ul>
                <#list person.personen as relation>
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
</div>
    <#if loginKennung??>
    <div class="container">
        <form action="/bewertung/anlegen?loginKennung=${loginKennung}" method="post">
            <div class="form-group">
                <label for="bewertung">Bewertung zu Figur</label>
                <select class="form-control" name="bewertungsNiveau">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
                <textarea class="form-control" name="bewertungsInhalt" rows="5" id="bewertung"></textarea>
            </div>
            <input name="bewertungstyp" value="figur" style="display: none">
            <input name="figurid" value="${person.id}" style="display: none">
            <button type="submit" class="btn btn-default">Bewerten</button>
        </form>
    </div>
    <#else>
    <div class="container">
        <h4 class="text-danger">Bitte anmelden zum Bewerten der Figur.</h4>
    </div>
    </#if>
</#if>
</#macro>
<@dispaly_page/>