<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 2 | Dashboard</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="/WebEntry/resource/css/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/WebEntry/resource/css/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="/WebEntry/resource/css/dist/css/skins/_all-skins.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="/WebEntry/resource/css/plugins/iCheck/flat/blue.css">
  <!-- Morris chart -->
  <link rel="stylesheet" href="/WebEntry/resource/css/plugins/morris/morris.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href="/WebEntry/resource/css/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <!-- Date Picker -->
  <link rel="stylesheet" href="/WebEntry/resource/css/plugins/datepicker/datepicker3.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="/WebEntry/resource/css/plugins/daterangepicker/daterangepicker-bs3.css">
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="/WebEntry/resource/css/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn t work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <header class="main-header">
    <!-- Logo -->
    <a href="index2.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>A</b>LT</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Admin</b>LTE</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
          <li class="dropdown messages-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-envelope-o"></i>
              <span class="label label-success">4</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 4 messages</li>
              <li>
                <!-- inner menu: contains the actual data -->
                <ul class="menu">
                  <li><!-- start message -->
                    <a href="#">
                      <div class="pull-left">
                        <img src="/WebEntry/resource/css/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        Support Team
                        <small><i class="fa fa-clock-o"></i> 5 mins</small>
                      </h4>
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
                  <!-- end message -->
                  <li>
                    <a href="#">
                      <div class="pull-left">
                        <img src="/WebEntry/resource/css/dist/img/user3-128x128.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        AdminLTE Design Team
                        <small><i class="fa fa-clock-o"></i> 2 hours</small>
                      </h4>
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <div class="pull-left">
                        <img src="/WebEntry/resource/css/dist/img/user4-128x128.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        Developers
                        <small><i class="fa fa-clock-o"></i> Today</small>
                      </h4>
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <div class="pull-left">
                        <img src="/WebEntry/resource/css/dist/img/user3-128x128.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        Sales Department
                        <small><i class="fa fa-clock-o"></i> Yesterday</small>
                      </h4>
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <div class="pull-left">
                        <img src="/WebEntry/resource/css/dist/img/user4-128x128.jpg" class="img-circle" alt="User Image">
                      </div>
                      <h4>
                        Reviewers
                        <small><i class="fa fa-clock-o"></i> 2 days</small>
                      </h4>
                      <p>Why not buy a new awesome theme?</p>
                    </a>
                  </li>
                </ul>
              </li>
              <li class="footer"><a href="#">See All Messages</a></li>
            </ul>
          </li>
          <!-- Notifications: style can be found in dropdown.less -->
          <li class="dropdown notifications-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-bell-o"></i>
              <span class="label label-warning">10</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 10 notifications</li>
              <li>
                <!-- inner menu: contains the actual data -->
                <ul class="menu">
                  <li>
                    <a href="#">
                      <i class="fa fa-users text-aqua"></i> 5 new members joined today
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-warning text-yellow"></i> Very long description here that may not fit into the
                      page and may cause design problems
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-users text-red"></i> 5 new members joined
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-shopping-cart text-green"></i> 25 sales made
                    </a>
                  </li>
                  <li>
                    <a href="#">
                      <i class="fa fa-user text-red"></i> You changed your username
                    </a>
                  </li>
                </ul>
              </li>
              <li class="footer"><a href="#">View all</a></li>
            </ul>
          </li>
          <!-- Tasks: style can be found in dropdown.less -->
          <li class="dropdown tasks-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-flag-o"></i>
              <span class="label label-danger">9</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 9 tasks</li>
              <li>
                <!-- inner menu: contains the actual data -->
                <ul class="menu">
                  <li><!-- Task item -->
                    <a href="#">
                      <h3>
                        Design some buttons
                        <small class="pull-right">20%</small>
                      </h3>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">20% Complete</span>
                        </div>
                      </div>
                    </a>
                  </li>
                  <!-- end task item -->
                  <li><!-- Task item -->
                    <a href="#">
                      <h3>
                        Create a nice theme
                        <small class="pull-right">40%</small>
                      </h3>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-green" style="width: 40%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">40% Complete</span>
                        </div>
                      </div>
                    </a>
                  </li>
                  <!-- end task item -->
                  <li><!-- Task item -->
                    <a href="#">
                      <h3>
                        Some task I need to do
                        <small class="pull-right">60%</small>
                      </h3>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-red" style="width: 60%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">60% Complete</span>
                        </div>
                      </div>
                    </a>
                  </li>
                  <!-- end task item -->
                  <li><!-- Task item -->
                    <a href="#">
                      <h3>
                        Make beautiful transitions
                        <small class="pull-right">80%</small>
                      </h3>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-yellow" style="width: 80%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">80% Complete</span>
                        </div>
                      </div>
                    </a>
                  </li>
                  <!-- end task item -->
                </ul>
              </li>
              <li class="footer">
                <a href="#">View all tasks</a>
              </li>
            </ul>
          </li>
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="/WebEntry/resource/css/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs">user name</span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="/WebEntry/resource/css/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                <p>
                  Alexander Pierce - Web Developer
                  <small>Member since Nov. 2012</small>
                </p>
              </li>
              <!-- Menu Body -->
              <li class="user-body">
                <div class="row">
                  <div class="col-xs-4 text-center">
                    <a href="#">Followers</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Sales</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Friends</a>
                  </div>
                </div>
                <!-- /.row -->
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
                  <a href="#" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          <li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">kernel khotfix</li>
        <li class="active treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>3.10 patch合入</span> <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li class="active"><a href="index.html"><i class="fa fa-circle-o"></i> khotfix patch 合入</a></li>
            <li><a href="index2.html"><i class="fa fa-circle-o"></i> khotfix patch 追加分支 </a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>4.9 patch合入</span> <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li class="active"><a href="index.html"><i class="fa fa-circle-o"></i> khotfix patch 合入</a></li>
            <li><a href="index2.html"><i class="fa fa-circle-o"></i> khotfix patch 追加分支 </a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-files-o"></i>
            <span>patch 处理列表</span>
            <span class="label label-primary pull-right">4</span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/layout/top-nav.html"><i class="fa fa-circle-o"></i> Top Navigation</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>hotfix 打包</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/charts/chartjs.html"><i class="fa fa-circle-o"></i> 打包</a></li>
            <li><a href="pages/charts/morris.html"><i class="fa fa-circle-o"></i> 回归测试</a></li>
            <li><a href="pages/charts/flot.html"><i class="fa fa-circle-o"></i> 正式包信息更新</a></li>
            <li><a href="pages/charts/flot.html"><i class="fa fa-circle-o"></i> 转正式包</a></li>
          </ul>
        </li>
		<li>
			<a href="pages/calendar.html">
			<i class="fa fa-calendar"></i> <span>hotfix update</span>
			</a>
		</li>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Dashboard
        <small>Control panel</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Dashboard</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
		<div class="row">
			<div class="box box-primary">
				<%@ page language="java" import="hotfix.db.hitfix_rpminfo_bean" %>
				<% 
					hitfix_rpminfo_bean  o_akid= (hitfix_rpminfo_bean)request.getAttribute("akid_obj");
				%>
				<div class="box-header with-border">
					<h3 class="box-title" id="akid_title"><%=o_akid.getAkid()%></h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<div id="top">
						<div class="form-group">
							<strong style="display:none">aone_link</strong>
							<strong>aone</strong>
							<button type="submit" class="btn btn-info pull-right btn-xs editevent">edit</button>
						</div>
						<p class="text-muted">
							<a href="<%=o_akid.getLink()%>"><%=o_akid.getLink()%></a>
						</p>
						<form class="form-horizontal" style="display:none" id="aoneform">
							<input type="text" class="form-control"  id="akid_aone" name="<%=o_akid.getAkid()%>" value="<%=o_akid.getLink()%>">
							<button type="button" class="btn btn-info btn-flat akid_submit">提交</button>
						</form>
						<hr>
					</div>


					<div class="top">
						<div class="form-group">
							<strong style="display:none">description</strong>
							<strong>描述</strong>
							<button type="submit" class="btn btn-info pull-right btn-xs editevent">edit</button>
						</div>
						<p class="text-muted"><%=o_akid.getDescription()%></p>
						<form class="form-horizontal" style="display:none">
							<textarea class="form-control" id="akid_func_mod" rows="5"></textarea>
							<button type="button" class="btn btn-info btn-flat akid_submit">提交</button>
						</form>
						<hr>
					</div>


					<div class="top">
						<div class="form-group">
							<strong style="display:none">author</strong>
							<strong>作者</strong>
							<button type="submit" class="btn btn-info pull-right btn-xs editevent">edit</button>
						</div>
						<p class="text-muted" id="akid_author">
							<%=o_akid.getAuthor()%>
						</p>
						<form class="form-horizontal" style="display:none">
							<input type="text" class="form-control">
							<button type="button" class="btn btn-info btn-flat akid_submit">提交</button>
						</form>
						<hr>
					</div>

					<div class="top">
						<div class="form-group">
							<strong style="display:none">dispose</strong>
							<strong>部署方式</strong>
							<button type="submit" class="btn btn-info pull-right btn-xs editevent">edit</button>
						</div>
							<p> 请严格按照灰度部署，部署节奏由业务团队自行把控</p>
							<p> 建议方式：1台，5台，10台，50台，200台这样的节奏来进行，每次灰度之间要保留足够的观察期（如一周）</p>
						<form class="form-horizontal" style="display:none">
							<textarea class="form-control" id="akid_func_mod" rows="3"></textarea>
							<button type="button" class="btn btn-info btn-flat akid_submit">提交</button>
						</form>
							<hr>
					</div>

					<div class="top">
						<div class="form-group">
							<strong style="display:none">install</strong>
							<strong>安装方式</strong>
							<button type="submit" class="btn btn-info pull-right btn-xs editevent">edit</button>
						</div>
							<p>安装前准备： 无
							安装命令: 安装完成后，执行 khotfix-view -r 查看</p>
						<form class="form-horizontal" style="display:none">
							<textarea class="form-control" id="akid_func_mod" rows="3"></textarea>
							<button type="button" class="btn btn-info btn-flat akid_submit">提交</button>
						</form>
						<hr>
					</div>

					<div class="top">
						<div class="form-group">
							<strong stycle="display:none">unstall</strong>
							<strong>卸载方式</strong>
							<button type="submit" class="btn btn-info pull-right btn-xs editevent">edit</button>
						</div>
							<p> 卸载rpm包即可</p>
						<form class="form-horizontal" style="display:none">
							<textarea class="form-control" id="akid_func_mod" rows="3"></textarea>
							<button type="button" class="btn btn-info btn-flat akid_submit">提交</button>
						</form>
						<hr>
					</div>

					<div class="top">
						<div class="form-group">
							<strong>功能测试</strong>
							<button type="submit" class="btn btn-info pull-right btn-xs editevent">edit</button>
						</div>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam fermentum enim neque.</p>
						<form class="form-horizontal" style="display:none">
							<textarea class="form-control" id="akid_func_mod" rows="3"></textarea>
							<button type="button" class="btn btn-info btn-flat akid_submit">提交</button>
						</form>
						<hr>
					</div>

					<div class="top">
						<div class="form-group">
							<strong><i class="fa fa-file-text-o margin-r-5"></i>rpm包</strong>
							<button type="submit" class="btn btn-info pull-right btn-xs editevent">edit</button>
						</div>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam fermentum enim neque.</p>
						<div class="box">
							<div class="box-body no-padding">
								<table class="table table-condensed" id="rpmtable">
									<%@ page language="java" import="java.util.List" %>
									<%@ page language="java" import="hotfix.db.hotfix_rpmpackage_bean" %>
									<%
										List<hotfix_rpmpackage_bean> list=(List<hotfix_rpmpackage_bean>)request.getAttribute("rpmpackage_list");
										if (!list.isEmpty()) {
											for(hotfix_rpmpackage_bean rpmpackage_bean: list) {
												out.print("<tr>");
												out.print("<td>"+rpmpackage_bean.getKernel()+"</td>");
												out.print("<td><span class=\"\"><a href=\""+rpmpackage_bean.getDownlink()+"\">"+rpmpackage_bean.getRpmname()+"</a> </span></td>");
												out.print("</tr>");
											}
										}
									%>
								</table>
							</div>
						<!-- /.box-body -->
						</div>

						<form class="form-horizontal" style="display:none" action="../hotfix_info_item_update">
							<label class="control-label">yum rpm link</label>
							<textarea class="form-control" id="akid_func_mod" rows="3"></textarea>
							<button type="button" class="btn btn-info btn-flat " name="rpm_append" onclick="updateRpm">更新</button>
						</form>
						<hr>
					</div>

					<div class="top">
						<div class="form-group">
							<strong>修改函数</strong>
							<button type="submit" class="btn btn-info pull-right btn-xs editevent">edit</button>
						</div>
						<p>修改函数</p>
						<p>修改函数</p>
						<p>修改函数</p>
						<form class="form-horizontal" style="display:none">
							<textarea class="form-control" id="akid_func_mod" rows="3"></textarea>
							<button type="button" class="btn btn-info btn-flat akid_submit">提交</button>
						</form>
						<hr>
					</div>

					<div class="top">
						<div class="form-group">
							<strong>patch</strong>
							<button type="submit" class="btn btn-info pull-right btn-xs editevent">edit</button>
						</div>
							<%
							out.print("<a href=\"https://aone.alibaba-inc.com/code/"+o_akid.getAkid()+"\">"+"https://aone.alibaba-inc.com/code/"+o_akid.getAkid()+"</a>");
							%>
						<form class="form-horizontal" style="display:none">
							<input type="text" class="form-control" id="akid_code">
							<button type="button" class="btn btn-info btn-flat akid_submit">提交</button>
						</form>
						<hr>
					</div>
				</div>
				<!-- /.box-body -->
			</div>
		</div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Version</b> 2.3.3
    </div>
    <strong>Copyright &copy; 2014-2015 <a href="http://almsaeedstudio.com">Almsaeed Studio</a>.</strong> All rights
    reserved.
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Create the tabs -->
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
      <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
      <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
      <!-- Home tab content -->
      <div class="tab-pane" id="control-sidebar-home-tab">
        <h3 class="control-sidebar-heading">Recent Activity</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-birthday-cake bg-red"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                <p>Will be 23 on April 24th</p>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-user bg-yellow"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Frodo Updated His Profile</h4>

                <p>New phone +1(800)555-1234</p>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-envelope-o bg-light-blue"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Nora Joined Mailing List</h4>

                <p>nora@example.com</p>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-file-code-o bg-green"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Cron Job 254 Executed</h4>

                <p>Execution time 5 seconds</p>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

        <h3 class="control-sidebar-heading">Tasks Progress</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Custom Template Design
                <span class="label label-danger pull-right">70%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Update Resume
                <span class="label label-success pull-right">95%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-success" style="width: 95%"></div>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Laravel Integration
                <span class="label label-warning pull-right">50%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-warning" style="width: 50%"></div>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Back End Framework
                <span class="label label-primary pull-right">68%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-primary" style="width: 68%"></div>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

      </div>
      <!-- /.tab-pane -->
      <!-- Stats tab content -->
      <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
      <!-- /.tab-pane -->
      <!-- Settings tab content -->
      <div class="tab-pane" id="control-sidebar-settings-tab">
        <form method="post">
          <h3 class="control-sidebar-heading">General Settings</h3>

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Report panel usage
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Some information about this general settings option
            </p>
          </div>
          <!-- /.form-group -->

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Allow mail redirect
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Other sets of options are available
            </p>
          </div>
          <!-- /.form-group -->

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Expose author name in posts
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Allow the user to show his name in blog posts
            </p>
          </div>
          <!-- /.form-group -->

          <h3 class="control-sidebar-heading">Chat Settings</h3>

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Show me as online
              <input type="checkbox" class="pull-right" checked>
            </label>
          </div>
          <!-- /.form-group -->

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Turn off notifications
              <input type="checkbox" class="pull-right">
            </label>
          </div>
          <!-- /.form-group -->

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Delete chat history
              <a href="javascript:void(0)" class="text-red pull-right"><i class="fa fa-trash-o"></i></a>
            </label>
          </div>
          <!-- /.form-group -->
        </form>
      </div>
      <!-- /.tab-pane -->
    </div>
  </aside>
  <!-- /.control-sidebar -->
  <!-- Add the sidebar background. This div must be placed immediately after the control sidebar -->

  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.0 -->
<script src="/WebEntry/resource/css/plugins/jQuery/jQuery-2.2.0.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.6 -->
<script src="/WebEntry/resource/css/bootstrap/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<!-- <script src="/WebEntry/resource/css/plugins/morris/morris.min.js"></script>-->
<!-- Sparkline -->
<script src="/WebEntry/resource/css/plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="/WebEntry/resource/css/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/WebEntry/resource/css/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="/WebEntry/resource/css/plugins/knob/jquery.knob.js"></script>
<!-- daterangepicker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="/WebEntry/resource/css/plugins/daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="/WebEntry/resource/css/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="/WebEntry/resource/css/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="/WebEntry/resource/css/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/WebEntry/resource/css/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/WebEntry/resource/css/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/WebEntry/resource/css/dist/js/demo.js"></script>

<script type="text/javascript">
    $(document).ready(function(){
		$(".editevent").click(function() {
			console.log("1234")
			if ($(this).parent().parent().children(".form-horizontal").is(":hidden")) {
				$(this).parent().parent().children(".form-horizontal").show()
			} else {
				$(this).parent().parent().children(".form-horizontal").hide()
			}
			
		});
		$(".akid_submit").click(function() {
			akid_val=$("#akid_title").text()
			akid_item = $(this).parent().parent().children("div").children("strong:first").text();
			console.log($(this).parent().children("input").val())
			console.log(akid_val)
			console.log(akid_item)
			input_val = $(this).parent().children("input").val();
			if (input_val == "")
				return
			$.ajax({
                type: "GET",
				url: "hotfix_db_akid_show_update?akid="+akid_val+"&"+akid_item+"="+input_val,
                dataType: "text",
                success: function(data){
                    if(data=="true"){
                        $("#show").html("===ok==="+"<br/>"+"name="+$("[name=name]").val()+"<br/>"+"pwd="+$("[name=pwd]").val());
                    }else if(data=="false"){
                        $("#show").html("==信息不符合==");
                    }
                },
                error: function(){
                    $("#show").html("Error XMLHttpRequest");
                }
            });
			$(this).parent().hide()
		});
		$(".rpm_submit").click(function() {
			console.log($(this).attr("name"))
			$(this).parent().parent().parent().hide()
		});

		function updateRpm(){
			var rowTem ='<tr><td></td><td><span class="badge"><a href=""></a> </span></td></tr>'
			console.log("updateRpm")
			$("#rpmtable tbody:last").append(rowTem);
		}
	});
</script>

</body>
</html>
