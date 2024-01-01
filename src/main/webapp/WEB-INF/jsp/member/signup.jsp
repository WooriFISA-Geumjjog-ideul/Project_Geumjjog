<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport"content="width=device-width, user-scalable=no, initial-scale=1.0">
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/test.css">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700;800&display=swap"
	rel="stylesheet">
</head>
<title>Geumjjok</title>
<body>
	<div class="main">
		<div class="container a-container" id="a-container">
			<form class="form" id="form-signup" method="post" action="">
				<h2 class="form_title title">회원가입</h2>
				<input class="form__input" type="text" name="username" placeholder="이름">
				<input class="form__input" type="password" name="userpw" placeholder="비밀번호">
				<input class="form__input" type="text" name="usernickname" placeholder="닉네임">
				<input class="form__input" type="email" name="useremail" placeholder="이메일">
				<button class="form__button button submit" id="btn-signup">회원가입</button>
			</form>
		</div>
		<div class="switch" id="switch-cnt">
			<div class="switch__circle"></div>
			<div class="switch__circle switch__circle--t"></div>
			<div class="switch__container" id="switch-c1">
				<h2 class="switch__title title">금쪽이들</h2>
				<p class="switch__description description">from 금쪽같은내코드</p>
			</div>
		</div>
	</div>
	<script src="main.js"></script>
	<!-- <script>
      let isUseId = false;
      document.querySelector("#username").addEventListener("keyup", function () {
    	 let userid = this.value;
    	 let resultDiv = document.querySelector("#idcheck-result");
    	 if(userid.length < 6 || userid.length > 16) {
    		 resultDiv.setAttribute("class", "mb-3 text-dark");
    		 resultDiv.textContent = "아이디는 6자 이상 16자 이하 입니다.";
    		 isUseId = false;
    	 } else {
    		 fetch("${root}/member/" + username)
    		   .then(response => response.text())
    		   .then(data => {
	    			 if(data == 0) {
	    				 console.log(data);
	    			   resultDiv.setAttribute("class", "mb-3 text-primary");
	    		       resultDiv.textContent = userid + "는 사용할 수 있습니다.";
	    		       isUseId = true;
	    			 } else {
	    			   resultDiv.setAttribute("class", "mb-3 text-danger");
	      		       resultDiv.textContent = userid + "는 사용할 수 없습니다.";
	      		     isUseId = false;
	    			 }
    		   });
    	 }
      });
      
      document.querySelector("#btn-signup").addEventListener("click", function () {
        if (!document.querySelector("#username").value) {
          alert("이름 입력하세요");
          return;
        } else if (!document.querySelector("#userpw").value) {
          alert("비밀번호 입력하세요");
          return;
        } else if (!document.querySelector("#usernickname").value) {
          alert("닉네임 입력하세요");
          return;
        } else if (!document.querySelector("#useremail").value) {
          alert("이메일 입력하세요");
          return;
        } /* else if (!isUseId) {
          alert("아이디 확인!!");
          return; */
        } else {
          let form = document.querySelector("#form-signup");
          form.setAttribute("action", "${root}/member/signup");
          form.submit();
        }
      }); -->
    </script>
</body>
</html>