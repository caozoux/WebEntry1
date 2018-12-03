<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

  <%@ include file="./admin_head.jsp" %>
<script type="text/javascript">
    $(document).ready(function(){
		$("#buildrpm").click(function() {
			if ($(this).parent().parent().children(".form-horizontal").is(":hidden")) {
				$(this).parent().parent().children(".form-horizontal").show()
			} else {
				$(this).parent().parent().children(".form-horizontal").hide()
			}
		});
		$("#transtest").click(function() {
			consle.log("aa")
			$("#buildrpmprocess").css('width','10%')
		});
		$("#transcurrent").click(function() {
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
			<div class="col-md-6">
			  <div class="box box-primary">
				<div class="box-header">
				  <i class="fa fa-edit"></i>
				  <h3 class="box-title">打包</h3>
				</div>
				<div class="box-body pad table-responsive">
				  <table class="table text-center">
					<tbody>
					<tr>
					  <td>
						<button type="button" class="btn btn-block btn-success" id="buildrpm">打包</button>
					  </td>
					  <td>
						<button type="button" class="btn btn-block btn-success" id="transtest">转测试包</button>
					  </td>
					  <td>
						<button type="button" class="btn btn-block btn-success" id="transcurrent">转正式包</button>
					  </td>
					</tr>
				  </tbody></table>
				</div>
				<!-- /.box -->
				<div class="box-body">
					<div class="form-inline">
						<span>成功</span>
						<a>查看日志</a>
					</div>
					<div class="progress progress-sm active">
						<div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 1%" id="buildrpmprocess">
						<span class="sr-only">20% Complete</span>
						</div>
					</div>
				</div>
				<div class="box-body">
					<div class="form-inline">
						<span>成功</span>
						<a>查看日志</a>
					</div>
					<div class="progress progress-sm active">
						<div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 1%" id="transtestprocess">
						<span class="sr-only">20% Complete</span>
						</div>
					</div>
				</div>
				<div class="box-body">
					<div class="form-inline">
						<span>成功</span>
						<a>查看日志</a>
					</div>
					<div class="progress progress-sm active">
						<div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 1%" id="transcurrentprocess">
						<span class="sr-only">20% Complete</span>
						</div>
					</div>
				</div>
			  </div>
			</div>
        <!-- /.col -->
 		</div>     <!-- Small boxes (Stat box) -->

      <!-- Main row -->
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

