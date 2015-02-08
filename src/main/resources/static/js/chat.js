var stompClient = null;

function connect() {
	var socket = new SockJS('/conn');
	stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/base/chat/anonmess', function(message){
        	var JSONified = JSON.parse(message.body);
        	showMessage(JSONified.name + ": " + JSONified.message);
        });
    });
}

function disconnect() {
	stompClient.disconnect();
	console.log("Disconnected");
	return null;
}

function sendMessage() {
	var username = $('#username').text();
	var txtmessage = $('#message').val();
	stompClient.send("/anon/conn", {}, JSON.stringify({ 'name': username, 'message' : txtmessage }));
}

function showMessage(txtmessage) {
	$('#chat_space').append(txtmessage + '<br>');
}

window.onload = connect();
window.onbeforeunload = disconnect();

$(document).ready(function ()
{
	$('#message').keyup(function(event){
    	if(event.keyCode == 13){
    	    $('#enter').click();
    	}
	});
});