"use strict";
function wordPlay(number){
    if(number>50){
        console.log("Range is High");
        return "Range is High";
    }
    if(number<1){
        console.log("Not Valid");
        return "Not Valid";
    } 
    var s='';
    
    for(let i=1;i<=number;i++){
        
        if(i%5===0 && i%3===0){
            s+= " Jump";
        }
        else if(i%3===0){
            s+= " Tap";
        }
        else if(i%5===0){
            s+= " Clap";
        }
        else{
            s+=" "+i;
        }
        
    }

    console.log(s)
      return s;
    
}
wordPlay(16)