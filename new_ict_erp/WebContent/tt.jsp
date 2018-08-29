<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>
<%
Map<String,Object> mm = new HashMap<String,Object>();
int cnt = 3;
mm.put("cnt", cnt);
request.setAttribute("mm", mm);
session.setAttribute("ms", "읭긯");


%>
<body>
${mm.cnt}
${ms}

</body>
</html>