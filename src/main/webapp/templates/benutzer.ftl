<#include "base.ftl">
<#macro extra_files>
<script type="text/javascript" src="/js/main.js"></script>
</#macro>
<#macro page_body>
<div class="container">
    <div class="row user-center">
        <div class="col-sm-3 col-md-3 user-sidebar">
            <div class="page-header">
                <h4>Zentrum von Benutzer </h4>
            </div>
            <ul>
                <li><a class="show-playliste">Playliste</a></li>
                <li><a class="show-bewertung">Bewertung</a></li>
                <li><a class="write-bewertung">Neue Bewertung</a></li>
                <li><a class="add-playliste">Neue Playliste</a></li>
            </ul>
        </div>

        <div class="col-sm-8 col-md-8 user-playlist">
            <p class="lead">Liste</p>
            <ul class="list-group">
                <#list playliste.episoden as episode>
                    <li class="list-group-item">Staffel ${episode.staffelNummer} Episode ${episode.epiNummer}</li>
                </#list>
            </ul>
        </div>

        <div class="col-sm-8 col-md-8 user-bewertung">
            <p class="lead">Bewertung</p>
            <ul class="list-group">
                <#list bewertungen as bewertung>
                    <li class="list-group-item">
                        <h4 class="list-group-item-heading">
                            Bewertungslevel
                            <#list 1..5 as x>
                                <#if x <= bewertung.rating>
                                    <span class="glyphicon glyphicon-star"></span>
                                <#else>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                </#if>
                            </#list>
                        </h4>
                        <p class="list-group-item-text">
                            Bewertungsinhalt: ${bewertung.textInhalt}
                        </p>
                    </li>
                </#list>
            </ul>
        </div>

        <div class="col-sm-8 col-md-8 neue-bewertung">
            <form action="/bewertung" method="post">
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

        <div class="container neue-playliste">
            <h4>Playlisten</h4>
            <#if playlisten??>
                <ul>
                    <#list playlisten as p>
                        <li>Playliste ${p.id}</li>
                    </#list>
                </ul>
            </#if>
            <button class="btn btn-default" type="button">Neue Playlist</button>
        </div>

    </div>
</div>
</#macro>
<@dispaly_page/>