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
Ext.require(['Ext.data.*', 'Ext.tree.*', 'Ext.tab.*', 'Ext.panel.*',  
             'Ext.container.Viewport']);  
       
     Ext.onReady(function() {  
         Ext.QuickTips.init();  
           
          Ext.define("treeModel", { // 定义树节点数据模型  
             extend : "Ext.data.Model",  
             fields : [{  
                         name : "id",  
                         type : "string"  
                     }, {  
                         name : "text",  
                         type : "string"  
                     }, {  
                         name : "iconCls",  
                         type : "string"  
                     }, {  
                         name : "leaf",  
                         type : "boolean"  
                     }, {  
                         name : 'type',  
                         type : "string"  
                     }, {  
                         name : 'component',  
                         type : "string"  
                     }, {  
                         name : 'url',  
                         type : "string"  
                     }]  
         });  
         var treeStore = Ext.create('Ext.data.TreeStore', {  
                     model : 'treeModel',  
                     proxy : {  
                         type : 'ajax',  
                         url : 'm.json'  
                     },  
                     folderSort : true  
                 });  
         var tree = Ext.create('Ext.tree.Panel', {  
                     title : '问卷管理',  
                     animate : true, // 有滑动效果  
                     autoScroll : true,  
                     autoHeight : true,  
                     width : '100%',  
                     collapsible : true,  
                     expanded : true,  
                     rootVisible : true,  
                     store : treeStore  
                 });  
       
         var centerTab = Ext.create('Ext.tab.Panel', {  
                     activeTab : 0,  
                     enableTabScroll : true,  
                     animScroll : true,  
                     border : true,  
                     autoScroll : true,  
                     region : 'center',  
                     split : true,  
                     items : [{  
                                 iconCls : 'icon-activity',  
                                 title : '首页',  
                                 html : '<h1>hello</h1>'  
                             }]  
                 });  
         var westTree = Ext.create("Ext.panel.Panel", {  
                     region : 'west',  
                     title : "系统菜单",  
                     width : 200,  
                     iconCls : "icon-tree",  
                     autoScroll : false,  
       
                     layout : 'accordion',  
                     collapsible : true,  
                     layoutConfig : {  
                         animate : true  
                     },  
                     items : [tree],  
                     split : true  
                 });  
         var northTitle = Ext.create("Ext.panel.Panel", {  
                     height : 75,  
                     html : '1111111111111',  
                     region : 'north',  
                     split : true  
       
                 });  
         Ext.create('Ext.container.Viewport', {  
                     layout : 'border',  
                     items : [northTitle, centerTab, westTree]  
       
                 });  
       
     });  

</script>
<title>Insert title here</title>
</head>
<body>

</body>
</html>