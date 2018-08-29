<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>
<%
String msg = (String)request.getAttribute("msg");
if(msg != null){
%>
<script>
alert('<%=msg%>');
location.href = '<%=rPath%>/test/tList';
</script>
<%
}
%>
<body>

</body>
</html>