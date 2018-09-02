<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>

<body>
<div id="wrapper" class="container">
<jsp:include page="/WEB-INF/views/menu/left.jsp"/>
<table class="table">
	<thead>
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>취미</td>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach var="b" items="${bi}">
			<tr>
				<td>${b.bNum}</td>
				<td>${b.bName}</td>
				<td>${b.bHobby}</td>
			</tr>
		</c:forEach>
	</tbody>	

</table>



<button onclick="insert()">등록하기</button>

</div>

<script>

	function insert(){
		location.href="/bean/beanInsert";
	
	}
	
</script>

<jsp:include page="/WEB-INF/views/menu/bottom.jsp"/>


