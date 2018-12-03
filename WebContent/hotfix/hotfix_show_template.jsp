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
							<a href="<%=o_akid.getLink()%>"><%=o_akid.getAonelink()%></a>
						</p>
						<form class="form-horizontal" style="display:none" id="aoneform">
							<textarea class="form-control" id="akid_func_mod" rows="1"></textarea>
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
							<textarea class="form-control" id="akid_func_mod" rows="1"></textarea>
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
							<strong style="display:none">functest</strong>
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
							<strong style="display:none">functionschange</strong>
							<strong>修改函数</strong>
							<button type="submit" class="btn btn-info pull-right btn-xs editevent">edit</button>
						</div>
							<%@ page language="java" import="java.util.List" %>
							<%@ page language="java" import="hotfix.db.rpminfo.hotfix_hibernate_functionschange_bean" %>
							<%
								List<hotfix_hibernate_functionschange_bean> func_list=(List<hotfix_hibernate_functionschange_bean>)request.getAttribute("funschange_list");
								if (!list.isEmpty()) {
									for(hotfix_hibernate_functionschange_bean functionschange_bean: func_list) {
										out.print("<p>"+functionschange_bean.getFile()+":"+functionschange_bean.getMode()+":"+functionschange_bean.getFunctions()+"</p>");
									}
								}
							%>
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

<%@ include file="./admin_end.jsp" %>
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

		function updateRpm(){
			var rowTem ='<tr><td></td><td><span class="badge"><a href=""></a> </span></td></tr>'
			console.log("updateRpm")
			$("#rpmtable tbody:last").append(rowTem);
		}
	});
</script>

</body>
</html>
