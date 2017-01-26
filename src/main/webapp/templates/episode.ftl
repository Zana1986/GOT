<#include "base.ftl">
<#macro page_body>
    <#if loginKennung??>
    <div class="container">
        <form action="/bewertung/anlegen?loginKennung=${loginKennung}" method="post">
            <div class="form-group">
                <label for="bewertung">Bewertung zu Staffel ${staffelnummer}</label>
                <select class="form-control" name="bewertungsNiveau">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
                <textarea class="form-control" name="bewertungsInhalt" rows="5" id="bewertung"></textarea>
            </div>
            <input name="bewertungstyp" value="staffel" style="display: none">
            <input name="staffelnummer" value="${staffelnummer}" style="display: none">
            <button type="submit" class="btn btn-default">Bewerten</button>
        </form>
    </div>
    <#else>
    <div class="container">
        <h4 class="text-danger">Bitte anmelden zum Bewerten der Staffel ${staffelnummer}.</h4>
    </div>
    </#if>

    <#if episoden??>
    <div class="container">
        <#list episoden as episode>
            <ul>
                <li>
                    <a href="/staffel/s${episode.staffelNummer}/e${episode.epiNummer}">
                    ${episode.titel} ${episode.epiNummer}
                    </a>
                     ${episode.erstausstrahlungsDatum}
                </li>
            </ul>
        </#list>
    </div>
    <#else>
        <div class="container alert alert-warning" role="alert">
            <p>Keine Episoden gefunden.</p>
        </div>
    </#if>
</#macro>
<@dispaly_page/>