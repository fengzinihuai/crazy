<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>用户登录</title>
</head>
<!-- CSS件 -->
<body>
	<div class="container">
		<form class="form-signin" action="/login" method="post">
			<h2 class="form-signin-heading">Please sign in</h2>
			<div>${errormsg}</div>
			<input type="text" class="form-control" placeholder="Email address" required autofocus name="email" > 
			<input type="password" class="form-control" placeholder="Password" required name="password" > 
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		</form>
	</div>

	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="/js/bootstrap.min.js"></script>
</body>
</html>