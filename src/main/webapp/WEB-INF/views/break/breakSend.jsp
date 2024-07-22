<%@page import="com.uni.system.repository.model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ include file="/WEB-INF/views/student/subMenuMY.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
request.getAttribute("principal");
session.getAttribute("studentInfo");
System.out.print(session.getAttribute("studentInfo"));
%>
<div class="breakList">
<form action="${pageContext.request.contextPath}/break/send" method="post">
	<h3>휴학 신청서</h3>
	<table border="1">
		<tbody>
			<tr>
				<th>단 과 대</th>
				<td>${studentInfo.college}</td>
				<th>학과</th>
				<td>${studentInfo.department}</td>
			</tr>
			<tr>
				<th>학번</th>
				<td>${studentInfo.id}</td>
				<td>${principal.id}</td>
				<th>학년</th>
				<td>${studentInfo.grade}</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>${studentInfo.address}</td>
			</tr>
			<tr>
				<th>기간</th>
				<td>2024학년 <!-- fromYear -->
				
				<select id="fromSemester" name = "fromSemester">
						<option value="1">1</option>
						<option value="2">2</option>
				</select> 
				
				<select id="toYear" name = "toYear">
						<option value="2024">2024</option>
						<option value="2025">2025</option>
						<option value="2026">2026</option>
				</select>년도 
				
				<select id="toSemester" name = "toSemester"> <!-- toYear -->
						<option value="1">1</option>
						<option value="2">2</option>
				</select>학기까지
				</td>
			</tr>
			<tr>
				<th>휴학구분</th>
				<td>  
				
				<input type="radio" id="normal" name="fav_language" value="normal">   
				<label for="normal">일반휴학</label><br>   
				
				<input type="radio" id="pregnant" name="fav_language" value="pregnant">   
				<label for="pregnant">임신·출산·육아휴학</label><br>   
				
				<input type="radio" id="disease" name="fav_language" value="disease">
				<label for="disease">질병휴학</label>
				
				<input type="radio" id="founded" name="fav_language" value="founded">
				<label for="founded">창업휴학</label>
				
				<input type="radio" id="army" name="fav_language" value="army">
				<label for="army">군입대휴학</label>

				</td>
			</tr>
			<tr>
				<a>위와 같이 휴학하고자 하오니 허가하여 주시기 바랍니다.</a>
				<p><fmt:formatDate value="${breakApp.appdate}" pattern="yyyy-MM-dd HH:mm"/></p>
			</tr>
			

		</tbody>
	</table>
	<button type="submit">신청하기</button>
	</form>
</div>
</body>
</html>
