<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/subjectList.css">
</head>
<body>
	<div class="registration_box" style="min-width: 100em">
		<!-- 세부 메뉴 div -->
		<div class="sub_menu">
			<%@ include file="/WEB-INF/views/subMenu/sugangMenu.jsp"%>
		</div>
		<!-- 메인 div -->
		<main>
			<div>
				<h1>신청 미완료 강의 목록</h1>
				<table border="1">
					<thead>
						<tr>
							<th>학수번호</th>
							<th>강의명</th>
							<th>담당교수</th>
							<th>학점</th>
							<th style="width: 200px">요일시간 (강의실)</th>
							<th>현재인원</th>
							<th>정원</th>
							<th>수강신청</th>
						</tr>
					</thead>
					<tbody>

						<c:choose>
							<c:when test="${empty selectedLect}">
								<h1>예비신청한 내역이 없습니다</h1>
							</c:when>
							<c:otherwise>
								<c:forEach var="selectedLect" items="${selectedLect}">
									<tr>
										<td>${selectedLect.haksuNum}</td>
										<td>${selectedLect.lectureName}</td>
										<td>${selectedLect.professorName}</td>
										<td>${selectedLect.grades}</td>
										<td>${selectedLect.subDay}${selectedLect.startTime}:00-
											${selectedLect.endTime}:00 (${selectedLect.roomId})</td>
										<td>${selectedLect.numOfStudent}</td>
										<td>${selectedLect.capacity}</td>
										<td><c:choose>
												<c:when
													test="${selectedLect.numOfStudent >= selectedLect.capacity}">
													<button type="button" onclick="alert('인원이 가득 찼습니다.')">신청
														불가</button>
												</c:when>
												<c:when test="${sumOfGrades >= 17}">
													<button type="button" onclick= "alert('수강 가능한 최대 학점이 넘었습니다.')">신청</button>
												</c:when>
												<c:otherwise>
													<form
														action="${pageContext.request.contextPath}/sugang/addSugang"
														method="POST">
														<button type="submit" name="selectedList"
															value="${selectedLect.haksuNum}"
															onclick="return confirm('수강을 신청하겠습니까?');">신청</button>
														<input type="hidden" name="principal"
															value="${principal.id}">
													</form>
												</c:otherwise>
											</c:choose></td>
									</tr> 
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
				<div>
					<h1>신청 내역</h1>
					<span>[총 ${sumOfGrades}학점]</span>
					<table border="1">
						<thead>
							<tr>
								<th>학수번호</th>
								<th>강의명</th>
								<th>담당교수</th>
								<th>학점</th>
								<th style="width: 200px">요일시간 (강의실)</th>
								<th>현재인원</th>
								<th>정원</th>
								<th>수강신청</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${empty selectedRealLect}">
									<h1>신청 내역이 없습니다</h1>
								</c:when>
								<c:otherwise>
									<c:forEach var="selectedRealLect" items="${selectedRealLect}">
										<tr>
											<td>${selectedRealLect.haksuNum}</td>
											<td>${selectedRealLect.lectureName}</td>
											<td>${selectedRealLect.professorName}</td>
											<td>${selectedRealLect.grades}</td>
											<td>${selectedRealLect.subDay}${selectedRealLect.startTime}:00-
												${selectedRealLect.endTime}:00 (${selectedRealLect.roomId})</td>
											<td>${selectedRealLect.numOfStudent}</td>
											<td>${selectedRealLect.capacity}</td>
											<td>
												<form
													action="${pageContext.request.contextPath}/sugang/cansleSugang"
													method="POST">
													<button type="submit" name="cansleSugang"
														onclick="return confirm('수강을 취소 하시겠습니까?');">취소</button>
													<input type="hidden" name="principal"
														value="${principal.id}"> <input type="hidden"
														name="haksuNum" value="${selectedRealLect.haksuNum}">
												</form>
											</td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>
			</div>
		</main>
	</div>
</body>
</html>