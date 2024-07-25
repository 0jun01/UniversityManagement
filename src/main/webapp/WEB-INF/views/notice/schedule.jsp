<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>전체 일정</title>
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

    <h1>전체 일정</h1>
    <table border="1">
        <tr>
            <th>번호</th>
            <th>카테고리</th>
            <th>제목</th>
            <th>조회수</th>
        </tr>
        <tbody>
        <c:forEach items="${schedulelist}" var="schedule">
            <tr>
                <td>${schedule.staffId}</td>
                <td>${schedule.startDay}</td>
                <td>${schedule.endDay}</td>
                <td>${schedule.information}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>