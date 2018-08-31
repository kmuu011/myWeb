<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>

<body>
<div id="wrapper" class="container">
<jsp:include page="/WEB-INF/views/menu/left.jsp"/>
<c:if test="${!empty user}">
	${user.miName}님 안녕하세요.
</c:if>
</div>

<jsp:include page="/WEB-INF/views/menu/bottom.jsp"/>