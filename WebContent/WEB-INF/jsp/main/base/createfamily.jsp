<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>创建新家庭</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=basePath%>extjs5/ext-all.js"></script>
<script src="<%=basePath%>extjs5/ext-locale/ext-locale-zh_CN.js"></script>
<link href="<%=basePath%>extjs5/ext-theme-classic/build/resources/ext-theme-classic-all.css" rel="stylesheet" />
<script type="text/javascript">
	Ext.onReady(function() {
		//db数据部----------------------------------------------------------------------------	
		Ext.define('Member', {
	        extend: 'Ext.data.Model',
	        fields: [
	            {name:'familyno',              type: 'string'},
	            {name:'mastername',            type: 'string'},
	            {name:'paperid' ,              type: 'string'},
	            {name:'sex' ,              type: 'string'}
	        ]
	    });

	    var store = Ext.create('Ext.data.Store', {
	        model: 'Member',
	        remoteSort: true,
	        pageSize: 10,
	        proxy: {
	            type: 'ajax',
	            enablePaging: true,
	            url: 'data/MemberData.json',
	            reader: {
	            		type: 'json',
		                root: 'member'
		         		}
	        }

	    });
	    
	    store.load();
	  //右侧数据显示部------------------------------------------------------------------------
 		var familygrid = Ext.create('Ext.grid.Panel', {
 			store: store,
 	        region: 'center',
 	        columnLines: true,
 	        columns: [
 	        {
 	            text: '姓名',
 	            dataIndex: 'mastername',
 	            flex: .3,
 	            sortable: false,
 	            align: 'center'
 	        },
 	       	{
 	            text: '性别',
 	            dataIndex: 'sex',
 	            flex: .2,
 	            sortable: false,
 	            align: 'center'
 	        },
 	       	{
 	            text: '身份证号码',
 	            dataIndex: 'paperid',
 	           	flex: .5,
 	            sortable: true,
 	            //locked: false
 	            align: 'center'
 	        }],
 	        listeners:{
 	        	 'itemclick':function(view, record, item, index, e, eOpts){
 	        		var centerpanel = Ext.getCmp("tabs");
 					var tab_modifyResidentInfo = centerpanel.getComponent('modifyResidentInfo');
 					centerpanel.setActiveTab(tab_modifyResidentInfo);
 	        	}
 	        }

 	    });
		var createfamilyForm = Ext.create('Ext.form.Panel',{
			margin: '60 10 10 10',
			border: 0,
			//layout : "form",
	    	fieldDefaults: {
	            msgTarget: 'side',
	            labelAlign: 'left',
	            labelWidth: 80
	        },
	        defaults: {
	            anchor: '100%'
	        },
			items: [ familygrid ]
		});
		var createfamilyPanel = Ext.create('Ext.panel.Panel', { 
			 margin: '0 0 5 0',
			 layout: 'border',
			 border: false,
			 items:[{
				 	xtype: 'panel',   
					region: 'center',
					border: false,
			        autoScroll: true,
			        flex:.9,
			        items:[createfamilyForm]
			    },{
			    	xtype: 'panel',
			        region: 'south',
			        border: false,
			        autoScroll: true,
			        align:'right',
			        flex:.1,
			        items:[{
			        	xtype: 'container',
			            layout: 'hbox',
			            items: [{
			                text: '保存',
			                xtype: 'button',
			                flex: 1,
			                handler:function(){
		                	  alert("111");
			                }
			           
			            }]
			        }]
			}]

		 });
		 
		Ext.create('Ext.container.Viewport',{
			layout: 'border',
	        renderTo : Ext.getBody(),
	    	items: [
	   	         {
	   	            region: 'east',
	 	            autoScroll: true,
	 	            flex: .5,
	 	  			layout:'fit',
	 	  			bodyStyle: 'padding:10px 10px 0',
	   	            items:[{
	   	            	xtype: 'fieldset',
						title: '扫描身份证',
						html: '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="test.html"></iframe>'
	   	            }]
	   	        },{
	   	        	region: 'center',
	   	        	autoScroll: true,
	   	        	layout: 'fit',
	   	        	flex: .5,
	   	        	bodyStyle: 'padding:10px 10px 0',
	   	        	items:[{
	   	        		xtype: 'fieldset',
						title: '创建家庭',
						layout: 'fit',
						items: [createfamilyPanel]
	   	        	}]
	   	        }
	   	        ]
		});
	});
</script>
</head>
<body>
</body>
</html>
