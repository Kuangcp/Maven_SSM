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


