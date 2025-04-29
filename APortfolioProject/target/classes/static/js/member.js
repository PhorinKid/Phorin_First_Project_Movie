document.addEventListener("DOMContentLoaded", function () {
    let isIdValid = false;
    let isEmailValid = false;

    const memberIdInput = document.getElementById("member_id");
    const emailInput = document.getElementById("email");
    const registerForm = document.getElementById("registerForm");
    const errorMessage = document.getElementById("error-message");

    // 아이디 중복 체크
    document.getElementById("checkIdBtn").addEventListener("click", function () {
        const member_id = memberIdInput.value;

        if (!member_id) {
            showError("아이디를 입력하세요.");
            return;
        }

        fetch("/members/checkMemberId", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: new URLSearchParams({ member_id })
        })
        .then(response => response.json())
        .then(data => {
            if (data.exists) {
                showError("이미 존재하는 아이디입니다.");
                isIdValid = false;
            } else {
                alert("사용 가능한 아이디입니다.");
                isIdValid = true;
                clearError();
            }
        })
        .catch(() => showError("아이디 중복 체크 중 오류가 발생했습니다."));
    });

    // 이메일 중복 체크
    document.getElementById("checkEmailBtn").addEventListener("click", function () {
        const email = emailInput.value;

        if (!email) {
            showError("이메일을 입력하세요.");
            return;
        }

        fetch("/members/checkEmail", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: new URLSearchParams({ email })
        })
        .then(response => response.json())
        .then(data => {
            if (data.exists) {
                showError("이미 존재하는 이메일입니다.");
                isEmailValid = false;
            } else {
                alert("사용 가능한 이메일입니다.");
                isEmailValid = true;
                clearError();
            }
        })
        .catch(() => showError("이메일 중복 체크 중 오류가 발생했습니다."));
    });

    // 입력값 변경 시 유효성 초기화
    memberIdInput.addEventListener("input", () => {
        isIdValid = false;
        clearError();
    });

    emailInput.addEventListener("input", () => {
        isEmailValid = false;
        clearError();
    });

    // 회원가입 유효성 검사
    registerForm.addEventListener("submit", function (e) {
        const password = document.getElementById("password").value;
        const confirmPassword = document.getElementById("confirmPassword").value;
        const email = emailInput.value;
        const emailRegex = /^[\w.-]+@[a-zA-Z\d.-]+\.[a-zA-Z]{2,}$/;

        if (!isIdValid) {
            showError("아이디 중복 체크를 완료해주세요.");
            e.preventDefault();
            return;
        }

        if (!isEmailValid) {
            showError("이메일 중복 체크를 완료해주세요.");
            e.preventDefault();
            return;
        }

        if (password.length < 4) {
            showError("비밀번호는 최소 4자 이상이어야 합니다.");
            e.preventDefault();
            return;
        }

        if (password !== confirmPassword) {
            showError("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            e.preventDefault();
            return;
        }

        if (!emailRegex.test(email)) {
            showError("유효한 이메일 형식이 아닙니다.");
            e.preventDefault();
            return;
        }
    });

    function showError(message) {
        errorMessage.textContent = message;
    }

    function clearError() {
        errorMessage.textContent = "";
    }
});