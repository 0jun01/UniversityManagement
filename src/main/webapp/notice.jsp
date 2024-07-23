<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<<<<<<< HEAD


<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/notice.css">
</head>
<body>

	<div class="d-flex">
=======
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/notice.css">
</head>
<body>

<div class="d-flex justify-content-center align-items-start" style="min-width: 100em;">
>>>>>>> 325551c6e4f13bf6cada3ea7292eb0e666527dbd
		<div class="sub-menu">
			<div class="sub-menu-top">
				<h3>학사 정보</h3>
			</div>
			<table class="sub-menu-middle" border="1">
				<tbody>
					<tr>
						<td><a href="/notice" class="menu">공지사항</a></td>
					</tr>
					<tr>
						<td><a href="/schedule" class="menu">학사일정</a></td>
					</tr>
				</tbody>
			</table>
		</div>

<<<<<<< HEAD
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
								<label for="search" class="blind">공지사항 내용 검색</label> <input id="search" type="search" name="" placeholder="검색어를 입력해주세요." value="">
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
								<th scope="col" class="th-title">제목</th>
								<th scope="col" class="th-date">등록일</th>
							</tr>
						</thead>
						<tbody>

							<tr>
								<td>6</td>
								<th><a href="#!">[일반] 2024년도 1학기 휴학신청 안내</a>
									<p>테스트</p></th>
								<td>2024-06-22 09:50:30</td>
							</tr>

							<tr>
								<td>5</td>
								<th><a href="#!">[일반] 2024년도 1학기 휴학신청 안내</a>
									<p>테스트</p></th>
								<td>2024-06-22 09:50:30</td>
							</tr>

							<tr>
								<td>4</td>
								<th><a href="#!">[일반] 2024년도 1학기 휴학신청 안내</a>
									<p>테스트</p></th>
								<td>2024-06-22 09:50:30</td>
							</tr>

							<tr>
								<td>3</td>
								<th><a href="#!">[일반] 2024년도 1학기 휴학신청 안내</a>
									<p>테스트</p></th>
								<td>2024-06-22 09:50:30</td>
							</tr>

							<tr>
								<td>2</td>
								<th><a href="#!">[일반] 2024년도 1학기 휴학신청 안내</a>
									<p>테스트</p></th>
								<td>2024-06-22 09:50:30</td>
							</tr>

							<tr>
								<td>1</td>
								<th><a href="#!">[일반] 2024년도 1학기 휴학신청 안내</a>
									<p>테스트</p></th>
								<td>2024-06-22 09:50:30</td>
							</tr>

						</tbody>
					</table>
				</div>
			</div>


		</section>
	</div>

	<c:choose>
		<c:when test="${principal.userRole.equals(\"professor\")}">
			<h1>-- 교직원 접속 시 --</h1>
			<div class="d-flex">
				<div class="sub-menu">
					<div class="sub-menu-top">
						<h3>학사 정보</h3>
					</div>
					<table class="sub-menu-middle" border="1">
						<tbody>
							<tr>
								<td><a href="/notice" class="menu">공지사항</a></td>
							</tr>
							<tr>
								<td><a href="/schedule" class="menu">학사일정</a></td>
							</tr>
							<tr>
								<td><a href="/scheduleUpdate" class="menu">학사일정 등록</a></td>
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
										<th scope="col" class="th-title">제목</th>
										<th scope="col" class="th-date">등록일</th>
									</tr>
								</thead>
								<tbody>



									<tr>
										<td>5</td>
										<th><a href="#!">[일반] 2024년도 1학기 휴학신청 안내</a>
											<p>테스트</p></th>
										<td>2024-06-22 09:50:30</td>
									</tr>

									<tr>
										<td>4</td>
										<th><a href="#!">[일반] 2024년도 1학기 휴학신청 안내</a>
											<p>테스트</p></th>
										<td>2024-06-22 09:50:30</td>
									</tr>

									<tr>
										<td>3</td>
										<th><a href="#!">[일반] 2024년도 1학기 휴학신청 안내</a>
											<p>테스트</p></th>
										<td>2024-06-22 09:50:30</td>
									</tr>

									<tr>
										<td>2</td>
										<th><a href="#!">[일반] 2024년도 1학기 휴학신청 안내</a>
											<p>테스트</p></th>
										<td>2024-06-22 09:50:30</td>
									</tr>

									<tr>
										<td>1</td>
										<th><a href="#!">[일반] 2024년도 1학기 휴학신청 안내</a>
											<p>테스트</p></th>
										<td>2024-06-22 09:50:30</td>
									</tr>

								</tbody>
							</table>
						</div>
					</div>


				</section>
			</div>
		</c:when>
	</c:choose>
=======
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
						<label for="search" class="blind">공지사항 내용 검색</label> <input id="search" type="search" name="" placeholder="검색어를 입력해주세요." value="">
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
							<th scope="col" class="th-title">제목</th>
							<th scope="col" class="th-date">등록일</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>5</td>
							<th><a href="#!">[일반] 2024년도 1학기 휴학신청 안내</a>
								<p>테스트</p></th>
							<td>2024-06-22 09:50:30</td>
						</tr>

						<tr>
							<td>4</td>
							<th><a href="#!">[일반] 2024년도 1학기 휴학신청 안내</a>
								<p>테스트</p></th>
							<td>2024-06-22 09:50:30</td>
						</tr>

						<tr>
							<td>3</td>
							<th><a href="#!">[일반] 2024년도 1학기 휴학신청 안내</a>
								<p>테스트</p></th>
							<td>2024-06-22 09:50:30</td>
						</tr>
						
							<tr>
							<td>2</td>
							<th><a href="#!">[일반] 2024년도 1학기 휴학신청 안내</a>
								<p>테스트</p></th>
							<td>2024-06-22 09:50:30</td>
						</tr>
						
							<tr>
							<td>1</td>
							<th><a href="#!">[일반] 2024년도 1학기 휴학신청 안내</a>
								<p>테스트</p></th>
							<td>2024-06-22 09:50:30</td>
						</tr>
						
					</tbody>
				</table>
			</div>
		</div>

	</section>
>>>>>>> 325551c6e4f13bf6cada3ea7292eb0e666527dbd
</body>
</html>
