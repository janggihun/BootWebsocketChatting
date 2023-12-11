<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel='stylesheet' type='text/css' href='./css/chatt.css'>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<body>
<h1>아이디 로그인후 채팅가능합니다.</h1>
<div id='chatt'>
    <h1 id = "hello">WebSocket Chatting</h1>
    <input class = "loginform" type='text' id='mid' placeholder='아이디를 입력하세요'>
    <input class = 'loginform' type='password' id='mpw' placeholder='비밀번호 입력하세요'>
    <input class = 'loginform' type='button' value='로그인' id='btnLogin'>
    <input class = 'loginform' type='button' value='회원가입' id='join'>
    <input class = 'logoutform' type='button' value='로그아웃' id='logout' style = "display: none">
    <div id='talk'></div>
    <div id='sendZone'>
        <textarea id='msg' value='hi...' ></textarea>

        <input type='button' value='전송' id='btnSend'>
    </div>
</div>
<script src='./js/chatt.js'></script>
</body>
</html>
