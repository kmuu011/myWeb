<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>



<body>
<div id="wrapper" class="container">
<jsp:include page="/WEB-INF/views/menu/left.jsp"/>

<form action="/depart/departUpdate" method="post">
<table class="table table-bordered">
	<tbody id="tBody">
		<tr>
			<th>부서 번호 : ${di.diNum}</th>
			<th>부서 코드 : ${di.diCode}</th>
			<th>부서 이름 : ${di.diName}</th>
		</tr>
		<tr>
			<th colspan="3"> - 부서 설명 - <br><br>${di.diDesc}</th>
		</tr>
		<tr>
		<td colspan="3"><button type="button" onclick="updateR()">수정하기</button></td>
	</tbody>
</table>
</form>




<script>
function updateR(){
	var obj = document.querySelector("#tBody");
	

	var html =	'<tr>';
	html += '<th>부서 번호 : ${di.diNum}</th>';
	html += '<th>부서 코드 : <input type="text" name="diCode" value="${di.diCode}"></th>';
	html += '<th>부서 이름 : <input type="text" name="diName" value="${di.diName}"></th>';
	html += '</tr>';
	html += '<tr>';
	html += '<th colspan="3"> - 부서 설명 - <br><br><input type="text" name="diDesc" value="${di.diDesc}"></th>';
	html += '</tr>';
	html += '<tr>';
	html += '<td colspan="3"><button>수정하긩</button></td>';
	html += '<td><input type="hidden" name="diNum" value="${di.diNum}"</td>';
	html += '</tr>'

	
	obj.innerHTML = html;

	
}


</script>



</div>

<jsp:include page="/WEB-INF/views/menu/bottom.jsp"/>


