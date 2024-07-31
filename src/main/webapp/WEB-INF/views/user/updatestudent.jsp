<%@page import="com.uni.system.repository.model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<table class="idtable" border="1">
		<colgroup>
			<col class="col1">
			<col class="col2">
			<col class="col3">
			<col class="col4">
		</colgroup>
	</table>
	<form action="${pageContext.request.contextPath}/info/updatestudent"
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
						value="${studentInfo.address}"></td>

					<td><label for="tel">전화번호</label></td>
					<td><input type="text" id="tel" name="tel"
						value="${studentInfo.tel}"></td>
				</tr>
				<tr>
					<td><label for="email">이메일</label></td>
					<td><input type="text" id="email" name="email"
						value="${studentInfo.email}"></td>
					<td><label for="password">비밀번호 확인</label></td>
					<td><input type="password" id="password" name="password"></td>
				</tr>
			</tbody>
		</table>
		<button type="submit">수정하기</button>
	</form>
</div>
<%-- <%@ include file="/WEB-INF/views/layout/footer.jsp"%> --%>



</body>
</html>