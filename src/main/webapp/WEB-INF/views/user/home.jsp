<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<%-- <%
request.getAttribute("principal");
%> --%>
	<div class="background">
	<img alt="메인이미지" src="${pageContext.request.contextPath}/resources/img/mainBackground.jpg">
	</div>
	<div class="notice_bar">
		<div>
		<h1>공지사항</h1>
		</div>
		<div>
			<h1>학사일정</h1>
		</div>
			<h1>${principal.name}님, 환영합니다</h1>  	
	</div>
	
</body>
</html>