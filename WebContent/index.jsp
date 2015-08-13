<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="extjs5/ext-all.js"></script>
<script src="extjs5/ext-locale/ext-locale-zh_CN.js"></script>
<link href="extjs5/ext-theme-classic/build/resources/ext-theme-classic-all.css" rel="stylesheet" />
<script type="text/javascript">
/**
 * 程序主入口
 */
Ext.onReady(function() {
			/**
			 * 上,panel.Panel
			 */
			this.topPanel = Ext.create('Ext.Component', {
						region : 'north',
						height: 32, // give north and south regions a height
		                autoEl: {
		                    tag: 'div',
		                    html:'<p>吉林市最低生活保障救助信息管理系统 ver2.0</p>'
		                }
					});
			/**
			 * 左,panel.Panel
			 */
			this.leftPanel = Ext.create('Ext.panel.Panel', {
						region : 'west',
						title : '导航栏',
						width : 180,
						layout : 'accordion',
						collapsible : true
					});
			/**
			 * 右,tab.Panel
			 */
			this.rightPanel = Ext.create('Ext.tab.Panel', {
						region : 'center',
						layout : 'fit',
						tabWidth : 120,
						items : [{
									title : '首页'
								}]
					});
			/**
			 * 组建树
			 */
			var buildTree = function(json) {
				return Ext.create('Ext.tree.Panel', {
							rootVisible : false,
							border : false,
							store : Ext.create('Ext.data.TreeStore', {
										root : {
											expanded : true,
											children : json.children
										}
									}),
							listeners : {
								'itemclick' : function(view, record, item,
										index, e) {
									 //点击菜单时，执行main.js里的addTab方法。 
						            //传递的参数包括当前点击节点的id,url,文本信息text,是否是叶子leaf。 
						        	var n = rightPanel.getComponent(record.raw.menuId);  
					                 if(record.raw.menuId=='root'){  
					                    return;  
					                 }  
					                   if (!n) { // 判断是否已经打开该面板  
					                	   if(record.raw.leaf){
					                		   n = rightPanel.add({  
		                                            'id' : record.raw.menuId,  
		                                            'title' : record.raw.menuname,  
		                                             closable : true, // 通过html载入目标页  
		                                             html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="'+record.raw.menuurl+'"></iframe>'
		                                             //html:r.raw.id
		                                        });
					                	   }
		                                       
					                   }  
					                   rightPanel.setActiveTab(n);
								},
								scope : this
							}
						});
			};
			/**
			 * 加载菜单树
			 */
			Ext.Ajax.request({
						url : 'main/biz/getmenujson.do',
						success : function(response) {
							var json = Ext.JSON.decode(response.responseText)
							Ext.each(json.data, function(el) {
										var panel = Ext.create(
												'Ext.panel.Panel', {
													id : el.id,
													title : el.text,
													animate : true, // 有滑动效果  
								                    autoScroll : true,  
								                    autoHeight : true,  
								                    collapsible : true,  
								                    expanded : true,
								                    rootVisible : true
												});
										panel.add(buildTree(el));
										leftPanel.add(panel);
									});
						},
						failure : function(request) {
							Ext.MessageBox.show({
										title : '操作提示',
										msg : "连接服务器失败",
										buttons : Ext.MessageBox.OK,
										icon : Ext.MessageBox.ERROR
									});
						},
						method : 'post'
					});
			/**
			 * Viewport
			 */
			Ext.create('Ext.container.Viewport', {
						layout : 'border',
						renderTo : Ext.getBody(),
						items : [this.topPanel, this.leftPanel, this.rightPanel]
					});
		});


</script>
<title>Insert title here</title>
</head>
<body>

</body>
</html>