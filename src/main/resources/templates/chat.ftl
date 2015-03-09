<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Chatterfox Base Chat</title>

<script src="/js/jquery-2.1.3.min.js"></script>
<script src="//cdn.jsdelivr.net/sockjs/0.3.4/sockjs.min.js"></script>
<script src="/js/stomp.js"></script>
<script src="/js/chat.js"></script>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/simple-sidebar.css" rel="stylesheet">

</head>

<body>

	<div id="wrapper">
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="sidebar-brand" style="color: white">Welcome to
					Chatterfox!</li>
				<li><a href="#">Username: <label id="username">${user.name}</label></a></li>
				<li><a href="http://cs480-projects.github.io/teams/codefox.html">About</a></li>
				<li><a href="#" data-toggle="modal" data-target="#myModal">Contact</a></li>




				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Contact Us!</h4>
							</div>
							<div class="modal-body">
								<form class="form-horizontal" role="form" method="post"
									action="index.php">
									<div class="form-group">
										<label for="name" class="col-sm-2 control-label">Name</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="name" name="name"
												placeholder="First & Last Name" value="">
										</div>
									</div>
									<div class="form-group">
										<label for="email" class="col-sm-2 control-label">Email</label>
										<div class="col-sm-10">
											<input type="email" class="form-control" id="email"
												name="email" placeholder="example@domain.com" value="">
										</div>
									</div>
									<div class="form-group">
										<label for="message" class="col-sm-2 control-label">Message</label>
										<div class="col-sm-10">
											<textarea class="form-control" rows="4" name="message"></textarea>
										</div>
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<input name="submit" type="submit" value="Send"
									class="btn btn-primary">
							</div>
						</div>
					</div>
				</div>



				<li><a href="#" id="logout" onClick="logout()">Logout</a></li>

				<br>
				<br>
				<br>

				<div id="parent">

					<div>
						<li><a href="#" data-toggle="collapse"
							data-target="#users_space">Users Online</a></li>
						<ul>
							<p id="users_space" class="collpase in" style="color: black"></p>
						</ul>
					</div>
			</ul>
		</div>
		<a href="#menu-toggle" class="btn btn-link" id="menu-toggle"
			style="color: white"> <span
			class="glyphicon glyphicon-align-left"></span>
		</a>

		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<div class="container">
							<div class="row">
								<div class="col-lg-12">
									<div class="panel panel-primary">
										<div class="panel-heading">Global Chat</div>
										<div class="panel-body" id="chat_space" style="height: 75%; overflow-y: scroll"></div>
									</div>

									<div class="row">
										<div class="col-sm-12">
											<div class="input-group">
												<input type="text" class="form-control" id="otheruser"
													placeHolder="Enter a Username..."> <span
													class="input-group-btn">
													<button class="btn btn-primary"
														onClick="sendPrivMessage()" type="button">
														Send <span class="glyphicon glyphicon-send"
															aria-hidden="true"></span>
													</button>
													</span>
											</div>
										</div>
									</div>

									<br>
									<div class="row">
										<div class="col-sm-12">
											<div class="input-group">
												<input type="text" class="form-control" id="message"
													placeHolder="Enter a message..."> <span
													class="input-group-btn">
													<button class="btn btn-primary" id="enter"
														onClick="sendMessage()" type="button">
														Send <span class="glyphicon glyphicon-send"
															aria-hidden="true"></span>
													</button>
												</span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<script src="../js/jquery.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

	<script>
		$(document).ready(function() {
			$("#message").keyup(function(event) {
				if (event.keyCode == 13) {
					$("#enter").click();
					var field = document.getElementById('message');
					field.value = field.defaultValue;
				}
			});
		});
	</script>

	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
	</script>
	<script>
		$(function() {

			$('[data-toggle]')
					.on(
							'click',
							function() {
								var id = $(this).data("toggle"), $object = $(id), className = "open";

								if ($object) {
									if ($object.hasClass(className)) {
										$object.removeClass(className)
										$(this).text("Toggle: show");
									} else {
										$object.addClass(className)
										$(this).text("Toggle: hide");
									}
								}
							});
		});
	</script>
</body>

</html>

