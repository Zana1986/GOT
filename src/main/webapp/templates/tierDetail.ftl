<#include "base.ftl">
<#macro page_body>
    <#if tier??>
        <div class="container">
            <ul>
                <li>Name: ${tier.name}</li>
                <li>Herkunftsort: <a href="/ort/${tier.herkunftsort.ortName}">${tier.herkunftsort.ortName}</a></li>
                <li>Besitzer: <a href="/person/${tier.person.name}">${tier.person.name}</a></li>
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
                <input name="figurid" value="${tier.id}" style="display: none">
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