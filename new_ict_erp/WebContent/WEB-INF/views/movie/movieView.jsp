<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>

<body>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/menu/left.jsp"/>

<form name="view" method="post" enctype="multipart/form-data">
	<table class="table">
		<tbody id="tBody">
			<tr>
				<td>번호 : ${mi.tmNum}</td>
				<td>제목 : ${mi.tmName}</td>
				<td>표값 : ${mi.tmPrice}</td>
			</tr> 
			<tr>
				<td>개봉일 : ${mi.tmCredat}</td>
				<td>상영시작 : ${mi.tmStartDat}</td>
				<td>상영종료 : ${mi.tmEndDat}</td>
			</tr>
			<tr>
				<td colspan="3">관객수 : ${mi.tmCnt}</td>
			</tr>
			<tr>
				<td colspan="3">상세설명 : ${mi.tmDesc}</td>
			</tr>
			<tr>
				<td colspan="3"><img src="${mi.tmImg}"></td>
				<td><input type="hidden" name="tmNum" value="${mi.tmNum}"></td>
			</tr>
			
			<tr>
				<td><button onclick="moReady()" type="button">수정하기</button></td>
				<td colspan="2"><button onclick="removeM()" type="submit">삭제하기</button></td>
			</tr>
		</tbody>
	
	</table>

</form>


<script>

	function moReady(){
		var obj = document.querySelector("#tBody");
		
		var html = '<tr>'
		html += '<td>번호 : ${mi.tmNum}</td>'
		html += '<td>제목 : <input type="text" name="tmName" value="${mi.tmName}"></td>'
		html += '<td>표값 : <input type="number" name="tmPrice" value="${mi.tmPrice}"></td>'
		html += '</tr> '
		html += '<tr>'
		html += '<td>개봉일 : ${mi.tmCredat}</td>'
		html += '<td>상영시작 : <input type="date" name="tmStartDat"></td>'
		html += '<td>상영종료 : <input type="date" name="tmEndDat"></td>'
		html += '</tr>'
		html += '<tr>'
		html += '<td colspan="3">관객수 : <input type="number" name="tmCnt" value="${mi.tmCnt}"></td>'
		html += '</tr>'
		html += '<tr>'
		html += '<td colspan="3">상세설명 : <input type="text" name="tmDesc" value="${mi.tmDesc}"></td>'
		html += '</tr>'
		html += '<tr>'
		html += '<td colspan="3"><input type="file" name="tmImg"></td>'
		html += '<td><input type="hidden" name="tmNum" value="${mi.tmNum}"></td>'
		html += '</tr>'
	
		html += '<tr>'
		html += '<td colspan="3"><button onclick="modify()" type="submit">수정하기</button></td>'
		html += '</tr>'
		
		obj.innerHTML = html;
	
	}
	
	function modify(){
		view.action ="/movie/movieUpdate";
		
	}
	
	function removeM(){
		view.action = "/movie/movieDelete";
	}
	
	
</script>


</div>

<jsp:include page="/WEB-INF/views/menu/bottom.jsp"/>


