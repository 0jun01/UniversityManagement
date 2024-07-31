<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/subMenu.css">
</head>
<body>
		<div class="sub_menu_top">
			<h2>MY</h2>
			</div>
			<div class="sub_menu_mid">
				<table class="sub_menu_table" border="1">
					<tbody>
						<tr>
							<td><a href="${pageContext.request.contextPath}/info/student" class="seleted-menu">내 정보 조회</a></td>
						</tr>
						<tr>
							<td><a href="${pageContext.request.contextPath}/info/studentPassword">비밀번호 변경</a></td>
						</tr>
						<tr>
						<tr>
							<td><a href="${pageContext.request.contextPath}/break/send">휴학 신청</a></td>
						</tr>
						<tr>
						<tr>
							<td><a href="${pageContext.request.contextPath}/break/list">휴학 내역 조회</a></td>
						</tr>
						<tr>
							<td><a href="${pageContext.request.contextPath}/tuition/list">등록금 내역 조회</a></td>
						</tr>
						<tr>
							<td><a href="${pageContext.request.contextPath}/tuition/payment">등록금 납부 고지서</a></td>
						</tr>
					</tbody>
				</table>
			</div>
</body>
</html>