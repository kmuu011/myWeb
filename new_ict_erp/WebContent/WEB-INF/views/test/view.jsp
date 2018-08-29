<%@page import="com.ict.erp.service.impl.TestServiceImpl"%>
<%@page import="com.ict.erp.service.TestService"%>
<%@page import="com.ict.erp.vo.TInfo"%>
<%@page import="com.ict.erp.dao.TestDAO"%>
<%@page import="com.ict.erp.dao.impl.TestDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>

<body>
<div class="container">

	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>설명</th>
			</tr>
		</thead>
		
		<tbody>
		<%
		TInfo ti = (TInfo)request.getAttribute("tInfo");
		%>
			
			<tr>
				<td><%=ti.getTiNum() %></td>
				<td><%=ti.getTiId() %></td>
				<td><%=ti.getTiName() %></td>
				<td><%=ti.getTiText() %></td>
			</tr>
				
		</tbody>
			
		</tbody>
	</table>

</div>
</body>
</html>