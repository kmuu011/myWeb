<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>

<body>
<div id="wrapper" class="container">
<jsp:include page="/WEB-INF/views/menu/left.jsp" />

<input type="text" name="search" onkeyup="checkEnter(event)">
<select name="op">
	<option value="diNum">번호</option>
	<option value="diCode">코드</option>
	<option value="diName">이름</option>
	<option value="diDesc">설명</option>
</select>
<button onclick="search()">검색</button>

<div class="page-content-wrapper">
<table class="table table-hover">
	<thead>
		<tr>
			<td><input type="checkbox" onclick="achk(this)"></td>
			<td>부서번호</td>
			<td>부서코드</td>
			<td>부서이름</td>
			<td>부서설명</td>
		</tr>
	</thead>
	
	<tbody id="diTbody">
	
	<c:forEach var="dl" items="${dList}">
		<tr>
			<td><input type="checkbox" name="chk" value="${dl.diNum}"></td>
			<td>${dl.diNum}</td>
			<td><a onclick='view(${dl.diNum})' href="#">${dl.diCode}</a></td>
			<td><a onclick='view(${dl.diNum})' href="#">${dl.diName}</a></td>
			<td><a onclick='view(${dl.diNum})' href="#">${dl.diDesc}</a></td>
		</tr>
	</c:forEach>
	
	<c:if test="${empty dList}">
		<tr>
			<td colspan="5">부서 없음</td>
		</tr>
	</c:if>
	
	
	
	</tbody>
	
</table>

<div class="page" style="text-align:center">
			<jsp:include page="/WEB-INF/views/menu/pagination.jsp"></jsp:include>
</div>

<div class="btns">
		<button data-page="/views/depart/departInsert">부서 추가</button>
		<button id="del" onclick="deleteR()">부서 삭제</button>
</div>
</div>

<script>


var emptyList = '${empty dList}';

var cnt = '${imap.cnt}';

if(cnt){
	alert(cnt + "개의 등록이 성공했습니다.");
	location.href = "/depart/departList";
}



function addR(){
	var html = '<tr>';
	html += '<td>&nbsp;</td>';
	html += '<td>&nbsp;</td>';
	html += '<td><input type="text" name="diCode"></td>';
	html += '<td><input type="text" name="diName"></td>';
	html += '<td><input type="text" name="diDesc"></td>';
	html += '</tr>';

	var obj = document.querySelector('#diTbody');
	
	if(emptyList === 'true'){
		obj.innerHTML = html;
		emptyList = false;
	} else {
		obj.insertAdjacentHTML('beforeend', html);
	}
}

function makeParam(name,option){
	var selector = 'input[name=' + name + ']';
	if(option){
		selector += option;	
	}
	
	if(!document.querySelector(selector)){
		selector = 'select[name=' + name + ']';
	}
	
	var obj = document.querySelectorAll(selector);
	var param = '';
	
	for(var i=0 ; i<obj.length ; i++){
		param += name+ '=' + obj[i].value + '&';
	}
	
	return param;
	
}

function search(){
	var params = makeParam('search');
	params += makeParam('op');
	
	location.href = "/depart/departList?" + params;
	
}



function view(e){
	location.href = "/depart/departView?diNum=" + e;
}

function achk(e){
	document.querySelectorAll('input[name=chk]').forEach((el) => {el.checked = e.checked});
	
}

function deleteR(){
	var params = makeParam("chk",":checked");
	
	location.href = "/depart/departDelete?" + params;
}


</script>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />