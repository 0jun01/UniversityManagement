<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main>
		<h1>비밀번호 변경</h1>
		<div class="split--div"></div>
		<form action="${pageContext.request.contextPath}/info/professorPassword" method="post" class="form--container">
			<input type="hidden" name="_method" value="put">
			<table class="table--container">
				<tbody>

					<tr>
						<td><label for="beforePW">현재 비밀번호</label></td>
						<td><input type="password" name="current_password" class="input--box"
							id="beforePW"></td>
					</tr>

					<tr>
						<td><label for="afterPW">변경할 비밀번호</label></td>
						<td><input type="password" name="change_password" class="input--box"
							id="afterPW"></td>
					</tr>

				</tbody>
			</table>

			<br> <input type="submit" value="수정하기"
				class="btn btn-green update--button">

		</form>

	</main>



</body>
</html>