"use strict"
function modifyString(str)
{
    let removeWhiteSpace=str.replace(/\s+/g, '');
    return removeWhiteSpace.toLowerCase();
}

function uniqueCharacters(str)
{
 let s=modifyString(str);
 let result=new Set(s)
  result=Array.from(result).join('')
  return result

}
console.log(uniqueCharacters("Welcome to the Javascript course"));



