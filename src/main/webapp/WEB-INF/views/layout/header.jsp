<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/header.css">
</head>
<body>
	<%
	request.getAttribute("principal");
	%>
	<header>


		<nav class="header_menu">
			
			<c:choose>
				<c:when test="${principal.userRole.equals(\"student\")}">
					<div class="header_top_box">
						<ul class="header_top_info_ul">
							<li class="header_top_info_li">${principal.name}님 / id:${principal.id}</li>
							<li class="header_top_info_li" style="margin: 0 15px;"></li>
							<li class="header_top_info_li"><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
						</ul>
					</div>
					
					<ul class="header_menu_bar">	
						<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/user/home">홈</a>
						<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/info/student">MY</a>
						<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/subject/subject">수업</a>
						<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/user/home"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="로고이미지"></a>
						<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/sugang/subjectList">수강신청</a>
						<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/thisSemester">성적</a>
						<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/notice">학사정보</a>
					</ul>
				</c:when>
	
				<c:when test="${principal.userRole.equals(\"professor\")}"> <!-- home, my, 학사관리, 등록, 학사 정보  -->
					<div class="header_top_box">
						<ul class="header_top_info_ul">
							<li class="header_top_info_li">${principal.professorName}님 / id:${principal.id}</li>
							<li class="header_top_info_li" style="margin: 0 15px;"></li>
							<li class="header_top_info_li"><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
						</ul>
					</div>
					<ul class="header_menu_bar">
						<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/home.jsp">홈</a>
						<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/info/proffessor">MY</a>
						<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/subject/subject">수업</a>
						<li class="header_menu_bar_li"><a href="/six/header.jsp"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="로고이미지"></a>
						<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/notice">학사정보</a>
					</ul>
				</c:when>

				<c:otherwise> <!-- 홈 my 수업 학사 학사정 -->
					<div class="header_top_box">
						<ul class="header_top_info_ul">
							<li class="header_top_info_li">${principal.staffName}님 / id:${principal.id}</li>
							<li class="header_top_info_li" style="margin: 0 15px;"></li>
							<li class="header_top_info_li"><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
						</ul>
					</div>
					
					<ul class="header_menu_bar">
						<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/home.jsp">홈</a>
						<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/info/staff">MY</a>
						<li class="header_menu_bar_li"><a href="/six/header.jsp"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="로고이미지"></a>
						<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/management/addStudent">학사관리</a>
						<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/admin">등록</a>
						<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/notice">학사정보</a>
					</ul>

				</c:otherwise>
			</c:choose>

		</nav>
	</header>
</body>
</html>
