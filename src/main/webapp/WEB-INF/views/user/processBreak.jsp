<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/subject.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/subjectList.css">
<div class="registration_box" style="min-width: 100em">
	<!-- 세부 메뉴 div -->
	<div class="sub_menu">
		<%@ include file="/WEB-INF/views/subMenu/staffManagement.jsp"%>
	</div>
	<!-- 메인 div -->
	<main>
		<h1>휴학 신청 목록</h1>
		<div class="split--div">
			<table border="1" class="sub--list--table">
				<thead>
					<tr>
						<th>신청일자</th>
						<th>신청자 학번</th>
						<th>구분</th>
						<th>시작학기</th>
						<th>종료학기</th>
						<th>신청서 확인</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="breakList" items="${breakList}">
						<tr>
							<td>${breakList.appDate}</td>
							<td>${breakList.studentId}</td>
							<c:choose>
								<c:when test="${breakList.type eq 'normal'}">
									<td>일반 휴학</td>
								</c:when>
								<c:when test="${breakList.type eq 'pregnant'}">
									<td>임신·출산·육아휴학</td>
								</c:when>
								<c:when test="${breakList.type eq 'disease'}">
									<td>질병휴학</td>
								</c:when>
								<c:when test="${breakList.type eq 'founded'}">
									<td>창업휴학</td>
								</c:when>
								<c:when test="${breakList.type eq 'army'}">
									<td>군입대휴학</td>
								</c:when>
							</c:choose>
							
							<td>${breakList.fromSemester}학기</td>
							<td>${breakList.toSemester}학기</td>
							<form action="${pageContext.request.contextPath}/management/processBreak" method="post">
								<td><button type="submit" name="clickButton" value="${breakList.studentId}">휴학 처리</button></td>
							</form>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="pagination">
				<c:forEach begin="1" end="${totalPages}" var="i">
					<c:choose>
						<c:when test="${i == currentPage}">
							<span class="current-page">${i}</span>
						</c:when>
						<c:otherwise>
							<span><a
								href="${pageContext.request.contextPath}/management/breakList?page=${i}">${i}</a></span>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
		</div>
	</main>
</div>
</body>
</html>