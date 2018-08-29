<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String rPath = request.getContextPath();

%>
 <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="<%=rPath%>/">
                        홈
                    </a>
                </li>
                <li>
                    <a href="<%=rPath%>/login/login">로그인</a>
                </li>
                <li>
                    <a href="<%=rPath%>/member/memberList">멤버 리스트</a>
                </li>
                <li>
                    <a href="<%=rPath%>/level/lvlList">레벨 리스트</a>
                </li>
                <li>
                    <a href="<%=rPath%>/depart/departList">부서 리스트</a>
                </li>
                <li>
                    <a href="#">About</a>
                </li>
                <li>
                    <a href="#">Services</a>
                </li>
                <li>
                    <a href="#">Contact</a>
                </li>
            </ul>
        </div>
<div id="page-content-wrapper">
	<div>
		<a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
	</div>
</div>