<%@page import="com.ict.erp.vo.PList"%>
<%@page import="java.util.List"%>
<%@page import="com.ict.erp.service.Servicepr"%>
<%@page import="com.ict.erp.service.impl.ServiceprImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>
<%
Servicepr sp = new ServiceprImpl();
sp.getList(request);

%>
<body>
<div class='container'>
	<table class="table table-hover">
		<thead>
			<tr>
				<th><input type="checkbox" id="achk"></th>
				<th>번호</th>
				<th>제목</th>
				<th>조회수</th>
			</tr>
		</thead>
	
	<tbody>
	<c:forEach var="p" items="${pList}">
		<tr>
			<td><input type="checkbox" name="chk" value="${p.pno}"></td>
			<td>${p.pno}</td>
			<td><a onclick="view(${p.pno})">${p.pname}</a></td>
			<td>${p.phit}</td>
		</tr>
	</c:forEach>
		
			
	</tbody>
	
	</table>
	
	<button onclick="insert()">입력</button>
</div>


<script>
	function insert(){
		location.href="/level/insert";
	}

	function view(obj){
		
		
		
	}

</script>

</body>
</html>