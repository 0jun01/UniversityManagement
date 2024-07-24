<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="alltable">
	<div class="sub-bar">
		<div class="sub-bar-top">
			<table class="sub-bar-list" border="1">
				<tbody>
					<tr>
						<td><a href="${pageContext.request.contextPath}/info/student" class="seleted-menu">내 정보 조회</a></td>
					</tr>
					<tr>
						<td><a href="${pageContext.request.contextPath}/info/studentPassword">비밀번호 변경</a></td>
					</tr>
					<tr>
						<tr>
						<td><a href="${pageContext.request.contextPath}/break/send">휴학 신청</a>
						</td>
					</tr>
					<tr>
					
					<tr>
						<td>
							<a href="${pageContext.request.contextPath}/break/list">휴학 내역 조회</a>
						</td>
					</tr>
					<tr>
						<td>
							<a href="${pageContext.request.contextPath}/tuition/list">등록금 내역 조회</a>
						</td>
					</tr>
					<tr>
						<td>
							<a href="${pageContext.request.contextPath}/tuition/payment">등록금 납부 고지서</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>