<%@page import="com.osf.test.vo.PhotoBoardVO"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
pageContext.setAttribute("str","난페이지");
request.setAttribute("str", "난리퀘스트");
session.setAttribute("str", "난세션");
application.setAttribute("str", "난어플");
Map<String,String> tMap = new HashMap<>();
tMap.put("ttt_nnn","1");
tMap.put("ttt_nname","최인경");
pageContext.setAttribute("tMap",tMap);
PhotoBoardVO pb = new PhotoBoardVO();
pb.setPbTitle("제목");
pageContext.setAttribute("pb",pb);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
전 테스트입니다.
${str}<br>
${applicationScope.str}<br>
${sessionScope.str}<br>
${requestScope.str}<br>
${pageScope.str}<br>
${tMap.ttt_nname}<br>
<%=tMap.get("ttt_nname")%>
<%=pb.getPbTitle()%>
${pb.pbTitle}
</body>
</html>