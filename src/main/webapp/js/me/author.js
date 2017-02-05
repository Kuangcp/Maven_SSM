/**
 * Created by l on 2017/1/21 0021.
 */
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
    console.log(data);
}
//将消息显示在网页上
function setMessageInnerHTML(innerHTML) {
    // var mess = eval(+innerHTML);
    // innerHTML = mess.content;
    var message = '  ';
    for(var i=0;i<innerHTML.length;i+=50){
        message+=innerHTML.substr(i,50)+'<br/>';
    }
    //console.log(message);
    innerHTML = "<div class='row_box'>"+message+"</div>";
    document.getElementById('history').innerHTML += innerHTML + '';
    var history = document.getElementById('history');
    // console.log(history);
    history.scrollTop = history.scrollHeight;
}
//发送消息 这里进行JSON包装
function send(id) {
    var dates = new Date();
    var date =(1900+dates.getYear())+"-"+""+(dates.getMonth()+1)+"-"+dates.getUTCDate()+" "+dates.getHours()+":"+dates.getMinutes();
    //console.log(dates.getDate()+""+dates.getUTCDate());
    var message = document.getElementById('inputText').value;
    message = "{send:\""+id+"\",title:\"发送至 00 \"content:\""+message+"\",send_time:\""+date+"\"}";
    console.log("发送的 ："+message);
    websocket.send(message);
}