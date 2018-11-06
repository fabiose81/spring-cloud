
$(document).ready(function() {
	
	function request(){
		$.ajax({
			url : "http://localhost:8082/api/client-ui/indice",
			success : function(response) {
				$('#indice-block').replaceWith(response);				
			},
			error : function(response) {
				$('#indice-block').attr('class', "panel panel-danger");
				$('#stock-heading').html("<strong>Stock</strong> service not responding.");
			}
		});

		$.ajax({
			url : "http://localhost:8082/api/client-ui/currency",
			success : function(response) {
				$('#currency-block').replaceWith(response);
			},
			error : function(response) {
				$('#currency-block').attr('class', "panel panel-danger");
				$('#currency-heading').html("<strong>Currency</strong> service not responding.");
			}
		});
	}
	
	request();
	
	setInterval(function() {
		request();
	}, 5000 * 60);

});