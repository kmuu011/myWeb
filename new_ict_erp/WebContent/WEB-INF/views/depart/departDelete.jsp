<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>


<body>
<c:if test="${!empty rMap}">
	<script>
		alert('${rMap.msg}');
		location.href= "/depart/departList";
	</script>
</c:if>
<div id="wrapper" class="container">
<jsp:include page="/WEB-INF/views/menu/left.jsp"/>
		


</div>

<jsp:include page="/WEB-INF/views/menu/bottom.jsp"/>


