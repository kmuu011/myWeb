<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>

<body>
	<div id="wrapper" class="container">
		<jsp:include page="/WEB-INF/views/menu/left.jsp" />
		<form name="view" method="post">
			<table class="table">
				<tbody id="tBody">
					<tr>
						<th>번호 : ${msi.mcNum}</th>
						<th>제목 : ${msi.mcName}</th>
						<th>가수 : ${msi.mcSinger}</th>
					</tr>
					<tr>

						<th>회사 : ${msi.mcVendor}</th>
						<th>작곡가 : ${msi.mcCredat}</th>
						<th></th>
					</tr>
					<tr>

						<th>좋아요 : ${msi.mcLike}</th>
						<th>싫어요 : ${msi.mcDislike}</th>
						<th></th>


					</tr>

					<tr>
						<th><input type="hidden" name="mcNum" value="${msi.mcNum}"></th>
						<th colspan="3">설명 : ${msi.mcDesc}</th>
					</tr>
					<tr>
						<td colspan="3"><button type="button" onclick="goM()">수정하기</button></td>
					</tr>
					
				</tbody>
			</table>



		</form>

		<script>
function goM(){
	var obj = document.querySelector("#tBody");
	
	var html = '<tr>'
		html += '<th>번호 : ${msi.mcNum}</th>'
		html += '<th>제목 : <input type="text" name="mcName" value="${msi.mcName}"></th>'
		html += '<th>가수 : <input type="text" name="mcSinger" value="${msi.mcSinger}"></th>'
		html += '</tr>'
		html += '<tr>'
	
		html += '<th>회사 : <input type="text" name="mcVendor" value="${msi.mcVendor}"></th>'
		html += '<th>작곡가 : <input type="text" name="mcCredat" value="${msi.mcCredat}"></th>'
		html += '<th></th>'
		html += '</tr>'
		html += '<tr>'
	
		html += '<th>좋아요 : ${msi.mcLike}</th>'
		html += '<th>싫어요 : ${msi.mcDislike}</th>'
		html += '<th></th>'
	
		html += '</tr>'
		
		html += '<tr>'
		html += '<th><input type="hidden" name="mcNum" value="${msi.mcNum}"></th>'
		html += '<th colspan ="3">설명 : <input type="text" name="mcDesc" value="${msi.mcDesc}"></th>'
		html += '</tr>'
		html += '<tr>'
		html += '<td><button type="submit" onclick="modify()">수정하기</button></td>'
		html += '<td colspan="2"><button type="submit" onclick="remove()">삭제하기</button></td>'
		html += '</tr>'
		
		obj.innerHTML = html;
	
}

function modify(){
	 view.action = "/music/musicModify";
}

function remove(){
	view.action = "/music/musicDelete";
}

</script>
	</div>

	<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />