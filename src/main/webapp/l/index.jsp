<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.book.bean.*" %>
<%
    String Path = request.getContextPath();
//    System.out.println(Path);
    Users u = null;
    long user_id=0;
    u = (Users)session.getAttribute("user");

    if(u!=null){
        user_id = u.getUser_id();
    }
%>
<html>
<head>
    <title> Myth Book </title>
    <link rel="icon" href="<%=Path%>/image/ico/book.ico">
    <link href="<%=Path%>/js/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=Path%>/js/me/home.css" rel="stylesheet">
    <link href="<%=Path%>/css/offcanvas.css" rel="stylesheet">

    <script src="<%=Path%>/js/jquery-3.0.0.min.js"></script>
    <script src="<%=Path%>/js/me/home.js"></script>
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
        ajax.post("<%=Path%>/user/ajax_in","email="+email+"&password="+pass+"&code="+code,function (data) {
            //console.log(data);
            if(data==1){
                window.location.href="http://localhost/Book/";
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
        /*$.ajax("../user/login",function (data) {
            console.log(data);
        })*/
        for(var i=1;i<=5;i++){
            $('#image_'+i).css('display','none');
        }
        $('#book_1').css({'display':'block','background-color':'#0E88EB','color':'white'});
        $('#image_1').css('display','block');
    });

</script>
</head>
<body>
<!--顶部按钮-->
<nav class="navbar navbar-toggleable-md fixed-top navbar-inverse bg-inverse">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="#">Myth</a>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="<%=Path%>/">首页 <span class="sr-only">(current)</span></a>
            </li>

            <!--<li class="nav-item">
              <a class="nav-link disabled" href="#">Disabled</a>
            </li>-->

        </ul>

        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="输入......"><!--动态生成，将最热的默认填入，不改就直接搜默认填入的内容-->
            <button class="btn btn-primary" type="submit"><img src="<%=Path%>/image/home/zoom-outline.png"></button>
        </form>
        <!--如果已经登录就显示用户名 头像-->
        <%--<a href="../html/signup_user.html">--%>
        <%if(u==null){%>
        <button class="btn btn-primary" data-toggle="modal" data-target="#myModal"
                style="margin: 0 5px 0 10px;" onclick="turnCode()">登录</button>
        <%}%>
        <ul class="navbar-nav">
            <%if(u!=null){%>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown02"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">消息</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="">消息头1</a>
                    <a class="dropdown-item" href=""></a>
                    <a class="dropdown-item" href="#"></a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown03"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><%=u.getName()%></a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="">我的书架</a>
                    <a class="dropdown-item" href="">个人中心</a>
                    <a class="dropdown-item" href="">会员充值</a>
                    <a class="dropdown-item" href="#">文档帮助</a>
                    <a class="dropdown-item" href="<%=Path%>/user/logout">注销登录</a>
                </div>
            </li>
            <%}%>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">功能中心</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">

                    <a class="dropdown-item" href="../html/signup_author.html">作家专区</a>
                    <a class="dropdown-item" href="#">客服中心</a>
                </div>
            </li>
        </ul>
    </div>
</nav>


<!--中间布局-->
<div class="container">
    <div class="row row-offcanvas row-offcanvas-right">
        <div class="col-12 col-md-9">
            <p class="float-right hidden-md-up">
                <!--隐藏按钮-->
                <button type="button" class="btn btn-primary btn-sm" data-toggle="offcanvas">Toggle nav</button>
            </p>

            <!--轮播区域-->
            <div class="image_show">
            <div>
            <ul id="imageList">
                <!--图片数据也是动态的 就是一部小说的宣传海报，或者是活动的海报，URL-->
                <%
                    for(int i=1;i<=5;i++){
                %>
                <li id="image_<%=i%>"><a><img src="<%=Path%>/image/home/<%=i%>.jpg" width="820px" height="345px" ></a></li>
                <%
                    }
                %>
                <%--<li id="image_1"><a><img src="../image/home/1.jpg" width="820px" height="345px" ></a></li>
                <li id="image_2"><a><img src="../image/home/2.jpg" width="820px" height="345px" ></a></li>
                <li id="image_3"><a><img src="../image/home/3.png" width="820px" height="345px" ></a></li>
                <li id="image_4"><a><img src="../image/home/4.jpg" width="820px" height="345px" ></a></li>
                <li id="image_5"><a><img src="../image/home/5.jpg" width="820px" height="345px" ></a></li>--%>
            </ul>
            </div>
            </div>
            <div class="image_show_book">

                <ul>
                    <li style="width: 90px;color:#0E88EB;">编辑推荐:</li>
                    <%
                        for(int i=1;i<=5;i++){
                    %>
                        <li id="book_<%=i%>" onclick="toShow('<%=i%>')">22</li>
                    <%}%>
                    <li style="width: 30px;color:#0E88EB;"><a href="">>></a></li>
                </ul>
                <!--<img src="tri.png">-->

            </div>
            <br/>
            <br/>

            <!--排行榜区域-->
            <div class="row ">
                <div class="col-5 col-lg-3 ">
                    <h2>热销排行</h2>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
                </div><!--/span-->
                <div class="col-5 col-lg-3">
                    <h2>点击排行</h2>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
                </div><!--/span-->
                <div class="col-5 col-lg-3">
                    <h2>打赏排行</h2>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
                </div><!--/span-->
                <div class="col-5 col-lg-3">
                    <h2>收藏排行</h2>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
                </div><!--/span-->
            </div><!--/row-->
        </div><!--/span-->


        <!--
          类别区域
          使用数据库动态生成 如果为了不频繁查询数据库使用缓存机制（因为这个数据的改动较少）
        -->
        <div class="col-6 col-md-3 sidebar-offcanvas" id="sidebar" >
            <div class="card type_title" >
                <div class="card-header" role="tab" id="headingOne">
                    <h5 class="mb-0">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                            奇异玄幻
                        </a>
                    </h5>
                </div>

                <div id="collapseOne" class="collapse show" role="tabpanel" aria-labelledby="headingOne">
                    <div class="card-block type_box">
                        <a href=""><button type="button" class="btn btn-primary">玄幻大陆</button></a>
                        <a href=""><button type="button" class="btn btn-primary">洪荒传说</button></a>
                        <a href=""><button type="button" class="btn btn-primary">异界时空</button></a>
                    </div>
                </div>
            </div>
            <!--0000000000000000000000-->
            <div class="card type_title">
                <div class="card-header" role="tab" id="headingTwo">
                    <h5 class="mb-0">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                            都市小说
                        </a>
                    </h5>
                </div>
                <div id="collapseTwo" class="collapse" role="tabpanel" aria-labelledby="headingTwo">
                    <div class="card-block type_box">
                        <a href=""><button type="button" class="btn btn-primary">热血都市</button></a>
                        <a href=""><button type="button" class="btn btn-primary">洪荒传说</button></a>
                        <a href=""><button type="button" class="btn btn-primary">异界时空</button></a>
                    </div>
                </div>
            </div>
            <!--0000000000000000000000-->
            <div class="card type_title">
                <div class="card-header" role="tab" id="headingThree">
                    <h5 class="mb-0">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                            武侠仙侠
                        </a>
                    </h5>
                </div>
                <div id="collapseThree" class="collapse" role="tabpanel" aria-labelledby="headingTwo">
                    <div class="card-block type_box">
                    </div>
                </div>
            </div>
            <!--0000000000000000000000-->
            <div class="card type_title">
                <div class="card-header" role="tab" id="headingFour">
                    <h5 class="mb-0">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                            历史军事
                        </a>
                    </h5>
                </div>
                <div id="collapseFour" class="collapse" role="tabpanel" aria-labelledby="headingTwo">
                    <div class="card-block type_box">
                    </div>
                </div>
            </div>
            <!--类别区域 end-->
        </div><!--/span-->
    </div><!--/row-->

    <hr><!--分割线-->

    <footer>
        <p>&copy; Myth 2017</p>
    </footer>

</div><!--/.container-->
<%--登录窗口--%>
<div class="modal fade login_box" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel" style="margin-left: 36%; font-family: 楷体;">请登录...</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
                <form class="login_form" <%--action="<%=Path%>/user/login" method="post"--%>>
                    <label for="inputEmail" class="sr-only">Email address</label>
                    <input type="email" id="inputEmail" name="email" class="form-control" placeholder="邮件:" style="width:250px;" required autofocus>
                    <label for="inputPassword" class="sr-only">Password</label>
                    <input type="password" id="inputPassword" name="password" class="form-control" placeholder="密码:" style="width:250px;" required>
                    <div>
                        <label for="inputCode" class="sr-only">Code</label>
                        <input type="text" id="inputCode" name="code" class="form-control" placeholder="验证码:" style="width:150px;float:left;" required>
                        <button type="button" class="btn-primary" style="width:60px;height:28px;float:left;margin-left: 20px;margin-top:3px;" id="ShowCode" onclick="turnCode()"></button>
                    </div>
                    <br/><br/>
                    <div id="OUT" style="margin-left:50px;"></div>

                    <button class="btn btn-lg btn-primary btn-block" type="button" style="margin-top: 30px;" onclick="login()" >登录</button>
                </form>
            </div>

            <%--<div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>--%>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="<%=Path%>/js/jquery-slim.min.js"></script>
<!--
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
-->
<script src="<%=Path%>/js/tether.min.js"></script>
<script src="<%=Path%>/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="<%=Path%>/js/ie10-viewport-bug-workaround.js"></script>
<script src="<%=Path%>/js/offcanvas.js"></script>

</body>
</html>