<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@ page import="com.springbook.biz.board.BoardVO" %>

<%
	BoardVO vo = new BoardVO(); 
	BoardDAO boardDAO = new BoardDAO(); 
	List<BoardVO> boardList = boardDAO.getBoardList(vo); 
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>글 목록</title>
</head>
<body>
	<center> 
		<h1>글 목록 </h1>
		<h3> ${userName}님! 환영합니다. </h3>
		<a href="logout.do"> Log-out </a>
	
		<!-- 검색 시작 -->
		<form action="getBoardList.do" method="post"> 
			<table border="1" cellpadding="0" cellspacing="0" width="700"> 
				<tr>
					<td align="right">
						<select name="searchCondition"> 
							<option value="title"> 제목 </option>
						 	<option value="content"> 내용 </option>
						</select>
						<input name="searchKeyword" type="text" />
						<input type="submit" value="검색" /> 
					</td>
				</tr>
			</table>
		</form>
		<!-- 검색 종료  -->
		
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100"> 번호 </th>
				<th bgcolor="orange" width="200"> 제목 </th>
				<th bgcolor="orange" width="150"> 작성자 </th>
				<th bgcolor="orange" width="150"> 등록일 </th>
				<th bgcolor="orange" width="100"> 조회수 </th>
			</tr>
			
			<% for(BoardVO board : boardList)  { %>
				<tr>
					<td><%= board.getSeq() %></td>
					<td align="left"><a href="getBoard.jsp?seq=<%=board.getSeq() %>">
						<%= board.getTitle() %></a></td>
					<td><%= board.getWriter() %></td>
					<td><%= board.getRegDate() %></td>
					<td><%= board.getCnt() %></td>
				</tr>
			<% } %>
		</table>
		<br>
		<a href="insertBoard.jsp"> 새글 등록 </a>
	</center>
</body>
</html>