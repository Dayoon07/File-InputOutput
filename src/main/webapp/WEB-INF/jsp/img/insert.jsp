<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<c:set var="cl" value="${ pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>이미지 업로드</title>
</head>
<body>

	<form action="${ cl }/image/upload" method="post" enctype="multipart/form-data">
	    <label>이미지 이름</label>
	    <input type="text" name="imgname" required><br>
	    <label>이미지 경로</label>
	    <input type="file" name="path" required><br><br>
	    <button type="submit">업로드</button>
	    <a href="${ cl }/"><button type="button">돌아가기</button></a>
	</form>

</body>
</html>
