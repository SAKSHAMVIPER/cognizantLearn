//WRITE YOUR jQUERY CODE HRE
$("#btn-id").on("click",function(){
    $.ajax({
        url:'employee.json',
        dataType:'json',
        success: function(data){
            $("#err-id").html('Success Message: File found');
        },
        statusCode:{
            404: function() {
           $("#err-id").html('Error Message: Not found');
         }
        }
    });
});