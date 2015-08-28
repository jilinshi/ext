<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=basePath %>extjs5/ext-all.js"></script>
<script src="<%=basePath %>extjs5/ext-locale/ext-locale-zh_CN.js"></script>
<link href="<%=basePath %>extjs5/ext-theme-classic/build/resources/ext-theme-classic-all.css" rel="stylesheet" />
<title>Insert title here</title>
<script type="text/javascript">
Ext.onReady(function() {
	//db数据部----------------------------------------------------------------------------	
	Ext.define('Task', {
        extend: 'Ext.data.Model',
        fields: [
            {name:'familyno',          type: 'string'},
            {name:'mastername',      type: 'string'}
        ]
    });

    var store = Ext.create('Ext.data.Store', {
        model: 'Task',
        remoteSort: true,
        pageSize: 10,
        proxy: {
            type: 'ajax',
            enablePaging: true,
            url: 'data/CSBasicInfoData.json',
            reader: {
            		type: 'json',
	                root: 'tasks'
	         		}
        }

    });
    
    store.load({              // =====页面自动加载
    	  params:{            // =====分页参数
    		     start:0,     // =====向后台提供 当前页码
    		     limit:5      // =====向后台提供 每页显示记录数
    	  		 },
    	  		callback: function(r, options, success) { 
                    if (!success) { 
                        alert("加载数据失败，无对应数据或者系统出现异常！"); 
                    } 
                } 
    });
	//右侧检索部-----------------------------------------------------------------------
	var queryForm = Ext.create('Ext.form.Panel',{
		margin: '0 0 5 0',
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
		items: [
                { xtype : "textfield", allowBlank:true, fieldLabel: '家庭编号', name: 'fdto.familyNo'},
                { xtype : "textfield", allowBlank:true, fieldLabel: '户主姓名', name: 'fdto.resName'},
                { xtype : "textfield", allowBlank:true, fieldLabel: '身份证号码', name: 'fdto.idcard'}
        ]
	});
 	  var topPanel = Ext.create('Ext.panel.Panel', {
	    	bodyStyle: 'padding:5px 5px 0',
	    	region: 'north',
	    	height: 210,
	    	//flex:1,
	    	border: false,
	    	items:[{
	            xtype: 'fieldset',
	            title: '创建新家庭',
	            items:[{
	            	xtype: 'container',
				            layout: 'hbox',
				            defaultType: 'textfield',
				            margin: '0 0 5 0',
				            items: [{
				            	xtype: 'button',
				                text: '创建新家庭',
				                flex: 1,
				               	handler:function(){
				               		
				               	}
				            }]
	            }]
	        },{
	            xtype: 'fieldset',
	            title: '查询家庭',
	            items: [
	            	queryForm,
	                {xtype: 'container',
				            layout: 'hbox',
				            margin: '0 0 5 0',
				            items: [{
				                text: '重置',
				                xtype: 'button',
				                flex: 0.5,
				                handler:function(){
				                    queryForm.getForm().reset();
				                }
				            }, {
				                text: '查询',
				                xtype: 'button',
				                flex: 0.5,
				                margins: '0 0 0 10',
				                handler:function(){
			                	  
				                }
				           
				            }]
				}]
	        }]
	    });
 	//右侧分页工具条------------------------------------------------------------------------
 	    var pagingToolbar = Ext.create('Ext.PagingToolbar',{
 	    	width: 30,
 	        pageSize: 10,
 	        store: store,
 	        displayInfo: true
 	    });
 	 //右侧数据显示部------------------------------------------------------------------------
 		var familygrid = Ext.create('Ext.grid.Panel', {
 			requires: [
 				       'Ext.grid.RowNumberer'
 				    ],
 			store: store,
 	        region: 'center',
 	        columnLines: true,
 	        columns: [{
 	            xtype: 'rownumberer'
 	        },{
 	            text: '家庭编号',
 	            dataIndex: 'familyno',
 	           	flex: 0.6,
 	            sortable: true,
 	            //locked: false
 	            align: 'center'
 	        }
 	        , {
 	            text: '户主姓名',
 	            dataIndex: 'mastername',
 	            flex: 0.4,
 	            sortable: false,
 	            align: 'center'
 	        }],
 	        bbar: pagingToolbar,
 	        listeners:{
 	        	 'itemclick':function(view, record, item, index, e, eOpts){
 	        		var centerpanel = Ext.getCmp("tabs");
 					var tab_modifyResidentInfo = centerpanel.getComponent('modifyResidentInfo');
 					centerpanel.setActiveTab(tab_modifyResidentInfo);
 	        	}
 	        }

 	    });
		var rightPanel = Ext.create('Ext.panel.Panel',{
	    	layout: 'border',
		    items:[topPanel,familygrid]
	    });
		var tabs = Ext.create('Ext.tab.Panel', {
			id:'main_tabs',
		    autoTabs: true,
		    //autoScroll:true,
		    tabPosition: 'top',
		    activeTab: 0,
		    layout: 'border',
		    frame: false,
		    border:false,
		    plain: true,
		    deferredRender: true,
		    //enableTabScroll: true,
		    items: [{
		    	id : 'createNewFamily',
		        iconCls: 'go',
		        title: '创建新家庭',
		        layout: 'fit',
			    html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="createfamilyinit.do"></iframe>'
		        
		    },{
		    	id : 'modifyResidentInfo',
		    	iconCls: 'go',
		        title: '家庭成员信息维护',
		        layout: 'fit',
		        frame:false,
		       // disabled:true,
		        html: "家庭成员信息维护."
		    },{
		    	id : 'houseInfo',
		        iconCls: 'go',
		        title: '家庭住房信息维护',
		        layout: 'fit',
		        frame:false,
		        html: "家庭住房信息维护."
		    },{
		    	id : 'dependentInfo',
		        iconCls: 'go',
		        title: '赡扶抚养人信息维护',
		        layout: 'fit',
		        frame:false,
		        html: "赡扶抚养人信息维护."
		    },{
		    	id : 'familyassetsInfo',
		        iconCls: 'go',
		        title: '家庭财产信息维护',
		        layout: 'fit',
		        frame:false,
		        html: "家庭财产信息维护."
		    },{
		    	id : 'residentIncomeInfo',
		        iconCls: 'go',
		        title: '个人收入信息维护',
		        layout: 'fit',
		        frame:false,
		        html: "个人收入信息维护."
		    },{
		    	id : 'jobInfo',
		        iconCls: 'go',
		        title: '就业信息维护',
		        frame:false,
		        html: "就业信息维护."
		    },{
		    	id : 'educationInfo',
		        iconCls: 'go',
		        title: '教育信息维护',
		        frame:false,
		        html: "教育信息维护."
		    },{
		    	id : 'insuranceInfo',
		        iconCls: 'go',
		        title: '社会保险信息维护',
		        frame:false,
		        html: "社会保险信息维护."
		    },{
		    	id : 'otherInfo',
		        iconCls: 'go',
		        title: '人员其他信息维护',
		        frame:false,
		        html: "人员其他信息维护."
		    }]
		});
	Ext.create('Ext.container.Viewport',{
        layout: 'border',
        renderTo : Ext.getBody(),
    	items: [
   	         {
   	            region: 'east',
       	        title: '家庭信息查询列表',
 	            width: 290,
 	            collapsible: true,
 	            autoScroll: true,
 	  			layout:'fit',
   	            items:[rightPanel]
   	        },{
   	        	region: 'center',
   	        	layout: 'fit',
   	        	 autoScroll: true,
   	        	items:[tabs]
   	        }
   	        ]
	});
});
</script>
<style type="text/css">
.go {
	background-image: url( <%=basePath%>image/arrow_right.png) !important;
}
</style>
</head>
<body>
</body>
</html>