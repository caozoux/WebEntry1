<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">kernel khotfix</li>
        <li id="infoupdate">
          <a href="/oskhotfix/hotfix/hotfix_info_update.jsp">
            <i class="fa fa-dashboard"></i> patch提交<i class="fa fa-angle-left pull-right"></i>
          </a>
        </li>
        <li id="hotfix_mergePatch" class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>patch合入</span> <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li id="ker7u" class=""><a href="/oskhotfix/hotfix/hotfix_mergePatch.jsp"><i class="fa fa-circle-o"></i> 3.14 </a></li>
            <li><a href="index2.html"><i class="fa fa-circle-o"></i> 4.9 </a></li>
          </ul>
        </li>
        <li id="patchlist" class="treeview">
          <a href="#">
            <i class="fa fa-files-o"></i>
            <span>patch 处理列表</span>
            <span class="label label-primary pull-right">4</span>
          </a>
          <ul class="treeview-menu">
            <li><a href="/oskhotfix/hotfix_servlet_listshow"><i class="fa fa-circle-o"></i>patches</a></li>
          </ul>
        </li>

        <li id="hotfix_manage" class="treeview">
          <a href="#">
			<i class="fa fa-random"></i>
            <span>hotfix 管理</span>
			<i class="fa fa-angle-left pull-right"></i>
            <i class="fa fa-angle-left pull-right"></i>
          </a>

          <ul class="treeview-menu">
            <li id="hotfix_manage_view"><a href="/oskhotfix/hotfix/hotfix_manage_view.jsp"><i class="fa fa-search"></i> 查询</a></li>
            <li id="hotfix_manage_add"><a href="/oskhotfix/hotfix/hotfix_manage_add.jsp"><i class="fa fa-plus-square-o"></i>添加</a></li>
            <li id="hotfix_manage_config"><a href="/oskhotfix/hotfix/hotfix_manage_config.jsp"><i class="fa fa-wrench"></i> 配置</a></li>
          </ul>
        </li>

        <li class="treeview">
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>hotfix 打包</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="/oskhotfix/hotfix/hotfix_rpmbuild.jsp"><i class="fa fa-circle-o"></i> 打包</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>业务部署数据</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="/oskhotfix/hotfix/hotfix_rpmbuild.jsp"><i class="fa fa-circle-o"></i>列表</a></li>
            <li><a href="/oskhotfix/hotfix/hotfix_rpmbuild.jsp"><i class="fa fa-circle-o"></i>配置</a></li>
          </ul>
        </li>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>
