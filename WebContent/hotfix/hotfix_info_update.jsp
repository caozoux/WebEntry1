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
			<section class="col-lg-7 connectedSortable ui-sortable">
			<!-- handle submit commid for hotfix -->
				<div id="col-md5-6">
					<div class="box box-info">
						<div class="box-header with-border">
						  <h3 class="box-title">信息更新</h3>
						</div>
						<form class="form-horizontal"  action="../hotfix_servlet_akidupdate">
							<div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">ak id</label>
								<div class="col-sm-10">
								  <input type="text" class="form-control" name="akid">
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">Aone</label>
								<div class="col-sm-10">
								  <input type="text" class="form-control" name="aone">
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">摘要</label>
								<div class="col-sm-10">
								  <input type="text" class="form-control" name="summary">
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">描述</label>
								<div class="col-sm-10">								  
								  <textarea class="form-control" id="akid_func_mod" rows="3" name="description"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">跟踪者</label>
								<div class="col-sm-10">
								  <input type="text" class="form-control" name="author">
								</div>
							</div>
							<div class="form-group">
								<label for="inputName" class="col-sm-2 control-label">wiki链接</label>
								<div class="col-sm-10">
								  <input type="text" class="form-control" name="wiki_link">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-sm-2 control-label">选择内核</label>
								<div class="col-sm-10">
									<select multiple="" class="form-control ">
										<option>3.10</option>
										<option>4.9</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-danger">Submit</button>
								</div>
							</div>
						</form>
					</div>

				</div>
			</section>
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
    $(document).ready(function(){
        $("[value=GETsubmit]").click(function(){
        	var params = '';
        	console.log($("[name=akid]").val())
        	$('input:checkbox[name=version]:checked').each(function(k){
        	    if(k == 0){
        	    	params = "version="+$(this).parent().text();
        	    }else{
        	    	params += '&version='+$(this).parent().text();
        	    }
        	})
        	
			$.ajax({
				type: "GET",
				url: "../hotfix_ajaxservlet_mergetPatch?"+params+"&akid="+$("[name=akid]").val()+"&date="+new Date().getTime(),
				dataType: "text",
				success: function(data){
					var status=""
					var json = eval('('+data+')'); //数组
	                $.each(json, function (index) {  
	                    //循环获取数据    
	                    
	                  	if (json[index].status == "ok") {
	                  		status += json[index].version+"(success) ";
	                  	} else {
	                  		status += json[index].version+"(failed) ";
	                  	}
	                });  
					$("#show").html(status);
				},
				error: function(){
					$("#show").html("Error XMLHttpRequest");
				}
			});
		});
	});
</script>

</body>
</html>
