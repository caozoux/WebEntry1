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
			<%@ page language="java" import="java.util.List" %>
			<%@ page language="java" import="hotfix.db.hitfix_rpminfo_bean" %>
			<% 
				List<hitfix_rpminfo_bean> list=(List<hitfix_rpminfo_bean>)request.getAttribute("akid_list");
				if (list != null) {
					for(hitfix_rpminfo_bean rpminfo_bean : list) {
						out.print("<a href='./hotfix_akid_show?akid="+rpminfo_bean.getAkid()+"'"+" class='package list-group-item' target='_blank' onclick='_hmt.push(['_trackEvent', 'packages', 'click', 'twitter-bootstrap'])'>");
						out.print("<div class='row'>");
						out.print("<div class='col-md-3'>");
						out.print("<h4 class='package-name'>"+rpminfo_bean.getAkid()+"</h4>");
						out.print("</div>");
						out.print("<div class='col-md-9 hidden-xs'>");
						out.print("<p class='package-description'>"+rpminfo_bean.getSummary()+"</p>");
						out.print("</div>");
						out.print("<div class='package-extra-info col-md-9 col-md-offset-3 col-xs-12'>");
						out.print("</div>");
						out.print("</div>");
						out.print("</a>");
					}
				}
			%>
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
		$("#patchlist").addClass("active")
		$(".editevent").click(function() {
			if ($(this).parent().parent().children(".form-horizontal").is(":hidden")) {
				$(this).parent().parent().children(".form-horizontal").show()
			} else {
				$(this).parent().parent().children(".form-horizontal").hide()
			}
			
		});
		$("#akid_submit").click(function() {
			console.log("22")
			$(this).parent(".form-horizontal").hide()
		});
	});
</script>

</body>
</html>
