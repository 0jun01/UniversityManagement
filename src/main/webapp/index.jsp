<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
=======
>>>>>>> 2da229930aa0eb27fd9ffc52b6bba3383cccf211
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login.css">


</head>
<body>

	<div class="container">
<<<<<<< HEAD
		<h2>로그인</h2>

		<form action="${pageContext.request.contextPath}/user/signIn" method="post">
			<div>
				<label for="username">사용자 이름:</label>
				<input type="text" id="username" name="username" value="${cookie.id.value}"> 
				<label for="password">비밀번호:</label> 
				<input type="password" id="password" name="password" value="0000">
				<button type="submit">로그인</button>
				<input type="checkbox" id="checkbox" name="checkbox">ID 저장

			</div>
		</form>



	</div>



=======
		<div class="login--div">
			<div class="main--logo">
				<a href="#"><img class="logo" alt=""
					src="resources/img/logo.png"></a>
			</div>

			<form action="${pageContext.request.contextPath}/user/signIn"
				method="post" class="main--container">
				<div class="login--container">
					<div class="id--container">
						<div class="login--id">
							<label for="username"></label> 
							<input type="number"
								max="2147483647" name="username" id="username"
								value="2023000001" placeholder="아이디를 입력하세요" required>


						</div>
					</div>
					<div class="pwd--container">
						<div class="login--pwd">
							<label for="password"></label> <input type="password"
								name="password" id="password" value="0000"
								placeholder="비밀번호를 입력하세요" required>
						</div>

					</div>
				</div>
				<div>
					<input type="submit" value="로그인" id="input--submit">
				</div>
				<ul class="login--info">
					<li><a href="/find/id"
						onclick="window.open(this.href, '_blank', 'width=500, height=300'); return false;">
							ID 찾기 </a></li>
					<li><a href="/find/password"
						onclick="window.open(this.href, '_blank', 'width=500, height=350'); return false;">
							비밀번호 찾기 </a></li>
				</ul>
			</form>
		</div>
	</div>


>>>>>>> 2da229930aa0eb27fd9ffc52b6bba3383cccf211
</body>
</html>