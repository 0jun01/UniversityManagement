<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">


</head>
<body>
<<<<<<< HEAD
=======

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
>>>>>>> 325551c6e4f13bf6cada3ea7292eb0e666527dbd

	<div class="login--div">
		<div class="main--logo">
			<a href="#"><img class="logo" alt="" src="resources/img/logo.png"></a>
		</div>

		<form action="${pageContext.request.contextPath}/user/signIn"  method="post"  class="main--container">
			<div class="login--container">
				<div class="id--container">
					<div class="login--id">
						<label for="username"></label> 
						<input type="number" max="2147483647" name="username" id="username" value="2023000001" placeholder="아이디를 입력하세요" required>


					</div>
				</div>
				<div class="pwd--container">
					<div class="login--pwd">
						<label for="password"></label> 
						<input type="password" name="password" id="password"  value="0000" placeholder="비밀번호를 입력하세요" required>
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





<<<<<<< HEAD
=======
	
>>>>>>> ebdbf330f5c3c8e759771b450707cde9ae3e9a06
>>>>>>> 325551c6e4f13bf6cada3ea7292eb0e666527dbd
</body>
</html>