function OrderCake(str) {
	//fill the code
	var kg=parseInt(str.slice(0,4))/1000;
	var name=str.slice(4,str.length-3)
	var orderid=str.slice(str.length-3,str.length)
	var price=Math.round(kg*450)
	var result="Your order for "+Math.ceil(kg)+" kg "+name+" cake has been taken. You are requested to pay Rs. "+price+" on the order no "+orderid;
	 
	console.log(result)
	return result
}
OrderCake("5848ButterBlast485");

