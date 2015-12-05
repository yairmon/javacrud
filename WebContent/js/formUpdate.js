$( "#formUpdate" ).submit(function( event ) {
	clearISBN();
	
	// Stop form from submitting normally
	event.preventDefault();

	// Get some values from elements on the page:
	var $form = $( this ),
		v_oldisbn = $form.find( "select[name='oldisbn']" ).val(),
		v_isbn = $form.find( "input[name='isbn']" ).val(),
	  	v_name = $form.find( "input[name='name']" ).val(),
	  	v_year = $form.find( "input[name='year']" ).val(),
	  	v_author = $form.find( "input[name='author']" ).val(),
	  	v_area = $form.find( "input[name='area']" ).val(),
	  	v_status = $form.find( "input[name='status']" ).val(),
	  	v_quantity = $form.find( "input[name='quantity']" ).val(),
	    url = $form.attr( "action" );

		// Send the data using post
		var posting = $.post(url, {
			oldisbn : v_oldisbn,
			isbn : v_isbn,
			name : v_name,
			year : v_year,
			author : v_author, 
			area : v_area,
			status : v_status, 
			quantity : v_quantity
		});

		// Show the result
		posting.done(function(data) {
			console.log("server says..." + data);
			if(data == "Success"){
				showSuccess();
				$( "#inputISBN" ).focus();
			}else
				showErrorISBN(data);
			
		});


//	}
	document.body.scrollTop = document.documentElement.scrollTop = 0;
});

// Show an alert if is empty the ISBN field
// And add the red input in the form
function showErrorISBN(data){
	var error = document.getElementById("alertError1"); 
	error.className = 'alert alert-danger';
	error.innerHTML = data;
	document.getElementById("divISBN").className = 'form-group has-error';
	
}

// Create the notification for success
function showSuccess(){

//	Div where the alert is going to be
	var father = document.getElementById('alertSuccess');
	father.style.display = 'block';
	
	if(father.childNodes.length > 0)
		console.log("already has...");
	else{

		var div = document.createElement("div");
		div.innerHTML = "Book has been modified.";
		div.setAttribute("class", "alert alert-success alert-dismissible");
		div.setAttribute("role", "alert");
		var button = document.createElement("button");
		button.setAttribute("type", "button");
		button.setAttribute("class", "close");
		button.setAttribute("data-dismiss", "alert");
		button.setAttribute("aria-label", "Close");
		var span = document.createElement("span");
		span.setAttribute("aria-hidden", "true");
		span.innerHTML = "&times;";
		button.appendChild(span);
		div.appendChild(button);
		father.appendChild(div);
	}
	
}

function clearISBN(){
	document.getElementById("alertError1").className = '';
	document.getElementById("alertError1").innerHTML = '';
	document.getElementById("divISBN").className = 'form-group';
}

