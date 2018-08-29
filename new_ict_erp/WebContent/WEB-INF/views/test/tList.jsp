<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp"%>

<style>
	tr>td{
		cursor : pointer;
	}
</style>

<body>
<div id="wrapper" class="container">
<jsp:include page="/WEB-INF/views/menu/left.jsp" />


	<div class="container">
		<select id="shType">
			<option value="tiNum">번호</option>
			<option value="tiId">아이디</option>
			<option value="tiName">이름</option>
			<option value="tiText">내용</option>
		</select>
		<input type="text" id="shText">
		<button type="button" onclick="searchTest()">검색</button>
	</div>
	
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
			<c:forEach var="ti" items="${tList}">
				<tr onclick="goPage(${ti.tiNum})">
					<td>${ti.tiNum}</td>
					<td>${ti.tiId}</td>
					<td>${ti.tiName}</td>
					<td>${ti.tiText}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<button onclick="insert()">입력하기</button>
</div>

<script>
function searchTest(){
	var shType = document.querySelector('#shType').value;
	var shText = document.querySelector('#shText').value;
	
	if(shText.trim()==''){
		alert("검색어는 1글자 이상입니다.");
		return;
	}
	
	location.href = "<%=rPath%>/test/tList?shType=" + shType + "&shText=" + shText;
}

function goPage(tiNum){
	location.href = "<%=rPath%>/test/view?tiNum=" + tiNum;
}

function insert(){
	location.href = "<%=rPath%>/test/insert";
}

</script>

<jsp:include page="/WEB-INF/views/menu/bottom.jsp"/>