<#include "base.ftl">

<#macro page_body>
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
    <form action="/playliste/neu" method="post">
        <div class="form-group">
            <input type="text" name="playlisteName">
            <input type="text" name="loginKennung" value="${loginKennung}" style="display: none">
            <button class="btn btn-default" type="submit">Neue Playlist</button>
        </div>
    </form>
    <#else>
        <div class="container">
            <h4 class="text-danger">Bitte anmelden zur Erstellung einer Playliste.</h4>
        </div>
    </#if>
</div>
</#macro>
<@dispaly_page/>

