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
						<td>
						<a href="${pageContext.request.contextPath}/management/studentList" class="seleted-menu">학생 명단 조회</a>
						</td>
					</tr>
					<tr>
						<td><a href="${pageContext.request.contextPath}/management/professorList">교수 명단 조회</a></td>
					</tr>
					<tr>
						<tr>
						<td>
						<a href="${pageContext.request.contextPath}/management/addStudent">학생 등록</a>
						</td>
					</tr>
					<tr>
					<tr>
						<td>
							<a href="${pageContext.request.contextPath}/management/addProfessor">교수 등록</a>
						</td>
					</tr>
					<tr>
						<td>
							<a href="${pageContext.request.contextPath}/management/addStaff">직원 등록</a>
						</td>
					</tr>
					<tr>
						<td>
							<a href="${pageContext.request.contextPath}/management/sendtuition">등록금 고지서 발송</a>
						</td>
					</tr>
					<tr>
						<td>
							<a href="${pageContext.request.contextPath}/management/breakList">휴학 처리</a>
						</td>
					</tr>
					<tr>
						<td>
							<a href="${pageContext.request.contextPath}/management/deadline">수강 신청 기간 설정</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>