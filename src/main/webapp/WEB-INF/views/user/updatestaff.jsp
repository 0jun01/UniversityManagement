<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.uni.system.repository.model.Staff"%>

<%
session.getAttribute("principal");
session.getAttribute("staffInfo");
%>
<div class="alltable">
	<div class = "sub-bar">
		<div class = "sub-bar-top">
			<table class="sub-bar-list" border="1">
				<tbody>
					<tr>
						<td>
							<a href="${pageContext.request.contextPath}/info/staff" class="seleted-menu">내 정보 조회</a>
						</td>
					</tr>
					<tr>
						<td>
							<a href="${pageContext.request.contextPath}/info/staffPassword">비밀번호 변경</a>
						</td>
					</tr>
		
				</tbody>
			</table>
		</div>
	</div>
	<h1>내 정보 조회</h1>
	<div class="main"></div>
	<table class="idtable" border="1">
		<colgroup>
			<col class="col1">
			<col class="col2">
			<col class="col3">
			<col class="col4">
		</colgroup>
		<tbody>
			<tr>
				<th>ID</th>
				<td>${principal.id}</td>
				<th>입사 날짜</th>
				<td>${staffInfo.hireDate}</td>
			</tr>
		</tbody>
	</table>
	<table class="infotable" border="1">
		<colgroup>
			<col class="col1">
			<col class="col2">
			<col class="col3">
			<col class="col4">
		</colgroup>
		<tbody>
			<tr>
				<th>이름</th>
				<td>${staffInfo.name}</td>
				<th>생년월일</th>
				<td>${staffInfo.birthDate}</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>${staffInfo.gender}</td>
				<th>주소</th>
				<td>${staffInfo.address}</td>
			</tr>
			<tr>
				<th>연락처</th>
				<td>${staffInfo.tel}</td>
				<th>email</th>
				<td>${staffInfo.email}</td>
			</tr>
		</tbody>
	</table>
	<button type="submit">수정하기</button>
</div>

<form action="${pageContext.request.contextPath}/info/updatestaff"
		method="post">
		<table class="infotable">
			<colgroup>
				<col class="col1">
				<col class="col2">
				<col class="col3">
				<col class="col4">
			</colgroup>
			<tbody>
				<tr>
					<td><label for="address">주소:</label></td>
					<td><input type="text" id="address" name="address"
						value="${staffInfo.address}"></td>

					<td><label for="tel">전화번호</label></td>
					<td><input type="text" id="tel" name="tel"
						value="${staffInfo.tel}"></td>
				</tr>
				<tr>
					<td><label for="email">이메일</label></td>
					<td><input type="text" id="email" name="email"
						value="${staffInfo.email}"></td>
					<td><label for="password">비밀번호 확인</label></td>
					<td><input type="password" id="password" name="password"></td>
				</tr>
			</tbody>
		</table>
		<button type="submit">수정하기</button>
	</form>
	
	
</body>
</html>