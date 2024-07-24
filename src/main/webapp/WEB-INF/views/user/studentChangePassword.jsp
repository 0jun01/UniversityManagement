<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ include file="/WEB-INF/views/subMenu/subMenuMY.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="container">
	<h2>비밀번호 변경 </h2>

	<form action="${pageContext.request.contextPath}/info/studentPassword" method="post">
		<div>
		<label for="current_password">현재 비밀번호:</label>
		<input type="text" id="current_password" name="current_password" value="0000">
		<label for="change_password">변경할 비밀번호:</label>
		<input type="password" id="change_password" name="change_password" value="0001">
		<button type="submit">변경하기</button>
	</div>
	</form>



</div>

</body>
</html>