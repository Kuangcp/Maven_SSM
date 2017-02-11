<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf8" %>
<html>
<head>
    <title>后台管理中心</title>
    <link rel="icon" href="../image/ico/books.ico">
    <link href="../js/css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/dashboard.css" rel="stylesheet">
    <link href="../css/author.css" rel="stylesheet">

</head>
<body>

<nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
    <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand title_font" href="#" >Myth·后台管理</a>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
        </ul>
        <ul class="navbar-nav" style="margin-right: 50px;">
            <li class="nav-item">
                <a class="nav-link user_font" href=""><img src="../image/author/messages.png" width="28px" height="28px"></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle user_font" href="http://example.com" id="dropdown03"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="">用户名</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="">个人中心</a>
                    <a class="dropdown-item" href="#">文档帮助</a>
                </div>
            </li>
        </ul>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">

        <%--导航栏--%>
        <nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar" style="width:140px;">
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link" href="#" id="item_1" onclick="item_tran('1')"><img src="../image/author/newspapel.png" width="26px" height="26px">  </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" id="item_2" onclick="item_tran('2')"><img src="../image/author/book.png" width="30px" height="30px"> </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" id="item_3" onclick="item_tran('3')"><img src="../image/author/credit-card.png" width="30px" height="30px"> </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" id="item_4" onclick="item_tran('4')"><img src="../image/author/gift.png" width="30px" height="30px"> </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#" id="item_5" onclick="item_tran('5')"><img src="../image/author/info-large-outline.png" width="30px" height="30px"> </a>
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
    </div>
</div>
<!-- Placed at the end of the document so the pages load faster -->
<script src="../js/in/jquery-slim.min.js"></script>
<script src="../js/in/jquery-3.0.0.min.js"></script>
<script src="../js/in/tether.min.js"></script>
<script src="../js/in/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../js/in/ie10-viewport-bug-workaround.js"></script>
<script src="../js/me/author.js"></script>
<script>
    $(function(){
        init();
    });

</script>
</body>
</html>
