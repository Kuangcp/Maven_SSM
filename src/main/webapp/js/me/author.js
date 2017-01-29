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
    for(var i=0;i<=5;i++){
        $('#main_'+i).css({'display':'none'});
        $('#item_'+i).attr('class','nav-link');
    }
}

function item_tran(item){
    // console.log(item);
    Noshow();
    $('#main_'+item).css({'display':'block'});
    if(item!='0')$('#item_'+item).attr('class','nav-link active');
}