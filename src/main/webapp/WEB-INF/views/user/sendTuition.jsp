<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ include file="/WEB-INF/views/subMenu/staffManagement.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/subject.css">

<form action="${pageContext.request.contextPath}/management/sendTuition">
	<input type="submit" value="등록금 고지서 발송"> 
</form> 

</body>
</html>