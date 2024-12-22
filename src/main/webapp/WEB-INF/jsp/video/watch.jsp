<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<c:set var="cl" value="${ pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>${ videoInfo.title }</title>
</head>
<body>
	<a href="${ cl }/"><button>돌아가기</button></a>
    <h1>${ videoInfo.title }</h1>
    <h3>영상 설명 : ${ videoInfo.description }</h3>
    <p>만든 날짜 : ${ videoInfo.created }</p>
    <p>조회수 : ${ videoInfo.views }</p>

    <video width="640" height="360" controls>
	    <source src="${videoInfo.filepath}" type="video/mp4">
	</video>


</body>
</html>
