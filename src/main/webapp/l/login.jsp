<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf8" %>
<%
    String Path = request.getContextPath();

%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../image/ico/books.ico">

    <title>Signin To Author</title>
    <link href="<%=Path%>/js/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=Path%>/css/signup.css" rel="stylesheet">
    <script src="<%=Path%>/js/in/jquery-3.0.0.min.js"></script>
    <script>
        //原生js的ajax实现，jquery的不兼容也是日了狗了
        var ajax = {
            get:function(url,fn){
                var obj = new XMLHttpRequest();
                obj.open('GET',url,true);
                obj.onreadystatechange=function(){
                    if(obj.readyState==4&&obj.status==200||obj.status==304){
                        fn.call(this,obj.responseText);
                    }
                };
                obj.send(null);
            },
            post:function(url,data,fn){
                var obj = new XMLHttpRequest();
                obj.open('POST',url,true);
                obj.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
                obj.onreadystatechange=function () {
                    if(obj.readyState==4&&obj.status==200||obj.status==304){
                        fn.call(this,obj.responseText);
                    }
                };
                obj.send(data);
            }
        }
        //ajax 实现登录
        function login() {
            var email = $('#inputEmail').val();
            var pass = $('#inputPassword').val();
            var code = $('#inputCode').val();
            ajax.post("<%=Path%>/user/ajax_in","email="+email+"&password="+pass+"&code="+code+"&sex=1",function (data) {
                //console.log(data); 登录成功返回1失败返回0，这里是到读者
                if(data==1){
                    window.location.href="<%=Path%>/l/author.jsp";
                }else{
                    $('#OUT').html('<span style="color:red">用户名密码或验证码错误</span>');
                    turnCode();
                }
            })
            //console.log(email + ":" + pass);
        }
        //获取验证码
        function turnCode(){
            ajax.get("<%=Path%>/user/getCode",function(data){
                $('#ShowCode').html("<span>"+data+"</span>");
            });
        }
        $(function(){
           turnCode();
        });
    </script>
</head>

<body>

<div class="container" style="margin-top: 160px;">

    <form class="form-signin">
        <h2 class="form-signin-heading">Myth Book</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="邮件" value="1181951407@qq.com" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="密码" value="1232" required>
        <div>
            <label for="inputCode" class="sr-only">Code</label>
            <input type="text" id="inputCode" name="code" class="form-control" placeholder="验证码:" style="width:150px;float:left;" required>
            <button type="button" class="btn btn-primary" style="width:70px;height:32px;float:left;margin-left: 20px;margin-top:6px;" id="ShowCode" onclick="turnCode()"></button>
        </div>
        <br/><br/>
        <div id="OUT" style="margin-left:50px;"></div>
        <button class="btn btn-lg btn-primary btn-block" type="button" style="margin-top: 30px;" onclick="login()">登录</button>
    </form>

</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../js/in/ie10-viewport-bug-workaround.js"></script>
</body>
</html>

