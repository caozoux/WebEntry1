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
			<div class="col-xs-12">
				<button id="business_modal" class="btn btn-primary btn-small" data-toggle="modal" data-target="#modal"  href="/Home/Test">新增业务</button>
				<table id="table"></table>
			</div>
			<div class="col-xs-12">
				<button id="btn_add" class="btn btn-primary btn-small" data-toggle="modal" data-target="#modal"  href="/Home/Test">新增内核</button>
				<table id="table_kerlist"></table>
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

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">新增</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="txt_departmentname">内核版本</label>
                        <input type="text" name="txt_departmentname" class="form-control" id="txt_kerver" placeholder="内核版本">
                    </div>
                    <div class="form-group">
                        <label for="txt_parentdepartment">描述</label>
                        <input type="text" name="txt_parentdepartment" class="form-control" id="txt_desc" placeholder="描述">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
                    <button type="button" id="kerver_submit" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>提交</button>
                </div>
            </div>
        </div>
</div>

<div class="modal fade" id="businessModal" tabindex="-1" role="dialog" aria-labelledby="myBusinessLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">业务</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="txt_departmentname">业务</label>
                        <input type="text" name="txt_departmentname" class="form-control" id="business_name" placeholder="业务名称">
                    </div>
                    <div class="form-group">
                        <label for="txt_parentdepartment">描述</label>
                        <input type="text" name="txt_parentdepartment" class="form-control" id="business_desc" placeholder="描述">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>关闭</button>
                    <button type="button" id="business_submit" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>提交</button>
                </div>
            </div>
        </div>
</div>

<script type="text/javascript">

	$("#btn_add").click(function () {
		$("#myModalLabel").text("新增");
		$('#myModal').modal();
	});
	$("#business_modal").click(function () {
		$("#myBusinessLabel").text("新增");
		$('#businessModal').modal();
	});

	$("#business_submit").click(function () {
		 var json = {
			business: $("#business_name").val(),
			desc: $("#business_desc").val()
    	};
		console.log(json)
		console.log(JSON.stringify(json))
		$.ajax({
			type: "post",
			url: "/WebEntry/hotfix_servlet_business_ajax",
			data: "json="+JSON.stringify(json),
			dataType: "json",
			success: function (message) {
				alert("okay");
			},
			error: function (message) {
				alert("failed");
			}
		});
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
			url: "/WebEntry/hotfix_servlet_mangeUpdate_ajax",
			data: "json="+JSON.stringify(json),
			dataType: "json",
			success: function (message) {
				alert("okay");
			},
			error: function (message) {
				alert("failed");
			}
		});
	});

    $(document).ready(function(){
	});

  var $table = $('#table')
  var $tableker = $('#table_kerlist')
  var $remove = $('#remove')
  var selections = []

  function getIdSelections() {
    return $.map($table.bootstrapTable('getSelections'), function (row) {
      return row.id
    })
  }

  function responseHandler(res) {
    $.each(res.rows, function (i, row) {
      row.state = $.inArray(row.id, selections) !== -1
	  console.log("zz", res, row.state)
    })
    return res
  }

  function detailFormatter(index, row) {
    //var html = []
    //$.each(row, function (key, value) {
    //  html.push('<p><b>' + key + ':</b> ' + value + '</p>')
    //})
    //return html.join('')
	    var html = "";
		html += "<table class='table'>";
		html += "<thead>";
		html += "<tr style='height: 40px;'>";
		html += "<th>akid</th>";
		html += "<th>baoming</th>";
		html += "<th>xiazailianjie</th>";
		html += "</tr>";
		html += "</thead>";
    	return html
  }

  window.operateEvents = {
    'click .like': function (e, value, row, index) {
      alert('You click like action, row: ' + JSON.stringify(row))
    },
    'click .remove': function (e, value, row, index) {
      $table.bootstrapTable('remove', {
        field: 'id',
        values: [row.id]
      })
    }
  }


  function initTable() {
	$table.bootstrapTable({
      height: 500,
      columns: [{
          title: 'ID',
          field: 'id',
          align: 'center',
		},
		{
			title: '内核版本',
			field: 'business',
			align: 'left'
		},
		],

	  minimumCountColumns:"2",
	  pagination:true,
	  idField:"id",
	  pageList:"[10, 25, 50, 100, ALL]",
	  showFooter:false,
	  sidePagination:"client",
	  //url:"https://examples.wenzhixin.net.cn/examples/bootstrap_table/data",
	  //url:"/WebEntry/hotfix_servlet_getkerlist",
	  url:"/WebEntry/hotfix_servlet_getbusinesslist",
	  responseHandler:"responseHandler",
      onExpandRow: function(index, row, $detail) {
		  console.log(row)
      },
    })
    $tableker.bootstrapTable({
      height: 500,
      columns: [{
          title: 'ID',
          field: 'id',
          align: 'center',
        },
		{
          title: '内核版本',
          field: 'kerver',
          align: 'left'
        },
      ],
	  minimumCountColumns:"2",
	  pagination:true,
	  idField:"id",
	  pageList:"[10, 25, 50, 100, ALL]",
	  showFooter:false,
	  sidePagination:"client",
	  //url:"https://examples.wenzhixin.net.cn/examples/bootstrap_table/data",
	  url:"/WebEntry/hotfix_servlet_getkerlist",
	  responseHandler:"responseHandler",
      onExpandRow: function(index, row, $detail) {
		  console.log(row)
      },
    })
  }

  $(function() {
    initTable()
  })
</script>

</body>
</html>
