<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
	<h2>비밀번호 변경 </h2>

	<form action="${pageContext.request.contextPath}/info/staffPassword" method="post">
		<div>
		<label for="current_password">현재 비밀번호:</label>
		<input type="text" id="current_password" name="current_password" value="0000">
		<label for="change_password">변경할 비밀번호:</label>
		<input type="password" id="change_password" name="change_password">
		<button type="submit">변경하기</button>
	</div>
	</form>



</div>

</body>
</html>