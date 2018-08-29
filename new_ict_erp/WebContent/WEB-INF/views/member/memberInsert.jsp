<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>


<body>
<c:if test="${!empty rMap}">
<script>
alert('${rMap.msg}');
location.href = "/member/memberList";
</script>
</c:if>
<div id="wrapper" class="container">
<jsp:include page="/WEB-INF/views/menu/left.jsp"/>

<form action="/member/memberInsert" method="post">
<table class="table table-bordered">
	<tbody>
		<tr>
			<th>이름</th>
			<td><input type="text" name="miName"></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="miId"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="miPwd"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="email" name="miEmail"></td>
		</tr>
		<tr>
			<th>설명</th>
			<td><input type="text" name="miDesc"></td>
		</tr>
		<tr>
			<th>폰번호</th>
			<td><input type="text" name="miPhone"></td>
		</tr>
		<tr>
			<th>zip코드</th>
			<td><input type="text" name="miZipcode"></td>
		</tr>
		<tr>
			<th>주소1</th>
			<td><input type="text" name="miAddress1"></td>
		</tr>
		<tr>
			<th>주소2</th>
			<td><input type="text" name="miAddress2"></td>
		</tr>
		
		<tr>
			<th>
				부서 명
			</th>
			<td>
				<select name="diCode">
				<c:forEach var="di" items="${selector.miD}">
				<option value="${di.diCode}">${di.diName}</option>
				</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<th>
				직급
			</th>
		
			<td>
				<select name="liLevel">
				<c:forEach var="li" items="${selector.miL}">
				<option value="${li.liLevel}">${li.liName}</option>
				</c:forEach>
				</select>
			</td>
		</tr>
		
		<tr>
			<td colspan ="2">
				<button type="submit">가입하기</button>
			</td>
		</tr>
	</tbody>
</table>
</form>
</div>

<jsp:include page="/WEB-INF/views/menu/bottom.jsp"/>


