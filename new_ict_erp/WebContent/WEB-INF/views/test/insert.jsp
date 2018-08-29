<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>
<%
String msg = (String)request.getAttribute("msg");

if(msg !=null){
%>
<script>
alert('<%=msg%>');
</script>
<%
}
%>

<body>
	<div id="wrapper" class="container">
<jsp:include page="/WEB-INF/views/menu/left.jsp"/>
		<div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
			<div class="form-group">
			<h2>정보 입력하기</h2>
				<input type="text" id="id" class="form-control input-lg" placeholder="아이디" >
			</div>
			
			<div class="form-group">
        		<input type="text" id="name" class="form-control input-lg" placeholder="이름" >
			</div>
			
			<div class="form-group">
        		<input type="text" id="txt" class="form-control input-lg" placeholder="내용" style="height:300px">
			</div>
			
			<div class="form-group">
				<button onclick="insertOK()">입력 하기</button>
			</div>
			
		</div>
		
	</div>
	
	<script>
	
	function insertOK(){
		var id = document.querySelector('#id').value;
		var name = document.querySelector('#name').value;
		var txt = document.querySelector('#txt').value;
		
		location.href = '<%=rPath%>/test/insertOK?id=' + id + '&name=' + name + '&txt=' + txt;
		
	}
	
	</script>

<jsp:include page="/WEB-INF/views/menu/bottom.jsp"/>