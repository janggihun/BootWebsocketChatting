<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h2>로그인페이지.</h2>

<form action="/find" method="post">
    아이디 :<input type="text" name="id" id="id"></br>
    비밀번호 : <input type="text" name="pw" id="pw">
    <button type="submit">로그인버튼</button>
</form>




 <a href="/join">회원가입</a>메인페이지 들어가기



</body>
</html>