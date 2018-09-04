<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>

<style>
	td{
	width:400px;
	text-align:center;
	
	}
</style>

<body>
<c:if test="${!empty cnt}">
	<script>
		alert('${cnt}개의 작업이 성공!');
		location.href = "/movie/movieList";
	</script>
</c:if>

<div id="wrapper">
<jsp:include page="/WEB-INF/views/menu/left.jsp"/>
<form name="view" method="post">
<table class="table">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>표값</th>
			<th>시작날짜</th>
			<th>종료날짜</th>
			<th>개봉일</th>
			<th>설명</th>
			<th>관객수</th>
			<th>이미지</th>
		</tr>
	</thead>
	
	<tbody>
	<c:forEach var="mi" items="${miList}">
		<tr>
			<td>${mi.tmNum}</td>
			<td><a href="/movie/movieView?tmNum=${mi.tmNum}">${mi.tmName}</a></td>
			<td>${mi.tmPrice}</td>
			<td>${mi.tmStartDat}</td>
			<td>${mi.tmEndDat}</td>
			<td>${mi.tmCredat}</td>
			<td>${mi.tmDesc}</td>
			<td>${mi.tmCnt}</td>
			<td><img src="${mi.tmImg}" width="100"></td>
		</tr>
	</c:forEach>
	</tbody>
			
	
</table>
</form>

<div class="btns">
<button onclick="insert()">추가하기</button>
</div>

<script>
function insert(){
	location.href = "/movie/movieInsert";
}


</script>
</div>

<jsp:include page="/WEB-INF/views/menu/bottom.jsp"/>


