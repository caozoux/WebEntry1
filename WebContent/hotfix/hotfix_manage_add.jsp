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
			<div class="col-xs-12">
			<button id="btn_add" class="btn btn-primary btn-small" data-toggle="modal" data-target="#modal"  href="/Home/Test">新增Hotfix</button>
			  <div class="box">
				<div class="box-header">
				  <h3 class="box-title">Hotfix管理</h3>
				</div>
				<div class="k-header k-grid-toolbar">
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="firsttable" class="table table-bordered table-hover">
						<tbody>
							<thead>
								<tr>
								  <th> </th>
								  <th>ID </th>
								  <th>名称</th>
								  <th>描述</th>
								  <th>ReleaseNote</th>
								  <th>备注</th>
								  <th>合入版本</th>
								  <th>创建人</th>
								  <th>更新时间</th>
								  <th></th>
								</tr>
							</thead>
							<tr>
								<td id="pushselect"><i class="fa fa-fw fa-sort-down"></i> </th>
								<td>Trident</td>
								<td>Internet Explorer 4.0 </td>
								<td>Win 95+</td>
								<td> 4</td>
								<td>X</td>
							</tr>
						</tbody>
					</table>
					<table id="tablehide" class="table" frame=void style="display:none" >
						<tbody>
							<tr >
								<td width="40px"></td>
								<td id="test22">
									<table id="" class="table table-bordered table-hover" >
										<thead>
										<tr>
										  <th>内核版本 </th>
										  <th>Hotfix包</th>
										  <th>是否通用</th>
										  <th>适用范围</th>
										  <th>发布时间</th>
										  <th>备注</th>
										  <th></th>
										</tr>
										</thead>
										<tbody>
										<tr>
										  <td>Trident</td>
										  <td>Internet
											Explorer 4.0
										  </td>
										  <td>Win 95+</td>
										  <td> 4</td>
										  <td>X</td>
										</tr>
										</tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
        <!-- /.col -->
		</div>
		<!-- /.row (main row) -->

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

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">新增</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="txt_departmentname">名称</label>
                        <input type="text" name="txt_departmentname" class="form-control" id="addhotfix_name" placeholder="内核版本">
                    </div>
                    <div class="form-group">
                        <label for="txt_departmentname">描述</label>
                        <input type="text" name="txt_departmentname" class="form-control" id="addhotfix_desc" placeholder="描述">
                    </div>
                    <div class="form-group">
                        <label for="txt_departmentname">ReleaseNote</label>
                        <input type="text" name="txt_departmentname" class="form-control" id="addhotfix_name" placeholder="releasenote">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
                    <button type="button" id="kerver_submit" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>提交</button>
                </div>
            </div>
        </div>
</div>

<script type="text/javascript">

    $("#hotfix_manage").addClass("active")
    $("#hotfix_manage_add").addClass("active")

	$("#pushselect").click(function () {
		console.log($(this).parent().parent().val())
		input_val = $(this).parent().parent().children("#rpmlistshow").show();
	});

	$("#btn_add").click(function () {
		$("#myModalLabel").text("新增");
		$('#myModal').modal();
	});


	$("#kerver_submit").click(function () {
		 var json = {
			kerver: $("#txt_kerver").val(),
			desc: $("#txt_desc").val()
    	};
		console.log(json)
		console.log(JSON.stringify(json))
		$.ajax({
			type: "post",
			url: "/oskhotfix/hotfix_servlet_mangeUpdate_ajax",
			data: "json="+JSON.stringify(json),
			dataType: "json",
			success: function (message) {
				alert("okay");
			},
			error: function (message) {
				alert("faled");
			}
		});
	});

	$("#pushselect").click(function () {
		obj=$(this).parent().parent().parent()
		hideobj=obj.next()
		if(hideobj.is(":hidden"))
			hideobj.show()
		else
			hideobj.hide()
	});

    $(document).ready(function(){
	});
</script>

</body>
</html>
