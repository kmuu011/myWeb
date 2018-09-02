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
<form action="/music/musicInsert" method="post">
	<table class="table">
		
			<tr>
				<th>제목 : <input type="text" name="mcName"></th>
			</tr>
			<tr>
				<th>가수 : <input type="text" name="mcSinger"></th>
			</tr>
			<tr>
				<th>회사 : <input type="text" name="mcVendor"></th>
			</tr>
			<tr>
				<th>작곡가 : <input type="text" name="mcCredat"></th>
			</tr>
			<tr>
				<th>설명 : <input type="text" name="mcDesc"></th>
			</tr>
			
			<tr>
			
			<tr>
				<td><button>등록</button></td>
			</tr>
				
				
	</table>
</form>

</div>

<jsp:include page="/WEB-INF/views/menu/bottom.jsp"/>


