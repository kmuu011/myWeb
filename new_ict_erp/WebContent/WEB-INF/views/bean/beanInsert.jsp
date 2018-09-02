<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>

<body>
<div id="wrapper" class="container">
<jsp:include page="/WEB-INF/views/menu/left.jsp"/>

	<form action="/bean/beanInsert" method="post">
			<table class="table table-bordered">
				<tr>
					<th>이름</th>
					<td><input type="text" name="bName"></td>
				</tr>
				
				<tr>
					<th>취미</th>
					<td><input type="text" name="bHobby"></td>
				</tr>
				
				<tr>
					<td colspan="2"><button>등록</button></td>
				</tr>
			
			</table>
	</form>
</div>

<jsp:include page="/WEB-INF/views/menu/bottom.jsp"/>


