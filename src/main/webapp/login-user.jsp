
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Login-Page</title>

<style>

/* Reset CSS */
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

/* Body */
body {
	min-height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	font-family: Arial, sans-serif;
	background: linear-gradient(135deg, #667eea, #764ba2, #f093fb);
	padding: 20px;
}

/* Login Container */
.login-container {
	width: 100%;
	max-width: 400px;
	background: rgba(255, 255, 255, 0.95);
	padding: 35px 30px;
	border-radius: 20px;
	box-shadow: 0 15px 35px rgba(0, 0, 0, 0.25);
	backdrop-filter: blur(10px);
}

/* Heading */
.login-container h2 {
	text-align: center;
	color: #4a3f8c;
	margin-bottom: 8px;
	font-size: 28px;
}

/* Subtitle */
.login-container p {
	text-align: center;
	color: #777;
	margin-bottom: 25px;
	font-size: 14px;
}

/* Labels */
label {
	display: block;
	margin-bottom: 8px;
	color: #333;
	font-size: 14px;
	font-weight: bold;
}

/* Input Fields */
input[type="email"], input[type="password"] {
	width: 100%;
	padding: 13px 15px;
	margin-bottom: 20px;
	border: 2px solid #ddd;
	border-radius: 10px;
	font-size: 15px;
	outline: none;
	transition: 0.3s;
}

/* Input Focus */
input[type="email"]:focus, input[type="password"]:focus {
	border-color: #667eea;
	box-shadow: 0 0 8px rgba(102, 126, 234, 0.4);
}

/* Login Button */
input[type="submit"] {
	width: 100%;
	padding: 14px;
	border: none;
	border-radius: 10px;
	background: linear-gradient(135deg, #667eea, #764ba2);
	color: white;
	font-size: 16px;
	font-weight: bold;
	cursor: pointer;
	transition: 0.3s;
}

/* Button Hover */
input[type="submit"]:hover {
	transform: translateY(-2px);
	box-shadow: 0 8px 15px rgba(118, 75, 162, 0.4);
}

/* Mobile Responsive */
@media ( max-width : 480px) {
	body {
		padding: 15px;
	}
	.login-container {
		padding: 28px 20px;
		border-radius: 15px;
	}
	.login-container h2 {
		font-size: 24px;
	}
	input[type="email"], input[type="password"] {
		padding: 12px;
	}
}
</style>

</head>

<body>

	<div class="login-container">

		<h2>USER LOGIN</h2>

		<p>Welcome back! Please login to your account.</p>

		<form action="loginUser" method="post">

			<label for="email">USER-NAME</label> <input type="email" id="email"
				placeholder="Enter your email" name="email" required> <label
				for="password">USER-PASSWORD</label> <input type="password"
				id="password" placeholder="Enter your password" name="password"
				required> <input type="submit" value="LOGIN">

			<!-- Register User Link -->
			<div class="register-link">

				<p>Not registered yet?</p>

				<a href="register-user.jsp"> REGISTER USER </a>

			</div>

		</form>

	</div>

</body>
</html>