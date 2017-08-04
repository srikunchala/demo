<html>
<head>
  <title>Welcome!</title>
</head>
<body>
         <#assign x>Hello ${username}!</#assign> 

           <h1> ${x}</h1>
           
           
           <#macro myMacro>foo</#macro>
           
			<#assign x>
  				<#list 1..3 as n>
    				${n} <@myMacro />
  				</#list>
			</#assign>
Number of words: ${x?word_list?size}
${x}


 <#assign x>Hello ${username1?default("NA")}!</#assign> 

           <h1> ${x}</h1>


<#>if error>
<include "error.html">
<#>else>
<#>include "good.html">
</if>

</body>	
</html>

<!--http://localhost:8080/spring4-freemarker-example/ui/assign

-->