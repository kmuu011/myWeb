<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>

<body>
<div id="wrapper" >
<jsp:include page="/WEB-INF/views/menu/left.jsp"/>

<div class="container button">
	<button onclick="insertM()">추가하기</button>
</div>


<table class="table table-hover">
	<thead>
		<tr>
			<th>멤버 번호</th>
			<th>멤버 이름</th>
			<th>부서 코드</th>
			<th>레벨</th>
			<th>주소1</th>
			<th>주소2</th>
			<th>Zip</th>
			<th>멤버 설명</th>
			<th>멤버 번호</th>
			<th>멤버 이메일</th>
			<th>멤버 아이디</th>
			<th>부서명</th>
			<th>직급</th>
			
		</tr>
	</thead>
	
	<tbody>
	<c:forEach var="mi" items="${miList}">
		<tr>
			<td>${mi.miNum}</td>
			<td><a href="/member/memberView?miNum=${mi.miNum}">${mi.miName}</a></td>
			<td>${mi.diCode}</td>
			<td>${mi.liLevel}</td>
			<td>${mi.miAddress1}</td>
			<td>${mi.miAddress2}</td>
			<td>${mi.miZipcode}</td>
			<td>${mi.miDesc}</td>
			<td>${mi.miPhone}</td>
			<td>${mi.miEmail}</td>
			<td>${mi.miId}</td>
			<td>${mi.diName}</td>
			<td>${mi.liName}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

</div>

<script>
function insertM(){
	location.href="/member/memberInsert";
	
}
</script>

<jsp:include page="/WEB-INF/views/menu/bottom.jsp"/>


