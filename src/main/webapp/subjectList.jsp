<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<!-- 세부 메뉴 + 메인 -->
<div class="registration_box" style="min-width: 100em">

	<!-- 세부 메뉴 div -->
	<div class="sub_menu">
		<div class="sub_menu_top">
			<h2>수강신청</h2>
		</div>
		<!-- 메뉴 -->
		<!-- 선택된 메뉴 -->
		<div class="sub_menu_mid">
		<table class="sub_menu_table" border="1">
			<tbody>
				<tr>
					<td>
						<a href="/sugang/subjectList">강의 시간표 조회</a>
					</td>
				</tr>
				<tr>
					<td>
					<a href="/sugang/pre">예비 수강 신청</a>
					</td>
				</tr>
				<tr>
					<td>
					<a href="/sugang/preAppList">수강 신청</a>
					</td>
				</tr>
				<tr>
					<td>
					<a href="/sugang/List">수강 신청 내역 조회</a>
					</td>
				</tr>
			</tbody>
		</table>
		</div>
		<!-- 메인 div -->
		<main>
			<h1>강의 시간표 조회</h1>
			<div class="sub_filter">
				<form action="/sugang/subjectList/search" method="GET">
				<!-- 강의구분 콤보박스 -->
				<label for="type">강의구분</label>
				<select name="type" id="type">
					<option value="전체">전체</option>
					<option value="전공">전공</option>
					<option value="교양">교양</option>
				</select>
				<!-- 대상혁과 콤보박스 -->
				<label for="deptId">개설학과</label>
				<select name="deptId" id="deptId">
					<!-- TODO DB 개설학과 가져오기 -->
				</select>
				<!-- 강의 검색 -->
				<label for="subName">강의명</label>
				<input type="text" name="name" list="subName">
				<datalist id="subName"></datalist>
				<button type="submit">조회</button>
				</form>
			</div>
		</main>
	</div>
</div>
</body>
</html>