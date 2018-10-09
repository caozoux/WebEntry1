<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>


<form action="">
<div>
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
</div>

	<label><input type="checkbox" name="version" value ="ali2013">ali2013</label>
	<label><input type="checkbox" name="version" value ="ali2014">ali2014</label>
	<label><input type="checkbox" name="version" value ="ali2015">ali2015</label>
	<label><input type="checkbox" name="version" value ="ali2016">ali2016</label>
	<label><input type="checkbox" name="version" value ="ali2017">ali2017</label>
	<label><input type="checkbox" name="version" value ="ali2018">ali2018</label>
    <input type="text" name="name"/>
    <input type="button" value="GETsubmit"/>
</form>


<div id="show"></div>
<script src="../../resource/jQuery-2.2.0.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $("[value=GETsubmit]").click(function(){
        	var params = '';
        	$('input:checkbox[name=version]:checked').each(function(k){
        	    if(k == 0){
        	    	params = "version="+$(this).val();
        	    }else{
        	    	params += '&version='+$(this).val();
        	    }
        	})

            $.ajax({
                type: "GET",
                url: "../../frist_ajaxservlet_checkbox?"+params+"&date="+new Date().getTime(),
                dataType: "text",
                success: function(data){
                    if(data=="true"){
                        $("#show").html("===ok==="+"<br/>"+"name="+$("[name=name]").val()+"<br/>"+"pwd="+$("[name=pwd]").val());
                    }else if(data=="false"){
                        $("#show").html("==信息不符合==");
                    } else {
                    	$("#show").html(data);
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