
/*$(window).load(function(){     	
  $('#login1').hide();
  $('#login').show();
  $('#register').hide();

})
*/

$('#toggle-login-anon').click(function(){
  if($('#login').is(':visible')){
    $('#login').hide();
  }
  else { 
    $('#login1').hide()
    $('#register').hide()
    $('#login').show();
  }
});

$('#toggle-login-accn').click(function(){
  if($('#login1').is(':visible')){
    $('#login1').hide();
  }
  else { 
    $('#login').hide()
    $('#register').hide()
    $('#login1').show();
  }
});

$('#toggle-register').click(function(){
  if($('#register').is(':visible')){
    $('#register').hide();
  }
  else { 
    $('#login').hide()
    $('#login1').hide()
    $('#register').show();
  }
});

$(document).ready(function ()
{
  $('#login1').hide();
  $('#login').show();
  $('#register').hide();
	$('#user_login').keyup(function(event){
    	if(event.keyCode == 13){
        	$('#enter').click();
    	}
	});
});


function loginUser() {

	var userName = $('#user_login').val();

	if (userName) {
		$.ajax(
				{
					type : "POST",
					url  : "/login/anon/",
					data : {
						"name" : userName,
					},
					success : function(result) {
						if(result === "success")
						{//also not a good way of doing this, should probably split it up into a few functions
							window.location.replace("/chat/" + userName);
						}
						else
							alert("Username already exists.");
					},
					error: function (jqXHR, exception) {
						alert("Something went wrong.");
					}
				});
	} else {
		alert("Failed");
	}
}