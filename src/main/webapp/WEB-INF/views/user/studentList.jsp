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
	<main>
		<h1>학생 명단 조회</h1>
		<!-- 여기에 내용 넣기 -->

		<!-- 필터 및 검색 -->
		<div class="sub_filter">
			<form action="/user/studentList" method="get">
				<div>
					<!-- 개설연도 숫자 -->
					<label for="deptId">학과 번호</label> <input type="text" name="deptId"
						id="deptId"> <label for="studentId">학번</label> <input
						type="text" name="studentId" list="studentId">
					<!-- 검색 버튼 -->
					<button type="submit">
						<ul class="d-flex justify-content-center" style="margin: 0;">
							<li style="height: 24px; margin-right: 2px;">조회
							<li style="height: 24px;"><span
								class="material-symbols-outlined"
								style="font-size: 18px; padding-top: 4px;">search</span>
						</ul>
					</button>
					<button type="button"
						onclick="location.href='/user/student/update'"
						style="margin-left: 10px;">
						<ul>
							<li style="height: 24px;">새학기 적용
						</ul>
					</button>
				</div>
			</form>
		</div>


		<h4>
			<span style="font-weight: 600;">학생 목록</span>
		</h4>
		<table border="1" class="sub--list--table">
			<thead>
				<tr>
					<th>학번</th>
					<th>이름</th>
					<th>생년월일</th>
					<th>성별</th>
					<th>주소</th>
					<th>전화번호</th>
					<th>이메일</th>
					<th>학과번호</th>
					<th>학년</th>
					<th>입학일</th>
					<th>졸업일(졸업예정일)</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="studentList" items="${studentList}">
					<tr>
						<td>${studentList.id}</td>
						<td>${studentList.name}</td>
						<td>${studentList.birthDate}</td>
						<td>${studentList.gender}</td>
						<td>${studentList.address}</td>
						<td>${studentList.tel}</td>
						<td>${studentList.email}</td>
						<td>${studentList.deptId}</td>
						<td>${studentList.grade}</td>
						<td>${studentList.entranceDate}</td>
						<td>${studentList.graduationDate}</td>
						<td>조회</td>
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
							href="${pageContext.request.contextPath}/management/studentList?page=${i}">${i}</a></span>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>


	</main>
</div>
</body>
</html>