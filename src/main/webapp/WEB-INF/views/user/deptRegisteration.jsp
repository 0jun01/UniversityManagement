<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/subjectList.css">
<body>
	<div class="registration_box" style="min-width: 100em">
		<div class="sub_menu">
			<%@ include file="/WEB-INF/views/subMenu/registrationMenu.jsp"%>
		</div>
		<main>
			<h1>학과</h1>
			<div>
				<a href="${pageContext.request.contextPath}/admin/collegeUpdate">수정</a>
				<a href="${pageContext.request.contextPath}/admin/deptDelete">삭제</a>
				<br>
			</div>
			<div>
				<form action="${pageContext.request.contextPath}/admin/addFilter"
					method="POST">
					<h1>등록하기</h1>
					<!-- 강의구분 콤보박스 -->
					<!-- 대상학과 콤보박스 -->
					<label for="deptId">개설학과</label> <select name="deptId" id="deptId">
						<option value="-1">선택</option>
						<c:forEach var="collegeList" items="${collegeList}">
							<option value="${collegeList.id}">${collegeList.name}</option>
						</c:forEach>
					</select>
					<!-- TODO DB 개설학과 가져오기 -->
					<!-- 강의 검색 -->
					<input type="text" name="subName" list="subName"
						placeholder="학과를 입력해주세요">
					<button type="submit">입력</button>
					<c:if test="${not empty message}">
						<script type="text/javascript">
							alert("${message}");
						</script>
					</c:if>
				</form>
			</div>
			<div>
				<table border="1">
					<thead>
						<tr>
							<th>ID</th>
							<th>학과명</th>
							<th>단과대ID</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="dept" items="${dept}">
							<tr>
								<td>${dept.id}</td>
								<td>${dept.name}</td>
								<td>${dept.collegeId}</td>
							</tr>

						</c:forEach>

					</tbody>
				</table>
			</div>


		</main>
	</div>

</body>
</html>