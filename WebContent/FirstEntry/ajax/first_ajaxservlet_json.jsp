<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="">
<table border="0">
    <tr><td>name:</td><td><input type="text" name="name"/></td></tr>
    <tr><td>password:</td><td><input type="password" name="pwd"/></td></tr>
    <tr><td></td><td><input type="button" value="GETsubmit"/></td></tr>
</table>
</form>
<div id="show"></div>
<script src="../../resource/jQuery-2.2.0.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $("[value=GETsubmit]").click(function(){
            $.ajax({
                type: "GET",
                url: "../../first_ajaxservlet_json?name="+$("[name=name]").val()+"&pwd="+$("[name=pwd]").val()+"&date="+new Date().getTime(),
                dataType: "text",
                success: function(data){
                	console.log(data);
                	var dataObj = JSON.parse(data);
                	var jsonText = JSON.stringify(data);
                	var list = eval(data);//解析json
                	for(var i=0;i<list.length;i++)
                	{
                		var id=list[i].name;
                		console.log(id);
                	}
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
        });
    });
</script>
</body>
</html>