//WRITE YOUR jQUERY CODE HERE
$("#each_ex").on("click",function(){
    $(".men_ex ul li a").css("background-color","red");
    var con =[];
    $(".men_ex ul li").each(function() { con.push($(this).text()) });
    var menu = '<p>' + con.join('<br>') + '</p>';
    $("#msg_ex").html(menu);
    
});