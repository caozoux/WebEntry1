<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">kernel khotfix</li>
        <li class="active treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <a href="/WebEntry/hotfix/hotfix_info_update.jsp">patch提交</a> <i class="fa fa-angle-left pull-right"></i>
          </a>
        </li>
        <li class="active treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>patch合入</span> <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li class="active"><a href="/WebEntry/hotfix/hotfix_mergePatch.jsp"><i class="fa fa-circle-o"></i> 3.14 </a></li>
            <li><a href="index2.html"><i class="fa fa-circle-o"></i> 4.9 </a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-files-o"></i>
            <span>patch 处理列表</span>
            <span class="label label-primary pull-right">4</span>
          </a>
          <ul class="treeview-menu">
            <li><a href="/WebEntry/hotfix_servlet_listshow"><i class="fa fa-circle-o"></i>patches</a></li>
          </ul>
        </li>

        <li class="treeview">
          <a href="#">
			<i class="fa fa-random"></i>
            <span>hotfix 管理</span>
			<i class="fa fa-angle-left pull-right"></i>
            <i class="fa fa-angle-left pull-right"></i>
          </a>

          <ul class="treeview-menu">
            <li><a href=""><i class="fa fa-search"></i> 查询</a></li>
            <li><a href=""><i class="fa fa-plus-square-o"></i>添加</a></li>
            <li><a href=""><i class="fa fa-wrench"></i> 配置</a></li>
          </ul>
        </li>

        <li class="treeview">
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>hotfix 打包</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="/WebEntry/hotfix/hotfix_rpmbuild.jsp"><i class="fa fa-circle-o"></i> 打包</a></li>
            <li><a href=""><i class="fa fa-circle-o"></i> 回归测试</a></li>
            <li><a href=""><i class="fa fa-circle-o"></i> 正式包信息更新</a></li>
            <li><a href=""><i class="fa fa-circle-o"></i> 转正式包</a></li>
          </ul>
        </li>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>