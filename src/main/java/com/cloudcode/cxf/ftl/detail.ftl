<!DOCTYPE html>
<html lang="en">
<head>
   <title>集团信息</title>
   <#include "classpath:com/cloudcode/framework/common/ftl/head.ftl"/>
</head>

<body data-spy="scroll" data-target=".bs-docs-sidebar" data-twttr-rendered="true"> 
<div id="dialogDiv" xtype="hh_content">
<div class="container" id="layout" style="width: 100%;">
<form  xtype="form" role="form" class="form-horizontal" id="myFormId" action="${request.getContextPath()}/groups/createGroup" method="post">
			<span xtype="text" config=" hidden:true,name : 'id'"></span>
	  <span xtype="text" config=" name : 'path' "></span>
   
   
     <span xtype="password" config=" name : 'path' "></span>
     <br>
     <span xtype="radio"
							config="name: 'expanded' ,defaultValue : 0,  data :[{id:1,text:'是'},{id:0,text:'否'}]"></span>
     
     <span xtype="radio"
							config="name: 'leaf' ,defaultValue : 0,  data :[{id:1,text:'子节点'},{id:0,text:'父节点'}]"></span>
							<br><span
							config=" name : 'remember'  ,  data : [{id:1,text:'记住'}] "
							xtype="checkbox">
							</span>
  <span config=" name : 'game'  ,  data : [{id:11,text:'羽毛球'},{id:22,text:'乒乓球'}] "
							xtype="checkbox"></span>
	<br>					
	<span xtype="textarea" config=" name : 'remark'"></span>						
	<br>						
     
     <span id="node_span" xtype="selectTree"
							config="name: 'node' , tableName : 'US_GROUP' , url : '../groups/queryTree' , params : {isNoLeaf : false} "></span>
	<br>							
	<span xtype="selectUser" config="name: 'users' ">	</span>			
	<br>	
	<span xtype="selectPic" config=" name : 'icon' "></span>		
	<br>	
	
	<span xtype="selectPic"
						config=" name : 'vdtp' ,params :{path:'/hhcommon/images/big'} ,selectType:'big' "></span>
						
	<span lxchange="true" xtype="tableitem"
						config="name: 'params' "></span>					
	
	
	
	
	
							
	<span configVar="configcombobox"  xtype="combobox"></span>						
							
	<span xtype=menu id="messDivspan" configVar=" messConfig "></span>
	
	<span xtype="tree" configVar="orgtreeconfig"></span>
	
	<span id="messageSpan"
						config=" height:78,bottom:'hidden', name:'message' ,toolbar : ['Format',	'Font', 'FontSize', 'Styles'] "
						xtype="ckeditor"></span>
						
	<span xtype="selectPageList"
						config="name: 'roleIds'  , url:'usersystem-role-queryPagingData' ,tableName:'US_ROLE' "></span>
		<div id="pagelist" xtype="pagelist"
		config=" url: 'usersystem-user-queryOnLinePagingData' ,column : [
		{
			name : 'nxb' ,
			text : '性别',
			render:'rendersex'
		},{
			name : 'text' ,
			text : '用户名称'
		},{
			name : 'vdzyj' ,
			text : '电子邮件'
		},{
			name : 'vdh' ,
			text : '联系电话'
		}
	]">
	</div>				
		<span xtype="uploadpic"
						config="name: 'headpic' , type : 'headpic'  ,path:'/hhcommon/images/big/qq' "></span>
						
	<span xtype="date" config="name: 'dsr'  "></span>
	
	<span xtype="selectOrg"  config="name: 'orgId' ,selectType:'org' ,onChange: orgChange  ">
	
		<span xtype="selectUser" config="name: 'users' "></span>																			
	<div xtype="toolbar">
		<span xtype="button" config="text:'保存' , onClick : save "></span> <span
			xtype="button" config="text:'取消' , onClick : Dialog.close "></span>
	</div>
</form>
<div id="divInDialog2" style="display:none">
	</div>
</div>
<#include "classpath:com/cloudcode/framework/common/ftl/vendor.ftl"/>

<script type="text/javascript">
var params = $.cc.getIframeParams();
	var width = 720;
	var height = 450
	
	function save() {
		$.cc.validation.check('form', function(formData) {
			Request.request('usersystem-menu-saveTree', {
				data : formData,
				callback : function(result) {
					if (result.success!=false) {
						params.callback();
						Dialog.close();
					}
				}
			});
		});
	}
	
var data = [];
	for (var i = 0; i < params.currOrg.length; i++) {
		data.push({id:params.currOrg[i].id,text:params.currOrg[i].text});
	}
	var configcombobox = {
		required : true,
		name : 'currOrgId',
		data : data
	}
	
	var messConfig = {
			render:false,
			onClick : function(data){
				data.li.find('.hh_red').remove();
				//clickMenu(data);
			}
	}
	
	var orgtreeconfig = {};
</script>
</div>
</body>
</html>