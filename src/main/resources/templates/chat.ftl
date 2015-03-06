<html>

	<head>
	    <title>Chatterfox Base Chat</title>
	    <script src="/js/jquery-2.1.3.min.js"></script>
	    <script src="//cdn.jsdelivr.net/sockjs/0.3.4/sockjs.min.js"></script>
	    <script src="/js/stomp.js"></script>
	    <script src="/js/chat.js"></script>
	</head>
	
	<noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being enabled. Please enable Javascript and reload this page!</h2></noscript>
	
	<label>Chatterfox Base Chat</label><br>
	<label>Username: </label><label id="username">${user.name}</label><br><br>
	<input type="text" id="message"><button id="enter" onclick="sendMessage()">Enter</button><br><br>
	
	<label>Private Username</label><br>
	<input type="text" id="otheruser"><button onclick="sendPrivMessage()">Send</button><br><br>
	
	<button id="logout" onclick="logout()">Logout</button><br><br>
	
	<div id="chat_space" style="height : 20em; overflow : auto;"></div>

</html>