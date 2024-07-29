<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/subjectList.css">

<div class="registration_box" style="min-width: 100em">

	<div class="sub_menu">
		<%@ include file="/WEB-INF/views/subMenu/subMenuMY.jsp"%>
	</div>
	<main>
		<h2>비밀번호 변경</h2>
		<div>
			<form action="${pageContext.request.contextPath}/info/studentPassword" method="post">
				<div class="form-group">
					<label for="current_password">현재 비밀번호:</label> <input type="text" id="current_password" name="current_password" value="0000">
				</div>
				<div class="form-group">
					<label for="change_password">변경할 비밀번호:</label> <input type="password" id="change_password" name="change_password" value="0001">
				</div>
				<button type="submit">변경하기</button>
			</form>
		</div>
	</main>
</div>
</body>
</html>
