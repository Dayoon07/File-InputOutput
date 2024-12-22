<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<c:set var="cl" value="${ pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>${ imgInfo.imgname }</title>
</head>
<body>
	<a href="${ cl }/"><button>돌아가기</button></a>
    <h1>${imgInfo.imgname}</h1>
    <p>업로드 날짜: ${imgInfo.datetime}</p>
    <p>조회수: ${imgInfo.views}</p>

    <!-- 이미지 출력 -->
    <img src="${ imgInfo.path }" alt="${ imgInfo.imgname }" style="max-width: 100%; height: auto;">
</body>
</html>