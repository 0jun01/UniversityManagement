<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/myInfo.css">
</head>
<body>
<!-- SUB MENU -->
<div class="d-flex">
		<div class="sub-menu">
			<div class="sub-menu-top">
				<h3>MY</h3>
			</div>
			<table class="sub-menu-middle" border="1">
				<tbody>
					<tr>
						<td><a href="/myInfo" class="menu">내 정보 조회</a></td>
					</tr>
					<tr>
						<td><a href="/pwupdate" class="menu">비밀번호 변경</a></td>
					</tr>
				</tbody>
			</table>
		</div>

<!-- MAIN -->
<main>
<div class="split--div"></div>

<table border= "1" class="input--table">
	<colgroup>
		<col class ="col1">
		<col class ="col2">
		<col class ="col3">
		<col class ="col4">
	</colgroup>
	
<tbody>
	<tr>
		<th>ID</th>
		<td>23000001</td>
		<th>소속</th>
		<td>공과대학&nbsp;컴퓨터공학과</td>
	</tr>
</tbody>
</table>

<table border="1" class="input--table">
	<colgroup>
		<col class ="col1">
		<col class ="col2">
		<col class ="col3">
		<col class ="col4">
	</colgroup>
	
	<tbody>
	<tr>
	<th>성명</th>
	<td>김근</td>
	<th>생년월일</th>
	<td>1975-08-01</td>
	</tr>
	
	<tr>
	<th>성별</th>
	<td>남성</td>
	<th>주소</th>
	<td>부산시 부산진구 범향빌딩</td>
	</tr>
	
	<tr>
	<th>연락처</th>
	<td>010-0000-1111</td>
	<th>email</th>
	<td>tenco@green.com</td>
	</tr>
	</tbody>
</table>
 
 <!-- BUTTON  -->
<button type ="button" onclick = "location.href= '/update' " class="btn btn update--button">수정하기</button>
</main>
</div>
</body>
</html>