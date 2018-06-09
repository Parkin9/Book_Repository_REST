document.addEventListener("DOMContentLoaded", function(){
    
    
    $("#btn1").one('click', function(){
        
        $.ajax({
            url: "http://localhost:8080/books/1",
            success: function(json){
                //console.log(json.title);
				$("#date1-1").append(json.title);
        }});
    });
	
	$("#btn2").one('click', function(){
        
        $.ajax({
            url: "http://localhost:8080/books/2",
            success: function(json){
                //console.log(json.title);
				$("#date2-1").append(json.title);
        }});
    });
	
	$("#btn3").one('click', function(){
        
        $.ajax({
            url: "http://localhost:8080/books/3",
            success: function(json){
                //console.log(json.title);
				$("#date3-1").append(json.title);
        	}
		});
    });
//////////////////////////////////////////////////////////////
	
	$("#search").click(function(e){
		e.preventDefault();
		var id = $("#idVal").val();
        
	  $.ajax({
		  url: "http://127.0.0.1:8080/books/" + id,
		  success: function(result) {
			  console.log(result);
			  $("#divForm").append(result.title);
		  }
	  });
	});
//////////////////////////////////////////////////////////////
	
	$('#date1-1').one('click', function() {
		$.ajax({
			url: "http://localhost:8080/books/1",
			success: function(result) {
				$('#date1-2').append(JSON.stringify(result));
			}
		});
	});
	
	$('#date2-1').one('click', function() {
		$.ajax({
			url: "http://localhost:8080/books/2",
			success: function(result) {
				$('#date2-2').append(JSON.stringify(result));
			}
		});
	});
	
	$('#date3-1').one('click', function() {
		$.ajax({
			url: "http://localhost:8080/books/3",
			success: function(result) {
				$('#date3-2').append(JSON.stringify(result));
			}
		});
	});
//////////////////////////////////////////////////////////////////
	
	$("#add").click(function(e){
		e.preventDefault();
		var id = $("#idBook").val();
		var isbn = $("#isbnBook").val();
		var title = $("#titleBook").val();
		var author = $("#authorBook").val();
		var publish = $("#publishBook").val();
		var type = $("#typeBook").val();
        
	  $.ajax({
		  url: "http://127.0.0.1:8080/books/",
		  success: function(result) {
			  console.log(result);
			  $("#divForm").append(result.title);
		  }
	  });
	});
});