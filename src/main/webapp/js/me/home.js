/**
 * Created by l on 2017/1/17 0017.
 */
function showType(list_id){
    console.log('移动到'+list_id+'');
    switch(list_id){
        case 'a_1':
            console.log('1');

        default:
    }
}
function toShow(id){
    // console.log(id);
    for(var i=1;i<=5;i++){
        $('#book_'+i).css({'background-color':'darkgray','color':'black'});
        $('#image_'+i).css('display','none');
    }
    $('#book_'+id).css({'background-color':'#0E88EB','color':'white'});
    $('#image_'+id).css('display','block')
}
/*jQuery.get("http:localhost/Book/user/login",function(data){
 console.log(data);
 });
 $.ajax({
 type: "GET",
 url: "http:localhost/Book/user/login",
 data: "email=" + email + "&password=" + pass,
 success: function (data) {
 console.log("Data Saved: " + data);
 }
 });*/