

<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/login.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	background-color: #f4f4f4;
	font-family: 'Noto Sans KR', sans-serif;
}

.login--div {
	height: 600px;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

.logo {
	width: 400px;
	height: 225px;
}

.main--container {
	width: 400px;
	padding-top: 15px;
}

.login--container {
	border: 1px solid #e8e6e6;
	border-radius: 10px;
	margin-top: 20px;
	padding: 0 10px;
	font-size: 15px;
	background-color: #fff;
}

.id--container {
	border-bottom: 1px solid #e8e6e6;
	background-color: #fff;
	display: flex;
	align-items: center;
}

.pwd--container {
	display: flex;
	align-items: center;
	background-color: #fff;
}

label {
	background-color: #fff;
	margin: 0 0 0 3px;
	padding-top: 3px;
}

.login--id {
	display: flex;
	align-items: center;
	height: 20px;
	margin-top: 20px;
	margin-bottom: 20px;
	background-color: #fff;
}

.login--pwd {
	height: 20px;
	display: flex;
	align-items: center;
	margin-top: 20px;
	margin-bottom: 20px;
	background-color: #fff;
}

.checkbox--id {
	background-color: #fff;
	font-size: 12px;
	display: flex;
	align-items: center;
}

#userId, #password {
	border: hidden;
	background-color: #fff;
	margin-left: 5px;
	padding: 1px 3px;
}

#userId {
	margin-right: 70px;
}

#input--submit {
	height: 50px;
	width: 400px;
	border: 1px solid #e8e6e6;
	border-radius: 10px;
	margin-top: 40px;
	background-color: #32c182;
	color: white;
	margin-top: 40px;
}

#input--submit:hover {
	background-color: #6E6AE6;
	transition: background-color 0.3s ease-in-out;
}

.login--info {
	display: flex;
	flex-direction: row;
	justify-content: center;
	font-size: 15px;
	margin-top: 20px;
}

.login--info li {
	margin-right: 20px;
	list-style: none;
}

.login--info li a {
	text-decoration: none;
	color: black;
}

input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
	-webkit-appearance: none;
	margin: 0;
}

input[type=number] {
	-moz-appearance: textfield;
}
</style>
</head>
<body>
<<<<<<< HEAD

	<div class="login--div">
		<div class="main--logo">
			<a href="#"><img class="logo" alt="" src="resources/img/logo.png"></a>
		</div>

		<form action="/login" method="post" class="main--container">
			<div class="login--container">
				<div class="id--container">
					<div class="login--id">
						<label for="userId"></label> <input type="number" max="2147483647" name="id" id="userId" placeholder="아이디를 입력하세요" required>


					</div>
				</div>
				<div class="pwd--container">
					<div class="login--pwd">
						<label for="password"></label> <input type="password" name="password" id="password" placeholder="비밀번호를 입력하세요" required>
					</div>

				</div>
			</div>
			<div>
				<input type="submit" value="로그인" id="input--submit">
			</div>
			<ul class="login--info">
				<li><a href="/find/id" onclick="window.open(this.href, '_blank', 'width=500, height=300'); return false;"> ID 찾기 </a></li>
				<li><a href="/find/password" onclick="window.open(this.href, '_blank', 'width=500, height=350'); return false;"> 비밀번호 찾기 </a></li>
			</ul>
		</form>
	</div>

=======
	
<div class="container">
	<h2> 로그인</h2>

	<form action="${pageContext.request.contextPath}/user/signIn" method="post">
		<div>
		<label for="username">사용자 이름:</label>
		<input type="text" id="username" name="username" value="2023000001">
		<label for="password">비밀번호:</label>
		<input type="password" id="password" name="password" value="0000">
		<button type="submit">로그인</button>
	</div>
	</form>



</div>


	
>>>>>>> ebdbf330f5c3c8e759771b450707cde9ae3e9a06
</body>
</html>