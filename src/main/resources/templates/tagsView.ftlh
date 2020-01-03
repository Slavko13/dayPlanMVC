<#include "includers/main_template.ftlh">

<#macro content>
<#list HomesTags as tag>
    <p>Дом №${tag.id} ${tag.homeName}</p>
</#list>
</#macro>

<@main title="Homes"/>
