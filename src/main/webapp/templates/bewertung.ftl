<#include "base.ftl">

<#macro page_body>
<#if loginKennung??>
    <div class="container">
        <form action="/bewertung/anlegen?loginKennung=${loginKennung}" method="post">
            <div class="form-group">
                <label for="bewertung">Bewertung</label>
                <select class="form-control" name="bewertungsNiveau">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
                <textarea class="form-control" name="bewertungsInhalt" rows="5" id="bewertung"></textarea>
            </div>
            <button type="submit" class="btn btn-default">Bewerten</button>
        </form>
    </div>
<#else>
<div class="container">
    <h4 class="text-danger">Bitte anmelden zum Bewerten.</h4>
</div>
</#if>
    <#if ratingsWithNutzer??>
    <div class="container">
        <p class="lead">Alle Bewertungen</p>
        <ul class="list-group">
            <#list ratingsWithNutzer as bewertung>
                <li class="list-group-item">
                    <h4>Benutzer: ${bewertung[1].name}</h4>
                    <h4 class="list-group-item-heading">
                        Bewertungslevel
                        <#list 1..5 as x>
                            <#if x <= bewertung[0].rating>
                                <span class="glyphicon glyphicon-star"></span>
                            <#else>
                                <span class="glyphicon glyphicon-star-empty"></span>
                            </#if>
                        </#list>
                    </h4>
                    <textarea rows="5" cols="20" disabled>
                        Bewertungsinhalt: ${bewertung[0].textInhalt}
                    </textarea>
                </li>
            </#list>
        </ul>
    </div>
    <#else>
        <p>Keine Bewertung.</p>
    </#if>
</#macro>
<@dispaly_page/>