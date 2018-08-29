<%@page import="com.ict.erp.service.Servicepr"%>
<%@page import="com.ict.erp.service.impl.ServiceprImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>

<%
Servicepr sp = new ServiceprImpl();
String name = request.getParameter("name");
String txt = request.getParameter("txt");
int result = sp.getInsert(name, txt);


%>
<body>


<%
if(result ==1){
%>
<script>
alert("작성완료!");

location.href = "/level/list"
</script>
<%
}
%>

</body>
</html>