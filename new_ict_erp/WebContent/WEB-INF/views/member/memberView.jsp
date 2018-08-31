<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>


<body>
<c:if test="${!empty rMap}">
<script>
	alert('${rMap.msg}');
	location.href="/member/memberList";
</script>

</c:if>

<div id="wrapper" class="container">
<jsp:include page="/WEB-INF/views/menu/left.jsp"/>
<form name="view" method="post">
<table  class="table">
	<tbody id="tBody">
		<tr>
			<th></th>
			<th></th>
			<th></th>
			<th><button type="button" onclick="modify()">수정하기</button></th>
		</tr>
		<tr>
			<th>번호 : ${mi.miNum}</th>
			<th>이름 : ${mi.miName}</th>
			<th>부서 : ${mi.diCode}</th>
			<th>직급 : ${mi.liLevel}</th>
		</tr>
		<tr>
			<th colspan="2">아이디 : ${mi.miId}</th>
			<th colspan="2">비번 : ******</th>
		</tr>
		<tr>
			<th colspan="2">이메일 : ${mi.miEmail}</th>
			<th colspan="2">연락처 : ${mi.miPhone}</th>
		</tr>
		<tr>
			<th colspan="4">우편번호 : ${mi.miZipcode}</th>
		</tr>
		<tr>
			<th colspan="2">주소 : ${mi.miAddress1}</th>
			<th colspan="2">주소 : ${mi.miAddress2}</th>
		</tr>
		<tr>
			<th colspan="4">설명 : ${mi.miDesc}</th>
		</tr>
	</tbody>

</table>

</form>

</div>


<script>
function modify(){
	var obj = document.querySelector("#tBody");
	
	var html = '<tr>'
		html += '<td><button type="submit" onclick="remove()">삭제하기</button></td>'
		html += '<th></th>'
		html += '<th></th>'
		html += '<th><button type="submit" onclick="update()">수정하기</button></th>'
		html += '</tr>'
		html += '<tr>'
		html += '<th>번호 : ${mi.miNum}</th>'
		html += '<th>이름 : <input type="text" name="miName" value="${mi.miName}"></th>'
		html += '<th>부서 : '
		html += '<select name="diCode">'
		html += '<c:forEach var="mid" items="${selector.miD}">'
		html += '<option value="${mid.diCode}">${mid.diName}</option>'
		html += '</c:forEach>'
		html += '</select>'
		html += '</th>'
		html += '<th>직급 : '
		html += '<select name="liLevel">'
		html += '<c:forEach var="mil" items="${selector.miL}">'
		html += '<option value="${mil.liLevel}">${mil.liName}</option>'
		html += '</c:forEach>'
		html += '</select>'
		html += '</th>'
		html += '</tr>'
		html += '<tr>'
		html += '<th colspan="2">아이디 : <input type="text" name="miId" value="${mi.miId}"></th>'
		html += '<th colspan="2">비번 : <input type="text" name="miPwd" value="${mi.miPwd}"></th>'
		html += '</tr>'
		html += '<tr>'
		html += '<th colspan="2">이메일 : <input type="text" name="miEmail" value="${mi.miEmail}"></th>'
		html += '<th colspan="2">연락처 : <input type="text" name="miPhone" value="${mi.miPhone}"></th>'
		html += '</tr>'
		html += '<tr>'
		html += '<th colspan="4">우편번호 : <input type="text" name="miZipcode" value="${mi.miZipcode}"></th>'
		html += '</tr>'
		html += '<tr>'
		html += '<th colspan="2">주소 : <input type="text" name="miAddress1" value="${mi.miAddress1}"></th>'
		html += '<th colspan="2">주소 : <input type="text" name="miAddress2" value="${mi.miAddress2}"></th>'
		html += '<th><input type="hidden" name="miNum" value="${mi.miNum}"></th>'
		html += '</tr>'
		html += '<tr>'
		html += '<th colspan="4">설명 : <input type="text" name="miDesc" value="${mi.miDesc}"></th>'
		html += '</tr>'
		
		obj.innerHTML = html;
}

function remove(){
	view.action = "/member/memberDelete";
}

function update(){
	view.action = "/member/memberUpdate";
}


</script>


<jsp:include page="/WEB-INF/views/menu/bottom.jsp"/>


