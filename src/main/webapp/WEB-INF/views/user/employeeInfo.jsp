<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<div class="alltable">
	<div class = "sub-bar">
		<div class = "sub-bar-top">
			<table class="sub-bar-list" border="1">
				<tbody>
					<tr>
						<td>
							<a href="/info/student" class="seleted-menu">내 정보 조회</a>
						</td>
					</tr>
					<tr>
						<td>
							<a href="/password">비밀번호 변경</a>
						</td>
					</tr>
		
				</tbody>
			</table>
		</div>
	</div>
	<h1>내 정보 조회</h1>
	<div class="main"></div>
	<table class="idtable">
		<colgroup>
			<col class="col1">
			<col class="col2">
			<col class="col3">
			<col class="col4">
		</colgroup>
		<tbody>
			<tr>
				<th>ID</th>
				<td>test123</td>
				<th>Date</th>
				<td>testDate</td>
			</tr>
		</tbody>
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
				<td>testname</td>
				<th>생년월일</th>
				<td>testBirth</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>testgender</td>
				<th>주소</th>
				<td>testaddress</td>
			</tr>
			<tr>
				<th>연락처</th>
				<td>testcontact</td>
				<th>email</th>
				<td>testemail</td>
			</tr>
		</tbody>
	</table>
	<button type="button">수정하기</button>
</div>
	
	
</body>
</html>