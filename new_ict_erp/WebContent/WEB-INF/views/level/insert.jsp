<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/WEB-INF/views/common/common.jsp" %>

<body>
<form action="/level/insertOK">

<div class='container'>
	<table class="table">
		<thead>
			<tr>
				<th>제목 <input type="text" id="name" name="name" style="width:600px"></th>
				
			</tr>
		</thead>
		
		<tbody>
			<tr>
				<td>내용 <input type="text" id="txt" name="txt" style="width:600px; height:500px"></td>
			</tr>
		</tbody>

	</table>
	<button>입력</button>
</div>
</form>
<script>

function ins(){
	var name = document.querySelector("#name");
	var txt = document.querySelector("#txt");
	
	
	
}

</script>

</body>
</html>