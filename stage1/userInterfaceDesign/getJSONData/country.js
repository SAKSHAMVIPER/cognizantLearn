//WRITE YOUR jQUERY CODE HERE
$("#btn-id").on("click",function(){
    $.getJSON("https://reqres.in/api/users?page=2",function(data){
        var user="";
        $.each(data["data"],function(key,value){
            user += '<ul>';
            user +='<li>'+value.id+' -- '+value.email+'</li>';
            user +='</ul>';
        });
        $("#data-id").append(user);
    });
});