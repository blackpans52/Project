<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<div class="item">		
		<c:if test="${fn:contains(boardInfo.board_category1, 'playstation')}">
		<div id="list" class="aside_contents">
			<strong class="title"><i class="fas fa-clipboard-list"></i>Playstaion</strong>
			<ul>
				<li>Playstaion</li>
			</ul>
		</div>	
		</c:if>
		<c:if test="${fn:contains(boardInfo.board_category1, 'nintendo')}">
		<div id="list" class="aside_contents">
			<strong class="title"><i class="fas fa-clipboard-list"></i>nintendo</strong>
			<ul>
				<li>Nintendo</li>
			</ul>
		</div>	
		</c:if>
		<c:if test="${fn:contains(boardInfo.board_category1, 'xbox')}">
		<div id="list" class="aside_contents">
			<strong class="title"><i class="fas fa-clipboard-list"></i>Xbox</strong>
			<ul>
				<li>Xbox</li>
			</ul>
		</div>	
		</c:if>
		<c:if test="${fn:contains(boardInfo.board_category1, 'pc')}">
		<div id="list" class="aside_contents">
			<strong class="title"><i class="fas fa-clipboard-list"></i>PC</strong>
			<ul>
				<li>PC</li>
			</ul>
		</div>	
		</c:if>
		<c:if test="${fn:contains(boardInfo.board_category1, 'mobile')}">
		<div id="list" class="aside_contents">
			<strong class="title"><i class="fas fa-clipboard-list"></i>Mobile</strong>
			<ul>
				<li>Mobile</li>
			</ul>
		</div>	
		</c:if>
		<c:if test="${fn:contains(boardInfo.board_category1, 'arcade')}">
		<div id="list" class="aside_contents">
			<strong class="title"><i class="fas fa-clipboard-list"></i>AC/고전</strong>
			<ul>
				<li>AC/고전</li>
			</ul>
		</div>	
		</c:if>
		<c:if test="${fn:contains(boardInfo.board_category1, 'news')}">
		<div id="list" class="aside_contents">
			<strong class="title"><i class="fas fa-clipboard-list"></i>뉴스</strong>
			<ul>
				<li>뉴스</li>
			</ul>
		</div>	
		</c:if>
		<c:if test="${fn:contains(boardInfo.board_category1, 'community')}">
		<div id="list" class="aside_contents">
			<strong class="title"><i class="fas fa-clipboard-list"></i>커뮤니티</strong>
			<ul>
				<li>커뮤니티</li>
			</ul>
		</div>	
		</c:if>		
	</div>
