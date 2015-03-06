var stompClient = null;

var receiveMessage = function(message) {
    var JSONified = JSON.parse(message.body);
    showMessage(0, JSONified.name + " (" + JSONified.time + ") " + "- " + JSONified.message);
}

var receivePrivMessage = function(message) {
    var JSONified = JSON.parse(message.body);
    showMessage(1, JSONified.name + " (" + JSONified.time + ") " + "- " + JSONified.message);
}

function showMessage(bool, txtmessage) {
    if(bool == 0) {
        $('#chat_space').append(txtmessage + '<br>');
    }
    else {
        $('#chat_space').append('<div style="color:#FF0000">' + txtmessage + '</div>');
    }
    
    $('#chat_space').animate({
        scrollTop: $('#chat_space')[0].scrollHeight
    }, "fast");
}

function connect() {
	var socket = new SockJS('/conn');
	
	stompClient = Stomp.over(socket);
	
    stompClient.connect({}, function(frame) {
        console.log('Connected: ' + frame);
        
        stompClient.subscribe('/base/chat/anonmess', receiveMessage);
        stompClient.subscribe("/private/conn/message/" + $('#username').text(), receivePrivMessage);
    });
}

function Message(client, url, ctime) {
    var username = $('#username').text();
    var txtmessage = $('#message').val();
    
    client.send(url, {}, JSON.stringify({ 'name': username, 'message' : txtmessage, 'time' : ctime }));
}

function sendMessage() {
    var date = new Date();
    var ctime = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
    
	Message(stompClient, "/anon/conn", ctime);
}

function sendPrivMessage() {
    var date = new Date();
    var ctime = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
    var otheruser = $('#otheruser').val();
    
    Message(stompClient, "/anon/conn/message/" + otheruser, ctime);
    
    var username = $('#username').text();
    var txtmessage = $('#message').val();
    
    var myMessage = username + "->" + otheruser + " (" + ctime + ") " + "- " + txtmessage;
    
    showMessage(1, myMessage);
}

function disconnect() {
    stompClient.disconnect();
    console.log("Disconnected");
    return null;
}

function logout() {
    disconnect();
    
    $.ajax(
            {
                type : "DELETE",
                url  : "/login/anon/" + $('#username').text(),
                data : {
                },
                success : function(result) {
                    window.location.replace("/");
                },
                error: function (jqXHR, exception) {
                    alert("Failed to logout.");
                }
            });
}

window.onload = connect();
window.onbeforeunload = disconnect();
$('#otheruser').watermark('Other username for private message');

$(document).ready(function ()
{
	$('#message').keyup(function(event){
    	if(event.keyCode == 13){
    	    $('#enter').click();
    	}
	});
});