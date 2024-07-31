<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home.css">

<% request.getAttribute("principal"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>공지사항 및 학사일정</title>
</head>
<body>
    <div class="background">
        <img alt="메인이미지" src="${pageContext.request.contextPath}/resources/img/mainBackground.jpg">
    </div>

    <h1>${principal.name}님, 환영합니다</h1>

    <div class="main-content">
        <!-- Notice Bar Section -->
        <div class="notice_bar">
            <h2>공지사항</h2>
            <section class="notice">
                <div class="page-title">
                    <div class="container">
                        <!-- Page Title -->
                    </div>
                </div>

                <div id="board-search">
                    <div class="container">
                            <form action="">
                                <div class="search-wrap">
                                    <!-- Add search input and button here if needed -->
                                </div>
                            </form>
                    </div>
                </div>

                <!-- Board list area -->
                <div id="board-list">
                    <div class="container">
                        <table class="board-table">
                            <thead>
                                <tr>
                                    <!-- <th scope="col" class="th-num">번호</th> -->
                                    <th scope="col" class="th-category">말머리</th>
                                    <th scope="col" class="th-title">제목</th>
                                    <th scope="col" class="th-date">등록일</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${noticeList}" var="notice">
                                    <tr>
                                        <!-- <td>${notice.id}</td> -->
                                        <td>${notice.category}</td>
                                        <td>${notice.title}</td>
                                        <td>${notice.createdTime}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </section>
        </div>

        <!-- Schedule Section -->
        <div class="schedule_section">
            <h2>학사일정</h2>
            <table class="schedule-table">
                <thead>
                    <tr>
                        <!-- <th>번호</th> -->
                        <th>시작일</th>
                        <th>종료일</th>
                        <th>제목</th> 
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${scheduleList}" var="schedule">
                        <tr>
                            <!-- <td>${schedule.staffId}</td> -->
                            <td>${schedule.startDay}</td>
                            <td>${schedule.endDay}</td>
                            <td>${schedule.information}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>