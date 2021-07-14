<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로그인 페이지</title>
    <link rel="stylesheet" href="style/login.css">
</head>
<body>
<div id="logo" class="title"><a href="index.jsp">로고</a></div>
<div id="wrap">
    <div id="title" class="title">로그인</div>
    <form name="loginForm" method="post" action="login.me" onsubmit="return checkLoginForm()">
        <div class="input-area">
            <div class="input">
                <input name="id" id="id" type="text" placeholder="아이디" minlength="4" maxlength="20">
            </div>
            <div class="input">
                <input name="pw" id="pw" type="password" placeholder="비밀번호" minlength="8" max="20">
            </div>
        </div>

        <div class="submit-area">
            <div class="submit">
                <button type="submit" class="submit-btn">로그인</button>
            </div>
        </div>
        <div class="forgot">
            <a class="text-link" href="join.jsp">회원가입</a>
            <span> | </span>
            <a class="text-link" href="findid.jsp">아이디</a>
            <span> | </span>
            <a class="text-link" href="findpw.jsp">비밀번호</a>
        </div>
    </form>
</div>
<script src="script/login.js">
</script>
</body>
</html>