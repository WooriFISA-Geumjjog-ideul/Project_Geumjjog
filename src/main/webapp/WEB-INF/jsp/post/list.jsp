<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<!-- Add this script tag to use JQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document)
			.ready(
					function() {
						$
								.ajax({
									url : '/post/list', // 백엔드 API URL
									type : 'GET',
									success : function(posts) { // 받아온 데이터는 'posts'에 저장됩니다.
										posts
												.forEach(function(post) {
													var row = '<tr class="text-center">'
															+ '<th scope="row">'
															+ post.postId
															+ '</th>'
															+ '<td class="text-start"><a href="#" class="post-title link-dark" data-no="' 
                               + post.postId + '" style="text-decoration: none">'
															+ post.title
															+ '</a></td>'
															+ '<td>'
															+ post.memberName
															+ '</td>'
															+ '<td>'
															+ post.createdAt
															+ '</td>' + '</tr>';
													$('table tbody')
															.append(row);
												});
									}
								});
					});
</script>
</head>
<body>
	<div class="row justify-content-center">
		<div class="col-lg-10 col-md-10 col-sm-12">
			<h2 class="my-3 py-3 shadow-sm bg-light text-center">게시글 목록</h2>
		</div>
		<div class="col-lg-10 col-md-10 col-sm-12">
			<div class="row align-self-center mb-2">
				<div class="col-md-2 text-start">
					<button type="button" id="btn-mv-register"
						class="btn btn-outline-primary btn-sm">글쓰기</button>
				</div>
				<div class="col-md-5 offset-5">
					<form class="d-flex" id="form-search" action="">
						<input type="hidden" name="pgno" value="1" /> <select
							class="form-select form-select-sm ms-5 me-1 w-50" id="skey"
							name="key" aria-label="검색조건">
							<option value="" selected>검색조건</option>
							<option value="title">제목</option>
							<option value="userid">작성자</option>
						</select>
						<div class="input-group input-group-sm">
							<input type="text" class="form-control" id="sword" name="word"
								placeholder="검색어..." />
							<button id="btn-search" class="btn btn-dark" type="button">검색</button>
						</div>
					</form>
				</div>
			</div>
			<table class="table table-hover">
				<thead>
					<tr class="text-center">
						<th scope="col">글번호</th>
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty posts}">
						<c:forEach var="post" items="${posts}">
							<tr class="text-center">
								<th scope="row">${post.postId}</th>
								<td class="text-start"><a href="#"
									class="post-title link-dark" data-no="${post.postId}"
									style="text-decoration: none"> ${post.title} </a></td>
								<td>${post.memberName}</td>
								<td>${post.createdAt}</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
		<div class="m-3 row">${navigation.navigator}</div>
	</div>
	</div>
	<form id="form-param" method="get" action="">
		<input type="hidden" id="pgno" name="pgno" value="${pgno}"> <input
			type="hidden" name="key" value="${key}"> <input type="hidden"
			name="word" value="${word}">
	</form>
	<form id="form-no-param" method="get" action="${root}/board/view">
		<input type="hidden" name="pgno" value="${pgno}"> <input
			type="hidden" name="key" value="${key}"> <input type="hidden"
			name="word" value="${word}"> <input type="hidden" id="postid"
			name="postid" value="">
	</form>
	<script>
		var sel = document.getElementById("skey");
		for (var i = 0; i < sel.length; i++) {
			if (sel[i].value == "${key}") {
				sel[i].selected = true;
			}
		}

		if ("${word}" != "")
			document.getElementById("sword").value = "${word}";

		let titles = document.querySelectorAll(".post-title");
		titles.forEach(function(title) {
			title.addEventListener("click", function() {
				document.querySelector("#postid").value = this
						.getAttribute("data-no");
				document.querySelector("#form-no-param").submit();
			});
		});

		document.querySelector("#btn-mv-register").addEventListener("click",
				function() {
					let form = document.querySelector("#form-param");
					form.setAttribute("action", "${root}/post/write");
					form.submit();
				});

		document.querySelector("#btn-search").addEventListener("click",
				function() {
					let form = document.querySelector("#form-search");
					form.setAttribute("action", "${root}/post/list");
					form.submit();
				});

		let pages = document.querySelectorAll(".page-link");
		pages.forEach(function(page) {
			page.addEventListener("click", function() {
				let form = document.querySelector("#form-param");
				document.querySelector("#pgno").value = page.parentNode
						.getAttribute("data-pg");
				form.setAttribute("action", "${root}/post/list");
				form.submit();
			});
		});
	</script>
	<script>
		$(document).ready(function() {
			$("#btn-mv-register").click(function() {
				let form = $("#form-param");
				form.attr("action", "${root}/post/write");
				form.submit();
			});
		});
	</script>
</body>
</html>
<%@ include file="/WEB-INF/jsp/common/footer.jsp"%>