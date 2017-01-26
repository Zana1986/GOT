<#include "base.ftl">
<#macro page_body>

    <#if loginKennung??>
        <div class="container">
            <form action="/bewertung/anlegen?loginKennung=${loginKennung}" method="post">
                <div class="form-group">
                    <label for="bewertung">Bewertung zu Haus</label>
                    <select class="form-control" name="bewertungsNiveau">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>
                    <textarea class="form-control" name="bewertungsInhalt" rows="5" id="bewertung"></textarea>
                </div>
                <input name="bewertungstyp" value="haus" style="display: none">
                <input name="hausid" value="${haus.id}" style="display: none">
                <button type="submit" class="btn btn-default">Bewerten</button>
            </form>
        </div>
    <#else>
        <div class="container">
            <h4 class="text-danger">Bitte anmelden zum Bewerten des Haus.</h4>
        </div>
    </#if>

    <#if haus??>
    <div class="container">
        <div class="page-header">
            <h4><span class="label label-default">Bewertungsniveau</span>
                <#list 1..5 as x>
                    <#if x <= ratingLevel>
                        <span class="glyphicon glyphicon-star"></span>
                    <#else>
                        <span class="glyphicon glyphicon-star-empty"></span>
                    </#if>
                </#list>
            </h4>
            <h4>
                <span class="label label-default">Beherrschen</span>
                <#list haus.orte as ort>
                    <a href="/ort/${ort.ort.ortName}">${ort.ort.ortName}</a>
                </#list>
            </h4>
            <h4>
                <span class="label label-default">Sitz</span>
                <a href="/ort/${haus.sitz.standOrt.ortName}">${haus.sitz.standOrt.ortName}</a>
            </h4>
        </div>
        <div class="row">
        <#list haus.owners as angehoert>
            <div class="col-sm-4 col-md-3">
                <div class="img-thumbnail">
                    <img src="/images/Snow.jpg" alt="${angehoert.person.name}">
                    <div class="caption">
                        <h4><a href="/person/${angehoert.person.name}">${angehoert.person.name}</a></h4>
                        <p>Titel:${angehoert.person.titel}</p>
                        <p>Biografie:${angehoert.person.biografie}</p>
                        <p>Herkunfsort:<a href="/ort/${angehoert.person.herkunftsort.ortName}">${angehoert.person.herkunftsort.ortName}</a></p>
                        <p><span class="label label-default">Von</span>
                            <a href="/staffel/s${angehoert.startPunkt.staffelNummer}">Staffel ${angehoert.startPunkt.staffelNummer}</a>
                            <a href="/staffel/s${angehoert.startPunkt.staffelNummer}/e${angehoert.startPunkt.epiNummer}">Episode ${angehoert.startPunkt.epiNummer}</a>
                        </p>
                        <p><span class="label label-default">Bis</span>
                            <a href="/staffel/s${angehoert.endPunkt.staffelNummer}">Staffel ${angehoert.endPunkt.staffelNummer}</a>
                            <a href="/staffel/s${angehoert.endPunkt.staffelNummer}/e${angehoert.endPunkt.epiNummer}">Episode ${angehoert.endPunkt.epiNummer}</a>
                        </p>
                    </div>
                </div>
            </div>
        </#list>
        </div>
    </div>
</#if>
</#macro>
<@dispaly_page/>