<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport"content="width=device-width, user-scalable=no, initial-scale=1.0">
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/common-style.css">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700;800&display=swap"
	rel="stylesheet">
</head>
<title>금쪽같은 게시판</title>
<body>
	<div class="main">
		<div class="container a-container" id="a-container">
			<form class="form" id="form-signup" method="post" action="">
				<div class="waviy">
					<span style="--i: 1">F</span> <span style="--i: 2">I</span> <span
						style="--i: 3">S</span> <span style="--i: 4">A</span>
				</div>
				<br>
				<br>
				<br>
				<input class="form__input" type="text" name="username" placeholder="이름">
				<input class="form__input" type="email" name="useremail" placeholder="이메일">
				<button class="form__button button submit" id="btn-find-password">비밀번호 찾기</button>
			</form>
		</div>
		<div class="switch" id="switch-cnt">
			<div class="switch__circle"></div>
			<div class="switch__circle switch__circle--t"></div>
			<div class="switch__container" id="switch-c1">
				<h2 class="switch__title title">금쪽같은 게시판</h2>
				<p class="switch__description description">by 금쪽이들</p>
			</div>
		</div>
	</div>
</body>
</html>