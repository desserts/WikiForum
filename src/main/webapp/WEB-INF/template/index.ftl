<p>hello world</p>

<br/>


<p>barList:</p>

<#list barList as bar>
    <#if bar??>
    <p>name:${bar.name!""}</p>
    <p>catalog:${bar.catalog!""}</p>
    <p>description:${bar.description!""}</p>
    <p>create_time:${bar.create_time!""}</p>
    </#if>
</#list>




