<#include "base.ftl">
<#macro page_body>
    <div class="container">
        <div class="row">
            <#if figuren??>
            <div class="col-sm-4">
                <p class="text-muted">Figur</p>
                <ul>
                    <#list figuren as figur>
                    <li>
                        <a href="<#if figur.type == 1>/person/${figur.name}<#else>/tier/${figur.name}</#if>>">
                            ${figur.name}
                        </a>
                    </li>
                    </#list>
                </ul>
            </div>
            </#if>
            <#if haeuser??>
            <div class="col-sm-4">
                <p class="text-muted">Haus</p>
                <ul>
                    <#list haeuser as haus>
                    <li>
                        <a href="/haus/${haus.name}">${haus.name}</a>
                    </li>
                    </#list>
                </ul>
            </div>
            </#if>
            <#if staffeln??>
            <div class="col-sm-4">
                <p class="text-muted">Staffel</p>
                <ul>
                    <#list staffeln as staffel>
                    <li>
                        <a href="/staffel/${staffel.nummer}">Staffel ${staffel.nummer}</a>
                    </li>
                    </#list>
                </ul>
            </div>
            </#if>
        </div>
    </div>
</#macro>
<@dispaly_page/>