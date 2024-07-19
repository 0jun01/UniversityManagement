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
					<tr>
					<tr>
						<td>
							<a href="/break/send">휴학 신청</a>
						</td>
					</tr>
					<tr>
					<tr>
						<td>
							<a href="/break/list">휴학 내역 조회</a>
						</td>
					</tr>
					<tr>
						<td>
							<a href="/tuition/list">등록금 내역 조회</a>
						</td>
					</tr>
					<tr>
						<td>
							<a href="/tuition/payment">등록금 납부 고지서</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<h1>내 정보 조회</h1>
	<div class="line"></div>
	<table class="idtable">
		<colgroup>
			<col class="col1">
			<col class="col2">
			<col class="col3">
			<col class="col4">
		</colgroup>
		<tbody>
			<tr>
				<th>학번</th>
				<td>test123</td>
				<th>소속</th>
				<td>testAD</td>
			</tr>
			<tr>
				<th>학년</th>
				<td>testgrade</td>
				<th>학기</th>
				<td>testDurate</td>
			</tr>
			<tr>
				<th>입학일</th>
				<td>testDate</td>
				<th>졸업일</th>
				<td>testgraduate</td>
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