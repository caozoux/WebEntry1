<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
    body,div{font-size:12px;font-familly:宋体;}
    #progressBar {width:200px;height:12px;background:#FFFFFF;border:1px solid #000000;padding:1px;}
    #progressBarItem {width:30%;height:100%;background:#FF0000;}
</style>
</head>
<body>
<iframe name="upload_iframe" width=0 height=0></iframe>
    <form action="/servletUpdateFile" method="post" enctype="multipart/form-data" target="upload_iframe" onsubmit="showStatus();">
        <input type="file" name="file1" style="width:350px"> <br>
        <input type="file" name="file2" style="width:350px"> <br>
        <input type="file" name="file3" style="width:350px"> <br>
        <input type="file" name="file4" style="width:350px"> <br>
        <input type="submit" id="btnSubmit" value="上传文件">
    </form>
    <div id="status" style="display:none">
        上传进度条：
        <div id="progressBar"><div align="left" id="progressBarItem"></div></div>
        <div id="statusInfo"></div>
    </div>

    <script type="text/javascript">
        var finished = true;    // 是否上传结束
        function $(obj){
            return document.getElementById(obj);
        }
        function showStatus(){
            //alert("showStatus");
            finished = false;
            $('status').style.display =  'block';  // 将隐藏的进度条显示
            $('progressBarItem').style.width = '1%';   // 设置进度条初始值
            $('btnSubmit').disabled = true;    // 防止重复提交
            //alert("showStatus");
            setTimeout("requestStatus()", 1000);    // 1秒后执行 requestStatus 方法，更新上传进度
        }
        // 向服务器请求上传进度信息
        function requestStatus(){
            if(finished) return; 
            var req = createRequest(); // 获取Ajax 请求
            req.open("GET","/servletUpdateFile");  // 设置请求路径
            req.onreadystatechange = function(){
                callback(req);  // 请求完毕就执行 callback(req)
            }
            req.send(null); //发送请求
            //alert("requestStatus");
            setTimeout("requestStatus()",1000); // 1秒后重新执行请求
        }
        // 返回Ajax 请求对象
        function createRequest(){
            if(window.XMLHttpRequest){
                //alert("createRequest");
                return new XMLHttpRequest();
            }else {
                try{
                    return new ActiveXObject("Msxm12.XMLHTTP");
                }catch(e){
                    return new ActiveXObject("Microsoft.XMLHTTP");
                }
            }
            return null;
        }

        function callback(req){
            if(req.readyState == 4){    // 刷新进度条
                if(req.status != 200) {
                    debug("发生错误 req.status"+req.status+" ");
                    return;
                }
                debug("status.jsp 返回值："+ req.responseText);
                var ss = req.responseText.split("||");  // 处理进度信息
                $('progressBarItem').style.width = ''+ss[0]+'%';
                $('statusInfo').innerHTML = '已完成百分比：'+ss[0]+'% <br /> 已完成数（M）：'+ss[1]+'<br/>文件总长度（M)：'
                +ss[2]+'<br/> 传输速率（k）：'+ss[3]+'<br/> 已用时间(s)：'+ss[4]+'<br>估计总时间(s):'+ss[5]+
                '<br> 估计剩余时间（S）：'+ss[6]+'<br> 正在上传第几个文件：'+ss[7];

                if(ss[1] == ss[2]){
                    finished = true;
                    $('statusInfo').innerHTML += "<br/><br/><br/>上传已完成。";
                    $('btnSubmit').disabled = false;
                }
            }
        }

        function debug(obj){
            var div = document.createElement("DIV");
            div.innerHTML = "[debug]: "+obj;
            document.body.appendChild(div);
        }
    </script>
</body>
</html>