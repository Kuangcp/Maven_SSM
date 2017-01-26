/**
    *
    * Created by Myth on 2017/1/16 0016
    */
/*校验密码*/
function checkPassword(){
    var first = $('#inputPassword1').val();
    var second = $('#inputPassword2').val();
    //alert("["+first+"]["+second+"]");
    if(first == second){
        $('#submitting').removeAttr('disabled');
        $('#OUT_pass').html('');
    }else{
        $('#submitting').attr('disabled','disabled');
        //alert("两次输入的密码不相同");
        $('#OUT_pass').html('<span style="color:red">两次输入的密码不相同</span>');
    }
}
//ajax 验证用户名 尚未完善，等写好接口再。。
function checkUsername(){
    //console.log('username');
    $.get("",{name:"id"},function(data){

    });
    if(true){
        $('#submitting').removeAttr('disabled');
        $('#OUT_name').html('');
    }else{
        $('#submitting').attr('disabled','disabled');
        $('#OUT_name').html('<span style="color:red">用户名已存在</span>');
    }
}
//获取验证码
function getCode(){
    // alert('getCode');
    if($('#inputEmail').val() ){
        if(checkMail($('#inputEmail').val())) {
            buttonCountdown($('#CodeBtn'), 1000 * 60 * 1, "ss");
        }else{
            alert('请输入正确的邮件地址');
        }
    }
}
function checkIdCard(){

}
/*function clearCode(){
    $('#CodeBtn').trigger('bc.clear');
}*/
function checkMail(mail){
    // var reg = /^[A-Za-zd]+([-_.][A-Za-z0-9]+)*@([A-Za-z0-9]+[-.])+[A-Za-z0-9]{2,5}$/;
    var reg = /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
    var checkResult = reg.test(mail);
    return checkResult;
}
/*可以倒计时很久的工具方法*/
function buttonCountdown($el,msNum,timeFormat){
    var text = $el.data("text") || $el.text(),timer=0;
    $el.prop("disabled",true).addClass("disabled").on("bc.clear",function (){
        clearTime();
    });
    (function countdown(){
        var time = showTime(msNum)[timeFormat];
        $el.text(time+'后重试');
        if(msNum<=0){
            msNum = 0;
            clearTime();
        }else{
            msNum-= 1000;
            timer = setTimeout(arguments.callee,1000);
        }
        })();
    function clearTime(){
        clearTimeout(timer);
        $el.prop("disabled",false).removeClass("disabled").text(text);
    }
    function showTime(ms){
        var d = Math.floor(ms/1000/60/60/24),
            h = Math.floor(ms/1000/60/60%24),
            m = Math.floor(ms/1000/60%60),
            s = Math.floor(ms/1000%60),
            ss = Math.floor(ms/1000);
        return {
            d:d+"天",
            h:h+"时",
            m:m+"分",
            s:s+"秒",
            ss:ss+"秒",
            "d:h:m:s":d+"天"+h+"时"+m+"分"+s+"秒",
            "h:m:s":h+"时"+m+"分"+s+"秒",
            "m:s":m+"分"+s+"秒"
        };
    }
    return this;
}