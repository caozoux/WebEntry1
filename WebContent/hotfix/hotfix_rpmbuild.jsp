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
						<span id="rpmbuildstatus">成功</span>
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
				<div id="downlinklist">
				</div>
				 <div class="form-group">
					 <div class="checkbox" id="versionSelect">
						<label><input type="checkbox" name="version" value ="ali2000">ali2000</label>
						<label><input type="checkbox" name="version" value ="ali2001">ali2001</label>
						<label><input type="checkbox" name="version" value ="ali2002">ali2002</label>
						<label><input type="checkbox" name="version" value ="ali2003">ali2003</label>
						<label><input type="checkbox" name="version" value ="ali2004">ali2004</label>
						<label><input type="checkbox" name="version" value ="ali2005">ali2005</label>
						<label><input type="checkbox" name="version" value ="ali2006">ali2006</label>
						<label><input type="checkbox" name="version" value ="ali2007">ali2007</label>
						<label><input type="checkbox" name="version" value ="ali2008">ali2008</label>
						<label><input type="checkbox" name="version" value ="ali2009">ali2009</label>
						<label><input type="checkbox" name="version" value ="ali2010">ali2010</label>
						<label><input type="checkbox" name="version" value ="ali2011">ali2011</label>
						<label><input type="checkbox" name="version" value ="ali2012">ali2012</label>
						<label><input type="checkbox" name="version" value ="ali2013">ali2013</label>
						<label><input type="checkbox" name="version" value ="ali2014">ali2014</label>
						<label><input type="checkbox" name="version" value ="ali2015">ali2015</label>
						<label><input type="checkbox" name="version" value ="ali2016">ali2016</label>
						<label><input type="checkbox" name="version" value ="ali2017">ali2017</label>
						<label><input type="checkbox" name="version" value ="ali2018">ali2018</label>
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
<script type="text/javascript">
    $(document).ready(function(){
		<%@ page language="java" import="java.util.List" %>
		<%@ page language="java" import="hotifx.db.rpmbuild.hotfix_hibernate_rpmbuild_bean" %>
		<% 
			hotfix_hibernate_rpmbuild_bean bean=(hotfix_hibernate_rpmbuild_bean)request.getAttribute("akid_obj");
			out.println("var akid=\""+bean.getAkid()+"\"");
			out.println("var status=\""+bean.getStatus()+"\"");
			out.println("var verstr=\""+bean.getVersionlist()+"\"");
		%>
		var verlist = verstr.split(",")
		console.log(akid)
		console.log(verlist)
		console.log(status)
		if (status == 0) {
		} else if (status == 1) { // building
			$("#buildrpmprocess").css("width","50%");
			process("#buildrpmprocess", akid, "build")
			$("#downlinklist").empty()
		} else if (status == 2) { // built
			$("#buildrpmprocess").css("width","100%");
			for (var i = 0; i<verlist.length; i++) {
				$("#downlinklist").append("<a>"+verlist[i]+" </a>")
			}
		} else if (status == 3) { // testing
		} else if (status == 4) { //test
		} else if (status == 5) { // currenting
		} else if (status == 6) { // current
		}
		//check status
		$("#buildrpm").click(function() {
			//var verlist = [];
			console.log("buildrpm")
			var verstr="ali2012,ali2013";
			$("#versionSelect :checkbox").each(function(index,element) {
				if ($(this).is(':checked')) {
					//verlist.push($(this).val())
					verstr=verstr+$(this).val()+","
				}
			});
			if (verstr == "") {
				verstr="all";
			}
			$("#buildrpmprocess").css("width",5);
			$("#downlinklist").empty()
			console.log(verstr)
			$.ajax({
				type: "GET",
				url: "/WebEntry/hotfix_servlet_rpmbuild_ajax?akid="+akid+"&verlist="+verstr+"&command=build",
				dataType: "text",
				success: function(data){
					if(data=="true"){
						console.log("true")
						//$("#show").html("===ok==="+"<br/>"+"name="+$("[name=name]").val()+"<br/>"+"pwd="+$("[name=pwd]").val());
					}else if(data=="false"){
					}
				},
				error: function(){
				}
			});
			process("#buildrpmprocess", akid, "build")
		});

		$("#buildtest").click(function() {
			//var verlist = [];
			var verstr="ali2012,ali2013";
			console.log("buildtest")
			$("#versionSelect :checkbox").each(function(index,element) {
				if ($(this).is(':checked')) {
					//verlist.push($(this).val())
					verstr=verstr+$(this).val()+","
				}
			});
			if (verstr == "") {
				verstr="all";
			}
			$.ajax({
				type: "GET",
				url: "../hotfix_servlet_rpmbuild_ajax?akid="+akid+"&verlist="+verstr+"&command=test",
				dataType: "text",
				success: function(data){
					if(data=="true"){
						console.log("true")
						//$("#show").html("===ok==="+"<br/>"+"name="+$("[name=name]").val()+"<br/>"+"pwd="+$("[name=pwd]").val());
					}else if(data=="false"){
					}
				},
				error: function(){
				}
			});
			//$("#downlinklist").append("<a>asf </a>")
			process("#buildrpmprocess", akid, "test")
		});

		$("#buildcurrent").click(function() {
			//var verlist = [];
			var verstr="";
			console.log("buildcurrent")
			$("#versionSelect :checkbox").each(function(index,element) {
				if ($(this).is(':checked')) {
					//verlist.push($(this).val())
					verstr=verstr+$(this).val()+","
				}
			});
			if (verstr == "") {
				verstr="all";
			}
			$.ajax({
				type: "GET",
				url: "../hotfix_servlet_rpmbuild_ajax?akid="+akid+"&verlist="+verstr+"&command=current",
				dataType: "text",
				success: function(data) {
					if(data=="true"){
						console.log("true")
						//$("#show").html("===ok==="+"<br/>"+"name="+$("[name=name]").val()+"<br/>"+"pwd="+$("[name=pwd]").val());
					}else if(data=="false"){
					}
				},
				error: function(){
				}
			});
			//$("#downlinklist").append("<a>asf </a>")
			process("#buildrpmprocess", akid, "current")
		});

		function process(selector,akid, status){
			var num=0;
			timer=setInterval(function(){
				num++;
				val=$(selector).width()

				if (num <= 5) {
					val += 100
					$(selector).css("width",val);
				}

				if(num== 5){
					//clearInterval(timer);   //定时器清除；
				}

				$.ajax({
					type: "GET",
					url: "/WebEntry/hotfix_servlet_rpmbuild_ajax?akid="+akid+"&command=check",
					dataType: "text",
					success: function(data){
						console.log(data)
						var dataObj = JSON.parse(data);
						var list = eval(data);//解析json
						var status=""
						var verlist=""
						var verstr=""
						status = list[0].status;
						verstr = list[0].verlist;
						console.log(status)
						console.log(verstr)
						if (status == "built") {
							clearInterval(timer);   //定时器清除；
							verlist= verstr.split(" ")
							for(var off=0; off<verlist.length;off++) {
								$("#downlinklist").append("<a>"+verlist[off]+" </a>")
							}
							$(status).text("成功");
							$(selector).css("width","100%");
							return;
						} else if (status == "failed") {
							clearInterval(timer);   //定时器清除；
							$(status).text("失败");
							$(selector).css("width","100%");
							$(selector).css("background-color","red");
						}

						if (status == "doing")
							return;

						if(data=="true"){
							console.log("true")
							//$("#show").html("===ok==="+"<br/>"+"name="+$("[name=name]").val()+"<br/>"+"pwd="+$("[name=pwd]").val());
						}else if(data=="false"){
							clearInterval(timer);   //定时器清除；
							$(status).text("失败");
							$(selector).css("width","100%");
							$(selector).css("background-color","red");
						}
					},
					error: function(){
						clearInterval(timer);   //定时器清除；
						$(status).text("失败");
						$(selector).css("width","100%");
						$(selector).css("background-color","red");
					}
				});
        	},1000);
		};
		$(".akid_submit").click(function() {
			akid_val=$("#akid_title").text()
			akid_item = $(this).parent().parent().children("div").children("strong:first").text();
			input_val = $(this).parent().children("textarea").val();
			console.log(input_val)
			console.log(akid_val)
			console.log(akid_item)
			console.log("hotfix_db_akid_show_update?akid="+akid_val+"&"+akid_item+"="+input_val)
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

		function updateRpm() {
			var rowTem ='<tr><td></td><td><span class="badge"><a href=""></a> </span></td></tr>'
			console.log("updateRpm")
			$("#rpmtable tbody:last").append(rowTem);
		}
	});
</script>

</body>
</html>
