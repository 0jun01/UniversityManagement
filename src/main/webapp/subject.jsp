<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file= "/WEB-INF/views/layout/header.jsp" %>
</head>
<body>
	<!-- 세부 메뉴 + 메인 -->
	<div>
		<div class="sub_menu">
			<div class="sub_menu_top">
				<h2>수업</h2>
			</div>
			<div class="sub_menu_mid">
				<table class="sub_menu_table" border="1">
					<tbody>
						<tr>
							<td><a href="subject/list/1" class="selected_menu">전체 강의 조회</a></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- 메뉴 -->
		<main>
			<h1>전체 강의 조회</h1>
			<div class="filter">
				<form action="#">
					<label>연도</label>
					<!-- 개설연도 숫자 -->
					<input type="number" value="2024" name="year" id="year" min="2017" max="2033"> <label>학기</label> <select name="semester" id="semester">
						<option value="1">1학기</option>
						<option value="2">2학기</option>
					</select> <label>개설학과</label> <select name="deptId">
						<option value="-1">전체</option>
						<option value="101">컴퓨터공학과</option>
						<option value="102">전자공학과</option>
						<option value="103">화학공학과</option>
						<option value="104">기계공학과</option>
						<option value="105">신소재공학과</option>
						<option value="106">철학과</option>
						<option value="107">국사학과</option>
						<option value="108">언어학과</option>
						<option value="109">국어국문학과</option>
						<option value="110">영어영문학과</option>
						<option value="111">심리학과</option>
						<option value="112">정치외교학과</option>
						<option value="113">사회복지학과</option>
						<option value="114">언론정보학과</option>
						<option value="115">인류학과</option>
						<option value="116">경영학과</option>
						<option value="117">경제학과</option>
						<option value="118">회계학과</option>
						<option value="119">농업경영학과</option>
						<option value="120">무역학과</option>
						</select> 
						
						<!-- 강의 검색 -->
						<label>강의명</label> 
						<input type="text" name="name" list="lecture_name">
						<datalist id="lecture_name">
						<option value="데이터통신"></option>
						<option value="딥러닝의 기초"></option>
						<option value="컴퓨터의 개념 및 실습"></option>
						<option value="컴퓨터 프로그래밍"></option>
						<option value="공학설계 입문"></option>
						<option value="반도체 공학"></option>
						<option value="융합전자연구"></option>
						<option value="기초 전기실험"></option>
						<option value="물리화학"></option>
						<option value="반응공학"></option>
						<option value="사고와 표현"></option>
						<option value="과학과 기술"></option>
						<option value="고체역학"></option>
						<option value="자유정의진리"></option>
						<option value="정보적 사고"></option>
						<option value="CAD기초"></option>
						<option value="에너지재료"></option>
						<option value="나노재료합성"></option>
						<option value="신소재공학개론"></option>
						<option value="신소재기초실습"></option>
						<option value="칸트철학"></option>
						<option value="불교철학사"></option>
						<option value="대륙합리론"></option>
						<option value="심리학론"></option>
						<option value="역사학개론"></option>
						<option value="동아시아사"></option>
						<option value="한국근대사"></option>
						<option value="한국사입문"></option>
						<option value="의미론"></option>
						<option value="형태론"></option>
						<option value="컴퓨터언어학"></option>
						<option value="이태리어"></option>
						<option value="고전문학연습"></option>
						<option value="국어정서법"></option>
						<option value="한국현대작가론"></option>
						<option value="국문학개론"></option>
						<option value="중세영문학"></option>
						<option value="영어발달사"></option>
						<option value="현대영국소설론"></option>
						<option value="영문학입문"></option>
						<option value="일반심리학"></option>
						<option value="적응심리학"></option>
						<option value="성격심리학"></option>
						<option value="인지심리학"></option>
						<option value="비교정치론"></option>
						<option value="외교정치론"></option>
						<option value="국제정치경제론"></option>
						<option value="한국정치론"></option>
						<option value="현대사회심리"></option>
						<option value="인간행동과 사회환경"></option>
						<option value="사회복지학개론"></option>
						<option value="사회복지행정론"></option>
						<option value="언론정보학개론"></option>
						<option value="방송의이해"></option>
						<option value="광고의이해"></option>
						<option value="한국언론사"></option>
						<option value="문화인류학"></option>
						<option value="세계화와 다문화주의"></option>
						<option value="의료인류학"></option>
						<option value="도시와문화"></option>
						<option value="기업경영의이해"></option>
						<option value="경영학원론"></option>
						<option value="마켓팅의 이해"></option>
						<option value="마켓팅 조사론"></option>
						<option value="경제학원론"></option>
						<option value="미시경제학"></option>
						<option value="거시경제학"></option>
						<option value="신자유주의 경제학"></option>
						<option value="재무회계"></option>
						<option value="회계감사"></option>
						<option value="원가회계"></option>
						<option value="관리회계"></option>
						<option value="농업생산경제학"></option>
						<option value="농산물 가격분석"></option>
						<option value="농산물 유통학"></option>
						<option value="농업 정책론"></option>
						<option value="무역상무론"></option>
						<option value="국제경영학"></option>
						<option value="국제무역론 입문"></option>
						<option value="한국무역법"></option>
						</datalist>
				</form>
				<h2>목록 </h2>
				<!-- TODO [총 00건] -->
				<!-- 나중에 for문 돌려서 강의 목록 페이지 작성! 페이징 처리도 해야함.  -->
				<h3> [총 00건]</h3>
				<table border="1">
					<tbody>
						<tr>
							<th></th>
						</tr>						
					</tbody>
				</table>
			</div>
		</main>
	</div>
</body>
</html>