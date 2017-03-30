<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="navbar navbar-fixed-top rest-navbar">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span>
            </button>
            <div class="dropdown rf-dropdown">
                <button class="btn btn-default" type="button" data-toggle="dropdown">
                    <span class='glyphicon glyphicon-align-justify'></span>
                </button>
                <ul class="dropdown-menu rf-menu-width">
                    <li><a href="#" data-toggle="modal" data-target="#workspaceModal">新建Workspace</a></li>
                    <li><a href="#" id="switchWorkSpace" class="dummySwitchWorkspace">切换Workspace</a></li>
                    <li class="divider"></li>
                    <li><a href="#" data-toggle="modal" data-target="#projectModal">新建项目</a></li>
                    <li class="divider"></li>
                    <li><a href="#" data-toggle="modal" data-target="#updateProfileModal">个人资料</a></li>
                    <li><a href="#" data-toggle="modal" data-target="#changePasswordModal">修改密码</a></li>
                    <li class="divider"></li>
                    <li><a href="#" data-toggle="modal" id="manageEnvironments" data-target="#manageEnvironmentsModal">环境配置</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="#" data-toggle="modal" data-target="#collaboratorModal">添加成员</a></li>
                    <li><a href="#" data-toggle="modal" id="manageUsersMenu" data-target="#manageCollaboratorsModal">管理成员</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="#" data-toggle="modal" id="globalSettings" data-target="#globalSettingsModal">系统配置</a>
                    </li>
                </ul>
            </div>
            <a class="navbar-brand rest-navbar-brand" href="/">RestFeel接口测试平台</a>
        </div>

        <div class="nav-item"><a class="navbar-brand rest-navbar-item" href="#" style="color: rgb(255,255,255); font-size: 14px;">需求管理</a></div>
        <div class="nav-item"><a class="navbar-brand rest-navbar-item" href="#" style="color: rgb(255,255,255); font-size: 14px;">项目管理</a></div>
        <div class="nav-item"><a class="navbar-brand rest-navbar-item" href="#" style="color: rgb(255,255,255); font-size: 14px;">持续集成</a></div>
        <div class="nav-item"><a class="navbar-brand rest-navbar-item" href="#" style="color: rgb(255,255,255); font-size: 14px;">缺陷管理</a></div>
        <div class="nav-item"><a class="navbar-brand rest-navbar-item" href="blogs.do" style="color: rgb(255,255,255); font-size: 14px;">技术社区</a></div>

        <div class="navbar-collapse collapse collapse" aria-expanded="false">
            <ul class="nav navbar-nav navbar-right">
                <li class="env-selectbox">
                    <select class="environmentsSelectBox form-control" placeholder="Seclect Environment"></select>
                </li>
                <li class="btn-group">
                    <button type="button" class="username dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        ${currentUser.username}<span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="http://www.restfiddle.com/" target="_blank">关于</a></li>
                        <li class="divider"></li>
                        <li><a href="https://github.com/Jason-Chen-2017/restfeel" target="_blank">GitHub</a></li>
                        <li class="divider"></li>
                        <li><a href="http://restfiddle.blogspot.com/" target="_blank">文档</a></li>
                        <li class="divider"></li>
                        <li><a href="https://github.com/Jason-Chen-2017/restfeel" target="_blank">联系我们</a></li>
                        <li class="divider"></li>
                        <li>
                            <form action="/logout">
                                <button class="logout-btn" type="submit">退出</button>
                            </form>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>

    </div>
</div>
