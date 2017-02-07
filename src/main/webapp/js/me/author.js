/**
 * Created by l on 2017/1/21 0021.
 */
var receiver; //接收方名字
var send_name;
var sendor; //自己
function init(){
    // $('#main_2').css({'display':'none'});
    Noshow();
    item_tran('1');
    //$('#item_1').attr('class','nav-link active');
}
function Noshow(){
    for(var i=0;i<=6;i++){
        $('#main_'+i).css({'display':'none'});
        $('#item_'+i).attr('class','nav-link');
    }
}

function item_tran(item){
    console.log(item);
    Noshow();
    $('#main_'+item).css({'display':'block'});
    if(item!='0')$('#item_'+item).attr('class','nav-link active');
    $("#show_info").attr('class','')
    $("#update_Info").attr('class','invisible');
}

function showMessage(data){
    $('#messageBox').attr('class','invisible');
    $('#SendMessage').attr('class','');
    $('.historychat').attr('class','historychat invisible')
    $('#history_'+data).attr('class','historychat')
    receiver = data;
    document.getElementById('message_title').innerText = data;
    //console.log(data);
}
function back(){
    document.getElementById('message_title').innerText = '消息查看';
    $('#messageBox').attr('class','container');
    $('#SendMessage').attr('class','invisible');
}
function new_Message() {

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