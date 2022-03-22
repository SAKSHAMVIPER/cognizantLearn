//Write Your jQuery Code Here
$("#btnId").click(function() {
        var name = $("#txt").val();
        $("#address").html('"<h2>Welcome '+name+'!"</h2>');
      });