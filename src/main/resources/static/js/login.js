$(document).ready(function () {
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
						{
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