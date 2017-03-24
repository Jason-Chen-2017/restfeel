<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="col-xs-4 rf-col-2">
    <br>
    &nbsp;
    <button class="btn btn-default btn-sm col-1-toggle-btn">
        <i id="col1-toggle-icon" class="fa fa-angle-double-left"></i>
    </button>
    &nbsp;
    <div class="btn-group" id="newRequestDropdown">
        <button class="btn btn-default btn-sm" data-toggle="modal" id="requestBtn">新建请求</button>
        <button type="button" class="btn btn-sm btn-default dropdown-toggle" data-toggle="dropdown">
            <span class="caret"></span> <span class="sr-only">Toggle Dropdown</span>
        </button>
        <ul class="dropdown-menu pull-right">
            <li><a href="#" class="btn-sm" data-toggle="modal" data-target="#folderModal">新文件夹</a></li>
            <li class="divider"></li>
            <li><a class="rf-font-12" data-toggle="modal" data-target="#socketModal">新建Socket</a></li>
            <li class="divider"></li>
            <li><a href="#" class="btn-sm" data-toggle="modal" data-target="#entityModal">新建Entity</a></li>
        </ul>
    </div>
    &nbsp;
    <div class="btn-group">
        <button class="btn btn-default btn-sm run-project"  data-toggle="tooltip" data-placement="bottom" data-container="body" title="Run project lets you run requests together.">运行项目</button>
    </div>
     &nbsp;
     <div class="btn-group" id="sortOptionsDropdown">
        <button type="button" class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown">
            排序&nbsp;&nbsp;<span class="caret"></span>
        </button>
        <ul class="dropdown-menu pull-right">
            <li><a class="rf-font-12" data-toggle="modal" id="sortByName">名称升序</a></li>
            <li><a class="rf-font-12" data-toggle="modal" id="sortByNameDesc">名称降序</a></li>
            <li><a class="rf-font-12" data-toggle="modal" id="sortByLastRun">最近运行升序</a></li>
            <li><a class="rf-font-12" data-toggle="modal" id="sortByLastRunDesc">最近运行降序</a></li>
            <li><a class="rf-font-12" data-toggle="modal" id="sortByLastModified">编辑时间升序</a></li>
            <li><a class="rf-font-12" data-toggle="modal" id="sortByLastModifiedDesc">编辑时间降序</a></li>
        </ul>
    </div>
    &nbsp;
    <div class="btn-group" id="moreOptionsDropdown">
        <button type="button" class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown">
            更多&nbsp;&nbsp;<span class="caret"></span>
        </button>
        <ul class="dropdown-menu pull-right">
            <li><a class="rf-font-12" data-toggle="modal" id="expandAllNodes">展开</a></li>
            <li><a class="rf-font-12" data-toggle="modal" id="collapseAllNodes">收起</a></li>
            <li class="divider"></li>
            <li><a class="rf-font-12 socket-connector">Socket</a></li>
            <li class="divider"></li>
            <li><a class="rf-font-12" id="editNodeMenuItem">编辑节点</a></li>
            <li><a class="rf-font-12" data-toggle="modal" data-target="#deleteNodeModal">删除节点</a></li>
            <li class="divider"></li>
            <li><a class="rf-font-12" data-toggle="modal" data-target="#importModal">导入</a></li>
            <li class="divider"></li>
            <li><a class="rf-font-12" data-toggle="tooltip" data-placement="bottom" data-container="body" title="Flat View shows requests only." id="showFlatView">平铺</a></li>
            <li><a class="rf-font-12" data-toggle="tooltip" data-placement="bottom" data-container="body" title="Tree View shows tree structure of project." id="showTreeView">树状</a></li>
        </ul>
    </div>

    <div class="btn-group" id="searchBox">
	    <div class="input-group stylish-input-group">
	         <input type="text" class="form-control"  placeholder="Search"  id="search">
	         <span class="input-group-addon">
	             <button id="searchbtn" type="submit">
	                 <span class="glyphicon glyphicon-search"></span>
	             </button>
	         </span>
         </div>
    </div>


    <ul class="nav nav-pills nav-stacked rf-left-nav" id="starred-items">
    </ul>

    <ul class="nav nav-pills nav-stacked rf-left-nav" id="tagged-items">
    </ul>

    <ul class="nav nav-pills nav-stacked rf-left-nav" id="history-items">
    </ul>

    <ul class="nav nav-pills nav-stacked rf-left-nav" id="requests-items">
    </ul>

    <div id="tree" class="fancytree-colorize-hover"></div>
    <br><br>
</div>
