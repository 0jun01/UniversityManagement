<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/studentInfo.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/subjectList.css">

<div class="registration_box" style="min-width: 100em">

	<div class="sub_menu">
		<%@ include file="/WEB-INF/views/subMenu/subMenuMY.jsp"%>
	</div>

	<main>
		<h1>내 정보 조회</h1>
		<div id="student-info-container">
			<table class="idtable">
				<colgroup>
					<col class="col1">
					<col class="col2">
				 	<col class="col3">
					<col class="col4">
				</colgroup>
				<tbody>
					<tr>
						<th>학번</th>
						<td>${principal.id}</td>
						<th>소속</th>
						<td>${studentInfo.college}${studentInfo.department}</td>
					</tr>
					<tr>
						<th>학년</th>
						<td>${studentInfo.grade}</td>
						<th>학기</th>
						<td>${studentInfo.semester}</td>
					</tr>
					<tr>
						<th>입학일</th>
						<td>${studentInfo.entranceDate}</td>
						<th>졸업일</th>
						<td>${studentInfo.graduationDate}</td>
					</tr>
				</tbody>
			</table>
			<table class="infotable">
				<colgroup>
					<col class="col1">
					<col class="col2">
					<col class="col3">
					<col class="col4">
				</colgroup>
				<tbody>
					<tr>
						<th>이름</th>
						<td>${studentInfo.name}</td>
						<th>생년월일</th>
						<td>${studentInfo.birthDate}</td>
					</tr>
					<tr>
						<th>성별</th>
						<td>${studentInfo.gender}</td>
						<th>주소</th>
						<td>${studentInfo.address}</td>
					</tr>
					<tr>
						<th>연락처</th>
						<td>${studentInfo.tel}</td>
						<th>email</th>
						<td>${studentInfo.email}</td>
					</tr>
				</tbody>
			</table>
		<form action="${pageContext.request.contextPath}/info/changeStudentInfo" method="GET">
		<button type="submit">수정하기</button>
		</form>
		</div>
	</main>
</div>
</body>
</html>