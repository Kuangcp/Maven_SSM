/**
 * Created by l on 2017/2/5 0005.
 */

var websocket = null;
//判断当前浏览器是否支持WebSocket
if ('WebSocket' in window) {
    websocket = new WebSocket("ws://localhost/Book/message");
}
else {
    alert('You Not support web socket')
}

//连接发生错误的回调方法
websocket.onerror = function () {
    console.log("WebSocket Error!!");
};

//连接成功建立的回调方法
websocket.onopen = function () {
    console.log("WebSocket Success");
}

//接收到消息的回调方法
websocket.onmessage = function (event) {
    setMessageInnerHTML(event.data);
}

//连接关闭的回调方法
websocket.onclose = function () {
    console.log("WebSocket Closed");
}

//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
window.onbeforeunload = function () {
    closeWebSocket();
}


//关闭WebSocket连接
function closeWebSocket() {
    websocket.close();
}



//获取JSON 将消息显示在网页上
function setMessageInnerHTML(innerHTML) {
    var mess=eval('('+innerHTML+')');
    innerHTML = mess.message;

    var message = '  ';
    for(var i=0;i<innerHTML.length;i+=50){
        message+=innerHTML.substr(i,50)+'<br/>';
    }
    if(sendor==mess.send){
        innerHTML = "<div class='row_box me_box'>"+message+"</div>";
    }else if(sendor==mess.receive){
        innerHTML = "<div class='row_box'>"+message+"</div>";
    }else{
        innerHTML='';
    }

    //如果是当前窗口，直接添加
    if(receiver==mess.receive_name){
        document.getElementById('history_'+receiver).innerHTML += innerHTML + '';
        var history = document.getElementById('history_'+receiver);
    }else{
        var div = document.getElementById('history_'+receiver);
        if(div==null){
            var title="<div class='row' onclick='showMessage("+send_name+")' id='"+send_name+"'><div class='col-2' style='float:left;'>"+send_name+"</div></div>";
            document.getElementById('messageBox').innerHTML += title + '';
            var content = "<div id='history_'"+receiver+" class='historychat invisible'> <div class='row_box'>"+message+"</div></div>";
            document.getElementById('SendMessage').innerHTML += content + '';
        }else{
            document.getElementById('history_'+receiver).innerHTML += innerHTML + '';
            var history = document.getElementById('history_'+receiver);
        }
    }
    history.scrollTop = history.scrollHeight;
    //console.log(innerHTML);

}
//发出JSON 发送消息 这里进行JSON包装
function send(sender,sendname) {
    sendor = sender;
    send_name = sendname;
    var dates = new Date();
    var month = dates.getMonth()+1;
    var day = dates.getUTCDate();
    if(month<10) month = "0"+month;
    if(day<10) day = "0"+day;
    var date =(1900+dates.getYear())+"-"+""+month+"-"+day+" "+dates.getHours()+":"+dates.getMinutes()+":"+dates.getSeconds();
    //console.log(dates.getDate()+""+dates.getUTCDate());
    var message = document.getElementById('inputText').value;
    console.log(receiver);
    var receive_id = document.getElementById(receiver+'_id').innerText;
    message = "{\"send\":\""+sender+"\",\"send_name\":\""+send_name+"\",\"receive\":"+receive_id+",\"receive_name\":\""+receiver+"\",\"title\":\"发送至"+receive_id+" \",\"message\":\""+message+"\",\"send_time\":\""+date+"\",\"readed\":0}";
    console.log("发送的 ："+message);
    //清除内容
    $('#inputText').val("");
    websocket.send(message);
}
