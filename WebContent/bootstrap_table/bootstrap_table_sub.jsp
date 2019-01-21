<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <%@ include file="../hotfix/admin_start.jsp" %>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
  <!-- Left side column. contains the logo and sidebar -->
  <%@ include file="../hotfix/admin_head.jsp" %>

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
		   <div class="panel-body" style="padding-bottom:0px;">
				<div class="panel panel-default">
					<div class="panel-heading">查询条件</div>
					<div class="panel-body">
						<form id="formSearch" class="form-horizontal">
							<div class="form-group" style="margin-top:15px">
								<label class="control-label col-sm-1" for="txt_search_departmentname">部门名称</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="txt_search_departmentname">
								</div>
								<label class="control-label col-sm-1" for="txt_search_statu">状态</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="txt_search_statu">
								</div>
								<div class="col-sm-4" style="text-align:left;">
									<button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary">查询</button>
								</div>
							</div>
						</form>
					</div>
				</div>       

				<div id="toolbar" class="btn-group">
					<button id="btn_add" type="button" class="btn btn-default">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
					</button>
					<button id="btn_edit" type="button" class="btn btn-default">
						<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
					</button>
					<button id="btn_delete" type="button" class="btn btn-default">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
					</button>
				</div>
<table id="table"
  data-detail-view="true">
  <thead>
  <tr>
    <th data-field="id">ID</th>
    <th data-field="name">Item Name</th>
    <th data-field="price">Item Price</th>
  </tr>
  </thead>
</table>

<table id="table2"></table>


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

<%@ include file="../hotfix/admin_end.jsp" %>

<script type="text/javascript">
var $table = $('#table')

function buildTable($el, cells, rows) {
  var i; var j; var row
  var columns = []
  var data = []

  for (i = 0; i < cells; i++) {
    columns.push({
      field: 'field' + i,
      title: 'Cell' + i,
      sortable: true
    })
  }
  for (i = 0; i < rows; i++) {
    row = {}
    for (j = 0; j < cells; j++) {
      row['field' + j] = 'Row-' + i + '-' + j
    }
    data.push(row)
  }
  $el.bootstrapTable({
    columns: columns,
    data: data,
    detailView: cells > 1,
    onExpandRow: function (index, row, $detail) {
      /* eslint no-use-before-define: ["error", { "functions": false }]*/
      //expandTable($detail, cells - 1)
    }
  })
}

function expandTable($detail, cells) {
  //buildTable($detail.html('<table></table>').find('table'), cells, 1)
}

$(function() {
  buildTable($table, 3, 1)
})	



	$(function () {
        //1.初始化Table
        var oTable = new TableInit();
        oTable.Init();
        //2.初始化Button的点击事件
        /* var oButtonInit = new ButtonInit();
        oButtonInit.Init(); */
	});

	console.log("asf")
    var TableInit = function () {
        var oTableInit = new Object();
        //初始化Table
        oTableInit.Init = function () {
            $('#table2').bootstrapTable({
                url: '/WebEntry/servlet_bootstraptable',         //请求后台的URL（*）
                method: 'post',                      //请求方式（*）
                toolbar: '#toolbar',                //工具按钮用哪个容器
                striped: true,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
                sortable: false,                     //是否启用排序
                sortOrder: "asc",                   //排序方式
                queryParams: oTableInit.queryParams,//传递参数（*）
                sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber:1,                       //初始化加载第一页，默认第一页
                pageSize: 50,                       //每页的记录行数（*）
                pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
                strictSearch: true,
                clickToSelect: true,                //是否启用点击选中行
                height: 460,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "id",                     //每一行的唯一标识，一般为主键列
                cardView: false,                    //是否显示详细视图
                detailView: true,                   //是否显示父子表
                columns: [{
                    field: 'id',
                    title: '序号'
                }, {
                    field: 'kernel',
                    title: '内核版本'
                },]
            });
        };
	};
</script>

</body>
</html>
