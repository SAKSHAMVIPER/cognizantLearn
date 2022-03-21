function display(){
    var print_name = document.getElementById("sname").value;
    var print_course = document.getElementById("course").value;
    if(print_name ===""){
        document.getElementById("greet").innerHTML = "Name cannot be empty";
    }
    else{
       document.getElementById("greet").innerHTML ="Hi,"+print_name+".You have successfully registered for the"+print_course+"course."; 
    }
}