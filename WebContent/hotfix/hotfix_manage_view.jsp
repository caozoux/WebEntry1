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
			<table id="table"></table>
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

  var $table  = $('#table')
  var $remove = $('#remove')
  var selections = []

    $("#hotfix_manage").addClass("active")
    $("#hotfix_manage_view").addClass("active")

  function aFormatter(value, row, index) {
	  return [
		  '<a href="'+value+'">链接</a>'
		  ].join("")
  }

  function getIdSelections() {
    return $.map($table.bootstrapTable('getSelections'), function (row) {
      return row.id
    })
  }

  function responseHandler(res) {
    $.each(res.rows, function (i, row) {
      row.state = $.inArray(row.id, selections) !== -1
    })
    return res
  }

  function detailFormatter(index, row) {
	var html = "";
	html += "<table id='"+index+"'></table>";
	html += "<table class='table'>";
	html += "<thead>";
	html += "<tr style='height: 40px;'>";
	html += "<th>id</th>";
	html += "<th>名称</th>";
	html += "<th>描述</th>";
	html += "<th>hotfix包</th>";
	html += "<th>是否通用</th>";
	html += "<th>适用范围</th>";
	html += "<th>ReleaseNote</th>";
	html += "<th>合入版本</th>";
	html += "<th>发布时间</th>";
	html += "<th>作者</th>";
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
      columns: [{
          title: 'ID',
          field: 'id',
          align: 'center',
          width: '20',
        },
		{
          title: '内核版本',
          field: 'kerver',
          align: 'left'
        },
      ],
	  detailView:true,
	  detailFormatter:"detailFormatter",
	  minimumCountColumns:"2",
	  pagination:true,
	  idField:"id",
	  pageList:"[10, 25, 50, 100, ALL]",
	  showFooter:false,
	  sidePagination:"client",
	  //url:"https://examples.wenzhixin.net.cn/examples/bootstrap_table/data",
	  //url:"/oskhotfix/hotfix_servlet_getkerlist",
	  url:"/oskhotfix/hotfix_servlet_getkerlist",
	  responseHandler:"responseHandler",
      onExpandRow: function(index, row, $detail) {
			var kerver=row['kerver']
			cur_tab=$detail.html('<table></table>').find('table')
			$(cur_tab).bootstrapTable({
			  columns: [{
				  title: 'ID',
				  field: 'id',
				  align: 'center',
				},
				{
				  title: '名称',
				  field: 'akid',
				  align: 'left'
				},
				{
				  title: '描述',
				  field: 'desc',
				  align: 'left'
				},
				{
				  title: 'khotfix包',
				  field: 'downlink',
				  align: 'left',
				  formatter:aFormatter
				},
				{
				  title: '是否通用',
				  field: 'type',
				  align: 'left'
				},
				{
				  title: '适用范围',
				  field: 'business',
				  align: 'left'
				},
				{
				  title: 'ReleaseNote',
				  field: 'link',
				  align: 'left',
				  width: '50',
				  formatter:aFormatter
				},
				{
				  title: '合入版本',
				  field: 'mergetkernel',
				  align: 'left'
				},
				{
				  title: '发布时间',
				  field: 'date',
				  align: 'left'
				},
				{
				  title: '作者',
				  field: 'author',
				  align: 'left'
				},
			  ],
			  idField:"id",
			  showFooter:false,
			  sidePagination:"client",
			  url:"/oskhotfix/hotfix_servlet_getAkidInfoByKervel?kervel="+kerver,
			  responseHandler:"responseHandler",
			})
		},
		})
  }

  $(function() {
    initTable()
  })
</script>

</body>
</html>
