<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

</head>
<body>

	<div class="d-flex">
		<div class="sub-menu">
			<div class="sub-menu-top">
				<h3>학사 정보</h3>
			</div>
			<table class="sub-menu-middle" border="1">
				<tbody>
					<tr>
						<td><a href="${pageContext.request.contextPath}/notice/notice" class="menu">공지사항</a></td>
					</tr>
					<tr>
						<td><a href="${pageContext.request.contextPath}/schedule/schedule" class="menu">학사일정</a></td>
					</tr>
				</tbody>
			</table>
		</div>

		<section class="notice">
			<div class="page-title">
				<div class="container">
					<h3>공지사항</h3>
				</div>
			</div>

			<div id="board-search">
				<div class="container">
					<div class="search-window">
						<form action="">
							<div class="search-wrap">
								<label for="search" class="blind">공지사항 내용 검색</label> <input id="search" type="search" name="search" placeholder="검색어를 입력해주세요." value="">
								<button type="submit" class="btn btn-color">검색</button>
							</div>
						</form>
					</div>
				</div>
			</div>

			<!-- board list area -->
			<div id="board-list">
				<div class="container">
					<table class="board-table">
						<thead>
							<tr>
								<th scope="col" class="th-num">번호</th>
								<th scope="col" class="th-category">말머리</th>
								<th scope="col" class="th-title">제목</th>
								<th scope="col" class="th-date">등록일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${noticelist}" var="notice">
								<tr>
									<td>${notice.id}</td>
									<td>${notice.category}</td>
									<td><a href="#!">${notice.title}</a></td>
									<td>${notice.createdTime}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</section>
	</div>

<form action="${pageContext.request.contextPath}/notice/register" method="get">
		<button type="submit">등록</button>
	<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
</body>
</html>