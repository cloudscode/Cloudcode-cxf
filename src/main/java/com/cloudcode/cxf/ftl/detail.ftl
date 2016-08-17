<!DOCTYPE html>
<html lang="en">
<head>
   <title>集团信息</title>
   <#include "classpath:com/cloudcode/framework/common/ftl/head.ftl"/>
</head>

<body data-spy="scroll" data-target=".bs-docs-sidebar" data-twttr-rendered="true"> 
<div id="dialogDiv" xtype="hh_content">
<div class="container" id="layout" style="width: 100%;">
<form role="form" class="form-horizontal" id="myFormId" action="${request.getContextPath()}/groups/createGroup" method="post">
  
	  <span xtype="text" config=" name : 'path' "></span>
   
</form>
<div id="divInDialog2" style="display:none">
	</div>
</div>
<#include "classpath:com/cloudcode/framework/common/ftl/vendor.ftl"/>

<script type="text/javascript">

</script>
</div>
</body>
</html>