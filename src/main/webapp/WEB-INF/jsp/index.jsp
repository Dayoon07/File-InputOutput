<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<c:set var="cl" value="${ pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>출력 페이지</title>
	<style>
		table > tr, td {
			padding: 12.5px;
		}
	</style>
</head>
<body>
	<a href="${ cl }/insert">영상 업로드하기</a><br>
	<a href="${ cl }/imgInsert">이미지 업로드하기</a><br>

	<div style="display: flex; justify-content: space-around;">
		<div>
			<table border="1" style="border-collapse: collapse; text-align: center;">
				<tr>
					<td>고유 아이디</td>
					<td>제목</td>
					<td>영상 설명</td>
					<td>파일 경로</td>
					<td>만든 날찌</td>
					<td>조회수</td>
				</tr>
				<c:if test="${ not empty allVideo }">
					<c:forEach var="v" items="${ allVideo }">
						<tr>
							<td><a href="${ cl }/video?videoId=${ v.videoId }">${ v.videoId }</a></td>
							<td>${ v.title }</td>
							<td>${ v.description }</td>
							<td>${ v.filepath }</td>
							<td>${ v.created }</td>
							<td>${ v.views }</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
		<div>
			<table border="1" style="border-collapse: collapse; text-align: center;">
				<tr>
					<td>고유 아이디</td>
					<td>이미지 이름</td>
					<td>이미지 경로</td>
					<td>만든 날짜</td>
					<td>조회수</td>
				</tr>
				<c:if test="${ not empty allImg }">
					<c:forEach var="i" items="${ allImg }">
						<tr>
							<td>
								${ i.imgId } <br>
								<img src="${ i.path }" alt="${ i.imgname }" style="max-width: 200px; height: auto;">
							</td>
							<td><a href="${ cl }/img?imgId=${ i.imgId }">${ i.imgname }</a></td>
							<td>${ i.path }</td>
							<td>${ i.datetime }</td>
							<td>${ i.views }</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
	</div>

</body>
</html>