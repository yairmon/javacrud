// When the HTML is loaded
$(document).ready(
		function() {
			$.ajax({
				url : 'crud/read/showallbooks',
				type : 'GET',
				dataType : 'json',
				success : function(json) {
					$.each(json, function(i, value) {

						var text = value.isbn + ', ' + value.name;

						$('#boxlist').append(
								// Add an option to the #boxlist
								// It contains the isbn,name as text
								// It contains the isbn as value
								$('<option>').text(text).attr('value',value.isbn));
					});
				}
			});
			
			
		});

// When the form is sent
$( "#formDelete" ).submit(function( event ) {
	
	// Stop form from submitting normally
	event.preventDefault();

	// Get some values from elements on the page:
	var $form = $( this ),
		v_isbn = $form.find( "select[name='isbn']" ).val(),
	    url = $form.attr( "action" );

		// Send the data using post
		var posting = $.post(url, {
			isbn : v_isbn
		});

		// Show the result
		posting.done(function(data) {
			console.log("server says..." + data);
			if(data == "Success"){
				showSuccess();
				
			}else
				showErrorISBN(data);
			
		});


//	}
});

//Create the notification for success
function showSuccess(){

//	Div where the alert is going to be
	var father = document.getElementById('alertSuccess');
	father.style.display = 'block';
	
	if(father.childNodes.length > 0)
		console.log("already has...");
	else{

		var div = document.createElement("div");
		div.innerHTML = "Book has been deleted.";
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


//Show an alert if is empty the ISBN field
//And add the red input in the form
function showErrorISBN(data){
	var error = document.getElementById("alertError1"); 
	error.className = 'alert alert-danger';
	error.innerHTML = data;
	document.getElementById("divISBN").className = 'form-group has-error';
	
}