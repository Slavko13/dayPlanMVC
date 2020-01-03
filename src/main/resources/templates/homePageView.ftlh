<#include "includers/main_template.ftlh">


<#macro content>
<h1>Welcome!</h1>
<#if id == 0  >
<p>Click <a href="/login">here</a> to login.</p>
</#if>
<#if id != 0  >
    <p >${name} Click <a href="/id${id}"> here </a> to go to ur profile </p>
</#if>
</#macro>

<@main title="home page"/>