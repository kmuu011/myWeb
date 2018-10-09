<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>

<body>
<c:if test="${!empty cnt}">
	<script>
		alert('${cnt}개의 작업이 성공!');
		location.href = "/movie/movieList";
	</script>
</c:if>

<div id="wrapper" class="container">
<jsp:include page="/WEB-INF/views/menu/left.jsp"/>

<form action="/movie/movieInsert" method="post" enctype="multipart/form-data">
	<table class="table table-bordered">
		<tr>
			<th>영화이름</th>
			<td><input type="text" name="tmName"></td>
		</tr>
		<tr>
			<th>티켓가격</th>
			<td><input type="number" name="tmPrice"></td>
		</tr>
		<tr>
			<th>상영일</th>
			<td><input type="date" name="tmStartDat"></td>
		</tr>
		<tr>
			<th>종료일</th>
			<td><input type="date" name="tmEndDat"></td>
		</tr>
		<tr>
			<th>영화설명</th>
			<td><input type="text" name="tmDesc"></td>
		</tr>
		<tr>
			<th>영화포스터</th>
			<td><input type="file" name="tmImg"></td>
		</tr>
		<tr>
			<td colspan="2"><button>영화등록</button></td>
		</tr>
	</table>
</form>


</div>

<jsp:include page="/WEB-INF/views/menu/bottom.jsp"/>


