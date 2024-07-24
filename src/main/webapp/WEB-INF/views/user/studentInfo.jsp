<%@page import="com.uni.system.repository.model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ include file="/WEB-INF/views/subMenu/subMenuMY.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
request.getAttribute("principal");
session.getAttribute("studentInfo");

%>
	<h1>내 정보 조회</h1>
	<div class="line">
	<table class="idtable" border = "1">
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
				<td>${studentInfo.college} ${studentInfo.department}</td>
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
		<%-- <c:if test="${board.userId == userId }">
			<a class= "btn btn-edit" href="#">수정</a>
			<a class= "btn btn-delete" href="#">삭제</a>
			</c:if> --%>
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
	<button type="button">수정하기</button>
	</div>
	
</body>
</html>