<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.book.bean.BookType,com.book.bean.FatherType,com.book.bean.Users,com.book.redis.RedisUtils" pageEncoding="utf8" %>
<%@ page import="com.book.service.BookService" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="redis.clients.jedis.Jedis" %>
<%@ page import="java.util.List" %>
<%
    String Path = request.getContextPath();
    ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
//    BookService bookService = (BookService)context.getBean("bookService");
//    List list = bookService.getAllTypes();
    Users u = null;
    long user_id=0;
    //加载redis缓存中的数据
    RedisUtils redisUtil = (RedisUtils)context.getBean("redisUtils");
    Jedis jedis = redisUtil.getConnect();
    List<String> types = jedis.lrange("BookFatherType",0,-1);
//    for(int i=0;i<types.size();i++){
//        System.out.println("|"+types.get(i)+"|");
//        List type = jedis.lrange(types.get(i),0,-1);
//        for (int j=0;j<type.size();j++){
//            System.out.println(j+"/"+type.get(j)+"/");
//        }
//    }
    System.out.println("父类型 : "+types.size());
    jedis.close();
    u = (Users)session.getAttribute("user");
    if(u!=null){
        user_id = u.getUser_id();
    }
%>
<html>
<head>
    <title>Myth Book</title>
    <link rel="icon" href="<%=Path%>/image/ico/books.ico">
    <link href="<%=Path%>/js/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=Path%>/css/home.css" rel="stylesheet">
    <link href="<%=Path%>/css/offcanvas.css" rel="stylesheet">

    <script src="<%=Path%>/js/in/jquery-3.0.0.min.js"></script>
    <script src="<%=Path%>/js/me/home.js"></script>
<script>
    $(function(){
        for(var i=1;i<=5;i++){
            $('#image_'+i).css('display','none');
        }
        //图片轮播的初始化
        $('#book_1').css({'display':'block','background-color':'#0E88EB','color':'white'});
        $('#image_1').css('display','block');
    });
    //原生js的ajax实现，jquery的不兼容
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
        // sex 0 是读者，1 作家
        ajax.post("<%=Path%>/user/ajax_in","email="+email+"&password="+pass+"&code="+code+"&sex=0",function (data) {
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
    //ajax 获取验证码
    function turnCode(){
        ajax.get("<%=Path%>/user/getCode",function(data){
            $('#ShowCode').html("<span>"+data+"</span>");
        });
    }
</script>
</head>
<body>
<!--顶部按钮-->
<nav class="navbar navbar-toggleable-md fixed-top navbar-inverse bg-inverse">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand title_font" href="<%=Path%>/" >Myth</a>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <%--<li class="nav-item active">
                <a class="nav-link" href="<%=Path%>/">首页 <span class="sr-only">(current)</span></a>
            </li>--%>

            <!--<li class="nav-item">
              <a class="nav-link disabled" href="#">Disabled</a>
            </li>-->

        </ul>

        <form class="form-inline my-2 my-lg-0" action="#">
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
                    <a class="dropdown-item" href="<%=Path%>/user/logout/user">注销登录</a>
                </div>
            </li>
            <%}%>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">功能中心</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">

                    <a class="dropdown-item" href="<%=Path%>/l/author.jsp">作家专区</a>
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
                    <%for(int i=1;i<=5;i++){%>
                        <li id="image_<%=i%>"><a><img src="<%=Path%>/image/home/<%=i%>.jpg" width="820px" height="345px" ></a></li>
                    <%}%>
                </ul>
                </div>
            </div>
            <%--图片对应的书籍--%>
            <div class="image_show_book">
                <ul>
                    <li style="width: 90px;color:#0E88EB;">编辑推荐:</li>
                    <%for(int i=1;i<=5;i++){%>
                        <li id="book_<%=i%>" onclick="toShow('<%=i%>')">22</li>
                    <%}%>
                    <li style="width: 30px;color:#0E88EB;"><a href="">>></a></li>
                </ul>
            </div><br/><br/>
            <!--排行榜区域-->
            <div class="row ">
                <div class="col-5 col-lg-3 ">
                    <h2 class="bang_title">热销排行</h2>

                    <p><a class="btn btn-secondary" href="#" role="button">更多 &raquo;</a></p>
                </div><!--/span-->
                <div class="col-5 col-lg-3">
                    <h2 class="bang_title">点击排行</h2>

                    <p><a class="btn btn-secondary" href="#" role="button">更多 &raquo;</a></p>
                </div><!--/span-->
                <div class="col-5 col-lg-3">
                    <h2 class="bang_title">打赏排行</h2>

                    <p><a class="btn btn-secondary" href="#" role="button">更多 &raquo;</a></p>
                </div><!--/span-->
                <div class="col-5 col-lg-3">
                    <h2 class="bang_title">收藏排行</h2>

                    <p><a class="btn btn-secondary" href="#" role="button">更多 &raquo;</a></p>
                </div>
            </div>
        </div>

        <!--
          书籍类别区域
          使用数据库动态生成 如果为了不频繁查询数据库使用缓存机制（因为这个数据的改动较少）
        -->
        <div class="col-6 col-md-3 sidebar-offcanvas" id="sidebar" >
            <%/*for(int i=0;i<list.size();++i){
                FatherType fa = (FatherType)list.get(i);
                List types = fa.getBookTypes();*/
                for(int i=0;i<types.size();i++){ List type = jedis.lrange(types.get(i),0,-1);
            %>
                <div class="card type_title" >
                    <div class="card-header" role="tab" id="heading<%=i%>">
                        <h5 class="mb-0">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse<%=i%>"
                               aria-expanded="true" aria-controls="collapse<%=i%>">
                                <%--<%=fa.getType_name()%>--%><%=types.get(i)%>
                            </a>
                        </h5>
                    </div>
                    <div id="collapse<%=i%>" class="collapse" role="tabpanel" aria-labelledby="heading<%=i%>">
                        <div class="card-block type_box">
                            <%--<%for (int j=0;j<types.size();++j){BookType type = (BookType)types.get(j);%>
                                <a href=""><button type="button" class="btn btn-primary"><%=type.getType_name()%></button></a>
                            <%}%>--%>
                            <%for (int j=0;j<type.size();j++){%>
                                <a href=""><button type="button" class="btn btn-primary"><%=type.get(j)%></button></a>
                            <%}%>
                        </div>
                    </div>
                </div>
            <%}%>
        </div>
    </div>
    <hr><!--分割线-->
    <footer>
        <p>&copy; Myth 2017</p>
    </footer>
</div>
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
<script src="<%=Path%>/js/in/jquery-slim.min.js"></script>
<script src="<%=Path%>/js/in/tether.min.js"></script>
<script src="<%=Path%>/js/in/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="<%=Path%>/js/in/ie10-viewport-bug-workaround.js"></script>
<script src="<%=Path%>/js/in/offcanvas.js"></script>
</body>
</html>
