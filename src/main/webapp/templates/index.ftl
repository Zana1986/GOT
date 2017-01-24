<#include "base.ftl">


<#macro page_body>
<#if loginfailed??>
    <div class="alert alert-danger" role="alert">Loginkennung order Passwort ist falsch.</div>
<#else>
    <div class="container">
        <div class="page-header">
            <img src="../images/GameOfThronesLogo.png" class="img-rounded">
        </div>
        <h4>Datenbank von Game Of Thrones</h4>
        <p>
            <a href="https://de.wikipedia.org/wiki/Game_of_Thrones">GOT</a>
            ist eine US-amerikanische Fernsehenserie, die 2011 beim HBO im Fersehen ausgestrahlt wurde. Die aktuelle
            Staffel lautet Staffel 6, die schon zu Ende gewesen ist, ferner 10 Episoden je Staffel.
        </p>
    </div>
    <div class="container">
        <div class="col-sm-3">
            <ul class="list-unstyled">
                <#list figuren as figur>
                <li><#if figur.type == 1><a href="/person/${figur.name}">Person <#else><a href="/tier/${figur.name}">Tier </#if>${figur.name}</a></li>
                </#list>
            </ul>
            <form class="navbar-left" action="/suchen?suchTyp=Figur" method="post">
                <div class="form-group">
                    <a href="/figur"><span class="label label-default">Alle</span></a>
                    <input type="text" name="suchInfo" class="form-control" placeholder="Figur">
                </div>
                <button type="submit" class="btn btn-default">Suchen</button>
            </form>
        </div>
        <div class="col-sm-3">
            <ul class="list-unstyled">
                <#list haeuser as haus>
                    <li><a href="/haus/${haus.name}">Haus ${haus.name}</a></li>
                </#list>
            </ul>
            <form class="navbar-left" action="/suchen?suchTyp=Haus" method="post">
                <div class="form-group">
                    <a href="/haus"><span class="label label-default">Alle</span></a>
                    <input type="text" name="suchInfo" class="form-control" placeholder="Haus">
                </div>
                <button type="submit" class="btn btn-default">Suchen</button>
            </form>
        </div>
        <div class="col-sm-3">
            <ul class="list-unstyled">
                <#list staffeln as staffel>
                    <li><a href="/staffel/${staffel.nummer}?nummer=${staffel.nummer}">Staffel ${staffel.nummer}</a></li>
                </#list>
            </ul>
            <form class="navbar-left" action="/suchen?suchTyp=Staffel" method="post">
                <div class="form-group">
                    <a href="/staffel"><span class="label label-default">Alle</span></a>
                    <input type="text" name="suchInfo" class="form-control" placeholder="Staffel">
                </div>
                <button type="submit" class="btn btn-default">Suchen</button>
            </form>
        </div>
        <div class="col-sm-3">
            <ul class="list-unstyled">
                <#list playlisten as playliste>
                    <li><a href="/playliste/${playliste.id}">Playliste ${playliste.id}</a></li>
                </#list>
            </ul>
            <#if loginKennung??>
                <a class="btn btn-default" type="button" href="/playliste/neu?loginKennung=${loginKennung}">Neue Playlist</a>
            <#else>
                <h4 class="text-danger">Bitte anmelden zur Erstellung einer Playliste.</h4>
            </#if>
        </div>
    </div>
</#if>
</#macro>
<@dispaly_page/>