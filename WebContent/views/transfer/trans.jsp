<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%
List<Map<String,String>> ccList = new ArrayList<>();
Map<String,String> commonCode = new HashMap<>();
commonCode.put("cc_num","1");
commonCode.put("cc_group","trans");
commonCode.put("cc_name","한국어");
commonCode.put("cc_code","kr");
ccList.add(commonCode);

commonCode = new HashMap<>();
commonCode.put("cc_num","2");
commonCode.put("cc_group","trans");
commonCode.put("cc_name","영어");
commonCode.put("cc_code","en");
ccList.add(commonCode);

request.setAttribute("ccList", ccList);
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OSF번역</title>
</head>
<body>
<script>
function check(){
	/* 자바스크립트는'' 쓰고, html은 "" 쓴다  */
	var selectObj1 = document.querySelector('#source');
	var selectObj2 = document.querySelector('#target');
	if(selectObj1.value==selectObj2.value){
		alert('번역할 언어와 번역 될 언어가 같습니다. \n 다시 선택해주세요.');
		return false;
	}
	var textObj = document.querySelector('#text');
	if(textObj.value.length>=100){
		alert('번역할 내용은 100 글자 이상일 수 없습니다. ')
		return false;
	}	
	return true;
}
</script>
<c:if test="${rMap.isError=='true'}">
<script>
alert("${rMap.msg}");
</script>
</c:if>
<form method="post" action="/trans" onsubmit="return check()">
	<table border="1">
		<tr>
		<th>번역할 언어</th>
			<td>
			<select name="source" id="source">
					<c:forEach items="${ccList}" var="cc">
						<option value="${cc.ccCode}"
						<c:if test="${cc.ccCode==param.source}">
						selected
						</c:if>
						>${cc.ccName}</option>
					</c:forEach>
			</select>
			</td>
			<td rowspan="2"><button>번역</button></td>
			<th>번역될언어</th>
			<td><select name="target" id="target">
					<c:forEach items="${ccList}" var="cc">
						<option value="${cc.ccCode}"
						<c:if test="${cc.ccCode==param.target}">
						selected
						</c:if>
						>${cc.ccName}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td colspan="2">
			<textarea name="text" id="text">${param.text}</textarea>
			</td>
			<td colspan="2">
			<textarea>
			<c:if test="${rMap.isError!='true'}">
			${rMap.msg}
			</c:if>
			</textarea>
			</td>
		</tr>
	</table>
	
<select>
<option selected>10</option>
</select>
	</form>
</body>
</html>