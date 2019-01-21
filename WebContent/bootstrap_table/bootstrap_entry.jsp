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
				<table id="table"></table>
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
            $('#table').bootstrapTable({
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
                    field: 'liushuiid',
                    title: '交易编号'
                }, {
                    field: 'orderid',
                    title: '订单号'
                }, {
                    field: 'receivetime',
                    title: '交易时间'
                }, {
                    field: 'price',
                    title: '金额'
                }, {
                    field: 'coin_credit',
                    title: '投入硬币'
                },  {
                    field: 'bill_credit',
                    title: '投入纸币'
                },  {
                    field: 'changes',
                    title: '找零'
                }, {
                    field: 'tradetype',
                    title: '交易类型'
                },{
                    field: 'goodmachineid',
                    title: '货机号'
                },{
                    field: 'inneridname',
                    title: '货道号'
                },{
                    field: 'goodsName',
                    title: '商品名称'
                }, {
                    field: 'changestatus',
                    title: '支付'
                },{
                    field: 'sendstatus',
                    title: '出货'
                },]
            });
        };

        //得到查询的参数
      oTableInit.queryParams = function (params) {
            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                limit: params.limit,   //页面大小
                offset: params.offset,  //页码
                sdate: $("#stratTime").val(),
                edate: $("#endTime").val(),
                sellerid: $("#sellerid").val(),
                orderid: $("#orderid").val(),
                CardNumber: $("#CardNumber").val(),
                maxrows: params.limit,
                pageindex:params.pageNumber,
                portid: $("#portid").val(),
                CardNumber: $("#CardNumber").val(),
                tradetype:$('input:radio[name="tradetype"]:checked').val(),
                success:$('input:radio[name="success"]:checked').val(),
            };
            return temp;
        };
        return oTableInit;
    }
</script>

</body>
</html>