//WRITE YOUR jQUERY CODE HERE
var row_index=0;
$(".add-row").on("click",function(){
     var name=$('#name').val();
     $('tbody').append("<tr><td><input type='checkbox' name='record'></td><td>"+name+"</td></tr>");
});
$(".delete-row").on("click",function(){
      $('table tr').has('input[name="record"]:checked').remove();
});