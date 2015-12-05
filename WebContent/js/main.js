var $_GET = {};

document.location.search.replace(/\??(?:([^=]+)=([^&]*)&?)/g, function () {
    function decode(s) {
        return decodeURIComponent(s.split("+").join(" "));
    }
    console.log("1 = " + arguments[1])
    console.log("2 = " + arguments[2])
    $_GET[decode(arguments[1])] = decode(arguments[2]);
});

var tab = $_GET["tab"];

if(tab == 1){
	document.getElementById("li_create").setAttribute("class", "active");
	console.log("yeah is one!");
}else{
	console.log("nope... it is " + tab)
}
