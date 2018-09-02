<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
                
                <c:if test="${empty user}">
	                <li>
	                    <a href="<%=rPath%>/login/login">로그인</a>
	                </li>
                </c:if>
                <c:if test="${!empty user}">
	                <li>
	                    <a href="<%=rPath%>/login/logout">로그아웃</a>
	                </li>
                </c:if>
                
                
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
                    <a href="<%=rPath%>/music/musicList">음악 리스트</a>
                </li>
                <li>
                    <a href="<%=rPath%>/movie/movieList">영화 리스트</a>
                </li>
                <li>
                    <a href="<%=rPath%>/bean/beanList">콩콩 리스트</a>
                </li>
            </ul>
        </div>
<div id="page-content-wrapper">
	<div>
		<a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
	</div>
</div>