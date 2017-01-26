/**
 * Created by l on 2017/1/21 0021.
 */
function init(){
    $('#main_2').css({'display':'none'});
    $('#item_1').attr('class','nav-link active');
}

function item_tran(item){
    console.log(item);
    for(var i=1;i<=5;i++){
        $('#main_'+i).css({'display':'none'});
        $('#item_'+i).attr('class','nav-link');
    }
    $('#main_'+item).css({'display':'block'});
     $('#item_'+item).attr('class','nav-link active');
}