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
			this.topPanel = Ext.create('Ext.panel.Panel', {
						region : 'north',
						height : 55
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
									var id = record.get('id');
									var text = record.get('text');
									var leaf = record.get('leaf');
									if (leaf) {
										alert('id-' + id + ',text-' + text
												+ ',leaf-' + leaf);
									}
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