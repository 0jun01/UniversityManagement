<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div class="sub_menu">
			<div class="sub_menu_top">
				<h2>수업</h2>
			</div>
			<div class="sub_menu_mid">
				<table class="sub_menu_table" border="1">
					<tbody>
						<tr>
							<td><a href="${pageContext.request.contextPath}/subject/subject" class="selected_menu">전체 강의 조회</a></td>
									<td><a href="${pageContext.request.contextPath}/professor/myClass" class="selected_menu">내 강의 조회</a></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
</body>
</html>