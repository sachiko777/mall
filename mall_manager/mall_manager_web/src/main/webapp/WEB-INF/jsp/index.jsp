<%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2019/7/12
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mall</title>
    <link rel="stylesheet" type="text/css" href="/css/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/css/themes/icon.css">
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.easyui.min.js"></script>
</head>
<body>

<body class="easyui-layout">
<div data-options="region:'west',title:'菜单',split:true,minWidth:180" style="width:100px;">
    <ul id="tt" class="easyui-tree">
        <li>
            <span>商品管理</span>
            <ul>
                <li data-options="attributes:{'url':'product_list'}"><span>商品列表</span></li>
                <li data-options="attributes:{'url':'product_add'}"><span>商品添加</span></li>
            </ul>
        </li>
        <li>
            <span>商品分类管理</span>
            <ul>
                <li data-options="attributes:{'url':'product_cat_list'}"><span>商品分类列表</span></li>
            </ul>
        </li>
    </ul>
</div>
<div data-options="region:'center'" style="padding:5px;background:#eee;">
    <div id="tabs" class="easyui-tabs" >
        <div title="首页" style="padding:20px;display:none;">
            首页
        </div>
        <%--<div title="Tab2" data-options="closable:true" style="overflow:auto;padding:20px;display:none;">--%>
            <%--tab2--%>
        <%--</div>--%>
        <%--<div title="Tab3" data-options="iconCls:'icon-reload',closable:true" style="padding:20px;display:none;">--%>
            <%--tab3--%>
        <%--</div>--%>
    </div>
</div>
</body>



<script>
    $('#tt').tree({
        onClick: function(node){
            // 获取选中的标签页面板（tab panel）
            var tabs = $('#tabs');
            var tab = tabs.tabs('getTab',node.text);

            if(tab){
                tabs.tabs("select",node.text)
            }else{
                // 添加一个新的标签页面板（tab panel）
                $('#tabs').tabs('add',{
                    title:node.text,
                    content:'Tab Body',
                    closable:true,
                    href:node.attributes.url
                });
            }



        }
    });


</script>
</body>
</html>
