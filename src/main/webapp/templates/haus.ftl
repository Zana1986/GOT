<#include "base.ftl">
<#macro page_body>
<div class="container hausmedia">
    <#list haeuser as haus>
        <#if haus?index != 0 && haus?index % 3 == 0>
            </div>
            <div class="container hausmedia">
        </#if>
        <div class="col-sm-6 col-md-4">
            <div class="media">
                <div class="media-left media-middle">
                    <a href="/haus/${haus.name}">
                        <img src="../images/House-${haus.name}-Main-Shield.png" alt="Haus ${haus.name}" class="img-rounded media-object">
                    </a>
                </div>
                <div class="media-body">
                    <h4 class="media-heading">Haus ${haus.name}</h4>
                    <ul class="list-unstyled">
                        <li><span class="label label-info">Sitz</span>${haus.sitz.getName()}</li>
                        <li><span class="label label-info">Motto</span>${haus.motto}</li>
                        <li><span class="label label-info">Wappen</span>${haus.wappen}</li>
                        <#if haus.burg??>
                        <li><span class="label label-info">Ansehen</span>${haus.burg.name}</li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
    </#list>
    </div>
</#macro>
<@dispaly_page/>