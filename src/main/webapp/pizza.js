function login()
{
    let username = document.getElementById("firstform").elements[0].value;
    let password = document.getElementById("firstform").elements[0].value;
    if(username == "Pizza" && password == "Time")
    {
        console.log("In getVG");
	    var xhr = new XMLHttpRequest();
	    xhr.onreadystatechange = function()
	    {
		    console.log("in onreadystatechange "+xhr.readyState);
		    if(xhr.readyState == 4 && xhr.status == 200)
		    {
			    console.log(xhr.responseText);
		    }
	    }
	xhr.open("POST", "http://localhost:8080/PizzaTime/order?username="+username+"&?password="+password, true);
	xhr.send();
    }
}

function placeOrder()
{
    console.log("in postVG");
	
	let vg = document.getElementById("firstform").submit;
	var xhr= new XMLHttpRequest();
	xhr.onreadystatechange= function() 
	{
		console.log("in ORSC "+ xhr.readyState );
		if(xhr.readyState==4 && xhr.status==200)
		{
			console.log(xhr.responseText);
		}
	}
	xhr.open("POST","http://localhost:8080/PizzaTime/order",true);
	var trash=jsonBuilder();
	xhr.send(trash);
}

function jsonBuilder() 
{
    var elements = document.getElementById("firstform").elements;
    var obj ={};
	for(var i = 0 ; i < elements.length-1; i++)
	{
        var item = elements.item(i);
        obj[item.name] = item.value;
        console.log(obj);        
    }
    var json= JSON.stringify(obj);
    console.log(json);
    return json;
}

window.onload = function()
{
    document.querySelector("input [name = 'submit']").addEventListener("click", login);
}