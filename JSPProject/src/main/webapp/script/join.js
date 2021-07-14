function checkJoinForm() {
    const id = document.getElementById("id");
    const pw = document.getElementById("pw");
    const nickname = document.getElementById("nickname");
    const spaceRegExp = /\s/g;
    const idRegExp = /^[a-z0-9]{8,20}$/;
    const nickRegExp = /^[A-za-z0-9가-힣]{4,16}$/;
    const items = [id,pw,nickname];

    for (let i = 0; i < items.length; i++) {
        if (spaceRegExp.test(items[i].value)) {
            alert("공백은 사용할 수 없습니다.");
            items[i].focus();
            return false;
        }
    }
    if (!idRegExp.test(id.value)) {
        alert("아이디는 영어 소문자, 숫자만 가능합니다. (8~20자)");
        id.focus();
        return false;
    }
    if (isEqual()) {
        if (!nickRegExp.test(nickname.value)) {
            alert("닉네임에는 특수문자를 사용할 수 없습니다.");
            nickname.focus();
            return false;
        }
    } else {
        alert("비밀번호가 일치하지 않습니다.");
        pw.focus();
        return false;
    }

    return true;
}

function isEqual() {
    const pw = document.getElementById("pw").value;
    const secondPw = document.getElementById("pwCheck").value;
    const warning = document.getElementById("pwCheckWarning");

    if (pw === secondPw) {
        warning.innerHTML = "";
        return true;
    } else {
        warning.innerText = "비밀번호가 일치하지 않습니다.";
        return false;
    }
}

function checkID() {
    const id = document.getElementById("id").value;
    window.open("checkID.me?query=" + id, "아이디 중복체크", "width=10, height=10, top=100, location=no," +
        "status=no, toolbars=no, scrollbars=no");
}