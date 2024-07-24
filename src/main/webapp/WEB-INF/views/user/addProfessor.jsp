<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ include file="/WEB-INF/views/subMenu/staffManagement.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<main>
		<h1>교수 등록</h1>
		<div class="split--div"></div>
		<form action="${pageContext.request.contextPath}/management/addProfessor" method="post">
			<table class="table--container">
				<tr>
					<td><label for="name">이름</label></td>
					<td><input type="text" name="name" id="name" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="birthDate">생년월일</label></td>
					<td><input type="date" name="birthDate" id="birthDate" class="input--box"></td>
				</tr>
				<tr>
					<td style="padding-top: 7px">
					<label>성별</label></td>
					<td style="padding-top: 7px">
					<label for="male">남성</label> 
					<input type="radio" value="남성" name="gender" id="male" checked="checked">
					<label for="female">여성</label> 
					<input type="radio" value="여성" name="gender" id="female">
					</td>
				</tr>
				<tr>
					<td><label for="address">주소</label></td>
					<td><input type="text" name="address" id="address" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="tel">전화번호</label></td>
					<td><input type="text" name="tel" id="tel" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="email">이메일</label></td>
					<td><input type="text" name="email" id="email" class="input--box"></td>
				</tr>
				<tr>
					<td><label for="deptId">과 ID</label></td>
					<td><input type="text" name="deptId" id="deptId" class="input--box"></td>
				</tr>
			
			</table>
				<div class="button--container">
					<input type="submit" value="입력">
				</div>
		</form>
	</main>


</body>
</html>