<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/hiddenATag.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/subMenu.css">

</head>
<body>
    <div class="d-flex">
        <div class="sub_menu_top">
            <h2>학사 정보</h2>
        </div>
        <div class="sub_menu_mid">
            <table class="sub_menu_table">
                <tbody>
                    <tr>
                    	
                        <td><a class="link-style" href ="${pageContext.request.contextPath}/notice/notice">공지사항</a></td>
                    </tr>
                    <tr>
                        <td><a class="link-style" href="${pageContext.request.contextPath}/schedule/schedule">학사일정</a></td>
                    </tr>
                </tbody>
            </table>
        </div>

        <div class="container">
            <form action="${pageContext.request.contextPath}/notice/addregister" method="post">
                <h1>게시판</h1>
                <div class="input-form">
                    <h2>글 작성하기</h2>
                    <select id="category" name="category">
                        <option value="&#91;일반&#93;">일반</option>
                        <option value="&#91;학사&#93;">학사</option>
                        <option value="&#91;장학&#93;">장학</option>
                    </select>
                    <label for="title">제목:</label> 
                    <input type="text" id="title" name="title" required>
                    <label for="content">내용:</label> 
                    <textarea id="content" name="content" required></textarea>
                    <button type="submit">등록</button>
                </div>
            </form>
        </div>
    </div>
    <%@ include file="/WEB-INF/views/layout/footer.jsp"%>
</html>