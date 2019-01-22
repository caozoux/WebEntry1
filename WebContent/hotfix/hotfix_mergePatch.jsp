<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <%@ include file="./admin_start.jsp" %>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
  <!-- Left side column. contains the logo and sidebar -->
  <%@ include file="./admin_head.jsp" %>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
		Khotfix system
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Dashboard</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
		<div class="row">
			<div class="col-md-7">
				<div class="box box-primary">
					<div class="box-header with-border">
					  <h3 class="box-title">合入patch</h3>
					</div>
					<!-- form start -->
					<form role="form" action="../hotfix_servlet_patchmerge" method="post">
						<div class="box-body">
							<div class="form-group">
								<label for="inputName" class="col-sm-5 control-label">patch在git仓commit id</label>
								<input id="commitid" "type="txt" class="form-control" name="commit" placeholder="commit id">
							</div>
							<div class="form-group">
								<select id="kerver_select" multiple="multiple" name="kervels">
									<%@ page language="java" import="java.util.List" %>
									<%@ page language="java" import="hotfix.db.config.hotfix_db_config" %>
									<%@ page language="java" import="hotfix.db.config.hotfix_hibernate_config_bean" %>
									<% 
									hotfix_db_config fac = hotfix_db_config.getFactoryObj();
										List<hotfix_hibernate_config_bean> list=(List<hotfix_hibernate_config_bean>)fac.selectAll();
										if (list != null) {
											for(hotfix_hibernate_config_bean bean : list) {
												out.print("<option value=\""+bean.getKerver()+"\">"+bean.getKerver()+"</option>");
											}
										}
									%>
								</select>
							</div>
						</div>
						<div class="box-footer">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</form>
				</div>
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

<%@ include file="./admin_end.jsp" %>

<script type="text/javascript">
    $("#hotfix_mergePatch").addClass("active")
    $("#ker7u").addClass("active")
	$(document).ready(function(){
		$('#kerver_select').multiselect();
	});
</script>

</body>
</html>
