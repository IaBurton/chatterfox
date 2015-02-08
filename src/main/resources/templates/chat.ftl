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
	
	<!-- <button id="dis" onclick="disconnect()">dis</button><br><br> commented out for now -->
	
	<p id="chat_space"></p>

</html>