<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>

<body>
<c:if test="${!empty rMap}">
	<script>
		alert('${rMap.msg}');
		location.href="/music/musicList";
	</script>

</c:if>
<div id="wrapper" class="container">
<jsp:include page="/WEB-INF/views/menu/left.jsp"/>
<table class="table table-hover">
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>가수</th>
			<th>회사</th>
			<th>좋아요</th>
			<th>싫어요</th>
			<th>작곡가</th>
			<th>설명</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach var="mi" items="${music}">
		<tr>
			<td>${mi.mcNum}</td>
			<td><a href="/music/musicView?mcNum=${mi.mcNum}">${mi.mcName}</a></td>
			<td>${mi.mcSinger}</td>
			<td>${mi.mcVendor}</td>
			<td>${mi.mcLike}</td>
			<td>${mi.mcDislike}</td>
			<td>${mi.mcCredat}</td>
			<td>${mi.mcDesc}</td>
		</tr>
		</c:forEach>
	</tbody>

</table>
<div class="btns">

</div>
	<button onclick="musicInsert()">등록하기</button>
</div>

<script>
function musicInsert(){
	location.href = "/music/musicInsert";
}

</script>

<jsp:include page="/WEB-INF/views/menu/bottom.jsp"/>


