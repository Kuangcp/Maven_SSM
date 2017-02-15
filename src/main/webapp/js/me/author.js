/**
 * Created by l on 2017/1/21 0021.
 */
var receiver; //接收方名字
var send_name;//自己name
var sendor; //自己id
function init(){
    // $('#main_2').css({'display':'none'});
    Noshow();
    item_tran('1');
    $('#sendBox').attr('class','invisible');
    //$('#item_1').attr('class','nav-link active');
}
function Noshow(){
    for(var i=0;i<=6;i++){
        $('#main_'+i).css({'display':'none'});
        $('#item_'+i).attr('class','nav-link');
    }
}

function item_tran(item){
    //console.log("条目 : "+item);
    Noshow();
    $('#main_'+item).css({'display':'block'});
    if(item!='0')$('#item_'+item).attr('class','nav-link active');
    $("#show_info").attr('class','')
    $("#update_Info").attr('class','invisible');
}

function showMessage(data){
    $('#sendBox').attr('class','inputBox');
    $('#messageBox').attr('class','name_box');
    $('#SendMessage').attr('class','send_box');
    $('.historychat').attr('class','historychat invisible')
    $('#history_'+data).attr('class','historychat')
    receiver = data;
    document.getElementById('message_title').innerText = data;
   // console.log("赋值成功："+data);
}
function back(){
    document.getElementById('message_title').innerText = '消息查看';
    $('#messageBox').attr('class','name_box');
    $('#SendMessage').attr('class','invisible');
}
function new_Message() {

}
//---------------------------------------------------
var ws = null;
function connect(sender,sendname) {
    sendor = sender;
    send_name = sendname;
    ws = new SockJS("http://localhost/Book/message/sockjs");

    ws.onopen = function () {
        // setConnected(true);
        //console.log('Info: connection opened.');
    };

    ws.onmessage = function (event) {
        // console.log('收到的json: ' + event.data);
        setMessageInnerHTML(event.data);
    };

    ws.onclose = function (event) {
        // setConnected(false);
        //console.log('Info: connection closed.');
        //console.log(event);
    };
}
//发出数据函数
function send() {
    if (ws != null) {

        var dates = new Date();
        var month = dates.getMonth()+1;
        var day = dates.getUTCDate();
        if(month<10) month = "0"+month;
        if(day<10) day = "0"+day;
        var date =(1900+dates.getYear())+"-"+""+month+"-"+day+" "+dates.getHours()+":"+dates.getMinutes()+":"+dates.getSeconds();
        //console.log(dates.getDate()+""+dates.getUTCDate());
        var message = document.getElementById('inputText').value;
        //console.log(receiver);
        var receive_id = document.getElementById(receiver+'_id').innerText;
        message = "{\"send\":\""+sendor+"\",\"send_name\":\""+send_name+"\",\"receive\":"+receive_id+",\"receive_name\":\""+receiver+"\",\"title\":\""+send_name+" - To - "+receiver+" \",\"message\":\""+message+"\",\"send_time\":\""+date+"\",\"readed\":0}";
        //清除内容
        $('#inputText').val("");
        ws.send(message);
        console.log('发出的json: ' + message);

        // ws.send(message);
    } else {
        alert('connection not established, please connect.');
    }
}
//获取JSON 将消息显示在网页上
function setMessageInnerHTML(innerHTML) {
    var mess=eval('('+innerHTML+')');
    innerHTML = mess.message;
    console.log("长度 : "+innerHTML.length);

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
    var receive_id = document.getElementById(receiver+'_id').innerText;
    var json_receive = mess.receive_name;
    var history;
    //如果是当前窗口，直接添加
    // console.log("当前窗口："+receive_id+"--消息发送方："+mess.send+"--得到的："+receiver+"--添加的："+innerHTML);
    if(receive_id==mess.send){
        document.getElementById('history_'+receiver).innerHTML += innerHTML + '';
        history = document.getElementById('history_'+receiver);
    }else{
        // console.log("budeng---receiver="+receiver+",send_name="+send_name);
        var div = document.getElementById('history_'+receiver);
        if(div==null || div==undefined){
            //当收到的消息是当前没有这个div时，创建一个条目出来，BUG挺多，弃用
            // var title="<div class='row' onclick='showMessage("+mess.send_name+")' id='"+mess.send_name+"'><div class='col-2'>"+mess.send_name+"</div></div>";
            // document.getElementById('messageBox').innerHTML += title + '';
            // var content = "<div id='history_'"+json_receive+" class='historychat invisible'><div hidden id='"+mess.send+"_id'>"+mess.send+"</div> <div class='row_box'>"+message+"</div></div>";
            // document.getElementById('SendMessage').innerHTML += content + '';
        }else{
            // console.log('追加：history_'+mess.send_name);
            var current = document.getElementById('history_'+mess.send_name);
            if(current==null || current==undefined){
                current = document.getElementById('history_'+receiver);
            }
            current.innerHTML += innerHTML + '';
            history = document.getElementById('history_'+receiver);
        }
    }
    history.scrollTop = history.scrollHeight;
    //console.log(innerHTML);

}
//记录对方id的机制要改，加载消息要限制最近30条，其他的在历史记录里分页查看
// 新消息提示，更改阅读状态
//其他模块的编写
//Toolkit 的仓库转移，改成maven项目，便于发布和处理JAR的关系，发布到maven中央仓库去
//多阅读别人的代码，查看别人的思路，借鉴，升华