<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>


<body>

<c:if test="${rMap.result == 0}">
<script>
	alert('${rMap.msg}');
	location.href = "/login/login";
</script>

</c:if>

<c:if test="${rMap.result == 1}">
<c:set var="user" value="${rMap.mi}" scope="session"/>
<script>
	alert('${rMap.msg}');
	location.href = "/";
</script>

</c:if>


<div id="wrapper" class="container">
<jsp:include page="/WEB-INF/views/menu/left.jsp"/>
<form action="/login/login" method="post">
<table>
	<tr>
		<th>아이디</th>
		<td><input type="text" name="miId"></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="miPwd"></td>
	</tr>
	<tr>
		<td><button type="submit">로그인</button></td>
	</tr>
</table>

</form>


</div>

<jsp:include page="/WEB-INF/views/menu/bottom.jsp"/>


