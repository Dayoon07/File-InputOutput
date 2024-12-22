<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<c:set var="cl" value="${ pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>영상 업로드</title>
</head>
<body>

	<form action="${ cl }/upload" method="post" enctype="multipart/form-data">
	    <label>영상 제목</label>
	    <input type="text" name="title" required><br>
	    <label>영상 설명</label>
	    <input type="text" name="description" required><br>
	    <label>영상 파일</label>
	    <input type="file" name="filepath" required><br><br>
	    <button type="submit">업로드</button>
	    <a href="${ cl }/"><button type="button">돌아가기</button></a>
	</form>
	
</body>
</html>