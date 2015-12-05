
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

			$("#boxlist").change(function() {
				// Get the value of the boxlist
				var isbn = document.getElementById("boxlist").value;

				$.ajax({
					url : 'crud/read/'+isbn,
					type : 'GET',
					dataType : 'json',
					success : function(json) {

						// Set all the fields (not writable) in the form

						document.getElementById("inputISBN").setAttribute("value", json.isbn);
						document.getElementById("inputName").setAttribute("value", json.name);
						document.getElementById("inputYear").setAttribute("value", json.year);
						document.getElementById("inputArea").setAttribute("value", json.area);
						document.getElementById("inputAuthor").setAttribute("value", json.author);
						document.getElementById("inputStatus").setAttribute("value", json.status);
						document.getElementById("inputQuantity").setAttribute("value", json.quantity);
							
					}
				});
			});
		});