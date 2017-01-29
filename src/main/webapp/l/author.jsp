<%@ page import="com.book.bean.Author" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String Path = request.getContextPath();
    Author author = (Author) session.getAttribute("author");
    if(author==null) response.sendRedirect(Path+"/l/login.jsp");
%>
<html>
<head>
    <title>作家管理中心</title>
    <link rel="icon" href="<%=Path%>/image/ico/book.ico">
    <link href="<%=Path%>/js/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=Path%>/css/dashboard.css" rel="stylesheet">
    <link href="<%=Path%>/css/author.css" rel="stylesheet">
    <script src="<%=Path%>/js/jquery-3.0.0.min.js"></script>
    <script>
        $(function(){
            init();
        });
    </script>
</head>
<body>
<%--<%
 String email = request.getParameter("email");
 System.out.println(email);
%>
<%=email%>--%>
<nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
    <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand title_font" href="<%=Path%>/l/author.jsp" >Myth·作家专区</a>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
        </ul>
        <%if(author!=null){%>
        <ul class="navbar-nav" style="margin-right: 50px;">
            <li class="nav-item">
                <a class="nav-link user_font" href=""><img src="<%=Path%>/image/author/messages.png" width="28px" height="28px"></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle user_font" href="http://example.com" id="dropdown03"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><%=author.getName()%></a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item"  onclick="item_tran('0')">个人中心</a>
                    <a class="dropdown-item" href="#">文档帮助</a>
                </div>
            </li>
        </ul>
        <%}%>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">

        <%--导航栏--%>
        <nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar" style="width:140px;">
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link" href="#" id="item_1" onclick="item_tran('1')"><img src="../image/author/newspapel.png" width="26px" height="26px">  作家资讯</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" id="item_2" onclick="item_tran('2')"><img src="../image/author/book.png" width="30px" height="30px"> 作品管理</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" id="item_3" onclick="item_tran('3')"><img src="../image/author/credit-card.png" width="30px" height="30px"> 稿酬收入</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" id="item_4" onclick="item_tran('4')"><img src="../image/author/gift.png" width="30px" height="30px"> 奖金收入</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" id="item_5" onclick="item_tran('5')"><img src="../image/author/info-large-outline.png" width="30px" height="30px"> 作家帮助</a>
                </li>
            </ul>
        </nav>

        <%--
            页面内容
        --%>
        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3" id="main_1">
            <h1>Dashboard</h1>

        </main>

        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3" id="main_2">
            <h1>main 2 </h1>

        </main>
        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3" id="main_0">
            <h1>main666 </h1>

        </main>
    </div>
</div>
<!-- Placed at the end of the document so the pages load faster -->
<script src="<%=Path%>/js/jquery-slim.min.js"></script>

<script src="<%=Path%>/js/tether.min.js"></script>
<script src="<%=Path%>/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="<%=Path%>/js/ie10-viewport-bug-workaround.js"></script>
<script src="<%=Path%>/js/me/author.js"></script>

</body>
</html>
