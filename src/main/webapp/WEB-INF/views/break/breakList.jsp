<%@page import="java.util.List"%>
<%@page import="com.uni.system.repository.model.BreakApp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ include file="/WEB-INF/views/subMenu/subMenuMY.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>여기는 휴학 신청서를 보는 JSP입니다</h2>
<h1>휴학 내역 조회</h1>
<div class="split--div"></div>
<table border="1" class="list--table">
	<tbody>
		<c:if test="${empty requestScope.breakAppList}">
			<div>님 휴학 신청을 안했어용</div>
		</c:if>

		<c:if test="${not empty requestScope.breakAppList}">
			<thead>
				<tr>
					<th>신청일자</th>
					<th>구분</th>
					<th>시작학기</th>
					<th>종료학기</th>
					<th>신청서 확인</th>
					<th>상태</th>
				</tr>
			</thead>
			<c:forEach var="breakApp" items="${requestScope.breakAppList}">
				<tr>
					<td>${breakApp.appDate}</td>
					<td>${breakApp.type}</td>
					<td>${breakApp.fromYear}년도${breakApp.fromSemester}학기</td>
					<td>${breakApp.toYear}년도${breakApp.toSemester}학기</td>
					<td><a href="/break/detail/${breakApp.id}">Click</a></td>
					<td><span style="color: #767676; font-weight: 600">${breakApp.status}</span></td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
</body>
</html>