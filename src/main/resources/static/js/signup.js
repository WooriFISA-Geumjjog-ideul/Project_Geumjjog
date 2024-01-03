document.addEventListener("DOMContentLoaded", function() {
    var signupForm = document.getElementById('form-signup');
    if (signupForm) {
        document.getElementById('btn-signup').addEventListener('click', function(e) {
            e.preventDefault(); // 기본 form 제출 이벤트 방지

            // Form 데이터를 JSON 객체로 변환
            var formData = {
                name: signupForm.elements['name'].value,
                password: signupForm.elements['password'].value,
                nickName: signupForm.elements['nickName'].value,
                email: signupForm.elements['email'].value
            };

            // Fetch API를 사용하여 데이터를 서버에 전송
            fetch('/member/signup', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(formData)
            })
            .then(function(response) {
                return response.json(); // 응답을 JSON으로 변환
            })
            .then(function(responseData) {
                if(responseData.message === '회원가입에 성공하였습니다.') {
                    alert(responseData.message); // 성공 메시지 표시
                    window.location.href = '/login'; // 로그인 페이지로 이동
                } else {
                    throw new Error(responseData.message); // 서버에서 제공하는 실패 메시지 표시
                }
            })
            .catch(function(error) {
                alert(error.message); // 오류 메시지 표시
            });
        });
    }
});