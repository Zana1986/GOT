<#include "base.ftl">

<div class="container">
    <h4>Playlisten</h4>
    <#if playlisten??>
        <ul>
            <#list playlisten as p>
                <li><a href="/playliste/${p.id}">Playliste ${p.id}</a></li>
            </#list>
        </ul>
    <#else>
        <p class="text-danger">Keine Playliste.</p>
    </#if>
    <#if loginKennung??>
        <a class="btn btn-default" type="button" href="/playliste/neu?loginKennung=${loginKennung}">Neue Playlist</a>
    <#else>
        <div class="container">
            <h4 class="text-danger">Bitte anmelden zur Erstellung einer Playliste.</h4>
        </div>
    </#if>
</div>

