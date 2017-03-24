<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="col-xs-2 sidebar rf-col-1">
    <div id="rf-col-1-body">
        <div id="dd-workspace-wrapper"></div>
        <br>
        <div class="rf-margin-5">
            <h6 class="rf-h6">项目&nbsp;&nbsp;</h6>
            <button class="btn btn-default btn-xs pull-right rf-btn-margin-2" data-toggle="modal" data-target="#projectModal" >
                <span class="glyphicon glyphicon-plus rf-plus-font"></span>
            </button>
        </div>
        <ul class="nav nav-pills nav-stacked rf-left-nav" id="test_project">
        </ul>
        <br>
        <div class="left-menu-divider"></div>
        <br>
        <div class="rf-margin-5">
            <h6 class="rf-h6">标签&nbsp;&nbsp;</h6>
            <button class="btn btn-default btn-xs pull-right rf-btn-margin-2" data-toggle="modal" data-target="#tagModal" >
                <span class="glyphicon glyphicon-plus rf-plus-font"></span>
            </button>
        </div>
        <ul class="nav nav-pills nav-stacked rf-left-nav" id="rfTags">
        </ul>
        <br>
        <div class="left-menu-divider"></div>
        <br>
        <div>
            <h6 class="rf-h6 members-width">其他</h6>
        </div>
        <ul class="nav nav-pills nav-stacked rf-left-nav">
            <li class="list-view-menu-item starred"><a href="#/starred"><span class="glyphicon glyphicon-star"></span>&nbsp;&nbsp;收藏</a></li>
            <li class="list-view-menu-item history"><a href="#/activityLog"><span class="glyphicon glyphicon-time"></span>&nbsp;&nbsp;操作记录
            </a></li>
            <li><a href="#" data-toggle="modal" data-target="#globalSettingsModal"> <span class="glyphicon glyphicon-wrench"></span>&nbsp;&nbsp; 配置
            </a></li>
        </ul>
        <br>
        <div class="left-menu-divider"></div>
        <br>
        <div>
            <h6 class="rf-h6 members-width">成员</h6>
            <button class="btn btn-default btn-xs pull-right rf-btn-margin-2" id="manageCollaboratorsMenu" data-toggle="modal" data-target="#manageCollaboratorsModal" >
                <span class="glyphicon glyphicon-plus rf-plus-font"></span>
            </button>
        </div>
        <ul class="nav nav-sidebar" id="rfUsers">
            <li>
            </li>
        </ul>
    </div>
    <br><br><br>
</div>
